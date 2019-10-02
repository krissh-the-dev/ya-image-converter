import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class YAGrayscale{
  public static void main(String args[]) throws IOException{
    BufferedImage img = null;
    File colored = null;

    try{
      colored = new File(args[0]);
      img = ImageIO.read(colored);
    } catch(IOException e){
        System.out.println(e);
    } catch (ArrayIndexOutOfBoundsException aoe) {
        System.out.println("Please give command-line arguments.");
    }

    int width = img.getWidth();
    int height = img.getHeight();

    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y);

        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;

        int avg = (r+g+b)/3;

        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        img.setRGB(x, y, p);
      }
    }

    // thanks to stackoverflow for image conversion algorithms

    try{
      colored = new File("\\outputs\\raw\\" + args[0] + "-grayscale.jpg");
      ImageIO.write(img, "jpg", colored);
    }catch(IOException e){
      System.out.println(e);
    }
  }
}

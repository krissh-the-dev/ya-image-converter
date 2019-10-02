import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class YAConverter {
    public static void main(String[] args) {
        try {
            File input = new File(args[0]);
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_BYTE_BINARY);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);
            graphic.dispose();

            File output = new File("outputs\\" + args[0] + "-bw.jpeg");
            ImageIO.write(result, "jpeg", output);

        }  catch (IOException e) {
            e.printStackTrace();
        } catch(ArrayIndexOutOfBoundsException aob) {
            System.out.println("Please provide command-line arguments.");
        }
    }
}

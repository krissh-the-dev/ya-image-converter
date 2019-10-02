import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import yac.toBW;
import yac.toGrayscale;
/*
class toBW {
  public static void convert(String path) {
    try {
        File input = new File(path);
        BufferedImage image = ImageIO.read(input);

        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D graphic = result.createGraphics();
        graphic.drawImage(image, 0, 0, Color.WHITE, null);
        graphic.dispose();
        // thanks to tutorialspoint for conversion algorithm

        File output = new File(path + "-bw.jpeg");
        ImageIO.write(result, "jpeg", output);
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}

class toGrayscale {
  public static void convert(String path) {
    BufferedImage img = null;
    File colored = null;
    try{
      colored = new File(path);
      img = ImageIO.read(colored);
    } catch(IOException e){
        System.out.println(e);
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

    // thanks to stackoverflow for image conversion algorithm

    try {
      colored = new File(path + "-grayscale.jpg");
      ImageIO.write(img, "jpg", colored);
    } catch(IOException e){
      System.out.println(e);
    }
  }
}

*/
class yaconverter {
  static JTextField pathField;
  static JLabel status;
  static JButton tobw, togs;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ya Converter");

        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("About");
        mb.add(m1);

        JPanel panel = new JPanel();
        JPanel statusBar = new JPanel();

        JLabel label = new JLabel("File path: ");
        pathField = new JTextField(25);
        JButton browse = new JButton("Browse");
        tobw = new JButton("Convert into B/W");
        togs = new JButton("Convert into GrayScale");

        // Status Bar
        statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        status = new JLabel("Ready");

        statusBar.add(status);

        // Main panel
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(pathField);
        panel.add(browse);
        panel.add(tobw);
        panel.add(togs);


        frame.setLayout(new BorderLayout());

        // Action Handling
        tobw.addActionListener(new ButtonListener());
        togs.addActionListener(new ButtonListener());

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(mb, BorderLayout.NORTH);
        frame.getContentPane().add(statusBar, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

class ButtonListener extends yaconverter implements ActionListener {
  public void actionPerformed(ActionEvent ae) {
    String path = pathField.getText();
    status.setText(path);
    System.out.println(path);
    try {
      if (ae.getSource() == tobw) {
        toBW.convert(path);
        status.setText("Converted to black and white.");
      }
      else if (ae.getSource() == togs) {
        toGrayscale.convert(path);
        status.setText("Converted to grayscale.");
      }
      else {}

      // Thread.sleep(2000);
      status.setText("Image saved to /outputs.");
    } catch (Exception e) {
      status.setText("Error converting the file.");
    }
  }
}

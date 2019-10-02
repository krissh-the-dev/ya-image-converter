import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import yac.toBW;
import yac.toGrayscale;

class yaconverter {
  static JTextField pathField;
  static JLabel status;
  static ImageIcon ic;
  static JButton tobw, togs;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ya Converter");

        frame.setSize(550, 670);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu bar
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("About");
        mb.add(m1);

        // Panels
        JPanel imageViewer = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel statusBar = new JPanel();

        ImageIcon ic = new ImageIcon("sample.jpeg");
        JLabel label = new JLabel("File path: ");
        pathField = new JTextField(30);
        JButton browse = new JButton("Browse");
        tobw = new JButton("Convert into B/W");
        togs = new JButton("Convert into GrayScale");


        // Image Viewer
        imageViewer.setSize(300, 300);
        imageViewer.add(new JLabel(ic));


        // Main panel
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(label);
        mainPanel.add(pathField);
        mainPanel.add(browse);
        mainPanel.add(tobw);
        mainPanel.add(togs);

        // Status Bar
        statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        status = new JLabel("Ready");

        statusBar.add(status);


        frame.setLayout(new BorderLayout());

        // Action Handling
        tobw.addActionListener(new ButtonListener());
        togs.addActionListener(new ButtonListener());
        browse.addActionListener(new ButtonListener());

        frame.getContentPane().add(mb, BorderLayout.NORTH);
        frame.getContentPane().add(imageViewer, BorderLayout.NORTH);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
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
      else if(ae.getSource() == browse) {
        JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("C:\\Users\\asarj\\github\\ya-image-converter")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              label.setIcon(ResizeImage(path));
          }
           //if the user click on save in Jfilechooser


          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }



    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(700,400);
    setVisible(true);


     // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
      ImageIcon MyImage = new ImageIcon(ImagePath);
       Image img = MyImage.getImage();
       Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon image = new ImageIcon(newImg);
       return image;
   }
 }


      else {}

      // Thread.sleep(2000);
      status.setText("Image saved to /outputs.");
    } catch (Exception e) {
      status.setText("Error converting the file.");
    }
  }
}

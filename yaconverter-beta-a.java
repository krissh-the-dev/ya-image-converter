import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.image.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import yac.toBW;
import yac.toGrayscale;

class yaconverterA{
  static JFrame frame = new JFrame("Ya Converter");
  static JTextField pathField;
  static JLabel status, img;
  static JButton tobw, togs, browse;
  static JPanel imageViewer = new JPanel();
    public static void main(String[] args) {
      // Theming
      try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      } catch(Exception looke) {
        System.out.println("Look and feel error.");
      }

      // Frame settings
        frame.setSize(550, 670);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Menu bar
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("About");
        mb.add(m1);

        // Panels
        JPanel mainPanel = new JPanel();
        JPanel statusBar = new JPanel();

        ImageIcon ic = new ImageIcon("raw\\logo.png");
        frame.setIconImage(ic.getImage());
        JLabel label = new JLabel("File path: ");
        pathField = new JTextField(45);
        browse = new JButton("Browse");
        tobw = new JButton("Convert into B/W");
        togs = new JButton("Convert into GrayScale");


        // Image Viewer
        imageViewer.setSize(300, 300);
        img = new JLabel(ic);
        img.setSize(50, 50);
        imageViewer.add(img);


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

        // Adding to frame
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
    JFileChooser bb = null;
    int bbd = 0;
    if(ae.getSource() == browse) {
      bb = new JFileChooser(FileSystemView.getFileSystemView());
      bbd = bb.showOpenDialog(frame);

      if (bbd == JFileChooser.APPROVE_OPTION) {
          pathField.setText(bb.getSelectedFile().getAbsolutePath());
          path = pathField.getText();
      }
    }

    if (path.equals("")){
      status.setText("Choose a file to convert.");
      return;
    }
    if (!(new File(path).exists()))
      status.setText("File does not exist!");

    try {
      File op = null;
      String conv = "";
      BufferedImage image = ImageIO.read(new File(path));
      if (ae.getSource() == tobw) {
        op = toBW.convert(path);
        conv = path + "-bw.jpeg";
        status.setText("Converted to black and white.");
      }
      else if (ae.getSource() == togs) {
        op =toGrayscale.convert(path);
        conv = path + "-grayscale.jpeg";
        status.setText("Converted to grayscale.");
      }
      else {}

      if (op == null)
        status.setText("File chosen successfully.");
      else{
        imageViewer.remove(img);
        img = new JLabel(new ImageIcon(conv));
        imageViewer.add(img);
        frame.getContentPane().add(imageViewer, BorderLayout.NORTH);
        status.setText("Image saved as " + conv + ".");
      }
    } catch(javax.imageio.IIOException iioe) {
      status.setText("File not found.");
    } catch (Exception e) {
      status.setText("Error converting the file. The file is either not an image or currupted.");
    }
  }
}

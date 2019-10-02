
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import java.awt.image.*;
import javax.swing.JFileChooser;
class yaconverterasarcopy {
  protected static JTextField tf;
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Ya-Converter");
  ImageIcon ic = new ImageIcon("logo.png");
  JDesktopPane dp = new JDesktopPane();
  JLabel lbl = new JLabel(ic);
  JPanel transparentPanel = new JPanel();
      //  BufferedImage img = ImageIO.read(new File("C:\\Users\\asarj\\Downloads\\YA-logo-white.png"));

        //ImageIcon icon = new ImageIcon(img);


        //ImageIcon image = new ImageIcon("C:\\Users\\asarj\\Downloads\\YA-logo-white.png");
        //JLabel label = new JLabel(image);
        //frame.add(image);
        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("About");
        mb.add(m1);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("File path");
        tf  = new JTextField(25); // accepts upto 25 characters
        JButton browse = new JButton("Browse");
        JButton convertintobw = new JButton("Convert into B/W ");
        JButton convertintogs=new JButton("Convert into GrayScale");
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel(ic));
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(browse);
        panel.add(convertintobw);
        panel.add(convertintogs);
        frame.setLayout(new BorderLayout());
        //Adding Components to the frame.
        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.getContentPane().add(mb,BorderLayout.NORTH);
        convertintobw.addActionListener(new ButtonListener());
        convertintogs.addActionListener(new ButtonListener());



      frame.setVisible(true);




}
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class yaconverter {
  protected static JTextField tf;
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Ya-Converter");


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
        tf  = new JTextField(25); // accepts upto 100 characters
        JButton gotofiles = new JButton("Browse");
        JButton convertintobw = new JButton("Convert into B/W ");
        JButton convertintogs=new JButton("Convert into GrayScale");
        panel.setLayout(new FlowLayout());
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(gotofiles);
        panel.add(convertintobw);
        panel.add(convertintogs);
        frame.setLayout(new BorderLayout());
        //Adding Components to the frame.
        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.getContentPane().add(mb,BorderLayout.NORTH);
        convertintobw.addActionListener(new ButtonListener());
        convertintogs.addActionListener(new ButtonListener());
      //  convertintobw.addActionListener(new ButtonListener());
      frame.setVisible(true);
    }
}
class ButtonListener extends yaconverter implements ActionListener
{
  public void actionPerformed(ActionEvent ae)
  {
    tf.setText("OK");
  }
}

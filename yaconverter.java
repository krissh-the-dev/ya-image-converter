
import javax.swing.*;
import java.awt.*;
class yaconverter {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Ya-Converter");


        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Close");
        mb.add(m1);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter File Location");
        JTextField tf = new JTextField(25); // accepts upto 100 characters
        JButton gotofiles = new JButton("Go to files");
        JButton convertintobw = new JButton("Convert into B/W ");
        JButton convertintogs=new JButton("Convert into GreyScale");
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
      /*  frame.getContentPane().add(label);
        frame.getContentPane().add(tf);
        frame.getContentPane().add(gotofiles);
        frame.getContentPane().add(convertintobw);
        frame.getContentPane().add(convertintogs);*/
      //  frame.add(panel,BorderLayout)
      frame.setVisible(true);
    }
}

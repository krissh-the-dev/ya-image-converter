
import javax.swing.*;
import java.awt.*;
class yaconverter {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Ya-Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Close");
        mb.add(m1);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter File Location");
        JTextField tf = new JTextField(100); // accepts upto 10 characters
        JButton gotofiles = new JButton("Go to files");
        JButton convert = new JButton("Convert into B/W ");
        JButton
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(gotofiles);
        panel.add(convert);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }
}

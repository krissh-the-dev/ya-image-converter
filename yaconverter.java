import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import yac.toBW;
import yac.toGrayscale;

class yaconverter {
  static JTextField pathField;
    public static void main(String args[]) {
        JFrame frame = new JFrame("Ya Converter");

        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("About");
        mb.add(m1);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("File path: ");
        pathField = new JTextField(25);
        JButton browse = new JButton("Browse");
        JButton tobw = new JButton("Convert into B/W");
        JButton togs = new JButton("Convert into GrayScale");
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(pathField);
        panel.add(browse);
        panel.add(tobw);
        panel.add(togs);
        frame.setLayout(new BorderLayout());

        tobw.addActionListener(new ButtonListener());
        togs.addActionListener(new ButtonListener());

        //Adding Components to the frame.
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(mb, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}

class ButtonListener extends yaconverter implements ActionListener {
  public void actionPerformed(ActionEvent ae) {
    pathField.setText("OK");
  }
}

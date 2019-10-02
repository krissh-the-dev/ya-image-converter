import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import yac.toBW;
import yac.toGrayscale;

class yaconverter {
  static JTextField pathField;
  static JLabel status;
  static JButton tobw, togs;
    public static void main(String args[]) {
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
      Thread.sleep(2000);
      status.setText("Image saved to /outputs.");
    } catch (Exception e) {
      status.setText("Error converting the file.");
    }
  }
}

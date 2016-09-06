package dreamsystutorial;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Swing test class for the DreamSys tutorial.
 * 
 * @see <a href="http://www.dreamsyssoft.com/java-8-lambda-tutorial/listeners-tutorial.php">Listeners</a>
 */
public class SwingTest {
  public static void main(String []args) {
    makeFrameOldWay();
    makeFrameNewWay();
  }

  public static void makeFrameOldWay() {
    JButton btn = new JButton("Click Me");
    JComboBox<String> cmb = new JComboBox<>();
    JFrame f = makeFrame(btn, cmb);

    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");
      }
    });

    cmb.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        System.out.println("Select Event On: " + e.getItem());
      }
    });

    f.setVisible(true);
  }

  public static void makeFrameNewWay() {
    JButton btn = new JButton("Click Me");
    JComboBox<String> cmb = new JComboBox<>();
    JFrame f = makeFrame(btn, cmb);

    btn.addActionListener(e -> System.out.println("Button Clicked"));
    cmb.addItemListener(e -> System.out.println("Select Event On: " + e.getItem()));

    f.setVisible(true);
  }

  public static JFrame makeFrame(JButton btn, JComboBox<String> cmb) {

    cmb.setModel(new DefaultComboBoxModel<String>(new String[]{
      "Item 1",
      "Item 2",
      "Item 3",
      "Item 4",
      "Item 5",
    }));

    JFrame f = new JFrame("Old Way");
    f.getContentPane().setLayout(new GridLayout(2, 1));
    f.getContentPane().add(cmb);
    f.getContentPane().add(btn);
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    return f;
  }
}

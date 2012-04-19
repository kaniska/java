package pattern;

/**
 * @author jbu
 */
import javax.swing.*;
import java.awt.event.*;
class TestAdapter extends JFrame {

    public TestAdapter () {
        setSize(200,200);
        setVisible(true);
//        addWindowListener(new Closer());
    }
    public static void main(String[] args) {
        new TestAdapter();
    }
    class Closer extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}

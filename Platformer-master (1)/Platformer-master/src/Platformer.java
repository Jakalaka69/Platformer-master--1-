import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Platformer extends WindowAdapter {
    static MainFrame frame = new MainFrame();

    public static void windowClosing(MainFrame f) {
        f.dispose();
    }


    //    public static void main(String[] args){
//
//
//
//            MainFrame frame = new MainFrame();
//
//            frame.setSize(700, 700);
//
//
//            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//            frame.setLocation((int) (screenSize.getWidth() / 2 - frame.getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - frame.getSize().getHeight() / 2));
//
//            frame.setResizable(false);
//            frame.setTitle("Platformer Game");
//            frame.setVisible(true);
//
//            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//
//    };

    public static void restart(){


            MainFrame oldFrame = frame;


            frame.setSize(700, 700);


            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation((int) (screenSize.getWidth() / 2 - frame.getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - frame.getSize().getHeight() / 2));

            frame.setResizable(false);
            frame.setTitle("Platformer Game");
            frame.setVisible(true);

            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            try {
//                windowClosing(oldFrame);
//            }catch(NullPointerException e){
//
//        }
    };

    public static void main(String[] args) {
        restart();
    }

}
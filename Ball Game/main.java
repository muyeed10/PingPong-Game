import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class main {

    public static void main(String[] args) {
        

        JFrame frame = new JFrame();
        frame.setBounds(0, 0 , 800, 600);
        frame.setSize(815, 639);;
        frame.setTitle("Ball Game");
        frame.setResizable(false);
        
        JOptionPane box = new JOptionPane();
        String[] options = {"Easy", "Medium", "Difficulty"};
        int i = box.showOptionDialog(frame, "Please Enter the difficulty level", "Difficulty", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
      
        
        ballform objects;
        switch (i) {
            case 0: 
                objects = new ballform(2);
                break;
            case 1: 
                objects = new ballform(4);
                break;
            case 2: 
                objects = new ballform(5);
                break;
            default:
             objects = new ballform(2);
                break;
        }
        
        box.showMessageDialog(frame, "Press DOWN or UP Arrow Key to start once in the game");
        frame.add(objects);
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
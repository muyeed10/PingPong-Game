import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;



public class ballform extends JPanel implements KeyListener, ActionListener {

    private boolean started;
    private int ballXPos = 400;
    private int ballYPos = 300;
    private int ballSize = 35;
    private int Xdir, yDir;
    private int playerY = 250;
    private int cmpY = 250;
    private int playerScore = 0, compScore = 0;
    JFrame frame = new JFrame();
    JOptionPane Scores = new JOptionPane();
    Timer timer;
    

    public ballform(int speed) {

        this.Xdir = speed;
        this.yDir = speed;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(8, this);
        timer.start();
        
    }

    public void paint(Graphics g) {

        //background
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.black);

        //the ball
        g.setColor(Color.BLUE);
        g.fillOval(ballXPos, ballYPos - ballSize, ballSize, ballSize);

        //the user moving object
        g.setColor(Color.red);
        g.fillRect(800 - 25, playerY, 15, 100);

        //the CPU moving object
        g.setColor(Color.yellow);
        g.fillRect(0 + 8, cmpY, 15, 100);

        g.dispose();
        
    }
    
    public void actionPerformed(ActionEvent e) {
       
        
        if (started) {

            ballXPos += Xdir;
            ballYPos += yDir;
            cmpY = ballYPos - 70;

            if (cmpY <= 0) {
                cmpY = 0;
            }
            if (cmpY >= 500) {
                cmpY = 500;
            }

            if (ballXPos == 800 - ballSize - 25 && ballYPos >= playerY && ballYPos <= (playerY + 100)) {
                Xdir = -Xdir;
            }
            if (ballXPos == 8 && ballYPos >= cmpY && ballYPos <= (cmpY + 100)) {
                Xdir = -Xdir;
            }
            if (ballXPos <= 0) {
                playerScore ++;
                restart();
            }
            if (ballYPos < ballSize) {
                yDir = -yDir;

            }
            if (ballXPos > 800 - ballSize) {
                compScore ++;
                restart();
            }
            if (ballYPos > 600) {
                yDir = -yDir;

            }
          
        }
        repaint();
        
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (playerY <= 0) {
                playerY = 0;
            }
            else {
                moveUp();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (playerY >= 500) {
                playerY = 500;
            }
            else {
                moveDown();
            }
        }
        
    }
    public void keyReleased(KeyEvent e) {
        
    }

    public void moveDown() {
        started = true;
        playerY += 20;
    }

    public void moveUp() {
        started = true;
        playerY -= 20;
    }

    public int getPlayerScore() {
        return this.playerScore;
    }

    public int getCompScore() {
        return this.compScore;
    }

    public void restart() {
        started = false;
        ballXPos = 400;
        ballYPos = 300;
        playerY = 250;
        cmpY = 250;
        Scores.showMessageDialog(frame, "Player: " + this.getPlayerScore() + "| Comp Score: " + this.getCompScore());
    }
}

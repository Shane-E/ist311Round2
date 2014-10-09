package latetoclass;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener{
    SettingsPanel sp;
    Timer gameLoop;
    int timeLeftInMilliseconds;
    final int STARTING_TIME_IN_MILLISECONDS, REFRESH_TIME_IN_MILLISECONDS;
    JLabel timeLeft;
    ImageIcon background;
    Image background1;
    Enemy[] enemiesMovingUp;
    Enemy[] enemiesMovingDown;
    Player player;
    JButton gamePiece;
    
    public GamePanel(){
        background = new ImageIcon("images/bg_summer.png");
        background1 = background.getImage();
        setLayout(new BorderLayout());
        sp = new SettingsPanel();
        sp.setLayout(new GridLayout(2,2));
        add(sp,"South");
        sp.add(sp.playGame);

        STARTING_TIME_IN_MILLISECONDS = 0;
        REFRESH_TIME_IN_MILLISECONDS = 0;
        
        //creates the game piece and adds it to the JPanel
        ImageIcon water = new ImageIcon("images/boy.png");
        gamePiece = new JButton(water);
        add(gamePiece);
       
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background1, 0, 0, this);
    }
    
    void startGame(){
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        //Action
    }

    public void keyPressed(KeyEvent e) {
        int currentX = gamePiece.getLocation().x;  
        int currentY = gamePiece.getLocation().y;
        int newY = 0;
        int newX = 0;
        
        if(e.getKeyCode() == KeyEvent.VK_KP_UP) {
            newY = currentY + 10;
            gamePiece.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_KP_DOWN) {
            newY = currentY - 10;
            gamePiece.setLocation(currentX, newY);
        }
    }

    public void keyReleased(KeyEvent e) {
        //Action
    }
}

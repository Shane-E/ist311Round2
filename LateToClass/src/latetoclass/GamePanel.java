package latetoclass;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
    SettingsPanel sp;
    Timer gameLoop;
    int timeLeftInMilliseconds;
    final int STARTING_TIME_IN_MILLISECONDS, REFRESH_TIME_IN_MILLISECONDS;
    JLabel timeLeft;
    ImageIcon background;
    Image background1;
    Enemy[] enemiesMovingUp;
    Enemy[] enemiesMovingDown;
    Player gamePiece;
    ImageIcon water;
    
    /*Constants
    final int WINTER_SEASON, SPRING_SEASON, SUMMER_SEASON, FALL_SEASON, 
            BOY_PLAYER, GIRL_PLAYER, EASY_DIFFICULTY, MEDIUM_DIFFICULTY, 
            HARD_DIFFICULTY;
    int currentSeason, currentPlayer, currentDifficulty;*/
    
    public GamePanel(){
        /*SUMMER_SEASON = 0;
        SPRING_SEASON = 1;
        FALL_SEASON = 2;
        WINTER_SEASON = 3; 
        BOY_PLAYER = 0;
        GIRL_PLAYER = 1;
        EASY_DIFFICULTY = 0;
        MEDIUM_DIFFICULTY = 1;
        HARD_DIFFICULTY = 2;
        //Default Values
        currentPlayer = 0;
        currentSeason = 0;*/
        
        STARTING_TIME_IN_MILLISECONDS = 0;
        REFRESH_TIME_IN_MILLISECONDS = 0;
        //background = new ImageIcon("images/bg_summer.png");
        //background1 = background.getImage();
        setLayout(new BorderLayout());
        sp = new SettingsPanel();
        sp.setLayout(new GridLayout(2,2));
        
        //creates the game piece and adds it to the JPanel
        //water = new ImageIcon("images/boy.png");
        gamePiece = new Player();
        
        //Add components to game panel
        add(sp,"South");
        sp.add(sp.playGame);
        sp.add(sp.boyButton);
        sp.add(sp.girlButton);
        
        sp.playGame.addActionListener(this);
        sp.boyButton.addActionListener(this);
        sp.girlButton.addActionListener(this);
        gamePiece.player.addKeyListener(this);
    }
    
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        //g.drawImage(background1, 0, 0, this);
    }
    
    void startGame(){
        
    }

    public void keyTyped(KeyEvent e) {
        //Action
    }

    public void keyPressed(KeyEvent e) {
        int currentX = gamePiece.player.getLocation().x;  
        int currentY = gamePiece.player.getLocation().y;
        int newY = 0;
        int newX = 0;
        
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            newY = currentY - 10;
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            newY = currentY + 10;
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            newX = currentX - 10;
            gamePiece.player.setLocation(newX, currentY);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            newX = currentX + 10;
            gamePiece.player.setLocation(newX, currentY);
        }
    }

    public void keyReleased(KeyEvent e) {
        //Action
    }
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == sp.playGame){
            startGame();
        }
        if(obj == sp.boyButton){
            gamePiece.game.setPlayer(0);
            add(gamePiece.player);
        }
        if(obj == sp.girlButton){
            gamePiece.game.setPlayer(1);
            add(gamePiece.player);
        }
    }
}

package latetoclass;

<<<<<<< Updated upstream
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
import java.awt.Color;
>>>>>>> Stashed changes
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
    Game game;
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
    
    //Constants
    final int WINTER_SEASON, SPRING_SEASON, SUMMER_SEASON, FALL_SEASON, 
            BOY_PLAYER, GIRL_PLAYER, EASY_DIFFICULTY, MEDIUM_DIFFICULTY, 
            HARD_DIFFICULTY;
    int currentSeason, currentPlayer, currentDifficulty;
    
    public GamePanel(){
<<<<<<< Updated upstream
        super();
        setLayout(null);
        
        sp = new SettingsPanel();
        
        SUMMER_SEASON = 0;
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
        currentSeason = 0;
        
=======
        //gives the panel a null layout so the button can be moved around the screen
        setLayout(null);
        
>>>>>>> Stashed changes
        STARTING_TIME_IN_MILLISECONDS = 0;
        REFRESH_TIME_IN_MILLISECONDS = 0;
        
        //creates the game piece and adds it to the JPanel
<<<<<<< Updated upstream
        //water = new ImageIcon("images/boy.png");
        //JButton p1 = new JButton(water);
        
        background = new ImageIcon("images/bg_summer.png");
        background1 = background.getImage();
        
        //Add components to game panel
        add(sp);
        
        sp.playGame.addActionListener(this);
        sp.boyButton.addActionListener(this);
        sp.girlButton.addActionListener(this);
        sp.winterButton.addActionListener(this);
        sp.fallButton.addActionListener(this);
        sp.springButton.addActionListener(this);
        sp.summerButton.addActionListener(this);
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background1, 0, 0, this);
=======
        ImageIcon water = new ImageIcon("images/boy.png");
        gamePiece = new JButton(water);
        gamePiece.setBounds(100, 100, 200, 200);
        add(gamePiece);
        addKeyListener(this);
       
       
>>>>>>> Stashed changes
    }
    
    void startGame(){
        //background = new ImageIcon("images/bg_summer.png");
        //background1 = background.getImage();
        
        if(currentPlayer == 0){
            gamePiece.image = new ImageIcon("images/boy.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 15;
            gamePiece.width = 20;
            gamePiece.height = 15;
        }else if(currentPlayer == 1){
            gamePiece.image = new ImageIcon("images/girl.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 10;
            gamePiece.width = 15;
            gamePiece.height = 10;
        }
        add(gamePiece.player);
        gamePiece.player.addKeyListener(this);
        revalidate();
        repaint();
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
<<<<<<< Updated upstream
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            newX = currentX - 10;
            gamePiece.player.setLocation(newX, currentY);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            newX = currentX + 10;
            gamePiece.player.setLocation(newX, currentY);
=======
            gamePiece.setBounds(100, 100, currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_KP_DOWN) {
            newY = currentY - 10;
            gamePiece.setBounds(100, 100, currentX, newY);
>>>>>>> Stashed changes
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
            gamePiece = new Player();
            gamePiece.image = new ImageIcon("images/boy.png");
            gamePiece.image1 = gamePiece.image.getImage();
            currentPlayer = 0;
        }
        if(obj == sp.girlButton){
            gamePiece = new Player();
            gamePiece.image = new ImageIcon("images/girl.png");
            gamePiece.image1 = gamePiece.image.getImage();
            currentPlayer = 1;
        }
        if(obj == sp.winterButton){
            background = new ImageIcon("images/bg_winter.png");
            background1 = background.getImage();
            repaint();
        }
        if(obj == sp.fallButton){
            background = new ImageIcon("images/bg_fall.png");
            background1 = background.getImage();
            repaint();
        }
        if(obj == sp.springButton){
            background = new ImageIcon("images/bg_spring.png");
            background1 = background.getImage();
            repaint();
        }
        if(obj == sp.summerButton){
            background = new ImageIcon("images/bg_summer.png");
            background1 = background.getImage();
            repaint();
        }
    }
}

package latetoclass;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
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
<<<<<<< HEAD


    
    JButton playGame = new JButton("Play");
    JButton boyButton = new JButton("Boy");
    JButton girlButton = new JButton("Girl");
    JButton winterButton = new JButton("Winter");
    JButton fallButton = new JButton("Fall");
    JButton springButton = new JButton("Spring");
    JButton summerButton = new JButton("Summer");
    

    Player gamePiece;
    Player texter1;
    Player texter2;
    Player average1;
    Player average2;

=======
    Player gamePiece;
>>>>>>> parent of 28da17b... Major Improvements
    ImageIcon water;
    
    //Constants
    final int WINTER_SEASON, SPRING_SEASON, SUMMER_SEASON, FALL_SEASON, 
            BOY_PLAYER, GIRL_PLAYER, EASY_DIFFICULTY, MEDIUM_DIFFICULTY, 
            HARD_DIFFICULTY;
    int currentSeason, currentPlayer, currentDifficulty;
    
    public GamePanel(){
        super();
        //gives the panel a null layout so the button can be moved around the screen
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
                
        STARTING_TIME_IN_MILLISECONDS = 0;
        REFRESH_TIME_IN_MILLISECONDS = 0;
        
        //creates the game piece and adds it to the JPanel
        //water = new ImageIcon("images/boy.png");
        //JButton p1 = new JButton(water);
        
        background = new ImageIcon("images/bg_summer.png");
        background1 = background.getImage();
        
        //Add components to game panel
        add(sp);
        add(sp.instructionsText);
        
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
        ImageIcon water = new ImageIcon("images/boy.png");
        //gamePiece = new JButton(water);
        //gamePiece.setBounds(100, 100, 200, 200);
        //add(gamePiece);
        addKeyListener(this);
    }
    
    void startGame(){
        //background = new ImageIcon("images/bg_summer.png");
        //background1 = background.getImage();
        
<<<<<<< HEAD

        

        //starts the gameLoop timer
        gameLoop.start();
        gameLoop.addActionListener(this);

        
=======
>>>>>>> parent of 28da17b... Major Improvements
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
<<<<<<< HEAD

        gamePiece.player.setFocusable(true);
        //setFocus(gamePiece.player);

        
        //adds the first texter obstacle
        texter1.image = new ImageIcon("images/texter.png");
        texter1.speed = 15;
        texter1.width = 20;
        texter1.height = 15;
        add(texter1.player);
        //adds the second texter obstacle
        texter2.image = new ImageIcon("images/texter.png");
        texter2.speed = 15;
        texter2.width = 20;
        texter2.height = 15;
        add(texter2.player);
        //adds the first average obstacle
        average1.image = new ImageIcon("images/texter.png");
        average1.speed = 15;
        average1.width = 20;
        average1.height = 15;
        add(average1.player);
        //adds the second average obstacle
        average2.image = new ImageIcon("images/texter.png");
        average2.speed = 15;
        average2.width = 20;
        average2.height = 15;
        add(average2.player);

        
=======
>>>>>>> parent of 28da17b... Major Improvements
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
        if(obj == gameLoop){
            //move texter and average obstacles back and forth
            repaint();
        }
    }
}

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
    JButton playGame = new JButton("Play");
    JButton boyButton = new JButton("Boy");
    JButton girlButton = new JButton("Girl");
    JButton winterButton = new JButton("Winter");
    JButton fallButton = new JButton("Fall");
    JButton springButton = new JButton("Spring");
    JButton summerButton = new JButton("Summer");
    Player texter1 = new Player();
    Player texter2 = new Player();
    Player average1 = new Player();
    Player average2 = new Player();
    Player gamePiece = new Player();
    
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
        
        background = new ImageIcon("images/bg_summer.png");
        background1 = background.getImage();
        
        //Add components to game panel
        add(sp);
        add(sp.instructionsText);
        add(playGame);
        add(boyButton);
        add(girlButton);
        add(winterButton);
        add(fallButton);
        add(springButton);
        add(summerButton);

        playGame.setBounds(0, 70, 100, 50);
        boyButton.setBounds(0, 120, 100, 50);
        girlButton.setBounds(0, 170, 100, 50);
        winterButton.setBounds(0, 220, 100, 50);
        fallButton.setBounds(0, 270, 100, 50);
        springButton.setBounds(0, 320, 100, 50);
        summerButton.setBounds(0, 370, 100, 50);
        
        playGame.addActionListener(this);
        boyButton.addActionListener(this);
        girlButton.addActionListener(this);
        winterButton.addActionListener(this);
        fallButton.addActionListener(this);
        springButton.addActionListener(this);
        summerButton.addActionListener(this);
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background1, 0, 0, this);
        ImageIcon water = new ImageIcon("images/boy.png");
        addKeyListener(this);
    }
    
    void startGame(){
        //background = new ImageIcon("images/bg_summer.png");
        //background1 = background.getImage();

        //starts the gameLoop timer
        //gameLoop.start();
        //gameLoop.addActionListener(this);
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
        gamePiece.player.setBounds(getWidth() / 2, getHeight() - 50, 50, 50);
        add(gamePiece.player);
        gamePiece.player.addKeyListener(this);
        gamePiece.player.setFocusable(true);
        
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
            System.out.println("up");
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            newY = currentY + 10;
            System.out.println("down");
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            newX = currentX - 10;
            System.out.println("left");
            gamePiece.player.setLocation(newX, currentY);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            newX = currentX + 10;
            System.out.println("right");
            gamePiece.player.setLocation(newX, currentY);
        }
        this.setFocusable(true);
    }

    public void keyReleased(KeyEvent e) {
        //Action
    }
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == playGame){
            startGame();
        }
        if(obj == boyButton){
            gamePiece = new Player();
            gamePiece.image = new ImageIcon("images/boy.png");
            gamePiece.image1 = gamePiece.image.getImage();
            currentPlayer = 0;
        }
        if(obj == girlButton){
            gamePiece = new Player();
            gamePiece.image = new ImageIcon("images/girl.png");
            gamePiece.image1 = gamePiece.image.getImage();
            currentPlayer = 1;
        }
        if(obj == winterButton){
            background = new ImageIcon("images/bg_winter.png");
            background1 = background.getImage();
            repaint();
        }
        if(obj == fallButton){
            background = new ImageIcon("images/bg_fall.png");
            background1 = background.getImage();
            repaint();
        }
        if(obj == springButton){
            background = new ImageIcon("images/bg_spring.png");
            background1 = background.getImage();
            repaint();
        }
        if(obj == summerButton){
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

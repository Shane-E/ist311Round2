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
    Enemy texter1 = new Enemy();
    Enemy texter2 = new Enemy();
    Enemy average1 = new Enemy();
    Enemy average2 = new Enemy();
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
        gameLoop = new Timer(1000, this);
        
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
        
        //Default background
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
        
        //Make the play button invisible until the user picks a player.
        playGame.setVisible(false);
        
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
    }
    
    void startGame(){
        //background = new ImageIcon("images/bg_summer.png");
        //background1 = background.getImage();
        
        //Hide the settings buttons
        playGame.setVisible(false);
        boyButton.setVisible(false);
        girlButton.setVisible(false);
        winterButton.setVisible(false);
        fallButton.setVisible(false);
        springButton.setVisible(false);
        summerButton.setVisible(false);

        //starts the gameLoop timer
        gameLoop.start();
        gameLoop.addActionListener(this);
        if(currentPlayer == 0){
            gamePiece.image = new ImageIcon("images/boy.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 15;
            gamePiece.width = 115;
            gamePiece.height = 69;
        }else if(currentPlayer == 1){
            gamePiece.image = new ImageIcon("images/girl.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 10;
            gamePiece.width = 115;
            gamePiece.height = 69;
        }
        gamePiece.player.setBounds(getWidth() / 2, getHeight() - 50, gamePiece.width, gamePiece.height);
        add(gamePiece.player);
        gamePiece.player.addKeyListener(this);
        gamePiece.player.setFocusable(true);
        
        //adds the first texter obstacle
        texter1.image = new ImageIcon("images/texter.png");
        texter1.player = new JButton(texter1.image);
        texter1.speed = 15;
        texter1.width = 117;
        texter1.height = 70;
        texter1.player.setBounds(getWidth() - 450, 0, texter1.width, texter1.height);
        add(texter1.player);
        //adds the second texter obstacle
        texter2.image = new ImageIcon("images/texter.png");
        texter2.player = new JButton(texter2.image);
        texter2.speed = 15;
        texter2.width = 117;
        texter2.height = 70;
        texter2.player.setBounds(getWidth() - texter2.width, getHeight() - 200, texter2.width, texter2.height);
        add(texter2.player);
        //adds the first average obstacle
        average1.image = new ImageIcon("images/average.png");
        average1.player = new JButton(average1.image);
        average1.speed = 15;
        average1.width = 117;
        average1.height = 71;
        average1.player.setBounds(getWidth() - average1.width, getHeight() / 3, average1.width, average1.height);
        add(average1.player);
        //adds the second average obstacle
        average2.image = new ImageIcon("images/average.png");
        average2.player = new JButton(average2.image);
        average2.speed = 15;
        average2.width = 117;
        average2.height = 71;
        average2.player.setBounds(getWidth() - 700, 0, average2.width, average2.height);
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
            newY = currentY - gamePiece.speed;
            System.out.println("up");
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            newY = currentY + gamePiece.speed;
            System.out.println("down");
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            newX = currentX - gamePiece.speed;
            System.out.println("left");
            gamePiece.player.setLocation(newX, currentY);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            newX = currentX + gamePiece.speed;
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
            playGame.setVisible(true);
            gamePiece.image = new ImageIcon("images/boy.png");
            gamePiece.player = new JButton(gamePiece.image);
            currentPlayer = 0;
        }
        if(obj == girlButton){
            playGame.setVisible(true);
            gamePiece.image = new ImageIcon("images/girl.png");
            gamePiece.player = new JButton(gamePiece.image);
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

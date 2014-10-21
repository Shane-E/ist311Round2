package latetoclass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
    Game gf;
    SettingsPanel sp;
    Timer gameLoop;
    int timeLeftInMilliseconds;
    final int STARTING_TIME_IN_MILLISECONDS, REFRESH_TIME_IN_MILLISECONDS;
    ImageIcon background;
    Image background1;
    Enemy[] enemiesMovingUp;
    Enemy[] enemiesMovingDown;
    Enemy texter1 = new Enemy();
    Enemy texter2 = new Enemy();
    Enemy average1 = new Enemy();
    Enemy average2 = new Enemy();
    Player gamePiece = new Player();
    int numCollisions = 0;
    boolean lastMoveCollision = false;
    int n;
    int k;
   
    int gameDifficulty = 0;
    
    public GamePanel(Game game){
        super();
        
        //gives the panel a null layout so the button can be moved around the screen
        setLayout(null);
        gf = game;
        
        gameLoop = new Timer(gameDifficulty, this);

  
        STARTING_TIME_IN_MILLISECONDS = 0;
        REFRESH_TIME_IN_MILLISECONDS = 0;
        
        //Default background
        background = new ImageIcon("images/bg_summer.png");
        background1 = background.getImage();
        
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background1, 0, 0, this);
    }
    
    void startGame(){
        //Hide the settings buttons and display the score/mistakes
        gf.sp.playGame.setVisible(false);
        gf.sp.boyButton.setVisible(false);
        gf.sp.girlButton.setVisible(false);
        gf.sp.winterButton.setVisible(false);
        gf.sp.fallButton.setVisible(false);
        gf.sp.springButton.setVisible(false);
        gf.sp.summerButton.setVisible(false);
        gf.sp.scoreLabel.setVisible(true);
        gf.sp.easyDifficultyButton.setVisible(false);
        gf.sp.mediumDifficultyButton.setVisible(false);
        gf.sp.hardDifficultyButton.setVisible(false);
        
        //starts the gameLoop timer
        gameDifficulty = gf.sp.gameDifficulty;
        gameLoop.setDelay(gameDifficulty);
        gameLoop.start();
        gameLoop.addActionListener(this);
        if(gf.currentPlayer == 0){
            gamePiece.image = new ImageIcon("images/boy.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 25;
            gamePiece.width = 65;
            gamePiece.height = 39;
        }else if(gf.currentPlayer == 1){
            gamePiece.image = new ImageIcon("images/girl.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 15;
            gamePiece.width = 65;
            gamePiece.height = 40;
        }
        gamePiece.player.setBounds(getWidth() / 2, getHeight() - 50, gamePiece.width, gamePiece.height);
        add(gamePiece.player);
        gamePiece.player.addKeyListener(this);
        gamePiece.player.setFocusable(true);
        
        //adds the first texter obstacle
        texter1.image = new ImageIcon("images/texter.png");
        texter1.player = new JButton(texter1.image);
        texter1.speed = 15;
        texter1.width = 65;
        texter1.height = 39;
        texter1.x = getWidth() - 650;
        texter1.y = 0;
        texter1.player.setBounds(texter1.x, texter1.y, texter1.width, texter1.height);
        add(texter1.player);
        //adds the second texter obstacle
        texter2.image = new ImageIcon("images/texter.png");
        texter2.player = new JButton(texter2.image);
        texter2.speed = 15;
        texter2.width = 65;
        texter2.height = 39;
        texter2.x = getWidth() - 500;
        texter2.y = getHeight() - 200;
        texter2.player.setBounds(texter2.x, texter2.y, texter2.width, texter2.height);
        add(texter2.player);
        //adds the first average obstacle
        average1.image = new ImageIcon("images/average.png");
        average1.player = new JButton(average1.image);
        average1.speed = 15;
        average1.width = 65;
        average1.height = 39;
        average1.x = getWidth() - 600;
        average1.y = getHeight() / 3;
        average1.player.setBounds(average1.x, average1.y, average1.width, average1.height);
        add(average1.player);
        //adds the second average obstacle
        average2.image = new ImageIcon("images/average.png");
        average2.player = new JButton(average2.image);
        average2.speed = 15;
        average2.width = 65;
        average2.height = 39;
        average2.x = getWidth() - 500;
        average2.y = 80;
        average2.player.setBounds(average2.x, average2.y, average2.width, average2.height);
        add(average2.player);
        
        gamePiece.player.requestFocus();
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
        
        if(e.getKeyCode() == KeyEvent.VK_UP && lastMoveCollision == false) {
            newY = currentY - gamePiece.speed;
            //System.out.println("up");
            gamePiece.player.setLocation(currentX, newY);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            newY = currentY + gamePiece.speed;
            //System.out.println("down");
            if(newY < 614)   {
            gamePiece.player.setLocation(currentX, newY);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            newX = currentX - gamePiece.speed;
            
            if(newX>390)    {
                //System.out.println("left");
                gamePiece.player.setLocation(newX, currentY);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            newX = currentX + gamePiece.speed;
            if(newX<750)    {
            //System.out.println("right");
            gamePiece.player.setLocation(newX, currentY);
            }
        }
        this.setFocusable(true);
    }

    public void keyReleased(KeyEvent e) {
        //Action
    }
    
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == gameLoop){
            //move texter and average obstacles from top to bottom, random x on loop
            average2.y++;
            gf.gp.average2.player.setBounds(average2.x, average2.y,average2.width, average2.height);
            if(average2.y > getHeight())
            {
                average2.y = 0;
                Random rand = new Random();
                int randomNum = rand.nextInt((700-410)+ 1) + 410;   
                average2.x = randomNum;
                
            }
            
            //move texter and average obstacles from top to bottom, random x on loop
            average1.y++;
            gf.gp.average1.player.setBounds(average1.x, average1.y,average1.width, average1.height);
            if(average1.y > getHeight())
            {
                average1.y = 0;
                Random rand = new Random();
                int randomNum = rand.nextInt((700-410)+ 1) + 410;   
                average1.x = randomNum;   
            }
            
            //move texter and average obstacles from top to bottom, random x on loop
            texter2.y++;
            gf.gp.texter2.player.setBounds(texter2.x, texter2.y,texter2.width, texter2.height);
            if(texter2.y > getHeight())
            {
                texter2.y = 0;
                Random rand = new Random();
                int randomNum = rand.nextInt((700-410)+ 1) + 410;   
                texter2.x = randomNum;   
            }
           
            //move texter and average obstacles from top to bottom, random x on loop
            texter1.y++;
            gf.gp.texter1.player.setBounds(texter1.x, texter1.y,texter1.width, texter1.height);
            if(texter1.y > getHeight())
            {
                texter1.y = 0;
                Random rand = new Random();
                int randomNum = rand.nextInt((700-410)+ 1) + 410;   
                texter1.x = randomNum;
            }
            
            //Get minimum and maximum values for collision detection
            int minX = gamePiece.player.getLocation().x-gamePiece.player.getWidth();
            int maxX = gamePiece.player.getLocation().x+ gamePiece.player.getWidth();
            int minY = gamePiece.player.getLocation().y - gamePiece.player.getHeight();
            int maxY = gamePiece.player.getLocation().y+ gamePiece.player.getHeight();
            
            //If player touches any of the other objects execute this loop
            if((gf.gp.texter1.player.getLocation().x >= minX && 
                gf.gp.texter1.player.getLocation().x <= maxX && 
                gf.gp.texter1.player.getLocation().y <= maxY && 
                gf.gp.texter1.player.getLocation().y >= minY) || 
                (gf.gp.average1.player.getLocation().x >= minX && 
                gf.gp.average1.player.getLocation().x <= maxX && 
                gf.gp.average1.player.getLocation().y <= maxY && 
                gf.gp.average1.player.getLocation().y >= minY) || 
                (gf.gp.average2.player.getLocation().x >= minX && 
                gf.gp.average2.player.getLocation().x <= maxX && 
                gf.gp.average2.player.getLocation().y <= maxY && 
                gf.gp.average2.player.getLocation().y >= minY) || 
                (gf.gp.texter2.player.getLocation().x >= minX && 
                gf.gp.texter2.player.getLocation().x <= maxX && 
                gf.gp.texter2.player.getLocation().y <= maxY && 
                gf.gp.texter2.player.getLocation().y >= minY))
            {
                //Only add to the number of collisions if the event before was not a collision
                if(lastMoveCollision == false)
                {
                    numCollisions += 1;
                    gf.gp.gamePiece.numberOfMistakes -=1;
                    gf.sp.scoreLabel.setText("Mistakes Left: " + gf.gp.gamePiece.numberOfMistakes);
                    
                }
                
                //if you run into an object, make it stop until you move
                if(gf.gp.texter1.player.getLocation().x >= minX && 
                gf.gp.texter1.player.getLocation().x <= maxX && 
                gf.gp.texter1.player.getLocation().y <= maxY && 
                gf.gp.texter1.player.getLocation().y >= minY)
                {
                    texter1.y--;
                }
                
                if(gf.gp.average1.player.getLocation().x >= minX && 
                gf.gp.average1.player.getLocation().x <= maxX && 
                gf.gp.average1.player.getLocation().y <= maxY && 
                gf.gp.average1.player.getLocation().y >= minY)
                {
                    average1.y--;
                }
                
                 if(gf.gp.texter2.player.getLocation().x >= minX && 
                gf.gp.texter2.player.getLocation().x <= maxX && 
                gf.gp.texter2.player.getLocation().y <= maxY && 
                gf.gp.texter2.player.getLocation().y >= minY)
                {
                    texter2.y--;
                }
                
                if(gf.gp.average2.player.getLocation().x >= minX && 
                gf.gp.average2.player.getLocation().x <= maxX && 
                gf.gp.average2.player.getLocation().y <= maxY && 
                gf.gp.average2.player.getLocation().y >= minY)
                {
                    average2.y--;
                }
                
                //Change color of label to red during collision
                gf.sp.scoreLabel.setForeground(Color.red);
                //Set last move variable to true so counter doesn't get incremented
                lastMoveCollision = true;
            }
            else
            {
               //Set label to black when no collision
               gf.sp.scoreLabel.setForeground(Color.black); 
               //Let detector know last move was not a collision
               lastMoveCollision = false;
            }
            
            //if the player reaches Willard building, display dialog box
            if(gamePiece.player.getLocation().x < 410 && gamePiece.player.getLocation().y < 200)
            {
                System.out.println("DIALOG BOX");
                
                
                gameLoop.stop();
                background = new ImageIcon("images/bg_winner.gif");
                gf.gp.remove(gf.gp.gamePiece.player);
                gf.gp.remove(gf.gp.average1.player);
                gf.gp.remove(gf.gp.average2.player);
                gf.gp.remove(gf.gp.texter1.player);
                gf.gp.remove(gf.gp.texter2.player);
                
                
                background1 = background.getImage();
                gf.pgp.setVisible(true);
                gf.sp.scoreLabel.setText("Winner!");                
            }
            if(gf.gp.gamePiece.numberOfMistakes == 0)
            {
                gameLoop.stop();
                background = new ImageIcon("images/bg_loser.gif");
                gf.gp.remove(gf.gp.gamePiece.player);
                gf.gp.remove(gf.gp.average1.player);
                gf.gp.remove(gf.gp.average2.player);
                gf.gp.remove(gf.gp.texter1.player);
                gf.gp.remove(gf.gp.texter2.player);
                
                background1 = background.getImage();
                gf.pgp.setVisible(true);
                gf.sp.scoreLabel.setText("Loser!");
                
            }
            repaint();
        }
    }
    }



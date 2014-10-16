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
    Game gf;
    SettingsPanel sp;
    Timer gameLoop;
    int timeLeftInMilliseconds;
    final int STARTING_TIME_IN_MILLISECONDS, REFRESH_TIME_IN_MILLISECONDS;
    JLabel timeLeft;
    ImageIcon background;
    Image background1;
    Enemy[] enemiesMovingUp;
    Enemy[] enemiesMovingDown;
    Enemy texter1 = new Enemy();
    Enemy texter2 = new Enemy();
    Enemy average1 = new Enemy();
    Enemy average2 = new Enemy();
    Player gamePiece = new Player();
    
    public GamePanel(Game game){
        super();
        
        //gives the panel a null layout so the button can be moved around the screen
        setLayout(null);
        gf = game;
        
        gameLoop = new Timer(1000, this);
  
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
        //Hide the settings buttons
        gf.sp.playGame.setVisible(false);
        gf.sp.boyButton.setVisible(false);
        gf.sp.girlButton.setVisible(false);
        gf.sp.winterButton.setVisible(false);
        gf.sp.fallButton.setVisible(false);
        gf.sp.springButton.setVisible(false);
        gf.sp.summerButton.setVisible(false);

        //starts the gameLoop timer
        gameLoop.start();
        gameLoop.addActionListener(this);
        if(gf.currentPlayer == 0){
            gamePiece.image = new ImageIcon("images/boy.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 15;
            gamePiece.width = 65;
            gamePiece.height = 39;
        }else if(gf.currentPlayer == 1){
            gamePiece.image = new ImageIcon("images/girl.png");
            gamePiece.image1 = gamePiece.image.getImage();
            gamePiece.speed = 10;
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
        texter1.x = getWidth() - 450;
        texter1.y = 0;
        texter1.player.setBounds(texter1.x, texter1.y, texter1.width, texter1.height);
        add(texter1.player);
        //adds the second texter obstacle
        texter2.image = new ImageIcon("images/texter.png");
        texter2.player = new JButton(texter2.image);
        texter2.speed = 15;
        texter2.width = 65;
        texter2.height = 39;
        texter2.x = getWidth() - texter2.width;
        texter2.y = getHeight() - 200;
        texter2.player.setBounds(texter2.x, texter2.y, texter2.width, texter2.height);
        add(texter2.player);
        //adds the first average obstacle
        average1.image = new ImageIcon("images/average.png");
        average1.player = new JButton(average1.image);
        average1.speed = 15;
        average1.width = 65;
        average1.height = 39;
        average1.x = getWidth() - average1.width;
        average1.y = getHeight() / 3;
        average1.player.setBounds(average1.x, average1.y, average1.width, average1.height);
        add(average1.player);
        //adds the second average obstacle
        average2.image = new ImageIcon("images/average.png");
        average2.player = new JButton(average2.image);
        average2.speed = 15;
        average2.width = 65;
        average2.height = 39;
        average2.x = getWidth() - 700;
        average2.y = 0;
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
        
        if(obj == gameLoop){
            //move texter and average obstacles back and forth
            repaint();
        }
    }
}

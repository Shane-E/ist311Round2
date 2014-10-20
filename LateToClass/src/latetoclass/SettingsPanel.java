package latetoclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel implements ActionListener{
    JButton playGame, winterButton, fallButton, springButton, summerButton, 
            easyDifficultyButton, mediumDifficultyButton, hardDifficultyButton, 
            boyButton, girlButton;
    JLabel instructionsText, scoreLabel;
    Game gf;
    int timerCounter;
    
    public SettingsPanel(Game game){
        gf = game;
        playGame = new JButton("Play");
        boyButton = new JButton("Boy");
        girlButton = new JButton("Girl");
        winterButton = new JButton("Winter");
        fallButton = new JButton("Fall");
        springButton = new JButton("Spring");
        summerButton = new JButton("Summer");
        scoreLabel = new JLabel("Collisions: ");
        timerCounter = 0;
        
        instructionsText = new JLabel("Select player, difficulty, and background. "
                + "Use the arrow keys to move your character. Avoid other people "
                + "and texters. Make it to Willard building without embarassing yourself.");

        instructionsText.setBounds(0,700,1200,50);
        
        add(playGame);
        add(boyButton);
        add(girlButton);
        add(winterButton);
        add(fallButton);
        add(springButton);
        add(summerButton);
        add(scoreLabel);

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
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == playGame){
            gf.gp.startGame();
        }
        if(obj == boyButton){
            playGame.setVisible(true);
            gf.gp.gamePiece.image = new ImageIcon("images/boy.png");
            gf.gp.gamePiece.player = new JButton(gf.gp.gamePiece.image);
            gf.currentPlayer = 0;
        }
        if(obj == girlButton){
            playGame.setVisible(true);
            gf.gp.gamePiece.image = new ImageIcon("images/girl.png");
            gf.gp.gamePiece.player = new JButton(gf.gp.gamePiece.image);
            gf.currentPlayer = 1;
        }
        if(obj == winterButton){
            gf.gp.background = new ImageIcon("images/bg_winter.png");
            gf.gp.background1 = gf.gp.background.getImage();
            gf.gp.repaint();
        }
        if(obj == fallButton){
            gf.gp.background = new ImageIcon("images/bg_fall.png");
            gf.gp.background1 = gf.gp.background.getImage();
            gf.gp.repaint();
        }
        if(obj == springButton){
            gf.gp.background = new ImageIcon("images/bg_spring.png");
            gf.gp.background1 = gf.gp.background.getImage();
            gf.gp.repaint();
        }
        if(obj == summerButton){
            gf.gp.background = new ImageIcon("images/bg_summer.png");
            gf.gp.background1 = gf.gp.background.getImage();
            gf.gp.repaint();
        }
    }
}

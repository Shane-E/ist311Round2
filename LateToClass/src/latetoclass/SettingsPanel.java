package latetoclass;

import java.awt.Color;
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
    JLabel instructionsText, scoreLabel, timeLeft;
    Game gf;
    int timerCounter;
    int gameDifficulty = 10;
    
    public SettingsPanel(Game game){
        gf = game;
        playGame = new JButton("Play");
        boyButton = new JButton("Boy");
        girlButton = new JButton("Girl");
        winterButton = new JButton("Winter");
        fallButton = new JButton("Fall");
        springButton = new JButton("Spring");
        summerButton = new JButton("Summer");
        scoreLabel = new JLabel("Mistakes Left: ");
        timeLeft = new JLabel("Time Left: ");
        timerCounter = 0;
        
        easyDifficultyButton = new JButton("Easy");
        mediumDifficultyButton = new JButton("Medium");
        hardDifficultyButton = new JButton("Hard");
        
        instructionsText = new JLabel("<html><p>Select player, difficulty, and background.<br> "
                + "Use the arrow keys to move your character. Avoid other people <br> "
                + "and texters. Make it to Willard building without embarassing yourself.</p></html>");

        instructionsText.setBounds(0,700,1200,50);
        add(instructionsText);
        
        add(playGame);
        add(boyButton);
        add(girlButton);
        add(winterButton);
        add(fallButton);
        add(springButton);
        add(summerButton);
        add(scoreLabel);
        add(easyDifficultyButton);
        add(mediumDifficultyButton);
        add(hardDifficultyButton);
        
        //Make the play button invisible until the user picks a player.
        //playGame.setEnabled(false);
        scoreLabel.setVisible(false);
        easyDifficultyButton.setBackground(Color.PINK);
        mediumDifficultyButton.setBackground(Color.PINK);
        hardDifficultyButton.setBackground(Color.PINK);
        winterButton.setBackground(Color.CYAN);
        springButton.setBackground(Color.CYAN);
        summerButton.setBackground(Color.CYAN);
        fallButton.setBackground(Color.CYAN);
        playGame.setBackground(Color.green);
        
        
        playGame.addActionListener(this);
        boyButton.addActionListener(this);
        girlButton.addActionListener(this);
        winterButton.addActionListener(this);
        fallButton.addActionListener(this);
        springButton.addActionListener(this);
        summerButton.addActionListener(this);
        easyDifficultyButton.addActionListener(this);
        mediumDifficultyButton.addActionListener(this);
        hardDifficultyButton.addActionListener(this);
        
        gameDifficulty = 20;
        gf.gp.gamePiece.numberOfMistakes = 5;
        easyDifficultyButton.setBackground(Color.RED);
        
        gf.gp.gamePiece.image = new ImageIcon("images/boy.png");
        gf.gp.gamePiece.player = new JButton(gf.gp.gamePiece.image);
        gf.currentPlayer = 0;
        boyButton.setBackground(Color.gray);
        
        gf.gp.background = new ImageIcon("images/bg_summer.png");
        gf.gp.background1 = gf.gp.background.getImage();
        summerButton.setBackground(Color.blue);
        gf.gp.repaint();
        
        
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == easyDifficultyButton) {
            gameDifficulty = 20;
            gf.gp.gamePiece.numberOfMistakes = 5;
            if(mediumDifficultyButton.getBackground().equals(Color.RED) || hardDifficultyButton.getBackground().equals(Color.RED))
            {
            easyDifficultyButton.setBackground(Color.RED);
            mediumDifficultyButton.setBackground(Color.PINK);
            hardDifficultyButton.setBackground(Color.PINK);
            }
            else
            {
            easyDifficultyButton.setBackground(Color.RED);
            }
        }
        if(obj == mediumDifficultyButton) {
            gameDifficulty = 15;
            gf.gp.gamePiece.numberOfMistakes = 3;
            if(easyDifficultyButton.getBackground().equals(Color.RED) || hardDifficultyButton.getBackground().equals(Color.RED))
            {
            mediumDifficultyButton.setBackground(Color.RED);
            easyDifficultyButton.setBackground(Color.PINK);
            hardDifficultyButton.setBackground(Color.PINK);
            }
            else
            {
            mediumDifficultyButton.setBackground(Color.RED);
            }
        }
        if(obj == hardDifficultyButton) {
            gameDifficulty = 5;
            gf.gp.gamePiece.numberOfMistakes = 1;
            if(mediumDifficultyButton.getBackground().equals(Color.RED) || easyDifficultyButton.getBackground().equals(Color.RED))
            {
            hardDifficultyButton.setBackground(Color.RED);
            easyDifficultyButton.setBackground(Color.PINK);
            mediumDifficultyButton.setBackground(Color.PINK);
            }
            else
            {
            hardDifficultyButton.setBackground(Color.RED);
            }
        }
        if(obj == playGame){
            gf.gp.startGame();
        }
        if(obj == boyButton){
            if(girlButton.getBackground().equals(Color.gray))
            {
            boyButton.setBackground(Color.gray);
            girlButton.setBackground(null);
            }
            boyButton.setBackground(Color.gray);
            gf.gp.gamePiece.image = new ImageIcon("images/boy.png");
            gf.gp.gamePiece.player = new JButton(gf.gp.gamePiece.image);
            gf.currentPlayer = 0;
        }
        if(obj == girlButton){
            playGame.setVisible(true);
            if(boyButton.getBackground().equals(Color.gray))
            {
            girlButton.setBackground(Color.gray);
            boyButton.setBackground(null);
            }
            gf.gp.gamePiece.image = new ImageIcon("images/girl.png");
            gf.gp.gamePiece.player = new JButton(gf.gp.gamePiece.image);
            gf.currentPlayer = 1;
        }
        if(obj == winterButton){
            gf.gp.background = new ImageIcon("images/bg_winter.png");
            gf.gp.background1 = gf.gp.background.getImage();
            if(fallButton.getBackground().equals(Color.blue) || springButton.getBackground().equals(Color.blue) || summerButton.getBackground().equals(Color.blue))
            {
            winterButton.setBackground(Color.blue);
            fallButton.setBackground(Color.cyan);
            springButton.setBackground(Color.cyan);
            summerButton.setBackground(Color.cyan);
            }
            else
            {
            winterButton.setBackground(Color.blue);
            }
            gf.gp.repaint();
        }
        if(obj == fallButton){
            gf.gp.background = new ImageIcon("images/bg_fall.png");
            
            if(winterButton.getBackground().equals(Color.blue) || springButton.getBackground().equals(Color.blue) || summerButton.getBackground().equals(Color.blue))
            {
            fallButton.setBackground(Color.blue);
            winterButton.setBackground(Color.cyan);
            springButton.setBackground(Color.cyan);
            summerButton.setBackground(Color.cyan);
            }
            else
            {
            fallButton.setBackground(Color.blue);
            }
            
            gf.gp.background1 = gf.gp.background.getImage();
            gf.gp.repaint();
        }
        if(obj == springButton){
            gf.gp.background = new ImageIcon("images/bg_spring.png");
            
            if(winterButton.getBackground().equals(Color.blue) || fallButton.getBackground().equals(Color.blue) || summerButton.getBackground().equals(Color.blue))
            {
            springButton.setBackground(Color.blue);
            fallButton.setBackground(Color.cyan);
            winterButton.setBackground(Color.cyan);
            summerButton.setBackground(Color.cyan);
            }
            else
            {
            springButton.setBackground(Color.blue);
            }
            
            gf.gp.background1 = gf.gp.background.getImage();
            gf.gp.repaint();
        }
        if(obj == summerButton){
            gf.gp.background = new ImageIcon("images/bg_summer.png");
            
            if(winterButton.getBackground().equals(Color.blue) || fallButton.getBackground().equals(Color.blue) || springButton.getBackground().equals(Color.blue))
            {
            summerButton.setBackground(Color.blue);
            fallButton.setBackground(Color.cyan);
            winterButton.setBackground(Color.cyan);
            springButton.setBackground(Color.cyan);
            }
            else
            {
            summerButton.setBackground(Color.blue);
            }
            gf.gp.background1 = gf.gp.background.getImage();
            gf.gp.repaint();
        }
    }
}

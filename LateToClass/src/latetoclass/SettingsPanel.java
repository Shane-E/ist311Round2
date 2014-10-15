package latetoclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel{
    JButton playGame, winterButton, fallButton, springButton, summerButton, 
            easyDifficultyButton, mediumDifficultyButton, hardDifficultyButton, 
            boyButton, girlButton;
    JLabel instructionsText;
    int timerCounter;
    
    public SettingsPanel(){        
        playGame = new JButton("Play");
        boyButton = new JButton("Boy");
        girlButton = new JButton("Girl");
        winterButton = new JButton("Winter");
        fallButton = new JButton("Fall");
        springButton = new JButton("Spring");
        summerButton = new JButton("Summer");
        timerCounter = 0;
        
        instructionsText = new JLabel("Select player, difficulty, and background. "
                + "Use the arrow keys to move your character. Avoid other people "
                + "and texters. Make it to Willard building without embarassing yourself.");

        instructionsText.setBounds(0,700,1200,50);
    }
}

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
    
    public SettingsPanel(){        
        playGame = new JButton("Play");
        boyButton = new JButton("Boy");
        girlButton = new JButton("Girl");
        winterButton = new JButton("Winter");
        fallButton = new JButton("Fall");
        springButton = new JButton("Spring");
        summerButton = new JButton("Summer");
        
        instructionsText = new JLabel("Select your player and difficulty. "
                + "Use the arrow keys to move your character. Avoid other people "
                + "and texters. Make it to Willard building without embarassing yourself.");
        instructionsText.setBounds(0,750,1024,50);
        
        add(playGame);
        add(boyButton);
        add(girlButton);
        add(winterButton);
        add(fallButton);
        add(springButton);
        add(summerButton);
    }
}

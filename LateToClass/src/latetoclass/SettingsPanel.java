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
    }
}

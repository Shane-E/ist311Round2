package latetoclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel implements ActionListener{
    Game game;
    JButton playGame, winterButton, fallButton, springButton, summerButton, 
            easyDifficultyButton, mediumDifficultyButton, hardDifficultyButton, 
            boyButton, girlButton;
    JLabel instructionsText;
    
    public SettingsPanel(){
        playGame = new JButton("Play");
        
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == playGame){
            game.gp.startGame();
        }
    }
}

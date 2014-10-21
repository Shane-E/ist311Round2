package latetoclass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PostGamePanel extends JPanel implements ActionListener{
    Game g;
    ImageIcon background;
    JButton restartButton, closeButton;
    
    public PostGamePanel(Game game){
        g = game;
        restartButton = new JButton("Restart");
        closeButton = new JButton("Close");
        add(restartButton);
        add(closeButton);
        restartButton.addActionListener(this);
        closeButton.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        //Action
        Object obj = e.getSource();
        
        if(obj == restartButton){
            g.dispose();
            app.main(null);  
        }
        if(obj == closeButton){
            System.exit(0);
        }
        }
    }
    


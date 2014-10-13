package latetoclass;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Enemy extends Character{
    
    public Enemy(){
        image = new ImageIcon();
        player = new JButton();
        speed = 0;
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }
}

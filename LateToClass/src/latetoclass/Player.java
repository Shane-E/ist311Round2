package latetoclass;

import java.awt.Color;
import javax.swing.ImageIcon;

public class Player extends Character{
    int numberOfMistakes;
    
    public Player(){
        if(game.getPlayer() == 0){
            image = new ImageIcon("images/boy.png");
            image1 = image.getImage();
            speed = 15;
            width = 20;
            height = 15;
        }else if(game.getPlayer() == 1){
            image = new ImageIcon("images/girl.png");
            speed = 10;
            width = 15;
            height = 10;
        }
    }
    
    void moveUp(){
        
    }
    
    void moveDown(){
        
    }
    
    void moveLeft(){
        
    }
    
    void moveRight(){
        
    }
}

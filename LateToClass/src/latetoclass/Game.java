package latetoclass;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Game extends JFrame{
    final int WINTER_SEASON, SPRING_SEASON, SUMMER_SEASON, FALL_SEASON, 
            BOY_PLAYER, GIRL_PLAYER, EASY_DIFFICULTY, MEDIUM_DIFFICULTY, 
            HARD_DIFFICULTY;
    int currentSeason, currentPlayer, currentDifficulty;
    GamePanel gp;
    
    public Game(){
        super("Round 2");
        
        gp = new GamePanel();
        getContentPane().setLayout(new BorderLayout());
	getContentPane().add(gp,"Center");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 480);
        setVisible(true);
        
        
        getContentPane().setLayout(new BorderLayout());
	//getContentPane().add(*InsertPanel*,"Center");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 480);
        setVisible(true);
        
        SUMMER_SEASON = 0;
        SPRING_SEASON = 1;
        FALL_SEASON = 2;
        WINTER_SEASON = 3; 
        BOY_PLAYER = 1;
        GIRL_PLAYER = 2;
        EASY_DIFFICULTY = 0;
        MEDIUM_DIFFICULTY = 1;
        HARD_DIFFICULTY = 2;
    }
    
    void setSeason(int season){
        if (season == 0){
            currentSeason = 0;
        }else if (season == 1){
            currentSeason = 1;
        }else if (season == 2){
            currentSeason = 2;
        }else if (season == 3){
            currentSeason = 3;
        }
    }
    
    void setDifficulty(int difficulty){
        
    }
    
    void setPlayer(int player){
        
    }
    
    int getSeason(){
        return currentSeason;
    }
    
    int getDifficulty(){
        return currentDifficulty;
    }
    
    int getPlayer(){
        return currentPlayer;
    }
    
    void playGame(){
        
    }
    
    void showSettings(){
        
    }
    
    void showPostGameOptions(){
        
    }
}

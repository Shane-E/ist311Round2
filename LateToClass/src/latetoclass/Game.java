package latetoclass;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Game extends JFrame{
    /*final int WINTER_SEASON, SPRING_SEASON, SUMMER_SEASON, FALL_SEASON, 
            BOY_PLAYER, GIRL_PLAYER, EASY_DIFFICULTY, MEDIUM_DIFFICULTY, 
            HARD_DIFFICULTY;
    int currentSeason, currentPlayer, currentDifficulty;*/
    GamePanel gp;
    SettingsPanel sp;
    PostGamePanel pgp;
    
    public Game(){
        super("Late To Class");
        gp = new GamePanel();
        pgp = new PostGamePanel();
        sp = new SettingsPanel();
        
        getContentPane().setLayout(new BorderLayout());
	getContentPane().add(gp, "Center");
        getContentPane().add(sp, "South");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (1024, 860);
        setVisible(true);
        gp.setFocusable(true);
        
        /*
        SUMMER_SEASON = 0;
        SPRING_SEASON = 1;
        FALL_SEASON = 2;
        WINTER_SEASON = 3; 
        BOY_PLAYER = 0;
        GIRL_PLAYER = 1;
        EASY_DIFFICULTY = 0;
        MEDIUM_DIFFICULTY = 1;
        HARD_DIFFICULTY = 2;
        
        //Default Values
        currentPlayer = 0;
        currentSeason = 0;
        */
    }
    /*
    void setSeason(int season){
        currentSeason = season;
    }
    
    void setDifficulty(int difficulty){
        
    }
    
    void setPlayer(int player){
        currentPlayer = player;
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
    */
}

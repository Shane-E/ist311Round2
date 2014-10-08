package latetoclass;

public class Game {
    final int WINTER_SEASON, SPRING_SEASON, SUMMER_SEASON, FALL_SEASON, 
            BOY_PLAYER, GIRL_PLAYER, EASY_DIFFICULTY, MEDIUM_DIFFICULTY, 
            HARD_DIFFICULTY;
    int currentSeason, currentPlayer, currentDifficulty;
    
    public Game(){
        WINTER_SEASON = 0;
        SPRING_SEASON = 0;
        SUMMER_SEASON = 0;
        FALL_SEASON = 0; 
        BOY_PLAYER = 0;
        GIRL_PLAYER = 0;
        EASY_DIFFICULTY = 0;
        MEDIUM_DIFFICULTY = 0;
        HARD_DIFFICULTY = 0;
    }
    
    void setSeason(int season){
        
    }
    
    void setDifficulty(int difficulty){
        
    }
    
    void setPlayer(int player){
        
    }
    
    int getSeason(){
        int s = currentSeason;
        return s;
    }
    
    int getDifficulty(){
        int d = currentDifficulty;
        return d;
    }
    
    int getPlayer(){
        int p = currentPlayer;
        return p;
    }
    
    void playGame(){
        
    }
    
    void showSettings(){
        
    }
    
    void showPostGameOptions(){
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiOperations;

import Main.GameArea;


public class Mediator {
    
    private GameArea gameArea;
    private GameUI game;
    
    public void addArea(GameArea area){
        this.gameArea = area;
    }
    
    public void addUI(GameUI game){
        this.game = game;
    }
    
    public void skorGuncelle(int score){
        gameArea.lblScore.setText("Score: "+score);
    }
    
    public void hakGuncelle(int hak){
        gameArea.lblHak.setText("Heart: "+hak);
    }
}

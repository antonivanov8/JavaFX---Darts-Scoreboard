/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dartsbro;

import javafx.beans.property.SimpleStringProperty;


public class Player {
    
    private SimpleStringProperty nickname;
    private int points;
    
  
    public Player (String nickname) {
        
        this.nickname = new SimpleStringProperty(nickname);
        this.points = 501;
    }
    

   
    public String getNickname() {
        return nickname.get();
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = new SimpleStringProperty(nickname);
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }
        
}

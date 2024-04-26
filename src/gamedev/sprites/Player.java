/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedev.sprites;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author saura
 */
public class Player extends Sprite{
    
        
    
    
    public Player(){
        w = 250;
        h = 250;
        x = 50;
        y = 600;
        image = new ImageIcon(Player.class.getResource("plyaer.gif"));
    }
    
    public void draw(Graphics pen){
         
        pen.drawImage(image.getImage(), x, y, w, h,null);
    }
    
    public void move(){
        x = x + speed;
    }
    
    public boolean outOfScreen(){
        return x > 1920;
    }
}


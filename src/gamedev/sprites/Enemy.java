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
public class Enemy extends Sprite{
    
    

    public Enemy(int x, int speed){
        y = 0;
        this.x = x;
        this.speed = speed;
        w = 150;
        h = 150;
        
        image = new ImageIcon(Enemy.class.getResource("enemy.gif"));
    }
    
    public void move(){
        if(y > 950){
            
            y = 0;
        }
        y = y + speed;
    }
    
    
    
}

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
public abstract class Sprite {
    
    public int speed;
    public int x;
    public int y;
    public int w;
    public int h;
    public ImageIcon image;
    
    public void draw(Graphics pen){
        pen.drawImage(image.getImage(), x, y, w, h, null);
    }
    
    
    
}

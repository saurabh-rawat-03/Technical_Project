/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedev;

import gamedev.sprites.Enemy;
import gamedev.sprites.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author saura
 */
public class Canvas extends JPanel{
    
    Timer timer;
    BufferedImage bg;
    Player player;
    Enemy enemy[] = new Enemy[3];
    
    public Canvas(){
        setSize(1500, 950);
        loadBGImage();
        player = new Player();
        loadEnemies();        
        gameLoop();
        setFocusable(true);
        bindEvents();
        
        
    }
    
    
    private void gameOver(Graphics pen){
        if(player.outOfScreen()){
            pen.setFont(new Font("times", Font.BOLD, 30));
                pen.setColor(Color.red);
                pen.drawString("Congratulations......", 1920/2, 950/2);
                
                timer.stop();
        }
        for(Enemy enm : enemy){
            if(isCollide(enm)){
                
                pen.setFont(new Font("times", Font.BOLD, 30));
                pen.setColor(Color.red);
                pen.drawString("You Lost.....", 1920/2, 950/2);
                
                timer.stop();
            }
        }
    }
    
    private boolean isCollide(Enemy enemy){
        int xDis = Math.abs(player.x - enemy.x);
        int yDis = Math.abs(player.y - enemy.y);
        
        int maxH = Math.max(player.h, enemy.h);
        int maxW = Math.max(player.w, enemy.w);
        
        return xDis <= maxW-50 && yDis <= maxH-200;
        
    }
    
    private void bindEvents(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    player.speed = 10;
                }
                
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    player.y = 450;
                        
//                    for(int i = 0; i<3000; i++){
//                        //hi
//                    }
                    
                    player.y = 600;
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    player.speed = -10;
                }
                
          
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                player.speed = 0;
            }
            
            
        });
    }
    
    private void loadEnemies(){
        int x = 600;
        int gap = 500;
        int speed = 7;
        for(int i = 0; i<enemy.length; i++){
            enemy[i] = new Enemy(x, speed);
            x+=gap;
            speed+=5;
        }
    }
    
    private void gameLoop(){
        timer = new Timer(50, (e)->repaint());
        timer.start();
    }
    
    private void loadBGImage(){
        try {
            bg = ImageIO.read(Canvas.class.getResource("bgImg.jpg"));
        } catch (IOException ex) {
            System.out.println("No Background Image Found...");
            System.exit(1);
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    private void printEnemies(Graphics pen){
        for(Enemy enem : enemy){
            enem.draw(pen);
            enem.move();
        }
    }
    
    @Override
    public void paintComponent(Graphics pen){
        super.paintComponent(pen);
        pen.drawImage(bg, 0, 0, 1920, 950, null);   
        player.draw(pen);
        player.move();
        printEnemies(pen);
        gameOver(pen);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedev;

import javax.swing.JFrame;

/**
 *
 * @author saura
 */
public class GameFrame extends JFrame{
    
    public GameFrame(){
        Canvas brd = new Canvas();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1920, 950);
        setTitle("My Game");
        setLocationRelativeTo(null);
        add(brd);
        setVisible(true);
        
    }
    public static void main(String[] args) {
           
        new GameFrame();        
        
    }
    
}

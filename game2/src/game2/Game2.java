/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Game2 extends JFrame{
    public Game2() throws IOException, UnsupportedAudioFileException, LineUnavailableException
    {
        Gameplay2_ gameplay2=new Gameplay2_();
         this.setSize(800,600);
         this.addMouseListener(new MouseMenu()); 
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(300,50);
        this.add(gameplay2);
    }
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Game2 game2 = new Game2();
    }
    
}

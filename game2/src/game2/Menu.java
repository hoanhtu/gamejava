/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *270
 *265
 *5 3 5
 * @author MyPC
 */
public class Menu {
    public Rectangle Play=new Rectangle(270,150,265,100);
    public Rectangle Help=new Rectangle(270,300,265,100);
    public Rectangle Exit=new Rectangle(270,450,265,100);
    public void paint(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        Font font =new Font("arial",Font.BOLD,60);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g2d.drawString("Bullet Flies", 240, 100);
        Font font1 =new Font("arial",Font.BOLD,45);
        g.setFont(font1);
        g2d.drawString("Start Game", 280, 210);
        g2d.draw(Play);
        g2d.drawString("Help Game", 285, 360);
        g2d.draw(Help);
        g2d.drawString("Exit Game", 290, 510);
        g2d.draw(Exit);
    }
}

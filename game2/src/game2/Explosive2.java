/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author MyPC
 */
public class Explosive2 {
    public int x,y,x1,y1,x2,y2,x3,y3,dx,dx1,dx2,dx3,dy,dy1,dy2,dy3;
    public Explosive2(){}
    public Explosive2(int x,int y,int x1,int y1,int x2,int y2,int x3,int y3,int dx,int dx1,int dx2,int dx3,int dy,int dy1,int dy2,int dy3)
    {
        this.x=x;
        this.y=y;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
        this.dx=dx;
        this.dx1=dx1;
        this.dy=dy;
        this.dy1=dy1;
        this.dx2=x2;
        this.dx3=dx3;
        this.dy2=dy2;
        this.dy3=dy3;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x, y, 10, 10);
        g.fillRect(x1, y1, 10, 10);
        g.fillRect(x2, y2, 10, 10);
        g.fillRect(x3, y3, 10, 10);
    }
    public void move()
    {
//        x-=dx;
//        y+=dy;
//        x1+=dx1;
//        y1-=dy1;
//        x2-=dx2;
//        y2+=dy2;
//        x3+=dx3;
//        y3-=dy3;
        x-=2;
        x1+=2;
        y2-=2;
        y3+=2;
    }
    public int GetX()
    {
        return x3;
    }
     public int GetY()
    {
        return y3;
    }
   
}

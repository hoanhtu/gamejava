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
public class Bars {
    public double x,y,dx,dy,w,h,w1,h1;
    public Bars(){}
    public Bars(double x,double y,double dx,double dy,double w,double h,double w1,double h1)
    {
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
        this.w=w;
        this.h=h;
        this.w1=w1;
        this.h1=h1;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y, 300,30);
    }
    public void move()
    {
        x+=dx;
        y+=dy;
        if(x<w1)
            dx=-dx;
        if(x>w)
            dx=-dx;
        if(y<h1)
            dy=-dy;
        if(y>h)
            dy=-dy;
    }
}

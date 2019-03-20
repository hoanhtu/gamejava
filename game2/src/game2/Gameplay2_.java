
package game2;

import com.sun.xml.internal.bind.v2.TODO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Component;


public class Gameplay2_ extends JPanel implements ActionListener,KeyListener,MouseMotionListener{

    Timer timer,timer1;
    public static int x=300,y=200,bx,by,scores=0,life=300;
    private final controller c;
    private flies f;
    private BulletFlies bf;
    private Gif gif;
    private Bullet b;
    private Background bg;
    private Explosive exl;
    private Explosive2 exl2;
    private Bars bars;
    private Menu menu;
    private final Sound sound;
    private final Sound sound1;
    private final Sound sound2;
    private Vector b1,b2;
    BufferedImage img,img1,img2,imglv1,imglv2,imglv3,imglv4,imglv5,imglv6,imglv7,imglv8,imglv9,imglv10;
   // public static ArrayList<Bullet>bullet;
    //public static ArrayList<BulletFlies>bulletfList;
  
      int dem=0,dem1=1; 
    private final boolean kt = false;
    private final boolean bien = true;
    Random rand=new Random();
    private int timeloop = 10,timeloopLevel=-1;
    int rangif;
    private Graphics g;
    private long timeLevelBegin1=-1L,timeLevelEnd1,timeLevelBegin2=-1L,timeLevelEnd2;
    private int fliesDie;
    private int level=2,level1=1;
    private final int demGif=0;
    private int numberFlies=10;
    private long timeFliesBegin=-1L,timeFliesEnd;
    private int tgflies = 0;
    private int tg = 0;
    private final double speedBackground=.3;
    private int fly=0;
    private double speedbullet=-1,speedbulletx=1;
    private int gifColor;
    private int numberGif=8;
    private int s=2;
    private int imgmaybay=0;
    private long timeCreateBegin=-1L,timeCreateEnd,timeCreate=-1L;
    private int nho=0,nho1=0,nho2=0;
    private int dx=0,dy=0;
     int demlv2=0,demlv3=0,demlv4=0,demlv5;
    static Vector toadox;
    static Vector toadoy;
    private int  KtLevel=1,demTach=0;
    private long timeDieBegin=-1L,timeDieEnd;
    private int KtVaCham3=0,KtTGVaCham3=1;
    public enum MenuGame 
    {
        Menu,
        Game
    };
    public static MenuGame menuGame=MenuGame.Menu;
    public  Gameplay2_() throws IOException, UnsupportedAudioFileException, LineUnavailableException
    {
        
         
        this.addKeyListener(this);
        this.setFocusable(true);
	this.setFocusTraversalKeysEnabled(false);
        if(menuGame==MenuGame.Menu)
            menu=new Menu();
        //this.addMouseMotionListener(this);
        //bars=new Bars();
         //if(level1==1)
         //bars=new Bars(10,200,-1,0,750,550,0,0);
        c=new controller();
       //bg=new Background(0,0,0,0.5);
        c.addBackgroud(new Background(0, 0, 0, speedBackground));
        //int lr=rand.nextInt(20);
        sound=new Sound(new File("image/shot1.wav"));
        sound1=new Sound(new File("image/flies1.wav"));
        sound2=new Sound(new File("image/DesiJourney.wav"));
       //sound2.play();
        
        //listflies(); 
        createGif();
        //createCoin();
         this.x=350;this.y=500;
       // toadox=new Vector();
        //toadoy=new Vector();
        fliesDie=numberFlies;
        //f=new flies(50,50);
        //gif=new Gif();
       // exl=new Explosive();
        image();
        timer=new Timer(8,this);
        timer.start();
      
        
    
    }
    public void ToaDoX(double x)
    {
        toadox.addElement(x);
    }
    public void ToaDoY(double y)
    {
        toadoy.addElement(y);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //timer.start();
            // bars.move();
            
           
            move();
            //enemy nổ
            if(c.E.size()>0){
                if(timeloop<0){
                    for(int i=0;i<c.E.size();i++)
                        c.removeExplosive(c.E.get(i));
                    timeloop=10;
                }
                timeloop--;
            }
            
            ////////////////////////////
            // di chuyển backGround
            for(int i=0;i<c.B.size();i++)
            {
                bg=c.B.get(i);
                
                if(bg.getY()>-1&&c.B.size()<2){
                    //c.removeBackground(bg);
                    
                    try {
                        
                        c.addBackgroud(new Background(0, -600, 0, speedBackground));
                    } catch (IOException ex) {
                        Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                if(bg.getY()>600){
                    c.removeBackground(bg);
                    
                }
            }
            try {
                //image();
                //bg.move();
                c.movebackground();
            } catch (IOException ex) {
                Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // bf.dx=x;
            //bf.dy=y;
            
            
            //xử lý level
            if(level1==1){
                BulletFlies.s="boom.png";
                flies.s="quy1.png";
                fly=1;
                //speedbullet=-2;
                numberGif=rand.nextInt(10);
                numberFlies=20;fliesDie=20;
                if(numberFlies>c.f.size()&&nho==0){
                    for(int i=30;i<200+30;i+=100)
                        for(int j=120;j<numberFlies*40-80;j+=60)
                            try {
                                c.addflies(new flies(j,i,50,50,0.5,0,j+50,i,j-50,i));
                                
                                
                            } catch (IOException ex) {
                                Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    nho=1;nho2=1;
                }
                
            }
            else{
                switch(level)
                {
                    case 2:{
                        
                        //c.f.clear();
                        BulletFlies.s="thien_thach.png";
                        flies.s="quy2.png";
                        
                        numberGif=rand.nextInt(10);
                        numberFlies=20;fliesDie=20;
                        if(timeloopLevel<0&&demlv2<numberFlies&&nho1==1)
                        {nho2=0;
                        try {
                            c.addflies(new flies(0,0,50,50,2,2,800,500,0,0));
                            demlv2++;
                            timeloopLevel=50;
                        } catch (IOException ex) {
                            Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        timeloopLevel--;
                        if(demlv2==numberFlies){
                            timeloopLevel=-1;nho1=0;}
                        if(c.f.size()==0&&demlv2==numberFlies){
                            nho2=1;
                            level++;
                        }
                        break;}
                    case 3:{
                        
                        numberGif=rand.nextInt(5);
                        numberFlies=10;fliesDie=10;
                        if(timeloopLevel<0&&demlv3<numberFlies&&nho1==1)
                        { nho2=0;
                        try {
                            
                            c.addflies(new flies(0,0,50,50,2,2,800,500,0,0));
                            c.addflies(new flies(750,0,50,50,-2,2,800,500,0,0));
                            //c.addflies(new flies(0,250,50,50,2,0.2,800,500,0,0));
                            //c.addflies(new flies(750,250,50,50,-2,0.2,800,500,0,0));
                            demlv3++;
                            timeloopLevel=150;
                        } catch (IOException ex) {
                            Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        timeloopLevel--;
                        if(demlv3==numberFlies){
                            timeloopLevel=-1;nho1=0;}
                        if(c.f.size()==0&&demlv3==numberFlies){
                            nho2=1;
                            level++;
                        }
                        break;
                        
                        
                    }
                    case 4:{
                        // f.w=200;
                        //f.h=200;
                        
                       
                        c.KtMove=1;
                        if(KtLevel==1)
                        {
                            f.setW(200);
                            f.setH(200);
                        }
                        numberGif=rand.nextInt(3);
                        numberFlies=1;fliesDie=1;fly=6;c.timeloop2=0;
                        if(timeloopLevel<0&&demlv4<numberFlies&&nho1==1)
                        {nho2=0;
                        try {
                            c.addflies(new flies(0,0,50,50,2,2,800,500,0,0));
                            demlv4++;
                            timeloopLevel=15;
                        } catch (IOException ex) {
                            Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        timeloopLevel--;
                        if(demlv4>=numberFlies){
                            timeloopLevel=-1;nho1=0;}
                        if(c.f.size()==0&&demlv4>=numberFlies){
                            nho2=1;
                            level++;
                        }
                        break;
                    }
                    case 5:
                    {
                        numberGif=rand.nextInt(3);
                        numberFlies=1;fliesDie=1;fly=6;
                        if(timeloopLevel<0&&demlv5<numberFlies&&nho1==1)
                        {nho2=0;
                        try {
                            c.addflies(new flies(100,100,50,50,1,2,800,500,0,0));
                            c.addflies(new flies(500,100,50,50,-1,2,800,500,0,0));
                            demlv5++;
                            timeloopLevel=15;
                        } catch (IOException ex) {
                            Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        timeloopLevel--;
                        if(demlv5>=numberFlies){
                            timeloopLevel=-1;nho1=0;}
                        if(c.f.size()==0&&demlv5>=numberFlies){
                            nho2=1;
                            level++;
                        }
                        break;
                    }
                }
            }
            if(menuGame==MenuGame.Game)
            {
            c.tick();
            c.move();
            }
            try {
                // f.move();
                vacham1();
            } catch (IOException ex) {
                Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
            }
            LoadFly();
            vacham2();
            //gif.move();
            vacham3();
            vacham4();
            //  vacham5();
            vacham6();
            vacham7();
            removeAll();
            repaint();
        } catch (IOException ex) {
            Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       // bf.dx=x;
        //bf.dy=y;
    }
   
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        c.drawbackground(g);
        if(menuGame==MenuGame.Menu)
        menu.paint(g);
        if(menuGame==MenuGame.Game){
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.PLAIN,20));
        g.drawString("scores:"+scores, 4, 20);
//        g.drawString("life:"+life, 4, 40);
//        g.drawString("size no:"+c.E2.size(), 4, 60);
//        g.drawString("fliesDie"+fliesDie, 4, 80);
//        g.drawString("s:"+s, 4, 100);
//        g.drawString("sizebullet"+c.b.size(), 4, 120);
//        g.drawString("size:"+c.f.size(), 4, 140);
//        g.drawString("sizebf:"+c.flie.bf.size(), 4, 160);
//        g.drawString("sizegif:"+c.G.size(), 4, 180);
//        g.drawString("KTvacham3:"+KtVaCham3+" "+KtTGVaCham3,4,200);
//        g.drawString("numberGif"+numberGif,4,220);
////        g.drawString("tD"+c.toadox,4,240);
//        g.drawString("tD"+c.bl.size(),4,260);
        if(level>=5&&c.f.size()>=2)
            g.drawLine((int)c.f.get(0).getX()+(int)c.f.get(0).getW()/2,(int)c.f.get(0).getY(),(int)c.f.get(1).getX()+(int)c.f.get(1).getW()/2,(int)c.f.get(1).getY());
           //fliesDie=numberFlies;
        if(timeLevelBegin1<0)
            timeLevelBegin1=System.currentTimeMillis();
        else {
             timeLevelEnd1=System.currentTimeMillis()-timeLevelBegin1;
            
             if(c.f.size()==0&&nho2==1)
              {level1=0; 
                  
                  if(timeLevelBegin2<0)
                      timeLevelBegin2=System.currentTimeMillis();
                  else {
                     timeLevelEnd2=System.currentTimeMillis()-timeLevelBegin2;
                     switch(imgmaybay)
                     {
                         case 0:g.drawImage(img, x, y, 50,50,null);break;
                         case 1:g.drawImage(img1, x, y, 50,50,null);break;
                         case 2:g.drawImage(img2, x, y, 50,50,null);break;
                     }
                     
                    try { 
                          c.draw(g);
                          
                         // vacham1();
                     } catch (IOException ex) {
                          Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     if(timeLevelEnd2>0L&&timeLevelEnd2<3000L){
                      
                        switch(level){
                             case 2: g.drawImage(imglv2, 120, 70,550,500, null);break;
                             case 3: g.drawImage(imglv3, 120, 70,550,500, null);break;
                             case 4: g.drawImage(imglv4, 120, 70,550,500, null);break;
                             case 5: g.drawImage(imglv5, 120, 70,550,500, null);break;
                        }
                        
                     }
                     if(timeLevelEnd2>3000L){
                          
                         nho1=1;
                       fliesDie=numberFlies;
                       //demGif+=numberFlies;
                       s++;
//                       try {
//                            listflies();
//                       } catch (IOException ex) {
//                            Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
//                       }
                       createGif();
                       //createCoin();
                       timeLevelBegin2=-1L;
//                       level++;
                       
                     }
                      
                  }
            }
            else{
                if(timeLevelEnd1>000L&&timeLevelEnd1<2000L)
                {
                  
                     switch(imgmaybay)
                     {
                         case 0:g.drawImage(img, x, y, 50,50,null);break;
                         case 1:g.drawImage(img1, x, y, 50,50,null);break;
                         case 2:g.drawImage(img2, x, y, 50,50,null);break;
                     }
                     g.drawImage(imglv1, 120, 70,550,500, null);
                     
                }
                 else
                {
                  //level1=0;
                  switch(imgmaybay)
                     {
                         case 0:g.drawImage(img, x, y, 50,50,null);break;
                         case 1:g.drawImage(img1, x, y, 50,50,null);break;
                         case 2:g.drawImage(img2, x, y, 50,50,null);break;
                     }
                  try { 
                      c.draw(g);
                     
                      //bars.paint(g);
                      
                  } catch (IOException ex) {
                      Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }
           
        }
         
        
        }
      
        }
    }
    public void listflies() throws IOException
    {
         if(level1==1){
//             BulletFlies.s="boom.png";
//             flies.s="quy1.png";
//            
//            //speedbullet=-2;
//            numberGif=rand.nextInt(10);
//             numberFlies=20;fliesDie=20;
//             if(c.f.size()<numberFlies)
//             for(int i=30;i<200+30;i+=100)
//                 for(int j=120;j<numberFlies*40-80;j+=60)
//                  c.addflies(new flies(j,i,50,50,0.5,0,j+50,i,j-50,i));
             
                
         }
            else{ 
            switch(level)
           {
            case 2:{
               c.f.clear();
               BulletFlies.s="thien_thach.png";
               flies.s="quy2.png";
               //fly++;
               //speedbullet=-10;
               numberGif=rand.nextInt(10);
                numberFlies=10;fliesDie=10;
                
                for(int i=0;i<numberFlies*40;i+=40){
            int xr=rand.nextInt(700);
            int yr=rand.nextInt(200);
           // c.addflies(new flies(xr,yr ,1,rand.nextInt(5),rand.nextInt(5)));
            c.addflies(new flies(i,i,50,50,2,2,800,500,0,0));
                }
                    
            break;}
            case 3:{
                c.f.clear();
                
                numberFlies=1;fliesDie=1;
                numberGif=rand.nextInt(5);
               // c.addflies(new flies(50, 100,50,50, 2, 0.5, 800, 500, 0, 0));
                break;
            }
            case 4:{
                c.f.clear();
                numberGif=rand.nextInt(3);
                numberFlies=10;fliesDie=40;
               for(int i=0;i<numberFlies*40;i+=40)
               {
                   c.addflies(new flies(i,i,50,50,2,2,800,500,0,0));
                   c.addflies(new flies(750-i,i,50,50,-2,2,800,500,0,0));
                   c.addflies(new flies(0+2*i,250,50,50,2,0.2,800,500,0,0));
                   c.addflies(new flies(750-2*i,250,50,50,-2,0.2,800,500,0,0));
               }
               
            break;}
            case 5:{
                c.f.clear();
                
                numberFlies=1;fliesDie=1;numberGif=rand.nextInt(numberFlies)+1;
                c.addflies(new flies(50, 100,50,50, 2, 0.5, 800, 500, 0, 0));
                break;
            }
            default:{numberFlies=1;fliesDie=1;break;}
           }
         
         }
//        for(int i=0;i<numberFlies;i++){
//            int xr=rand.nextInt(700);
//            int yr=rand.nextInt(200);
//           // c.addflies(new flies(xr,yr ,1,rand.nextInt(5),rand.nextInt(5)));
//            c.addflies(new flies(xr,yr,1,0,0));
//            
//            //c.addbulletflies(new BulletFlies(xr, yr));
//            
//        }
    }
    public void createGif()
    {
        
        b1=new Vector();
        
        //tạo ra số quà ngẫu nhiên trong ruồi;
        for(int i=0;i<numberGif;i++){
        int dem =0;
        rangif= rand.nextInt(numberFlies);
        for(int j=0;j<b1.size();j++)
            if((int)b1.get(j)==rangif)
                dem=1;
         if(dem==0)       
         b1.addElement(rangif);
        
        }
    }
    public void createCoin()
    {
     b2=new Vector();
        
        //tạo ra số quà ngẫu nhiên trong ruồi;
        for(int i=0;i<numberFlies;i++){
        int dem =0;
        rangif= rand.nextInt(numberFlies);
        for(int j=0;j<b2.size();j++)
            if((int)b2.get(j)==rangif)
                dem=1;
         if(dem==0)       
         b2.addElement(rangif);
        }
    }
   
    
    @Override
    public void removeAll()
    {
        //xóa đạn trong ruồi nếu vượt ra ngoài tọa độ 
        for(int i=0;i<c.f.size();i++)
         {
             this.f=c.f.get(i);
             for(int j=0;j<f.bf.size();j++)
             {
              this.bf=this.f.bf.get(j);
              if(bf.getX()<0||bf.getX()>800||bf.getY()>500||bf.getY()<0)
                  f.removebulletflies(bf);
             }
         }
        //xóa đạn ngoài ruồi
        for(int i=0;i<c.bl.size();i++)
        {
            this.bf=c.bl.get(i);
            if(this.bf.getX()<0||this.bf.getX()>800||this.bf.getY()>500||this.bf.getY()<0)
                c.removeBulletFlies(bf);
        }
        //xóa quà
        for(int i=0;i<c.G.size();i++)
         {
             this.gif=c.G.get(i);
             if(gif.getY()>600)
                 c.removegif(gif);
         }
        //xóa nổ 
        for(int i=0;i<c.E2.size();i++)
        {
            this.exl2=c.E2.get(i);
            if(exl2.GetY()>600)
                c.removeExplosive2(exl2);
        }
    }
     void LoadFly() throws IOException
     {
         
            if(KtVaCham3==1)
             if(timeDieBegin<0)
                    timeDieBegin=System.currentTimeMillis();
                 else {
                    timeDieEnd=System.currentTimeMillis()-timeDieBegin;
                        if(timeDieEnd<4000L)
                        {
                                KtTGVaCham3=0;
                                //img= ImageIO.read(new File("image/plane.png"));
                        }
                        else{
                            //img= ImageIO.read(new File("image/phico2.png"));
                            KtVaCham3=0;
                            KtTGVaCham3=1;
                            timeDieBegin=-1L;
                        }
                 }
                 
                    
         
     }
    //va chạm giữa đạn và ruồi
     public void vacham1() throws IOException
    {
      
        for(int j=0;j<c.f.size();j++)
        {
            this.f=c.f.get(j);
            Rectangle rectflies=new Rectangle((int)this.f.getX(),(int)this.f.getY(),(int)f.w,(int)f.h );
         //timer1=new Timer(-2,this); 
         //timer1.start();
         
         //timer1.stop();
         
        
           for(int i=0;i<c.b.size();i++){
               this.b=c.b.get(i);
               
             Rectangle rectBullet=new Rectangle((int)this.b.getX(),(int)this.b.getY(),10,10);
                if(rectflies.intersects(rectBullet)){ 
                    
                    //f.ky=-1;
                    if(tg==1){
                       // c.f.get(j).move(-5);
                        
                        //c.f.get(j).move(-1);
                        c.f.get(j).move(-1,j);
                        tgflies=1;
                    }
                    //f.ky=0;
                    dem++;
                    
                    System.out.println(dem);
                    c.removeBullet(this.b);
                   
                    if(dem>fly){
                        sound1.play();
                        scores+=10;
                        if(level==4&& level1==0&&demlv4>=numberFlies&&demTach<10){
                        demTach++;
                        KtLevel=0;
                        f.setW(f.getW()-20);f.setH(f.getH()-20);
                        c.addflies(new flies(f.getX(),f.getY(),f.getW(),f.getH(),rand.nextInt(3)+1,rand.nextInt(3)+1,800,600,0,0));
                        c.addflies(new flies(f.getX(),f.getY(),f.getW(),f.getH(),rand.nextInt(3)+1,rand.nextInt(3)+1,800,600,0,0));
                         //g.drawLine((int)c.f.get(0).getX(),(int)c.f.get(0).getY(),(int)c.f.get(0).getX(),(int)c.f.get(0).getY());
                        }
                      //exl=new Explosive((int)this.f.getX(), (int)this.f.getY());
                      
                      if(level>=3)
                       c.addExplosive2(new Explosive2((int)this.f.getX(), (int)this.f.getY(),(int)this.f.getX(), (int)this.f.getY(),(int)this.f.getX(), (int)this.f.getY(),(int)this.f.getX(), (int)this.f.getY(),rand.nextInt(3)+1,rand.nextInt(3)+1,rand.nextInt(3)+1,rand.nextInt(3)+1,rand.nextInt(3),rand.nextInt(3),rand.nextInt(3),rand.nextInt(3)));
                       //gif.Gif1(this.f.getX(), this.f.getY(),50,50);
                                Enumeration vEnum = b1.elements();
                                for(int i1=0;i1<b1.size();i1++)
                                   if((int)b1.get(i1)==j){
                                      gifColor=rand.nextInt(3)+1;
                                      c.addgif(new Gif((int)this.f.getX(), (int)this.f.getY(),40,40,gifColor));
                                      b1.remove(i1);
                                   }
//                                for(int i2=0;i2<b2.size();i2++)
//                                {
//                                    if((int)b2.get(i2)==j){
//                                        c.addCoin(new Coin((int)this.f.getX(), (int)this.f.getY(), 40, 40));
//                                    b2.remove(i2);
//                                    }
//                                }
                               //f.setpaint();
                               fliesDie--;
                               c.removeflies(f);
                               
//                               scores+=10;
                                 dem=0;
                           }
                    
                   
               }
                
               // f=new flies(50, 50);
                    
             }
           if(tgflies==1)
           if(timeFliesBegin<0)
                    timeFliesBegin=System.currentTimeMillis();
                    else {
                    timeFliesEnd=System.currentTimeMillis()-timeFliesBegin;
                        if(timeFliesEnd>100L&&timeFliesEnd<200L)
                        {
                            //c.f.get(j).move2((int)c.f.get(j).getX(),(int) c.f.get(j).getY());
                            //c.f.get(j).setY(getY()-1);
                             c.f.get(j).move(1,j);
                            //f.ky=1;
                            //timeFliesBegin=-1L;              
                          }
                        if(timeFliesEnd>200L){
                            c.f.get(j).move(0,j);
                            
                            //f.ky=0;
                            tgflies=0;
                            timeFliesBegin=-1L;
                        }
                    }
                
           }
          
                
        
          
    }
     //va chạm giữa ruồi và máy bay
     public void vacham2()
     {
         
         for(int j=0;j<c.f.size();j++)
        {
            this.f=c.f.get(j);
        Rectangle rectflies=new Rectangle((int)this.f.getX(), (int)this.f.getY(), (int)f.w,(int)f.h );
        Rectangle rectfly=new Rectangle(x,y,50,50);
        if(rectflies.intersects(rectfly))
        {
            KtVaCham3=1;
                 if(KtTGVaCham3==1)
                 {
                      this.x=350;
                      this.y=500;
                      life--;
                      if(dem1>0)
                      dem1--;
                      c.removeflies(f);
                     fliesDie--;
                     scores+=10;
                 }
           
            
            //f.setpaint();
          
            if(life<=0)
            {
                life=0;
            timer.stop();
            JOptionPane.showMessageDialog(null, "thua rồi kkk!!!@.@",
                  "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
        }
     }
     //va chạm giữa máy bay và đạn ruồi
     public void vacham3()
     {
         
        
         for(int i=0;i<c.bl.size();i++)
         {
             this.bf=c.bl.get(i);
            Rectangle rectflies=new Rectangle((int)this.bf.getX(), (int)this.bf.getY(), (int)this.bf.getWidth(),(int)this.bf.getHeight() );
            Rectangle rectfly=new Rectangle(x,y,50,50);
             if(rectflies.intersects(rectfly))
             {
                 KtVaCham3=1;
                 if(KtTGVaCham3==1)
                 {
                      this.x=350;
                      this.y=500;
                      life--;
                      if(dem1>0)
                      dem1--;
                      c.removeBulletFlies(bf);
                    
                 }
                 
                 
                 if(life<=0){
                  life=0;
                  timer.stop();
                   JOptionPane.showMessageDialog(null, "thua rồi kkk!!!@.@",
                  "Thông báo", JOptionPane.WARNING_MESSAGE);
            
                  }
                 
              
              
             }
         }
     }
    
     //va chạm giữa máy bay và quà
     public void vacham4()
     {
         for(int i=0;i<c.G.size();i++)
         {
             this.gif=c.G.get(i);
              Rectangle rectflies=new Rectangle(this.gif.getX(), this.gif.getY(), 50,50 );
              Rectangle rectfly=new Rectangle(x,y,50,50);
              if(rectflies.intersects(rectfly))
              {
                 
                  
                 switch (gif.getS()) {
                     case 1:
                         dem1++;
                         break;
                     case 2:{
                         speedbullet-=1;
                         speedbulletx+=1;
                         break;
                     }
                     case 3:{
//                          Bullet.w+=1;
//                          Bullet.h+=1;
                            b.setW(b.getW()+3);
                            b.setH(b.getH()+3);
                         break;}
                     default:
                         break;
                 }
                  c.removegif(gif);
              }
        }
     }
     //va chạm giữa đạn máy bay và đạn ruồi và
     public void vacham5()
     {
         for(int i=0;i<c.f.size();i++)
         {
             this.f=c.f.get(i);
             for(int j=0;j<f.bf.size();j++)
             {
              this.bf=this.f.bf.get(j);
              Rectangle rectflies=new Rectangle((int)this.bf.getX(),(int) this.bf.getY(), 20,20 );
              for(int ib=0;ib<c.b.size();ib++){
                 this.b=c.b.get(ib);
               
                Rectangle rectBullet=new Rectangle((int)this.b.getX(),(int)this.b.getY(),10,10);
                if(rectflies.intersects(rectBullet))
                 {
                     
                     this.f.removebulletflies(bf);
                     if(controller.TG==0)
                     c.removeBullet(b);
                 }
               }
             }
         }
     }
    //va cham giữa ruồi và nổ
    public void vacham6()
    {
        for(int i=0;i<c.E2.size();i++)
         {
             this.exl2=c.E2.get(i);
              Rectangle rectflies=new Rectangle(this.exl2.GetX(), this.exl2.GetY(), 10,10 );
              Rectangle rectfly=new Rectangle(x,y,50,50);
              if(rectflies.intersects(rectfly))
              {
                 KtVaCham3=1;
                 if(KtTGVaCham3==1)
                 {
                      this.x=350;
                      this.y=500;
                      life--;
                      if(dem1>0)
                      dem1--;
                      c.removeExplosive2(exl2);
                 }
                 if(life<=0)
                  {
                    life=0;
                    timer.stop();
                  }
                    
              }
         }
                 
    }
    //va chạm giữa ruồi và dây
    void vacham7()
    {
       
       if(c.f.size()>=2&&level==5&&level1==0)
       {
       int x0=(int)c.f.get(0).getX();
       int y0=(int)c.f.get(0).getY();
       int x1=(int)c.f.get(1).getX();
       int y1=(int)c.f.get(1).getY();
       int w=(int) Math.sqrt((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1));
       
       Rectangle rec=new Rectangle(x0,y0,w,1);
       Rectangle rec1=new Rectangle(x1,y1,w,1);
       Rectangle rectfly=new Rectangle(x,y,50,50);
        if(rec.intersects(rectfly)||rec1.intersects(rectfly))
        {
             KtVaCham3=1;
                 if(KtTGVaCham3==1)
                 {
                      this.x=350;
                      this.y=500;
                      life--;
                      if(dem1>0)
                      dem1--;
                      c.removeExplosive2(exl2);
                 }
                 if(life<=0)
                  {
                    life=0;
                    timer.stop();
                  }
        }
       }
    }
    public void image()
    {
        try {
              img= ImageIO.read(new File("image/phico2.png"));
              img1= ImageIO.read(new File("image/phico2left.png"));
              img2= ImageIO.read(new File("image/phico2right.png"));
           // bg.img=ImageIO.read(new File("image/vuTru.jpg"));
            imglv1=ImageIO.read(new File("image/level_Cke/lv1.png"));
            imglv2=ImageIO.read(new File("image/level_Cke/lv2.png"));
            imglv3=ImageIO.read(new File("image/level_Cke/lv3.png"));
            imglv4=ImageIO.read(new File("image/level_Cke/lv4.png"));
            imglv5=ImageIO.read(new File("image/level_Cke/lv5.png"));
            //imglv6=ImageIO.read(new File("image/level_Cke/lv6.png"));
            //imglv7=ImageIO.read(new File("image/level_Cke/lv7.png"));
            //imglv8=ImageIO.read(new File("image/level_Cke/lv8.png"));
            //imglv9=ImageIO.read(new File("image/level_Cke/lv9.png"));
            //imglv10=ImageIO.read(new File("image/level_Cke/lv10.png"));
            
            // ImageIcon icon= new ImageIcon(image.getScaledInstance(200,350,image.SCALE_SMOOTH));
        } catch (IOException ex) {
            Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public void move()
    {       
            
             x+=dx;    
        
             y+=dy;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //keyPressed
    @Override
    public void keyReleased(KeyEvent e) {
        
      if(menuGame==MenuGame.Game){ 
      if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            imgmaybay=0;
                      
			dx=0;
			
		}
       else
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            imgmaybay =0;
                dx=0;
		}
      else
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            dy=0;
        }
      else
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            dy=0;
        }
       if(e.getKeyCode()==KeyEvent.VK_SPACE){
           sound.play();
           switch(dem1)
           {
               case 0:{
               try {
                   c.addBullet(new Bullet(x+20, y,0,speedbullet));break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }

               case 1: 
               { 
              
               try {
                   c.addBullet(new Bullet(x+40, y,0,speedbullet));
             
                   c.addBullet(new Bullet(x, y,0,speedbullet));
                   
                   break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
               case 2: 
               {
               
               try {
                   c.addBullet(new Bullet(x, y,0,speedbullet));
              
                   c.addBullet(new Bullet(x+40, y,0,speedbullet));
             
                   c.addBullet(new Bullet(x+20, y,0,speedbullet));
               
                   break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
               case 3:{
               
               try {
                   // b.dx=-1;
                   c.addBullet(new Bullet(x, y,0,speedbullet));
              
                   c.addBullet(new Bullet(x+40, y,0,speedbullet));
              
                   c.addBullet(new Bullet(x+20, y,0,speedbullet));
              
                   c.addBullet(new Bullet(x, y,speedbullet/10,speedbullet));
              
                   c.addBullet(new Bullet(x+40, y,-speedbullet/10, speedbullet));
                   
                   break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
               case 4:
               {
              
               try {
                   c.addBullet(new Bullet(x, y,0,speedbullet));
               
                   c.addBullet(new Bullet(x+40, y,0,speedbullet));
               
                   c.addBullet(new Bullet(x+20, y,0,speedbullet));
               
                   c.addBullet(new Bullet(x, y,speedbullet/10,speedbullet));
               
                   c.addBullet(new Bullet(x+40, y, -speedbullet/10, speedbullet));
              
                   c.addBullet(new Bullet(x, y,(speedbullet/10)*2,speedbullet));
              
                   c.addBullet(new Bullet(x+40, y,(-speedbullet/10)*2, speedbullet));
                   
                   break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
               case 5:
               {
               
                  
               try {
                   c.addBullet(new Bullet(x, y,0,speedbullet));
                   
                   c.addBullet(new Bullet(x+40, y,0,speedbullet));
                   c.addBullet(new Bullet(x+20, y,0,speedbullet));
                   c.addBullet(new Bullet(x, y,speedbullet/10,speedbullet));
                   c.addBullet(new Bullet(x+40, y, -speedbullet/10, speedbullet));
                   c.addBullet(new Bullet(x, y,(speedbullet/10)*2,speedbullet));
                   c.addBullet(new Bullet(x+40, y,(-speedbullet/10)*2, speedbullet));
                   c.addBullet(new Bullet(x, y,3*(speedbullet/10),speedbullet));
                   c.addBullet(new Bullet(x+40, y,3*(-speedbullet/10), speedbullet));
                   break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               }
               case 6:
               {
               try {
                   c.addBullet(new Bullet(x, y,0,speedbullet));
                   c.addBullet(new Bullet(x+40, y,0,speedbullet));
                   c.addBullet(new Bullet(x+20, y,0,speedbullet));
                   c.addBullet(new Bullet(x, y,speedbullet/10,speedbullet));
                   c.addBullet(new Bullet(x+40, y,-speedbullet/10, speedbullet));
                   c.addBullet(new Bullet(x, y,(speedbullet/10)*2,speedbullet));
                   c.addBullet(new Bullet(x+40, y,(-speedbullet/10)*2, speedbullet));
                   c.addBullet(new Bullet(x, y,3*(speedbullet/10),speedbullet));
                   c.addBullet(new Bullet(x+40, y,3*(-speedbullet/10), speedbullet));
                   c.addBullet(new Bullet(x, y,4*(speedbullet/10),speedbullet));
                   c.addBullet(new Bullet(x+40, y,4*(-speedbullet/10), speedbullet));
                   break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
               default:
               {
               try {
                  c.addBullet(new Bullet(x, y,0,speedbullet));
                   c.addBullet(new Bullet(x+40, y,0,speedbullet));
                   c.addBullet(new Bullet(x+20, y,0,speedbullet));
                   c.addBullet(new Bullet(x, y,speedbullet/10,speedbullet));
                   c.addBullet(new Bullet(x+40, y,-speedbullet/10, speedbullet));
                   c.addBullet(new Bullet(x, y,(speedbullet/10)*2,speedbullet));
                   c.addBullet(new Bullet(x+40, y,(-speedbullet/10)*2, speedbullet));
                   c.addBullet(new Bullet(x, y,3*(speedbullet/10),speedbullet));
                   c.addBullet(new Bullet(x+40, y,3*(-speedbullet/10), speedbullet));
                   c.addBullet(new Bullet(x, y,4*(speedbullet/10),speedbullet));
                   c.addBullet(new Bullet(x+40, y,4*(-speedbullet/10), speedbullet));
                   break;
               } catch (IOException ex) {
                   Logger.getLogger(Gameplay2_.class.getName()).log(Level.SEVERE, null, ex);
               }
               }
           }
           
       }
      }
    }
   

    @Override
    public void keyPressed(KeyEvent e) {
        if(menuGame==MenuGame.Game){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            imgmaybay=2;
            if(x>=740){
                dx=0;
            }
            if(x<740) dx=3;
            
//			if(x >= 740)
//				x = 740;
//			else
//                        {
//                            x+=dx;
//                        }
		}
       else
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            imgmaybay =1;
            
            if(x<=0)
                dx=0;
            else dx=-3;
//            if(x <= 0)
//				x= 0;
//			else
//				x-=dx;
		}
        else
        if(e.getKeyCode()==KeyEvent.VK_UP){
//            if(y<=0)
//                y=0;
//            else y-=20;
            if(this.y<=0)
                dy=0;
            else
               dy=-3;
        }
        else
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            if(y>=500)
                dy=0;
            else
            dy=3;
//            if(y>=520)
//                y=520;
//            else y+=20;
        }
        else
        if(e.getKeyCode()==KeyEvent.VK_1)
        {
            timer.start();
        }
       }
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        if(e.getX()>=740)
            x=740;
        if(e.getY()>=520)
            y=520;
        e.consume();
    }


   
}

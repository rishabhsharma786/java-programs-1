
import java.awt.Color;
import static java.awt.Color.getColor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class snake extends JFrame implements Runnable, KeyListener{
    int xvel=10,yvel=0,foodn=3;
    JButton[] sb=new JButton[200];
    int[] sbx=new int[200];
    int[] sby=new int[200];
    Point[] pt=new Point[200];
    Random r=new Random();
    JButton f=new JButton();
    boolean food=false,left=false,right=true,down=true,up=true;
    int width=600,height=400;
    JPanel jp=new JPanel();
    int a=10,b=100;
    
    snake(){
        sbx[0]=300;
        sby[0]=200;
        setSize(630,450);
        setResizable(false);
        //setBackground(Color.BLACK);
        setTitle("python");
        setVisible(true);
        setDefaultCloseOperation(3);
        jp.setSize(width,height);
        jp.setLayout(null);
        add(jp);
        jp.setBackground(Color.black);
        createfirstsnake();
        addKeyListener(this);
        Thread t=new Thread(this);
        t.start();
        
    }
    
    public void run() {
        for(;;){
           move();
           putfood();
           //repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(snake.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

  
    public void keyTyped(KeyEvent e) {
        
    }
    
    public void keyPressed(KeyEvent e) {
        
        if(left==true && e.getKeyCode()==37){
            xvel=-10;
            yvel=0;
            right=false;
            up=true;
            down=true;
        }
        if(up==true && e.getKeyCode()==38){
            yvel=-10;
            xvel=0;
            down=false;
            right=true;
            left=true;
        }
        if(right==true && e.getKeyCode()==39){
            xvel=10;
            yvel=0;
            left=false;
            up=true;
            down=true;
        }
        if(down==true && e.getKeyCode()==40){
            yvel=10;
            xvel=0;
            up=false;
            left=true;
            right=true;
        }
        
    }

   
    public void keyReleased(KeyEvent e) {
        
    }
     
    public static void main(String []args){
        new snake();
    }

    private void createfirstsnake() {
        for(int i=0;i<3;i++){
            sb[i]=new JButton();
            sb[0].setBackground(Color.black);
            jp.add(sb[i]);
            sb[i].setEnabled(false);
            sb[i].setBounds(sbx[i],sby[i],10,10);
            sbx[i+1]=sbx[i]-10;
            sby[i+1]=sby[i];
        }
    }
   
    public void move(){
        for (int i = 0; i < foodn; i++) {
            pt[i] = sb[i].getLocation();
        }
        if(sbx[0]>width)
            sbx[0]=10;
        else if(sbx[0]==0)
            sbx[0]=width;
        else if(sby[0]==0)
            sby[0]=height;
        else if(sby[0]>height)
            sby[0]=10;
        sbx[0] += xvel;
        sby[0] += yvel;
        sb[0].setBounds(sbx[0], sby[0], 10, 10);

        for (int i = 1; i < foodn; i++) {
            sb[i].setLocation(pt[i - 1]);
        }
   }
   public void putfood(){
       if(!food){
           a=20+10*r.nextInt(59);
           b=20+10*r.nextInt(39);
           food=true;
           randomback();
       }
           jp.add(f);
           f.setEnabled(false);
           f.setBounds(a, b, 10, 10);
           
       if(sbx[0]==a&&sby[0]==b){
           sb[foodn]=new JButton();
           sb[foodn].setEnabled(false);
           jp.add(sb[foodn]);
           pt[foodn]=sb[foodn-1].getLocation();
           sb[foodn].setLocation(pt[foodn]);
           sb[foodn].setSize(10, 10);
           foodn++;
           food=false;
       }
   }    
   public void randomback(){
      int i=r.nextInt(10);
      if(i==0)
          jp.setBackground(Color.red);
      if(i==1)
          jp.setBackground(Color.black);
      if(i==2)
          jp.setBackground(Color.blue);
      if(i==3)
          jp.setBackground(Color.green);
      if(i==4)
          jp.setBackground(Color.orange);
      if(i==5)
          jp.setBackground(Color.cyan);
      if(i==6)
          jp.setBackground(Color.gray);
      if(i==7)
          jp.setBackground(Color.pink);
      if(i==8)
          jp.setBackground(Color.yellow);
      if(i==9)
          jp.setBackground(Color.magenta);
          
      
      
   }
}

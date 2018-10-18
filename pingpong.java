
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class pingpong extends JFrame implements Runnable,KeyListener{
    JPanel jp=new JPanel();
    public int x=10,y=200,yvel=0;
    public int m=300,n=200,mvel=10,nvel=10;
    JButton pad=new JButton();
    JButton ball=new JButton();
    pingpong(){
        setSize(700,600);
        setTitle("PingPong");
        setResizable(false);
        setBackground(Color.black);
        jp.setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(3);
        add(jp);
        jp.setSize(new Dimension(700,600));
        jp.setBackground(Color.black);
        addKeyListener(this);
        Thread t=new Thread(this);
        t.start();
    }
    public void moverect(){
        jp.add(pad);
        pad.setBackground(Color.red);
        pad.setEnabled(false);
        pad.setVisible(true);
        y=y+yvel;
        pad.setBounds(x, y, 20, 80);
        if(y<0)
            y=0;
        if(y>=490)
            y=490;
    }
    public void moveball() throws InterruptedException{
        m=m+mvel;
        n=n+nvel;
        jp.add(ball);
        ball.setBackground(Color.green);
        ball.setEnabled(false);
        ball.setVisible(true);
        ball.setBounds(m, n, 10, 10);
         if(n<10)
            nvel=-nvel;
        if(n>550)
            nvel=-nvel;
        if(m<40)
            mvel=-mvel;
        if(m>680)
            mvel=-mvel;
        if(!(n>=y&&n<=y+80)&&(m==x+20))
            out();
    }
    public static void main(String []args){
        new pingpong();
    }
    public void run() {
        for(;;){
             moverect();
            try {
                moveball();
            } catch (InterruptedException ex) {
                Logger.getLogger(pingpong.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            Thread.sleep(35);
        } catch (InterruptedException ex) {
            Logger.getLogger(pingpong.class.getName()).log(Level.SEVERE, null, ex);
        }
      }   
    }
    
    public void keyTyped(KeyEvent e) {
        
    }

 
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==38)
            yvel=-20;
        if(e.getKeyCode()==40)
            yvel=20;
        
    }

   
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==38)
            yvel=0;
        if(e.getKeyCode()==40)
            yvel=0;
    }

    private void out() throws InterruptedException {
        ball.setVisible(false);
        pad.setVisible(false);
        Graphics Graphics;
        JTextField out=new JTextField();
        jp.add(out);
        out.setBounds(200, 300, 300, 50);
        Font f=new Font("TimesRoman",Font.PLAIN,30);
        out.setFont(f);
        out.setBackground(Color.white);
        out.setText("THE GAME IS OVER");
        Thread.sleep(2000);
        System.exit(0);
    }
    
}
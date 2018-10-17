import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ludo extends JFrame { 
     int temp1=0,temp2=0,temp3=0,temp4=0;                             // to store current position
     int x=0,y=0,WIDTH=30,HEIGHT=30,flag=0;
     JLabel winner;
     Font f;
     boolean player1=true,player2=false,player3=false,player4=false;  //to find whose turn is currently on alive
     boolean isalive1=false,isalive2=false,isalive3=false,isalive4=false;   //run one time when player got 1 first time
     boolean finish1=false,finish2=false,finish3=false,finish4=false;
     final Random r=new Random();
     final JTextField d=new JTextField();
     JButton b=new JButton("DICE");
     JTextField p1=new JTextField("O1");
     JTextField p2=new JTextField("O2");
     JTextField p3=new JTextField("O3");
     JTextField p4=new JTextField("O4");
     final JTextField t [] =new JTextField[73]; 
     JLabel l1 = new JLabel("Ludo");
     public ludo()
     {
         l1.setBounds(550, 50, 150, 100);
         l1.setFont(new Font("Arial",Font.BOLD,60));
         add(l1);
         add(b);
         add(d);
         add(p1);
         add(p2);
         add(p3);
         add(p4);
         this.setLayout(null);
         setVisible(true);
         setSize(800,600);  
         setDefaultCloseOperation(3);
         
         
         for(int i=0;i<73;i++)
         {
           t[i]=new JTextField(); 
           add(t[i]);
         }
         for(int i=0;i<73;i++)              //starting of for loop for setBounds of blocks
         {
          if(i<=5)
          {
             x+=30;
             y=210;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i>=6&&i<=11)
          {
             x=210;
             y-=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i==12)
          {
             x=240;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
             y-=30;
          }
          if(i<=18&&i>=13)
          {
             x=270;
             y+=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i>=19&&i<=24)
          {
             x+=30;
             y=210;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i==25)
          {
             x=450;
             y+=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
             x+=30;
          }
          if(i<=31&&i>=26)
          {
             x-=30;
             y=270;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i<=37&&i>=32)
          {
             x=270;
             y+=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i==38)
          {
             x-=30;
             y=450;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
             y+=30;
          }
          if(i>=39&&i<=44)
          {
             x=210;
             y-=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i>=45&&i<=50)
          {
             x-=30;
             y=270;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i==51)
          {
             y-=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
          }
          if(i>=52&&i<=56)
          {
             x+=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
            
          }
         if(i==57)
             continue;
         if(i==58){
             x=240;
             y=60;
             t[58].setBounds(x, y, WIDTH, HEIGHT);
          }
         if(i>=59&&i<=62){
             y+=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
         }
         if(i==63){
             x=420;y=240;
             t[63].setBounds(x, y, WIDTH, HEIGHT);
         }
         if(i>=64&&i<=67){
             x-=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
         }
         if(i==68){
             x=240;y=420;
             t[68].setBounds(x, y, WIDTH, HEIGHT);
         }
         if(i>=69&&i<=72){
             y-=30;
             t[i].setBounds(x, y, WIDTH, HEIGHT);
         }
        }                                                //end of for loop for setBounds
      t[57].setBounds(210, 210, 90, 90);      //the final block or center block  
      b.setBounds(550, 200, 100, 50);         //click to play      
      d.setBounds(550, 300, 50, 50);          //random variable textfield            
      p1.setBounds(30, 30, 180, 180);         
      p2.setBounds(300, 30, 180, 180);
      p3.setBounds(300, 300, 180, 180);
      p4.setBounds(30, 300, 180, 180);
 
         
    
      
      b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ 
	                    if(player1){
                                turn1();
                                player1=false;
                                player2=true;
                                return;
                            } 
                            if(player2){
                                turn2();
                                player2=false;
                                player3=true;
                                return;
                            } 
                            if(player3){
                                turn3();
                                player3=false;
                                player4=true;
                                return;
                            } 
                            if(player4){
                                turn4();
                                player4=false;
                                player1=true;
                                return;
                            } 
                        }
		});
     }
     public void turn1(){
             if(d.getText()=="1"&&!isalive1){
                 temp1=1;
                 t[temp1].setText("O1");
                 isalive1=true;
             }
             if(temp1<57){
                t[temp1].setText(" ");
	        int dice=1+r.nextInt(6);
                d.setText(String.valueOf(dice));
                int get=Integer.parseInt(d.getText());  //dice can also use after=
                flag=temp1;
                temp1+=get;
                if(temp1>57)
                temp1=flag;
                if(temp1==57)
                    finish1=true;
                t[temp1].setText("O1");
            }                        
     }
     public void turn2(){
         if(d.getText()=="1"&&!isalive2){
                 temp2=14;
                 t[temp1].setText("O2");
                 isalive2=true;
             }
         if(temp2>=15&&temp2<=51){
                 t[temp2].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 temp2+=get;
                 if(temp2==52)
                     temp2=0;
                 if(temp2==53)
                     temp2=1;
                 if(temp2==54)
                     temp2=2;
                 if(temp2==55)
                     temp2=3;
                 if(temp2==56)
                     temp2=4;
                 if(temp2==57)
                     temp2=5;
                 t[temp2].setText("O2");
         }
         if(temp2>=0&&temp2<=12){
                 t[temp2].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 temp2+=get;
                 if(temp2==13)
                     temp2=58;
                 if(temp2==14)
                     temp2=59;
                 if(temp2==15)
                     temp2=60;
                 if(temp2==16)
                     temp2=61;
                 if(temp2==17)
                     temp2=62;
                 if(temp2==18)
                     temp2=57;
                 t[temp2].setText("O2");
         }
         if(temp2>=58&&temp2<=62){
                 t[temp2].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 flag=temp2;
                 temp2+=get;
                 if(temp2==63)
                     temp2=57;
                 if(temp2>62)
                     temp2=flag;
                 t[temp2].setText("O2");
         }
     }
     public void turn3(){
         if(d.getText()=="1"&&!isalive3){
                 temp3=27;
                 t[temp3].setText("O3");
                 isalive3=true;
             }
         if(temp3>=28&&temp3<=51){
                 t[temp3].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 temp3+=get;
                 if(temp3==52)
                     temp3=0;
                 if(temp3==53)
                     temp3=1;
                 if(temp3==54)
                     temp3=2;
                 if(temp3==55)
                     temp3=3;
                 if(temp3==56)
                     temp3=4;
                 if(temp3==57)
                     temp3=5;
                 t[temp3].setText("O3");
         }
         if(temp3>=0&&temp3<=25){
                 t[temp3].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 temp3+=get;
                 if(temp3==26)
                     temp3=63;
                 if(temp3==27)
                     temp3=64;
                 if(temp3==28)
                     temp3=65;
                 if(temp3==29)
                     temp3=66;
                 if(temp3==30)
                     temp3=67;
                 if(temp3==31)
                     temp3=57;
                 t[temp3].setText("O3");
         }
         if(temp3>=63&&temp3<=67){
                 t[temp3].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 flag=temp3;
                 temp3+=get;
                 if(temp3==68)
                     temp3=57;
                 if(temp3>67)
                     temp3=flag;
                 t[temp3].setText("O3");
         }
         
     }
     public void turn4(){
         if(d.getText()=="1"&&!isalive4){
                 temp4=40;
                 t[temp4].setText("O4");
                 isalive4=true;
             }
         if(temp4>=41&&temp4<=51){
                 t[temp4].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 temp4+=get;
                 if(temp4==52)
                     temp4=0;
                 if(temp4==53)
                     temp4=1;
                 if(temp4==54)
                     temp4=2;
                 if(temp4==55)
                     temp4=3;
                 if(temp4==56)
                     temp4=4;
                 if(temp4==57)
                     temp4=5;
                 t[temp4].setText("O4");
         }
         if(temp4>=0&&temp4<=38){
                 t[temp4].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 temp4+=get;
                 if(temp4==39)
                     temp4=68;
                 if(temp4==40)
                     temp4=69;
                 if(temp4==41)
                     temp4=70;
                 if(temp4==42)
                     temp4=71;
                 if(temp4==43)
                     temp4=72;
                 if(temp4==44)
                     temp4=57;
                 t[temp4].setText("O4");
         }
         if(temp4>=68&&temp4<=72){
                 t[temp4].setText(" ");
	         int dice=1+r.nextInt(6);
                 d.setText(String.valueOf(dice));
                 int get=Integer.parseInt(d.getText());  //dice can also use after =
                 flag=temp4;
                 temp4+=get;
                 if(temp4==73)
                     temp4=57;
                 if(temp4>72)
                     temp4=flag;
                 t[temp4].setText("O4");
         }
     }
	public static void main(String[] args) { 
		ludo l=new ludo();

	}

}

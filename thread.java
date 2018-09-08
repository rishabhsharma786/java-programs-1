class a extends Thread{
  public void run(){
	  for(int i=0;i<50;i++){
		if(i==10)
		 try{sleep(2000); }catch(Exception e){}
        System.out.println("a="+i);
	  }
	  System.out.println("exit of a");
  }
}	
class b extends Thread{
  public void run(){
	  for(int i=0;i<50;i++){
		   if(i==15)
			    yield();
			
	  System.out.println("b="+i);}
	  System.out.println("exit of b");
  }
}
class c extends Thread{
  public void run(){
	  for(int i=0;i<50;i++){
		   if(i==20)
			   stop();
	  System.out.println("c="+i);  }
 	  System.out.println("exit of c");
  }
}
class thread{
	public static void main(String []a){
		new a().start();
		new b().start();
		new c().start();
	}
}
import java.util.*;
class factorial{
	public int fun(int x){
		if(x==1)
			return x;
		else
			return x*fun(x-1);
	}
	public static void main(String []a){
		factorial ob=new factorial();
		Scanner ab=new Scanner(System.in);
		int y=ab.nextInt();
		System.out.print(" factorial of 6 is:"+ob.fun(y));
	}
}

class fab{
	public int fun(int x){
		if(x==1||x==0)
			return x;
		else
			return fun(x-1)+fun(x-2);
	}
	public static void main(String[]args){
		fab a=new fab();
		for(int i=0;i<10;i++)
		System.out.println(a.fun(i));
	}
}

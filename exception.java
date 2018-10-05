class exception
{
	public static void main(String [] ar)
	{
		int valid=0 , invalid=0 , number ;
		for(int i=0;i<ar.length;i++)
		{
			try
			{
				number=Integer.parseInt(ar[i]);
			}
			catch(Exception e)
			{
				invalid=1+invalid;
				System.out.println("invalid number="+ar[i]);
				continue;
			}
			System.out.println("valid number="+ar[i]);
			valid= valid+1;
		}
			System.out.println("total valid number="+valid);
            System.out.println("total invalid number="+invalid);
     }
}
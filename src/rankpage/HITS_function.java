package rankpage;

import java.util.Arrays;

public class HITS_function {
	public static int[][] inv(int[][] arr)
	{   
		int a= arr.length;
		int[][] b =new int[a][a];
		for (int i=0;i<a;i++)
		{
			for(int j=0;j<a;j++)
			{
				b[j][i]=arr[i][j];
							
			}
					
		}
		return b;
	}
	
	public static double[] mult(int[][] a, double[] b)
	{
		int i=a.length;
		double[] c= new double[i];
		double d=0;
		
		for(int j=0;j<i;j++)
		{
			d=0;
			for(int q=0;q<i;q++)
			{
			
				d=d+a[j][q]*b[q];
				
			}
			c[j]=d;
			
		}
		c=HITS_function.normalize(c);
		return c;
	}
	
	public static double[] mult_k(int[][] tp, double[] vec,int k)
	{
		
			tp=HITS_function.inv(tp);
			vec=HITS_function.mult(tp, vec);			
			k=k-1;
			
		if(k>0)
		{	
			vec=HITS_function.mult_k(tp, vec, k);
		}
		
		return vec;
	}
  
	public static double[] normalize(double[] vec)
	{
		double[] vec_n= new double[vec.length];
		double sqr_sum=0;
		for(int i=0;i<vec.length;i++)
		{
			sqr_sum+=vec[i]*vec[i];
			
		}
		sqr_sum=Math.sqrt(sqr_sum);
		
		for(int j=0;j<vec.length;j++)
		{
			vec_n[j]=vec[j]/sqr_sum;
			
		}
		
		return vec_n;
	}
	public static double [] ini_hub(int[][] a)
	{   
		
		int i= a.length;
		double[] hub= new double[i];
		Arrays.fill(hub, 0);
		for(int j=0;j<i;j++)
		{
			for(int t=0;t<i;t++)
			{
				hub[j]=hub[j]+a[j][t];
			}
		}
		hub=HITS_function.normalize(hub);
		return hub;
		
	}
	
}

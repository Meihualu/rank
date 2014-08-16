package rankpage;

import java.util.Arrays;

public class Pagerank_fun {
	
	public static int[] degree(int[][] tp)
	{   
		int i=tp.length;
		int[] deg=new int[i];	
		Arrays.fill(deg, 0);
		for(int j=0;j<i;j++)
		{
			for(int t=0;t<i;t++)
			{
				deg[j]+=tp[j][t];
			}
		}
		return deg;
	}
	
	public static double[][] tp_n(int[][] tp,int[] deg)
	{
		int l=tp.length;
					
		double[][] tpn=new double[l][l];
		
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				tpn[i][j]=1.0*tp[i][j]/deg[i];
				
			}
		}
		
		
		return tpn;
	}

	
	public static double[] rank_k( double[][] tpn, double[] ini,int k)
	{   
		int l=tpn.length ;
			
		double[] rank=new double[l];
		Arrays.fill(rank, 0);
		for(int i=0;i<l;i++)
		{double b=0;
			for(int j=0;j<l;j++)
			{
				b+=tpn[i][j]*ini[j];
			}
			rank[i]=b;
		}
		k=k-1;
		if(k>0)
		{
			rank=rank_k(tpn,rank,k);
		}
		return rank;
	}
	
	public static double[][] inv(double[][] arr)
	{   
		int a= arr.length;
		double[][] b =new double[a][a];
		for (int i=0;i<a;i++)
		{
			for(int j=0;j<a;j++)
			{
				b[j][i]=arr[i][j];
							
			}
					
		}
		return b;
	}
	
	public static double[] rank_k_n( double[][] tpn, double[] ini,int k,double f)
	{   
		int l=tpn.length ;
			
		double[] rank=new double[l];
		Arrays.fill(rank, 0);
		for(int i=0;i<l;i++)
		{double b=0;
			for(int j=0;j<l;j++)
			{
				b+=tpn[i][j]*ini[j];
			}
			rank[i]=f*b+(1-f);
		}
		k=k-1;
		if(k>0)
		{
			rank=/*Pagerank_fun.*/rank_k_n(tpn, rank, k, f);
		}
		return rank;
	}
}

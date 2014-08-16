package rankpage;

import java.util.Arrays;

public class Pagerank_main {

 
	
	public static void main(String[] args) {
		
           int[][] tp=new int[][]{{0,1,1,0,0,0,0,0},
        		   {0,0,0,0,0,0,1,1},
        		   {0,0,0,1,1,0,0,0},
        		   {0,0,0,0,1,1,0,0},
        		   {1,0,0,0,0,1,0,0},
        		   {1,0,0,0,0,0,0,0},
        		   {0,0,0,0,0,0,0,1},
        		   {0,0,0,0,0,0,1,0},
        		   };
           
           int[][] tp_t=HITS_function.inv(tp);
           for(int i=0;i<tp.length;i++)
           {
           System.out.println(Arrays.toString(tp[i]));
           }
           for(int i=0;i<tp.length;i++)
           {
           System.out.println(Arrays.toString(tp_t[i]));
           }
           
           double[] h0=HITS_function.ini_hub(tp);
           System.out.println(Arrays.toString(h0));
           
           double [] auth=HITS_function.mult_k(tp, h0,99);
           
           double [] hub=HITS_function.mult_k(tp,h0, 100);
           double [] auth_1=HITS_function.mult_k(tp, h0, 101);
           double [] hub_1=HITS_function.mult_k(tp,h0, 102);
           
           System.out.println(Arrays.toString(auth));
           System.out.println(Arrays.toString(auth_1));
           System.out.println(Arrays.toString(hub));
           System.out.println(Arrays.toString(hub_1));
           System.out.println(Arrays.toString(h0));
          
           double[] ini=new double[tp.length];
           Arrays.fill(ini,1);
           System.out.println(Arrays.toString(ini));
           int[] deg=Pagerank_fun.degree(tp);
           
           System.out.println(Arrays.toString(deg));
           double [][] tpn=Pagerank_fun.tp_n(tp, deg);
           for(int i=0;i<tp.length ;i++)
           {
        	   System.out.println(Arrays.toString(tpn[i]));
           }
           double [][] tpn_t=Pagerank_fun.inv(tpn);
           for(int i=0;i<tp.length ;i++)
           {
        	   System.out.println(Arrays.toString(tpn_t[i]));
           }
           double[] rank =Pagerank_fun.rank_k(tpn_t, ini, 1);
           System.out.println(Arrays.toString(rank));
           rank =Pagerank_fun.rank_k(tpn_t, ini, 50);
           System.out.println(Arrays.toString(rank));
           
           
           double fac=0.8;
           double[] rank_n=Pagerank_fun.rank_k_n(tpn_t, ini, 5, fac);
           System.out.println(Arrays.toString(rank_n));
           
	}

	
	
	
	
}

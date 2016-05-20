

	/*
	 * Realizado por:
	 * Juan Pablo Bohorquez - 201316189
	 * Felipe Martinez      - 201328315
	 */
	package main;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	public class ProblemaCcon4 
	{	
		private List<Integer> pesasSol;;
		private int[] pesos;
		private int peso;
		private int suma;
		private final static int COTA = 10001;
		private int nuevoObjetivo;
		
		public ProblemaCcon4()
		{
			suma = 0;
			entradaEstandar();
		}
		
		public void entradaEstandar()
		{
			boolean seguir = true;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try
			{
				while(seguir)
				{
					String x_str = br.readLine();
				    peso = Integer.parseInt(x_str);
				    String p_str = br.readLine();
				    String[] p_str_arr = p_str.split(" ");
				    pesos = new int[4*(p_str_arr.length)];
				    for(int i=0;i<p_str_arr.length;i++)
				    {
				    	pesos[i]=Integer.parseInt(p_str_arr[i]) +COTA;
				    	suma+= pesos[i];
				    	pesos[i+p_str_arr.length] = -1*pesos[i]; 
				    	pesos[i+2*p_str_arr.length] = COTA;
				    	pesos[i+3*p_str_arr.length] = COTA; 
				    }
				      suma+= pesos.length*COTA/4;
				      int p = 0;
				      while(Math.pow(2, p) < suma)
				      {
				    	p++;
				      }
				      nuevoObjetivo = (int) Math.pow(2, -p);
				      peso = peso +(pesos.length*COTA/4);
				      boolean respuesta = problemaC();
				      suma= 0;
				      if(respuesta)
				      {
				    	  System.out.println("S");
				      }
				      else
				      {
				    	  System.out.println("N");
				      }	
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		public boolean problemaC()
		{
			pesasSol = new ArrayList<Integer>();
			pesasSol.add(0);
			for(int i = 0; i < pesos.length; i++)
			{
				List<Integer>listaT = new ArrayList<Integer>();
				for(int j = 0; j<pesasSol.size(); j ++)
				{
					listaT.add(pesos[i]+pesasSol.get(j));
					
				}
				List<Integer> listaU = new ArrayList<Integer>();
				listaU.addAll(listaT);
				listaU.addAll(pesasSol);
				Collections.sort(listaU);
				pesasSol.removeAll(pesasSol);
				int y = listaU.get(0);
				pesasSol.add(y);
				for(int k = 0; k<listaU.size(); k++)
				{
					double cm = y+(nuevoObjetivo*peso/pesos.length);
					if(cm<listaU.get(k)&&listaU.get(k)<= peso)
					{
						y = listaU.get(k);
						pesasSol.add(listaU.get(k));
					}
				}	
			}
			boolean resp = false;
			for(int i = 0; i < pesasSol.size(); i++)
			{
				double cm = (1-nuevoObjetivo)*peso;
				if(pesasSol.get(i)>= cm && pesasSol.get(i) <= peso)
				{
					resp= true;
				}
				else 
				{
					resp = false;
				}
			}
			return resp;	
		}
		public static void main(String[] args) {
			new ProblemaCcon4();
		}
	
}

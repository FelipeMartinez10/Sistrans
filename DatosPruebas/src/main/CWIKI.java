package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CWIKI
{
	//REVISAR FORMATO ENTREGA

	private long tiempoInicio;
	private long tiempoFin;
	
	
	
	private int A;
	private int B;
	private int[] pesos;
	private boolean valoresCalculados[];
	private int peso;
	
	
	public CWIKI()
	{
		A = 0;
		B = 0;
	}
	
	public void entradaEstandar()
	{
		
		boolean seguir = true;
		boolean primero = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			
			while(seguir)
			{
				String x_str = br.readLine();
				
			      if(x_str.equals("T"))
			      {
			        seguir = false;
			      }  
			      peso = Integer.parseInt(x_str);
			      String p_str = br.readLine();
			      if(p_str.equals("T"))
			      {
			        seguir = false;
			      }
			      
			      
			      String[] p_str_arr = p_str.split(" ");
			      
			      pesos = new int[(p_str_arr.length*2)+1];
			      int i = 0;
			      while(i<p_str_arr.length)
			      {
			    	int valor = Integer.parseInt(p_str_arr[i]);
			        pesos[i]= valor*-1;
			        i++;
			      }
			      if(i==p_str_arr.length)
			      {
			    	  pesos[i] = 0;
			    	  i ++;
			      }
			      int k = 0;
			      while(k<p_str_arr.length && i<pesos.length)
			      {
			        pesos[i]= Integer.parseInt(p_str_arr[k]);
			        k++;
			        i++;
			      }
			      valoresCalculados = new boolean[pesos.length];
			      
			      tiempoInicio = System.currentTimeMillis();
			      boolean respuesta = problemaC();
			      System.out.println("A: "+A+ " B: "+B);
			      if(respuesta)
			      {
			    	  System.out.println("S");
			      }
			      else
			      {
			    	  System.out.println("N");
			      }
			     tiempoFin = System.currentTimeMillis();
				System.out.println("Tiempo en milisegundos: "+ (tiempoFin - tiempoInicio));
				limpiar();
			
				
			}
			
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void limpiar() {
		// TODO Auto-generated method stub
		A = 0;
		B = 0;
	}

	public boolean problemaC()
	{
		boolean respuesta;
		boolean seguir = true;
		for(int i = 0; i < pesos.length && seguir; i++)
		{
			if(pesos[i] != 0)
			{
				A += pesos[i];
			}
			else
			{
				seguir = false;
				B= A*-1;
			}
		}
		
		if( peso > B)
		{
			return false;
		}
		else
		{
			//respuesta = satisfaceSat(0, peso);
			System.out.println("AQUI EMPIEZA ARREGLO---------------------------");
			for(int i = 0;i<valoresCalculados.length; i++)
			{
				valoresCalculados[i] = satisfaceSat(i,peso);
				System.out.println(valoresCalculados[i]);
			}
		}
		return false;
		
		
	}
	
	
	public boolean satisfaceSat(int i, int s)
	{
		boolean resp = false;
		if(i == 0)
		{
			resp = pesos[i] == peso;
			return  resp;
		}
		else
		{
			if(pesos[i] == s)
			{
				return true;
			}
			else
			{
				resp = satisfaceSat(i-1,s) || satisfaceSat(i-1,s-pesos[i]);
				return resp;
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CWIKI nuevo = new CWIKI();
		nuevo.entradaEstandar();
	}
}
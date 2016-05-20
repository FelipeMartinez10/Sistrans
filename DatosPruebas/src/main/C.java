package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class C 
{
	//REVISAR FORMATO ENTREGA
	
	
	
	
	private long tiempoInicio;
	private long tiempoFin;
	
	
	private int[] balanza;
	private int[] pesos;
	private int peso;
	
	/*private int valorPasado;
	private int posCambio;
	private int ultimoPesoCalculado = 0;
	private int pesoCalculado;*/
	
	public C()
	{
		
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
			      pesos = new int[p_str_arr.length];
			      for(int i=0;i<p_str_arr.length;i++)
			      {
			        pesos[i]=Integer.parseInt(p_str_arr[i]);
			      }
			      tiempoInicio = System.currentTimeMillis();
			      boolean respuesta = problemaC();
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
					
			
				
			}
			
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean problemaC()
	{
		balanza = new int[pesos.length];
		for(int i = 0; i < balanza.length; i++)
		{
			balanza[i] = 0;
		}
		
		int[] agenda = sucesor(balanza);
		while(!satisfaceSat(balanza) && agenda != null)
		{
			balanza = agenda;
			agenda = sucesor(balanza);
		}
		if(agenda == null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
		
		
	}
	public int[] sucesor(int[] pActual)
	{
		boolean seguir = true;
		int[] respuesta = pActual;
		for(int i = pActual.length-1; i >= 0 && seguir; i--)
		{
		
			if(pActual[i] == 0)
			{
				//valorPasado = respuesta[i];
				respuesta[i] = 1;
				seguir = false;
				//posCambio = i;
			}
			else if(pActual[i] == 1)
			{
				//valorPasado = respuesta[i];
				respuesta[i] = -1;
				seguir = false;
				//posCambio = i;
			}
			else
			{
				
				respuesta[i] = 0;
				
			}
		}
		if(seguir)
		{
			return null;
		}
		
		return respuesta;
	}

	public boolean satisfaceSat(int[] pBalanza)
	{
		boolean resp = false;
		int pesoCalculado = 0;
		for(int i = 0; i< pBalanza.length; i++)
		{
			pesoCalculado+= pBalanza[i]*pesos[i];
			
		}
		if(peso == pesoCalculado)
		{
			for(int i = 0; i< pBalanza.length; i++)
			{
				System.out.println(pBalanza[i]*pesos[i]+" ");
			}
			
			resp = true;
		}
		return resp;
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C nuevo = new C();
		//nuevo.iniciarDialogo();
		nuevo.entradaEstandar();
		
	}

}
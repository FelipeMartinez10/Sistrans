package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class C2 
{
	//REVISAR FORMATO ENTREGA
	
	
	
	
	private long tiempoInicio;
	private long tiempoFin;
	
	
	private ArrayList balanza;
	private ArrayList pesos;
	private int peso;
	
	private ArrayList<ArrayList> lista = new ArrayList<ArrayList>();
	
	
	
	public C2()
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
			      pesos = new ArrayList();
			      for(int i=0;i<p_str_arr.length;i++)
			      {
			        pesos.add(Integer.parseInt(p_str_arr[i]));
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
		balanza = new ArrayList();
		ArrayList agenda = sucesor(balanza);
		
		
		while(!satisfaceSat(balanza) && agenda.size() != 0)
		{
			balanza = (ArrayList) agenda.get(0);
			agenda.remove(0);
			agenda.addAll(sucesor(balanza));
		}
		if(agenda.size() == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
		
		
	}
	public ArrayList<ArrayList> sucesor(ArrayList pActual)
	{
		ArrayList<ArrayList> respuesta = new ArrayList<ArrayList>();
		ArrayList s1 = new ArrayList();
		if(pActual.size() == 0)
		{	
			
			
			for(int i = 0; i < pesos.size(); i ++)
			{
				
				s1.add(pesos.get(i));
				respuesta.add(s1);
				s1.remove(0);
			}
		}
		else
		{
			if((Integer)pActual.get(pActual.size()-1) > 0)
			{
				s1 = pActual;
				s1.remove(s1.size()-1);
				s1.add(-1*(Integer)pActual.get(pActual.size()-1));
				respuesta.add(s1);	
			}
			s1 = pActual;
			int index = pesos.indexOf(pActual.get(pActual.size()-1));
			for(int i = index; i < pesos.size(); i ++)
			{
				s1.add(pesos.get(i));
				respuesta.add(s1);
				s1.remove(s1.size()-1);
			}
			
			
		}
		
		
		return respuesta;
	}

	public boolean satisfaceSat(ArrayList pBalanza)
	{
		
		int pesoCalculado = 0;
		for(int i = 0; i< pBalanza.size(); i++)
		{
			pesoCalculado+= (Integer)pBalanza.get(i);
			
		}
		if(peso == pesoCalculado)
		{
			return true;
		}
		return false;
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C2 nuevo = new C2();
		//nuevo.iniciarDialogo();
		nuevo.entradaEstandar();
		
	}

}
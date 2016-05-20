package main;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
	import java.util.Scanner;




	public class CrearCSV 
	{
		
		private static final String COMA = ",";
		private static final String NUEVALINEA = "\n";
		//private static final String ENCABEZADO= "ID_BUQUE,NOMBRE,NOMBRE_AGENTE_MARITIMO,REGISTRO_CAPITANIA,CAPACIDAD_TEUS,TIPO";
		//private final static String NOMBRE_FILE = "./data/muelles.csv";
		
		public CrearCSV()
		{
			iniciarDialogo();
		}
		
		public void writeFileBuques()
		{
			
			FileWriter writer;
			try
			{
				writer= new FileWriter("./data/buques.csv");
				Random rand = new Random();
				Random r = new Random();
				String[] tipos = new String[3];
				tipos[0] ="PortaContenedores";
				tipos[1] ="Multiproposito";
				tipos[2] ="Ro-Ro";			
						
	    		writer.append("ID_BUQUE,NOMBRE,NOMBRE_AGENTE_MARITIMO,REGISTRO_CAPITANIA,CAPACIDAD_TEUS,TIPO");
	    		for(int i = 1000001; i <= 2000000; i++)
	    		{
	    			writer.append(NUEVALINEA);
	    			writer.append(String.valueOf(i));
	    			writer.append(COMA);
	    			writer.append("buque"+i);
	    			writer.append(COMA);
	    			writer.append("agente"+i);
	    			writer.append(COMA);
	    			writer.append("registro"+i);
	    			writer.append(COMA);
	    			//double randomValue = 1 + (1000 - 1) * r.nextDouble();
	    			int randomTEUS = rand.nextInt((1000 - 1) + 1) + 1;
	    			//writer.append(String.format("%.2f", randomValue));
	    			writer.append(String.valueOf(randomTEUS));
	    			writer.append(COMA);
	    			int randomNum = rand.nextInt((2 - 0) + 1) + 0;
	    			String tipo = tipos[randomNum];
	    			writer.append(tipo);
	    			
	    			
	    		}
				writer.close();
			
			}
			catch (IOException e) {
				System.out.println("Error escribiendo archivo");
			}
		}
			public void writeFileMuelles()
			{
				
				FileWriter writer;
				try
				{
					writer= new FileWriter("./data/muelles.csv");		
		    		writer.append("ID_MUELLE,ESTADO");
		    		for(int i = 1000001; i <= 2000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append("0");
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			
			public void writeFileBodegas()
			{
				
				FileWriter writer;
				try
				{
					Random rand = new Random();
					writer= new FileWriter("./data/bodegas.csv");		
		    		writer.append("ID_BODEGA,ANCHO,LARGO,SEPARACION_COLUMNAS,PLATAFORMA_EXTERNA,FUNCIONANDO");
		    		for(int i = 1000001; i <= 2000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			int ancho = rand.nextInt((20 - 5) + 1) + 5;
		    			writer.append(String.valueOf(ancho));
		    			writer.append(COMA);
		    			int largo = rand.nextInt((20 - 5) + 1) + 5;
		    			writer.append(String.valueOf(largo));
		    			writer.append(COMA);
		    			int separa = rand.nextInt((20 - 5) + 1) + 5;
		    			writer.append(String.valueOf(separa));
		    			writer.append(COMA);
		    			int plat = rand.nextInt((1 - 0) + 1) + 0;
		    			writer.append(String.valueOf(plat));
		    			writer.append(COMA);
		    			writer.append("1");
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileCargas()
			{
				
				FileWriter writer;
				try
				{
					String[] tipos = new String[4];
					tipos[0] ="GRANEL";
					tipos[1] ="CONTENERIZADA";
					tipos[2] ="GENERAL";	
					tipos[3] = "CARBONIFERA";
					Random rand = new Random();
					writer= new FileWriter("./data/cargas.csv");		
		    		writer.append("ID_CARGA,CANTIDAD,TIPO,ESTADO");
		    		for(int i = 3000001; i <= 4000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			int cantidad = rand.nextInt((5000 - 1) + 1) + 1;
		    			writer.append(String.valueOf(cantidad));
		    			writer.append(COMA);
		    			int randomNum = rand.nextInt((3 - 0) + 1) + 0;
		    			String tipo = tipos[randomNum];
		    			writer.append(tipo);
		    			writer.append(COMA);
		    			writer.append("1");
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileEventos()
			{
				
				
				FileWriter writer;
				try
				{
				
					Random rand = new Random();
					writer= new FileWriter("./data/eventos.csv");		
		    		writer.append("ID_EVENTO,FECHA");
		    		for(int i = 1000001; i <= 2000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			long offset = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
						long end = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
						long diff = end - offset + 1;
						Timestamp randTime = new Timestamp(offset + (long)(Math.random() * diff));
						Date fecha = new Date(randTime.getTime());
						String cad = fecha.toString();
	
						final String OLD_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
						final String NEW_FORMAT = "dd/MM/yyyy";

						String oldDateString = cad;
						String newDateString;

						SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT,Locale.ENGLISH);
						Date d = sdf.parse(oldDateString);
						sdf.applyPattern(NEW_FORMAT);
						newDateString = sdf.format(d);
						
						//System.out.println(newDateString);
						
						
						
						writer.append(newDateString);
		    		
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException | ParseException e) {
					System.out.println(e.getMessage());
					System.out.println("Error escribiendo archivo");
				}
			
		}
			
			public void writeFileSalidas()
			{
				
				FileWriter writer;
				try
				{
		
					
					writer= new FileWriter("./data/salidas.csv");		
		    		writer.append("ID_SALIDA_MUELLE,ID_MUELLE,ID_BUQUE,ID_EVENTO");
		    		for(int i = 1; i <= 1000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileLlegadas()
			{
				
				FileWriter writer;
				try
				{
		
					
					writer= new FileWriter("./data/llegadas.csv");		
		    		writer.append("ID_LLEGADA,ID_MUELLE,ID_BUQUE,ID_EVENTO");
		    		for(int i = 1; i <= 1000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i+1000000));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i+1000000));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileExportador()
			{
				
				FileWriter writer;
				try
				{
		
					String[] tipos = new String[14];
					tipos[0] ="Colombia";
					tipos[1] ="Brasil";
					tipos[2] ="Uruguay";
					tipos[3] ="Francia";	
					tipos[4] ="Estados Unidos";	
					tipos[5] ="Australia";	
					tipos[6] ="Japon";	
					tipos[7] ="China";	
					tipos[8] ="Rusia";
					tipos[9] ="Inglaterra";	
					tipos[10] ="Alemania";	
					tipos[11] ="Argentina";	
					tipos[12] ="Chile";
					tipos[13] ="Mexico";	
					Random rand = new Random();
					
					writer= new FileWriter("./data/exportador.csv");		
		    		writer.append("NOMBRE_EXPORTADOR,PAIS,PERSONA_CONTACTO,CORREO,ID_CARGA,ID_EXPORTADOR");
		    		for(int i = 1; i <= 100000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append("Exportador"+i);
		    			writer.append(COMA);
		    			int randomNum = rand.nextInt((13 - 0) + 1) + 0;
		    			String tipo = tipos[randomNum];
		    			writer.append(tipo);
		    			writer.append(COMA);
		    			writer.append("Persona"+i);
		    			writer.append(COMA);
		    			writer.append("Correo"+i);
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileImportador()
			{
				
				FileWriter writer;
				try
				{
		
					
					writer= new FileWriter("./data/salidas.csv");		
		    		writer.append("ID_SALIDA_MUELLE,ID_MUELLE,ID_BUQUE,ID_EVENTO");
		    		for(int i = 1; i <= 1000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileEquipoDeApoyo()
			{
				
				FileWriter writer;
				try
				{
		
					String[] tipos = new String[3];
					tipos[0] ="Montacargas";
					tipos[1] ="Elevador";
					tipos[2] ="Grua Portico";	
					Random rand = new Random();
					writer= new FileWriter("./data/equipoapoyo.csv");		
		    		writer.append("ID_EQUIPO,TIPO,CAPACIDAD");
		    		for(int i = 1000001; i <= 2000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			int randomNum = rand.nextInt((2 - 0) + 1) + 0;
		    			String tipo = tipos[randomNum];
		    			writer.append(tipo);
		    			writer.append(COMA);
		    			int randCap = rand.nextInt((700 - 20) + 1) + 20;
		    			writer.append(String.valueOf(randCap));
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileCargarMaritima()
			{
				
				FileWriter writer;
				try
				{
		
					
					writer= new FileWriter("./data/cargarMaritima.csv");		
		    		writer.append("ID_OPERACION,ID_CARGA_MARITIMA,ID_MUELLE,ID_CARGA,ID_BUQUE,ID_EQUIPO_APOYO");
		    		for(int i = 1000001; i <= 2000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i-1000000));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i+1000000));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
			public void writeFileAlojamientoEnBodega()
			{
				
				FileWriter writer;
				try
				{
		
					
					writer= new FileWriter("./data/alojamientoBodega.csv");		
		    		writer.append("ID_CARGA,ID_BODEGA,ID_EVENTO");
		    		for(int i = 1; i <= 1000000; i++)
		    		{
		    			writer.append(NUEVALINEA);
		    			writer.append(String.valueOf(i+3000000));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i+1000000));
		    			writer.append(COMA);
		    			writer.append(String.valueOf(i));
		    			
		    			
		    			
		    		}
					writer.close();
				
				}
				catch (IOException e) {
					System.out.println("Error escribiendo archivo");
				}
			
		}
		public void iniciarDialogo()
		{
			Scanner in = new Scanner(System.in);
			System.out.println("MENU:");
			System.out.println("1. Crear Buques");
			System.out.println("2. Crear Muelles");
			System.out.println("3. Crear Bodegas");
			System.out.println("4. Crear Cargas");
			System.out.println("5. Crear Eventos");
			System.out.println("6. Crear Salidas");
			System.out.println("7. Crear Llegadas");
			System.out.println("8. Crear EquiposApoyo");
			System.out.println("9. Crear CargarMaritima");
			System.out.println("10. Crear AlojaEnBodegas");
			System.out.println("11. Crear Exportador");
			
			String org = in.nextLine();
			if(org.equals("1"))
			{
				writeFileBuques();
			}
			if(org.equals("2"))
			{
				writeFileMuelles();
			}
			if(org.equals("3"))
			{
				writeFileBodegas();
			}
			if(org.equals("4"))
			{
				writeFileCargas();
			}
			if(org.equals("5"))
			{
				writeFileEventos();
			}
			if(org.equals("6"))
			{
				writeFileSalidas();
			}
			if(org.equals("7"))
			{
				writeFileLlegadas();
			}
			if(org.equals("8"))
			{
				writeFileEquipoDeApoyo();
			}
			if(org.equals("9"))
			{
				writeFileCargarMaritima();
			}
			if(org.equals("10"))
			{
				writeFileAlojamientoEnBodega();
			}
			if(org.equals("11"))
			{
				writeFileExportador();
			}
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			CrearCSV prin = new CrearCSV();

		}

	

}

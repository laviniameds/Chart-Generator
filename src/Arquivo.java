import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Arquivo {
	
    private static ArrayList<String> bairros = new ArrayList<String> ();
	   
	public static ArrayList<String> nomesBairros(String csvFile) {
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
		
		
	        try {
	
	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {
	
	                String[] linhaArquivo = line.split(cvsSplitBy);
	                for(int i = 0;i<linhaArquivo.length;i++){
	                	if(!(linhaArquivo[i].equalsIgnoreCase("neighbourhood_group")) && 
	                			!(linhaArquivo[i].equalsIgnoreCase("neighbourhood")) && 
	                			!(linhaArquivo[i].equalsIgnoreCase(""))){
			               bairros.add(linhaArquivo[i]);		                	
	                	}
	                }
	                
	            }
	        } 
	        
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
			return bairros;
	
	    }   

    public static int[] ofertasBairro(String csvFileBairros, String csvFile) {
    	nomesBairros(csvFileBairros);
    	
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
    	
    	int valoresBairros[] = new int[bairros.size()];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] linhaArquivo = line.split(cvsSplitBy);
                for(int i = 0;i<linhaArquivo.length;i++){
                	for(int j = 0;j<bairros.size();j++){
                		if(linhaArquivo[i].equalsIgnoreCase(bairros.get(j)))
                			valoresBairros[j]++;
                	}
                }
                
            }
        } 
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return valoresBairros;

    }
    
    public static void main(String[] args){   	
    	
    }

}
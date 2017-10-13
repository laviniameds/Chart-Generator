import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {
	
    private String csvFile = "/home/lavinia/workspace/Chart-Generator/dataset/airbnb.csv";
    private BufferedReader br = null;
    private String line = "";
    private String cvsSplitBy = ",";
    private int case1 = 0, case2 = 0, case3 = 0, case4 = 0;


    public int[] ofertasBairro() {
    	
    	int valoresBairros[] = new int[4];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] linhaArquivo = line.split(cvsSplitBy);
                for(int i = 0;i<linhaArquivo.length;i++){
                	switch(linhaArquivo[i].toString()){
	                	case "Dn Laoghaire-Rathdown": case1++;
	                		break;
	                	case "Dublin City": case2++;
	                		break;
	                	case "Fingal": case3++;
	                		break;
	                	case "South Dublin": case4++;
	                		break;
	                	default: 
	                		break;
                	}
                }
                
            }
            valoresBairros[0] = case1;
            valoresBairros[1] = case2;
            valoresBairros[2] = case3;
            valoresBairros[3] = case4;

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
import java.io.*; 
import java.util.ArrayList;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ChartUtilities; 

public class BarChart3D {
	
	public void gerarGrafico(String path, Arquivo f) throws Exception {
	  int valoresBairros[] = f.ofertasBairro();
	  ArrayList<String> nomesBairros = f.nomesBairros();
              
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      for(int i = 0;i<valoresBairros.length;i++){
    	  dataset.addValue( valoresBairros[i] , nomesBairros.get(i) , "Quartos" );
      }             
      
      JFreeChart barChart = ChartFactory.createBarChart3D(
 	         "Ofertas de quartos por Bairro",           
 	         "Nome do bairro",            
 	         "Quartos",             
 	         dataset,          
 	         PlotOrientation.VERTICAL,           
 	         true, true, false);
                                  
      File barChart3D = new File(path + "/BarChart3D.jpeg");                            
      ChartUtilities.saveChartAsJPEG( barChart3D, barChart, 1024 , 768);
	}
}
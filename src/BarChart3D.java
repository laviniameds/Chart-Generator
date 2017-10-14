import java.io.*; 
import java.util.ArrayList;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ChartUtilities; 

public class BarChart3D {
	
	public void gerarGrafico() throws Exception {
	  Arquivo f = new Arquivo();
	  int valoresBairros[] = f.ofertasBairro();
	  ArrayList<String> nomesBairros = f.nomesBairros();
              
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      for(int i = 0;i<valoresBairros.length;i++){
    	  dataset.addValue( valoresBairros[i] , nomesBairros.get(i) , "Quantidade" );
      }             
      
      JFreeChart barChart = ChartFactory.createBarChart3D(
 	         "Ofertas por Bairro",           
 	         "Bairro",            
 	         "Quantidade",            
 	         dataset,          
 	         PlotOrientation.VERTICAL,           
 	         true, true, false);
                                  
      File barChart3D = new File( "/home/lavinia/workspace/Chart-Generator/img/BarChart3D.jpeg" );                            
      ChartUtilities.saveChartAsJPEG( barChart3D, barChart, 560 , 367);
	}
}
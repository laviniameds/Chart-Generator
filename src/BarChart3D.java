import java.io.*; 

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ChartUtilities; 

public class BarChart3D {
	
	public static void gerarGrafico() throws Exception {
	  Arquivo f = new Arquivo();
	  int valoresBairros[] = f.ofertasBairro();
      
      final String qtd = "Quantidade";              
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      dataset.addValue( valoresBairros[0] , "Dn Laoghaire-Rathdown" , qtd );                 

      dataset.addValue( valoresBairros[1] , "Dublin City" , qtd );        

      dataset.addValue( valoresBairros[2] , "Fingal" , qtd );
      
      dataset.addValue( valoresBairros[3] , "South Dublin" , qtd );              
      
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
   
	public static void main(String[] args) throws Exception {
	  gerarGrafico();
   }
}
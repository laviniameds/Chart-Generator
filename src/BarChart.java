import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart extends ApplicationFrame {
   
   public BarChart() throws IOException {
	      super( "Ofertas por Bairro" ); 
	      setContentPane(createDemoPanel( ));
	   }
  
   public static JPanel createDemoPanel( ) throws IOException {
	      JFreeChart chart = createChart(createDataset( ) );  
	      return new ChartPanel( chart ); 
	   }
   
   private static JFreeChart createChart(CategoryDataset dataset){
      JFreeChart barChart = ChartFactory.createBarChart(
    	         "Ofertas por Bairro",           
    	         "Bairro",            
    	         "Quantidade",            
    	         dataset,          
    	         PlotOrientation.VERTICAL,           
    	         true, true, false);
    	      
    	              
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
	return barChart;  
   }
   
   private static CategoryDataset createDataset( ) {
	  Arquivo f = new Arquivo();
	  int valoresBairros[] = f.ofertasBairro();
	  ArrayList<String> nomesBairros = f.nomesBairros();
                    
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
      
      for(int i = 0;i<valoresBairros.length;i++){
    	  dataset.addValue( valoresBairros[i] , nomesBairros.get(i) , "Quantidade" );
      }

      return dataset; 
   } 
   
   public void gerarGrafico() throws IOException {
	      File BarChart = new File("/home/lavinia/workspace/Chart-Generator/img/BarChart.jpeg"); 
	      ChartUtilities.saveChartAsJPEG( BarChart , createChart(createDataset()) , 560 , 367 );           
   }
}
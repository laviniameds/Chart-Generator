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

public class BarChart extends ApplicationFrame {
   
   public BarChart(Arquivo f) throws IOException {
	      super( "Ofertas por Bairro" ); 
	      setContentPane(createDemoPanel(f));
	   }
  
   public static JPanel createDemoPanel(Arquivo f) throws IOException {
	      JFreeChart chart = createChart(createDataset(f) );  
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
   
   private static CategoryDataset createDataset(Arquivo f) {
	  int valoresBairros[] = f.ofertasBairro();
	  ArrayList<String> nomesBairros = f.nomesBairros();
                    
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
      
      for(int i = 0;i<valoresBairros.length;i++){
    	  dataset.addValue( valoresBairros[i] , nomesBairros.get(i) , "Quantidade" );
      }

      return dataset; 
   } 
   
   public void gerarGrafico(String path, Arquivo f) throws IOException {
	      File BarChart = new File(path + "/BarChart.jpeg"); 
	      ChartUtilities.saveChartAsJPEG( BarChart , createChart(createDataset(f)) , 560 , 367 );           
   }
}
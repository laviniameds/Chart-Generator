import java.io.File;
import java.io.IOException;

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
   
   public BarChart( String title ) throws IOException {
	      super( title ); 
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
      
      final String qtd = "Quantidade";              
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      dataset.addValue( valoresBairros[0] , "Dn Laoghaire-Rathdown" , qtd );                 

      dataset.addValue( valoresBairros[1] , "Dublin City" , qtd );        

      dataset.addValue( valoresBairros[2] , "Fingal" , qtd );
      
      dataset.addValue( valoresBairros[3] , "South Dublin" , qtd );  

      return dataset; 
   } 
   
   public static void gerarGrafico() throws IOException {
	      File BarChart = new File("/home/lavinia/workspace/Chart-Generator/img/BarChart.jpeg"); 
	      ChartUtilities.saveChartAsJPEG( BarChart , createChart(createDataset()) , 560 , 367 );           
   }
   
   public static void main(String[] args) throws IOException {
      gerarGrafico();        
   }
}
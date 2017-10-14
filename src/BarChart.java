import java.io.File;
import java.io.IOException;

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
	
	//bar chart
   
   public BarChart( String applicationTitle , String chartTitle ) throws IOException {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Bairro",            
         "Quantidade",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
      
      File BarChart = new File("/home/lavinia/workspace/Chart-Generator/img/BarChart.jpeg"); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , 560 , 367 );
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
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
	   
   
   public static void main( String[ ] args ) throws IOException {
	  BarChart chart = new BarChart("Ofertas por Bairro", 
         "Dublin, Leinster, Ireland");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
            
   }
}
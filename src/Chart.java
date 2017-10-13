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

public class Chart extends ApplicationFrame {
   
   public Chart( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Bairros",            
         "Quantidade",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
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
	   Chart chart = new Chart("Ofertas por Bairro", 
         "Dublin, Leinster, Ireland");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
      
      
   }
}
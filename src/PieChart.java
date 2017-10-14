import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart extends ApplicationFrame {
   
   public PieChart( String title ) throws IOException {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      Arquivo f = new Arquivo();
	  int valoresBairros[] = f.ofertasBairro();
      PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1}");
	  
      dataset.setValue( "Dn Laoghaire-Rathdown" , new Double(valoresBairros[0]) );  
      dataset.setValue( "Dublin City" , new Double(valoresBairros[1]) );   
      dataset.setValue( "Fingal" , new Double( valoresBairros[2] ) );    
      dataset.setValue( "South Dublin" , new Double( valoresBairros[3] ) );
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) throws IOException {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Ofertas por Bairro",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      
      PiePlot plot = (PiePlot) chart.getPlot();
      plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} - {2}"));  
      
      File PieChart = new File("/home/lavinia/workspace/Chart-Generator/img/PieChart.jpeg"); 
      ChartUtilities.saveChartAsJPEG( PieChart , chart , 560 , 367 );

      return chart;
   }
   
   public static JPanel createDemoPanel( ) throws IOException {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) throws IOException {
	  PieChart demo = new PieChart( "Ofertas por Bairro" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true );
      
   }
}
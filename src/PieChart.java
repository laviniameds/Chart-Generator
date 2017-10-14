import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	  ArrayList<String> nomesBairros = f.nomesBairros();
	  
	  for(int i = 0;i<valoresBairros.length;i++){
	      dataset.setValue( nomesBairros.get(i) , new Double(valoresBairros[i]) ); 
      }    
	   
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Ofertas por Bairro",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      
      PiePlot plot = (PiePlot) chart.getPlot();
      plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} - {2}"));  

      return chart;
   }
   
   public static JPanel createDemoPanel( ) throws IOException {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

   public void gerarGrafico() throws IOException{
	   
      File PieChart = new File("/home/lavinia/workspace/Chart-Generator/img/PieChart.jpeg"); 
      ChartUtilities.saveChartAsJPEG( PieChart , createChart(createDataset()) , 560 , 367 );
      
   }
}
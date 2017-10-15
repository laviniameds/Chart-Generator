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
   
   public PieChart(Arquivo f) throws IOException {
      super( "Ofertas de quartos por Bairro" ); 
      setContentPane(createDemoPanel(f));
   }
   
   private static PieDataset createDataset(Arquivo f) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
	  int valoresBairros[] = f.ofertasBairro();
	  ArrayList<String> nomesBairros = f.nomesBairros();
	  
	  for(int i = 0;i<valoresBairros.length;i++){
	      dataset.setValue( nomesBairros.get(i) , new Double(valoresBairros[i]) ); 
      }    
	   
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Ofertas de quartos por bairro",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      
      PiePlot plot = (PiePlot) chart.getPlot();
      plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} - {1} - {2}"));  

      return chart;
   }
   
   public static JPanel createDemoPanel(Arquivo f) throws IOException {
      JFreeChart chart = createChart(createDataset(f) );  
      return new ChartPanel( chart ); 
   }

   public void gerarGrafico(String path, Arquivo f) throws IOException{
	   
      File PieChart = new File(path + "/PieChart.jpeg"); 
      ChartUtilities.saveChartAsJPEG( PieChart , createChart(createDataset(f)) , 1024 , 768 );
      
   }
}
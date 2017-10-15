import java.io.*; 
import java.util.ArrayList;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.data.general.DefaultPieDataset; 
import org.jfree.chart.ChartUtilities;

public class PieChart3D {

   public void gerarGrafico(String path, Arquivo f) throws Exception {
      DefaultPieDataset dataset = new DefaultPieDataset( );             
	  int valoresBairros[] = f.ofertasBairro();
	  
	  ArrayList<String> nomesBairros = f.nomesBairros();
	  
	  for(int i = 0;i<valoresBairros.length;i++){
	      dataset.setValue( nomesBairros.get(i) , new Double(valoresBairros[i]) ); 
      }  

      JFreeChart chart = ChartFactory.createPieChart3D( 
         "Ofertas por Bairro" ,  // chart title                   
         dataset ,         // data 
         true ,            // include legend                   
         true, 
         false);

      final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
      plot.setStartAngle( 180 );             
      plot.setForegroundAlpha( 0.60f );             
      plot.setInteriorGap( 0.02 );     
      plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} - {2}"));  
      
      File pieChart3D = new File(path + "/PieChart3D.jpeg");                           
      ChartUtilities.saveChartAsJPEG( pieChart3D , chart , 1024 , 768 );
   }
}
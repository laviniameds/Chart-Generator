import java.io.*; 

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.data.general.DefaultPieDataset; 
import org.jfree.chart.ChartUtilities;

public class PieChart3D {

   public void gerarGrafico() throws Exception {
      DefaultPieDataset dataset = new DefaultPieDataset( );             
      Arquivo f = new Arquivo();
	  int valoresBairros[] = f.ofertasBairro();
	  
      dataset.setValue( "Dn Laoghaire-Rathdown" , new Double(valoresBairros[0]) );  
      dataset.setValue( "Dublin City" , new Double(valoresBairros[1]) );   
      dataset.setValue( "Fingal" , new Double( valoresBairros[2] ) );    
      dataset.setValue( "South Dublin" , new Double( valoresBairros[3] ) );

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
      File pieChart3D = new File( "/home/lavinia/workspace/Chart-Generator/img/PieChart3D.jpeg" );                           
      ChartUtilities.saveChartAsJPEG( pieChart3D , chart , 560 , 367 );
   }
}
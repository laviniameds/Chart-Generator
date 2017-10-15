import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RectangleEdge;

import com.orsoncharts.label.StandardCategoryItemLabelGenerator;

public class BarChart extends ApplicationFrame {
	
	private static int min = 0;
	private static int max = 0;
   
   public BarChart(Arquivo f) throws IOException {
	      super( "Ofertas de quartos por Bairro" ); 
	      setContentPane(createDemoPanel(f));
	   }
  
   public static JPanel createDemoPanel(Arquivo f) throws IOException {
	      JFreeChart chart = createChart(createDataset(f) );  
	      return new ChartPanel( chart ); 
	   }
   
   private static JFreeChart createChart(CategoryDataset dataset){
	   
      JFreeChart barChart = ChartFactory.createBarChart(
    	         "Ofertas de quartos por Bairro",           
    	         "Nome do bairro",            
    	         "Quartos",            
    	         dataset,          
    	         PlotOrientation.VERTICAL,           
    	         true, true, false);  
    	              
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 1024 , 768 ) );
      
	return barChart;  
   }
   
   private static CategoryDataset createDataset(Arquivo f) {
	  int valoresBairros[] = f.ofertasBairro();
	  ArrayList<String> nomesBairros = f.nomesBairros();
                    
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
      
      for(int i = 0;i<valoresBairros.length;i++){
    	  dataset.addValue( valoresBairros[i] , nomesBairros.get(i) , "Quartos");
      }

      return dataset; 
   } 
   
   public void gerarGrafico(String path, Arquivo f) throws IOException {
	      File BarChart = new File(path + "/BarChart.jpeg"); 
	      ChartUtilities.saveChartAsJPEG( BarChart , createChart(createDataset(f)) , 1024 , 768 );           
   }
}
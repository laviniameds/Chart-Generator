import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		Arquivo arquivo = new Arquivo();
		
		int op = -1;
		while(op != 0){
			System.out.println("\n\n1 - Escolher dataset\n2 - Gerar Gráficos\n3 - Compartilhar no Facebook\n0 - Sair");
			op = sc.nextInt();
			switch (op) {
			case 1:
				
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Selecione arquivo csv dos bairros");
				chooser.setAcceptAllFileFilterUsed(false);
				
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					  arquivo.setCsvFileBairros(chooser.getSelectedFile().getAbsolutePath());
					  System.out.println("Arquivos dos bairros selecionado");
					} else {
					  System.out.println("Não foi selecionado nenhum arquivo!");
					}
				
				JFileChooser chooser2 = new JFileChooser();
				chooser2.setCurrentDirectory(new java.io.File("."));
				chooser2.setDialogTitle("Selecione o arquivo csv das ofertas por bairro");
				chooser2.setAcceptAllFileFilterUsed(false);
				
				if (chooser2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					  arquivo.setCsvFile(chooser2.getSelectedFile().getAbsolutePath());
					  System.out.println("Arquivos de ofertas por bairro selecionado");
					} else {
					  System.out.println("Não foi selecionado nenhum arquivo!");
					}

				break;
			
			case 2:
				String path  = "";
				
				JFileChooser chooser3 = new JFileChooser();
				chooser3.setCurrentDirectory(new java.io.File("."));
				chooser3.setDialogTitle("choosertitle");
				chooser3.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				if (chooser3.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  path = chooser3.getSelectedFile().getAbsolutePath();

				} else {
				  System.out.println("Nenhum diretorio selecionado!");
				}
				
				BarChart barChart = new BarChart(arquivo);
				barChart.gerarGrafico(path, arquivo);
				
				BarChart3D barChart3D = new BarChart3D();
				barChart3D.gerarGrafico(path, arquivo);
				
				PieChart pieChart = new PieChart(arquivo);
				pieChart.gerarGrafico(path, arquivo);
				
				PieChart3D pieChart3D = new PieChart3D();
				pieChart3D.gerarGrafico(path, arquivo);
				
				System.out.println("Gráficos gerados com sucesso!");
				
				break;
				
			case 3:
				
				break;
				
			case 0:				
				break;

			default:
				break;
			}
		}
	}

}

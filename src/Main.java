import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int op = -1;
		while(op != 0){
			System.out.println("\n\n1 - Escolher dataset\n2 - Gerar Gráficos\n3 - Compartilhar no Facebook\n0 - Sair");
			op = sc.nextInt();
			switch (op) {
			case 1:
				Arquivo arquivo = new Arquivo();
				
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
					  arquivo.setCsvFileBairros(chooser2.getSelectedFile().getAbsolutePath());
					  System.out.println("Arquivos de ofertas por bairro selecionado");
					} else {
					  System.out.println("Não foi selecionado nenhum arquivo!");
					}

				break;
			
			case 2:
				BarChart barChart = new BarChart();
				barChart.gerarGrafico();
				
				BarChart3D barChart3D = new BarChart3D();
				barChart3D.gerarGrafico();
				
				PieChart pieChart = new PieChart();
				pieChart.gerarGrafico();
				
				PieChart3D pieChart3D = new PieChart3D();
				pieChart3D.gerarGrafico();
				
				System.out.println("Gráficos em .jpeg gerados com sucesso! Veja na pasta 'img'");
				
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

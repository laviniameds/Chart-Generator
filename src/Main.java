import java.util.Scanner;

import javax.swing.JFileChooser;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) throws Exception {
		scanner = new Scanner(System.in);
		Scanner sc = scanner.useDelimiter("\\n");;
		
		Arquivo arquivo = new Arquivo();
		String path  = "";
		
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
					  Arquivo.setCsvFileBairros(chooser.getSelectedFile().getAbsolutePath());
					  System.out.println("Arquivos dos bairros selecionado");
					} else {
					  System.out.println("Não foi selecionado nenhum arquivo!");
					}
				
				JFileChooser chooser2 = new JFileChooser();
				chooser2.setCurrentDirectory(new java.io.File("."));
				chooser2.setDialogTitle("Selecione o arquivo csv das ofertas por bairro");
				chooser2.setAcceptAllFileFilterUsed(false);
				
				if (chooser2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					  Arquivo.setCsvFile(chooser2.getSelectedFile().getAbsolutePath());
					  System.out.println("Arquivos de ofertas por bairro selecionado");
					} else {
					  System.out.println("Não foi selecionado nenhum arquivo!");
					}

				break;
			
			case 2:
				
				JFileChooser chooser3 = new JFileChooser();
				chooser3.setCurrentDirectory(new java.io.File("."));
				chooser3.setDialogTitle("Selecione o destino das imagens");
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
				
				System.out.println("\nGráficos gerados com sucesso!");
				
				break;
				
			case 3:
				String nomegrafico = "";
				System.out.println("\nQual imagem deseja anexar?\n1 - BarChart\n2 - BarChart3D\n3 - PieChart\n4 - PieChart3D\n");
				switch(sc.nextInt()){
					case 1: nomegrafico = "/BarChart.jpeg";
						break;
					case 2: nomegrafico = "/BarChart3D.jpeg";
						break;
					case 3: nomegrafico = "/PieChart.jpeg";
						break;
					case 4: nomegrafico = "/PieChart3D.jpeg";
						break;
					default: nomegrafico = "/BarChart.jpeg";
						break;
				}
				System.out.println("\nEscreva seu post: ");
				String message = sc.next();
				System.out.println("\nInsira seu token de acesso ao facebook: ");
				String token = sc.next();
				System.out.println("\nInsira o ID do usuario que deseja marcar: ");
				String tagID = sc.next();
				System.out.println("\nInsira o nome do usuario que deseja marcar: ");
				String tagText = sc.next();
				PhotoTag photoTag = new PhotoTag(tagID, tagText);
				
				Social.postarNoFb(message, token, path, nomegrafico, photoTag);
				System.out.println("Postado no facebook com sucesso!");
				break;
				
			case 0:				
				break;

			default:
				break;
			}
		}
	}

}

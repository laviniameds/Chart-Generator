import java.io.IOException;
import java.util.Scanner;

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
				System.out.println("Digite o caminho do csv de bairros: ");
				arquivo.setCsvFileBairros(sc.next());
				System.out.println("Digite o caminho do csv de ofertas por bairro: ");
				arquivo.setCsvFile(sc.next());
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

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = -1;
		while(op != 0){
			System.out.println("1 - Escolher dataset\n2 - Gerar Gráficos\n3 - Compartilhar no Facebook\n0 - Sair\n");
			
			op = sc.nextInt();
		}
	}

}

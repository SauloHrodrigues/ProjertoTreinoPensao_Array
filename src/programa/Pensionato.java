package programa;

import java.util.Locale;
import java.util.Scanner;

public class Pensionato {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		int qtdQuartos = 10;
		int[] quartosPensao = new int[qtdQuartos+1];
		String[] nomes = new String[qtdQuartos+1];
		String[] emails = new String[qtdQuartos+1];
		int qtdeAlugados;
		System.out.printf("*********** Pensão da dona Maria ****** \n\n");
		do {
			System.out.print("Digite quantos serão alugado: (máximo "+qtdQuartos+" )");
			qtdeAlugados = input.nextInt();
		} while (qtdeAlugados < 1 || qtdeAlugados > qtdQuartos);
		
		
		
		for(int i=0;i<qtdeAlugados;i++){
			System.out.print("Qual numero do quarto: ");
			int aux = validaQuarto(input,quartosPensao,input.nextInt());
			quartosPensao[aux]=aux;
			System.out.println("Quarto : "+aux);
			System.out.println("Nome do hospede   "+(i+1)+"º: ");
			nomes[aux]= input.next();
			System.out.println("E-mail do hospede "+(i+1)+"º: ");
			emails[aux]= input.next();
			System.out.println();
		}
		
		System.out.println("*********** RELATÓRIO ***********");
		
		for(int i = 1; i < quartosPensao.length;i++) {
			if(quartosPensao[i]!=0) {
				System.out.println();
				System.out.println("Quarto:  "+quartosPensao[i]);
				System.out.println("Hospede: "+nomes[i]);
				System.out.println("Emails:  "+emails[i]);
				System.out.println("---------------------------------------");
			}
		}
		
	}
	
	public static int validaQuarto(Scanner input, int[] quartosPensao, int quarto) {
		int q =0;
		
		do {
			if(quarto >= quartosPensao.length) {
				System.out.print("Digite um quarto válido: ");
				quarto = input.nextInt();
			}else if(quartosPensao[quarto]!=0) {
				System.out.print("Quarto ocupado, digite novo quarto: ");
				quarto = input.nextInt();
			}else if(quartosPensao[quarto]==0  ) {
				q=quarto;
				break;
			} 
		}while(q==0);
		return q;	
	}
}
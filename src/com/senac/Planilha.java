package com.senac;

import java.util.Scanner;

import com.senac.algoritmos.AvaliadorRPN;

public class Planilha {
	public static void main(String[] args) throws Exception {
		String comando = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite uma express�o;" +
					       "\nINSTRU��ES:" +
					       "\nColoque espa�os para separar os d�gitos e operadores" +
						   "\nDigite \"fim\" para finalizar com programa.\n" +
						   "______________________________________________\n");
		
		while (sc.hasNext()) {
			comando = sc.nextLine();
			if (comando.equalsIgnoreCase("fim")){
				System.out.println("\n\nPROGRAMA FINALIZADO");
				System.exit(0);
			}
			else{
				AvaliadorRPN.InversorPosFixo(comando);
			}
		}
	}
}

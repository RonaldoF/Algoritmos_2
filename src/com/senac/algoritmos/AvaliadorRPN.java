package com.senac.algoritmos;

import java.util.Scanner;

import com.senac.estruturas.PilhaCheia;
import com.senac.estruturas.PilhaOperador;
import com.senac.estruturas.PilhaCalcula;
import com.senac.estruturas.PilhaVazia;

public class AvaliadorRPN {
	@SuppressWarnings("resource")
	public static double avalia(String expressao) throws PilhaCheia,PilhaVazia,InvalidOperator {
		PilhaCalcula p = new PilhaCalcula(50);

		Scanner sc = new Scanner(expressao);

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				p.push(sc.nextInt());
			} else {
				String op = sc.next();
				double rhs = p.pop();
				double lhs = p.pop();
				p.push(ExecOperador(op.charAt(0), lhs, rhs));
			}
		}

		return p.pop();
	}

	@SuppressWarnings("resource")
	public static void InversorPosFixo(String expressao) throws PilhaCheia,PilhaVazia, InvalidOperator {
		Scanner sc = new Scanner(expressao);

		PilhaOperador p = new PilhaOperador(50);
		String saida = "";

		while (sc.hasNext()){

			if (sc.hasNextInt()) {
				saida = saida+ " " + sc.next();//
			}

			else {
				String operador = sc.next();

				if (FechaParentes(operador)) {
					do {
						saida += " " + p.pop();

					} while (!AbreParenteses(p.peek()));
					p.pop();
				}

				else {
					if (p.isEmpty()) {

						p.push(operador);

					} else if (Prioridade(operador) > Prioridade(p.peek()))
						p.push(operador);

					else {
						while (!p.isEmpty()&& Prioridade(operador) < Prioridade(p.peek()) && !AbreParenteses(p.peek())) {
							if (AbreParenteses(p.peek()))
								p.pop();
							else
								saida += " " + p.pop();
						}
						p.push(operador);
					}
				}
			}
		}

		while (!p.isEmpty()) {
			if (AbreParenteses(p.peek()))
				p.pop();
			else
				saida += " " + p.pop();
		}

		System.out.println("Notação Polonesa: " + saida);
		System.out.println(AvaliadorRPN.avalia(saida));
	}

	public static boolean AbreParenteses(String string) {
		return string.equals("(");
	}

	public static boolean FechaParentes(String op) {
		return op.equals(")");
	}

	public static int Prioridade(String operadorLido) throws InvalidOperator {
		int precedencia = 0;
	
		switch (operadorLido.charAt(0)) {
		case '(':
			precedencia = 3;
			break;
		case '*':
			precedencia = 2;
			break;
		case '/':
			precedencia = 2;
			break;
		case '+':
			precedencia = 1;
			break;
		case '-':
			precedencia = 1;
			break;

		default:
			throw new InvalidOperator(operadorLido.charAt(0));
		}

		return precedencia;
	}

	private static double ExecOperador(char op, double lhs, double rhs)
			throws InvalidOperator {
		switch (op) {
		case '+':
			return lhs + rhs;
		case '-':
			return lhs - rhs;
		case '*':
			return lhs * rhs;
		case '/':
			return lhs / rhs;
		default:
			throw new InvalidOperator(op);
		}
	}
}
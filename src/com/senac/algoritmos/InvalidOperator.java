package com.senac.algoritmos;

public class InvalidOperator extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOperator(char op)
	{
		super(String.format("Operador invalido: %c",op));
	}
	
}

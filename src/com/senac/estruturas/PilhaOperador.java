package com.senac.estruturas;

public class PilhaOperador {

	private String[] dados;
	private int   topo;
	
	public PilhaOperador (int tam)
	{
		dados = new String[tam];
		topo = 0;
	}

	public String peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados[topo - 1]; 
	}

	public void push (String operadorLido) throws PilhaCheia
	{
		if (isFull())
			throw new PilhaCheia();
		
		dados[topo] = operadorLido;
		topo++;
	}
	
	public String pop () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		topo--;
		return dados[topo];
	}
	
	private boolean isFull() {
		return topo == dados.length;
	}

	public boolean isEmpty() {
		return topo == 0;
	}
}

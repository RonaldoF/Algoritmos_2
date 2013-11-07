package com.senac.estruturas;

@SuppressWarnings("serial")
public class PilhaVazia extends Exception {
	public PilhaVazia()
	{
		super("Tentativa de acesso a uma pilha vazia.");
	}
}

package com.senac.estruturas;

@SuppressWarnings("serial")
public class PilhaCheia extends Exception {
	public PilhaCheia()
	{
		super("Tentativa de inclus‹o em uma pilha cheia.");
	}
}

package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.*;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String nome) {
			return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}	
}

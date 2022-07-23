package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = false;
	
	public static Browsers BROWSER = Browsers.FIREFOX;
	
	//public static String NOME_CONTA_ALTERADA = "Conta do Teste alterada1" + System.nanoTime(); 
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
	
	public enum TipoExecucao{
		LOCAL,
		GRID
	}

}

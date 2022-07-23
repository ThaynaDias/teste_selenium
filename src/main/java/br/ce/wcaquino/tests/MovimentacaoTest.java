package br.ce.wcaquino.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menupage = new MenuPage();
	
	private MovimentacaoPage movimentacao = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menupage.acessarTelaMovimentacao();
		
		movimentacao.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movimentacao.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movimentacao.setDescricao("movimenta�ao de teste");
		movimentacao.setInteressado("thayna");
		movimentacao.setValor("700");
		movimentacao.setConta("Conta para movimentacoes");
		movimentacao.setStatusPago();
		movimentacao.Salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movimentacao.obterMensagemSucesso());
	}
	
	
	@Test
	public void test2_ValidacaoCamposObrigatorio() {
		menupage.acessarTelaMovimentacao();
		movimentacao.Salvar();
		
		List<String> erros = movimentacao.obterMensagemErro();
		//Assert.assertEquals("Data da Movimenta��o � obrigat�ria", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�ria"));
		Assert.assertTrue(erros.containsAll(Arrays.asList( // colecao de erros
				"Data da Movimenta��o � obrigat�rio","Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio","Interessado � obrigat�rio","Valor � obrigat�rio",
				"Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size()); //para amarrar mais, caso tenha outro erro q nao esta constando 
	}
	
	@Test
	public void Test3_InserirMovimentacaoFuturas() {
		menupage.acessarTelaMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		
		movimentacao.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movimentacao.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movimentacao.setDescricao("movimenta�ao de teste");
		movimentacao.setInteressado("thayna");
		movimentacao.setValor("700");
		movimentacao.setConta("Conta para movimentacoes");
		movimentacao.setStatusPago();
		movimentacao.Salvar();
		
		List<String> erros = movimentacao.obterMensagemErro();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size()); //para amarrar mais, caso tenha outro erro q nao esta constando 
	}
}

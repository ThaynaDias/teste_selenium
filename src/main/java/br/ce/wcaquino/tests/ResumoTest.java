package br.ce.wcaquino.tests;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	
	private MenuPage menupage = new MenuPage();
	private ResumoPage resumo = new ResumoPage();
	
	@Test
	public void test1_ExcluirMovimentacao() {
		menupage.acessarTelaResumo();
		
		resumo.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumo.obterMensagemSucesso());
	}
	
	
	@Test
	public void Test2_ResumoMensal() {
		menupage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resumo.selecionarAno("2021");
		resumo.buscar();
		
		List<WebElement> elementosEncontrados = 
		   DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
		
		/*try {
			DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
			Assert.fail();
		} catch(NoSuchElementException e){
			
		}*/
	}
}

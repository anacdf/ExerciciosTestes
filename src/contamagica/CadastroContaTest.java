package contamagica;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CadastroContaTest {

	@BeforeAll
	public static void SetUp() {
		CadastroContas cadastro = new CadastroContas();
		BigDecimal saldo = new BigDecimal(10);
		ContaMagica conta = new ContaMagica("Teste", saldo);
		cadastro.insereConta(conta);
	}
	
	@Test
	public void insereContaTest() {
		CadastroContas cadastro = new CadastroContas();
		BigDecimal saldo = new BigDecimal(10);
		ContaMagica conta1 = new ContaMagica("Teste1", saldo);
		cadastro.insereConta(conta1);
		assertEquals(conta1, cadastro.pesquisar("Teste1"));
	}
	
	@Test
	public void removeContaTest() {
		CadastroContas cadastro = new CadastroContas();
		BigDecimal saldo = new BigDecimal(10);
		ContaMagica conta1 = new ContaMagica("Teste1", saldo);
		cadastro.insereConta(conta1);
		cadastro.removeConta("Teste1");
		assertTrue(true);
	}
	
	@Test
	public void removeContaFalseTest() {
		CadastroContas cadastro = new CadastroContas();
		BigDecimal saldo = new BigDecimal(10);
		ContaMagica conta1 = new ContaMagica("Teste1", saldo);
		cadastro.insereConta(conta1);
		cadastro.removeConta("XYZ");
		assertFalse(false);
	}
	
	@Test
	public void pesquisarTest() {
		CadastroContas cadastro = new CadastroContas();
		BigDecimal saldo = new BigDecimal(10);
		ContaMagica conta2 = new ContaMagica("Teste2", saldo);
		cadastro.insereConta(conta2);
		ContaMagica pesquisa = cadastro.pesquisar("Teste2");

		assertEquals(conta2.toString(), pesquisa.toString());
	} 
	
	@Test
	public void pesquisarNullTest() {
	CadastroContas cadastro = new CadastroContas();
	BigDecimal saldo = new BigDecimal(10);
	ContaMagica conta1 = new ContaMagica("Teste1", saldo);
	cadastro.insereConta(conta1);
		cadastro.pesquisar("XYZ");
		assertNull(null);
	} 
}


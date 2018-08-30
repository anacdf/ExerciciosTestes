package contamagica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	@Test
	public void criarContaTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("10");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);

		assertTrue(true);
	}

	@Test
	public void contaExisteTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("10");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);
		assertTrue(banco.contaExiste("Fulano"));
	}

	@Test
	public void depositarTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("10");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);
		banco.depositar("Fulano", valor);
		BigDecimal valorTeste = new BigDecimal("20");

		assertEquals(valorTeste, banco.consultarSaldo("Fulano"));
	}

	@Test
	public void depositarExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			Banco banco = new Banco();
			BigDecimal valor = new BigDecimal("-1");
			ContaMagica conta = new ContaMagica("Fulano", valor);
			banco.criarConta(conta);
			banco.depositar("Fulano", valor);
		});
	}

	@Test
	public void statusSilverTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("10");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);

		assertEquals(Categorias.Silver, banco.status("Fulano"));
	}

	@Test
	public void statusGoldTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("50001");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);

		assertEquals(Categorias.Gold, banco.status("Fulano"));
	}

	@Test
	public void statusPlatinumTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("200001");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);

		assertEquals(Categorias.Platinum, banco.status("Fulano"));
	}

	@Test
	public void sacarTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("10");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);
		BigDecimal valorTeste = new BigDecimal("5");
		banco.sacar("Fulano", valorTeste);

		assertEquals(valorTeste, banco.consultarSaldo("Fulano"));
	}

	@Test
	public void sacarExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			Banco banco = new Banco();
			BigDecimal valor = new BigDecimal("10");
			ContaMagica conta = new ContaMagica("Fulano", valor);
			banco.criarConta(conta);
			BigDecimal valorTeste = new BigDecimal("20");
			banco.sacar("Fulano", valorTeste);
		});
	}

	@Test
	public void consultarSaldoTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("10");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);
		BigDecimal valorTeste = new BigDecimal("10");

		assertEquals(valorTeste, conta.getSaldo());
	}

	@Test
	public void encerrarContaTest() {
		Banco banco = new Banco();
		BigDecimal valor = new BigDecimal("10");
		ContaMagica conta = new ContaMagica("Fulano", valor);
		banco.criarConta(conta);
		banco.encerrarConta("Fulano");

		assertEquals(false, banco.contaExiste("Fulano"));
	}
}
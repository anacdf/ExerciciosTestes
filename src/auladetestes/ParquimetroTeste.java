package auladetestes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class ParquimetroTeste {
	private Parquimetro parq;

	@Before
	public void setUp() throws Exception {
		parq = new Parquimetro();
		parq.insereMoeda(100); //iniciara o teste com 100
	}

	@Test
	public void testInsereMoeda() {
		parq.insereMoeda(1);
		parq.insereMoeda(5);
		parq.insereMoeda(10);
		parq.insereMoeda(25);
		parq.insereMoeda(50);
		parq.insereMoeda(100);
		assertEquals(291, parq.getSaldo());
	}

	@Test
	public void testGetSaldo() {
		int actual = parq.getSaldo();
		assertEquals(100, actual);
	}

	@Test
	public void testEmiteTicket() {
		parq.insereMoeda(50);
		parq.insereMoeda(50);
		parq.insereMoeda(100);
		boolean actual = parq.emiteTicket();
		assertEquals(true, actual);
	}
	
	@Test
	public void testEmiteTicketFalse() {
		parq.insereMoeda(50);
		
		boolean actual = parq.emiteTicket();
		assertEquals(false, actual);
	}
	
	@Test
	public void testDivideEx() {
	assertThrows(IllegalArgumentException.class, () -> parq.insereMoeda(35));
	}

	@Test
	public void testDevolve() {
		parq.insereMoeda(50);
		parq.insereMoeda(50);
		parq.insereMoeda(100);
		parq.emiteTicket();
		int actual = parq.devolve();
		assertEquals(100, actual); //50+50+100 resultado esperado 100.
									//está dando erro aqui.
	}
}

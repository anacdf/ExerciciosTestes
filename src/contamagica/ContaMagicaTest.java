package contamagica;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ContaMagicaTest {
	
	@Test
	public void retirarTest(){
	ContaMagica target = new ContaMagica("Fulano", new BigDecimal(100));
	target.deposito(new BigDecimal(5000));
	target.retirada(new BigDecimal(1000));
	assertEquals(new BigDecimal(4100),target.getSaldo());
	}

	@Test
	public void depositarTest(){
	ContaMagica target = new ContaMagica("Fulano", new BigDecimal(100));
	target.deposito(new BigDecimal(100));
	target.deposito(new BigDecimal(100));
	assertEquals(new BigDecimal(300), target.getSaldo());
	}
	
}
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import contamagica.Categorias;
import contamagica.ContaMagica;

public class ContaMagicaTest {
	static Categorias categoria;
	
	@Test
	public void depositarTest(){
		BigDecimal valor = new BigDecimal(1);
		ContaMagica target = new ContaMagica("Fulano", valor);
		target.deposito(new BigDecimal("10"));
	assertEquals(new BigDecimal("11"), target.getSaldo());
	} 

	@Test
	public void retirarTest(){
		BigDecimal valor = new BigDecimal(1);
		ContaMagica target1 = new ContaMagica("Fulano", valor);
		target1.retirada(new BigDecimal("1"));
		
	assertEquals(new BigDecimal(0),target1.getSaldo());
	}
	
	@Test
	public void nomeClienteTest() {
		BigDecimal valor = new BigDecimal(1);
		ContaMagica target2 = new ContaMagica("Fulano", valor);
		String nome = target2.getNomeCliente();
		
		assertNotNull(nome);
		assertEquals("Fulano", nome);
	}
	
	@Test
	public void statusSilverTest() {
		BigDecimal valor = new BigDecimal(1);
		ContaMagica target3 = new ContaMagica("Fulano", valor);
		target3.deposito(new BigDecimal("10"));
		categoria = target3.getStatus();
		assertEquals(Categorias.Silver, categoria);
	}
	
	@Test
	public void statusGoldTest() {
		BigDecimal valor = new BigDecimal(1);
		ContaMagica target4 = new ContaMagica("Fulano", valor);
		target4.deposito(new BigDecimal("50001"));
		categoria = target4.getStatus();
		assertEquals(Categorias.Gold, categoria);
	}
	
	@Test
	public void statusPlatinumTest() {
		BigDecimal valor = new BigDecimal(1);
		ContaMagica target5 = new ContaMagica("Fulano", valor);
		target5.deposito(new BigDecimal("200001"));
		categoria = target5.getStatus();
		assertEquals(Categorias.Platinum, categoria);
	}
	
	@Test
	public void depositoGoldTest() {
		BigDecimal valor = new BigDecimal(1);
		ContaMagica target6 = new ContaMagica("Fulano", valor);
		BigDecimal deposito = new BigDecimal(50000);
		target6.deposito(deposito);
		
		valor = target6.getSaldo();
		
		BigDecimal goldPercent = new BigDecimal(0.01);
		BigDecimal acrescimo = deposito.multiply(goldPercent);
		BigDecimal esperado = deposito.add(acrescimo);
		 
		assertEquals(esperado, valor);
	}
	
	@Test
	public void depositoPlatinumTest() {
		BigDecimal valor = new BigDecimal(200000);
		ContaMagica target7 = new ContaMagica("Fulano", valor);
		BigDecimal deposito = new BigDecimal(1);
		target7.deposito(deposito);
		
		valor = target7.getSaldo();
		
		BigDecimal platinumPercent = new BigDecimal(0.025);
		BigDecimal acrescimo = deposito.multiply(platinumPercent);
		BigDecimal esperado = valor.add((deposito.add(acrescimo)));
		
		assertEquals(esperado, valor); 
	} 

}
package contamagica;

import java.math.BigDecimal;

public interface ContaMagicaInterface {
			
	public String getNomeCliente();
	
	public BigDecimal getSaldo();
	 
	public Categorias getStatus();
	 
	public void deposito(BigDecimal valor);
	 
	public void retirada(BigDecimal valor);
	 
	public String toString();
}

package contamagica;

public interface CadastroContasInterface {
	
	public void insereConta(ContaMagicaInterface conta);
	
	public boolean removeConta(String nome);
	
	public ContaMagicaInterface pesquisar(String nome);
	
	public int size();
}

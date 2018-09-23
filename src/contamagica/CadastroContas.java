package contamagica;

import java.util.ArrayList;

public class CadastroContas implements CadastroContasInterface{
	private ArrayList<ContaMagicaInterface> lista;
	
	public CadastroContas() {
		lista = new ArrayList<>();
	}
	
	public void insereConta(ContaMagicaInterface conta) {
		lista.add(conta);
	}
	
	public boolean removeConta(String nome) {
		for (int i=0; i<lista.size(); i++) {
			if (nome.equals(lista.get(i).getNomeCliente())) {
				lista.remove(lista.get(i));
				return true;
			}
		} return false;
	}
	
	public ContaMagicaInterface pesquisar(String nome) {
		ContaMagicaInterface x;
		for (int i=0; i<lista.size(); i++) {
			if (nome.equals(lista.get(i).getNomeCliente())) {
				return x=lista.get(i);
			}
		}return null;
	}

	public int size() {
		return lista.size();
	}
}

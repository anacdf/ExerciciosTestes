package contamagica;

import java.util.ArrayList;

public class CadastroContas {
	private ArrayList<ContaMagica> lista;
	
	public CadastroContas() {
		lista = new ArrayList<>();
	}
	
	public void insereConta(ContaMagica conta) {
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
	
	public ContaMagica pesquisar(String nome) {
		ContaMagica x;
		for (int i=0; i<lista.size(); i++) {
			if (nome.equals(lista.get(i).getNomeCliente())) {
				return x=lista.get(i);
			}
		}return null;
	}
}

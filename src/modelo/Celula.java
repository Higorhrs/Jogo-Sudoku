package modelo;

public class Celula {
	
	private int valor;
	private final boolean fixa;
	
	
	public Celula(int valor, boolean fixa) {
		this.valor = valor;
		this.fixa = fixa;
	}


	public int getValor() {
		return valor;
	}
	

	public boolean isFixa() {
		return fixa;
	}
	
	public boolean definirValor(int valor) {
		if(fixa) return false;
		this.valor = valor;
		return true;
		}
	
	public boolean limpar() {
		if(fixa) return false;
		this.valor = 0;
		return true;
	}
	
}

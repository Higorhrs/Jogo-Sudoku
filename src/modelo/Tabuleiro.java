package modelo;

public class Tabuleiro {
	private final Celula[][] grade = new Celula[9][9];
	private boolean iniciado = false;
	
	public void iniciar(int [][] iniciais) {
		for(int linha = 0; linha < 9; linha++) {
			for(int coluna = 0; coluna < 9; coluna++) {
				int valor = iniciais [linha][coluna];
				grade[linha][coluna] = new Celula(valor, valor != 0);
			
			}
		}
		
		iniciado = true;
	}
	public boolean iniciado() {
		return iniciado;
	}
	public boolean colocarNumero(int linha, int coluna, int valor) {
		if(!estaNoIntervalo(linha) || !estaNoIntervalo(coluna))
			return false;
			Celula celula = grade [linha][coluna];
		if(celula.isFixa())
			return false;
		if(!movimentoValido(linha, coluna, valor)) 
			return false;
		return celula.definirValor(valor);
	}
	public boolean removerNumero(int linha, int coluna) {
        if (!estaNoIntervalo(linha) || !estaNoIntervalo(coluna)) 
        	return false;
        return grade[linha][coluna].limpar();
    }
	public void imprimirTabuleiro() {
        System.out.println("\n   1 2 3   4 5 6   7 8 9");
        System.out.println(" +-------+-------+-------+");
        for (int linha = 0; linha < 9; linha++) {
            System.out.print((linha + 1) + "| ");
            for (int coluna = 0; coluna < 9; coluna++) {
                int v = grade[linha][coluna].getValor();
                char ch = (v == 0) ? '.' : (char)('0' + v);
                System.out.print(ch + " ");
                if ((coluna + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
            if ((linha + 1) % 3 == 0) System.out.println(" +-------+-------+-------+");
        }
    }
	
	private boolean estaNoIntervalo(int i) { return i >= 0 && i < 9; }

    private boolean movimentoValido(int linha, int coluna, int valor) {
        
        for (int c = 0; c < 9; c++)
            if (grade[linha][c].getValor() == valor) 
            	return false;
        
        for (int l = 0; l < 9; l++)
            if (grade[l][coluna].getValor() == valor) 
            	return false;
        
        int l0 = (linha / 3) * 3;
        int c0 = (coluna / 3) * 3;
        for (int l = l0; l < l0 + 3; l++)
            for (int c = c0; c < c0 + 3; c++)
                if (grade[l][c].getValor() == valor) 
                	return false;
        return true;
    }

    public boolean completo() {
        for (int linha = 0; linha < 9; linha++)
            for (int coluna = 0; coluna < 9; coluna++)
                if (grade[linha][coluna].getValor() == 0)
                	return false;
        return true;
    }

    public boolean possuiErros() {
        for (int linha = 0; linha < 9; linha++) {
            for (int coluna = 0; coluna < 9; coluna++) {
                int v = grade[linha][coluna].getValor();
                if (v != 0) {
                    grade[linha][coluna].limpar();
                    if (!movimentoValido(linha, coluna, v)) {
                        grade[linha][coluna].definirValor(v);
                        return true;
                    }
                    grade[linha][coluna].definirValor(v);
                }
            }
        }
        return false;
    }

    public void limparNumerosUsuario() {
        for (int linha = 0; linha < 9; linha++)
            for (int coluna = 0; coluna < 9; coluna++)
                if (!grade[linha][coluna].isFixa()) grade[linha][coluna].limpar();
    }
}

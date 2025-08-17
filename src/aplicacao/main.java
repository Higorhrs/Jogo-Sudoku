package aplicacao;

import jogo.JogoSudoku;
import modelo.Tabuleiro;

public class main {

	public static void main(String[] args) {
		
		int [][] iniciais = new int[9][9];
		
		for (int i = 0; i + 2 < args.length; i += 3) {
            int linha = Integer.parseInt(args[i]) - 1;
            int coluna = Integer.parseInt(args[i+1]) - 1;
            int valor = Integer.parseInt(args[i+2]);
            if (linha >= 0 && linha < 9 && coluna >= 0 && coluna < 9 && valor >= 1 && valor <= 9) {
                iniciais[linha][coluna] = valor;
            }
		}
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(iniciais);
		
		JogoSudoku jogo = new JogoSudoku(tabuleiro, null);
		jogo.menu();

	}

}

package jogo;

import java.util.Scanner;
import modelo.Tabuleiro;


public class JogoSudoku {
	
	private final Tabuleiro tabuleiro;
	private final Scanner sc;
	
	public JogoSudoku(Tabuleiro tabuleiro, Scanner sc) {
		this.tabuleiro = tabuleiro;
		this.sc = new Scanner(System.in);
	}
	public void menu() {
		int opcao;
		
		do {
			System.out.println("----------MENU---------");
			System.out.println("1. Iniciar novo jogo");
			System.out.println("2. Adcionar novo número");
			System.out.println("3. Remover um número");
			System.out.println("4. verificar o jogo");
			System.out.println("5. Status do jogo");
			System.out.println("6. Limpar");
			System.out.println("7. Finalizar jogo");
			System.out.println("0. Sair");
			System.out.print("Escolha");
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1 -> iniciarJogo();
            case 2 -> colocarNumero();
            case 3 -> removerNumero();
            case 4 -> tabuleiro.imprimirTabuleiro();
            case 5 -> verificarStatus();
            case 6 -> tabuleiro.limparNumerosUsuario();
            case 7 -> finalizarJogo();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida.");
			
			}
		}while(opcao != 0);
	}
	private void iniciarJogo() {
		System.out.println("Jogo iniciado");
		tabuleiro.imprimirTabuleiro();
	}
	private void colocarNumero() {
        System.out.print("Digite linha (1-9): ");
        int linha = sc.nextInt() - 1;
        System.out.print("Digite coluna (1-9): ");
        int coluna = sc.nextInt() - 1;
        System.out.print("Digite valor (1-9): ");
        int valor = sc.nextInt();
        if (!tabuleiro.colocarNumero(linha, coluna, valor)) {
            System.out.println("Não foi possível colocar o número (célula travada ou jogada inválida).");
        } else {
            System.out.println("Número colocado com sucesso!");
        }
	}
	private void removerNumero() {
        System.out.print("Digite linha (1-9): ");
        int linha = sc.nextInt() - 1;
        System.out.print("Digite coluna (1-9): ");
        int coluna = sc.nextInt() - 1;
        if (!tabuleiro.removerNumero(linha, coluna)) {
            System.out.println("Não é possível remover número fixo!");
        } else {
            System.out.println("Número removido.");
        }
    }

    private void verificarStatus() {
        if (!tabuleiro.iniciado()) {
            System.out.println("Status: Não iniciado. Sem erros.");
        } else if (tabuleiro.completo()) {
            if (tabuleiro.possuiErros()) System.out.println("Status: Completo, mas com erros!");
            else System.out.println("Status: Completo, sem erros!");
        } else {
            if (tabuleiro.possuiErros()) System.out.println("Status: Incompleto, com erros!");
            else System.out.println("Status: Incompleto, sem erros!");
        }
    }

    private void finalizarJogo() {
        if (!tabuleiro.completo()) {
            System.out.println("O jogo não está completo! Preencha todos os espaços.");
        } else if (tabuleiro.possuiErros()) {
            System.out.println("O jogo está completo, mas contém erros!");
        } else {
            System.out.println("Parabéns! Você completou o Sudoku corretamente!");
            System.exit(0);
        }
    }
}

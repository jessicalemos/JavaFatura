
/**
 * Escreva a descrição da classe Menu aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu{
    private List<String> opcoes;
    private int op;
    
    /**
     * Construtor para os objetos desta classe
     */
    public Menu(String[] opcoes) {
        this.opcoes = new ArrayList<String>();
        for(String op: opcoes)
            this.opcoes.add(op);
        this.op = 0;
    }
    
    /**
     * Ler uma opção do menu
     */
    private int lerOpcao() {
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("Opção: ");
        try {
            op = is.nextInt();
        }
        catch (InputMismatchException e) { // Não foi inscrito um int
            op = -1;
        }
        if (op<0 || op>this.opcoes.size()) {
            System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }
    
    /**
     * Aprensenta o menu a principal da aplicação e le uma opção
     */
    public void executaHomeMenu() {
        do {
            showMenu();
            this.op = lerOpcao();
        } while (this.op == -1);
    }
    
    /**
     * Aprensenta o menu da natureza e le uma opção
     */
    public void executaHomeMenu2() {
        do {
            showMenu2();
            this.op = lerOpcao();
        } while (this.op == -1);
    }

    /**
     * Mostra o menu da principal da aplicação
     */
    private void showMenu() {
          System.out.println("\n****** JavaFatura ******");
          for (int i=0; i<this.opcoes.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.opcoes.get(i));
          }
          if(!opcoes.get(this.opcoes.size()-1).equals("Logout"))
            System.out.println("0 - Sair");
    }
    
    /**
     * Mostra o menu da natureza
     */
    private void showMenu2() {
          System.out.println("Natureza:");
          for (int i=0; i<this.opcoes.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.opcoes.get(i));
          }
    }
    
    /**
     * Devolve a opção selecionada
     * @return opção
     */
    public int getOp() {
        return this.op;
    }
}

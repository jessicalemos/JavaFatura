
/**
 * Escreva a descrição da classe Saúde aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Saúde extends Fatura implements Serializable{
    private static double taxa = 0.15;
    private static int limite = 1000;
    
    /** Construtores */

    /**
     * Construtor vazio da fatura cuja natureza é de saúde
     */
     public Saúde() {
        super();
    }
    
     /**
     * Constrói a partir dos parametros fornecidos um fatura cuja natureza é de saúde
     * @param correção          Correção da fatura
     * @param id                Id da fatura
     * @param nifEmitente       Número fiscal do emitente
     * @param desig             Designação do emitente
     * @param dataDespesa       Data da despesa
     * @param nifCliente        Número fiscal do cliente
     * @param descricao         Descrição da despesa
     * @param valor             Valor da despesa
     */
     public Saúde(int correção, String id, String nifEmitente, String desig, LocalDate dataDespesa, String nifCliente, String descricao, double valor){
        super(correção,id,nifEmitente,desig,dataDespesa,nifCliente,descricao,"Saúde",valor);
    }
    
    /**
     * Constroi uma fatura cuja natureza é de saúde a partir de uma definida
     * @param s
     */
     public Saúde(Saúde s){
        super(s);
    }
    
    /** Metodos de Intância */
    
    /**
     * Retorna a taxa da fatura de saúde
     * @return taxa
     */
    public static double getTaxa(){
        return taxa;
    }

    /**
     * Retorna o limite de dedução de faturas de saúde
     * @return limite
     */
    public static double getLimite(){
        return limite;
    }
    
    /**
     * Imprime a informação de uma fatura cuja natureza é de saúde
     * @return String com a informação
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("A taxa de deduçao é ");
        sb.append(taxa);
        sb.append(" sendo o seu limite máximo ");
        sb.append(limite);
        sb.append(" euros.\n");
        return super.toString() + sb.toString();
    }
 
    /**
     * Faz a cópia de uma fatura cuja natureza é de saúde
     * @return Cópia da fatura
     */    
    public Saúde clone(){
        return new Saúde(this);
    }
    
    /**
     * Compara duas faturas de saúde
     * @param o       Fatura de saúde
     * @return É uma fatura igual (true) ou não é (false)
     */
      public boolean equals (Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Saúde c = (Saúde) o;
        return  super.equals(c);
    }
}

/**
 * Escreva a descrição da classe Habitação aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
import java.io.*;
import java.time.LocalDate;
public class Habitação extends Fatura implements Serializable{
    private static double taxa = 0.15;
    private static int limite = 300;
    
    /** Construtores */

    /**
     * Construtor vazio da fatura cuja natureza é de habitação 
     */
    public Habitação() {
        super();
    }
    
    /**
     * Constrói a partir dos parametros fornecidos um fatura cuja natureza é de habitação
     * @param correção          Correção da fatura
     * @param id                Id da fatura
     * @param nifEmitente       Número fiscal do emitente
     * @param desig             Designação do emitente
     * @param dataDespesa       Data da despesa
     * @param nifCliente        Número fiscal do cliente
     * @param descricao         Descrição da despesa
     * @param valor             Valor da despesa
     */
    public Habitação(int correção, String id, String nifEmitente, String desig, LocalDate dataDespesa, String nifCliente, String descricao, double valor){
        super(correção,id, nifEmitente,desig,dataDespesa,nifCliente,descricao,"Habitaçao",valor);
    }
    
    /**
     * Constroi uma fatura cuja natureza é de habitação a partir de uma definida
     * @param s
     */
    public Habitação(Habitação s){
        super(s);
    }
    
    /** Metodos de Intância */
    
    /**
     * Retorna a taxa da fatura de habitação
     * @return taxa
     */
    public static double getTaxa(){
        return taxa;
    }

    /**
     * Retorna o limite de dedução de faturas de habitação
     * @return limite
     */
    public static double getLimite(){
        return limite;
    }
    
    /**
     * Imprime a informação de uma fatura cuja natureza é de habitação
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
     * Faz a cópia de uma fatura cuja natureza é de habitação
     * @return Cópia da fatura
     */
    public Habitação clone(){
        return new Habitação(this);
    }
    
    /**
     * Compara duas faturas de habitação
     * @param o       Fatura de habitação
     * @return É uma fatura igual (true) ou não é (false)
     */
    public boolean equals (Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Habitação c = (Habitação) o;
        return  super.equals(c);
    }
}
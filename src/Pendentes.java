
/**
 * Write a description of class Pendentes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import java.time.LocalDate;
public class Pendentes extends Fatura implements Serializable {
    
    /** Construtores */

    /**
     * Construtor vazio da fatura cuja natureza é pendente
     */
    public Pendentes() {
        super();
    }
    
    /**
     * Constrói a partir dos parametros fornecidos um fatura cuja natureza é pendente
     * @param correção          Correção da fatura
     * @param id                Id da fatura
     * @param nifEmitente       Número fiscal do emitente
     * @param desig             Designação do emitente
     * @param dataDespesa       Data da despesa
     * @param nifCliente        Número fiscal do cliente
     * @param descricao         Descrição da despesa
     * @param valor             Valor da despesa
     */
    public Pendentes(int correção, String id, String nifEmitente, String desig, LocalDate dataDespesa, String nifCliente, String descricao, double valor){
        super(correção,id,nifEmitente,desig,dataDespesa,nifCliente,descricao,"",valor);
    }
    
    /**
     * Constroi uma fatura cuja natureza é pendente a partir de uma definida
     * @param s
     */
    public Pendentes(Pendentes p){
        super(p);
    }
    
    /**
     * Faz a cópia de uma fatura cuja natureza pendente
     * @return Cópia da fatura
     */
    public Pendentes clone(){
        return new Pendentes(this);
    }
    
}

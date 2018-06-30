
/**
 * Escreva a descrição da classe Fatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;
public abstract class Fatura implements Serializable{
    private int correção;
    private String idFatura;
    private String nifEmitente; // número fiscal do emitente
    private String desig; // designação do emitente
    private LocalDate dataDespesa; // data da despesa
    private String nifCliente; // número fiscal do cliente
    private String descricao; //descrição da despesa
    private String natureza; //natureza da despesa
    private double valor; //valor da despesa

    /** Construtores */

    /**
     * Constroi uma fatura sem parametros
     */
    public Fatura(){
        this.correção = 0;
        this.idFatura = "";
        this.nifEmitente = "";
        this.desig = "";
        this.dataDespesa = LocalDate.now();
        this.nifCliente = "";
        this.descricao = "";
        this.natureza = "";
        this.valor = 0;
    }
   
    /**
     * Constrói uma nova fatura a partir dos parametros fornecidos
     * @param nifEmitente       Número fiscal do emitente
     * @param desig             Designação do emitente
     * @param dataDespesa       Data da despesa
     * @param nifCliente        Número fiscal do cliente
     * @param descricao         Descrição da despesa
     * @param natureza          Natureza da despesa
     * @param valor             Valor da despesa
     */
    public Fatura(int correção, String idFatura, String nifEmitente, String desig, LocalDate dataDespesa, String nifCliente, String descricao, String natureza, double valor){
        this.correção = 0;
        this.idFatura = idFatura;
        this.nifEmitente = nifEmitente;
        this.desig = desig;
        this.dataDespesa = dataDespesa;
        this.nifCliente = nifCliente;
        this.descricao = descricao;
        this.natureza = natureza;
        this.valor = valor;
    }

    /**
     * Constroi uma fatura a partir de um definido
     * @param c
     */
    public Fatura(Fatura c){
        this.correção = c.getCorreção();
        this.idFatura = c.getIdFatura();
        this.nifEmitente = c.getNifEmitente();
        this.desig = c.getDesig();
        this.dataDespesa = c.getDataDespesa();
        this.nifCliente = c.getNifCliente();
        this.descricao = c.getDescricao();
        this.natureza = c.getNatureza();
        this.valor = c.getValor();
    }

    /** Metodos de Intância */
    
    /**
     * Retorna o id da fatura
     * @return id
     */
    public String getIdFatura() {
        return this.idFatura;
    }
    
    /**
     * Retorna se a fatura teve correção
     * @return booleano
     */
    public int getCorreção() {
        return this.correção;
    }
    
    /**
     * Retorna o número de identificação fiscal do emitente
     * @return nif
     */
    public String getNifEmitente() {
        return this.nifEmitente;
    }

    /**
     * Retorna a designação do emitente
     * @return designacao 
     */
    public String getDesig() {
        return this.desig;
    }

    /**
     * Retorna a data da despesa
     * @return data
     */
    public LocalDate getDataDespesa() {
        return this.dataDespesa;
    }

    /**
     * Retorna o número de identificação fiscal do cliente
     * @return nif
     */
    public String getNifCliente() {
        return this.nifCliente;
    }

    /**
     * Retorna a descrição da despesa
     * @return descrição
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Retorna a natureza da despesa
     * @return natureza
     */
    public String getNatureza() {
        return this.natureza;
    }

    /**
     * Retorna o valor da despesa
     * @return valor 
     */
    public double getValor() {
        return this.valor;
    }

    /**
     * Altera o id da fatura
     * @param id da nova fatura
     */
    public void setIdFatura(String idFatura) {
        this.idFatura = idFatura;
    }
    
    /**
     * Altera o valor da correção da fatura
     * @param correção         A nova correçao da fatura
     */
    public void setCorreção(int correção) {
        this.correção = correção;
    }
    
    /**
     * Altera o número fical do emitente
     * @param nifEmitente      Novo nif do emitente
     */
    public void setNifEmitente(String nifEmitente) {
        this.nifEmitente = nifEmitente;
    }

    /**
     * Altera a designação do emitente
     * @param desig         Nova designação do emitente
     */
    public void setDesig(String desig) {
        this.desig = desig;
    }

    /**
     * Altera a data da despesa
     * @param dataDespesa     Nova data da despesa
     */
    public void setDataDespesa(LocalDate dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    /**
     * Altera o número fiscal do cliente
     * @param nifCliente      Novo nif do cliente
     */
    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    /**
     * Altera a descrição da despesa
     * @param descricao       Nova descrição da despesa
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Altera a natureza da despesa
     * @param natureza      Nova natureza da despesa
     */
    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    /**
     * Altera o valor da despesa
     * @param valor        Novo valor da despesa
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Imprime a informação de uma fatura
     * @return String com a informação
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O identificador desta fatura é ");
        sb.append(this.idFatura);
        sb.append(" que tem como designação ");
        sb.append(this.desig);
        sb.append(" e descricao ");
        sb.append(this.descricao);
        sb.append(". A despesas de valor ");
        sb.append(this.valor);
        sb.append(" euros foi efetuada em ");
        sb.append(this.dataDespesa);
        if(!this.natureza.equals("")){
            sb.append(" e corresponde à natureza ");
            sb.append(this.natureza);
        }
        else sb.append(" e encontra-se em estado pendente");
        sb.append(". O nif do emitente é ");
        sb.append(this.nifEmitente);
        sb.append(" e o do cliente: ");
        sb.append(this.nifCliente);
        sb.append(".\n");
        return sb.toString();
    }

    /**
     * Faz a cópia de uma fatura
     * @return Cópia da fatura
     */
    public abstract Fatura clone();

    /**
     * Compara duas faturas
     * @param o       Fatura
     * @return É uma fatura igual (true) ou não é (false)
     */
    public boolean equals (Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Fatura c = (Fatura) o;
        return c.getNifEmitente().equals(this.nifEmitente) && c.getDesig().equals(this.desig) &&
               c.getDataDespesa().equals(this.dataDespesa) && c.getDescricao().equals(this.descricao)
                && c.getNifCliente().equals(this.nifCliente) && c.getNatureza().equals(this.natureza)
                && this.valor == c.getValor() && c.getIdFatura().equals(this.idFatura) && this.correção == c.getCorreção();
    }
}
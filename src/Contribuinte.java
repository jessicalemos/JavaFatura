/**
 * Escreva a descrição da classe Contribuinte aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.util.*;
import java.io.Serializable;
import static java.util.stream.Collectors.toMap;
import java.time.LocalDate;
public abstract class Contribuinte implements Serializable{
    private String nif;       // Número de identficação fiscal
    private String email;     // Email do contribuinte
    private String nome;      // Nome do contribuinte
    private String morada;    // Morada do contribuinte
    private String password;  // Password do contribuinte
    private Map<String,Fatura> faturas; //Faturas do contribuinte
    private Map<String,Fatura> pendentes;
    private double despesa;   // Despesa do contribuinte
   
    /**
     * Construtor para objetos da classe Contribuinte
     */
    public Contribuinte(){
        // inicializa variáveis de instância
        this.nif = "";
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.password = "";
        this.faturas = new HashMap<String,Fatura>(); 
        this.pendentes = new HashMap<String,Fatura>();
        this.despesa = 0;
    }
    

    /**
     * Constrói um novo contribuinte a partir dos parametros fornecidos
     * @param f             HashMap com faturas
     * @param nif           Número de identificação fiscal
     * @param email         Email do contribuinte
     * @param nome          Nome do contribuinte
     * @param morada        Morada do contribuinte
     * @param despesa       Despesa do contribuinte
     */
    public Contribuinte(HashMap<String,Fatura> f, HashMap<String,Fatura> p, String nif, String email, String nome, String morada, String password, double despesa) {
        this.nif = nif;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.password = password;
        this.faturas = new HashMap<String,Fatura>(); 
        if(f!=null) setFatura(f);
        this.pendentes = new HashMap<String,Fatura>(); 
        if(p!=null) setPendentes(p);
        this.despesa = despesa;
    }
    
    /**
     * Constrói um contribuinte a partir de um definido
     * @param c
     */
    public  Contribuinte (Contribuinte c){
        this.nif = c.getNif();
        this.email = c.getEmail();
        this.nome = c.getNome();
        this.morada = c.getMorada();
        this.password = c.getPassword();
        this.faturas = c.getFatura();
        this.pendentes = c.getPendentes();
        this.despesa = c.getDespesa();
    }
    
     /** Métodos de Instância */
     
    /**
     * Retorna as faturas emitidas em nome do contribuinte
     * @return faturas      Faturas emitidas em nome do contribuinte
     */
    public Map<String,Fatura> getFatura(){
         return this.faturas.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    /**
     * Retorna as faturas pendentes, ou seja, sem atividade económica do contribuinte
     * @return faturas pendentes       Faturas sem atividade económica do contribuinte
     */
     public Map<String,Fatura> getPendentes(){
         return this.pendentes.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    /**
     * Retorna o número de identificação fiscal do contribuinte
     * @return NIF 
     */
    public String getNif() {
        return this.nif;
    } 
    
    /**
     * Retorna o nome do contribuinte
     * @return nome  
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna o email do contribuinte
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Retorna a morada do contribuinte
     * @return morada
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * Retorna a password do contribuinte
     * @return password
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Retorna a despesa até ao momento do contribuinte
     * @return despesa    
     */
    public double getDespesa() {
        return this.despesa;
    }
    
    /** 
     * Altera as faturas emitidas em nome do contribuinte
     * @param novas faturas emitidas
     */
    public void setFatura(Map<String,Fatura> faturas){
         this.faturas = faturas.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    /** 
     * Altera as faturas pendentes emitidas em nome do contribuinte
     * @param novas faturas pendentes
     */
    public void setPendentes(Map<String,Fatura> pendentes){
         this.pendentes = pendentes.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    /**
     * Altera o número de identificação fiscal do contribuinte
     * @param novo Nif do contribuinte
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Altera o email do contribuinte
     * @param novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Altera o nome do contribuinte
     * @param novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera a morada do contribuinte
     * @param nova morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Altera a password do contribuinte
     * @param nova password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Altera a despesa atual do contibuinte
     * @param nova despesa
     */
    public void setDespesa(double despesa) {
        this.despesa = despesa;
    } 

    /**
     * Imprime a informação de um contribuinte
     * @return String com a informação
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O contribuinte ");
        sb.append(this.nome);
        sb.append(" tem como nif ");
        sb.append(this.nif);
        sb.append(" e password ");
        sb.append(this.password);
        sb.append(". A morada é ");
        sb.append(this.morada);
        sb.append(" e o seu email ");
        sb.append(this.email);
        sb.append(". A despesa efetuada até ao momento corresponde a ");
        sb.append(this.despesa);
        sb.append(" euros.\n");

        return sb.toString();
    }

    /**
     * Faz a cópia de um contribuinte
     * @return Cópia do contribuinte
     */
    public abstract Contribuinte clone();

    /**
     * Compara dois contribuintes
     * @param o contribuinte
     * @return É um contribuinte igual (true) ou não é (false)
     */
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Contribuinte c = (Contribuinte) o;
        return c.getEmail().equals(this.email) && c.getMorada().equals(this.morada) && c.getNif().equals(this.nif) &&
                c.getNome().equals(this.nome) && c.getPassword().equals(this.password);
    }
     
    /**
     * Adiciona uma fatura às faturas emitidas em nome do contribuinte
     * @param f       Fatura a inserir nas faturas do contribuinte
     */
    public void addFatura(Fatura f){
        this.faturas.put(f.getIdFatura(),f);
    }  
    
    /**
     * Remove uma fatura às faturas emitidas em nome do contribuinte
     * @param f       Fatura a remover das faturas do contribuinte
     */
    public void removeFaturas(Fatura f){
        this.faturas.remove(f.getIdFatura());
    }
    
     /**
     * Adiciona uma fatura pendente às faturas pendentes emitidas em nome do contribuinte
     * @param f        Fatura a inserir nas faturas do contribuinte
     */
    public void addPendentes(Fatura f){
        this.pendentes.put(f.getIdFatura(),f);
    }  
    
    /**
     * Remove uma fatura pendente  faturas pendentes emitidas em nome do contribuinte
     * @param f       tura a remover das faturas do contribuinte
     */
    public void removePendentes(Fatura f){
        this.pendentes.remove(f.getIdFatura());
    }
    
    /**
     * Aumenta a despesa até ao momento do contribuinte
     * @param d      Despesa efetuada pelo contribuinte
     */
    public void despesaAtual(double d){
        this.despesa += d;
    }
}

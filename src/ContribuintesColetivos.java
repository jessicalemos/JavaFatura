
/**
 * Escreva a descrição da classe ContribuintesColetivos aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
import java.io.Serializable;
import static java.util.stream.Collectors.toMap;
import java.time.LocalDate;
public class ContribuintesColetivos extends Contribuinte implements Serializable{
    private List<String> atividadeEcon; //Atividades em que a empresa atua
    private double fator; //Fator que a empresa tem no calculo de dedução fiscal
    private Map<String,Fatura> emitidas; //Faturas emitidas
    private double faturado; //Valor faturado
    private String concelho; //Concelho do contribuinte
    
    /** Construtores */
    
    /**
     * Constroi uma informação dos contribuintes coletivos sem parâmetros
     */
    public ContribuintesColetivos (){
        super();
        this.atividadeEcon = new ArrayList<String>();
        this.fator = 0;
        this.emitidas = new HashMap<String,Fatura>(); 
        this.faturado = 0;
        this.concelho = "";
    }
    
    /**
     * Constrói uma nova informação dos contribuintes coletivos a partir dos parâmetros fornecidos
     * @param f                  Faturas
     * @param emitidas           Faturas emitidas
     * @param nif                Nif do contribuinte
     * @param email              Email do contribunte
     * @param nome               Nome do contribunte
     * @param morada             Morada do contribunte
     * @param password           Password do contribunte
     * @param atividadeEcon      Atividade económica do contribunte
     * @param fator              Fator de dedução do contribuinte
     * @param despesa            Despesa do contribuinte
     * @param faturado           Valor faturado pelo contribuinte
     */
    public ContribuintesColetivos(HashMap<String,Fatura> f, HashMap<String,Fatura> p, HashMap<String,Fatura> emitidas, String nif, String email, String nome, 
    String morada, String password,ArrayList<String> atividadeEcon, double fator, double faturado, double despesa, String concelho) {
        super(f, p, nif, email, nome, morada, password,despesa);
        this.atividadeEcon = new ArrayList<String>();
        if (atividadeEcon!=null) setAtividadeEcon(atividadeEcon);
        this.fator = fator;
        this.emitidas = new HashMap<String,Fatura>(); 
        if (emitidas!=null) setEmitidas(emitidas);
        this.faturado = faturado;
        this.concelho = concelho;
    }

    /**
     * Constrói informação a partir da informação de uma empresa
     * @param c
     */
    public ContribuintesColetivos (ContribuintesColetivos c){
        super(c);
        this.atividadeEcon = c.getAtividadeEcon();
        this.fator = c.getFator();
        this.emitidas = c.getEmitidas();
        this.faturado = c.getFaturado();
        this.concelho = c.getConcelho();
    }

    /** Metodos de Intância */
    
    /**
     * Retorna as faturas emitidas
     * @return faturas emitidas
     */
    public Map<String,Fatura> getEmitidas(){
         return this.emitidas.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    /**
     * Retorna a/as atividades económicas nas quais atua a empresa
     * @return atividade económica
     */
    public List<String> getAtividadeEcon() {
         ArrayList<String> a = new ArrayList<String>();
         for (String i : this.atividadeEcon)
                a.add(i);
         return a;
    }

    /**
     * Retorna o valor da dedução fiscal
     * @return fator que a empresa tem no cálculo de dedução fiscal
     */
    public double getFator() {
        return this.fator;
    }
    
    /**
     * Retorna o valor faturado pelo contribuinte
     * @return valor faturado
     */
    public double getFaturado() {
        return this.faturado;
    }
    
    /**
     * Retorna o concelho do contribuinte
     * @return concelho
     */
    public String getConcelho() {
        return this.concelho;
    }

    /**
     * Altera as faturas emitidas pelo contribuinte
     * @param faturas emitidas
     */
    public void setEmitidas(Map<String,Fatura> emitidas){
         this.emitidas = emitidas.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    /**
     * Altera as atividades em que a empresa atua
     * @param atividadeEcon
     */
    public void setAtividadeEcon(ArrayList<String> c){   
       for (String l : c){
           this.atividadeEcon.add(l);
       }
   }

    /**
     * Altera o valor da dedução fiscal
     * @param fator que a empresa tem no cálculo de dedução fiscal
     */
    public void setFator(double fator) {
        this.fator = fator;
    }
    
    /**
     * Altera o valor faturado
     * @param valor faturado
     */ 
    public void setFaturado(double faturado) {
        this.faturado = faturado;
    }
    
    /**
     * Altera o concelho do contribuinte
     * @param concelho
     */ 
    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    /**
     * Imprime a informação do contribuinte coletivo
     * @return String com a informação
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("A empresa tem como atividades económicas: ");
        if(atividadeEcon.size()!=0){
            for(String i : atividadeEcon){
                sb.append(i);
                sb.append("; ");
            }
        }
        sb.append(" cujo fator no cálculo de dedução fical correponde a ");
        sb.append(this.fator);
        sb.append(". O valor faturado até ao momento é ");
        sb.append(this.faturado);
        sb.append(" euros.\n ");
        return super.toString() + sb.toString();
    }

    /**
     * Faz a cópia da informação do contribuinte coletivo
     * @return Cópia da informação
     */
    public ContribuintesColetivos clone(){
        return new ContribuintesColetivos(this);
    }

    /**
     * Compara as informações dos contribuintes
     * @param o informação
     * @return As informações são iguais (true) ou não são (false)
     */
    public boolean equals (Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        ContribuintesColetivos c = (ContribuintesColetivos) o;
        return  (super.equals(c) && c.getAtividadeEcon().equals(this.atividadeEcon) && c.getFator() == this.fator);
    }
    
   /** 
     * Adiciona uma fatura emitida
     * @param f Fatura
     */
    public void addFEmitidas(Fatura f){
        this.emitidas.put(f.getIdFatura(),f);
        
    }
    
    /**
     * Remove uma fatura emitida
     * @param f Fatura
     */
    public void removeFEmitidas(Fatura f){
        this.emitidas.remove(f.getIdFatura());
    }
    
    /**
     * Aumenta o valor faturado
     * @param d Faturado
     */
    public void faturaçãoAtual(double d){
        this.faturado += d;
    }
}
 
/**
 * Escreva a descrição da classe ContrinuintesIndividuais aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;
public class ContribuintesIndividuais extends Contribuinte implements Serializable {
    private int dependentes; //Número de dependentes
    private List<String> nifs; //Nif dos dependentes
    private double coeffiscal; //Coeficiente fiscal
    private List<String> codigos; //Codigos das atividades ecónomicas
    private int numFilhos; //Numero de filhos

    /** Construtores */
    /**
     * Constroi um contribuinte individual sem parametros
     */
    public ContribuintesIndividuais() {
        super();
        this.dependentes=0;
        this.nifs =  new ArrayList<String>();
        this.coeffiscal=0;
        this.codigos =  new ArrayList<String>();
        this.numFilhos = 0;
    }
    
    /**
     * Constrói uma nova fatura a partir dos parametros fornecidos
     * @param f                  Faturas
     * @param nif                Nif do contribuinte
     * @param email              Email do contribunte
     * @param nome               Nome do contribunte
     * @param morada             Morada do contribunte
     * @param password           Password do contribunte
     * @param dependentes        Número de dependentes
     * @param nifs               Nifs dos dependentes
     * @param coeffiscal         Coeficiente fiscal
     * @param codigos            Codigos das atividades ecónomicas
     * @param despesa            Despesa do contribuinte
     */
    public ContribuintesIndividuais(HashMap<String,Fatura> f, HashMap<String,Fatura> p, String nif, String email, String nome, String morada, String password, 
    int dependentes, ArrayList<String> nifs, double coeffiscal, ArrayList<String> codigos, int numFilhos, double despesa) {
        super(f, p, nif, email, nome, morada, password, despesa);
        this.dependentes = dependentes;
        this.nifs = new ArrayList<String>();
        if (nifs!=null) setNifs(nifs);
        this.coeffiscal = coeffiscal;
        this.codigos = new ArrayList<String>();
        if (codigos!=null) setCodigos(codigos); 
        this.numFilhos = numFilhos;
    }

    /**
     * Constroi um contribuinte individual a partir de um objeto definido
     * @param c
     */
    public ContribuintesIndividuais(ContribuintesIndividuais c){
        super(c);
        this.dependentes = c.getDependentes();
        this.nifs = c.getNifs();
        this.coeffiscal = c.getCoeffiscal();
        this.codigos = c.getCodigos();
        this.numFilhos = c.getNumFilhos();
    }
  
    /** Metodos de Intância */

    /**
     * Retorna o número de dependentes do agregado familiar
     * @return número de dependentes
     */
    public int getDependentes() {
        return this.dependentes;
    }
    
    /**
     * Retorna os números fiscais do agregado familiar
     * @return nifs do agragado familiar
     */
    public List<String> getNifs() {
         ArrayList<String> a = new ArrayList<String>();
         for (String i : this.nifs)
                a.add(i);
         return a;
    }

    /**
     * Retorna o coeficiente fiscal para efeitos de dedução
     * @return coeficiente fiscal
     */
    public double getCoeffiscal() {
        return this.coeffiscal;
    }
    
    /**
     * Retorna os códigos das atividades económicas para as quais um determinado contribuinte tem possibilidade de deduzir despesas
     * @return códigos das atividades económicas
     */
    public List<String> getCodigos() {
         ArrayList<String> a = new ArrayList<String>();
         for (String i : this.codigos)
                a.add(i);
         return a;
    }
    
    /**
     * Retorna o numero de filhos
     * @return Numero de filhos
     */
    public int getNumFilhos() {
        return this.numFilhos;
    }
    
    /**
     * Altera o número de dependentes do agregado familiar
     * @param dependentes Novo número de dependentes
     */
    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
    
    /**
     * Altera os números fiscais do agregado familiar
     * @param nifs Novos nifs do agregado familiar
     */
    public void setNifs (ArrayList<String> c){   
       for (String l : c){
           this.nifs.add(l);
       }
   }
    /**
     * Altera o coeficiente fiscal para efeitos de dedução
     * @param coeffiscal Novo coeficiente fiscal
     */
    public void setCoeffiscal(double coeffiscal) {
        this.coeffiscal = coeffiscal;
    }
    
    /**
     * Altera os códigos das atividades económicas para as quais um determinado  contribuinte
     * tem possibilidade de deduzir despesas
     * @param codigos Novo codigo da atividade económica
     */
    public void setCodigos(ArrayList<String> c){   
       for (String l : c){
           this.codigos.add(l);
       }
   }
   
   /**
     * Altera o numero de filhos no agregado familiar
     * @param numFilhos Novo numero de filhos no agregado
     */
    public void setNumFilhos(int numFilhos){   
       this.numFilhos = numFilhos;
   }
    
    /**
     * Imprime a informação de um contribuinte individual
     * @return String com a informação
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O número de dependentes do agregado familiar é ");
        sb.append(this.dependentes);
        sb.append(", sendo que ");
        sb.append(this.numFilhos);
        if(nifs.size()!=0){
            sb.append(" são filhos. Os números fiscais do agregado são: ");
            for(String i : nifs){
                sb.append(i);
                sb.append("; ");
            }
        }
        else sb.append(" são filhos. ");
        sb.append("Para efeito de dedução o coeficiente fiscal correponde a ");
        sb.append(this.coeffiscal);
        if(codigos.size()!=0){
            sb.append(". Os códigos das atividades económicas são ");
            for(String i : codigos){
                sb.append(i);
                sb.append("; ");
            }
        }
        else sb.append(".");
        sb.append("\n");
        return super.toString() + sb.toString();
    }
    
    /**
     * Faz a cópia de um contribuinte individual
     * @return Cópia do contribuinte individual
     */
    public ContribuintesIndividuais clone(){
        return new ContribuintesIndividuais(this);
    }
    
    /**
     * Compara dois contribuintes individuais
     * @param o contribuinte individual
     * @return É um contribuinte individual igual (true) ou não é (false)
     */
    public boolean equals (Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        ContribuintesIndividuais c = (ContribuintesIndividuais) o;
        return super.equals(c) && this.dependentes==c.getDependentes() && c.getNifs().equals(this.nifs) &&
               this.coeffiscal==getCoeffiscal() && c.getCodigos().equals(this.codigos);

    }
}
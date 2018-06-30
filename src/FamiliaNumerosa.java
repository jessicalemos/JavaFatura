
/**
 * Write a description of class FamiliaNumerosa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.Serializable;
import static java.util.stream.Collectors.toMap;
public class FamiliaNumerosa  extends ContribuintesIndividuais implements IncentivoFiscal, Serializable {
    private static double reduçao = 0.05; 
    
    /** Construtores */
    
    /**
     * Constroi um contribuinte individual que pertence a uma familia numerosa sem parametros
     */
    public FamiliaNumerosa() {
        super();
    }
    
    /**
     * Constrói  um contribuinte invididual que percente a uma familia numerosa
     * @param f                  Faturas
     * @param p                  Faturas em estado pendente
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
    public FamiliaNumerosa(HashMap<String,Fatura> f, HashMap<String,Fatura> p, String nif, String email, String nome, String morada, String password, 
    int dependentes, ArrayList<String> nifs, double coeffiscal, ArrayList<String> codigos, int numFilhos, double despesa){
        super(f, p, nif, email, nome, morada, password, dependentes, nifs, coeffiscal, codigos,numFilhos, despesa);
    }
    
     /**
     * Constroi um contribuinte invididual que percente a uma familia numerosa
     * @param s
     */
    public FamiliaNumerosa(FamiliaNumerosa p){
        super(p);
    }
    
     /**
     * Faz a cópia de um contribuinte invididual que percente a uma familia numerosa
     * @return Cópia de uma familia numerosa
     */
    public FamiliaNumerosa clone(){
        return new FamiliaNumerosa(this);
    }
   
   /**
     * Altera o valor da redução aplicada a familias numerosas
     * @param redução  Novo valor da redução
     */
   public void setReduçao(double reduçao){
       this.reduçao = reduçao;
    }
         
    /**
     * Devolve o valor da reduçao aplicada a familias numerosas
     * @return  Redução aplicada
     */
   public double getReduçao(){
       return this.reduçao;
    }
}

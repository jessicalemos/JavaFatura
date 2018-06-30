
/**
 * Write a description of class EmpresaInterior here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.Serializable;
import static java.util.stream.Collectors.toMap;

public class EmpresaInterior extends ContribuintesColetivos implements IncentivoFiscal, Serializable{
    private static double reduçao = 0.2;   
    
    /** Construtores */
    
    /**
     * Constroi um contribuinte coletivo que se situa no interior sem parametros
     */
    public EmpresaInterior() {
        super();
    }
    
    /**
     * Constrói  um contribuinte coletivo que se situa no interior
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
    public EmpresaInterior(HashMap<String,Fatura> f, HashMap<String,Fatura> p, HashMap<String,Fatura> emitidas, String nif, String email, String nome, 
    String morada, String password,ArrayList<String> atividadeEcon, double fator, double faturado, double despesa, String concelho){
        super(f, p, emitidas, nif, email, nome, morada, password,atividadeEcon, fator, faturado, despesa, concelho);
    }
    
    /**
     * Constroi um contribuinte coletivo que se situa no interior
     * @param s
     */
    public EmpresaInterior(EmpresaInterior p){
        super(p);
    }
     
    /**
     * Faz a cópia de um contribuinte coletivo que se situa no interior
     * @return Cópia de uma empresa do interior
     */
    public EmpresaInterior clone(){
        return new EmpresaInterior(this);
    }
      
    /**
     * Altera o valor da redução aplicada a empresas do interior
     * @param redução  Novo valor da redução
     */
   public void setReduçao(double reduçao){
       this.reduçao = reduçao;
    }
       
    /**
     * Devolve o valor da reduçao aplicada a empresas do interior
     * @return  Redução aplicada
     */
   public double getReduçao(){
       return this.reduçao;
    }
}

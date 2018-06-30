
/**
 * Escreva a descrição da classe SemAutorizaçãoException aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class SemAutorizaçãoException extends Exception{
    public SemAutorizaçãoException(String msg){
            super(msg);
    }
    
    public SemAutorizaçãoException(){
            super();
    }
}

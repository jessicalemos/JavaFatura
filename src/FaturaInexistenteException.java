
/**
 * Escreva a descrição da classe FaturaInexistenteException aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class FaturaInexistenteException extends Exception{
    public FaturaInexistenteException(String msg){
            super(msg);
    }
    
    public FaturaInexistenteException(){
        super();
    }
}

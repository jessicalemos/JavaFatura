
/**
 * Escreva a descrição da classe FaturaExisteException aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class FaturaExisteException extends Exception{
    public FaturaExisteException(String msg){
            super(msg);
    }
    
    public FaturaExisteException(){
        super();
    }
}

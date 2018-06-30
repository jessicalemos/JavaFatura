
/**
 * Escreva a descrição da classe Administrador aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
public class Administrador implements Serializable{
    private static int codigo = 19982;

    /** Construtores */

    /**
     * Construtor vazio de um administrador
     */
    public Administrador(){}

    /**
     * Retorna o codigo de acesso à aplicação por parte do adiministrador
     * @return Codigo de acesso
     */
    public int getCodigo(){
      return this.codigo;
    }
}

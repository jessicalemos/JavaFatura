
/**
 * Escreva a descrição da classe ContribuinteCComparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;

public class ContribuinteCComparator implements Comparator<ContribuintesColetivos>, Serializable {
    public int compare(ContribuintesColetivos c1, ContribuintesColetivos c2) {
        if (c1.getFaturado() < c2.getFaturado()) return 1;
        if (c1.getFaturado() > c2.getFaturado()) return -1;
        return 0;
    }
}

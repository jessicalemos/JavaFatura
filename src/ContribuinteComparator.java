
/**
 * Escreva a descrição da classe ContribuinteComparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;

public class ContribuinteComparator implements Comparator<Contribuinte>, Serializable {
    public int compare(Contribuinte c1, Contribuinte c2) {
        if (c1.getDespesa() < c2.getDespesa()) return 1;
        if (c1.getDespesa() > c2.getDespesa()) return -1;
        return 0;
    }
}

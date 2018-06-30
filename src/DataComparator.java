
/**
 * Escreva a descrição da classe DataComparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;

public class DataComparator implements Comparator<Fatura>, Serializable {
    public int compare(Fatura c1, Fatura c2) {
        if (c1.getDataDespesa().isBefore(c2.getDataDespesa())) return 1;
        if (c1.getDataDespesa().isAfter(c2.getDataDespesa())) return -1;
        return 0;
    }
}

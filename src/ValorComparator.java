
/**
 * Escreva a descrição da classe ValorComparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;

public class ValorComparator implements Comparator<Fatura>, Serializable {
    public int compare(Fatura c1, Fatura c2) {
        if (c1.getValor() < c2.getValor()) return 1;
        if (c1.getValor() > c2.getValor()) return -1;
        return 0;
    }
}

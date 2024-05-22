package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TShirtTest {
    private TShirt t1;
    private TShirt t2;

    @BeforeEach
    void setUp() {
        t1 = new TShirt(TShirt.Tamanho.S, TShirt.Padrao.LISO, "T-Shirt", Artigo.Estado.NOVO, 0, Artigo.Avaliacao.IMPECAVEL,
                "T-Shirt Branca", "Nike", "1234", 100.0, 0.0, "CTT");
        t2 = new TShirt(TShirt.Tamanho.M, TShirt.Padrao.RISCAS, "T-Shirt", Artigo.Estado.NOVO, 0, Artigo.Avaliacao.IMPECAVEL,
                "T-Shirt Azul", "Adidas", "1235", 100.0, 0.0, "CTT");
    }

    @Test
    void testEquals() {
        assertEquals(t1, t1.clone());
        assertNotSame(t1, t1.clone());
        assertNotEquals(t1, t2);
        assertNotEquals(t1, null);
    }

    @Test
    void testEqualsHeranca () { //falha porque há um bug: o equals da TShirt não usa o equals de Artigo
        TShirt t3 = t1.clone();
        t3.setAvaliacao(Artigo.Avaliacao.SATISFATORIO); //muda-se o estado de t3, tornando-o diferente de t1
        assertNotEquals(t1,t3);
    }

    @Test
    void testClone() {
        TShirt t3 = t1.clone();
        assertEquals(t1, t3);
        assertNotSame(t1, t3);
    }

    @Test
    void testPrecoFinal() {
        LocalDate d1 = LocalDate.of(2021, 1, 1);
        assertEquals(100.0, t1.precoFinal(d1));
        t2.setNumeroDonos(1);
        assertEquals(50.0, t2.precoFinal(d1));
    }

}
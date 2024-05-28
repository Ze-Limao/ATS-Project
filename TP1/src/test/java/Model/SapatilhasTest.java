package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SapatilhasTest {

    Sapatilhas s_default;
    Sapatilhas s1;
    Sapatilhas s2;

    @BeforeEach
    void setUp() {
        s_default = new Sapatilhas();
        LocalDate data1 = LocalDate.of(2021, 1, 1);
        s1 = new Sapatilhas(42, true, "Azul", data1 , Sapatilhas.Tipos_Sapatilhas.NORMAL, "Sapatilhas", Artigo.Estado.NOVO, 0, Artigo.Avaliacao.BOM, "Sapatilhas", "Nike", "SAP1", 100, 0, "Sapatilhas");
        LocalDate data2 = LocalDate.of(2015, 5, 2);
        s2 = new Sapatilhas(35, false, "Preto", data2, Sapatilhas.Tipos_Sapatilhas.PREMIUM, "Sapatilhas", Artigo.Estado.USADO, 1, Artigo.Avaliacao.IMPECAVEL , "Sapatilhas", "Adidas", "SAP2", 150, 0, "Sapatilhas");
    }

    @Test
    void testEquals() {
        assertEquals(s_default, s_default);
        assertNotEquals(s_default, s1);
        assertNotEquals(s_default, s2);
        assertNotEquals(s1, s2);
    }

    @Test
    void testClone() {
        Sapatilhas s_clone = s1.clone();
        assertEquals(s1, s_clone);
        assertNotSame(s1, s_clone);
    }

    @Test
    void testPrecoFinalNegativo() { // falha porque há um 'bug': o preço final de umas sapatilhas usadas pode ser negativo (não faz sentido)
        s1.setEstado(Artigo.Estado.USADO);
        s1.setNumeroDonos(999); // é possível ter um artigo com 999 donos anteriores, embora não seja comum, a aplicação permite entre 1 e 1000
        s1.setCorrecaoPreco(1); // a aplicação deixa o utilizador escolher uma correcao de preço entre 0 e 10000 ao registar um artigo
        double preco1 = s1.precoFinal(LocalDate.of(2021, 1, 1));
        assertTrue(preco1 > 0); // não faz sentido que o preço final seja negativo ou zero
    }

    @Test
    void testEqualsHeranca() {
        Sapatilhas s3 = s1.clone();
        s3.setAvaliacao(Artigo.Avaliacao.SATISFATORIO); // muda-se o estado de s3, tornando-o diferente de s1
        assertNotEquals(s1, s3);
    }
}
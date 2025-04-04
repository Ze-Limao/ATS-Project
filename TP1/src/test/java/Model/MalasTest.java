package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MalasTest {

    Malas m1;
    Malas m2;

    @BeforeEach
    void setUp() {
        m1 = new Malas();
        m2 = new Malas(Malas.Tipos_Malas.NORMAL, 10.0f  , "couro", 2020, "malas", Artigo.Estado.NOVO,
                0, Artigo.Avaliacao.IMPECAVEL, "descricao", "marca", "codigo", 10.0, 0.0, "tipo");
    }

    @Test
    void testEquals() {
        assertEquals(m1, m1.clone());
        assertNotSame(m1, m1.clone());
        assertNotEquals(m1, m2);
    }

    @Test
    void testEqualsHeranca() { // falha porque há um bug: o equals da superclasse não está a ser chamado
        Malas m3 = m2.clone();
        m2.setNumeroDonos(99);
        assertNotEquals(m2, m3);
    }

    @Test
    void testClone() {
        Malas m3 = m2.clone();
        assertEquals(m2, m3);
        assertNotSame(m2, m3);
    }

    @Test
    void testPrecoFinal() {
        LocalDate data = LocalDate.now();
        assertEquals(m2.getPrecoBase() + m2.getCorrecaoPreco() * (data.getYear() - m2.getAno_da_colecao()) *0.5 ,
                m2.precoFinal(data));
        LocalDate daquiA5Anos = data.plusYears(5);
        m2.setDim(32.0f);
        assertEquals(m2.getPrecoBase() + m2.getCorrecaoPreco() * (daquiA5Anos.getYear() - m2.getAno_da_colecao()) * 1.5 ,
                m2.precoFinal(daquiA5Anos));
        m2.setDim(9.0f);
        assertEquals(m2.getPrecoBase() + m2.getCorrecaoPreco() * (daquiA5Anos.getYear() - m2.getAno_da_colecao()) * 0.5 ,
                m2.precoFinal(daquiA5Anos));

    }

    @Test
    void testPrecoFinalNegativo() { // falha porque há um 'bug': o preço final de uma mala pode ser negativo (não faz sentido)
        m2.setDim(12);
        m2.setCorrecaoPreco(1); // a aplicação deixa o utilizador escolher uma correcao de preço entre 0 e 10000 ao registar um artigo
        m2.setAno_da_colecao(2090); // o ano da coleção pode variar entre 0 e 10000, logo é possível ser um ano futuro
        double preco1 = m2.precoFinal(LocalDate.of(2024, 1, 1));
        assertTrue(preco1 > 0);
    }
}
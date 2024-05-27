package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportadorasTest {
    Transportadoras t;
    Transportadoras t2;

    @BeforeEach
    void setUp() {
        t = new Transportadoras("TESTE", 0.23, 0.10, false, 0.0);
        t2 = new Transportadoras("TESTE2", 0, 0, false, 0.0);
    }

    @Test
    void testEquals() {
        assertEquals(t, t.clone());
        assertNotSame(t, t.clone());
        assertNotEquals(t, t2);
        assertNotEquals(t, null);
    }

    @Test
    void testClone() {
        Transportadoras t_clone = t.clone();
        assertEquals(t, t_clone);
        assertNotSame(t, t_clone);
    }



    @Test
    void calculaPrecoExpedicaoLucro0() { // tecnicamente o enunciado não o proíbe mas não faz sentido o preço de expedição ser 0, entao consideramos como bug
        // lucro pode ser de 0 a 100000
        t.setLucro(0); // a app deixa que o lucro seja 0. Lucro = 0 significa que a transportadora não ganha nada, mas também não devia perder dinheiro
        double preco = t.calculaPrecoExpedicao(1L);
        assertNotEquals(0.0, preco); // não faz sentido o preço ser 0. Se o preço for 0, a transportadora está a perder dinheiro
    }
}
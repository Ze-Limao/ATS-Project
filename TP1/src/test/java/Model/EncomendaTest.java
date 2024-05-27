package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EncomendaTest {
    Encomenda e1;
    Encomenda e2;

    @BeforeEach
    void setUp() {
        List <Artigo> artigos = new ArrayList<>();
        Artigo a1 = new Malas();
        Artigo a2 = new Sapatilhas();
        artigos.add(a1);
        artigos.add(a2);
        Map <Integer, String> vendedores = new HashMap<>();
        e1 = new Encomenda("dono", artigos, 1.0, LocalDate.now(), vendedores);
        e2 = new Encomenda("dono", artigos, 1.0, LocalDate.now(), vendedores);
    }
    @Test
    void testEquals() {
        assertNotEquals(e1, e2); //pq do id
        assertEquals(e1, e1.clone());
    }

    @Test
    void testClone() {
        Encomenda e3 = e2.clone();
        assertEquals(e2, e3);
        assertNotSame(e2, e3);
    }
}
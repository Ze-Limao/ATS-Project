package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ComparatorVendas;
import main.java.Utilizador;

class CompareVendasTest {

    @Test
    public void testCompareMaiorA1() {
        Utilizador utilizador1 = new Utilizador();
        Utilizador utilizador2 = new Utilizador();
        
        utilizador1.setN_vendidos(2);
        utilizador2.setN_vendidos(1);
        ComparatorVendas comparator = new ComparatorVendas();
        int resultado = comparator.compare(utilizador1, utilizador2);

        assertEquals(-1, resultado); // Espera-se que o utilizador1 (com mais vendidos) seja colocado primeiro
    }

    @Test
    public void testCompareMaiorA2() {
        Utilizador utilizador1 = new Utilizador();
        Utilizador utilizador2 = new Utilizador();
        
        utilizador1.setN_vendidos(1);
        utilizador2.setN_vendidos(2);
        
        
        ComparatorVendas comparator = new ComparatorVendas();
        int resultado = comparator.compare(utilizador1, utilizador2);

        assertEquals(1, resultado); // Espera-se que o utilizador2 (com mais vendidos) seja colocado primeiro
    }

}

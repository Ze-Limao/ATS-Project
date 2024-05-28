import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CompareVendasTest {

    @Test
    public void testCompareMaiorA1() {
        Utilizador utilizador1 = new Utilizador();
        Utilizador utilizador2 = new Utilizador();
        ComparatorVendas comparator = new ComparatorVendas();
        int resultado1 = comparator.compare(utilizador1, utilizador2);
        assertTrue(resultado1==1||resultado1==-1);
        assertEquals(-1, resultado1);
        utilizador1.setN_vendidos(2);
        utilizador2.setN_vendidos(1);
        int resultado2 = comparator.compare(utilizador1, utilizador2);

        assertEquals(-1, resultado2); // Espera-se que o utilizador1 (com mais vendidos) seja colocado primeiro
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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TransportadoraTest {

    Transportadora t1;
    Transportadora t0;

    @BeforeEach
    public void setup() {
        t0 = new Transportadora();
        t1 = new Transportadora("Transportadora X", 10, 20, 30, 0.2, 0.1, true, 1);
    }

    @Test
    public void testEquals() {
        Transportadora t2 = new Transportadora("T1", 10, 20, 30, 0.2, 0.1, true, 1);
        Transportadora t3 = new Transportadora("T2", 10, 20, 30, 0.2, 0.1, false, 1);
        
        assertFalse(t3.isPremium());
        assertEquals(t1,t1);
        assertNotEquals(t1,null);
        assertNotEquals(t1, t2); // Deve ser igual porque têm os mesmos atributos
        assertNotEquals(t1, t3); // Não devem ser iguais porque têm nomes diferentes
    }
    
    @Test
    public void testCodigo() {
    	long codigo = Transportadora.getCodigo();
    	assertTrue(codigo > 0);
    	assertTrue(t0.getId() < codigo);
    	
    }
    
    @Test
    public void testToString() {
    	Transportadora transportadora = new Transportadora("Transportadora Exemplo", 10.0, 20.0, 30.0, 0.1, 0.2, true, 1);
        
        // Define o valor esperado da string
        String expected = "Transportadora:: { Id: "+transportadora.getId()+" Nome: Transportadora Exemplo Valor da encomenda pequena: 10.0 Valor da encomenda média: 20.0 Valor da encomenda grande: 30.0 Imposto: 0.1 Margem de lucro: 0.2 É premium: true Formula atual: 1 Total lucro: 0.0}";
        
        // Compara a string retornada pelo método toString com a string esperada
        assertEquals(expected, transportadora.toString());

    }

    @Test
    public void testClone() {
        Transportadora t2 = t1.clone();

        assertEquals(t1, t2); // Deve ser igual porque o clone deve ter os mesmos atributos
        assertNotSame(t1, t2); // Mas não devem ser a mesma instância
    }

    @Test
    public void testPrecoTransportadora1() {
        double preco1 = t1.preco_transportadora1(1);
        double preco2 = t1.preco_transportadora1(3);
        double preco3 = t1.preco_transportadora1(Integer.MAX_VALUE);
        assertEquals(1.08, preco1, 0);
        assertEquals(6.48, t1.getTotalLucro()); 
        assertEquals(2.16, preco2, 0);
        assertEquals(6.48, t1.getTotalLucro(), 0); 
        assertEquals(3.2399999999999998, preco3, 0);
        assertEquals(6.48, t1.getTotalLucro(), 0); 
    }

    @Test
    public void testPrecoTransportadora2() {
        t1.setFormula(2);
        double preco1 = t1.preco_transportadora2(1);
        double preco2 = t1.preco_transportadora2(3);
        double preco3 = t1.preco_transportadora2(Integer.MAX_VALUE);
        assertEquals(9.1, preco1, 0);
        assertEquals(54.599999999999994, t1.getTotalLucro()); 
        assertEquals(18.2, preco2, 0);
        assertEquals(54.599999999999994, t1.getTotalLucro(), 0); 
        assertEquals(27.299999999999997, preco3, 0);
        assertEquals(54.599999999999994, t1.getTotalLucro(), 0); 
    }

    @Test
    public void testPrecoTransportadora3() {
        t1.setFormula(3);
        double preco1 = t1.preco_transportadora3(1);
        double preco2 = t1.preco_transportadora3(3);
        double preco3 = t1.preco_transportadora3(Integer.MAX_VALUE);
        assertEquals(1.7999999999999998, preco1, 0);
        assertEquals(10.799999999999999, t1.getTotalLucro()); 
        assertEquals(3.5999999999999996, preco2, 0);
        assertEquals(10.799999999999999, t1.getTotalLucro(), 0); 
        assertEquals(5.3999999999999995, preco3, 0);
        assertEquals(10.799999999999999, t1.getTotalLucro(), 0); 
    }
    
    @Test
    public void testFormulaPrint() {
    	assertNotEquals("",t1.formula1());
    	assertNotEquals("",t1.formula2());
    	assertNotEquals("",t1.formula3());
    }
}

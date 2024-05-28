package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Transportadora;

class TransportadoraTest {
	
	Transportadora t1;
	Transportadora t0;
	
	public void setup() {
		t0 = new Transportadora();
		t1 = new Transportadora("Transportadora X", 10, 20, 30, 0.2, 0.1, true, 1);
	}

    @Test
    public void testEquals() {
        Transportadora t2 = new Transportadora("T1", 10, 20, 30, 0.2, 0.1, true, 1);
        Transportadora t3 = new Transportadora("T2", 10, 20, 30, 0.2, 0.1, true, 1);

        assertEquals(t1, t2); // Deve ser igual porque têm os mesmos atributos
        assertNotEquals(t1, t3); // Não devem ser iguais porque têm nomes diferentes
    }

    @Test
    public void testClone() {
        Transportadora t2 = t1.clone();

        assertEquals(t1, t2); // Deve ser igual porque o clone deve ter os mesmos atributos
        assertNotSame(t1, t2); // Mas não devem ser a mesma instância
    }

    @Test
    public void testPrecoTransportadora1() {
        double preco = t1.preco_transportadora1(3); // 3 artigos médios
        assertEquals(40.5, preco, 0); // Esperado: (20 * 0.1 * (1 + 0.2)) * 0.9 = 40.5
        assertEquals(40.5, t1.getTotalLucro(), 0); // O total de lucro deve ser atualizado
    }

    @Test
    public void testPrecoTransportadora2() {
        t1.setFormula(2);
        double preco = t1.preco_transportadora2(3); // 3 artigos médios
        assertEquals(73.5, preco, 0); // Esperado: 20 * (1 + 0.1 + 0.2) * 0.7 = 73.5
        assertEquals(73.5, t1.getTotalLucro(), 0); // O total de lucro deve ser atualizado
    }

    @Test
    public void testPrecoTransportadora3() {
    	t1.setFormula(3);
        double preco = t1.preco_transportadora3(3); // 3 artigos médios
        assertEquals(121.5, preco, 0); // Esperado: (20 * 0.1 * (1 + 0.2)) * 1.5 = 121.5
        assertEquals(121.5, t1.getTotalLucro(), 0); // O total de lucro deve ser atualizado
    }

}

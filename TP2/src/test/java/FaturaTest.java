package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.Fatura;

import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

class FaturaTest {
	
	Fatura f1;
	Fatura f2;
	
	@BeforeEach
	void setUp() {
		Fatura.setCodigo(1);
		Set<String> artigos = new HashSet<String>();
		artigos.add("Artigo1");
		artigos.add("Artigo2");
		artigos.add("Artigo3");
		f1 = new Fatura();
        f2 = new Fatura(true, 1, 123456789, artigos, 69, 1, 70);
    }

    @Test
    void testClone() {
        assertEquals(f2, f2.clone());
        assertNotSame(f2, f2.clone());
    }
    
    public void testEquals() {
        Fatura fatura1 = new Fatura();
        Fatura fatura2 = new Fatura(fatura1);
        assertNotEquals(fatura1, fatura2);
        assertEquals(fatura1, fatura2);
    }
    
    @Test
    public void testCriaCodigo() {
    	Fatura.setCodigo(1);
        assertEquals(1, Fatura.getCodigo());
        Fatura fatura1 = new Fatura();
        assertEquals(2, Fatura.getCodigo());
        Fatura fatura2 = new Fatura();
        assertEquals(3, Fatura.getCodigo());
    }
    
    @Test
    public void testAtualizaFatura() {
        Fatura fatura = new Fatura();
        fatura.atualizaFatura("artigo10", 50.0, 5.0, 55.0);
        assertTrue(fatura.getArtigos().contains("artigo1"));
        assertEquals(50.0, fatura.getCustoProdutos());
        assertEquals(5.0, fatura.getAlteracaoPreco());
        assertEquals(55.0, fatura.getPrecoFinal());
    }
}

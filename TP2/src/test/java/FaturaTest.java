import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


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
    	Fatura f3 = f2.clone();
    	f3.setId(f2.getId());
        assertEquals(f2, f3);
    }
	
	@Test
    public void testGettersAndSetters() {
        Fatura fatura = new Fatura();

        // Testando getters e setters de id
        fatura.setId(10);
        assertEquals(10, fatura.getId());

        // Testando getters e setters de compra
        fatura.setCompra(true);
        assertTrue(fatura.isCompra());

        fatura.setCompra(false);
        assertFalse(fatura.isCompra());

        // Testando getters e setters de idEncomenda
        fatura.setIdEncomenda(12345);
        assertEquals(12345, fatura.getIdEncomenda());

        // Testando getters e setters de nifComprador
        fatura.setNifComprador(999999999);
        assertEquals(999999999, fatura.getNifComprador());

        // Testando getters e setters de artigos
        Set<String> artigos = new HashSet<>();
        artigos.add("artigo1");
        artigos.add("artigo2");
        fatura.setArtigos(artigos);
        assertEquals(artigos, fatura.getArtigos());

        // Testando getters e setters de custoProdutos
        fatura.setCustoProdutos(100.50);
        assertEquals(100.50, fatura.getCustoProdutos());

        // Testando getters e setters de alteracaoPreco
        fatura.setAlteracaoPreco(15.75);
        assertEquals(15.75, fatura.getAlteracaoPreco());

        // Testando getters e setters de precoFinal
        fatura.setPrecoFinal(116.25);
        assertEquals(116.25, fatura.getPrecoFinal());
    }
	
    @Test
    public void testEquals() {
        Fatura fatura1 = new Fatura();
        Fatura fatura2 = new Fatura(fatura1);
        //assertNotEquals(fatura1, fatura2);
        assertEquals(fatura1, fatura1);
        assertNotEquals(fatura1, null);
        fatura2.setId(fatura1.getId());
    }
    
    @Test
    public void testCriaCodigo() {
    	Fatura.setCodigo(1);
    	assertTrue(Fatura.getCodigo()>0);
        assertEquals(1, Fatura.getCodigo());
        Fatura fatura1 = new Fatura();
        assertEquals(fatura1.getId(), 1);
    }
    
    @Test
    public void testAtualizaFatura() {
        Fatura fatura = new Fatura();
        fatura.atualizaFatura("artigo10", 50.0, 5.0, 55.0);
        assertTrue(fatura.getArtigos().contains("artigo10"));
        assertEquals(50.0, fatura.getCustoProdutos());
        assertEquals(5.0, fatura.getAlteracaoPreco());
        assertEquals(55.0, fatura.getPrecoFinal());
    }
    
    @Test
    public void testToString() {
        Set<String> artigos = new HashSet<>();
        artigos.add("artigo1");
        artigos.add("artigo2");

        Fatura fatura = new Fatura(true, 12345, 999999999, artigos, 100.50, 15.75, 116.25);
        String expected = "Fatura " + fatura.getId() + " - Compra\n" +
                "NIF do comprador: 999999999\n" +
                "Artigos vendidos: [artigo1, artigo2]\n\n" +
                "Custo dos produtos: 100,50€\n" +
                "Custo do transporte: 15,75€\n" +
                "Preço final: 116,25€\n";
        assertEquals(expected, fatura.toString());
    }
}


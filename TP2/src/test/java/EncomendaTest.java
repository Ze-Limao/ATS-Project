import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncomendaTest {

    private Encomenda encomendaVazia;
    private Encomenda encomendaParametrizada1;
    private Set<String> artigos;

    @BeforeEach
    public void setUp() {
        encomendaVazia = new Encomenda();
        artigos = new HashSet<>();
        artigos.add("A1");
        artigos.add("A2");
        encomendaParametrizada1 = new Encomenda(artigos, 123, Dimensao.Medio, LocalDate.now());
    }
    
    @Test
    public void testSettersAndGetters() {
        assertEquals(2, Encomenda.getDiasDevolver());
    	
        encomendaVazia.setIdComprador(456);
        assertEquals(456, encomendaVazia.getIdComprador());

        encomendaVazia.setDimensao(Dimensao.Grande);
        assertEquals(Dimensao.Grande, encomendaVazia.getDimensao());

        encomendaVazia.setEstado(Estado.Expedida);
        assertEquals(Estado.Expedida, encomendaVazia.getEstado());

        LocalDate data = LocalDate.of(2023, 5, 28);
        encomendaVazia.setData(data);
        assertEquals(data, encomendaVazia.getData());

        encomendaVazia.setDataEntrega(data.plusDays(2));
        assertEquals(data.plusDays(2), encomendaVazia.getDataEntrega());
    }
    
    @Test
    public void testToString() {
        String expected = "Encomenda:: { Artigos: [A1, A2] Código: " + encomendaParametrizada1.getId() +
                " Dimensão: Medio Estado: Pendente Data de criação: " + LocalDate.now() +" Data de entrega: N/A}";
        assertEquals(expected, encomendaParametrizada1.toString());
    }
    
    @Test
    public void testAdicionaArtigo() throws ArtigoExistenteException{
        try {
            encomendaVazia.adicionaArtigo("A1");
            assertTrue(encomendaVazia.getEncomenda().contains("A1"));
        } catch (ArtigoExistenteException e) {
            fail("ArtigoExistenteException não esperada");
        }
    }

    @Test
    public void testRemoveArtigo() throws ArtigoExistenteException, ArtigoNaoEncontradoException {
        try {
            encomendaVazia.adicionaArtigo("A1");
            encomendaVazia.removeArtigo("A1");
            assertFalse(encomendaVazia.getEncomenda().contains("A1"));
        } catch (ArtigoExistenteException | ArtigoNaoEncontradoException e) {
            fail("Exceção não esperada");
        }
    }

    @Test
    public void testRemoveTudo() throws ArtigoExistenteException {
        encomendaVazia.adicionaArtigo("A1");
        encomendaVazia.adicionaArtigo("A2");
        Set<String> removidos = encomendaVazia.removeTudo();
        assertTrue(removidos.contains("A1"));
        assertTrue(removidos.contains("A2"));
        assertTrue(encomendaVazia.getEncomenda().isEmpty());
    }

    @Test
    public void testPodeDevolver() {
        encomendaVazia.setEstado(Estado.Expedida);
        encomendaVazia.setDataEntrega(LocalDate.now().minusDays(1));
        assertTrue(encomendaVazia.podeDevolver(LocalDate.now()));
        encomendaVazia.setDataEntrega(LocalDate.now().minusDays(3));
        assertFalse(encomendaVazia.podeDevolver(LocalDate.now()));
    }

    @Test
    public void testDefineTamanho() throws ArtigoExistenteException {
        encomendaVazia.defineTamanho();
        assertEquals(Dimensao.Pequeno, encomendaVazia.getDimensao());

        encomendaVazia.adicionaArtigo("A1");
        encomendaVazia.defineTamanho();
        assertEquals(Dimensao.Pequeno, encomendaVazia.getDimensao());

        encomendaVazia.adicionaArtigo("A2");
        encomendaVazia.defineTamanho();
        assertEquals(Dimensao.Medio, encomendaVazia.getDimensao());

        encomendaVazia.adicionaArtigo("A3");
        encomendaVazia.adicionaArtigo("A4");
        encomendaVazia.adicionaArtigo("A5");
        encomendaVazia.defineTamanho();
        assertEquals(Dimensao.Medio, encomendaVazia.getDimensao());

        encomendaVazia.adicionaArtigo("A6");
        encomendaVazia.defineTamanho();
        assertEquals(Dimensao.Grande, encomendaVazia.getDimensao());
    }

    @Test
    public void testNumeroArtigos() throws ArtigoExistenteException {
        assertEquals(0, encomendaVazia.numeroArtigos());

        encomendaVazia.adicionaArtigo("A1");
        assertEquals(1, encomendaVazia.numeroArtigos());

        encomendaVazia.adicionaArtigo("A2");
        assertEquals(2, encomendaVazia.numeroArtigos());
    }

    @Test
    public void testEquals() throws ArtigoExistenteException {
    	encomendaParametrizada1.setDataEntrega(LocalDate.now());
        Encomenda outra = new Encomenda(encomendaParametrizada1);
        outra.setId(encomendaParametrizada1.getId());
        assertEquals(encomendaParametrizada1, encomendaParametrizada1);
        assertEquals(encomendaParametrizada1, outra);
        assertNotEquals(encomendaParametrizada1, null);
//
        outra.adicionaArtigo("A3");
        assertNotEquals(encomendaParametrizada1, outra);
    }
//
    @Test
    public void testClone() {
    	encomendaParametrizada1.setDataEntrega(LocalDate.now());
        Encomenda copia = encomendaParametrizada1.clone();
        copia.setId(encomendaParametrizada1.getId());
        assertEquals(encomendaParametrizada1, copia);
    }
}

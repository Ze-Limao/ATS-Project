package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.ArtigoExistenteException;
import main.java.ArtigoNaoEncontradoException;
import main.java.Dimensao;
import main.java.Encomenda;
import main.java.Estado;

public class EncomendaTest {

    private Encomenda encomendaVazia;
    private Encomenda encomendaParametrizada;
    private Set<String> artigos;

    @BeforeEach
    public void setUp() {
        encomendaVazia = new Encomenda();
        artigos = new HashSet<>();
        artigos.add("A1");
        artigos.add("A2");
        encomendaParametrizada = new Encomenda(artigos, 123, Dimensao.Medio, LocalDate.now());
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
    public void testAdicionaArtigoExistente() throws ArtigoExistenteException {
        encomendaVazia.adicionaArtigo("A1");
        encomendaVazia.adicionaArtigo("A1"); // Deve lançar ArtigoExistenteException
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
        Encomenda outra = new Encomenda(encomendaParametrizada);
        assertEquals(encomendaParametrizada, outra);

        outra.adicionaArtigo("A3");
        assertNotEquals(encomendaParametrizada, outra);
    }

    @Test
    public void testClone() {
        Encomenda copia = encomendaParametrizada.clone();
        assertEquals(encomendaParametrizada, copia);
        assertNotSame(encomendaParametrizada, copia);
    }
}

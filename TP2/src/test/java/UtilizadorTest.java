package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.ArtigoExistenteException;
import main.java.ArtigoNaoEncontradoException;
import main.java.CarrinhoVazioException;
import main.java.Encomenda;
import main.java.EncomendaExistenteException;
import main.java.EncomendaNaoEncontradaException;
import main.java.Estado;
import main.java.Utilizador;

public class UtilizadorTest {
    private Utilizador utilizador;

    @BeforeEach
    public void setUp() {
        utilizador = new Utilizador("test@example.com", "Test User", "123 Test St", 123456789L, "password123");
    }

    @Test
    public void testConstrutorVazio() {
        Utilizador u = new Utilizador();
        assertNotNull(u);
        assertEquals("n/d", u.getEmail());
        assertEquals("n/d", u.getNome());
        assertEquals("n/d", u.getMorada());
        assertEquals(-1, u.getNif());
        assertEquals("n/d", u.getPassword());
        assertEquals(0, u.getN_vendidos());
        assertEquals(0, u.getN_comprados());
        assertNotNull(u.getProdutosVendidos());
        assertNotNull(u.getProdutosVender());
        assertNotNull(u.getPendentes());
        assertNotNull(u.getFaturasVendas());
        assertNotNull(u.getFaturasCompras());
        assertNotNull(u.getComprei());
        assertNotNull(u.getDevolvidos());
        assertNotNull(u.getCarrinho());
    }

    @Test
    public void testConstrutorParametrizado() {
        assertEquals("test@example.com", utilizador.getEmail());
        assertEquals("Test User", utilizador.getNome());
        assertEquals("123 Test St", utilizador.getMorada());
        assertEquals(123456789L, utilizador.getNif());
        assertEquals("password123", utilizador.getPassword());
        assertEquals(0, utilizador.getN_vendidos());
        assertEquals(0, utilizador.getN_comprados());
    }

    @Test
    public void testConstrutorCopia() {
        Utilizador copia = new Utilizador(utilizador);
        assertEquals(utilizador, copia);
    }

    @Test
    public void testClone() {
        Utilizador clone = utilizador.clone();
        assertEquals(utilizador, clone);
    }

    @Test
    public void testEquals() {
        Utilizador u1 = new Utilizador("test1@example.com", "User 1", "Address 1", 123456789L, "password1");
        Utilizador u2 = new Utilizador("test1@example.com", "User 1", "Address 1", 123456789L, "password1");
        assertEquals(u1, u2);
    }

    @Test
    public void testInsereNovoArtigo() throws ArtigoExistenteException {
        String idArtigo = "art123";
        assertEquals(idArtigo, utilizador.insereNovoArtigo(idArtigo));
        assertThrows(ArtigoExistenteException.class, () -> utilizador.insereNovoArtigo(idArtigo));
    }

    @Test
    public void testEliminaArtigo() throws ArtigoNaoEncontradoException, ArtigoExistenteException {
        String idArtigo = "art123";
        utilizador.insereNovoArtigo(idArtigo);
        assertEquals(idArtigo, utilizador.eliminaArtigo(idArtigo));
        assertThrows(ArtigoNaoEncontradoException.class, () -> utilizador.eliminaArtigo(idArtigo));
    }

    @Test
    public void testAVendaToPendente() throws ArtigoNaoEncontradoException, ArtigoExistenteException {
        String idArtigo = "art123";
        utilizador.insereNovoArtigo(idArtigo);
        assertEquals(idArtigo, utilizador.aVendaToPendente(idArtigo));
        assertThrows(ArtigoNaoEncontradoException.class, () -> utilizador.aVendaToPendente(idArtigo));
    }

    @Test
    public void testAtualizaEncomenda() {
        LocalDate data = LocalDate.now();
        long idEncomenda = utilizador.atualizaEncomenda(data);
        assertEquals(utilizador.getId(), utilizador.getCarrinho().getIdComprador());
        assertEquals(data, utilizador.getCarrinho().getData());
    }

    @Test
    public void testFinalizaEncomenda() throws EncomendaExistenteException, CarrinhoVazioException, ArtigoExistenteException {
        LocalDate data = LocalDate.now();
        utilizador.adicionaArtigo("art123");
        Encomenda encomenda = utilizador.finalizaEncomenda(data);
        assertEquals(Estado.Expedida, encomenda.getEstado());
        assertEquals(data, encomenda.getDataEntrega());
    }

    @Test
    public void testRemoveCarrinho() throws ArtigoExistenteException {
        utilizador.adicionaArtigo("art123");
        Set<String> artigosRemovidos = utilizador.removeCarrinho();
        assertTrue(artigosRemovidos.contains("art123"));
        assertTrue(utilizador.artigosCarrinho().isEmpty());
    }

    @Test
    public void testNovoCarrinho() {
        utilizador.novoCarrinho();
        assertTrue(utilizador.artigosCarrinho().isEmpty());
    }

    @Test
    public void testAdicionaArtigo() throws ArtigoExistenteException {
        String idArtigo = "art123";
        assertEquals(idArtigo, utilizador.adicionaArtigo(idArtigo));
        assertThrows(ArtigoExistenteException.class, () -> utilizador.adicionaArtigo(idArtigo));
    }

    @Test
    public void testRemoveArtigo() throws ArtigoNaoEncontradoException, ArtigoExistenteException {
        String idArtigo = "art123";
        utilizador.adicionaArtigo(idArtigo);
        assertEquals(idArtigo, utilizador.removeArtigo(idArtigo));
        assertThrows(ArtigoNaoEncontradoException.class, () -> utilizador.removeArtigo(idArtigo));
    }

    @Test
    public void testCompreiToDevolvido() throws EncomendaNaoEncontradaException, EncomendaExistenteException, CarrinhoVazioException, ArtigoExistenteException {
        LocalDate data = LocalDate.now();
        utilizador.adicionaArtigo("art123");
        utilizador.finalizaEncomenda(data);
        long idEncomenda = utilizador.getCarrinho().getId();
        assertEquals(idEncomenda, utilizador.compreiToDevolvido(idEncomenda));
        assertFalse(utilizador.verificaComprei(idEncomenda));
        assertTrue(utilizador.getDevolvidos().contains(idEncomenda));
    }

    @Test
    public void testCompareTo() {
        Utilizador u1 = new Utilizador("test1@example.com", "User 1", "Address 1", 123456789L, "password1");
        Utilizador u2 = new Utilizador("test2@example.com", "User 2", "Address 2", 123456789L, "password2");
        assertTrue(u1.compareTo(u2) != 0);
    }

    // Testes adicionais para métodos de fatura, impressão de faturas, etc.
}

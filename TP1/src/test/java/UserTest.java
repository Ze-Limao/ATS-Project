import Model.*;
import java.util.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private Utilizador user;

    @BeforeEach
    void setUp() {
        String email = "user@mail.com";
        String name = "User";
        String address = "123 Main St.";
        int nif = 123456789; // deveria ser uma string
        List<Artigo> compras = new ArrayList<>();
        List<Artigo> porVender = new ArrayList<>();
        List<Artigo> vendas = new ArrayList<>();
        Map<LocalDate, Double> faturacao = new HashMap<>();

        user = new Utilizador(email, "password", name, address, nif, compras, porVender, vendas, faturacao);
    }

    @Test
    void testDadosUtilizador() {
        assertEquals(1, user.getId());
        assertEquals("user@mail.com", user.getEmail());
        assertEquals("User", user.getNome());
        assertEquals("123 Main St.", user.getMorada());
        assertEquals(123456789, user.getNif());
    }

    @Test
    void testCompras() {
        List<Artigo> compras = new ArrayList<>();
        compras.add(new TShirt());
        user.setCompras(compras);
        assertEquals(compras, user.getCompras());
    }

    @Test
    void testPorVender() {
        List<Artigo> porVender = new ArrayList<>();
        porVender.add(new TShirt());
        porVender.add(new Sapatilhas( 40, true, "Azul", LocalDate.now(), Sapatilhas.Tipos_Sapatilhas.NORMAL, "Sapatilhas", Artigo.Estado.NOVO, 0, Artigo.Avaliacao.IMPECAVEL, "Sapatilhas Azuis", "Nike", "1234", 100.0, 0.0, "CTT"));
        porVender.add(new Malas());
        user.setPorVender(porVender);
        assertEquals(porVender, user.getPorVender());
    }

    @Test
    void testVendas() {
        List<Artigo> vendas = user.getVendas();
        vendas.add(new TShirt());
        vendas.add(new Sapatilhas());
        vendas.add(new Malas());
        user.setVendas(vendas);
        assertEquals(vendas, user.getVendas());
    }

    @Test
    void testFaturacao() {
        Map<LocalDate, Double> faturacao = new HashMap<>();
        faturacao.put(LocalDate.now(), 100.0);
        faturacao.put(LocalDate.now().minusDays(1), 200.0);
        user.setFaturacao(faturacao);
        assertEquals(faturacao, user.getFaturacao());
    }


}

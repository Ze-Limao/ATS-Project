package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Artigo;
import main.java.Mala;
import main.java.Padrao;
import main.java.Sapatilha;
import main.java.Tamanho;
import main.java.Tshirt;

class ArtigosTest {

	Sapatilha s2;
	Sapatilha s1;
	Mala m1;
	Tshirt t1;
	Mala m2;
	Tshirt t2;
	
	@BeforeEach
	public void setUp() {
        s1 = new Sapatilha();
        m1 = new Mala();
        t1 = new Tshirt();
        s2 = new Sapatilha("Sapatilhas de corrida","Nike",100.0,true,8,1,12345L,6890L,42,true,"Preto",2023,false,0.1);
        m2 = new Mala("Mala1","Louis Pyton",500.0,false,0,0,12345L,6890L,10,"Couro",1999,false,0.3f);
        t2 = new Tshirt("TShirt1","Adidas",10.0,true,5,3,12345L,6890L,Tamanho.M,Padrao.liso);
        
    }

    @Test
    public void testCriaCodigo() {
        String codigo1 = Artigo.criaCodigo();
        String codigo2 = Artigo.criaCodigo();
        assertEquals("A1", codigo1);
        assertEquals("A2", codigo2);
    }

    @Test
    public void testPrecoAtual() {
    	Sapatilha clone1 = s2.clone();
    	Mala clone2 = m2.clone();
    	Tshirt clone3 = t2.clone();
        assertEquals(s2.preco_atual(LocalDate.now()), clone1.preco_atual(LocalDate.now()));
        assertEquals(m2.preco_atual(LocalDate.now()), clone2.preco_atual(LocalDate.now()));
        assertEquals(t2.preco_atual(LocalDate.now()) , clone3.preco_atual(LocalDate.now()));
        assertTrue(s2.preco_atual(LocalDate.now()) > 0);
        assertTrue(m2.preco_atual(LocalDate.now()) > 0);
        assertTrue(t2.preco_atual(LocalDate.now()) > 0);
    }

    @Test
    public void testClone() {
    	Sapatilha clone1 = s1.clone();
    	Mala clone2 = m1.clone();
    	Tshirt clone3 = t1.clone();
        assertEquals(s1, clone1);
        assertEquals(m1, clone2);
        assertEquals(t1, clone3);
    }

    @Test
    public void testEquals() {
        Sapatilha sNew = new Sapatilha(s2);
        assertEquals(sNew, s2);

        s2.setDescricao("Outra descricao");
        assertNotEquals(sNew, s2);
        
        Mala mNew = new Mala(m2);
        assertEquals(mNew, m2);

        m2.setDescricao("Outra descricao");
        assertNotEquals(mNew, m2);
        
        Tshirt tNew = new Tshirt(t2);
        assertEquals(tNew, t2);

        s2.setDescricao("Outra descricao");
        assertNotEquals(sNew, t2);
    }
 }



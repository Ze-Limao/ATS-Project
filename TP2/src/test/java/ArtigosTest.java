import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ArtigosTest {

	Sapatilha s2;
	Sapatilha s3;
	Sapatilha s1;
	Sapatilha s4;
	Sapatilha s5;
	Sapatilha s6;
	Sapatilha s7;
	Sapatilha s8;
	Mala m1;
	Tshirt t1;
	Mala m2;
	Mala m3;
	Mala m4;
	Tshirt t2;
	Tshirt t3;

	@BeforeEach
	public void setUp() {
        s1 = new Sapatilha();
        m1 = new Mala();
        t1 = new Tshirt();
        s2 = new Sapatilha("Sapatilhas de corrida","Nike",100.0,true,8,2,12345L,6890L,42,true,"Preto",2023,false,0.1);
        s6 = new Sapatilha("Sapatilhas de corrida","Nike",0.0,true,8,2,12345L,6890L,42,true,"Preto",2023,false,0.1);
        s3 = new Sapatilha("Sapatilhas de corrida2","Nike",100.0,false,8,2,12345L,6890L,42,true,"Preto",2023,false,0.1);
        s4 = new Sapatilha("Sapatilhas de corrida","Nike",100.0,true,8,1,12345L,6890L,46,true,"Preto",2023,false,0.1);
        s7 = new Sapatilha("Sapatilhas de corrida","Nike",100.0,true,8,1,12345L,6890L,46,true,"Preto",2022,true,0.1);
        s5 = new Sapatilha("Sapatilhas de corrida2","Nike",100.0,false,8,2,12345L,6890L,45,true,"Preto",2023,true,0.1);
        m2 = new Mala("Mala1","Louis Pyton",500.0,true,0,0,12345L,6890L,10,"Couro",1999,false,0.3f);
        m3 = new Mala("Mala2","Louis Pyton",500.0,true,0,0,12345L,6890L,10,"Couro",1999,true,0.3f);
        m4 = new Mala("Mala2","Louis Pyton",500.0,false,2,7,12345L,6890L,10,"Couro",1999,true,0.3f);
        t2 = new Tshirt("TShirt1","Adidas",10.0,false,5,3,12345L,6890L,Tamanho.M,Padrao.liso);
        t3 = new Tshirt("TShirt1","Adidas",10.0,false,5,3,12345L,6890L,Tamanho.M,Padrao.riscas);
    }
	
	@Test
	public void testCodigo() {
		assertTrue(Artigo.getCodigo() != null && Artigo.getCodigo() != "" && Artigo.getContador() > 1);
		assertTrue("" != s2.getCodigo_barras());
		assertTrue('-' != s2.getCodigo_barras().charAt(1));
		assertEquals(true,s2.getNovo());
		assertEquals(false,t2.getNovo());
		assertEquals(true,s2.getDisponivel());
		assertEquals(false,s1.getDisponivel());
		
	}
	
    @Test
    public void testPrecoAtual() {
        assertEquals(100.0, s2.preco_atual(LocalDate.now()));
        assertEquals(97.40250000000002, s3.preco_atual(LocalDate.now()));
        assertEquals(99.9, s4.preco_atual(LocalDate.now()));
        assertEquals(110.0, s5.preco_atual(LocalDate.now()));
        assertEquals(0.01, s6.preco_atual(LocalDate.now()));
        assertEquals(120.0, s7.preco_atual(LocalDate.now()));
        assertEquals(500.0, m2.preco_atual(LocalDate.now()));
        assertEquals(538.8818506546518, m3.preco_atual(LocalDate.now()));
        assertEquals(538.8818506546518, m4.preco_atual(LocalDate.now()));
        assertEquals(10.0 , t2.preco_atual(LocalDate.now()));
        assertEquals(5.0 , t3.preco_atual(LocalDate.now()));
        assertTrue(s2.preco_atual(LocalDate.now()) > 0);
        assertTrue(m2.preco_atual(LocalDate.now()) > 0);
        assertTrue(t2.preco_atual(LocalDate.now()) > 0);
    }
    

    
    @Test
    public void testGetters() {
    	assertEquals(0.1,s2.getDesconto());
    	assertEquals(true,s2.isAtacadores());
    	assertEquals("Preto",s2.getCor());
    	assertEquals(2023,s2.getAnoColecao());
    	assertEquals(false,s2.isPremium());
    	assertEquals(true,s5.isPremium());
    	assertEquals(42,s2.getTamanho());
    	
    	assertEquals(10,m2.getDimensao());
    	assertEquals("Couro",m2.getMaterial());
    	assertEquals(1999,m2.getAno_colecao());
    	assertEquals(false,m2.isPremium());
    	assertEquals(0.3f,m2.getValorizacao());
    	
    	assertEquals(Tamanho.M,t2.getTamanho());
    	assertEquals(Padrao.liso,t2.getPadrao());
    }
    @Test
    public void testClone() {
    	assertEquals(s1,s1);
    	assertEquals(m1,m1);
    	assertEquals(t1,t1);
    	assertNotEquals(s1,null);
    	assertNotEquals(m1,null);
    	assertNotEquals(t1,null);
    	Sapatilha clone1 = s1.clone();
    	Mala clone2 = m1.clone();
    	t1.setTamanho(Tamanho.M);
    	t1.setPadrao(Padrao.liso);
    	Tshirt clone3= t1.clone();
        assertEquals(s1, clone1);
        assertEquals(m1, clone2);
        assertEquals(t1, clone3);
    }

    @Test
    public void testEquals() {
    	
        Sapatilha sNew = new Sapatilha(s2);
        //(sNew, s2);
//
        s2.setDescricao("Outra descricao");
        assertNotEquals(sNew, s2);
//
        Mala mNew = new Mala(m2);
        //assertEquals(mNew, m2);
//
        m2.setDescricao("Outra descricao");
        assertNotEquals(mNew, m2);
//
        Tshirt tNew = new Tshirt(t2);
    //    assertEquals(tNew, t2);
//
        t2.setDescricao("Outra descricao");
        assertNotEquals(tNew, t2);
    }
    
    @Test
    public void testMostrar() {
    	assertNotEquals("",s2.toString());
    	assertNotEquals("",m2.toString());
    	assertNotEquals("",t2.toString());
    	assertEquals(s2.toString()+" Preço atual: 100,00€ \n",s2.mostrar(LocalDate.now()));
    }
 }



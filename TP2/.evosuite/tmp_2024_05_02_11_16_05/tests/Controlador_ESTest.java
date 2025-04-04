/*
 * This file was automatically generated by EvoSuite
 * Thu May 02 10:21:51 GMT 2024
 */


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.evosuite.runtime.mock.java.time.MockLocalDate;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.evosuite.runtime.util.SystemInUtil;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Controlador_ESTest extends Controlador_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      HashMap<Integer, Artigo> hashMap0 = new HashMap<Integer, Artigo>();
      Gestor_Artigos gestor_Artigos0 = new Gestor_Artigos(hashMap0);
      Gestor_Utilizadores gestor_Utilizadores0 = new Gestor_Utilizadores();
      Gestor_Utilizadores gestor_Utilizadores1 = new Gestor_Utilizadores(gestor_Utilizadores0);
      GestorEncomendas gestorEncomendas0 = new GestorEncomendas();
      GestorEncomendas gestorEncomendas1 = new GestorEncomendas(gestorEncomendas0);
      Map<Long, Encomenda> map0 = gestorEncomendas1.getEncomendas();
      GestorEncomendas gestorEncomendas2 = new GestorEncomendas(map0);
      Gestor_Transportadoras gestor_Transportadoras0 = new Gestor_Transportadoras();
      Vintage vintage0 = new Vintage(gestor_Artigos0, gestor_Utilizadores1, gestorEncomendas2, gestor_Transportadoras0, (Menu) null);
      Controlador controlador0 = new Controlador((Menu) null, vintage0);
      // Undeclared exception!
      try { 
        controlador0.adicionar_artigo_carrinho();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Menu menu0 = new Menu();
      Vintage.carregarEstado();
      Controlador controlador0 = new Controlador(menu0, (Vintage) null);
      controlador0.getVintage();
      // Undeclared exception!
      try { 
        controlador0.escolha_carrinho();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      SystemInUtil.addInputLine("");
      Controlador controlador1 = new Controlador(controlador0);
      controlador0.povoar();
      controlador1.adicionar_artigo_carrinho();
      // Undeclared exception!
      try { 
        controlador1.escolha_venda_malas();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      FileSystemHandling.createFolder((EvoSuiteFile) null);
      Vintage vintage0 = new Vintage();
      Controlador controlador0 = new Controlador((Menu) null, vintage0);
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_sapatilhas();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Controlador controlador0 = new Controlador((Menu) null, (Vintage) null);
      // Undeclared exception!
      try { 
        controlador0.escolha_tipo();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Vintage vintage0 = new Vintage();
      Controlador controlador0 = new Controlador((Menu) null, vintage0);
      // Undeclared exception!
      try { 
        controlador0.escolha_transportadora();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      SystemInUtil.addInputLine("");
      Controlador controlador0 = new Controlador();
      controlador0.escolha_venda_tshirt();
      controlador0.escolha_venda();
      controlador0.inicio_controlador();
      controlador0.escolha_venda();
      controlador0.registar();
      controlador0.escolha_tshit();
      controlador0.escolha_transportadora();
      controlador0.adicionar_artigo_carrinho();
      controlador0.getMenu();
      controlador0.getMenu();
      controlador0.escolha_pesquica();
      controlador0.escolha_sapatilhas();
      controlador0.escolha_query();
      controlador0.escolha_venda();
      controlador0.escolha_malas();
      controlador0.escolha_venda_malas();
      controlador0.parsing();
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      System.setCurrentTimeMillis(123456L);
      SystemInUtil.addInputLine("F+t");
      Vintage vintage0 = Vintage.load();
      Controlador controlador0 = new Controlador((Menu) null, vintage0);
      // Undeclared exception!
      try { 
        controlador0.escolha_carrinho();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      SystemInUtil.addInputLine("$>? N[sGbq'XH");
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_sapatilhas();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Menu menu0 = null;
      Vintage.carregarEstado();
      EvoSuiteFile evoSuiteFile0 = null;
      String string0 = "@J.D ZTHI0A[VF[N";
      Controlador controlador0 = new Controlador((Menu) null, (Vintage) null);
      // Undeclared exception!
      try { 
        controlador0.escolha_tshit();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      Controlador controlador1 = new Controlador(controlador0);
      controlador1.getVintage();
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Controlador controlador0 = new Controlador((Menu) null, (Vintage) null);
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_malas();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Controlador controlador0 = new Controlador((Menu) null, (Vintage) null);
      // Undeclared exception!
      try { 
        controlador0.escolha();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Menu menu0 = new Menu();
      Vintage.carregarEstado();
      Controlador controlador0 = new Controlador(menu0, (Vintage) null);
      // Undeclared exception!
      try { 
        controlador0.inicio_controlador();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.menu_venda_retirar_artigo();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.menu_venda_retirar_artigo();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.parsing();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Menu menu0 = new Menu();
      assertNotNull(menu0);
      
      Vintage vintage0 = Vintage.carregarEstado();
      assertNull(vintage0);
      
      Controlador controlador0 = new Controlador(menu0, (Vintage) null);
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.salvarEstado();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Menu menu0 = new Menu();
      assertNotNull(menu0);
      
      Vintage vintage0 = Vintage.carregarEstado();
      assertNull(vintage0);
      
      Controlador controlador0 = new Controlador(menu0, (Vintage) null);
      assertNotNull(controlador0);
      
      Controlador controlador1 = new Controlador(controlador0);
      assertFalse(controlador1.equals((Object)controlador0));
      assertNotNull(controlador1);
      
      // Undeclared exception!
      try { 
        controlador1.povoar();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      HashMap<Integer, Artigo> hashMap0 = new HashMap<Integer, Artigo>();
      assertTrue(hashMap0.isEmpty());
      assertEquals(0, hashMap0.size());
      assertNotNull(hashMap0);
      
      Gestor_Artigos gestor_Artigos0 = new Gestor_Artigos(hashMap0);
      assertTrue(hashMap0.isEmpty());
      assertEquals(0, hashMap0.size());
      assertEquals(0.5, gestor_Artigos0.getTaxaNovo(), 0.01);
      assertEquals(0.25, gestor_Artigos0.getTaxaUsado(), 0.01);
      assertNotNull(gestor_Artigos0);
      
      Gestor_Utilizadores gestor_Utilizadores0 = new Gestor_Utilizadores();
      assertNotNull(gestor_Utilizadores0);
      
      GestorEncomendas gestorEncomendas0 = new GestorEncomendas();
      assertNotNull(gestorEncomendas0);
      
      Map<Long, Encomenda> map0 = gestorEncomendas0.getEncomendas();
      assertTrue(map0.isEmpty());
      assertEquals(0, map0.size());
      assertNotNull(map0);
      
      Gestor_Transportadoras gestor_Transportadoras0 = new Gestor_Transportadoras();
      assertNotNull(gestor_Transportadoras0);
      
      String string0 = gestor_Transportadoras0.toString();
      assertNotNull(string0);
      
      Vintage vintage0 = new Vintage(gestor_Artigos0, gestor_Utilizadores0, gestorEncomendas0, gestor_Transportadoras0, (Menu) null);
      assertTrue(hashMap0.isEmpty());
      assertEquals(0, hashMap0.size());
      assertEquals(0.5, gestor_Artigos0.getTaxaNovo(), 0.01);
      assertEquals(0.25, gestor_Artigos0.getTaxaUsado(), 0.01);
      assertEquals(0L, vintage0.getUtilizador());
      assertNotNull(vintage0);
      
      Controlador controlador0 = new Controlador((Menu) null, vintage0);
      assertTrue(hashMap0.isEmpty());
      assertEquals(0, hashMap0.size());
      assertEquals(0.5, gestor_Artigos0.getTaxaNovo(), 0.01);
      assertEquals(0.25, gestor_Artigos0.getTaxaUsado(), 0.01);
      assertEquals(0L, vintage0.getUtilizador());
      assertNotNull(controlador0);
      
      String string1 = gestor_Transportadoras0.toString();
      assertTrue(string1.equals((Object)string0));
      assertNotNull(string1);
      
      // Undeclared exception!
      try { 
        controlador0.parsing();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.parsing();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_malas();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      controlador0.salvarEstado();
      // Undeclared exception!
      try { 
        controlador0.escolha_malas();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_tipo();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      Controlador controlador1 = new Controlador(controlador0);
      assertFalse(controlador1.equals((Object)controlador0));
      assertNotNull(controlador1);
      
      // Undeclared exception!
      try { 
        controlador1.escolha_tipo();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Vintage vintage0 = new Vintage();
      assertEquals((-1L), vintage0.getUtilizador());
      assertNotNull(vintage0);
      
      boolean boolean0 = vintage0.verificaPassword("8J4hr'6nE`\"E74.|`W", "pa");
      assertFalse(boolean0);
      assertEquals((-1L), vintage0.getUtilizador());
      
      Controlador controlador0 = new Controlador((Menu) null, vintage0);
      assertEquals((-1L), vintage0.getUtilizador());
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.login();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_venda();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_tipo();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Menu menu0 = new Menu();
      assertNotNull(menu0);
      
      Vintage vintage0 = new Vintage();
      assertEquals((-1L), vintage0.getUtilizador());
      assertNotNull(vintage0);
      
      Controlador controlador0 = new Controlador(menu0, vintage0);
      assertEquals((-1L), vintage0.getUtilizador());
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            @Override public void run() { 
          Controlador controlador0 = new Controlador();
          assertNotNull(controlador0);
          
          Controlador controlador1 = new Controlador(controlador0);
          assertFalse(controlador1.equals((Object)controlador0));
          assertNotNull(controlador1);
          
          // Undeclared exception!
          try { 
            controlador0.escolha_venda_malas();
            fail("Expecting exception: StackOverflowError");
          
          } catch(StackOverflowError e) {
          }
      } 
    });
    future.get(4000, TimeUnit.MILLISECONDS);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_sapatilhas();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      Controlador controlador1 = new Controlador(controlador0);
      assertFalse(controlador1.equals((Object)controlador0));
      assertNotNull(controlador1);
      
      Menu menu0 = controlador1.getMenu();
      assertNotSame(controlador0, controlador1);
      assertNotSame(controlador1, controlador0);
      assertFalse(controlador0.equals((Object)controlador1));
      assertFalse(controlador1.equals((Object)controlador0));
      assertNotNull(menu0);
      
      // Undeclared exception!
      try { 
        controlador1.escolha_venda_malas();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.login();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Menu menu0 = new Menu();
      assertNotNull(menu0);
      
      Gestor_Utilizadores gestor_Utilizadores0 = new Gestor_Utilizadores();
      assertNotNull(gestor_Utilizadores0);
      
      Gestor_Utilizadores gestor_Utilizadores1 = new Gestor_Utilizadores(gestor_Utilizadores0);
      assertTrue(gestor_Utilizadores1.equals((Object)gestor_Utilizadores0));
      assertNotNull(gestor_Utilizadores1);
      
      GestorEncomendas gestorEncomendas0 = new GestorEncomendas();
      assertNotNull(gestorEncomendas0);
      
      HashMap<Long, Transportadora> hashMap0 = new HashMap<Long, Transportadora>();
      assertEquals(0, hashMap0.size());
      assertTrue(hashMap0.isEmpty());
      assertNotNull(hashMap0);
      
      Gestor_Transportadoras gestor_Transportadoras0 = new Gestor_Transportadoras(hashMap0);
      assertEquals(0, hashMap0.size());
      assertTrue(hashMap0.isEmpty());
      assertNotNull(gestor_Transportadoras0);
      
      Gestor_Transportadoras gestor_Transportadoras1 = new Gestor_Transportadoras(gestor_Transportadoras0);
      assertTrue(gestor_Transportadoras1.equals((Object)gestor_Transportadoras0));
      assertEquals(0, hashMap0.size());
      assertTrue(hashMap0.isEmpty());
      assertNotNull(gestor_Transportadoras1);
      
      Vintage vintage0 = new Vintage((Gestor_Artigos) null, gestor_Utilizadores1, gestorEncomendas0, gestor_Transportadoras1, menu0);
      assertTrue(gestor_Utilizadores0.equals((Object)gestor_Utilizadores1));
      assertTrue(gestor_Utilizadores1.equals((Object)gestor_Utilizadores0));
      assertTrue(gestor_Transportadoras0.equals((Object)gestor_Transportadoras1));
      assertTrue(gestor_Transportadoras1.equals((Object)gestor_Transportadoras0));
      assertEquals(0, hashMap0.size());
      assertTrue(hashMap0.isEmpty());
      assertEquals(0L, vintage0.getUtilizador());
      assertNotNull(vintage0);
      
      Controlador controlador0 = new Controlador(menu0, vintage0);
      assertTrue(gestor_Utilizadores0.equals((Object)gestor_Utilizadores1));
      assertTrue(gestor_Utilizadores1.equals((Object)gestor_Utilizadores0));
      assertTrue(gestor_Transportadoras0.equals((Object)gestor_Transportadoras1));
      assertTrue(gestor_Transportadoras1.equals((Object)gestor_Transportadoras0));
      assertEquals(0, hashMap0.size());
      assertTrue(hashMap0.isEmpty());
      assertEquals(0L, vintage0.getUtilizador());
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_sapatilhas();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Controlador controlador0 = null;
      try {
        controlador0 = new Controlador((Controlador) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      controlador0.salvarEstado();
      // Undeclared exception!
      try { 
        controlador0.adicionar_artigo_carrinho();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_carrinho();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_tshirt();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      assertNotNull(controlador0);
      
      // Undeclared exception!
      try { 
        controlador0.registar();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
      }
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      controlador0.salvarEstado();
      // Undeclared exception!
      try { 
        controlador0.escolha_tshit();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_pesquica();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_faturas();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      Controlador controlador1 = new Controlador(controlador0);
      // Undeclared exception!
      try { 
        controlador0.escolha_tshit();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      Controlador controlador1 = new Controlador(controlador0);
      // Undeclared exception!
      try { 
        controlador1.inicio_controlador();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_sapatilhas();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_query();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_transportadora();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      Menu menu0 = new Menu();
      Vintage vintage0 = new Vintage();
      vintage0.filtraMalasMaterial("0.00");
      menu0.registo();
      FileSystemHandling.shouldThrowIOException((EvoSuiteFile) null);
      Controlador controlador0 = new Controlador(menu0, vintage0);
      Controlador controlador1 = new Controlador(controlador0);
      // Undeclared exception!
      try { 
        controlador1.escolha_transportadora();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      Menu menu0 = new Menu();
      Gestor_Artigos gestor_Artigos0 = new Gestor_Artigos();
      Gestor_Utilizadores gestor_Utilizadores0 = new Gestor_Utilizadores();
      Gestor_Utilizadores gestor_Utilizadores1 = new Gestor_Utilizadores(gestor_Utilizadores0);
      HashMap<Long, Encomenda> hashMap0 = new HashMap<Long, Encomenda>();
      GestorEncomendas gestorEncomendas0 = new GestorEncomendas(hashMap0);
      Vintage vintage0 = new Vintage(gestor_Artigos0, gestor_Utilizadores1, gestorEncomendas0, (Gestor_Transportadoras) null, menu0);
      Controlador controlador0 = new Controlador(menu0, vintage0);
      Controlador controlador1 = new Controlador(controlador0);
      // Undeclared exception!
      try { 
        controlador1.escolha_pesquica();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      Menu menu0 = new Menu();
      Gestor_Utilizadores gestor_Utilizadores0 = new Gestor_Utilizadores();
      Gestor_Utilizadores gestor_Utilizadores1 = new Gestor_Utilizadores(gestor_Utilizadores0);
      GestorEncomendas gestorEncomendas0 = new GestorEncomendas();
      HashMap<Long, Transportadora> hashMap0 = new HashMap<Long, Transportadora>();
      Gestor_Transportadoras gestor_Transportadoras0 = new Gestor_Transportadoras(hashMap0);
      Gestor_Transportadoras gestor_Transportadoras1 = new Gestor_Transportadoras();
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_tipo();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      Vintage vintage0 = new Vintage();
      Controlador controlador0 = new Controlador((Menu) null, vintage0);
      // Undeclared exception!
      try { 
        controlador0.escolha_venda();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controlador", e);
      }
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      Vintage.carregarEstado();
      EvoSuiteFile evoSuiteFile0 = new EvoSuiteFile("dados.ser");
      FileSystemHandling.setPermissions(evoSuiteFile0, true, true, false);
      Menu menu0 = new Menu();
      Controlador controlador0 = new Controlador(menu0, (Vintage) null);
      Controlador controlador1 = new Controlador(controlador0);
      // Undeclared exception!
      try { 
        controlador1.escolha_sapatilhas();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      Controlador controlador1 = new Controlador(controlador0);
      // Undeclared exception!
      try { 
        controlador1.escolha_faturas();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      controlador0.salvarEstado();
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_tipo();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      // Undeclared exception!
      try { 
        controlador0.escolha_venda_malas();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      Controlador controlador0 = new Controlador();
      Controlador controlador1 = new Controlador(controlador0);
      controlador0.povoar();
      // Undeclared exception!
      try { 
        controlador1.adicionar_artigo_carrinho();
        fail("Expecting exception: StackOverflowError");
      
      } catch(StackOverflowError e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
}

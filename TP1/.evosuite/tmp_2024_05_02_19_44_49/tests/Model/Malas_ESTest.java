/*
 * This file was automatically generated by EvoSuite
 * Thu May 02 18:54:09 GMT 2024
 */

package Model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import Model.Artigo;
import Model.Malas;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.IsoChronology;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockLocalDate;
import org.evosuite.runtime.mock.java.time.chrono.MockIsoChronology;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Malas_ESTest extends Malas_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 30.0F, "\n", 0, ")llu>=J", artigo_Estado0, 1, artigo_Avaliacao0, ")llu>=J", ")llu>=J", "\n", (-112.92718805219626), (-112.92718805219626), "\n");
      Period period0 = Period.ofDays((-1));
      IsoChronology isoChronology0 = period0.getChronology();
      LocalDate localDate0 = MockIsoChronology.dateNow(isoChronology0);
      double double0 = malas0.precoFinal(localDate0);
      assertEquals((-341265.9622937371), double0, 0.01);
      assertEquals("\n", malas0.getMaterial());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, (-1.0F), "", (-1), "", artigo_Estado0, (-1), artigo_Avaliacao0, "", "", "", 1873.00818352, (-1.0F), "");
      malas0.setAno_da_colecao(0);
      Malas malas1 = new Malas(malas0);
      malas1.setAno_da_colecao((-1));
      boolean boolean0 = malas0.equals(malas1);
      assertEquals((-1), malas1.getAno_da_colecao());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Malas malas0 = new Malas();
      Malas malas1 = new Malas(malas0);
      malas1.setDim(30.0F);
      boolean boolean0 = malas1.equals(malas0);
      assertEquals(30.0F, malas1.getDim(), 0.01F);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "", (-2524), (String) null, artigo_Estado0, (-2524), artigo_Avaliacao0, (String) null, "h\"2B2=2p|", " ", 0.0F, (-1.0), "$VALUES");
      LocalDate localDate0 = MockLocalDate.ofEpochDay((-2524));
      double double0 = malas0.precoFinal(localDate0);
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals((-2243.5), double0, 0.01);
      assertEquals("", malas0.getMaterial());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Malas malas0 = new Malas();
      malas0.getTipo_mala();
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals(0, malas0.getAno_da_colecao());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.BOM;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 3144.64F, (String) null, 2, (String) null, artigo_Estado0, 0, artigo_Avaliacao0, (String) null, "USADO", "\"", (-724.31556), 0.0, (String) null);
      String string0 = malas0.getMaterial();
      assertEquals(2, malas0.getAno_da_colecao());
      assertNull(string0);
      assertEquals(3144.64F, malas0.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "b'", 0, "b'", artigo_Estado0, 0, artigo_Avaliacao0, "b'", "b'", "Gz\"e^^|_ d]2R$2#A", 1297.6347595258746, 1297.6347595258746, "");
      String string0 = malas0.getMaterial();
      assertEquals("b'", string0);
      assertEquals(0, malas0.getAno_da_colecao());
      assertEquals(0.0F, malas0.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Malas malas0 = new Malas();
      malas0.setDim(10.0F);
      float float0 = malas0.getDim();
      assertEquals(10.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, (-2287.4917F), ".1%%", 0, ".1%%", artigo_Estado0, 2388, artigo_Avaliacao0, ".1%%", "3E{1TF? 8n+", "xnx84|c.ba", 2388, 2388, "");
      float float0 = malas0.getDim();
      assertEquals((-2287.4917F), float0, 0.01F);
      assertEquals(0, malas0.getAno_da_colecao());
      assertEquals(".1%%", malas0.getMaterial());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Malas malas0 = new Malas();
      int int0 = malas0.getAno_da_colecao();
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Malas malas0 = new Malas();
      malas0.setAno_da_colecao(675);
      int int0 = malas0.getAno_da_colecao();
      assertEquals(675, int0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.BOM;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 235.32F, "DX=t~{vFYVcAp", (-1), "DX=t~{vFYVcAp", artigo_Estado0, (-1), artigo_Avaliacao0, (String) null, "DX=t~{vFYVcAp", (String) null, 1.0, (-1), (String) null);
      Malas malas1 = malas0.clone();
      assertEquals(235.32F, malas0.getDim(), 0.01F);
      assertEquals((-1), malas0.getAno_da_colecao());
      assertTrue(malas1.equals((Object)malas0));
      assertEquals((-1), malas1.getAno_da_colecao());
      assertEquals(235.32F, malas1.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "$VALUES", 1656, "$VALUES", artigo_Estado0, 46, artigo_Avaliacao0, "$VALUES", "$VALUES", "$VALUES", (-1071.38861058), 0.0, "");
      Malas malas1 = malas0.clone();
      assertEquals(1656, malas1.getAno_da_colecao());
      assertTrue(malas1.equals((Object)malas0));
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals("$VALUES", malas1.getMaterial());
      assertEquals(1656, malas0.getAno_da_colecao());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Malas malas0 = new Malas();
      malas0.setId(0);
      Malas malas1 = malas0.clone();
      assertEquals(0, malas1.getAno_da_colecao());
      assertEquals(0.0F, malas0.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Malas malas0 = new Malas();
      malas0.setId((-71));
      Malas malas1 = malas0.clone();
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals(0, malas1.getAno_da_colecao());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Malas malas0 = new Malas();
      malas0.setDim((-1235.0F));
      malas0.clone();
      assertEquals((-1235.0F), malas0.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.BOM;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "tp", (-914), "J", artigo_Estado0, (-914), artigo_Avaliacao0, "s", "8'D)PO`", "Preco Final: ", (-914), 0.5, "8'D)PO`");
      Malas malas1 = malas0.clone();
      assertTrue(malas1.equals((Object)malas0));
      assertEquals((-914), malas1.getAno_da_colecao());
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals("tp", malas1.getMaterial());
      assertEquals((-914), malas0.getAno_da_colecao());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Malas malas0 = new Malas();
      // Undeclared exception!
      try { 
        malas0.toString((LocalDate) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Model.Malas", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.BOM;
      Malas malas0 = new Malas(malas_Tipos_Malas0, (-1402.443F), "Qf", 0, "", artigo_Estado0, (-632), artigo_Avaliacao0, "Qf", "Y,'%^r]f=|", (String) null, (-1402.443F), (-1402.443F), (String) null);
      // Undeclared exception!
      try { 
        malas0.precoFinal((LocalDate) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Model.Malas", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Malas malas0 = null;
      try {
        malas0 = new Malas((Malas) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Model.Artigo", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.BOM;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 2781.729F, "USADO", 1, "Tipo de mala: ", artigo_Estado0, 0, artigo_Avaliacao0, "Tipo de mala: ", "!3", "USADO", 2781.729F, 2781.729F, "%MIr1^kn+x*CZ9");
      LocalDate localDate0 = MockLocalDate.ofEpochDay((-2573L));
      double double0 = malas0.precoFinal(localDate0);
      assertEquals("USADO", malas0.getMaterial());
      assertEquals(8185237.593994141, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Malas malas0 = new Malas();
      malas0.setDim(10.0F);
      LocalDate localDate0 = MockLocalDate.now();
      double double0 = malas0.precoFinal(localDate0);
      assertEquals(10.0F, malas0.getDim(), 0.01F);
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "", (-2524), (String) null, artigo_Estado0, (-2524), artigo_Avaliacao0, (String) null, "h\"2B2=2p|", " ", 0.0F, (-1.0), "$VALUES");
      String string0 = malas0.getMaterial();
      assertEquals("", string0);
      assertEquals((-2524), malas0.getAno_da_colecao());
      assertNotNull(string0);
      assertEquals(0.0F, malas0.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "", (-2524), (String) null, artigo_Estado0, (-2524), artigo_Avaliacao0, (String) null, "h\"2B2=2p|", " ", 0.0F, (-1.0), "$VALUES");
      float float0 = malas0.getDim();
      assertEquals(0.0F, float0, 0.01F);
      assertEquals("", malas0.getMaterial());
      assertEquals((-2524), malas0.getAno_da_colecao());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "", (-2524), (String) null, artigo_Estado0, (-2524), artigo_Avaliacao0, (String) null, "h\"2B2=2p|", " ", 0.0F, (-1.0), "$VALUES");
      int int0 = malas0.getAno_da_colecao();
      assertEquals("", malas0.getMaterial());
      assertEquals((-2524), int0);
      assertEquals(0.0F, malas0.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 0.0F, "", (-2524), (String) null, artigo_Estado0, (-2524), artigo_Avaliacao0, (String) null, "h\"2B2=2p|", " ", 0.0F, (-1.0), "$VALUES");
      malas0.getTipo_mala();
      assertEquals((-2524), malas0.getAno_da_colecao());
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals("", malas0.getMaterial());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1163, "CEmcS\"", artigo_Estado0, 1163, artigo_Avaliacao0, (String) null, (String) null, "", 2.8211018445027345, 2637.070161, "hUO>etP:pGFe");
      LocalDate localDate0 = MockLocalDate.now();
      malas0.setDim(1163);
      malas0.toString(localDate0);
      assertEquals(1163.0F, malas0.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Malas malas0 = new Malas();
      LocalDate localDate0 = MockLocalDate.now();
      double double0 = malas0.precoFinal(localDate0);
      assertEquals(0.0, double0, 0.01);
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals(0, malas0.getAno_da_colecao());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Malas malas0 = new Malas();
      Malas malas1 = new Malas(malas0);
      malas1.setAno_da_colecao(668);
      boolean boolean0 = malas0.equals(malas1);
      assertEquals(668, malas1.getAno_da_colecao());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Malas malas0 = new Malas();
      Malas malas1 = new Malas(malas0);
      boolean boolean0 = malas0.equals(malas1);
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals(0, malas1.getAno_da_colecao());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.BOM;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1178, (String) null, artigo_Estado0, 1178, artigo_Avaliacao0, (String) null, (String) null, "3VB1`ZV*v&+t", 10.0F, 1178, "hUO>etP:pGFe");
      malas0.setMaterial("hUO>etP:pGFe");
      malas0.setDim(1178);
      Malas malas1 = new Malas(malas_Tipos_Malas0, 1178, "3VB1`ZV*v&+t", 1178, "hUO>etP:pGFe", artigo_Estado0, 1178, artigo_Avaliacao0, "hUO>etP:pGFe", "ID: 1178\nTipo: null\nEstado: USADO\nN\u00FAmero de Donos: 1178\nAvaliacao: BOM\nDescri\u00E7\u00E3o: null\nMarca: null\nC\u00F3digo: 3VB1`ZV*v&+t\nPre\u00E7o Base: 10.0\nCorre\u00E7\u00E3o do Pre\u00E7o: 1178.0\nTransportadora: hUO>etP:pGFe\nTipo de mala: NORMAL\nDimens\u00F5es: 1178.0\nMaterial: hUO>etP:pGFe\nAno da cole\u00E7\u00E3o: 1178\nPreco Final: 1477222.0\n", (String) null, 10.0F, 1178, "hUO>etP:pGFe");
      boolean boolean0 = malas0.equals(malas1);
      assertEquals(1178.0F, malas0.getDim(), 0.01F);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1163, "CEmcS\"", artigo_Estado0, 1163, artigo_Avaliacao0, (String) null, (String) null, "", 2.8211018445027345, 2637.070161, "hUO>etP:pGFe");
      malas0.setDim(1163);
      Malas malas1 = new Malas(malas_Tipos_Malas0, 1163, "", (-1125), "", artigo_Estado0, (-1125), artigo_Avaliacao0, "Material: ", "ID: 1\nTipo: CEmcS\"\nEstado: NOVO\nN\u00FAmero de Donos: 0\nAvaliacao: null\nDescri\u00E7\u00E3o: null\nMarca: null\nC\u00F3digo: CEmcS\"\nPre\u00E7o Base: 2.8211018445027345\nCorre\u00E7\u00E3o do Pre\u00E7o: 10.0\nTransportadora: hUO>etP:pGFe\nTipo de mala: PREMIUM\nDimens\u00F5es: 1163.0\nMaterial: null\nAno da cole\u00E7\u00E3o: 1163\nPreco Final: 12767.821101844504\n", "Model.Malas$Tipos_Malas", (-3631.7878036068705), 1.0, "Tipo de mala: ");
      // Undeclared exception!
      try { 
        malas0.equals(malas1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Malas malas0 = new Malas();
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.SATISFATORIO;
      Malas malas1 = new Malas(malas_Tipos_Malas0, 30.0F, "Tipo: ", 0, "Tipo: ", artigo_Estado0, 2, artigo_Avaliacao0, "Tipo: ", "", "", 0.0, (-186.95891), "");
      boolean boolean0 = malas0.equals(malas1);
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals(0, malas0.getAno_da_colecao());
      assertEquals("Tipo: ", malas1.getMaterial());
      assertFalse(boolean0);
      assertEquals(0, malas1.getAno_da_colecao());
      assertEquals(30.0F, malas1.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.NORMAL;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.USADO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.BOM;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1178, (String) null, artigo_Estado0, 1178, artigo_Avaliacao0, (String) null, (String) null, "3VB1`ZV*v&+t", 10.0F, 1178, "hUO>etP:pGFe");
      Object object0 = new Object();
      boolean boolean0 = malas0.equals(object0);
      assertEquals(10.0F, malas0.getDim(), 0.01F);
      assertEquals(1178, malas0.getAno_da_colecao());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Malas malas0 = new Malas();
      boolean boolean0 = malas0.equals((Object) null);
      assertEquals(0.0F, malas0.getDim(), 0.01F);
      assertEquals(0, malas0.getAno_da_colecao());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1163, "CEmcS\"", artigo_Estado0, 1163, artigo_Avaliacao0, (String) null, (String) null, "", 2.8211018445027345, 2637.070161, "hUO>etP:pGFe");
      boolean boolean0 = malas0.equals(malas0);
      assertEquals(10.0F, malas0.getDim(), 0.01F);
      assertTrue(boolean0);
      assertEquals(1163, malas0.getAno_da_colecao());
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1163, "CEmcS\"", artigo_Estado0, 1163, artigo_Avaliacao0, (String) null, (String) null, "", 2.8211018445027345, 2637.070161, "hUO>etP:pGFe");
      LocalDate localDate0 = MockLocalDate.now();
      String string0 = malas0.toString(localDate0);
      assertEquals("ID: 1\nTipo: CEmcS\"\nEstado: NOVO\nN\u00FAmero de Donos: 0\nAvaliacao: null\nDescri\u00E7\u00E3o: null\nMarca: null\nC\u00F3digo: \nPre\u00E7o Base: 2.8211018445027345\nCorre\u00E7\u00E3o do Pre\u00E7o: 2637.070161\nTransportadora: hUO>etP:pGFe\nTipo de mala: PREMIUM\nDimens\u00F5es: 10.0\nMaterial: null\nAno da cole\u00E7\u00E3o: 1163\nPreco Final: 2244149.5281128446\n", string0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1163, "CEmcS\"", artigo_Estado0, 1163, artigo_Avaliacao0, (String) null, (String) null, "", 2.8211018445027345, 2637.070161, "hUO>etP:pGFe");
      Malas malas1 = new Malas(malas_Tipos_Malas0, 1163, "", (-1125), "", artigo_Estado0, (-1125), artigo_Avaliacao0, "Material: ", "ID: 1\nTipo: CEmcS\"\nEstado: NOVO\nN\u00FAmero de Donos: 0\nAvaliacao: null\nDescri\u00E7\u00E3o: null\nMarca: null\nC\u00F3digo: CEmcS\"\nPre\u00E7o Base: 2.8211018445027345\nCorre\u00E7\u00E3o do Pre\u00E7o: 10.0\nTransportadora: hUO>etP:pGFe\nTipo de mala: PREMIUM\nDimens\u00F5es: 1163.0\nMaterial: null\nAno da cole\u00E7\u00E3o: 1163\nPreco Final: 12767.821101844504\n", "Model.Malas$Tipos_Malas", (-3631.7878036068705), 1.0, "Tipo de mala: ");
      boolean boolean0 = malas0.equals(malas1);
      assertEquals("", malas1.getMaterial());
      assertFalse(boolean0);
      assertEquals((-1125), malas1.getAno_da_colecao());
      assertEquals(1163.0F, malas1.getDim(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Malas.Tipos_Malas malas_Tipos_Malas0 = Malas.Tipos_Malas.PREMIUM;
      Artigo.Estado artigo_Estado0 = Artigo.Estado.NOVO;
      Artigo.Avaliacao artigo_Avaliacao0 = Artigo.Avaliacao.IMPECAVEL;
      Malas malas0 = new Malas(malas_Tipos_Malas0, 10.0F, (String) null, 1163, "CEmcS\"", artigo_Estado0, 1163, artigo_Avaliacao0, (String) null, (String) null, "", 2.8211018445027345, 2637.070161, "hUO>etP:pGFe");
      malas0.setTipo_mala(malas_Tipos_Malas0);
      assertEquals(1163, malas0.getAno_da_colecao());
      assertEquals(10.0F, malas0.getDim(), 0.01F);
  }
}

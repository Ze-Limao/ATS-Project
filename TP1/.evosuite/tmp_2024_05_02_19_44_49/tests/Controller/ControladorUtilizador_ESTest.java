/*
 * This file was automatically generated by EvoSuite
 * Thu May 02 18:55:20 GMT 2024
 */

package Controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import Controller.ControladorUtilizador;
import Model.Vintage;
import View.Apresentacao;
import java.util.NoSuchElementException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.util.SystemInUtil;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ControladorUtilizador_ESTest extends ControladorUtilizador_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ControladorUtilizador controladorUtilizador0 = new ControladorUtilizador();
      Vintage vintage0 = new Vintage();
      // Undeclared exception!
      try { 
        controladorUtilizador0.interpretador(vintage0, (Apresentacao) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("Controller.Input", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      SystemInUtil.addInputLine("7");
      Vintage vintage0 = new Vintage();
      Apresentacao apresentacao0 = new Apresentacao();
      ControladorUtilizador controladorUtilizador0 = new ControladorUtilizador();
      // Undeclared exception!
      try { 
        controladorUtilizador0.interpretador(vintage0, apresentacao0);
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Vintage vintage0 = new Vintage();
      SystemInUtil.addInputLine("1");
      ControladorUtilizador controladorUtilizador0 = new ControladorUtilizador();
      Apresentacao apresentacao0 = new Apresentacao();
      // Undeclared exception!
      try { 
        controladorUtilizador0.interpretador(vintage0, apresentacao0);
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ControladorUtilizador controladorUtilizador0 = new ControladorUtilizador();
      Vintage vintage0 = new Vintage();
      SystemInUtil.addInputLine("2");
      Apresentacao apresentacao0 = new Apresentacao();
      // Undeclared exception!
      try { 
        controladorUtilizador0.interpretador(vintage0, apresentacao0);
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // No line found
         //
         verifyException("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ControladorUtilizador controladorUtilizador0 = new ControladorUtilizador();
      Vintage vintage0 = new Vintage();
      SystemInUtil.addInputLine("0");
      Apresentacao apresentacao0 = new Apresentacao();
      String string0 = controladorUtilizador0.interpretador(vintage0, apresentacao0);
      assertNull(string0);
  }
}

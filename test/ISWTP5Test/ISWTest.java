/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISWTP5Test;
import iswtp5.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Planos
 */
public class ISWTest {
    
    public ISWTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Negocio.Iniciar();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void comprobarRegla2ValoresEntre500Y1000Descuento3PorCiento(){
      //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 10);
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[2],1);
      Regla2 regla2 = new Regla2();
      double descuento =0;
      
      //Ejecución
      descuento = regla2.RealizarDescuento(venta);
      
      //Validación
        assertEquals(17.1, descuento, 0.01);
    }
    
    @Test
    public void comprobarRegla2ValoresEntre1000Y2500Descuento3PorCiento(){
      //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 40);
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[2],1);
      Regla2 regla2 = new Regla2();
      double descuento =0;
      
      //Ejecución
      descuento = regla2.RealizarDescuento(venta);
      
      //Validación
        assertEquals(103.5, descuento, 0.01);
    }
  
    @Test
    public void comprobarRegla2ValoresMayores2500Descuento6yMedioPorCiento(){
        //Configuración
      Venta venta;
      venta = new Venta();
      venta.AgregarDetalle(Negocio.Productos()[0], 80);
      venta.AgregarDetalle(Negocio.Productos()[1], 1);
      venta.AgregarDetalle(Negocio.Productos()[2],1);
      Regla2 regla2 = new Regla2();
      double descuento =0;
      
      //Ejecución
      descuento = regla2.RealizarDescuento(venta);
      
      //Validación
        assertEquals(264.55, descuento, 0.01);
    }


    @Test
    public void regla4VentasMenoresA1000() {
        Venta venta;
        venta = new Venta();

        Regla4 regla4 = new Regla4();

        double descuento = regla4.RealizarDescuento(venta);

        assertEquals(0, descuento, 0.01);
    }

    @Test
    public void regla4VentaMayorA1000ConDescuento() {
        Venta venta;
        venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[0], 21);   //descuento 105
        venta.AgregarDetalle(Negocio.Productos()[1], 2);    //descuento 0

        Regla4 regla4 = new Regla4();

        double descuento = regla4.RealizarDescuento(venta);

        assertEquals(105, descuento, 0.01);
    }

}

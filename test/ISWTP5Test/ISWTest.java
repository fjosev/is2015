/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISWTP5Test;
import iswtp5.model.Negocio;
import iswtp5.model.Regla1;
import iswtp5.model.Regla2;
import iswtp5.model.Regla3;
import iswtp5.model.Regla4;
import iswtp5.model.Venta;
import java.util.ArrayList;
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
    /** Test para Regla1  **/
    @Test
    public void ComprobarRegla1SinDescuento(){
        Venta venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[0], 1);
        Regla1 regla1 = new Regla1();
        double descuento = 0;
        
        //Ejecución
        descuento = regla1.RealizarDescuento(venta);
        
        //Validación
        assertEquals(0, descuento, 0.01);
    }
    
    @Test
    public void ComprobarRegla1ConDescuento(){
        Venta venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[0], 3);
        Regla1 regla1 = new Regla1();
        double descuento = 0;
        
        //Ejecución
        descuento = regla1.RealizarDescuento(venta);
        
        //Validación
        assertEquals(50, descuento, 0.01);
    }
    
    /** Test para Regla3  **/
    @Test
    public void ComprobarRegla3ConDescuento(){
        Venta venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[2], 5);
        Regla3 regla3 = new Regla3();
        double descuento = 0;
        
        //Ejecución
        descuento = regla3.RealizarDescuento(venta);
        
        //Validación
        assertEquals(48, descuento, 0.01);
    }
    @Test
    public void ComprobarRegla3ConDescuentoHasta5(){
        Venta venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[2], 6);
        Regla3 regla3 = new Regla3();
        double descuento = 0;
        
        //Ejecución
        descuento = regla3.RealizarDescuento(venta);
        
        //Validación
        assertEquals(48, descuento, 0.01);
    }

    
    @Test
    public void ComprobarRegla3SinDescuento(){
        Venta venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[2], 1);
        Regla3 regla3 = new Regla3();
        double descuento = 0;
        
        //Ejecución
        descuento = regla3.RealizarDescuento(venta);
        
        //Validación
        assertEquals(0, descuento, 0.01);
    }
    
        /** Test para Regla4  **/
    @Test
    public void ComprobarRegla4ConDescuento(){
        Venta venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[0], 21);
        venta.AgregarDetalle(Negocio.Productos()[1], 5);
        Regla4 regla4 = new Regla4();
        double descuento = 0;
        
        //Ejecución
        descuento = regla4.RealizarDescuento(venta);
        
        //Validación
        assertEquals(120, descuento, 0.01);
    }
    @Test
    public void ComprobarRegla4SinDescuento(){
        Venta venta = new Venta();
        venta.AgregarDetalle(Negocio.Productos()[0], 2);
        venta.AgregarDetalle(Negocio.Productos()[1], 1);
        Regla4 regla4 = new Regla4();
        double descuento = 0;
        
        //Ejecución
        descuento = regla4.RealizarDescuento(venta);
        
        //Validación
        assertEquals(0, descuento, 0.01);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import br.ufrn.WebService.WebServiceMonitoramentoAmbiental;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class WebServiceTest {
    WebServiceMonitoramentoAmbiental ws = new WebServiceMonitoramentoAmbiental();
    public WebServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void testSubscriber(){
        try {
            ws.atualizarTemeperatura(1, "20");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try {
            ws.atualizaDistanciaAgente(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarAgenteProximo(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarFluxoDeVeiculos(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarHumidade(1,  "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarIncidenciaDeIncendio(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarProbalidadeChuva(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarQuantidadeLixo(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarQuantidadeRuido(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarTemeperatura(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarVelociadeDoVento(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizardirecaoDoVento(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ws.atualizarindicePoluicao(1, "1");
        } catch (RemoteException ex) {
            Logger.getLogger(WebServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        assertEquals("1", "1");
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
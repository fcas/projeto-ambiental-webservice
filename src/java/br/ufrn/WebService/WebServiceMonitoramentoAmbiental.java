/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.WebService;

import br.ufrn.controlers.AtualizarWidgetsRMI;
import br.ufrn.controlers.Reference;
import java.rmi.RemoteException;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jorge
 */
@Path("monitoramento_ambiental")
public class WebServiceMonitoramentoAmbiental {

//    private InstanciaWidget widget;
//    private final AtualizarWidgets atualizarWidgets = ConcreteAtualizarWidgets.getInstance();
//    
//    private MonitorCidade monitorCidade = MonitorCidade.getInstance();
    private AtualizarWidgetsRMI atualizarWidgets;

    /**
     * Creates a new instance of WebServiceMonitoramentoAmbiental
     */
    public WebServiceMonitoramentoAmbiental() {
//        this.widget = new InstanciaWidget();
//        monitorCidade.setVisible(true);
            atualizarWidgets = new Reference().getReference("rmi://localhost:1029/Monitoramento");
        
        
    }

    //=====PollutionWidget=====
    @POST
    @Path("/atualizar_indice_poluicao/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarindicePoluicao(@PathParam("area") int area, String indexPolluition) throws RemoteException {
        try {
            atualizarWidgets.atualizarIndicePoluicao(area, Integer.parseInt(indexPolluition));
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        }
        System.out.println(area + " indice poluição " + indexPolluition);
    }

    @POST
    @Path("/atualizar_fluxo_veiculos/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarFluxoDeVeiculos(@PathParam("area") int area, String vehicleFlow) throws RemoteException {
        try {
            atualizarWidgets.atualizarFluxoDeVeiculos(area, Integer.parseInt(vehicleFlow));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + " fluxo de veiculos  " + vehicleFlow);
    }

    //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
    @POST
    @Path("/atualizar_velocidade_vento/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarVelociadeDoVento(@PathParam("area") int area, String windSpeed) throws RemoteException {
        try {
            atualizarWidgets.atualizarVelociadeDoVento(area, Integer.parseInt(windSpeed));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + "  velocidade do vento " + windSpeed);
    }

    @POST
    @Path("/atualizar_direcao_vento/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizardirecaoDoVento(@PathParam("area") int area, String directionWind) throws RemoteException {
        try {
            atualizarWidgets.atualizardirecaoDoVento(area, directionWind);
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + "  direção do vento " + directionWind);
    }

    @POST
    @Path("/atualizar_probabilidade_chuva/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarProbalidadeChuva(@PathParam("area") int area, String willRain) throws RemoteException {
        try {
            atualizarWidgets.atualizarProbalidadeChuva(area, Integer.parseInt(willRain));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + " vai chover " + willRain);
    }

    @POST
    @Path("/atualizar_quantidade_ruido/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarQuantidadeRuido(@PathParam("area") int area, String noise) throws RemoteException {
        try {
            atualizarWidgets.atualizarQuantidadeRuido(area, Integer.parseInt(noise));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + " quantidade de ruido  " + noise);
    }

    //======TemperatureWidget=====
    @POST
    @Path("/atualizar_temperatura/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarTemeperatura(@PathParam("area") int area, String temperature) throws RemoteException {
        try {
            atualizarWidgets.atualizarTemeperatura(area, Integer.parseInt(temperature));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + " temperatura " + temperature);
    }

    @POST
    @Path("/atualizar_humidade/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarHumidade(@PathParam("area") int area, String humidity) throws RemoteException {
        try {
            atualizarWidgets.atualizarHumidade(area, Integer.parseInt(humidity));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + " humidade do ar " + humidity);
    }

    @POST
    @Path("/atualizar_incidencia_incendio/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarIncidenciaDeIncendio(@PathParam("area") int area, String isFire) throws RemoteException {
        try {
            atualizarWidgets.atualizarIncidenciaDeIncendio(area, Integer.parseInt(isFire));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + " fogo " + isFire);
    }

    //=====DumpWidget===
    @POST
    @Path("/atualizar_quantidade_lixo/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarQuantidadeLixo(@PathParam("area") int area, String trash) throws RemoteException {
        try {
            atualizarWidgets.atualizarQuantidadeLixo(area, Integer.parseInt(trash));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + " lixo " + trash);
    }

    @POST
    @Path("/atualizar_agente_proximo/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarAgenteProximo(@PathParam("area") int area, String agentNearName) throws RemoteException {
        try {
            atualizarWidgets.atualizarAgenteProximo(area, agentNearName);
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + "  agente proximo " + agentNearName);
    }

    @POST
    @Path("/atualizar_distancia_agente/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizaDistanciaAgente(@PathParam("area") int area, String agentDistance) throws RemoteException {
        try {
            atualizarWidgets.atualizaDistanciaAgente(area, Integer.parseInt(agentDistance));
        } catch (java.rmi.ConnectException a) {
            System.out.println(" conexão recusada...");
        } catch (NullPointerException e) {
            System.out.println(" interface não pode ser reconhecida...");
        }
        System.out.println(area + "  distancia proximo " + agentDistance);
    }
}
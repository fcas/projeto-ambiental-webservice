/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.WebService;

import br.ufrn.GUI.MonitorCidade;
import br.ufrn.controlers.AtualizarWidgets;
import br.ufrn.controlers.ConcreteAtualizarWidgets;
import br.ufrn.controlers.InstanciaWidget;
import javax.activation.MimeType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jorge
 */
@Path("monitoramento_ambiental")
public class WebServiceMonitoramentoAmbiental {
    
    private InstanciaWidget widget;
    private final AtualizarWidgets atualizarWidgets = new ConcreteAtualizarWidgets();
    
    private MonitorCidade monitorCidade = MonitorCidade.getInstance();

    /**
     * Creates a new instance of WebServiceMonitoramentoAmbiental
     */
    public WebServiceMonitoramentoAmbiental() {
        this.widget = new InstanciaWidget();
        monitorCidade.setVisible(true);
    }
    
    
//    @GET
//    @Path("/iniciar")
//    public String iniciar(){
//        monitorCidade.setVisible(true);
//        return "iniciando";
//    }

    //=====PollutionWidget=====
    @POST
    @Path("/atualizar_indice_poluicao/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarindicePoluicao(@PathParam("area") int area, int indexPolluition) {
        atualizarWidgets.atualizarIndicePoluicao(area, indexPolluition);
    }
    
    @POST
    @Path("/atualizar_fluxo_veiculos/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarFluxoDeVeiculos(@PathParam("area") int area, int vehicleFlow) {
        atualizarWidgets.atualizarFluxoDeVeiculos(area, vehicleFlow);
    }

    //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
    @POST
    @Path("/atualizar_velocidade_vento/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarVelociadeDoVento(@PathParam("area") int area, int windSpeed) {
        atualizarWidgets.atualizarVelociadeDoVento(area, windSpeed);
    }
    
    @POST
    @Path("/atualizar_direcao_vento/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizardirecaoDoVento(@PathParam("area") int area, String directionWind) {
        atualizarWidgets.atualizardirecaoDoVento(area, directionWind);
    }
    
    @POST
    @Path("/atualizar_probabilidade_chuva/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarProbalidadeChuva(@PathParam("area") int area, int willRain) {
        atualizarWidgets.atualizarProbalidadeChuva(area, willRain);
    }
    
    @POST
    @Path("/atualizar_quantidade_ruido/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarQuantidadeRuido(@PathParam("area") int area, int noise) {
        atualizarWidgets.atualizarQuantidadeRuido(area, noise);
    }

    //======TemperatureWidget=====
    @POST
    @Path("/atualizar_temperatura/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarTemeperatura(@PathParam("area") int area, int temperature) {
        atualizarWidgets.atualizarTemeperatura(area, temperature);
    }
    
    @POST
    @Path("/atualizar_humidade/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarHumidade(@PathParam("area") int area, int humidity) {
        atualizarWidgets.atualizarHumidade(area, humidity);
    }
    
    @POST
    @Path("/atualizar_incidencia_incendio/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarIncidenciaDeIncendio(@PathParam("area") int area, boolean isFire) {
        atualizarWidgets.atualizarIncidenciaDeIncendio(area, isFire);
    }

    //=====DumpWidget===
    @POST
    @Path("/atualizar_quantidade_lixo/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarQuantidadeLixo(@PathParam("area") int area, int trash) {
        atualizarWidgets.atualizarQuantidadeLixo(area, trash);
    }
    
    @POST
    @Path("/atualizar_agente_proximo/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarAgenteProximo(@PathParam("area") int area, String agentNearName) {
        atualizarWidgets.atualizarAgenteProximo(area, agentNearName);
    }
}

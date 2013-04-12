package br.ufrn.services;

import br.ufrn.GUI.MonitorCidade;
import br.ufrn.controlers.AtualizarDumpWidget;
import context.arch.enactor.Enactor;
import context.arch.enactor.EnactorXmlParser;
import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;


public class MonitoramentoLixeira implements AtualizarDumpWidget{
	
	protected Widget dumpIN;
	
	protected Widget informaOUT;

	protected Enactor enactorDump;
	
	protected InformaService informaService;
	

	public MonitoramentoLixeira(Integer area, MonitorCidade monitor) {
		
		//IN Widgets
		dumpIN = WidgetXmlParser.createWidget("Informa/dump-widget-input.xml");
		dumpIN.updateData("area", area);
		
		//OUT Widgets and Service
		informaOUT = WidgetXmlParser.createWidget("Informa/informa-widget-output.xml");
		informaService = new InformaService(informaOUT, monitor);
		informaOUT.addService(informaService);
		
		//Enactors
		enactorDump = EnactorXmlParser.createEnactor("Informa/dump-enactor.xml");

	}

    @Override
    public void atualizarQuantidadeLixo(Integer area, int trash) {
        dumpIN.updateData("trash", trash);
    }

    @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
        dumpIN.updateData("agentNearName", agentNearName);
    }
	
}
	
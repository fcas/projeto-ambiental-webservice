/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

//import br.ufrn.interfaces.AtualizacoesLixeira;
import br.ufrn.GUI.MonitorCidade;
import context.arch.comm.DataObject;
import context.arch.service.Service;
import context.arch.service.helper.FunctionDescription;
import context.arch.service.helper.FunctionDescriptions;
import context.arch.service.helper.ServiceInput;
import context.arch.widget.Widget;


public class InformaService extends Service {
    
    public static final String SERVICE = "informaService";
	
    public static final String POLLUTION = "pollutionMonitor";
    public static final String WILL_RAIN = "willRainMonitor";
    public static final String ACID_RAIN = "acidRainMonitor";
    public static final String NOISE = "noiseMonitor";
    public static final String TEMPERATURE = "temperatureMonitor";
    public static final String BEATIFUL_WEATHER = "beautifulWeatherMonitor";
    public static final String IS_FIRE = "isFireMonitor";
    public static final String HOT_DRY = "hotDryMonitor";
    public static final String TRASH = "trashMonitor";
    public static final String GATHERING = "trashGathering";
    
    private MonitorCidade cidade;
    
       
            @SuppressWarnings("serial")
            public InformaService(final Widget widget, MonitorCidade cidade) {
                    super(widget, SERVICE,
                                    new FunctionDescriptions() {
                            { // constructor
                                    // POLLUTION FUNCTIONS
                                    add(new FunctionDescription(
                                                    POLLUTION, 
                                                    "avisa sobre o nível de poluição.", 
                                                    widget.getNonConstantAttributes()));
                                    add(new FunctionDescription(
                                                    WILL_RAIN, 
                                                    "avisa sobre o nível de poluição.", 
                                                    widget.getNonConstantAttributes()));
                                    add(new FunctionDescription(
                                                    ACID_RAIN,
                                                    "avisa sobre possibilidade de chuva acida.",
                                                    widget.getNonConstantAttributes()));
                                   add(new FunctionDescription(
                                                    NOISE,
                                                    "avisa sobre barulhos muito altos em faixas de horários proibidos.",
                                                    widget.getNonConstantAttributes()));
                                   // TEMPERATURE FUNCTIONS
                                   add(new FunctionDescription(
                                                    TEMPERATURE,
                                                    "mostra a temperatura.",
                                                    widget.getNonConstantAttributes()));
                                   add(new FunctionDescription(
                                                    BEATIFUL_WEATHER,
                                                    "mostra a temperatura aparente (sensação térmica).",
                                                    widget.getNonConstantAttributes()));
                                   add(new FunctionDescription(
                                                    IS_FIRE,
                                                    "avisa se existe algum incêndios.",
                                                    widget.getNonConstantAttributes()));
                                   add(new FunctionDescription(
                                                    HOT_DRY,
                                                    "chama o service de coleta.",
                                                    widget.getNonConstantAttributes()));
                                   // DUMP FUNCTIONS
                                   add(new FunctionDescription(
                                                    TRASH,
                                                    "mostra o nível de lixo da lixeira e avisa quando a lixeira esta bem próxima de encher.",
                                                    widget.getNonConstantAttributes()));
                                   add(new FunctionDescription(
                                                    GATHERING,
                                                    "chama um agente de coleta mais próximo.",
                                                    widget.getNonConstantAttributes()));
                            }
                    });

                    this.cidade = cidade;

            }

            @Override
             public DataObject execute(ServiceInput serviceInput) {
                    
                    String functionName = serviceInput.getFunctionName();   
                    
                    String contextPollution = serviceInput.getInput().getAttributeValue("pollution");
                    System.out.println(contextPollution);
                    
                    String contextTemperature = serviceInput.getInput().getAttributeValue("temperature");
                    System.out.println(contextTemperature);
                    
                    String contextDump = serviceInput.getInput().getAttributeValue("dump");
                    System.out.println(contextDump);
                    
                    String valoresP[] = contextPollution.split(";");
                    String valoresT[] = contextTemperature.split(";");
                    String valoresD[] = contextDump.split(";");
                    /**
                     *POLLUTION FUNCTIONS
                     */
                                       
                    //Index Pollution
                    
                    if (functionName.equals(POLLUTION)) {
                        //String valores[] = contextPollution.split(";");
                        
                        if (valoresP[0].equals("TRAFEGO")) {
                            cidade.atualizaFluxoVeiculos(Integer.parseInt(valoresP[0]));
                        }else {
                            cidade.atualizaNivelPoluicao(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }
                            
                    }   
                   
                    //Will Rain
                    else if (functionName.equals(WILL_RAIN)) {
                        cidade.atualizaProbabilidaDeChuva(Integer.parseInt(valoresP[0]));
                    }
                    
                    //Acid Rain
                    else if (functionName.equals(ACID_RAIN)) {
                                                
                        if (valoresP[0].equals("AQUI")) {
                            cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }else if (valoresP[0].equals("OUTRO")) {
                            cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }
                    }
                    
                    //Noise
                    else if (functionName.equals(NOISE)) {
                          cidade.atualizaQuantidadeRuido(Integer.parseInt(valoresP[0]),Integer.parseInt(valoresP[2]));                  
                    }
                    
                    /**
                     *TEMPERATURE FUNCTIONS
                     */      
                    
                    // Temperature
                    else if (functionName.equals(TEMPERATURE)) {
                        cidade.atualizaTemperatura(Integer.parseInt(valoresP[0]), Float.parseFloat(valoresP[2]));
                    }
                    
                    // beautiful Weather
                    else if (functionName.equals(BEATIFUL_WEATHER)) {
                        cidade.atualizaClimaBom(Integer.parseInt(valoresP[0]), true);                       
                    }
                    
                    //is fire?
                    else if (functionName.equals(IS_FIRE)) {
                        cidade.atualizaIncidenciaDeIncendio(Integer.parseInt(valoresP[0]), true); 
                    }
                    
                    // Hot and dry weather
                    else if (functionName.equals(HOT_DRY)) {
                        cidade.atualizaClimaQuenteESeco(Integer.parseInt(valoresP[0]), true); 
                    }
                    
                    /**
                     *DUMP FUNCTIONS
                     */      
                    
                    // Dump situation
                    
                    else if (functionName.equals(TRASH)) {
                                               
                        if (valoresD[0].equals("VAZIA")) {
                            cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresP[0]),valoresP[2]);   
                        }else if (valoresD[0].equals("ENCHENDO")) {
                            cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresP[0]),valoresP[2]);   
                        }else if (valoresD[0].equals("CHEIA")) {
                            cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresP[0]),valoresP[2]);   
                        }                       
                    }
                    // alerts you when is borderline calls and agent catcher.
                    else if (functionName.equals(GATHERING)) {
                                                
                        if (valoresD[0].equals("LIMITE")) {
                            cidade.atualizaAgenteProximo(Integer.parseInt(valoresP[0]),valoresP[2]); 
                        }else if (valoresD[0].equals("CHEIA")) {
                            cidade.atualizaAgenteProximo(Integer.parseInt(valoresP[0]),valoresP[3]); 
                        }                                             
                    }
                    
                    return null;

            }
}


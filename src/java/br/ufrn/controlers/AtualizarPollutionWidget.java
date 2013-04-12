/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

/**
 *
 * @author Jorge
 */
public interface AtualizarPollutionWidget {
    
    
    public void atualizarIndicePoluicao(Integer area, int indexPolluition);
    
    public void atualizarFluxoDeVeiculos(Integer area, int vehicleFlow);
    
    //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
    public void atualizarVelociadeDoVento(Integer area, int windSpeed);
    
    public void atualizardirecaoDoVento(Integer area, String directionWind);
    
    public void atualizarProbalidadeChuva( Integer area, int willRain);
    
    public void atualizarQuantidadeRuido( Integer area, int noise);
    
}

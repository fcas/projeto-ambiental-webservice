/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

/**
 *
 * @author Jorge
 */
public interface AtualizarTemperatureWidget {
    
    public void atualizarTemeperatura(Integer area, int temperature);
    
    public void atualizarHumidade( Integer area, int humidity);
    
    public void atualizarIncidenciaDeIncendio( Integer area, boolean isFire);
    
    public void atualizarVelociadeDoVento(Integer area, int windSpeed);
}

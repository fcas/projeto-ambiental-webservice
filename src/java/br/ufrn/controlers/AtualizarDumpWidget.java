/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

/**
 *
 * @author Jorge
 */
public interface AtualizarDumpWidget {
    
    public void atualizarQuantidadeLixo( Integer area, int trash);
    
    public void atualizarAgenteProximo( Integer area, String agentNearName);
    
}

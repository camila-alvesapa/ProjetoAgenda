/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacontatos;

/**
 *
 * @author camil
 */
public class ContatoNaoExisteException extends Exception {
    
    public String getMessage(){
        return "Contato não existe";
    }
    
}

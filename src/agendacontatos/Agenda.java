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
public class Agenda {
    
    private Contato[] ref = new Contato[5];
        
    public void adicionarContato(Contato novo) throws AgendaCheiaException{
        boolean cheia = true;
        for (int aux = 0; aux<ref.length; aux++){
            if(ref[aux] == null){
                ref[aux] = novo;
                aux++;
                cheia = false;
            }
        }
        if (cheia){
            throw new AgendaCheiaException();
        }
    }
    
    public boolean consultarContato (String nome) throws ContatoNaoExisteException{
       boolean resposta = true;
       for(int aux = 0; aux < ref.length; aux++){
           if (ref[aux] != null){
                if(ref[aux].getNome().equals(nome)){
                    String resp =  "Contato existente: \n Nome: ";
                    resposta = false;
                } 
            }
        }
       if (resposta){
           throw new ContatoNaoExisteException();
       }
       
       return resposta;
       
    }   
    
}

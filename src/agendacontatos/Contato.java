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
public class Contato {
    
    private String nome;
    private String telefone;
    private int id;
    static private int aux = 100;

    public Contato() {
        this.id = aux;
        aux++;
        
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

       
}

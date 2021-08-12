package agendacontatos;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camil
 */
public class AgendaContatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        String escolha = "CONSULTAR";
        
        /**
         * Laço que vai permitir fazer mais escolhas de adicionar e consultar
         */
        while (!escolha.equals("SAIR")){
            escolha = escolhaOpcao(teclado);
            
            if(escolha.equals("CONSULTAR")){
                consultaDeContato(teclado, agenda);
            } else if (escolha.equals("ADICIONAR")){
                adicaoDeContato(teclado, agenda);
            }
        }
    }
    
    /**
     * @param teclado
     * @param agenda 
     */
    public static void consultaDeContato(Scanner teclado, Agenda agenda){
        System.out.println("Consultando um contato na agenda: ");
        String nomeContato = lerInformacao(teclado, "Digite o nome do contato que deseja consultar: ");
        
        //tratando excessão caso o contato digitado pelo usuário não exista
        try {
            if(agenda.consultarContato(nomeContato) == false){
                System.out.println("Contato existe na agenda");
            }
        } catch (ContatoNaoExisteException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    /**
     * 
     * @param teclado
     * @param agenda 
     */
    public static void adicaoDeContato(Scanner teclado, Agenda agenda){
        System.out.println("Adicionando um contato na agenda: ");
        
        String nomeContato = lerInformacao(teclado, "Digite o nome do contato: ");
        String telefoneContato = lerInformacao(teclado, "Digite o telefone do contato: ");
        
        Contato contato = new Contato();//instanciando um novo contato
        
        contato.setNome(nomeContato);//setando o nome do contato criado
        contato.setTelefone(telefoneContato);//setando telefone do contato criado
        
        //Tratando uma excessão caso a agenda já esteja cheia e não é possível adicionar contato
        try {
            agenda.adicionarContato(contato);
        } catch (AgendaCheiaException exception) {
            System.out.println(exception.getMessage());
        }
        
    }
    
    /**
     * 
     * @param teclado
     * @param mensagem
     * @return 
     */
    public static String lerInformacao(Scanner teclado, String mensagem){
        System.out.println(mensagem);
        String entrada = teclado.nextLine();
        return entrada;
    }
    
    /**
     * 
     * @param teclado
     * @return 
     */
    public static String escolhaOpcao(Scanner teclado){
            
        boolean entradaCerta = false;
        String escolha = "SAIR";
        
        
        while (entradaCerta != true){
            System.out.println("Digite a opção que deseja: Adicionar, Consultar ou Sair: ");
            String aux = teclado.nextLine();            
            try {
                
                escolha = aux.toUpperCase();
                
                if (escolha.equals("ADICIONAR") || escolha.equals("CONSULTAR") || escolha.equals("SAIR")){
                    entradaCerta = true;
                } else {
                    throw new Exception("Escolha Inválida.");
                }
            } 
            catch (Exception exception){
                System.out.println("Escolha inválida, digite novamente.");
            }
        }   
            return escolha;
    }
}

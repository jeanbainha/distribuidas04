import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

// Classe remota para o exemplo "Fatorial, world!"
public class Jogo extends UnicastRemoteObject implements JogoInterface {
	private static final long serialVersionUID = 7896726845928782847L;

	ArrayList <JogadorInterface> listaJogadores = new ArrayList <JogadorInterface> ();
	// Constroi um objeto remoto armazenando nele o int recebido
	public Jogo() throws RemoteException {
	}

	// Implementa o metodo invocavel remotamente, que retorna a mensagem armazenada no objeto
	public int registra(JogadorInterface jogador) throws RemoteException {
	    System.out.println("chegou");
	    this.listaJogadores.add(jogador);
	    return this.listaJogadores.size();
	}
}


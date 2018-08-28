import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Classe remota para o exemplo "Hello, world!"
public class Jogador extends UnicastRemoteObject implements JogadorInterface {
	private static final long serialVersionUID = 7895385898928783746L;
	private String nome;

	public Jogador() throws RemoteException {
		
	}
	
}


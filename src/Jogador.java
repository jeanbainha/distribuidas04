import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Classe remota para o exemplo "Hello, world!"
public class Jogador extends UnicastRemoteObject implements JogadorInterface {
	private static final long serialVersionUID = 7895385898928783746L;
	private String nome;
	private int id;

	
	public Jogador(String nome) throws RemoteException {	
		this.nome = nome;
	}
	//seta id do jogador
	public void setId(int id) throws RemoteException {
		this.id = id;
	}
	//imprime na tela a mensagem
	public void encerrado() throws RemoteException{
		System.out.println("voce com id = " + id + " foi retirado do jogo");
	}
}


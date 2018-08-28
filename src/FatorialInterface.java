import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface remota para o exemplo "Hello, world!"
public interface FatorialInterface extends Remote {
	// Metodo invocavel remotamente que retorna a mensagem do objeto remoto
	public int fatorial(int n) throws RemoteException;
}


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Classe remota para o exemplo "Fatorial, world!"
public class Fatorial extends UnicastRemoteObject implements FatorialInterface {
	private static final long serialVersionUID = 7896795898928782847L;

	// Constroi um objeto remoto armazenando nele o int recebido
	public Fatorial() throws RemoteException {
	}

	// Implementa o metodo invocavel remotamente, que retorna a mensagem armazenada no objeto
	public int fatorial(int n) throws RemoteException {
	    if(n <= 1)
         return 1;
        return fatorial(n-1) * n;
	}
}


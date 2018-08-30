import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;;

public interface JogoInterface extends Remote {
	public int registra(JogadorInterface jogador) throws RemoteException;
	public int joga(int id) throws RemoteException;
	public int encerra(int id) throws RemoteException;
	public ArrayList<Long> retornaListaDeTempos() throws RemoteException;
	public ArrayList<JogadorInterface> retornaListaDeJogadores() throws RemoteException;
}

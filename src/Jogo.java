import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Timer;

public class Jogo extends UnicastRemoteObject implements JogoInterface {
	private static final long serialVersionUID = 7896726845928782847L;

	ArrayList <JogadorInterface> listaJogadores = new ArrayList <JogadorInterface> ();
	ArrayList <Long> temposJogadores = new ArrayList <Long> ();
	public Jogo() throws RemoteException {
	}

	public int registra(JogadorInterface jogador) throws RemoteException {
	    this.listaJogadores.add(jogador);
	    jogador.setId(listaJogadores.size()-1);
	    long tempo = (long) System.currentTimeMillis();
	    this.temposJogadores.add(tempo);
	    return this.listaJogadores.size()-1;
	}
	//set o tempo do jogador na posicao id como atual
	public int joga(int id) throws RemoteException{
		this.temposJogadores.set(id, (long) System.currentTimeMillis());
		return 1;
	}
	//seta o jogador como null
	public int encerra(int id) throws RemoteException{
		this.listaJogadores.set(id, null);
		System.out.println(listaJogadores);
		return 0;
	}
	//Retorna a lista de tempos
	public ArrayList<Long> retornaListaDeTempos() throws RemoteException{
		return this.temposJogadores;
	}
	//Retorna a lista de jogadores
	public ArrayList<JogadorInterface> retornaListaDeJogadores() throws RemoteException{
		return this.listaJogadores;
	}
}


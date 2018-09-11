import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

class HelloServer {
	// Programa servidor para o exemplo "Hello, World!"
	public static void main (String[] argv) {
		try {
			//System.setProperty("java.rmi.server.hostname", "10.32.169.18");
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");			
		} catch (RemoteException e) {
			System.out.println("RMI registry already running.");			
		}
		try {
			Naming.rebind ("Jogo", new Jogo());		
			JogoInterface hello = (JogoInterface) Naming.lookup ("//localhost/Jogo");
			//Cria o metodo da thread que ficara percorrendo a lista a cada 10 segundos vendo quem ja passou de 60000 milisegundos sem jogar
			//Não sei como tirar ele de dentro do main!!!!!
			Runnable r1 = new Runnable() {
				  public void run() {
					  try {
						  while (true) {
							  ArrayList<Long> tempos = hello.retornaListaDeTempos();
							  ArrayList<JogadorInterface> jogadores = hello.retornaListaDeJogadores();
							  for(int i = 0;i<tempos.size();i++) {
								  if(jogadores.get(i)!=null) {
									  if (tempos.get(i)<(long) System.currentTimeMillis()-60000) {	
										  //bota na lista o jogador como null e manda mensagem que ele foi retirado do jogo
										  hello.encerra(i);
										  jogadores.get(i).encerrado();
									  }
								  }
							  }
							  Thread.sleep(1000);
						  }
					  } catch (InterruptedException iex) {} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
			};
			Thread thr1 = new Thread(r1);
			thr1.start();
		} catch (Exception e) {
			System.out.println ("Server failed:");
			e.printStackTrace();
		}
	}
}


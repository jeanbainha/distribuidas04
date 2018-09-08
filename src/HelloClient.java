import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

class HelloClient {	
	// Programa cliente para o exemplo "Hello, world!"
	public static void main (String[] argv) {
		try {			
			JogoInterface jogoInterface = (JogoInterface) Naming.lookup ("//localhost/Jogo");
			//Cria o metodo da thread que ficara percorrendo a lista a cada 10 segundos
			//vendo quem ja passou de 60000 milisegundos sem jogar

			Runnable r1 = new Runnable() {
				  public void run() {
					  try {
						  while (true) {
							  ArrayList<Long> tempos = jogoInterface.retornaListaDeTempos();
							  ArrayList<JogadorInterface> jogadores = jogoInterface.retornaListaDeJogadores();
							  for(int i = 0;i<tempos.size();i++) {
								  if(jogadores.get(i)!=null) {
									  if (tempos.get(i)<(long) System.currentTimeMillis()-60000) {	
										  //bota na lista o jogador como null e manda mensagem
										  //que ele foi retirado do jogo
										  jogoInterface.encerra(i);
										  jogadores.get(i).encerrado();
									  }
								  }
							  }
							  Thread.sleep(5000);
						  }
					  } catch (InterruptedException iex) {} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  }
			};
			//testes manuais: inicia dois jogadores, joga apenas com 1 e ve eles saido
			//da lista de jogadores atuais em ordem
			JogadorInterface jogador = new Jogador("adan");
			System.out.println (jogoInterface.registra(jogador));
			
			Thread thr1 = new Thread(r1);
			thr1.start();
			
			JogadorInterface jogador2 = new Jogador("Maria");
			System.out.println (jogoInterface.registra(jogador2));
			
			System.out.println(jogoInterface.joga(0));	
			Thread.sleep(10000);
			System.out.println(jogoInterface.joga(0));	
			Thread.sleep(10000);
			System.out.println(jogoInterface.joga(0));	
			Thread.sleep(10000);
			
			//Aguarda os 2 jogadores serem desconectados
		} catch (Exception e) {
			System.out.println ("HelloClient failed:");
			e.printStackTrace();
		}
	}
	
}


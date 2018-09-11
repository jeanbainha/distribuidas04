import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

class HelloClient {	
	// Programa cliente para o exemplo "Hello, world!"
	public static void main (String[] argv) {
		try {//10.32.169.54			
			JogoInterface helloClient = (JogoInterface) Naming.lookup ("//localhost/Jogo");
			
			//testes manuais inicia dois jogadores, joga apenas com 1 e ve eles saido da lista de jogadores atuais em ordem
			JogadorInterface jogador = new Jogador("adan");
			System.out.println (helloClient.registra(jogador));
			
			JogadorInterface jogador2 = new Jogador("Maria");
			System.out.println (helloClient.registra(jogador2));
			System.out.println("Jogador com id = "+ helloClient.joga(0) + " jogou");	
			Thread.sleep(10000);
			System.out.println("Jogador com id = "+ helloClient.joga(0) + " jogou");	
			Thread.sleep(10000);
			System.out.println("Jogador com id = "+ helloClient.joga(0) + " jogou");	
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println ("HelloClient failed:");
			e.printStackTrace();
		}
	}
	
}


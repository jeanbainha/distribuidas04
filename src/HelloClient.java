import java.rmi.Naming;

class HelloClient {	
	// Programa cliente para o exemplo "Hello, world!"
	public static void main (String[] argv) {
		try {//10.32.169.54
			JogoInterface hello = (JogoInterface) Naming.lookup ("//localhost/Jogo");
			JogadorInterface jogador = new Jogador();
			System.out.println (hello.registra(jogador));
		} catch (Exception e) {
			System.out.println ("HelloClient failed:");
			e.printStackTrace();
		}
	}
}


import java.rmi.Naming;
import java.rmi.RemoteException;

class HelloServer {
	// Programa servidor para o exemplo "Hello, World!"
	public static void main (String[] argv) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");			
		} catch (RemoteException e) {
			System.out.println("RMI registry already running.");			
		}
		
		try {
			Naming.rebind ("Jogo", new Jogo());			
			System.out.println ("Jogo is ready.");
		} catch (Exception e) {
			System.out.println ("Jogo server failed:");
			e.printStackTrace();
		}
	}
}


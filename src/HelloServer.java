import java.rmi.Naming;
import java.rmi.RemoteException;

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
			//Naming.rebind ("Hello", new Hello ("Hello, world!"));
			//System.out.println ("HelloServer is ready.");
			//Naming.rebind ("Fatorial", new Fatorial ());
			Naming.rebind ("Jogo", new Jogo());			
			System.out.println ("Fatorial is ready.");
		} catch (Exception e) {
			//System.out.println ("HelloServer failed:");
			System.out.println ("Fatorial failed:");
			e.printStackTrace();
		}
	}
}


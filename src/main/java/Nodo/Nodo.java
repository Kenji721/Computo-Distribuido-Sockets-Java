package Nodo;

/**
 *
 * @author Sebastian Godinez Borja
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Nodo {
    private static final int PORT = 31010;
    // Mapa para guardar las conexiones de los clientes
    private Map<Integer, Socket> clientConnections = new HashMap<>();
    private int clientIdCounter = 0;

    public static void main(String[] args) {
        new Nodo().startServer();
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Nodo iniciado en el puerto " + PORT);
            // Bucle infinito para aceptar conexiones de clientes
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Espera una conexión
                clientIdCounter++;
                // Almacena la conexión en el Map con un ID único
                clientConnections.put(clientIdCounter, clientSocket);
                System.out.println("Cliente " + clientIdCounter + " conectado desde " +
                                   clientSocket.getInetAddress().getHostAddress());
                
                // Envía un mensaje de bienvenida al cliente
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Bienvenido al Nodo!");

                // Si se requiere mantener la conexión para futuros intercambios, se puede dejar abierta.
                // De lo contrario, para este ejemplo se cierra la conexión:
                // clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

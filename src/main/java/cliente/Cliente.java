/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

/**
 *
 * @author minemurakenji
 */
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Cliente {
    private static final String SERVER_IP = "localhost"; // Cambiar a la IP del servidor si es necesario
    private static final int SERVER_PORT = 31010;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // Recibe y muestra el mensaje de bienvenida del Nodo
            String mensajeBienvenida = in.readLine();
            System.out.println("Mensaje recibido: " + mensajeBienvenida);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


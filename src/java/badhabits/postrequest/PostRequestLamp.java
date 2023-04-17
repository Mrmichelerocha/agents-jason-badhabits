package badhabits.postrequest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestLamp {
	
    public void PostRequestLampOn() throws IOException {
        // URL do servidor ESP8266
        URL url = new URL("http://192.168.0.105/relay");

        // Cria uma conex�o HTTP
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Define o m�todo HTTP como POST
        con.setRequestMethod("POST");

        // Habilita a escrita no corpo da requisi��o
        con.setDoOutput(true);

        // Define o corpo da requisi��o (nesse exemplo, o valor "on" para ligar o rel�)
        String requestBody = "relay=1";

        // Define o tipo do conte�do da requisi��o (neste caso, form-urlencoded)
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Converte o corpo da requisi��o para um array de bytes e envia para o servidor
        OutputStream os = con.getOutputStream();
        byte[] input = requestBody.getBytes("utf-8");
        os.write(input, 0, input.length);

        // L� a resposta do servidor
        int statusCode = con.getResponseCode();

        // Exibe a resposta do servidor
        if (statusCode == 200) {
            System.out.println("Requisi��o bem sucedida!");
        } else {
            System.out.println("Erro ao realizar requisi��o. Status code: " + statusCode);
        }

        // Fecha a conex�o
        con.disconnect();
    }
    
    public void PostRequestLampOff() throws IOException {
        // URL do servidor ESP8266
        URL url = new URL("http://192.168.0.105/relay");

        // Cria uma conex�o HTTP
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Define o m�todo HTTP como POST
        con.setRequestMethod("POST");

        // Habilita a escrita no corpo da requisi��o
        con.setDoOutput(true);

        // Define o corpo da requisi��o (nesse exemplo, o valor "on" para ligar o rel�)
        String requestBody = "relay=0";

        // Define o tipo do conte�do da requisi��o (neste caso, form-urlencoded)
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Converte o corpo da requisi��o para um array de bytes e envia para o servidor
        OutputStream os = con.getOutputStream();
        byte[] input = requestBody.getBytes("utf-8");
        os.write(input, 0, input.length);

        // L� a resposta do servidor
        int statusCode = con.getResponseCode();

        // Exibe a resposta do servidor
        if (statusCode == 200) {
            System.out.println("Requisi��o bem sucedida!");
        } else {
            System.out.println("Erro ao realizar requisi��o. Status code: " + statusCode);
        }

        // Fecha a conex�o
        con.disconnect();
    }
}
package badhabits.postrequest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestLamp {
	
    public void PostRequestLampOn() throws IOException {
        // URL do servidor ESP8266
        URL url = new URL("http://192.168.0.105/relay");

        // Cria uma conexão HTTP
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Define o método HTTP como POST
        con.setRequestMethod("POST");

        // Habilita a escrita no corpo da requisição
        con.setDoOutput(true);

        // Define o corpo da requisição (nesse exemplo, o valor "on" para ligar o relé)
        String requestBody = "relay=1";

        // Define o tipo do conteúdo da requisição (neste caso, form-urlencoded)
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Converte o corpo da requisição para um array de bytes e envia para o servidor
        OutputStream os = con.getOutputStream();
        byte[] input = requestBody.getBytes("utf-8");
        os.write(input, 0, input.length);

        // Lê a resposta do servidor
        int statusCode = con.getResponseCode();

        // Exibe a resposta do servidor
        if (statusCode == 200) {
            System.out.println("Requisição bem sucedida!");
        } else {
            System.out.println("Erro ao realizar requisição. Status code: " + statusCode);
        }

        // Fecha a conexão
        con.disconnect();
    }
    
    public void PostRequestLampOff() throws IOException {
        // URL do servidor ESP8266
        URL url = new URL("http://192.168.0.105/relay");

        // Cria uma conexão HTTP
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Define o método HTTP como POST
        con.setRequestMethod("POST");

        // Habilita a escrita no corpo da requisição
        con.setDoOutput(true);

        // Define o corpo da requisição (nesse exemplo, o valor "on" para ligar o relé)
        String requestBody = "relay=0";

        // Define o tipo do conteúdo da requisição (neste caso, form-urlencoded)
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Converte o corpo da requisição para um array de bytes e envia para o servidor
        OutputStream os = con.getOutputStream();
        byte[] input = requestBody.getBytes("utf-8");
        os.write(input, 0, input.length);

        // Lê a resposta do servidor
        int statusCode = con.getResponseCode();

        // Exibe a resposta do servidor
        if (statusCode == 200) {
            System.out.println("Requisição bem sucedida!");
        } else {
            System.out.println("Erro ao realizar requisição. Status code: " + statusCode);
        }

        // Fecha a conexão
        con.disconnect();
    }
}
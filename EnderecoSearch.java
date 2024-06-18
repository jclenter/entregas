import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EnderecoSearch {

    public static String buscarEndereco(String cep) throws IOException {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpURLConnection connection = null;
        StringBuilder response = new StringBuilder();

        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }
}

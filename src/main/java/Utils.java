import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;

public class Utils {

    public static String getImageUrl(String nasaUrl) {

        CloseableHttpClient client = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        HttpGet request = new HttpGet(nasaUrl);

        String imageUrl = "";
        try {
            CloseableHttpResponse response = client.execute(request);
            NasaAnswer answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer.class);
            imageUrl = answer.url;
        } catch (IOException exception) {
            System.out.println("Произошла ошибка");
        }
        return imageUrl;
    }
}

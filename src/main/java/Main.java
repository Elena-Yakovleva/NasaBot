
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, TelegramApiException { // throws IOException - при отсутствии связи с сервером программа падает по выбору программиста

        new MyNasaBot("Js_test_nasa_bot",
                      "7978537749:AAEF2F6N5lKAXR7HLyTp_ab7ZKb-fDt48ac");
        }


    // String url = "https://api.nasa.gov/planetary/apod?api_key=v7Vy2F4zSg4YzpuySpsT9tdlfUjaCjjgCyJLgMAg" +
    //               "&date=2024-11-28";
// 1. создание закрытого клиента с переменной client с клиентом настроенным по умолчанию (.createDefault())
//  CloseableHttpClient client = HttpClients.createDefault();
//
// 2. создание запроса GET с переменной request  на адрес сервера
//  HttpGet request = new HttpGet(url);
//
// 3. клиент выполняет (execute) запрос(request)  и сохраняет Закрытый http отзыв в переменную отзыв(response)
//  CloseableHttpResponse response = client.execute(request);
//
// 4. scanner забирает часть информации из отзыва с параметрами (отзыв.получитьИдентификатор().получитьСодердание())
//  Scanner scanner = new Scanner(response.getEntity().getContent());

// 5. в сканере хранится отзыв с выбранными параметрами
// 6. для вывода ответа сохраняем информацию  в переменной типа строка с названием ответ(answer)
//  String answer = scanner.nextLine();

// 7. выводим ответ на экран
//  System.out.println(answer);
// 8. после вывода ответа сканер закомментируем, так как больше одного раза запрос не прочтется


// 9. копируем ответ из консоли и сохраняем в отдельный файл с названием answer.json
// 10. переводим ответ в формат понятный java. для этого создаем специальный класс NasaAnswer.java
// 11. создаем объект, который может преобразовать данные из json в java
//  ObjectMapper mapper = new ObjectMapper();
//
// 12. создает объект NasaAnswer c методом mapper.readValue  принимает какие данные надо преобразовать и к какому классу их надо преобразовать (NasaAnswer.class)
//  NasaAnswer answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer.class);
//
// 13. проверим вывод данных в консли.
//  System.out.println(answer.url);
//  System.out.println(answer.title);
//
// 14. для скачивания картинки cоздаем строку с адресом картинки
//  String imageUrl = answer.url;

// 15. разбиваем адрес картинки на части для использования его части в качестве названия картинки
//     тем самым создавая массив и сохраняем его в массив строк []
//  String[] splittedAnswer = imageUrl.split("/");

// 16. затем присваиваем переменную с этой информацией и сохраняем ее в папку
//  String filename = "Image/" + splittedAnswer[splittedAnswer.length - 1];
//
// 16. создаем GET запрос
//  HttpGet imageRequest = new HttpGet(imageUrl);

// 17. клиент выполняет (execute) запрос(imageRequest)  и сохраняет Закрытый http отзыв в переменную image
//  CloseableHttpResponse image = client.execute(imageRequest);
//
// 18. сохраняем полученную картинку на компьютере через метод
//  FileOutputStream fos = new FileOutputStream(filename);
//  image.getEntity().writeTo(fos);
//
// 19. создаем бота в телеграмм-боте BotFather
// 20. подключаем зависимость telegrambots в pom.xml
// 21. создаем новый java файл MyNasaBot, в котором прописываем Класс TelegramLongPollingBot
// 22. и необходимые методы: https://github.com/rubenlagus/TelegramBots/blob/aad139de980ae25ee7a4b06bbe7644c6077421ce/TelegramBots.wiki/Getting-Started.md
// 23. создаем класс Utils в котором будет находится метод для получения ссылки на сервере Наса на картинку дня
//

}
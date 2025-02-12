import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.Serializable;

public class MyNasaBot extends TelegramLongPollingBot {

    private final String BOT_NAME;
    private final String BOT_TOKEN;

    private final String url = "https://api.nasa.gov/planetary/apod" +
                 "?api_key=v7Vy2F4zSg4YzpuySpsT9tdlfUjaCjjgCyJLgMAg";

    public MyNasaBot(String BOT_NAME, String BOT_TOKEN) throws TelegramApiException {

        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot (this);
    }

    // Этот метод ожидает того, пока пользователь не напишет боту, прочитает сообщение и выведет текст
    @Override
    public void onUpdateReceived(Update update) {
        // Проверяет есть ли у апдейта сообщение и есть ли в сообщении тект
        if (update.hasMessage() && update.getMessage().hasText()) {
            // читает информацию
            long chatId = update.getMessage().getChatId();
            String answer = update.getMessage().getText();
            String[] separatedAnswer = answer.split(" ");
            String action = separatedAnswer[0];
            // создает ответ в зависимотси от запроса
            switch (action) {
                case "/start":
                    sendMessage("Привет, я бот Наса, я присылаю картинку дня.",chatId);
                    break;

                case "/help":
                    sendMessage("Введите команду /image для получения картинки дня или /date  в формате гггг-мм-дд для получения картинки за любую дату", chatId);
                    break;

                case "/image":
                    String image = Utils.getImageUrl(url);
                    sendMessage(image, chatId);
                    break;

                case "/date":
                    image = Utils.getImageUrl(url + "&date=" + separatedAnswer[1]);
                    sendMessage(image, chatId);
                    break;

                default:
                    sendMessage("Я не знаю такой команды", chatId);
            }

        }
    }
    // метод который создает ответ
    private void sendMessage(String text, long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    // Этот метод должен всегда возвращать ваше имя бота пользователю
    @Override
    public String getBotUsername() {

        return BOT_NAME;
    }

    // Этот метод должен всегда возвращать ваш токен бота
    @Override
    public String getBotToken() {

        return BOT_TOKEN;
    }

}

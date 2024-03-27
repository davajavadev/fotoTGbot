import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FotoBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        List<PhotoSize> photos = update.getMessage().getPhoto();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Mehrigiyo"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("QarDu - 1 "));
        keyboardRow2.add(new KeyboardButton("QarDu - 2 "));

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(new KeyboardButton("GrGu - 1"));
        keyboardRow3.add(new KeyboardButton("GrGu - 2 "));
        keyboardRow3.add(new KeyboardButton("GrGu - 2.5"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);
        list.add(keyboardRow3);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);


        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();
        switch (update.getMessage().getText()){
            case "Mehrigiyo" :
               sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMJZgFOfCgnVLoSRhuF9c3vU9wBcJ0AAubYMRsViBFI-nsevMOsXs4BAAMCAAN5AAM0BA"));
                        break;
            case "QarDu - 1" :
                sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMLZgFO3rpLtg0I8VsoMKOj2mkNn98AAujYMRsViBFIcOOERBc3FWgBAAMCAAN4AAM0BA"));
                break;
            case "QarDu - 2" :
                sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMNZgFPksPE80DW6XcFnOZLV8tAu9gAAuvYMRsViBFIEQuqxJx3U8wBAAMCAAN5AAM0BA"));
                break;
            case "GrGu - 1" :
                sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMPZgFPuXvqH5qz9JHyW4Co25sr3LQAAu7YMRsViBFIFW6rVXwgGjwBAAMCAAN5AAM0BA"));
                break;
            case "GrGu - 2 ":
                sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMRZgFP3o0HtFXhoZ48CwhDghKTwHgAAu_YMRsViBFIehHGSvFNGGcBAAMCAAN5AAM0BA"));
                break;
            case "GrGu - 2.5" :
                sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMTZgFQHGQIqOgQ65q6kBspLezj1kwAAu_YMRsViBFIehHGSvFNGGcBAAMCAAN5AAM0BA"));
                break;
        }

      /* // String id = photos.stream().sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                //.findFirst().orElse(null).getFileId();
       // sendMessage.setText(id);

       */
        try {
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }



        try {
            execute(sendPhoto);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }


    }
    @Override
    public String getBotToken(){
        return "6515655976:AAGeHDx7sXg0GFplEInMQh0U3Wn3XdfyXjI";
    }

    // Mehrigiyo - AgACAgIAAxkBAAMJZgFOfCgnVLoSRhuF9c3vU9wBcJ0AAubYMRsViBFI-nsevMOsXs4BAAMCAAN5AAM0BA
    //Qardu - AgACAgIAAxkBAAMLZgFO3rpLtg0I8VsoMKOj2mkNn98AAujYMRsViBFIcOOERBc3FWgBAAMCAAN4AAM0BA
    //Qardu2 - AgACAgIAAxkBAAMNZgFPksPE80DW6XcFnOZLV8tAu9gAAuvYMRsViBFIEQuqxJx3U8wBAAMCAAN5AAM0BA
    //Grgu - AgACAgIAAxkBAAMPZgFPuXvqH5qz9JHyW4Co25sr3LQAAu7YMRsViBFIFW6rVXwgGjwBAAMCAAN5AAM0BA
    //Grgu2 - AgACAgIAAxkBAAMRZgFP3o0HtFXhoZ48CwhDghKTwHgAAu_YMRsViBFIehHGSvFNGGcBAAMCAAN5AAM0BA
    //Grgu2.5 - AgACAgIAAxkBAAMTZgFQHGQIqOgQ65q6kBspLezj1kwAAu_YMRsViBFIehHGSvFNGGcBAAMCAAN5AAM0BA
    @Override
    public String getBotUsername() {
        return "davlat_rasm_bot";
    }
}

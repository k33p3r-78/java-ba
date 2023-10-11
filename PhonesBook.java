import java.util.HashMap;
import java.util.Scanner;

public class PhonesBook {
    public static void main(String[] args) {
        System.out.println("Введите имя и номер телефона через пробел.\n" +
                            "Если номеров несколько, введите их через запятую.\n" +
                            "Для выхода введите 'q'.");
        HashMap<String, String> phonesBase = new HashMap<String, String>();
        Scanner inputStream = new Scanner(System.in);
        String userInput = "";
        
        while (true) {
            userInput = inputStream.nextLine();
            userInput = userInput.substring(0, 1).toUpperCase() +
                            userInput.substring(1).toLowerCase();
            if (userInput.split(" ").length != 2) {
                if (userInput.equalsIgnoreCase("q")){ break; }
                System.out.println("Некорректные данные, повторите попытку.");
            }

        }

        inputStream.close();
    }
}

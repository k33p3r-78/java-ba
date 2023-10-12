import java.util.HashMap;
import java.util.Scanner;

public class PhonesBook {

    public static void main(String[] args) {
        System.out.println("Введите имя и номер телефона через двоеточие.\n" +
                            "Для выхода введите 'q'.");
        HashMap<String, String> phonesBase = new HashMap<String, String>();
        Scanner inputStream = new Scanner(System.in);
        String userInput = "";
        
        while (true) {
            userInput = inputStream.nextLine();
            userInput = userInput.substring(0, 1).toUpperCase() +
                            userInput.substring(1).toLowerCase();
            if (userInput.split(":").length != 2) {
                if (userInput.equalsIgnoreCase("q")){ break; }
                System.out.println("Некорректные данные, повторите попытку.");
            }

            String contactName = userInput.split(":")[0];
            String contactPhone = userInput.split(":")[1];

            if (phonesBase.containsKey(contactName)) {
                String resPhones = phonesBase.get(contactName) + ", " + contactPhone;
                phonesBase.put(contactName, resPhones);
                System.out.println("Номер успешно добавлен к существующему контакту.");
            } else {
                phonesBase.put(contactName, contactPhone);
                System.out.println("Контакт успешно добавлен.");
            }
        }

        for (String i : phonesBase.keySet()) {
            System.out.println(i + ": " + phonesBase.get(i));
        }

        inputStream.close();
    }
}

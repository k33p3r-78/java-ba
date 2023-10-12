import java.util.HashMap;
// import java.util.List;
import java.util.Scanner;
// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Collections;;

public class PhonesBook {

    // private static <T> T[] MergeArrays(T[] firstArray, T[] secondArray) {
    //     List<T> resArray = new ArrayList<>(firstArray.length + secondArray.length);
    //     Collections.addAll(resArray, firstArray);
    //     Collections.addAll(resArray, secondArray);
    //     @SuppressWarnings("unchecked")
    //     T[] typeOfArray = (T[]) Array.newInstance(firstArray.getClass().componentType(), 0);
    //     return resArray.toArray(typeOfArray);
    // }

    public static void main(String[] args) {
        System.out.println("Введите имя и номер телефона через двоеточие.\n" +
                            // "Если номеров несколько, введите их через запятую.\n" +
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
                // String[] resPhones = MergeArrays(phonesBase.get(contactName), contactPhones);
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

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class PhonesBook {

    private static void PrintBase(HashMap<String, String> phonesMap) {
        // LinkedHashMap<String, String> sortedBase = new LinkedHashMap<>();

        // phonesMap.entrySet()
        //             .stream()
        //             .sorted(Map.Entry.<String>comparingByValue(String::length).reversed())
        //             .forEachOrdered(x -> sortedBase.put(x.getKey(), x.getValue()));
        
        // phonesMap.forEach((key, value) -> System.out.println(key + ":" + value));

        Map<String, String> phonesSorted = new TreeMap<String, String>(
            new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.compare(s1.length(), s2.length());
                }
            }
        );

        phonesSorted.putAll(phonesMap);
        System.out.println(phonesSorted);
    }

    public static void main(String[] args) {
        System.out.println("Введите имя и номер телефона через двоеточие.\n" +
                            "Для выхода введите 'q', для вывода справочника 'p'.");
        HashMap<String, String> phonesBase = new HashMap<String, String>();
        Scanner inputStream = new Scanner(System.in);
        String userInput = "";
        
        while (true) {
            userInput = inputStream.nextLine();
            userInput = userInput.substring(0, 1).toUpperCase() +
                            userInput.substring(1).toLowerCase();
            if (userInput.split(":").length != 2) {
                if (userInput.equalsIgnoreCase("q")){
                    break; 
                } else if (userInput.equalsIgnoreCase("p")) { 
                    PrintBase(phonesBase);
                    continue;
                } else {
                    System.out.println("Некорректные данные, повторите попытку.");
                }
                
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


        inputStream.close();
    }
}

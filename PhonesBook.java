import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;



public class PhonesBook {

    private static void PrintBase(HashMap<String, String> phonesMap) {

        List<Map.Entry<String, String>> list = new ArrayList<>();
        HashMap<String, String> sortedMap = phonesMap.entrySet()
                                            .stream()
                                            .sorted(Comparator.comparing(itm -> itm.toString().length()).reversed())
                                            .collect(Collectors.toMap(
                                                Map.Entry::getKey, 
                                                Map.Entry::getValue,
                                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        list.addAll(sortedMap.entrySet());
        list.forEach(i -> System.out.println(i));
    }

    public static void main(String[] args) {
        System.out.println("Введите имя и номер телефона через двоеточие.\n" +
                            "Для выхода введите 'q', для вывода справочника 'p'.");
        HashMap<String, String> phonesBase = new HashMap<String, String>();
        Scanner inputStream = new Scanner(System.in);
        String userInput = "";
        
        while (true) {
            userInput = inputStream.nextLine();
            if (userInput.length() == 0) { continue; }
            userInput = userInput.substring(0, 1).toUpperCase() +
                            userInput.substring(1).toLowerCase();
            if (userInput.split(":").length != 2) {
                if (userInput.equalsIgnoreCase("q")){
                    break; 
                } else if (userInput.equalsIgnoreCase("p")) { 
                    PrintBase(phonesBase);
                    continue;
                }
                System.out.println("Некорректные данные, повторите попытку.");
                continue;
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

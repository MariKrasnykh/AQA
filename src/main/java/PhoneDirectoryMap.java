import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneDirectoryMap {
    LinkedHashMap<String, String> phoneDirectory = new LinkedHashMap<>();

    public PhoneDirectoryMap(){ }
    public PhoneDirectoryMap(String phone, String surname){
        phoneDirectory.put(phone, surname);
    }

    public void printPhoneDirectory(){
        for (Map.Entry<String, String> writing: phoneDirectory.entrySet()) {
            System.out.println(writing.getValue() + " - " + writing.getKey());;
        }
    }

    public void add(String surname, String phone) {
        phoneDirectory.put(phone, surname);
    }

    public void get(String surname){
        for (Map.Entry<String, String> writing: phoneDirectory.entrySet()){
            if (writing.getValue() == surname)
                System.out.println(writing.getValue() + " - " + writing.getKey());
        }
    }

    public static void main(String[] args) {
        PhoneDirectoryMap phonebook = new PhoneDirectoryMap();
        phonebook.add("Иванов","8 933 123 23 34");
        phonebook.add("Петров","8 933 567 67 89");
        phonebook.add("Иванов","8 998 111 22 33");
        phonebook.add("Марков","8 375 897 99 99");
        phonebook.add("Торес","+7 998 432 98 78");

        phonebook.printPhoneDirectory();
        System.out.println();
        phonebook.get("Иванов");
    }
}

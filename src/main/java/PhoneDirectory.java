import java.util.ArrayList;

public class PhoneDirectory {
    ArrayList<Writing> phoneDirectory = new ArrayList<>();

        public class Writing{
        String surname;
        String phone;

            public Writing(String surname, String phone){
                this.surname = surname;
                this.phone = phone;
            }
            public void printWriting(){
                System.out.println(surname + " - " + phone);
            };
        }
    public void add(String surname, String phone) {
        Writing writing = new Writing(surname, phone);
        phoneDirectory.add(writing);
    }
    public void printPhoneDirectory(){
        for (Writing writing: phoneDirectory) {
            writing.printWriting();
        }
    }
    public void get(String surname){
        for (Writing writing: phoneDirectory) {
            if (writing.surname == surname) writing.printWriting();
        }
    }



    public static void main(String[] args) {

        PhoneDirectory phonebook = new PhoneDirectory();
        phonebook.add("Иванов","8 933 123 23 34");
        phonebook.add("Петров","8 933 567 67 89");
        phonebook.add("Иванов","8 998 111 22 33");
        phonebook.add("Марков","8 375 897 99 99");
        phonebook.add("Торес","+7 998 432 98 78");

        phonebook.get("Иванов");



    }
}




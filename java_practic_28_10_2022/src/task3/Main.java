package task3;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "anton", "12345");
        dataBaseConnection.connect();

        DataBaseConnection dataBaseConnection1 = new DataBaseConnection("localhost", "anton", "12345");
        dataBaseConnection1.connect();

        Database database = Database.getInstance();
        // Database database1 = new Database(); // ошибка - нельзя создать объект через new
        Database.getInstance();

    }

}

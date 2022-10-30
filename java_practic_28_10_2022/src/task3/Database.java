package task3;

public class Database {

    private static Database instance;

    private Database() {
        // Здесь можно что-то сделать при создании экземпляра
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

}

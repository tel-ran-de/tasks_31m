package task3;

public class DataBaseConnection {

    private String url;
    private String login;
    private String password;
    public DataBaseConnection(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public void connect() {
        // Организуем подключение к базе данных по адресу url с помощью
        // логина-пароля login-password
    }

}

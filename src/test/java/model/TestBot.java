package model;

public class TestBot {
    private final String login;
    private final String password;
    private final String id;

    public TestBot(String login, String password, String id) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getId() { return id; }
}

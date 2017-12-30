package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBot {
    private String login;
    private String password;

    public TestBot(String resourcesPath) throws IOException {
        BufferedReader authConfig = new BufferedReader(new FileReader(resourcesPath));
        this.login = authConfig.readLine();
        this.password = authConfig.readLine();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
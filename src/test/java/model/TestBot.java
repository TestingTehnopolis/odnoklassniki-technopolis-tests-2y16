package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestBot {

    private String login;

    private String password;

    private String profileId;

    private String firstName;

    private String secondName;

    public String getFullName() {
        return firstName + " " + secondName;
    }
}

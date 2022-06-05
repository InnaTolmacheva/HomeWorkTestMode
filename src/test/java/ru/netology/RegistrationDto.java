package ru.netology;

import lombok.Data;

@Data
public class RegistrationDto {
    String login;
    String password;
    String status;

    public RegistrationDto(String login, String password, String status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }
}






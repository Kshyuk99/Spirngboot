package edu.du.login2.spring;

import lombok.Data;

@Data
public class AuthInfo {
    private Long id;
    private String name;
    private String email;

    public AuthInfo(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

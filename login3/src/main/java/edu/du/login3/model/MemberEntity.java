package edu.du.login3.model;

import lombok.Data;

@Data
public class MemberEntity {
    private Long id;
    private String name;
    private String password;
    private String email;

    public MemberEntity(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}

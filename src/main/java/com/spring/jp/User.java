package com.spring.jp;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}

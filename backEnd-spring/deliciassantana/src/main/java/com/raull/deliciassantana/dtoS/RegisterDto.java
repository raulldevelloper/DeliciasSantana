package com.raull.deliciassantana.dtoS;

import com.raull.deliciassantana.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String nome;
    private String login;
    private String senha;
    private Role role;
}

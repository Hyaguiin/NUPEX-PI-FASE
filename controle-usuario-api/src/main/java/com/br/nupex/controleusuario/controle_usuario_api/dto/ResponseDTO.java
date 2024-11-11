package com.br.nupex.controleusuario.controle_usuario_api.dto;

import java.util.Set;
public class ResponseDTO {

    private String name;
    private String token;
    private Set<String> roles;

    public ResponseDTO(String name, String token, Set<String> roles) {
        this.name = name;
        this.token = token;
        this.roles = roles;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }


}

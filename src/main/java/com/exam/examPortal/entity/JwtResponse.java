package com.exam.examPortal.entity;


public class JwtResponse {
    private String token;
    public JwtResponse(){}
    public JwtResponse(String token){
        this.token  = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                '}';
    }

    public void setToken(String token) {
        this.token = token;
    }
}

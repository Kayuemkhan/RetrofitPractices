package com.example.fakejsonapipostpractices;

public class PojoClassForPost {
    private String token;
    private DataClass dataClass;

    public PojoClassForPost() {
    }

    public PojoClassForPost(String token, DataClass dataClass) {
        this.token = token;
        this.dataClass = dataClass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataClass getDataClass() {
        return dataClass;
    }

    public void setDataClass(DataClass dataClass) {
        this.dataClass = dataClass;
    }
}

package com.example.apitest;

public class LoginSend {

    private String appid;
    private String nonce;
    private Integer ts;
    private Integer version;
    private String phoneNumber;
    private String password;

    public String getAppid() {
        return appid;
    }

    public String getNonce() {
        return nonce;
    }

    public Integer getTs() {
        return ts;
    }

    public Integer getVersion() {
        return version;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

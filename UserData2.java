package com.example.Edu;

public class UserData2 {
    String userName;
    String descp;
    Integer imageUrl;

    public UserData2(String userName, String descp, Integer imageUrl) {
        this.userName = userName;
        this.descp = descp;
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
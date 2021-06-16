package com.dragonize.opendating.modal;

import com.google.gson.annotations.SerializedName;

public class ResponseObject {

    @SerializedName("status")
    private String status;
    @SerializedName("Status")
    private String Status;
    @SerializedName("message")
    private String message;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Detail")
//    private UserObject user = new UserObject();
//    @SerializedName("profile")
//    private List<UserObject> profile = new ArrayList<UserObject>();


    public String getstatus() {
        return status;
    }
    public void setstatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }

    public String getMessage() {
        return Message;
    }
    public void setMessage(String message) {
        this.Message = message;
    }

    public String getmessage() {
        return message;
    }
    public void setmessage(String message) {
        this.message = message;
    }

//    public UserObject getUser() {
//        return user;
//    }
//    public void setUser(UserObject user) {
//        this.user = user;
//    }
//
//
//    public List<UserObject> getProfile() {
//        return profile;
//    }
//    public void setProfile(List<UserObject> profile) {
//        this.profile = profile;
//    }

}
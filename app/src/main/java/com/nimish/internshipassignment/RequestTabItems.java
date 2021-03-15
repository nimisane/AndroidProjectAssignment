package com.nimish.internshipassignment;

public class RequestTabItems {

    int userImage;
    String userName;
    String userPurpose;
    String dateTime;
    String location;
    String description;

    public RequestTabItems(int userImage, String userName, String userPurpose, String dateTime, String location, String description) {
        this.userImage = userImage;
        this.userName = userName;
        this.userPurpose = userPurpose;
        this.dateTime = dateTime;
        this.location = location;
        this.description = description;
    }

    public int getUserImage() {
        return userImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPurpose() {
        return userPurpose;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}

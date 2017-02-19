package com.blogspot.skooltchdev.tabbedapplicationmaster;



public class RowItem {

    private String title;
    private int rest_pic_id;
    private String description;
    private String number;

    public RowItem(String title, int rest_pic_id, String description,
                   String number) {

        this.title = title;
        this.rest_pic_id = rest_pic_id;
        this.description = description;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRest_pic_id() {
        return rest_pic_id;
    }

    public void setRest_pic_id(int rest_pic_id) {
        this.rest_pic_id = rest_pic_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
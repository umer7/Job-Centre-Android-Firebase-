package com.example.umer.jobcentre;

import java.util.List;

/**
 * Created by umer on 11/29/2017.
 */

public class info {
    private String text;
    private String name;
    private String photoUrl;

    public info(setting setting, int item_message, List<info> friendlyMessages) {
    }

    public info(String text, String name, String photoUrl) {
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}

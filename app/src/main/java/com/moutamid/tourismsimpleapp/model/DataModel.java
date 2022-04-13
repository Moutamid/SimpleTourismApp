package com.moutamid.tourismsimpleapp.model;

public class DataModel {
    public String title, desc;
    public int drawable;

    public DataModel(int drawable, String title, String desc) {
        this.title = title;
        this.desc = desc;
        this.drawable = drawable;
    }

    public DataModel() {
    }
}

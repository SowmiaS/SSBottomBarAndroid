package com.ss.example;

/**
 * Created by sowmi on 29/08/16.
 */
public class SampleData {

    private String title;
    private boolean isHeader;


    public SampleData(String title, boolean isHeader) {
        this.title = title;
        this.isHeader = isHeader;
    }

    public SampleData(String title) {
        this.title = title;
        this.isHeader = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }
}

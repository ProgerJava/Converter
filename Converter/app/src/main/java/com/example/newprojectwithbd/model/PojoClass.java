package com.example.newprojectwithbd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.JsonAdapter;

public class PojoClass {

    @JsonProperty("quotes")
    private Object quotes;
    private String source;

    public PojoClass(Object quotes, String source) {
        this.quotes = quotes;
        this.source = source;
    }
    public Object getQuotes() {
        return quotes;
    }

    public String getSource() {
        return source;
    }

}

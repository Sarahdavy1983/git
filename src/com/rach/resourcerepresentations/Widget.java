package com.rach.resourcerepresentations;

import java.math.BigDecimal;
import java.util.Objects;

public class Widget {

    private int id;
    private String name;
    private int widthcms;
    private int heightcms;
    private int weightgms;
    private BigDecimal value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidthcms() {
        return widthcms;
    }

    public void setWidthcms(int widthcms) {
        this.widthcms = widthcms;
    }

    public int getHeightcms() {
        return heightcms;
    }

    public void setHeightcms(int heightcms) {
        this.heightcms = heightcms;
    }

    public int getWeightgms() {
        return weightgms;
    }

    public void setWeightgms(int weightgms) {
        this.weightgms = weightgms;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "{\"Widget\":{"
                + "\"id\":\"" + id + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"widthcms\":\"" + widthcms + "\""
                + ", \"heightcms\":\"" + heightcms + "\""
                + ", \"weightgms\":\"" + weightgms + "\""
                + ", \"value\":\"" + value + "\""
                + "}}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Widget widget = (Widget) o;
        return id == widget.id &&
                widthcms == widget.widthcms &&
                heightcms == widget.heightcms &&
                weightgms == widget.weightgms &&
                Objects.equals(name, widget.name) &&
                Objects.equals(value, widget.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, widthcms, heightcms, weightgms, value);
    }
}


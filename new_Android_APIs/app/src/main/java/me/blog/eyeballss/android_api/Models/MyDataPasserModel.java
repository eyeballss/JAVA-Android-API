package me.blog.eyeballss.android_api.Models;

import java.util.Arrays;

/**
 * Created by david on 18. 3. 14.
 */

public class MyDataPasserModel {
    private int integerValue;
    private String stringValue;
    private double doubleValue;
    private boolean booleanValue;
    private char[] charValue;

    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public char[] getCharValue() {
        return charValue;
    }

    public void setCharValue(char[] charValue) {
        this.charValue = charValue;
    }
}

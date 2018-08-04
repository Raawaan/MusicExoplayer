package com.example.rawan.charities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rawan on 8/3/18.
 */

public class ArrayOfObjects {
    @SerializedName("charities")
    private ArrayList<charitiesData> ArrayOfCharites;

    public ArrayList<charitiesData> getArrayOfCharites() {
        return ArrayOfCharites;
    }

    public void setArrayOfCharites(ArrayList<charitiesData> arrayOfCharites) {
        ArrayOfCharites = arrayOfCharites;
    }
}

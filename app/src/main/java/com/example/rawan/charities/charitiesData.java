package com.example.rawan.charities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rawan on 8/2/18.
 */

public class charitiesData {
    @SerializedName("organization_name")
    private String organization_name;
    @SerializedName("organization_type")
    private String organization_type;
    @SerializedName("organization_pic")
    private String organization_pic;
    @SerializedName("organization_desc")
    private String organization_desc;
    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getOrganization_type() {
        return organization_type;
    }

    public void setOrganization_type(String organization_type) {
        this.organization_type = organization_type;
    }

    public String getOrganization_pic() {
        return organization_pic;
    }

    public void setOrganization_pic(String organization_pic) {
        this.organization_pic = organization_pic;
    }

    public String getOrganization_desc() {
        return organization_desc;
    }

    public void setOrganization_desc(String organization_desc) {
        this.organization_desc = organization_desc;
    }



}

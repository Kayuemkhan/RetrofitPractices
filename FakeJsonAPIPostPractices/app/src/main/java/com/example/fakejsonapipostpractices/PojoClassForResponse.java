package com.example.fakejsonapipostpractices;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoClassForResponse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameFirst")
    @Expose
    private String nameFirst;
    @SerializedName("nameLast")
    @Expose
    private String nameLast;
    @SerializedName("nameMiddle")
    @Expose
    private String nameMiddle;
    @SerializedName("namePrefix")
    @Expose
    private String namePrefix;
    @SerializedName("nameSuffix")
    @Expose
    private String nameSuffix;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameMiddle() {
        return nameMiddle;
    }

    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle = nameMiddle;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

}
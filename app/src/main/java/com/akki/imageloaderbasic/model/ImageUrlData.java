package com.akki.imageloaderbasic.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ImageUrlData implements Serializable {
    @SerializedName("imgUrl")
    private List<String> imgUrlData = null;

    public List<String> getImgUrlData() {
        return imgUrlData;
    }

    public void setImgUrlData(List<String> imgUrlData) {
        this.imgUrlData = imgUrlData;
    }
}

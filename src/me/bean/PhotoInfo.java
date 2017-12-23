package me.bean;

/**
 * Created by zzc on 2017/12/18.
 */
public class PhotoInfo {
    private int id;
    private String scale_photo;
    private String full_photo;
    private String photo_name;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScale_photo() {
        return scale_photo;
    }

    public void setScale_photo(String scale_photo) {
        this.scale_photo = scale_photo;
    }

    public String getFull_photo() {
        return full_photo;
    }

    public void setFull_photo(String full_photo) {
        this.full_photo = full_photo;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

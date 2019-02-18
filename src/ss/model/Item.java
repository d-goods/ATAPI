package ss.model;

import java.util.ArrayList;

public class Item {
    private int id;
    private String name;
    private String type;
    private String origin;
    private String page; //link
    private String image; //link
    private String description; //body text
    private ArrayList<String> owners; //character ids

    public Item() {
    }

    public Item(int id, String name, String type, String origin, String page, String image, String description, ArrayList<String> owners) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.origin = origin;
        this.page = page;
        this.image = image;
        this.description = description;
        this.owners = owners;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<String> owners) {
        this.owners = owners;
    }
}

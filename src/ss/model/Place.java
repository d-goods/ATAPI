package ss.model;

public class Place {
    private int id;
    private String type;
    private String name;
    private String page;
    private String image;
    private String description;

    public Place() {
    }

    public Place(int id, String type, String name, String page, String image, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.page = page;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

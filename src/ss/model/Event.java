package ss.model;

public class Event {
    private int id;
    private String name;
    private String type;
    private String location; //place id
    private String introduced; //episode id
    private String page; //link
    private String image; //link
    private String description; //body text

    public Event() {
    }

    public Event(int id, String name, String type, String location, String introduced, String page, String image, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.introduced = introduced;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduced() {
        return introduced;
    }

    public void setIntroduced(String introduced) {
        this.introduced = introduced;
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

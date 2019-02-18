package ss.model;

import java.util.ArrayList;

public class Episode {
    private int id; //episode number, 0101-1013
    private String name;
    private String page; //link
    private String image; //link
    private String description; //body text
    private String previous; //episode id
    private String next; //episode id
    private ArrayList<String> characters; //character ids
    private ArrayList<String> events; //event ids
    private ArrayList<String> places; //place ids

    public Episode() {
    }

    public Episode(int id, String name, String page, String image, String description, String previous, String next, ArrayList<String> characters, ArrayList<String> events, ArrayList<String> places) {
        this.id = id;
        this.name = name;
        this.page = page;
        this.image = image;
        this.description = description;
        this.previous = previous;
        this.next = next;
        this.characters = characters;
        this.events = events;
        this.places = places;
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

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }

    public ArrayList<String> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }

    public ArrayList<String> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<String> places) {
        this.places = places;
    }
}

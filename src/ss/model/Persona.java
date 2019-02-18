package ss.model;

import java.util.ArrayList;

public class Persona {
    private int id;
    private String name;
    private String gender;
    private String page; //link
    private String image; //link
    private String description; //body text
    private ArrayList<Integer> ages;
    private ArrayList<String> species;
    private ArrayList<String> occupations;
    private ArrayList<String> objects; //object ids
    private ArrayList<String> appearances; //episode ids

    public Persona() {
    }

    public Persona(int id, String name, String gender, String page, String image, String description, ArrayList<Integer> ages, ArrayList<String> species, ArrayList<String> occupations, ArrayList<String> objects, ArrayList<String> appearances) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.page = page;
        this.image = image;
        this.description = description;
        this.ages = ages;
        this.species = species;
        this.occupations = occupations;
        this.objects = objects;
        this.appearances = appearances;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public ArrayList<Integer> getAges() {
        return ages;
    }

    public void setAges(ArrayList<Integer> ages) {
        this.ages = ages;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

    public ArrayList<String> getOccupations() {
        return occupations;
    }

    public void setOccupations(ArrayList<String> occupations) {
        this.occupations = occupations;
    }

    public ArrayList<String> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<String> objects) {
        this.objects = objects;
    }

    public ArrayList<String> getAppearances() {
        return appearances;
    }

    public void setAppearances(ArrayList<String> appearances) {
        this.appearances = appearances;
    }
}

package ss.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ss.model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class DataScrape {
    private static String HOME_URL = "https://adventuretime.fandom.com";
    private ArrayList<Persona> personas;
    private ArrayList<Episode> episodes;
    private ArrayList<Event> events;
    private ArrayList<Item> items;
    private ArrayList<Place> places;

    public DataScrape()
    {
        personas = new ArrayList<Persona>();
        episodes = new ArrayList<Episode>();
        events = new ArrayList<Event>();
        items = new ArrayList<Item>();
        places = new ArrayList<Place>();
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public void scrapePersonas()
    {
        try {
            String charUrl = HOME_URL + "/wiki/Category:Characters";
            for(char alpha = 'A'; alpha <= 'Z'; alpha++) {
                String nextUrl = charUrl.concat("?from=" + alpha);
                Document maindoc = Jsoup.connect(nextUrl).get();
                //System.out.println(nextUrl);
                Elements charGroup = maindoc.getElementsByClass("category-page__members").get(0).child(1).getElementsByTag("a");
                //System.out.println("\t\t" + alpha + ":\n\n" + charGroup + "\n\n");
                for(Element persona : charGroup)
                {
                    String ref = persona.attr("href");
                    //Bypass fake entries
                    if(!((ref.toLowerCase().contains("category:"))
                            || (ref.toLowerCase().contains("user:"))
                            || (ref.toLowerCase().contains("jinn"))
                    ))
                    {
                        personas.add(scrapePersonaInfo(ref));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Persona scrapePersonaInfo(String url)
    {
        String clueName = "Name";
        String clueGender = "Gender";
        String clueAge = "Age";
        String clueSpecies = "Species";
        String clueOccu = "Occupation";
        String clueAppear = "Episode appearances";

        Persona character = new Persona();
        try {
            character.setPage(HOME_URL + url);
            Document charDoc = Jsoup.connect(HOME_URL + url).get();
            Elements info = charDoc.getElementsByTag("aside");
            if (info.size() < 1) {
                info = charDoc.getElementsByClass("infobox");
                Elements trs = info.get(0).getElementsByTag("tr");
                String name = trs.get(0).text();
                character.setName(name);
                for(Element el : trs) {
                    if(el.text().contains(clueGender)) {
                        String gender = el.getElementsByTag("td").get(1).text();
                        character.setGender(gender);
                    } else if (el.text().contains(clueAge)) {
                        Elements ages = el.getElementsByTag("td");
                        ArrayList<Integer> ageList = new ArrayList<>();
                        for (Element e : ages) {
                            if (!(e.text().contains(clueAge))) {
                                if(e.text().contains(" ")){
                                    String firstNum = e.text().substring(0, e.text().indexOf(" "));
                                    ageList.add(parseInt(firstNum));
                                } else {
                                    String str = e.text();
                                    str = str.replaceAll("\\D.*", "");
                                    if(!str.equals("")) ageList.add(parseInt(str));
                                }
                            }
                        }
                        if (character.getAges() != null) {
                            ArrayList<Integer> currAges = character.getAges();
                            currAges.addAll(ageList);
                            character.setAges(currAges);
                        } else {
                            character.setAges(ageList);
                        }
                    }  else if (el.text().contains(clueSpecies)) {
                        Elements specs = el.getElementsByTag("td");
                        ArrayList<String> sps = new ArrayList<>();
                        for(Element e : specs)
                            if(!(e.text().contains(clueSpecies))) sps.add(e.text());
                        character.setSpecies(sps);
                    } else if (el.text().contains(clueOccu)) {
                        Elements occus = el.getElementsByTag("td");
                        ArrayList<String> ocs = new ArrayList<>();
                        for (Element e : occus)
                            if (!(e.text().contains(clueOccu))) ocs.add(e.text());
                        character.setOccupations(ocs);
                    }
                }
            } else {
                Element name = info.get(0).child(0);
                character.setName(name.text());
                Elements infos = name.siblingElements();
                if(infos.size() == 1) infos = infos.get(0).children(); else infos = infos.get(1).children();
                for(Element el : infos) {
                    if(el.text().contains(clueGender)) {
                        String gender = el.getElementsByTag("div").get(0).text();
                        character.setGender(gender);
                    } else if (el.text().contains(clueAge)) {
                        String agesText = el.select("div > div").get(0).text();
                        String remove = el.select("div > div").get(0).select("div small").text()
                                .replace(") (", ") |(").replace("(", "\\(").replace(")", "\\)");
                        String ages = agesText.replaceAll(remove, "");
                        ArrayList<Integer> ageList = new ArrayList<>();
                        System.out.println(url);
                        for(String str : ages.split(" ")) {
                            str = str.replaceAll("\\D.*", "");
                            if(!str.equals("")) ageList.add(Integer.parseInt(str));
                        }
                        character.setAges(ageList);
                    } else if (el.text().contains(clueSpecies)) {
                        Elements specs = el.getElementsByTag("td");
                        ArrayList<String> sps = new ArrayList<>();
                        for(Element e : specs)
                            if(!(e.text().contains(clueSpecies))) sps.add(e.text());
                        character.setSpecies(sps);
                    } else if (el.text().contains(clueOccu)) {
                        Elements occus = el.getElementsByTag("td");
                        ArrayList<String> ocs = new ArrayList<>();
                        for (Element e : occus)
                            if (!(e.text().contains(clueOccu))) ocs.add(e.text());
                        character.setOccupations(ocs);
                    }
                }
            }
            String description = "";
            Elements desc = info.get(0).siblingElements().select("p");
            if(desc.size() != 0)
                description = desc.get(0).text();
            character.setDescription(description);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return character;
    }

    public void writeFile(String filename, ArrayList<?> section)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename), false));
            Gson g = new GsonBuilder().setPrettyPrinting().create();
            String jsonStr = g.toJson(section);
            bw.write(jsonStr);
            bw.close();
        } catch(IOException io) {
            io.printStackTrace();
            System.out.println("KILL MEEEEEEE.");
        }
    }
}

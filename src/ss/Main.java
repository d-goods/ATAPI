package ss;

import ss.model.*;
import ss.services.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)
    {
        DataScrape data = new DataScrape();
        try {
            Document doc = Jsoup.connect("https://adventuretime.fandom.com/wiki/Adventure_Time_with_Finn_and_Jake_Wiki").get();
            Element title = doc.getElementsByTag("title").get(0);
            System.out.println(title.text());

            data.scrapePersonas();
            data.writeFile("personas.json", data.getPersonas());

            /*
            Document finn = Jsoup.connect("https://adventuretime.fandom.com/wiki/Finn").get();
            Elements asider = finn.getElementsByTag("aside").get(0).children();
            System.out.println(asider.get(0).text());
            Elements sectels = asider.get(2).children();
            for(Element e : sectels) {
                if(e.text().toLowerCase().contains("age")) {
                    String agesText = e.select("div > div").get(0).text();
                    String remove = e.select("div > div").get(0).select("div small").text()
                            .replace(") (", ") |(").replace("(", "\\(").replace(")", "\\)");
                    String ages = agesText.replaceAll(remove, "");
                    ArrayList<Integer> yeet = new ArrayList<>();
                    for(String str : ages.split(" ")) { yeet.add(Integer.parseInt(str)); }
                    System.out.println(yeet.toString());
                }
            }


            Document terry = Jsoup.connect("https://adventuretime.fandom.com/wiki/Terry").get();
            Element content = terry.getElementById("mw-content-text");
            Elements inside = content.select("#mw-content-text > aside, #mw-content-text > table");
            String desc = content.text();
            String sub = inside.text();
            String description = desc.replaceFirst(Pattern.quote(sub + " "),  "");*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


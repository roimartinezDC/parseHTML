import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c").get();
        Elements title = doc.select("title[data-react-helmet=\"true\"]");
        Elements location = doc.select("h1.CurrentConditions--location--kyTeL");
        Elements temperature = doc.select("span.CurrentConditions--tempValue--3a50n[data-testid=\"TemperatureValue\"]");

        System.out.println();
        for (Element text : title) {
            System.out.println(text.html());
        }
        for (Element text : location) {
            System.out.println(text.html());
        }
        for (Element text : temperature) {
            System.out.println(text.html());
        }
    }
}

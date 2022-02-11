import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //recogemos la la página mediante su url en una variable
        Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c").get();

        //En instancias de tipo Elements recogemos mediante un función que utiliza selectores, lo que queramos recoger en esos selectores
        Elements title = doc.select("title[data-react-helmet=\"true\"]");
        Elements location = doc.select("h1.CurrentConditions--location--kyTeL");
        Elements temperature = doc.select("span.CurrentConditions--tempValue--3a50n[data-testid=\"TemperatureValue\"]");
        Elements sky = doc.select("div.CurrentConditions--phraseValue--2Z18W[data-testid=\"wxPhrase\"]");

        //Para poder mostrar el texto recogido en las instancias anteriores es necesario seguir el siguiente procedimiento
        System.out.println();
        //un bulce que instancie un tipo Element, y recorremos la instancia Elements con la nueva
        for (Element text : title) {
            //utilizamos la función .html() de Element para obtener solo el texto que nos interesa
            System.out.println(text.html());
        }
        for (Element text : location) {
            System.out.println(text.html());
        }
        for (Element text : temperature) {
            System.out.println(text.html());
        }
        for (Element text : sky) {
            System.out.println(text.html());
        }
    }
}

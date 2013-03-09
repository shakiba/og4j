package me.shakiba.og4j;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.annotations.Test;

@Test
public class OpenGraphTest {

    public void basic() throws Exception {
        OpenGraph og = new OpenGraph();
        og.put("og:title", "Title");
        og.put("og:image", "image1");
        og.put("og:image:width", "106");
        og.put("og:image:height", "109");

        System.out.println(og);

        assertEquals(og.title(), "Title");
        assertEquals(og.image(), "image1");
        assertEquals(og.imageWidth(), "106");
        assertEquals(og.imageHeight(), "109");

        og.put("og:image", "image2");
        og.put("og:image:width", "206");
        assertEquals(og.string("og:image", 0, 0), "image1");
        assertEquals(og.string("og:image:width", 0, 0), "106");
        assertEquals(og.string("og:image", 0, 1), "image2");
        assertEquals(og.string("og:image:width", 0, 1), "206");
    }

    public void jsoup() throws IOException {
        InputStream ogp = OpenGraphTest.class
                .getResourceAsStream("ogp.me.html");
        Document doc = Jsoup.parse(ogp, "UTF-8", "http://ogp.me/");

        OpenGraph og = new OpenGraph();
        for (Element tag : doc.select("meta[property^=og:]")) {
            og.put(tag.attr("property"), tag.attr("content"));
        }
        for (Element tag : doc.select("meta[property^=http://ogp.me/ns#]")) {
            og.put(tag.attr("property").replace("http://ogp.me/ns#", "og:"),
                    tag.attr("content"));
        }

        assertEquals(og.title(), "Open Graph protocol");
        assertEquals(og.type(), "website");
        assertEquals(og.url(), "http://ogp.me/");
        assertEquals(og.image(), "http://ogp.me/logo.png");
        assertEquals(og.imageType(), "image/png");
        assertEquals(og.imageWidth(), "300");
        assertEquals(og.imageHeight(), "300");
        assertEquals(
                og.description(),
                "The Open Graph protocol enables any web page to become a rich object in a social graph.");
    }
}
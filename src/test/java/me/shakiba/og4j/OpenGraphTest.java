package me.shakiba.og4j;

import static org.testng.Assert.assertEquals;

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
}
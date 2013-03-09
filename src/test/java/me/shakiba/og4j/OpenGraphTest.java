package me.shakiba.og4j;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import me.shakiba.og4j.OpenGraph;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

@Test
public class OpenGraphTest {

    public void testname() throws Exception {
        List<SimpleEntry<String, String>> date = Lists.newArrayList();
        date.add(new SimpleEntry<String, String>("og:title", "Title"));
        date.add(new SimpleEntry<String, String>("og:image", "image1"));
        date.add(new SimpleEntry<String, String>("og:image:width", "106"));
        date.add(new SimpleEntry<String, String>("og:image:height", "109"));

        OpenGraph og = new OpenGraph();
        for (SimpleEntry<String, String> entry : date) {
            og.add(entry.getKey(), entry.getValue());
        }

        System.out.println(og);

        for (SimpleEntry<String, String> entry : date) {
            System.out
                    .println(entry.getKey() + " -> " + og.str(entry.getKey()));
            Assert.assertEquals(og.str(entry.getKey()), entry.getValue());
        }

        og.add("og:image", "image2");
        og.add("og:image:width", "206");
        Assert.assertEquals(og.str("og:image", 0, 0), "image1");
        Assert.assertEquals(og.str("og:image:width", 0, 0), "106");
        Assert.assertEquals(og.str("og:image", 0, 1), "image2");
        Assert.assertEquals(og.str("og:image:width", 0, 1), "206");
    }
}
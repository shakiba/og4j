package me.shakiba.og4j;

public class OpenGraph extends OpenGraphValue {

    /**
     * og:url - The canonical URL of your object that will be used as its
     * permanent ID in the graph, e.g., "http://www.imdb.com/title/tt0117500/".
     * (Basic)
     */
    public String url() {
        return str("og:url");
    }

    /**
     * og:title - The title of your object as it should appear within the graph,
     * e.g., "The Rock". (Basic)
     */
    public String title() {
        return str("og:title");
    }

    /**
     * og:type - The type of your object, e.g., "video.movie". Depending on the
     * type you specify, other properties may also be required. (Basic)
     */
    public String type() {
        return str("og:type");
    }

    /**
     * og:image - An image URL which should represent your object within the
     * graph. (Basic)
     */
    public String image() {
        return str("og:image");
    }

    /**
     * og:audio - A URL to an audio file to accompany this object. (Optional)
     */
    public String audio() {
        return str("og:audio");
    }

    /**
     * og:description - A one to two sentence description of your object.
     * (Optional)
     */
    public String description() {
        return str("og:description");
    }

    /**
     * og:determiner - The word that appears before this object's title in a
     * sentence. An enum of (a, an, the, "", auto). If auto is chosen, the
     * consumer of your data should chose between "a" or "an". Default is ""
     * (blank). (Optional)
     */
    public String determiner() {
        return str("og:determiner");
    }

    /**
     * og:locale - The locale these tags are marked up in. Of the format
     * language_TERRITORY. Default is en_US. (Optional)
     */
    public String locale() {
        return str("og:locale");
    }

    /**
     * og:locale:alternate - An array of other locales this page is available
     * in. (Optional)
     */
    public String localeAlternate() {
        return str("og:locale:alternate");
    }

    /**
     * og:site_name - If your object is part of a larger web site, the name
     * which should be displayed for the overall site. e.g., "IMDb". (Optional)
     */
    public String site_name() {
        return str("og:site_name");
    }

    /**
     * og:video - A URL to a video file that complements this object. (Optional)
     */
    public String video() {
        return str("og:video");
    }

    /**
     * og:image:url - Identical to og:image. (Structured)
     */
    public String imageUrl() {
        return str("og:image:url");
    }

    /**
     * og:image:secure_url - An alternate url to use if the webpage requires
     * HTTPS. (Structured)
     */
    public String imageSecure_url() {
        return str("og:image:secure_url");
    }

    /**
     * og:image:type - A MIME type for this image. (Structured)
     */
    public String imageType() {
        return str("og:image:type");
    }

    /**
     * og:image:width - The number of pixels wide. (Structured)
     */
    public String imageWidth() {
        return str("og:image:width");
    }

    /**
     * og:image:height - The number of pixels high. (Structured)
     */
    public String imageHeight() {
        return str("og:");
    }

    /**
     * og:image:url - Identical to og:image. (Structured)
     */
    public String videoUrl() {
        return str("og:video:url");
    }

    /**
     * og:video:secure_url - An alternate url to use if the webpage requires
     * HTTPS. (Structured)
     */
    public String videoSecure_url() {
        return str("og:video:secure_url");
    }

    /**
     * og:video:type - A MIME type for this video. (Structured)
     */
    public String videoType() {
        return str("og:video:type");
    }

    /**
     * og:video:width - The number of pixels wide. (Structured)
     */
    public String videoWidth() {
        return str("og:video:width");
    }

    /**
     * og:video:height - The number of pixels high. (Structured)
     */
    public String videoHeight() {
        return str("og:video:height");
    }

    /**
     * og:audio:url - Identical to og:image. (Structured)
     */
    public String audioUrl() {
        return str("og:audio:url");
    }

    /**
     * og:audio:secure_url - An alternate url to use if the webpage requires
     * HTTPS. (Structured)
     */
    public String audioSecure_url() {
        return str("og:audio:secure_url");
    }

    /**
     * og:audio:type - A MIME type for this audio. (Structured)
     */
    public String audioType() {
        return str("og:audio:type");
    }
}

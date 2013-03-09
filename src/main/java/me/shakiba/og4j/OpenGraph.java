package me.shakiba.og4j;

public class OpenGraph extends OpenGraphValue {
    public static final String og_url = "og:url";
    public static final String og_title = "og:title";
    public static final String og_type = "og:type";
    public static final String og_image = "og:image";
    public static final String og_audio = "og:audio";
    public static final String og_description = "og:description";
    public static final String og_determiner = "og:determiner";
    public static final String og_locale = "og:locale";
    public static final String og_locale_alternate = "og:locale:alternate";
    public static final String og_site_name = "og:site_name";
    public static final String og_video = "og:video";
    public static final String og_image_url = "og:image:url";
    public static final String og_image_secure_url = "og:image:secure_url";
    public static final String og_image_type = "og:image:type";
    public static final String og_image_width = "og:image:width";
    public static final String og_image_height = "og:image:height";
    public static final String og_video_url = "og:video:url";
    public static final String og_video_secure_url = "og:video:secure_url";
    public static final String og_video_type = "og:video:type";
    public static final String og_video_width = "og:video:width";
    public static final String og_video_height = "og:video:height";
    public static final String og_audio_url = "og:audio:url";
    public static final String og_audio_secure_url = "og:audio:secure_url";
    public static final String og_audio_type = "og:audio:type";

    /**
     * og:url - The canonical URL of your object that will be used as its
     * permanent ID in the graph, e.g., "http://www.imdb.com/title/tt0117500/".
     * (Basic)
     */
    public String url() {
        return string(og_url);
    }

    /**
     * og:title - The title of your object as it should appear within the graph,
     * e.g., "The Rock". (Basic)
     */
    public String title() {
        return string(og_title);
    }

    /**
     * og:type - The type of your object, e.g., "video.movie". Depending on the
     * type you specify, other properties may also be required. (Basic)
     */
    public String type() {
        return string(og_type);
    }

    /**
     * og:image - An image URL which should represent your object within the
     * graph. (Basic)
     */
    public String image() {
        return string(og_image);
    }

    /**
     * og:audio - A URL to an audio file to accompany this object. (Optional)
     */
    public String audio() {
        return string(og_audio);
    }

    /**
     * og:description - A one to two sentence description of your object.
     * (Optional)
     */
    public String description() {
        return string(og_description);
    }

    /**
     * og:determiner - The word that appears before this object's title in a
     * sentence. An enum of (a, an, the, "", auto). If auto is chosen, the
     * consumer of your data should chose between "a" or "an". Default is ""
     * (blank). (Optional)
     */
    public String determiner() {
        return string(og_determiner);
    }

    /**
     * og:locale - The locale these tags are marked up in. Of the format
     * language_TERRITORY. Default is en_US. (Optional)
     */
    public String locale() {
        return string(og_locale);
    }

    /**
     * og:locale:alternate - An array of other locales this page is available
     * in. (Optional)
     */
    public String localeAlternate() {
        return string(og_locale_alternate);
    }

    /**
     * og:site_name - If your object is part of a larger web site, the name
     * which should be displayed for the overall site. e.g., "IMDb". (Optional)
     */
    public String siteName() {
        return string(og_site_name);
    }

    /**
     * og:video - A URL to a video file that complements this object. (Optional)
     */
    public String video() {
        return string(og_video);
    }

    /**
     * og:image:url - Identical to og:image. (Structured)
     */
    public String imageUrl() {
        return string(og_image_url);
    }

    /**
     * og:image:secure_url - An alternate url to use if the webpage requires
     * HTTPS. (Structured)
     */
    public String imageSecureUrl() {
        return string(og_image_secure_url);
    }

    /**
     * og:image:type - A MIME type for this image. (Structured)
     */
    public String imageType() {
        return string(og_image_type);
    }

    /**
     * og:image:width - The number of pixels wide. (Structured)
     */
    public String imageWidth() {
        return string(og_image_width);
    }

    /**
     * og:image:height - The number of pixels high. (Structured)
     */
    public String imageHeight() {
        return string(og_image_height);
    }

    /**
     * og:image:url - Identical to og:image. (Structured)
     */
    public String videoUrl() {
        return string(og_video_url);
    }

    /**
     * og:video:secure_url - An alternate url to use if the webpage requires
     * HTTPS. (Structured)
     */
    public String videoSecureUrl() {
        return string(og_video_secure_url);
    }

    /**
     * og:video:type - A MIME type for this video. (Structured)
     */
    public String videoType() {
        return string(og_video_type);
    }

    /**
     * og:video:width - The number of pixels wide. (Structured)
     */
    public String videoWidth() {
        return string(og_video_width);
    }

    /**
     * og:video:height - The number of pixels high. (Structured)
     */
    public String videoHeight() {
        return string(og_video_height);
    }

    /**
     * og:audio:url - Identical to og:image. (Structured)
     */
    public String audioUrl() {
        return string(og_audio_url);
    }

    /**
     * og:audio:secure_url - An alternate url to use if the webpage requires
     * HTTPS. (Structured)
     */
    public String audioSecureUrl() {
        return string(og_audio_secure_url);
    }

    /**
     * og:audio:type - A MIME type for this audio. (Structured)
     */
    public String audioType() {
        return string(og_audio_type);
    }
}

package sergio.splashbaseviewer.utils.models;

/**
 * @author s.ruiz
 */

public class SplashImage {
    private int id;
    private String url;
    private String large_url;
    private int source_id;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getLarge_url() {
        return large_url;
    }

    public int getSource_id() {
        return source_id;
    }

    @Override
    public String toString() {
        return "ID: " + String.valueOf(id) +
                "\nUrl: " + url +
                "\nLarge Url: " + large_url +
                "\nSource Id: " + source_id + "\n\n";
    }
}

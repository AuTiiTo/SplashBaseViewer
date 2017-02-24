package sergio.splashbaseviewer.utils.models;

/**
 * @author s.ruiz
 */

public class SplashImage {
    private long id;
    private String image;

    public long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public SplashImage(long id, String image) {
        this.id = id;
        this.image = image;
    }
}

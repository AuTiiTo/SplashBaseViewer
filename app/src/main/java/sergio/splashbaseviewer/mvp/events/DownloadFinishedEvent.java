package sergio.splashbaseviewer.mvp.events;

import java.util.List;

import sergio.splashbaseviewer.utils.models.SplashImageResponse;

/**
 * @author s.ruiz
 */

public class DownloadFinishedEvent {
    private List<SplashImageResponse> images;

    public DownloadFinishedEvent(List<SplashImageResponse> images) {
        this.images = images;
    }

    public List<SplashImageResponse> getImages() {
        return images;
    }
}

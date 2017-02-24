package sergio.splashbaseviewer.mvp.events;

/**
 * @author s.ruiz
 */

public class DownloadFailureEvent {
    String errorMessage;

    public DownloadFailureEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

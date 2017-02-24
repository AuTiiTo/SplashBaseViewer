package sergio.splashbaseviewer.mvp.model;

import sergio.splashbaseviewer.utils.SplashServiceInterface;

/**
 * @author s.ruiz
 */

public class SplashModel {

    SplashServiceInterface splashServiceInterface;

    public SplashModel(SplashServiceInterface splashServiceInterface) {
        this.splashServiceInterface = splashServiceInterface;
    }

    public void startDownload( ) {
        splashServiceInterface.startDownload();
    }
}

package sergio.splashbaseviewer.mvp.presenter;

import android.support.annotation.NonNull;

import com.squareup.otto.Subscribe;

import sergio.splashbaseviewer.mvp.events.DownloadFailureEvent;
import sergio.splashbaseviewer.mvp.events.DownloadFinishedEvent;
import sergio.splashbaseviewer.mvp.model.SplashModel;
import sergio.splashbaseviewer.mvp.view.SplashView;

/**
 * @author s.ruiz
 */

public class SplashPresenter{
    @NonNull
    private SplashView view;
    @NonNull
    private SplashModel model;

    public SplashPresenter(SplashView view, SplashModel model) {
        this.model = model;
        this.view = view;

        model.startDownload();
    }

    @Subscribe
    public void onDownloadFinishedEvent(DownloadFinishedEvent event) {
        view.setResul(event.getImages().toString().replace(',','*'));
    }

    @Subscribe
    public void onDownloadFailureEvent(DownloadFailureEvent event) {
        view.setResul(event.getErrorMessage());
    }
}

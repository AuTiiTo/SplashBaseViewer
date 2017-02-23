package sergio.splashbaseviewer.mvp.presenter;

import android.support.annotation.NonNull;

import com.squareup.otto.Subscribe;

import java.util.List;

import sergio.splashbaseviewer.mvp.model.SplashModel;
import sergio.splashbaseviewer.mvp.view.SplashView;
import sergio.splashbaseviewer.utils.models.SplashImage;

/**
 * @author s.ruiz
 */

public class SplashPresenter implements SplashModel.SplashServiceConsumer{
    @NonNull
    private SplashView view;
    @NonNull
    private SplashModel model;

    public SplashPresenter(SplashView view) {
        this.model = new SplashModel(this);
        this.view = view;
    }

    @Subscribe
    public void onFabSyncPressed(SplashView.FabSyncPressedEvent event) {
        model.startDownload();
    }

    @Override
    public void onDownloadFinished(List<SplashImage> images) {
        view.setResul(images.toString().replace(',','*'));
    }

    @Override
    public void onFailure(String errorMessage) {
        view.setResul(errorMessage);
    }
}

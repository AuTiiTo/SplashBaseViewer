package sergio.splashbaseviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sergio.splashbaseviewer.mvp.model.SplashModel;
import sergio.splashbaseviewer.mvp.presenter.SplashPresenter;
import sergio.splashbaseviewer.mvp.view.SplashView;
import sergio.splashbaseviewer.utils.BusProvider;
import sergio.splashbaseviewer.utils.SplashBaseServiceImpl;

public class MainActivity extends AppCompatActivity {

    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new SplashPresenter(new SplashView(this, BusProvider.getInstance()), new SplashModel(new SplashBaseServiceImpl()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }
}

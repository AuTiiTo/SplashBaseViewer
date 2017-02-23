package sergio.splashbaseviewer.mvp.view;

import android.app.Activity;
import android.widget.TextView;

import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import sergio.splashbaseviewer.R;

/**
 * @author s.ruiz
 */

public class SplashView extends ActivityView {
    private final Bus bus;

    @BindView(R.id.tv_splash_main)
    TextView jsonMain;

    public SplashView(Activity mainActivity, Bus bus) {
        super(mainActivity);
        this.bus = bus;
        ButterKnife.bind(this, mainActivity);
    }

    public void setResul(String result) {
        jsonMain.setText(result);
    }

}

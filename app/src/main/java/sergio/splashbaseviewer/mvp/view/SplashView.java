package sergio.splashbaseviewer.mvp.view;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.otto.Bus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sergio.splashbaseviewer.R;
import sergio.splashbaseviewer.adapters.ImageContainerAdapter;
import sergio.splashbaseviewer.utils.models.SplashImageResponse;

/**
 * @author s.ruiz
 */

public class SplashView extends ActivityView {
    private final Bus bus;
    private ImageContainerAdapter adapter;

    @BindView(R.id.image_container)
    ListView imageContainer;

    public SplashView(Activity mainActivity, Bus bus) {
        super(mainActivity);
        this.bus = bus;
        ButterKnife.bind(this, mainActivity);
        adapter = new ImageContainerAdapter();
    }

    public void setResult(List<SplashImageResponse> imageList) {
        adapter.setImages(imageList);
        imageContainer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void showError(String errorMessage) {
        Toast.makeText(super.getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }
}

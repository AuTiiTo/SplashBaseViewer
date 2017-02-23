package sergio.splashbaseviewer.mvp.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sergio.splashbaseviewer.utils.models.SplashBaseResponse;
import sergio.splashbaseviewer.utils.SplashBaseService;
import sergio.splashbaseviewer.utils.models.SplashImage;

/**
 * @author s.ruiz
 */

public class SplashModel {

    private final SplashServiceConsumer consumer;

    public SplashModel(SplashServiceConsumer consumer) {
        this.consumer = consumer;
    }

    public void startDownload() {
        SplashBaseService service = SplashBaseService.retrofit.create(SplashBaseService.class);
        Call<SplashBaseResponse> call = service.response();
        call.enqueue(new Callback<SplashBaseResponse>() {
            @Override
            public void onResponse(Call<SplashBaseResponse> call, Response<SplashBaseResponse> response) {
                List<SplashImage> images = response.body().getImages();
                consumer.onDownloadFinished(images);
            }

            @Override
            public void onFailure(Call<SplashBaseResponse> call, Throwable t) {
                consumer.onFailure(t.getMessage());
            }
        });
    }

    public interface SplashServiceConsumer {
        void onDownloadFinished(List<SplashImage> images);
        void onFailure(String errorMessage);
    }
}

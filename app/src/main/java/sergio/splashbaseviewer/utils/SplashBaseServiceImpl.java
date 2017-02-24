package sergio.splashbaseviewer.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sergio.splashbaseviewer.mvp.events.DownloadFailureEvent;
import sergio.splashbaseviewer.mvp.events.DownloadFinishedEvent;
import sergio.splashbaseviewer.utils.models.SplashBaseResponse;
import sergio.splashbaseviewer.utils.models.SplashImageResponse;

/**
 * @author s.ruiz
 */

public class SplashBaseServiceImpl implements SplashServiceInterface {

    public void startDownload() {

        SplashBaseService service = initRetrofit().create(SplashBaseService.class);
        Call<SplashBaseResponse> call = service.response();
        call.enqueue(new Callback<SplashBaseResponse>() {
            @Override
            public void onResponse(Call<SplashBaseResponse> call, Response<SplashBaseResponse> response) {
                List<SplashImageResponse> images = response.body().getImages();
                //BusEvent
                BusProvider.getInstance().post(new DownloadFinishedEvent(images));

            }

            @Override
            public void onFailure(Call<SplashBaseResponse> call, Throwable t) {
                String errorMessage = t.getMessage();
                //BusEvent
                BusProvider.getInstance().post(new DownloadFailureEvent(errorMessage != null ? errorMessage : "Timeout"));
            }
        });
    }

    private Retrofit initRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://www.splashbase.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

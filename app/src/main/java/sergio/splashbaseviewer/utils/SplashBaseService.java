package sergio.splashbaseviewer.utils;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import sergio.splashbaseviewer.utils.models.SplashBaseResponse;

/**
 * @author s.ruiz
 */

public interface SplashBaseService {
    @GET("/api/v1/images/latest")
    Call<SplashBaseResponse> response();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.splashbase.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

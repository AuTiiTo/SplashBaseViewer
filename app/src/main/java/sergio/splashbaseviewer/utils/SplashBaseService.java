package sergio.splashbaseviewer.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import sergio.splashbaseviewer.utils.models.SplashBaseResponse;

/**
 * @author s.ruiz
 */

public interface SplashBaseService {
    @GET("/api/v1/images/latest")
    Call<SplashBaseResponse> response();
}

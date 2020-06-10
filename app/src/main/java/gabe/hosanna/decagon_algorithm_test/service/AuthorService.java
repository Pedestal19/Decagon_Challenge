package gabe.hosanna.decagon_algorithm_test.service;

import gabe.hosanna.decagon_algorithm_test.model.PageData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author: Hosanna Gabe-Oji
 * Project: Decagon_Algorithm_Test
 * Date: 6/10/2020
 */
public interface AuthorService {
    @GET("api/article_users/search")
    Call<PageData> getArticleUsers(@Query("page") int page);
}

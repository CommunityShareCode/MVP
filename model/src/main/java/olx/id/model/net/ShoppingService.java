package olx.id.model.net;

import olx.id.model.response.Shopping;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by fandygotama on 3/12/16.
 */
public interface ShoppingService {

    /**
     * Example url request
     * http://open.api.ebay.com/shopping?callname=FindPopularItems&responseencoding=JSON&appid=FandyGot-ec13-4906-b11c-94d9e36684ee&siteid=0&QueryKeywords=dog&version=713
     */
    @GET("/shopping")
    Shopping shopping(
            @Query("callname") String callname,
            @Query("responseencoding") String responseEncoding,
            @Query("appid") String appId,
            @Query("siteid") int siteId,
            @Query("QueryKeywords") String queryKeywords,
            @Query("version") int version
            );


}

package olx.id.model.repository.datasource.shopping;

import android.support.annotation.NonNull;

import olx.id.model.net.ShoppingService;
import olx.id.model.repository.cache.ResponseCache;
import olx.id.model.request.ShoppingRequest;
import olx.id.model.response.Shopping;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingApiDataStore implements ShoppingDataStore {

    /**
     * For the sake of simplicity i put a config parameters here :), this section will be updated once
     * we already get a good understanding about Dependency Injection, and move all config parameters to Dagger Module.
     */
    private static final String RESONSE_ENCODING = "JSON";
    private static final String APP_ID = "FandyGot-ec13-4906-b11c-94d9e36684ee";

    private static final int SITE_ID = 0;
    private static final int VERSION = 713;
    /**
     * End of parameters
     */

    private final ShoppingService mService;
    private final ResponseCache mResponseCache;

    public ShoppingApiDataStore(@NonNull ShoppingService service, @NonNull ResponseCache responseCache) {
        mService = service;
        mResponseCache = responseCache;
    }

    @Override
    public Shopping getShopping(ShoppingRequest request) {
        Shopping shopping = mService.shopping(
                request.callname,
                RESONSE_ENCODING,
                APP_ID,
                SITE_ID,
                request.keywords,
                VERSION);

        mResponseCache.putList(shopping);

        return shopping;
    }
}

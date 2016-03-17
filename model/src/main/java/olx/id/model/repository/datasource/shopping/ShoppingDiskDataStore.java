package olx.id.model.repository.datasource.shopping;

import android.support.annotation.NonNull;

import olx.id.model.repository.cache.ResponseCache;
import olx.id.model.request.ShoppingRequest;
import olx.id.model.response.Shopping;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingDiskDataStore implements ShoppingDataStore {

    private final ResponseCache<Shopping, ShoppingRequest> mResponseCache;

    public ShoppingDiskDataStore(@NonNull ResponseCache responseCache) {
        mResponseCache = responseCache;
    }

    @Override
    public Shopping getShopping(@NonNull ShoppingRequest request) {
        return mResponseCache.getList(request);
    }
}

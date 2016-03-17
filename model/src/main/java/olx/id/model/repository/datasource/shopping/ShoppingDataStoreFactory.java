package olx.id.model.repository.datasource.shopping;

import android.support.annotation.NonNull;

import olx.id.model.net.ShoppingService;
import olx.id.model.repository.cache.ResponseCache;
import olx.id.model.repository.datasource.DataStoreFactory;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingDataStoreFactory extends DataStoreFactory<ShoppingDataStore> {

    private final ShoppingService mService;

    public ShoppingDataStoreFactory(@NonNull ShoppingService service, @NonNull ResponseCache responseCache) {
        super(responseCache);

        mService = service;
    }

    @Override
    protected ShoppingDataStore createDiskDataStore(ResponseCache responseCache) {
        return new ShoppingDiskDataStore(responseCache);
    }

    @Override
    protected ShoppingDataStore createApiDataStore(ResponseCache responseCache) {
        return new ShoppingApiDataStore(mService, responseCache);
    }
}

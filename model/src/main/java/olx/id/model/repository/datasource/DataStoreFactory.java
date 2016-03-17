package olx.id.model.repository.datasource;

import android.content.Context;
import android.support.annotation.Nullable;

import olx.id.model.repository.cache.ResponseCache;

/**
 * Created by aldychris on 11/18/15.
 */
public abstract class DataStoreFactory<T extends DataStore> {

    protected final ResponseCache mResponseCache;

    public DataStoreFactory(@Nullable ResponseCache responseCache) {
        mResponseCache = responseCache;
    }

    public T getDataStore() {
        DataStore dataStore;
        if (isCacheAvailable()) {
            dataStore = createDiskDataStore(mResponseCache);
        } else {
            dataStore = createApiDataStore(mResponseCache);
        }
        return (T) dataStore;
    }

    protected abstract T createDiskDataStore(ResponseCache responseCache);

    protected abstract T createApiDataStore(ResponseCache responseCache);

    public boolean isCacheAvailable() {
        return mResponseCache != null
                && mResponseCache.isCached()
                && !mResponseCache.isExpired();
    }
}

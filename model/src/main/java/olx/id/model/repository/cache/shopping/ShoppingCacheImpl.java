package olx.id.model.repository.cache.shopping;

import olx.id.model.repository.cache.ResponseCache;
import olx.id.model.request.ShoppingRequest;
import olx.id.model.response.Shopping;

/**
 * Created by fandygotama on 3/12/16.
 *
 * Here you can implement cache according to your preferences (e.g. MySQL, File or Memory)
 */
public class ShoppingCacheImpl implements ResponseCache<Shopping, ShoppingRequest> {

    public ShoppingCacheImpl() {

    }

    @Override
    public Shopping getList(ShoppingRequest request) {
        return null;
    }

    @Override
    public void put(Shopping response) {

    }

    @Override
    public void putList(Shopping list) {

    }

    @Override
    public boolean isCached() {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void removeAll() {

    }
}

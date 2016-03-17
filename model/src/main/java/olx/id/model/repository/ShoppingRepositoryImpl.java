package olx.id.model.repository;

import android.support.annotation.NonNull;

import olx.id.model.repository.datasource.shopping.ShoppingDataStoreFactory;
import olx.id.model.request.ShoppingRequest;
import olx.id.model.response.Shopping;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingRepositoryImpl {

    private final ShoppingDataStoreFactory mFactory;

    public ShoppingRepositoryImpl(@NonNull ShoppingDataStoreFactory factory) {
        mFactory = factory;
    }

    public Shopping getShopping(ShoppingRequest request) {
        return mFactory.getDataStore().getShopping(request);
    }
}

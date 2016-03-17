package olx.id.model.repository.datasource.shopping;

import olx.id.model.repository.datasource.DataStore;
import olx.id.model.request.ShoppingRequest;
import olx.id.model.response.Shopping;

/**
 * Created by fandygotama on 3/12/16.
 */
public interface ShoppingDataStore extends DataStore {

    Shopping getShopping(ShoppingRequest request);

}

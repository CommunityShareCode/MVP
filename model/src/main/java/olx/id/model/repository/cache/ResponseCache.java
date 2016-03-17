package olx.id.model.repository.cache;

import olx.id.model.request.BaseRequest;
import olx.id.model.response.BaseResponse;

/**
 * Created by fandygotama on 3/12/16.
 */
public interface ResponseCache<T extends BaseResponse, E extends BaseRequest> {

    T getList(E request);

    void put(T response);

    void putList(T list);

    boolean isCached();

    boolean isExpired();

    void removeAll();

}

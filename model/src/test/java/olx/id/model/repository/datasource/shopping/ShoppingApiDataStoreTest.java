package olx.id.model.repository.datasource.shopping;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.shadows.ShadowLog;

import olx.id.model.ApplicationTestCase;
import olx.id.model.net.ShoppingService;
import olx.id.model.repository.cache.ResponseCache;
import olx.id.model.request.ShoppingRequest;
import olx.id.model.response.BaseResponse;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingApiDataStoreTest extends ApplicationTestCase {

    @Mock
    private ShoppingService mMockService;

    @Mock
    private ResponseCache mMockResponseCache;

    @Mock
    private ShoppingRequest mMockRequest;

    private ShoppingApiDataStore mDataStore;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;

        MockitoAnnotations.initMocks(this);

        mDataStore = new ShoppingApiDataStore(mMockService, mMockResponseCache);
    }

    @Test
    public void testGetShoppingList() {

        mDataStore.getShopping(mMockRequest);

        verify(mMockService).shopping(anyString(), anyString(), anyString(), anyInt(), anyString(), anyInt());
        verify(mMockResponseCache).putList(any(BaseResponse.class));
    }

}

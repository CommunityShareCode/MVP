package olx.id.model.repository.datasource.shopping;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.shadows.ShadowLog;

import olx.id.model.ApplicationTestCase;
import olx.id.model.repository.cache.ResponseCache;
import olx.id.model.request.BaseRequest;
import olx.id.model.request.ShoppingRequest;

import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingDiskDataStoreTest {

    @Mock
    private ResponseCache mMockResponseCache;

    @Mock
    private ShoppingRequest mMockRequest;

    private ShoppingDiskDataStore mDataStore;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;

        MockitoAnnotations.initMocks(this);

        mDataStore = new ShoppingDiskDataStore(mMockResponseCache);
    }

    @Test
    public void testGetShoppingList() {
        mDataStore.getShopping(mMockRequest);

        verify(mMockResponseCache).getList(any(BaseRequest.class));
    }
}

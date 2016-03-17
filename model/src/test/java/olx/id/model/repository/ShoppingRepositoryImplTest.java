package olx.id.model.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.shadows.ShadowLog;

import olx.id.model.ApplicationTestCase;
import olx.id.model.repository.datasource.shopping.ShoppingApiDataStore;
import olx.id.model.repository.datasource.shopping.ShoppingDataStoreFactory;
import olx.id.model.repository.datasource.shopping.ShoppingDiskDataStore;
import olx.id.model.request.ShoppingRequest;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingRepositoryImplTest {

    @Mock
    private ShoppingDataStoreFactory mFactory;

    @Mock
    private ShoppingRequest mMockRequest;

    @Mock
    private ShoppingApiDataStore mMockApiDataStore;

    @Mock
    private ShoppingDiskDataStore mMockDiskDataStore;

    private ShoppingRepositoryImpl mRepository;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;

        MockitoAnnotations.initMocks(this);

        mRepository = new ShoppingRepositoryImpl(mFactory);
    }

    @Test
    public void testGetShoppingFromApi() {

        doReturn(mMockApiDataStore).when(mFactory).getDataStore();

        mRepository.getShopping(mMockRequest);

        verify(mFactory.getDataStore()).getShopping(any(ShoppingRequest.class));

        verify(mMockApiDataStore).getShopping(any(ShoppingRequest.class));
    }

    @Test
    public void testGetShoppingFromDisk() {
        doReturn(mMockDiskDataStore).when(mFactory).getDataStore();

        mRepository.getShopping(mMockRequest);

        verify(mFactory.getDataStore()).getShopping(any(ShoppingRequest.class));

        verify(mMockDiskDataStore).getShopping(any(ShoppingRequest.class));
    }

}

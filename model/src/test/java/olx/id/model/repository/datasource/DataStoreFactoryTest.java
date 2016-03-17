package olx.id.model.repository.datasource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.shadows.ShadowLog;

import olx.id.model.ApplicationTestCase;
import olx.id.model.repository.cache.ResponseCache;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;

/**
 * Created by fandygotama on 3/12/16.
 */
public class DataStoreFactoryTest {

    @Mock
    private ResponseCache mMockResponseCache;

    private DataStoreFactory mDataStoreFactory;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;

        MockitoAnnotations.initMocks(this);

        mDataStoreFactory = spy(new DataStoreFactory(mMockResponseCache) {
            @Override
            protected DataStore createDiskDataStore(ResponseCache responseCache) {
                return null;
            }

            @Override
            protected DataStore createApiDataStore(ResponseCache responseCache) {
                return null;
            }
        });
    }

    @Test
    public void testGetDataStoreWithNoCache() {
        doReturn(false).when(mDataStoreFactory).isCacheAvailable();

        mDataStoreFactory.getDataStore();

        verify(mDataStoreFactory).createApiDataStore(any(ResponseCache.class));
    }

    @Test
    public void testGetDataStoreWithCacheAvailable() {
        doReturn(true).when(mDataStoreFactory).isCacheAvailable();

        mDataStoreFactory.getDataStore();

        verify(mDataStoreFactory).createDiskDataStore(any(ResponseCache.class));
    }

    @Test
    public void testIsCacheAvailable() {
        doReturn(true).when(mMockResponseCache).isCached();

        mDataStoreFactory.isCacheAvailable();

        verify(mMockResponseCache).isCached();
        verify(mMockResponseCache).isExpired();
    }

}


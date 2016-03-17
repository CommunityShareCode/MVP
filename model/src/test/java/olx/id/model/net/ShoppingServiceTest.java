package olx.id.model.net;

import com.squareup.okhttp.OkHttpClient;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowLog;

import olx.id.model.ApplicationTestCase;
import olx.id.model.response.Shopping;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;

/**
 * Created by fandygotama on 3/12/16.
 */
public class ShoppingServiceTest {

    private static final String MOCK_CALLNAME = "FindPopularItems";
    private static final String MOCK_RESONSE_ENCODING = "JSON";
    private static final String MOCK_APP_ID = "FandyGot-ec13-4906-b11c-94d9e36684ee";
    private static final String MOCK_QUERY_KEYWORDS = "dog";

    private static final int MOCK_SITE_ID = 0;
    private static final int MOCK_VERSION = 713;

    private static final String MOCK_URL = "http://open.api.ebay.com";

    private ShoppingService mService;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;

        RestAdapter.Builder builder = new RestAdapter.Builder();

        OkHttpClient client = new OkHttpClient();

        builder.setEndpoint(MOCK_URL);
        builder.setClient(new OkClient(client));
        builder.setConverter(new JacksonConverter());

        RestAdapter adapter = builder.build();

        mService = adapter.create(ShoppingService.class);
    }

    @Test
    public void testGetShopping() {
        Shopping shopping = mService.shopping(
                    MOCK_CALLNAME,
                    MOCK_RESONSE_ENCODING,
                    MOCK_APP_ID,
                    MOCK_SITE_ID,
                    MOCK_QUERY_KEYWORDS,
                    MOCK_VERSION);

        Assert.assertNotNull(shopping);
        Assert.assertNotNull(shopping.itemArray);
        Assert.assertNotNull(shopping.itemArray.item);

        Assert.assertTrue(shopping.itemArray.item.size() > 0);
    }
}

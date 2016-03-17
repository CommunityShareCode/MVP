package olx.id.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by fandygotama on 3/12/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Shopping extends BaseResponse {

    @JsonProperty("ItemArray")
    public ItemArray itemArray;
}

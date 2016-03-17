package olx.id.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by fandygotama on 3/12/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ItemArray {

    @JsonProperty("Item")
    public List<Item> item;

}

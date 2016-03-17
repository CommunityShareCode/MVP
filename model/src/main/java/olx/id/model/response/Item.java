package olx.id.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by fandygotama on 3/12/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Item {

    @JsonProperty("ItemID")
    public String ItemID;

    @JsonProperty("EndTime")
    public String EndTime;

    @JsonProperty("ViewItemURLForNaturalSearch")
    public String ViewItemURLForNaturalSearch;

    @JsonProperty("ListingType")
    public String ListingType;

    @JsonProperty("GalleryURL")
    public String GalleryURL;

    @JsonProperty("PrimaryCategoryID")
    public String PrimaryCategoryID;

    @JsonProperty("PrimaryCategoryName")
    public String PrimaryCategoryName;

    @JsonProperty("BidCount")
    public Integer BidCount;

    @JsonProperty("ListingStatus")
    public String ListingStatus;

    @JsonProperty("TimeLeft")
    public String TimeLeft;

    @JsonProperty("Title")
    public String Title;

    @JsonProperty("WatchCount")
    public Integer WatchCount;

    @Override
    public String toString() {
        return "Item{" +
                "ItemID='" + ItemID + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", ViewItemURLForNaturalSearch='" + ViewItemURLForNaturalSearch + '\'' +
                ", ListingType='" + ListingType + '\'' +
                ", GalleryURL='" + GalleryURL + '\'' +
                ", PrimaryCategoryID='" + PrimaryCategoryID + '\'' +
                ", PrimaryCategoryName='" + PrimaryCategoryName + '\'' +
                ", BidCount=" + BidCount +
                ", ListingStatus='" + ListingStatus + '\'' +
                ", TimeLeft='" + TimeLeft + '\'' +
                ", Title='" + Title + '\'' +
                ", WatchCount=" + WatchCount +
                '}';
    }
}

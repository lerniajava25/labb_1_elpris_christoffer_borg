import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "EUR_per_kWh", "EXR" })
public class Price {
    public double price;
    public String start;
    public String end;


    @JsonCreator
    public Price(
            @JsonProperty("SEK_per_kWh") double price,
            @JsonProperty("time_start") String start,
            @JsonProperty("time_end") String end) {
        this.price = price;
        this.start = start;
        this.end = end;




        }
    }

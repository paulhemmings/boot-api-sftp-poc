package camelpoc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FeedResults {

  @JsonProperty("results")
  public List<FeedItem> results;

}

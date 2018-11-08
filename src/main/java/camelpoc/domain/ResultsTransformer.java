package camelpoc.domain;

import java.util.List;

public class ResultsTransformer {
  public List<FeedItem> getResults(FeedResults feedResults) {
    return feedResults.results;
  }
}

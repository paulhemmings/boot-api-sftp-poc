package camelpoc.components;

import camelpoc.domain.FeedItem;
import camelpoc.domain.FeedResults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultsTransformer {
  public List<FeedItem> getResults(FeedResults feedResults) {
    return feedResults.results;
  }
}

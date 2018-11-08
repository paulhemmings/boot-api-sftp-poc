package camelpoc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.util.List;

@CsvRecord(separator = ",", crlf = "UNIX")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"deliciousTags",
                    "feedId",
                    "title",
                    "lastUpdated",
                    "subscribers",
                    "velocity",
                    "website",
                    "score",
                    "coverage",
                    "coverageScore",
                    "estimatedEngagement",
                    "hint",
                    "scheme",
                    "language",
                    "contentType",
                    "description",
                    "coverUrl",
                    "iconUrl",
                    "partial",
                    "visualUrl",
                    "coverColor",
                    "art"})
public class FeedItem {

  @JsonProperty("deliciousTags")
  public List<String> deliciousTags = null;

  @DataField(pos = 1)
  @JsonProperty("feedId")
  public String  feedId;

  @DataField(pos = 2)
  @JsonProperty("title")
  public String  title;

  @JsonProperty("lastUpdated")
  public String lastUpdated;

  @JsonProperty("subscribers")
  public Integer subscribers;

  @JsonProperty("velocity")
  public Double  velocity;

  @DataField(pos = 3)
  @JsonProperty("website")
  public String  website;

  @JsonProperty("score")
  public Double  score;
  @JsonProperty("coverage")
  public Double  coverage;
  @JsonProperty("coverageScore")
  public Double  coverageScore;
  @JsonProperty("estimatedEngagement")
  public Integer estimatedEngagement;
  @JsonProperty("hint")
  public String  hint;
  @JsonProperty("scheme")
  public String  scheme;
  @JsonProperty("language")
  public String  language;
  @JsonProperty("contentType")
  public String  contentType;
  @JsonProperty("description")
  public String  description;
  @JsonProperty("coverUrl")
  public String  coverUrl;
  @JsonProperty("iconUrl")
  public String  iconUrl;
  @JsonProperty("partial")
  public Boolean partial;
  @JsonProperty("visualUrl")
  public String  visualUrl;
  @JsonProperty("coverColor")
  public String  coverColor;
  @JsonProperty("art")
  public Double  art;

}

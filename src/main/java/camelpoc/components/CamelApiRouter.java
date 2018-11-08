package camelpoc.components;

import camelpoc.domain.FeedItem;
import camelpoc.domain.FeedResults;
import camelpoc.domain.ResultsTransformer;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelApiRouter extends RouteBuilder {

  @Autowired
  ResultsTransformer transformer;

  @Override
  public void configure() {
    from("direct:start")
        .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
        .to("http4://cloud.feedly.com/v3/search/feeds?query=iot")
        .unmarshal(this.dataFormat())
        .bean(ResultsTransformer.class, "getResults")
        .marshal(this.bindy())
        .to("file://content/output");
  }

  GsonDataFormat dataFormat() {
    GsonDataFormat dataFormat = new GsonDataFormat();
    dataFormat.setUnmarshalType(FeedResults.class);
    return dataFormat;
  }

  BindyCsvDataFormat bindy() {
    BindyCsvDataFormat csvDataFormat = new BindyCsvDataFormat(FeedItem.class);
    return csvDataFormat;
  }






}


package cloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RouteFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(RouteFilter.class);

    @Override
    public Object run() {
        logger.info("route filter called");
        // statically routing in the properties file stinks.  Seems like we should be able to route dynamically here.
        RequestContext requestContext = RequestContext.getCurrentContext();
        logger.info(requestContext.getRouteHost().toString());
        return null;
    }

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}

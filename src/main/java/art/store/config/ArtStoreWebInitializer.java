package art.store.config;

import art.store.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ArtStoreWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /* This class is intended to configure ServletDispatcher to take all requests to the web-app
     * (getServletMapping), to configure rootConfigClass and ServletConfigClass
     * This class should extend AbstractAnnotationConfigDispatcherServletInitializer*/

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }
}

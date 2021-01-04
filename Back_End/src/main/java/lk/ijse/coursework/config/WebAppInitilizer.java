package lk.ijse.coursework.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};//parent context
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};// child context
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }//default servlet mapping
}

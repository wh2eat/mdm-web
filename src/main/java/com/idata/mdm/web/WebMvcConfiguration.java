package com.idata.mdm.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.idata.mdm.web.thymeleaf.custom")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // if (LOGGER.isDebugEnabled()) {
        // LOGGER.debug("[][][addResourceHandlers,/static/**->classpath:/static/]");
        // }
        // registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    // @Bean
    // public FilterRegistrationBean getEncodeFilterBean() {
    // EncodeFilter encodeFilter = new EncodeFilter();
    //
    // FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    // registrationBean.setFilter(encodeFilter);
    // List<String> urlPatterns = new ArrayList<>();
    // urlPatterns.add("/*");
    // registrationBean.setUrlPatterns(urlPatterns);
    // registrationBean.setOrder(1);
    //
    // return registrationBean;
    // }
    //
    // @Bean
    // public FilterRegistrationBean getLoginFilterBean() {
    // LoginFilter loginFilter = new LoginFilter();
    //
    // FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    // registrationBean.setFilter(loginFilter);
    // List<String> urlPatterns = new ArrayList<>();
    // urlPatterns.add("/index");
    // registrationBean.setUrlPatterns(urlPatterns);
    // registrationBean.setOrder(2);
    //
    // return registrationBean;
    // }
    //
    // @Configuration
    // @ConditionalOnClass({ FastJsonHttpMessageConverter.class })
    // @ConditionalOnProperty(name = {
    // "spring.http.converters.preferred-json-mapper" }, havingValue = "fastjson",
    // matchIfMissing = true)
    // protected static class FastJson2HttpMessageConverterConfiguration {
    // protected FastJson2HttpMessageConverterConfiguration() {
    // }
    //
    // @Bean
    // @ConditionalOnMissingBean({ FastJsonHttpMessageConverter.class }) // 3
    // public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
    // FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    //
    // FastJsonConfig fastJsonConfig = new FastJsonConfig();// 4
    // fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
    // SerializerFeature.WriteClassName,
    // SerializerFeature.WriteMapNullValue);
    // ValueFilter valueFilter = new ValueFilter() {// 5
    // // o 是class
    // // s 是key值
    // // o1 是value值
    // @Override
    // public Object process(Object o, String s, Object o1) {
    // if (null == o1) {
    // o1 = "";
    // }
    // return o1;
    // }
    // };
    // fastJsonConfig.setSerializeFilters(valueFilter);
    //
    // converter.setFastJsonConfig(fastJsonConfig);
    //
    // return converter;
    // }
    // }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        this.applicationContext = arg0;
    }

    // @Bean
    // public ViewResolver viewResolver() {
    //
    // SpringTemplateEngine engine = new SpringTemplateEngine();
    // engine.setEnableSpringELCompiler(true);
    //
    // SpringResourceTemplateResolver springResourceTemplateResolver = new
    // SpringResourceTemplateResolver();
    // springResourceTemplateResolver.setApplicationContext(applicationContext);
    // springResourceTemplateResolver.setPrefix("/WEB-INF/templates/");
    // springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
    // engine.setTemplateResolver(springResourceTemplateResolver);
    //
    // engine.addDialect("ctag", new CustomTagDialect());
    //
    // if (LOGGER.isDebugEnabled()) {
    // LOGGER.debug("[][config templateEngine][SpringTemplateEngine]");
    // }
    //
    // ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    // resolver.setTemplateEngine(engine);
    // resolver.setCharacterEncoding("UTF-8");
    //
    // if (LOGGER.isDebugEnabled()) {
    // LOGGER.debug("[][viewResolver][----]");
    // }
    //
    // return resolver;
    // }
}

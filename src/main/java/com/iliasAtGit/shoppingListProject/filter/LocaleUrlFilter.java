package com.iliasAtGit.shoppingListProject.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LocaleUrlFilter implements Filter{
    private static final Pattern localePattern = Pattern.compile("^/([a-z]{2})(?:-([a-z]{2}))?(/.*)?");
    public static final String COUNTRY_CODE_ATTRIBUTE_NAME = LocaleUrlFilter.class.getName() + ".country";
    public static final String LANGUAGE_CODE_ATTRIBUTE_NAME = LocaleUrlFilter.class.getName() + ".language";
    public static final String APPL_COUNTRY_CODE_ATTRIBUTE_NAME = "locale.default.countryCode";
    public static final String APPL_LANGUAGE_CODE_ATTRIBUTE_NAME = "locale.default.languageCode";


    private InputStream getResourceFile(String resourceFileName){
    	return getClass().getClassLoader().getResourceAsStream(resourceFileName);
    }

    private boolean checkIfMessageFileExists(String langCode){
    	return (getResourceFile(String.format("messages_%s.properties", langCode)) == null) ? false : true;
    }

    private Properties getProperties(InputStream input){
    	Properties prop = new Properties();
    	try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return prop;
    }
    private Properties getApplProperties(){
		return getProperties(getResourceFile("application.properties"));
    }

    private String calculateLanguageCode(String firstMatch, String secondMatch){
    	if (secondMatch != null)
    		if (checkIfMessageFileExists(secondMatch))
    			return secondMatch;

    	if (checkIfMessageFileExists(firstMatch))
			return firstMatch;

    	return getApplProperties().getProperty(APPL_LANGUAGE_CODE_ATTRIBUTE_NAME);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    		throws IOException, ServletException {

    	HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI().substring(request.getContextPath().length());
        Matcher matcher = localePattern.matcher(url);

        if (matcher.matches()) {
            // Set the language attributes that we will use in LocaleResolver and strip the language from the url
        	request.setAttribute(COUNTRY_CODE_ATTRIBUTE_NAME, matcher.group(1));
        	String calcLanguageCode = calculateLanguageCode(matcher.group(1), matcher.group(2));
        	if (calcLanguageCode != null)
        		request.setAttribute(LANGUAGE_CODE_ATTRIBUTE_NAME, calcLanguageCode);
            request.getRequestDispatcher(matcher.group(3) == null ? "/" : matcher.group(3)).forward(servletRequest, servletResponse);
        }
        else {
        	Properties prop = getApplProperties();
        	if (prop.getProperty(APPL_COUNTRY_CODE_ATTRIBUTE_NAME) != null)
    			request.setAttribute(COUNTRY_CODE_ATTRIBUTE_NAME, prop.getProperty(APPL_COUNTRY_CODE_ATTRIBUTE_NAME));
    		if (prop.getProperty(APPL_LANGUAGE_CODE_ATTRIBUTE_NAME) != null)
    		    request.setAttribute(LANGUAGE_CODE_ATTRIBUTE_NAME, prop.getProperty(APPL_LANGUAGE_CODE_ATTRIBUTE_NAME));
        	filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {}
}

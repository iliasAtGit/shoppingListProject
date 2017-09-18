package com.iliasAtGit.shoppingListProject.resolver;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

import com.iliasAtGit.shoppingListProject.filter.LocaleUrlFilter;

/*
* Set the Locale defined in the LocaleUrlFiltes. If none is defined (in the url) return the request locale.
*/
public class UrlBasedLocaleResolver implements LocaleResolver{

    @Override
    public Locale resolveLocale(HttpServletRequest servletRequest) {
        final String countryCode = (String)servletRequest.getAttribute(LocaleUrlFilter.COUNTRY_CODE_ATTRIBUTE_NAME);
        if (countryCode != null) {
            String languageCode = (String)servletRequest.getAttribute(LocaleUrlFilter.LANGUAGE_CODE_ATTRIBUTE_NAME);
            if (languageCode == null) {
                return new Locale(countryCode);
            }
            return new Locale(languageCode, countryCode);
        }
        return servletRequest.getLocale();
    }

    @Override
    public void setLocale(final HttpServletRequest servletRequest, final HttpServletResponse servletResponse, final Locale locale) {
        throw new UnsupportedOperationException();
    }

}

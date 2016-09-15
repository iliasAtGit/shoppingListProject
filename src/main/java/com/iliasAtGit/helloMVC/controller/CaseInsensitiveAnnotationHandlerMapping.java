package com.iliasAtGit.helloMVC.controller;

import java.util.Map;
import org.springframework.util.AntPathMatcher;

public class CaseInsensitiveAnnotationHandlerMapping extends AntPathMatcher {
	@Override
	protected boolean doMatch(String pattern, String path, boolean fullMatch,
			Map<String, String> uriTemplateVariables) {
		return super.doMatch(pattern.toLowerCase(), path.toLowerCase(), fullMatch, uriTemplateVariables);
	}
}

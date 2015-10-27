package com.lukeyj.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MySimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {
	
	private static Logger LOGGER = Logger.getLogger(MySimpleMappingExceptionResolver.class.getName());

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		String viewName = determineViewName(ex, request);
		LOGGER.info("viewName:" + viewName);
		
		if (viewName != null) {
			Integer statusCode = super.determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			request.setAttribute("error", ex.getMessage());
			return getModelAndView(viewName, ex, request);
		}
		
		return null;

	}
	
}
package com.gotprint.noteapplication.web;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.gotprint.noteapplication.web.provider.AuthenticationFilter;

public class CustomApplication extends ResourceConfig 
{
	public CustomApplication() 
	{
		packages("com.gotprint.noteapplication.web");
		register(LoggingFilter.class);
		
		register(AuthenticationFilter.class);
	}
}

package com.gotprint.noteapplication.web.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




public class NotesNotFoundException extends WebApplicationException {
	 
	  /**
	  * Create a HTTP 404 (Not Found) exception.
	  */
	  public NotesNotFoundException() {
	    super(Response.Status.NOT_FOUND);
	  }
	 
	  /**
	  * Create a HTTP 404 (Not Found) exception.
	  * @param message the String that is the entity of the 404 response.
	  */
	  public NotesNotFoundException(String message) {
	    super(Response.status(Response.Status.NOT_FOUND).
	    entity(message).type(MediaType.APPLICATION_JSON).build());
	  }
	}

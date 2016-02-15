package com.gotprint.noteapplication.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gotprint.noteapplication.core.dao.NotesAppDao;
import com.gotprint.noteapplication.core.dao.hibernate.model.Note;
import com.gotprint.noteapplication.core.dao.impl.NotesAppDaoImpl;
import com.gotprint.noteapplication.web.exception.NotesNotFoundException;

@Path("/userNotesService")
public class UserNotesService {

	
	private NotesAppDao appDao = null;

	public UserNotesService() {
		appDao = new NotesAppDaoImpl();
	}

	

	/**
	 * Get User all notes 
	 * URL GET : /GotPrintUserNoteApplication/rest/userNotesService/getUserNotes/{param}
	 * 
	 * @param userId
	 * @return  user Notes in JSON format
	 */
	@GET
	 @RolesAllowed("ADMIN")
	@Path("/getUserNotes/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getUserNotes(@PathParam("param") String userId) {
		
			System.out.println("userId " + userId);
			List<Note> notes = appDao.getUserNotes(Long.parseLong(userId));

			List<Note> notes2 = new ArrayList<Note>();
			if (notes != null) {
				for (Note note3 : notes) {
					note3.setUser(null);
					notes2.add(note3);
				}
				return notes2;
			}else{
				//No user data found for give user id
				throw new NotesNotFoundException("{exception:User notes not found}");
			}
			
	}

}

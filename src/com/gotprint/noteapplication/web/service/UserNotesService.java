package com.gotprint.noteapplication.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gotprint.noteapplication.core.dao.NotesAppDao;
import com.gotprint.noteapplication.core.dao.hibernate.model.Note;
import com.gotprint.noteapplication.core.dao.hibernate.model.User;
import com.gotprint.noteapplication.core.dao.impl.NotesAppDaoImpl;
import com.gotprint.noteapplication.web.exception.NotesNotFoundException;
import com.gotprint.noteapplication.web.validator.NotesValidation;

@Path("/userNotesService")
public class UserNotesService {

	
	private NotesAppDao appDao = null;

	public UserNotesService() {
		appDao = new NotesAppDaoImpl();
	}

	

	/**
	 * Get User all notes 
	 * URL GET : /GotPrintUserNotesAssignment/rest/userNotesService/getUserNotes/{param}
	 * HEADER : Authorization:gotprint:xxxxxx
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
	
	/**
	 * <p>
	 * URL /GotPrintUserNotesAssignment/rest/userNotesService/addUserNotes/1 < br />
	 * @param userId < br/>
	 * @POST param note  e.g. {"note":"add demo notes", "title":"Title-2" } in JSON format
	 * < br />
	 * @return user Notes in JSON format <br />
	 * </p>
	 */
	@POST
	 @RolesAllowed("ADMIN")
	@Path("/addUserNotes/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> addUserNotes(@PathParam("param") String userId, Note note) {
		System.out.println("note " + note);
		System.out.println("UserId " + userId);
		
		NotesValidation validator = new NotesValidation(); 
		boolean titleValid = validator.noteTitle(note.getTitle());
		boolean noteValid = validator.userNotes(note.getNote());
		if(titleValid && noteValid){
		
		User user = appDao.getUserDetail(Long.parseLong(userId));
		if(user != null){
			note.setCreateTime(new Date());
			note.setUpdateTime(new Date());
			note.setUser(user);
		appDao.addUserNotes(note);
		return getUserNotes(userId);
		}else{
			//No user data found for give user id
			throw new NotesNotFoundException("{exception:User not found}");
		}
		
		}else {
			//No user data found for give user id
			throw new NotesNotFoundException("{exception:Notes data not proper.}");
		}
	}


	
	/**
	 * <p>
	 * URL /GotPrintUserNotesAssignment/rest/userNotesService/updateUserNote/1 < br />
	 * @param userId < br/>
	 * @POST param note  e.g. {"noteId":1, "note":"22 sdfsdfsd sdfds test", "title":"2-Notes 111" } in JSON format
	 * < br />
	 * @return user Notes in JSON format <br />
	 * </p>
	 */
	@PUT
	 @RolesAllowed("ADMIN")
	@Path("/updateUserNote/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> updateUserNote(@PathParam("param") String userId, Note note) {
		System.out.println("note " + note);
		System.out.println("UserId " + userId);
		
		NotesValidation validator = new NotesValidation(); 
		boolean titleValid = validator.noteTitle(note.getTitle());
		boolean noteValid = validator.userNotes(note.getNote());
		
		if(titleValid  && noteValid){
		//check user id and note id present in database
		Note note2 = appDao.getNote(Long.parseLong(userId),note.getNoteId());
		if(note2  != null){ 
			note2.setUpdateTime(new Date());
			copyUserNote(note,note2);
			appDao.updateUserNotes(note2);
		return getUserNotes(userId);
		}else{
			//No user data found for give user id
			throw new NotesNotFoundException("{exception:User or notes not found}");
		}
		}else {
			// not valid data
			throw new NotesNotFoundException("{exception:User Note data not proper}");
		}

	}
	
	/**
	 * Copy note data
	 * @param note
	 * @param note2
	 */
	private void copyUserNote(final Note note, Note note2){
		if(note.getNoteId() != 0){
			note2.setNoteId(note.getNoteId());
		}
		if(note.getTitle() != null){
		note2.setTitle(note.getTitle());
		}
		if(note.getNote() != null){
			note2.setNote(note.getNote());
		}
		if(note.getCreateTime() != null){
			note2.setCreateTime(note.getCreateTime());
		}else{
			note2.setCreateTime(new Date());
		}if(note.getUser() != null){
			note2.setNote(note.getNote());
		}
		
	}

}

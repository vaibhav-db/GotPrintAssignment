package com.gotprint.noteapplication.core.dao;

import java.util.List;

import com.gotprint.noteapplication.core.dao.hibernate.model.Note;
import com.gotprint.noteapplication.core.dao.hibernate.model.User;

public interface NotesAppDao {

	public List<Note> getUserNotes(long UserId) ;
	
	public User getUserDetail(final long UserId) ;
	
	public void addUserNotes(final Note note) ;
	
	public void updateUserNotes(final Note note) ;
	
	public Note getNote(long userId, long noteId) ;
}


package com.gotprint.noteapplication.core.dao;

import java.util.List;

import com.gotprint.noteapplication.core.dao.hibernate.model.Note;

public interface NotesAppDao {

	public List<Note> getUserNotes(long UserId) ;
}

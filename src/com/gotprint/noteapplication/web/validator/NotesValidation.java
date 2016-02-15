package com.gotprint.noteapplication.web.validator;

public class NotesValidation {

	public NotesValidation() {

	}
	
	public boolean noteTitle(final String title){
		if(title == null || title.length() >50){
			return false;
		}
		
		return true;
	}
	
	public boolean userNotes(final String notes){
		if(notes != null && notes.length() >1000){
			return false;
		}
		
		return true;
	}
	
}

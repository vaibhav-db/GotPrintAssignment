package com.gotprint.noteapplication.core.dao.hibernate.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 *
 * @author Vaibhav Mankar <br />
 *         Note POJO classs
 *         </p>
 */

@XmlRootElement(name = "note")
public class Note {

	private long noteId;
	private String title;
	private String note;
	private Date createTime;
	private Date updateTime;
	private User user;

	public Note() {

	}

	public Note(long noteId, String title, String note, Date createTime,
			Date updateTime) {
		super();
		this.noteId = noteId;
		this.title = title;
		this.note = note;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public long getNoteId() {
		return noteId;
	}

	@XmlElement
	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	@XmlElement
	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateTime() {
		return createTime;
	}

	@XmlElement
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	@XmlElement
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public User getUser() {
		return user;
	}

	@XmlElement
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (noteId ^ (noteId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (noteId != other.noteId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", note=" + note
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+  "]";
	}

	
	
	
}

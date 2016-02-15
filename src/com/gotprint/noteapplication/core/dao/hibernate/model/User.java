package com.gotprint.noteapplication.core.dao.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 *
 * @author Vaibhav Mankar <br />
 *         User POJO class
 *         </p>
 */
@XmlRootElement(name = "user")
public class User implements Serializable {
	private long userId;
	private String email;
	private String password;
	private Date createTime;
	private Date updateTime;
	private Set<Note> notes = new HashSet<Note>(0);;

	public User() {

	}

	public User(long userId, String email, String password, Date createTime,
			Date updateTime) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public long getUserId() {
		return userId;
	}

	@XmlElement
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
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

	public Set<Note> getNotes() {
		return notes;
	}

	@XmlElement
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password="
				+ password + ", createTime=" + createTime + ", updateTime="
				+ updateTime + " notes "+notes+"]";
	}

	
	
}

package com.gotprint.noteapplication.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.gotprint.noteapplication.core.dao.NotesAppDao;
import com.gotprint.noteapplication.core.dao.hibernate.model.Note;
import com.gotprint.noteapplication.core.dao.hibernate.model.User;
import com.gotprint.noteapplication.utility.HibernateUtil;

public class NotesAppDaoImpl implements NotesAppDao {

	private SessionFactory sessionFactory = null;

	public NotesAppDaoImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public List<Note> getUserNotes(long UserId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<User> users = session.createCriteria(User.class)
				.add(Restrictions.eq("userId", UserId)).list();
		if (users != null && !users.isEmpty()) {
			return new ArrayList(users.get(0).getNotes());
		}

		return null;

	}
	
	public User getUserDetail(final long UserId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<User> users = session.createCriteria(User.class)
				.add(Restrictions.eq("userId", UserId)).list();
		if (users != null && !users.isEmpty()) {
			return  users.get(0);
		}

		return null;
	}
	
	public void addUserNotes(final Note note) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(note );
        session.getTransaction().commit();
	}


	public void updateUserNotes(final Note note) {
		Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.saveOrUpdate(note );
        session.getTransaction().commit();
	}
	
	public Note getNote(long userId, long noteId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Note> notes = session.createCriteria(Note.class)
				.add(Restrictions.eq("user.userId", userId))
						.add(Restrictions.eq("noteId", noteId)).list();
		if (notes != null && !notes.isEmpty()) {
			return notes.get(0);
		}

		return null;

	}


	
}

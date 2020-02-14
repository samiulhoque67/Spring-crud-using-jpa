package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Student;
import com.luv2code.springdemo.service.Studentservice;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private Studentservice srudentservice;
	//@Autowired
 //   private JavaMailSender javaMailSender;
	@Autowired
	private SessionFactory sessionFactory;

@Override
@Transactional
	public List<Student> getStudents() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("from Student");

		// execute query and get result list
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		Session currentSession = sessionFactory.getCurrentSession();
	
		// save employee

		currentSession.saveOrUpdate(student);

	}

	@Override
	@Transactional
	public Student get(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, theId);

		return student;
	}

	@Override
	@Transactional
	public void delete(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);

		theQuery.executeUpdate();
	}
/*/
	@Override
	@Transactional
	public Student mail(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student=entityManager.find(Student.class,theId);
		String email=student.getEmail();
		String username=student.getL_name();
		
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Test Message");
        msg.setText("Hello "+username+".\nTake love");

        javaMailSender.send(msg);
		//Query theQuery = entityManager.createQuery("select email from Student where Student.id=:theId");
		return student;
	}
	
/*/

	
}

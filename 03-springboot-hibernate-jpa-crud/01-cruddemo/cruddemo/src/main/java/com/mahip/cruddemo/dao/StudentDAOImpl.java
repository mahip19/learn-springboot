package com.mahip.cruddemo.dao;

import com.mahip.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

//  define fields for entity manager
    private EntityManager entityManager;
//    inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    implement save method
    @Override
    @Transactional
    public void save(Student student) {
//        saves student obj to database
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(Integer Id) {
        return entityManager.find(Student.class, Id);
    }

    @Override
    public List<Student> findAll() {
//        query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

//        return res
        return query.getResultList();
    }


}

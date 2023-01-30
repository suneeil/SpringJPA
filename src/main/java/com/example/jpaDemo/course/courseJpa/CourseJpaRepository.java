package com.example.jpaDemo.course.courseJpa;

import com.example.jpaDemo.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional  //when ever we are using JPA we need to use @Transactional
public class CourseJpaRepository {
    @PersistenceContext  //Similar to AutoWired but good to use for EntityManager and this managers the Beans
    private EntityManager entityManager; //Talks to Database

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}

package com.example.jpaDemo.course;

import com.example.jpaDemo.course.courseJpa.CourseJpaRepository;
import com.example.jpaDemo.course.springDataJpa.CourseSpringDataJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());


    /*@Autowired
    private CourseJdbcRepository repository;*/

    /*@Autowired
    private CourseJpaRepository repository;*/

    @Autowired
    private CourseSpringDataJpa repository;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info(">>>>>>>>>>>>>>>>>>>> CommandLineRunner");
        //repository.insert(new Course(1, "Learn AWS course", "in28min")); >>> using CourseJpaRepository
        repository.save(new Course(1, "Learn AWS course", "in28min"));

        //repository.insert(new Course(2, "Learn Java language", "in10min"));
        repository.save(new Course(2, "Learn Java language", "in10min"));
        //repository.insert(new Course(3, "Learn Python language", "in20min"));
        repository.save(new Course(3, "Learn Python language", "in20min"));
        repository.save(new Course(4, "Learn Protractor", "in10min"));
        repository.save(new Course(5, "Learn SQL", "in30min"));
        repository.deleteById(1L);
        //Course courseById2 = repository.findById(2l);
        Optional<Course> courseById2 = repository.findById(2L);
        //Course courseById3 = repository.findById(3L);
        Optional<Course> courseById3 =  repository.findById(3L);
        LOGGER.info("Course By Id-2 = {}", courseById2);
        LOGGER.info("Course By Id-3 = {}", courseById3);
        LOGGER.info("All Courses : {}", repository.findAll());
        LOGGER.info("Count : {}", repository.count());
        LOGGER.info("Find By Author = in10min : {}", repository.findByAuthor("in10min"));
        LOGGER.info("Find By Author = sunil: {}", repository.findByAuthor("sunil"));
        LOGGER.info("Find By name = Learn Protractor : {}", repository.findByName("Learn Protractor"));
        LOGGER.info("Find By name = Learn SQL: {}", repository.findByName("Learn SQL"));
    }
}

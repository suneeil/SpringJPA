package com.example.jpaDemo.course.courseJdbc;

import com.example.jpaDemo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * The Table is created using the schema.sql under src/resources
 */
@Repository //@Repository >>> this class talks to DB
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY = """
            insert into course (id, name, author) values(?,?,?);
            """;
    private static String DELETE_QUERY = """
            delete from course 
            where id = ?;
            """;

    private static String SELECT_QUERY = """
            select * from course 
            where id = ?;
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(Long id) {
        //When we fire the query we will a row which is of type "resultSet"
        //To Map "resultSet" to a "bean" i.e. Course bean we use "rowMappers" --> BeanPropertyRowMapper
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}

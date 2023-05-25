package com.lax.sms.repository;

import com.lax.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
//@Transactional
/*
@Repository & @Transactional its optional
SimpleJpaRepository is Implementation class of JpaRepository which will provide
@Repository  & @Transactional annotation
*/
public interface StudentRepository extends JpaRepository<Student, Long> {
}

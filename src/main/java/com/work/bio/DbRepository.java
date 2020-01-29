package com.work.bio;

import com.work.bio.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DbRepository extends JpaRepository<Person,Long> {

}
package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Integer> {
}

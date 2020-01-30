package com.work.bio;

import com.work.bio.ResourceNotFoundException;
import com.work.bio.Person;
import com.work.bio.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    DbRepository dbRepository;

    // Get All People
    @GetMapping("/people")
    public List<Person> getPeople() {
        return dbRepository.findAll();
    }

    @PostMapping("/people")
    public Person createPerson(@Valid @RequestBody Person person) {
        return dbRepository.save(person);
    }

    // Get 1 person
    @GetMapping("/people/{id}")
    public Person getPersonById(@PathVariable(value = "id") Long pId) {
        return dbRepository.findById(pId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", pId));
    }


    // Update
    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable(value = "id") Long pId,
                           @Valid @RequestBody Person pDetails) {

        Person person = dbRepository.findById(pId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", pId));

        person.setName(pDetails.getName());
        person.setSex(pDetails.getSex());
        person.setAge(pDetails.getAge());

        Person updatedPerson = dbRepository.save(person);

        
        return updatedPerson;
    }

    // Delete
    @DeleteMapping("/people/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long pId) {
        Person person = dbRepository.findById(pId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", pId));

        dbRepository.delete(person);

        return ResponseEntity.ok().build();
    }
}
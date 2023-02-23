package com.example.springrestdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springrestdemo.model.Tutorial;


@RepositoryRestResource(path = "learningtutorials")
public interface TutorialRepository extends JpaRepository<Tutorial, Long>
{
     //   findByPublished is a custom method()
    List<Tutorial> findByPublished(boolean published);
}

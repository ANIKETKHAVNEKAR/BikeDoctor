package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Statuses;

@Repository
public interface StatusesRepository extends JpaRepository<Statuses, Integer> {

}

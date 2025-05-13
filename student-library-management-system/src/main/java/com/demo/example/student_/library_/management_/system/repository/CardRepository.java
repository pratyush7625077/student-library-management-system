package com.demo.example.student_.library_.management_.system.repository;

import com.demo.example.student_.library_.management_.system.model.Author;
import com.demo.example.student_.library_.management_.system.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}

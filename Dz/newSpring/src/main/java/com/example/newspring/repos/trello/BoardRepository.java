package com.example.newspring.repos.trello;

import com.example.newspring.entities.trello.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}

package com.example.newspring.repos.trello;

import com.example.newspring.entities.trello.Cell;
import com.example.newspring.entities.trello.ColumnTrello;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CellRepository extends CrudRepository<Cell, Long> {
    Cell findByColumnId(Long id);

    void deleteAllByColumnId(Long column_id);

    List<Cell> findAllByColumnId(Long column_id);
}

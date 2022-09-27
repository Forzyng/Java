package com.example.newspring.repos.trello;

import com.example.newspring.entities.trello.Board;
import com.example.newspring.entities.trello.ColumnTrello;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColumnTrelloRepository extends CrudRepository<ColumnTrello, Long> {
    ColumnTrello findByBoardId(Long id);

    //void deleteAllByBoardId(Long board_id);

    @Modifying
    @Query("delete from ColumnTrello b where b.board=:board_id")
    void deleteAllByBoardId(@Param("board_id") Long board_id);

    List<ColumnTrello> findAllByBoardId(Long board_id);
}

/*public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}*/


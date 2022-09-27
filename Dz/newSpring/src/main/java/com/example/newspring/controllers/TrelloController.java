package com.example.newspring.controllers;

import com.example.newspring.entities.trello.Board;
import com.example.newspring.entities.trello.Cell;
import com.example.newspring.entities.trello.ColumnTrello;
import com.example.newspring.repos.trello.BoardRepository;
import com.example.newspring.repos.trello.CellRepository;
import com.example.newspring.repos.trello.ColumnTrelloRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class TrelloController {
    private final BoardRepository boardRepository;
    private final ColumnTrelloRepository columnTrelloRepository;
    private final CellRepository cellRepository;

    public TrelloController(BoardRepository boardRepository, ColumnTrelloRepository columnTrelloRepository, CellRepository cellRepository) {
        this.boardRepository = boardRepository;
        this.columnTrelloRepository = columnTrelloRepository;
        this.cellRepository = cellRepository;
    }

    //////////////////////// BOARDS ////////////////////////////
    @GetMapping("/boards")
    public String boards(Model model){
        model.addAttribute("boards", boardRepository.findAll());
        return "/trello/trello-main";
    }


    @GetMapping("/board/update/{id}")
    public String updateRBoard(
            Model model,
            @PathVariable(name="id") Long id
    ){
        Board p = boardRepository.findById(id).get();
        model.addAttribute("board", p);
        return "/trello/trello-all-boards-update";
    }

    // Delete board

    @GetMapping("/board/delete/{id}")
    public RedirectView deleteBoard(
            @PathVariable(name="id") Long id
    ) {

        //columnTrelloRepository.deleteAllByBoardId(id);/*findAllByBoardId(id);*/
        List<ColumnTrello> listColumns = columnTrelloRepository.findAllByBoardId(id);
        for (ColumnTrello column: listColumns
             ) {
            List<Cell> listCells = cellRepository.findAllByColumnId(column.getId());
            for (Cell cell: listCells
            ) {
                cellRepository.deleteById(cell.getId());
            }
            columnTrelloRepository.deleteById(column.getId());
        }

        boardRepository.deleteById(id);
        return new RedirectView("/boards");
    }

    // Create board

    @PostMapping("/board/create")
    public RedirectView createBoard(Board board){
        boardRepository.save(board);
        return new RedirectView("/boards");
    }


    /////////////////////// COLUMNS ///////////////////////////


    @GetMapping("/board/{board_id}/columns")
    public String columns(Model model, @PathVariable(name="board_id") Long board_id){
        model.addAttribute("columns", columnTrelloRepository.findAllByBoardId(board_id));
        model.addAttribute("board_id", board_id);
        return "/trello/trello-column";
    }

    @PostMapping("/board/{board_id}/column/create")
    public RedirectView createColumn(ColumnTrello columnTrello, @PathVariable(name="board_id") Long board_id){
        columnTrello.setBoard(boardRepository.findById(board_id).get());
        columnTrelloRepository.save(columnTrello);
        return new RedirectView("/board/"+ board_id +"/columns");
    }

    @PostMapping("/column/update")
    public RedirectView tryUpdateColumn(ColumnTrello columnTrello, @Param("board_id") Long board_id){

        columnTrello.setBoard(boardRepository.findById(board_id).get());
        columnTrelloRepository.save(columnTrello);
        return new RedirectView("/board/"+ board_id +"/columns");
    }

    @GetMapping("/board/{board_id}/column/update/{id}")
    public String updateRColumn(
            Model model,
            @PathVariable(name="id") Long id,
            @PathVariable(name="board_id") Long board_id){
        model.addAttribute("boards", boardRepository.findAll());
        ColumnTrello p = columnTrelloRepository.findById(id).get();
        model.addAttribute("column", p);
        return "/trello/trello-column-update";
    }

    // Delete board

    @GetMapping("/board/{board_id}/column/delete/{id}")
    public RedirectView deleteColumn(
            @PathVariable(name="id") Long id,
            @PathVariable(name="board_id") Long board_id) {

        columnTrelloRepository.deleteById(id);
        return new RedirectView("/board/" + board_id +"/columns");
    }

    // Create board


}

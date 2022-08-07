package com.techelevator.controller;

import com.techelevator.dao.kanban.KanbanDAO;
import com.techelevator.model.cat.CatFact;
import com.techelevator.model.cat.CatPic;
import com.techelevator.model.kanban.Board;
import com.techelevator.model.kanban.Card;
import com.techelevator.services.cat.CatFactService;
import com.techelevator.services.cat.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
//https://www.jsonschema2pojo.org/ (for converting JSON to java
@RestController
//@CrossOrigin
@CrossOrigin(origins = "http://localhost:8080")
public class KanbanController {

    private final KanbanDAO kanbanDAO;
    private final CatFactService catFact;
    private final CatPicService catPic;

    public KanbanController(KanbanDAO kanbanDAO, CatFactService catFact, CatPicService catPic) {
        this.kanbanDAO = kanbanDAO;
        this.catFact = catFact;
        this.catPic = catPic;
    }

    @GetMapping("/boards")
    public List<Board> getBoards() throws InterruptedException {
        Thread.sleep(2000); //Simulated loading time

        return kanbanDAO.getAllBoards();
    }

    @GetMapping("/boards/{id}")
    public Board getBoard(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Board result = kanbanDAO.getBoard(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No board with that id.");
        } else {
            return result;
        }
    }

    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable long id) throws InterruptedException {
        Thread.sleep(1000); //Simulated loading time

        Card result = kanbanDAO.getCard(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No card with that id.");
        } else {
            return result;
        }
    }

    @PostMapping("/boards")
    @ResponseStatus(HttpStatus.CREATED)
    public Board postBoard(@RequestBody Board newBoard) {
        return kanbanDAO.createBoard(newBoard);
    }

    @PostMapping("/cards")
    @ResponseStatus(HttpStatus.CREATED)
    public Card postCard(@Valid @RequestBody Card newCard, @RequestParam("meow") Optional<Boolean> meow) throws InterruptedException {

        if (meow.isPresent()) {

            String description =
                    String.format("%s\n%s", catFact.getFact().getText(), newCard.getDescription());
            newCard.setDescription(description);
            newCard.setAvatar(catPic.getPic().getFile());

        }
        return kanbanDAO.createCard(newCard.getBoardId(), newCard);
    }

    @PutMapping("/cards/{id}")
    public Card putCard(@PathVariable long id, @RequestBody Card updatedCard) {
        updatedCard.setId(id);
        if (kanbanDAO.updateCard(updatedCard)) {
            return updatedCard;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found to update.");
        }
    }

    @DeleteMapping("/boards/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteBoard(@PathVariable long id) {
        if (!kanbanDAO.deleteBoard(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found to delete.");
        }
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCard(@PathVariable long id) {
        if (!kanbanDAO.deleteCard(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found to delete.");
        }
    }



}

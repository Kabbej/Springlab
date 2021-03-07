package se.iths.springlab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springlab.entities.FootballPlayer;
import se.iths.springlab.repositories.FootBallPlayerRepository;

import java.util.List;

@RestController
public class Controller {

    private FootBallPlayerRepository footBallPlayerRepository;

    @GetMapping("/footballplayers")
    public List <FootballPlayer> all(){
        return footBallPlayerRepository.findAll();
    }

//    @GetMapping("/id/{id}")
//    public FootBallPlayerRepository findFootBallPlayerByID(@PathVariable long id) {
//        return footBallPlayerRepository.getOne(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " not found."));
//    }
}

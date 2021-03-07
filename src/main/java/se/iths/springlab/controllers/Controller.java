package se.iths.springlab.controllers;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.iths.springlab.dto.FirstNameDto;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.service.Service;

import java.util.List;

@Data
@RestController
public class Controller {

    private final Service service;

    public Controller (Service service){
        this.service=service;
    }


    //POST (create) method with 201 CREATED HTTP response
    @PostMapping("/footballplayers")
    @ResponseStatus(HttpStatus.CREATED)
    public FootBallPlayerDto createFootballPlayer(@RequestBody FootBallPlayerDto footballPlayer) {
        return service.createFootballPlayer(footballPlayer);
    }

    //GET (read) method
    @GetMapping("/footballplayers/")
    public List<FootBallPlayerDto> getAll(){
        return service.getAll();
    }

    @PutMapping("/footballplayers/{id}")
    public FootBallPlayerDto replace(@RequestBody FootBallPlayerDto footBallPlayerDto, @PathVariable long id){
        return service.replace(id, footBallPlayerDto);
    }

    @PatchMapping("/footballplayers/{id}")
    public FootBallPlayerDto update(@RequestBody FirstNameDto firstNameDto, @PathVariable long id){
        return service.updateFirstName(id, firstNameDto);

    }

    @DeleteMapping("/footballplayers/delete/{id}")
    public boolean deleteFootballPlayer(@PathVariable long id){
        service.delete(id);
        return true;
    }

    @GetMapping("/footballplayers/{firstname}")
    public List<FootBallPlayerDto>searchByFirstName(@PathVariable String firstname){
        return service.searchByFirstName(firstname);
    }



}

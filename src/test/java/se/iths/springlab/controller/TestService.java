package se.iths.springlab.controller;

import se.iths.springlab.controllers.Controller;
import se.iths.springlab.dto.FirstNameDto;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.entities.FootballPlayer;
import se.iths.springlab.service.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public FootBallPlayerDto createFootballPlayer(FootBallPlayerDto footBallPlayer) {
        return new FootBallPlayerDto(1,"Kabbe","Jartun","IFK");
    }

    @Override
    public Optional<FootBallPlayerDto> getOne(long id) {
        return Optional.of(new FootBallPlayerDto(1,"Kabbe","Jartun","IFK"));
    }

    @Override
    public List<FootBallPlayerDto> findByFirstname(String firstName) {
        if(firstName.equals("Kabbe"))
        return List.of(new FootBallPlayerDto(1,"Kabbe","Jartun","IFK"));
        else return null;
    }

    @Override
    public List<FootBallPlayerDto> searchByFirstName(String firstName) {
        if(firstName.equals("Kabbe"))
            return List.of(new FootBallPlayerDto(1,"Kabbe","Jartun","IFK"));
        else return null;
    }

    @Override
    public FootBallPlayerDto updateFirstName(long id, FirstNameDto firstNameDto) {
        return null;
    }

    @Override
    public FootBallPlayerDto replace(Long id, FootBallPlayerDto footBallPlayerDto) {
        FootBallPlayerDto newPlayer = new FootBallPlayerDto(1,"Test", "Test","Test");
        return newPlayer;
    }

    @Override
    public void delete(long id) {

    }
}

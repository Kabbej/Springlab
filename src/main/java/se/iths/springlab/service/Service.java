package se.iths.springlab.service;

import java.util.List;
import java.util.Optional;

import se.iths.springlab.dto.FirstNameDto;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.entities.FootballPlayer;


public interface Service {

    FootBallPlayerDto createFootballPlayer(FootBallPlayerDto footBallPlayer);

    Optional<FootBallPlayerDto> getOne(long id);
    List<FootBallPlayerDto>findByFirstname (String firstName);

    List<FootBallPlayerDto>searchByFirstName (String firstName);

    FootBallPlayerDto updateFirstName (long id, FirstNameDto firstNameDto);
    FootBallPlayerDto replace (Long id, FootBallPlayerDto footBallPlayerDto);

    void delete (long id);


}

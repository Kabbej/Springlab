package se.iths.springlab.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.entities.FootballPlayer;
import se.iths.springlab.repositories.FootBallPlayerRepository;

public class FootBallPlayerService implements se.iths.springlab.service.service {

    private FootBallPlayerRepository footBallPlayerRepository;

    public FootBallPlayerService (FootBallPlayerRepository footBallPlayerRepository){
        this.footBallPlayerRepository =footBallPlayerRepository;
    }

    public FootBallPlayerDto createFootballPlayer(FootBallPlayerDto footBallPlayer) {
        //validate here
        if ((footBallPlayer.getFirstName() == null))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        else return null;
    }

}

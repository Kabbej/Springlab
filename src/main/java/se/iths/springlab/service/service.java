package se.iths.springlab.service;

import java.util.List;
import java.util.Optional;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.entities.FootballPlayer;


public interface service {

    FootballPlayer createFootballPlayer(FootBallPlayerDto footBallPlayer);


}

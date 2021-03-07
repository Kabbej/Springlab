package se.iths.springlab.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springlab.dto.FirstNameDto;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.mappers.FootballPlayerMapper;
import se.iths.springlab.repositories.FootBallPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootBallPlayerService implements se.iths.springlab.service.Service {

    private FootBallPlayerRepository footBallPlayerRepository;

    private final FootballPlayerMapper footballPlayerMapper = new FootballPlayerMapper();

    public FootBallPlayerService (FootBallPlayerRepository footBallPlayerRepository){
        this.footBallPlayerRepository =footBallPlayerRepository;
    }

    public FootBallPlayerDto createFootballPlayer(FootBallPlayerDto footBallPlayer){
        if((footBallPlayer.getFirstName() == null))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        else return footballPlayerMapper.map(footBallPlayerRepository.save(footballPlayerMapper.map(footBallPlayer)));
    }

    @Override
    public List<FootBallPlayerDto> getAll() {
        return null;
    }

    @Override
    public List<FootBallPlayerDto> findByFirstname(String firstName) {
        return null;
    }

    @Override
    public List<FootBallPlayerDto> searchByFirstName(String firstName) {
        return null;
    }

    @Override
    public FootBallPlayerDto updateFirstName(long id, FirstNameDto firstNameDto) {
        return null;
    }

    @Override
    public FootBallPlayerDto replace(Long id, FootBallPlayerDto footBallPlayerDto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

}

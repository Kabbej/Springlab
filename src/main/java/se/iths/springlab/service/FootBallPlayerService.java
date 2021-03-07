package se.iths.springlab.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springlab.dto.FirstNameDto;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.entities.FootballPlayer;
import se.iths.springlab.mappers.FootballPlayerMapper;
import se.iths.springlab.repositories.FootBallPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<FootBallPlayerDto> getOne(long id) {
        return footballPlayerMapper.map(footBallPlayerRepository.findById(id));
    }


    @Override
    public List<FootBallPlayerDto> findByFirstname(String firstName) {
        return footballPlayerMapper.map(footBallPlayerRepository.findAllByFirstName(firstName));
    }

    @Override
    public List<FootBallPlayerDto> searchByFirstName(String firstName) {
        return footballPlayerMapper.map(footBallPlayerRepository.findAllByFirstName(firstName));
    }

    @Override
    public FootBallPlayerDto updateFirstName(long id, FirstNameDto firstNameDto) {
        Optional<FootballPlayer> player = footBallPlayerRepository.findById(id);
        if(player.isPresent()){
            FootballPlayer updatedPlayer = player.get();
            if(updatedPlayer.getFirstName()!=null)
                updatedPlayer.setFirstName(firstNameDto.firstName);
                return footballPlayerMapper.map(footBallPlayerRepository.save(updatedPlayer));
            }

        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " hittades inte.");
    }

    @Override
    public FootBallPlayerDto replace(Long id, FootBallPlayerDto footBallPlayerDto) {
        Optional<FootballPlayer> player = footBallPlayerRepository.findById(id);
        if(player.isPresent()){
            FootballPlayer newPlayer = player.get();
            newPlayer.setFirstName(footBallPlayerDto.getFirstName());
            newPlayer.setLastName(footBallPlayerDto.getLastName());
            newPlayer.setTeam(footBallPlayerDto.getTeam());
            return footballPlayerMapper.map(footBallPlayerRepository.save(newPlayer));
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " hittades inte.");

    }

    @Override
    public void delete(long id) {
        if(footBallPlayerRepository.existsById(id)){
            footBallPlayerRepository.deleteById(id);
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " hittades inte.");

    }

}

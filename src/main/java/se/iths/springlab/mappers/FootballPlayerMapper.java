package se.iths.springlab.mappers;

import org.springframework.stereotype.Component;
import se.iths.springlab.dto.FootBallPlayerDto;
import se.iths.springlab.entities.FootballPlayer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FootballPlayerMapper {

    public FootballPlayerMapper (){

    }

    public FootBallPlayerDto map(FootballPlayer footballPlayer){
        return new FootBallPlayerDto(footballPlayer.getId(), footballPlayer.getFirstName(), footballPlayer.getLastName(),
                footballPlayer.getTeam());
    }

    public FootballPlayer map(FootBallPlayerDto footBallPlayerDto){
        return new FootballPlayer(footBallPlayerDto.getId(), footBallPlayerDto.getFirstName(), footBallPlayerDto.getLastName(),
                footBallPlayerDto.getTeam());
    }

    public List<FootBallPlayerDto> map(List <FootballPlayer> all){
        return all
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Optional<FootBallPlayerDto> map (Optional<FootballPlayer> optionalFootballPlayer){
        if (optionalFootballPlayer.isEmpty())
            return Optional.empty();
        return Optional.of(map(optionalFootballPlayer.get()));
    }

}

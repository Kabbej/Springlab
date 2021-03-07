package se.iths.springlab.controller;

import org.assertj.core.error.ShouldHaveSizeGreaterThanOrEqualTo;
import org.junit.jupiter.api.Test;
import se.iths.springlab.controllers.Controller;
import se.iths.springlab.dto.FootBallPlayerDto;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ControllerTest {
    Controller controller = new Controller(new TestService());


    @Test
    void checkingOnePlayerById (){
        var footballPlayer = controller.getOne(1);
        System.out.println(footballPlayer);

    }

    @Test
    void createPlayerTest(){
        var newPlayer = controller.createFootballPlayer((new FootBallPlayerDto()));
        assertThat(newPlayer.getFirstName()).isEqualTo("Kabbe");
        assertThat(newPlayer.getLastName()).isEqualTo("Jartun");
        assertThat(newPlayer.getTeam()).isEqualTo("IFK");
    }

   @Test
   void searchPlayer(){
        List<FootBallPlayerDto> list = controller.searchByFirstName("Kabbe");
        assertEquals(list.size(), 1);
        assertThat(list.get(0).getLastName()).isEqualTo("Jartun");

   }

   @Test
    void updatePlayer(){
        var player = controller.replace(new FootBallPlayerDto(2,"Test","Test","Test"),1);

        assertThat(player.getFirstName()).isEqualTo("Test");
  }






}

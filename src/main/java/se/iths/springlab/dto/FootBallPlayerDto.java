package se.iths.springlab.dto;


import lombok.*;

@Data
@NoArgsConstructor
public class FootBallPlayerDto {
    //DataTransferObjects

    private long id;
    private String firstName;
    private String lastName;
    private String team;


    public FootBallPlayerDto(long id, String firstName, String lastName, String team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}

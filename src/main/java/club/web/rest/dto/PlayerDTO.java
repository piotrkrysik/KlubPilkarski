package club.web.rest.dto;

import lombok.Data;

@Data
public class PlayerDTO {
    private String name;
    private String photoUrl;
    private int coachId;
    private float marketValue;
}
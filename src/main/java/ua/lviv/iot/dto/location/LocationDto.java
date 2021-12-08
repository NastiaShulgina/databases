package ua.lviv.iot.dto.location;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LocationDto {

    private Integer id;

    private String city;

    private String street;

    private String office;

    private Integer roomNumber;

    private Integer workplaceNumber;

}

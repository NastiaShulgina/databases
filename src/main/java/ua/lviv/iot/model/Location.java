package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "location")
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "office", nullable = false)
    private String office;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "workplace_number")
    private Integer workplaceNumber;

    @OneToOne(fetch = FetchType.EAGER)
    private ResponsibleWorker responsibleWorker;

    @OneToOne(mappedBy = "location", fetch = FetchType.EAGER)
    private Application application;
}

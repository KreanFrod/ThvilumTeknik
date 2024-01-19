package dk.thvilum.TT.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tt_prototype", schema= "webgis_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String print_title;
    private String adresse_tegningshoved;
    private String adresse2_tegningshoved;
    private String postnrby_tegningshoved;
    private String kommunenavn;
    private String htnr;
    private String aftale_paa_plads;
    private String cvrnr;

}
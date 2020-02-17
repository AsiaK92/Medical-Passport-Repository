package pl.sda.medicalpassport.infrastructure.user.entity;

import lombok.*;
import pl.sda.medicalpassport.infrastructure.dto.MedicalHistoryDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_history")
@EqualsAndHashCode
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medical_history")
    private Long id;

    @Column(name = "disease")
    private String disease;

    @Column(name = "sicknessStart")
    private LocalDate sicknessStart;

    @Column(name = "sicknessEnd")
    private LocalDate sicknessEnd;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private LoginData loginData;



    public MedicalHistoryDTO toDTO(){
        return MedicalHistoryDTO.builder()
                .id(id)
                .sicknessStart(sicknessStart)
                .sicknessEnd(sicknessEnd)
                .disease(disease)
                .description(description)
                .loginData(loginData)
                .build();
    }

}

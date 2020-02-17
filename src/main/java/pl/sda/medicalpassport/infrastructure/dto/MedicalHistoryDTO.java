package pl.sda.medicalpassport.infrastructure.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.medicalpassport.infrastructure.user.entity.LoginData;

import java.time.LocalDate;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistoryDTO {

    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sicknessStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sicknessEnd;
    private String disease;
    private String description;
    private LoginData loginData;

}

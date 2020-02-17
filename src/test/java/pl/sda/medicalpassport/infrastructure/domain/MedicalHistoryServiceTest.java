package pl.sda.medicalpassport.infrastructure.domain;

import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.medicalpassport.infrastructure.dto.MedicalHistoryDTO;
import pl.sda.medicalpassport.infrastructure.user.entity.MedicalHistory;
import pl.sda.medicalpassport.infrastructure.user.repozitory.MedicalHistoryRepository;
import pl.sda.medicalpassport.infrastructure.HistoryFinder;

import java.time.LocalDate;

public class MedicalHistoryServiceTest {

    private MedicalHistoryRepository medicalHistoryRepository = Mockito.mock(MedicalHistoryRepository.class);
    private HistoryFinder historyFinder = Mockito.mock(HistoryFinder.class);


    private MedicalHistoryService medicalHistoryService = new MedicalHistoryService(medicalHistoryRepository, historyFinder);

    @Test
    public void shouldCreateNewSickHistory() {
        //given
        MedicalHistoryDTO medHistoryDTO = MedicalHistoryDTO.builder()
                .sicknessStart(LocalDate.parse("2019-10-11"))
                .sicknessEnd(LocalDate.parse("2019-10-15"))
                .disease("grypa")
                .description("katar i kaszel")
                .build();
        MedicalHistory expectedHistory = MedicalHistory.builder()
                .sicknessStart(LocalDate.parse("2019-10-11"))
                .sicknessEnd(LocalDate.parse("2019-10-15"))
                .disease("grypa")
                .description("katar i kaszel")
                .build();

        //when
        medicalHistoryService.create(medHistoryDTO);
        //then
        Mockito.verify(medicalHistoryRepository, Mockito.times(1)).save(expectedHistory);

    }

}

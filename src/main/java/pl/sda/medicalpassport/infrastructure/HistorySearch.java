package pl.sda.medicalpassport.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.medicalpassport.infrastructure.dto.MedicalHistoryDTO;
import pl.sda.medicalpassport.infrastructure.user.entity.LoginData;
import pl.sda.medicalpassport.infrastructure.user.entity.MedicalHistory;
import pl.sda.medicalpassport.infrastructure.user.repozitory.MedicalHistoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistorySearch {


    private final MedicalHistoryRepository medicalHistoryRepository;
    private final HistoryFinder historyFinder;

    public List<MedicalHistoryDTO> getMedicalHistoryDTO(){
        LoginData loginData = historyFinder.getLoginData();
        List<MedicalHistory> allMedicalHistory = medicalHistoryRepository.findByLoginData(loginData);

        return allMedicalHistory.stream().map(MedicalHistory::toDTO).collect(Collectors.toList());
    }

}

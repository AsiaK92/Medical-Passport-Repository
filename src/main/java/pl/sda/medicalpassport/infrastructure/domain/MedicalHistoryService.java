package pl.sda.medicalpassport.infrastructure.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.medicalpassport.infrastructure.dto.MedicalHistoryDTO;
import pl.sda.medicalpassport.infrastructure.user.entity.MedicalHistory;
import pl.sda.medicalpassport.infrastructure.user.repozitory.MedicalHistoryRepository;
import pl.sda.medicalpassport.infrastructure.HistoryFinder;

@Service
@RequiredArgsConstructor

public class MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final HistoryFinder historyFinder;

    public void create(MedicalHistoryDTO dto) {
        MedicalHistory medicalHistory = MedicalHistory.builder()
                .id(dto.getId())
                .sicknessStart(dto.getSicknessStart())
                .sicknessEnd(dto.getSicknessEnd())
                .disease(dto.getDisease())
                .description(dto.getDescription())
                .loginData(historyFinder.getLoginData())
                .build();
        medicalHistoryRepository.save(medicalHistory);
    }

    public void delete(Long historyId) {
        medicalHistoryRepository.deleteById(historyId);
    }
}


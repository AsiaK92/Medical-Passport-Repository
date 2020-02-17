package pl.sda.medicalpassport.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.medicalpassport.infrastructure.dto.MedicalHistoryDTO;
import pl.sda.medicalpassport.infrastructure.user.entity.LoginData;
import pl.sda.medicalpassport.infrastructure.user.entity.MedicalHistory;
import pl.sda.medicalpassport.infrastructure.user.repozitory.LoginDataRepository;
import pl.sda.medicalpassport.infrastructure.user.repozitory.MedicalHistoryRepository;
import pl.sda.medicalpassport.utilities.UserUtilities;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryFinder {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final LoginDataRepository loginDataRepository ;
    public MedicalHistoryDTO findById(Long id) {
        return medicalHistoryRepository
                .findById(id)
                .map(MedicalHistory::toDTO)
                .orElseThrow(() -> new IllegalStateException("Nie wystąpiła taka choroba"));
    }


    public Set<MedicalHistoryDTO> findByLoggedUser(){

        LoginData loginData = getLoginData();

        return medicalHistoryRepository.findByLoginData(loginData)
                .stream()
                .map(MedicalHistory::toDTO)
                .collect(Collectors.toSet());
    }

    public LoginData getLoginData() {
        String login = UserUtilities.getLoggedUser();
        return loginDataRepository.findLoginDataByLogin(login);
    }
}

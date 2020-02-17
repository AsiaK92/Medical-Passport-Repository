package pl.sda.medicalpassport.infrastructure.user.repozitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.medicalpassport.infrastructure.user.entity.LoginData;
import pl.sda.medicalpassport.infrastructure.user.entity.MedicalHistory;

import java.util.List;


@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {


    public List<MedicalHistory> findByLoginData(LoginData loginData);
}

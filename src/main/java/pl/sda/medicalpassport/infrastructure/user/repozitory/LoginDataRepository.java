package pl.sda.medicalpassport.infrastructure.user.repozitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.medicalpassport.infrastructure.user.entity.LoginData;

@Repository
public interface LoginDataRepository extends JpaRepository<LoginData, Long> {

    LoginData findLoginDataByLogin(String login);

}

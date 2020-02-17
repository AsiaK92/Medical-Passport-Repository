package pl.sda.medicalpassport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySource(value = {"application.properties", "application-ext.properties"}, ignoreResourceNotFound = true)
public class MedicalPassportApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalPassportApplication.class, args);
    }

}

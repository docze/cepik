package com.mwsi.cepik.configuration;

import com.mwsi.cepik.cek.model.Address;
import com.mwsi.cepik.cek.model.Authorisation;
import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.model.DrivingLicence;
import com.mwsi.cepik.cek.repository.AuthorisationRepository;
import com.mwsi.cepik.cek.repository.DriverRepository;
import com.mwsi.cepik.cek.repository.DrivingLicenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@AllArgsConstructor
public class InitCEKDatabase {

    private final DriverRepository driverRepository;
    private final DrivingLicenceRepository drivingLicenceRepository;
    private final AuthorisationRepository authorisationRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void initDb() {

        //drivers
        Driver driver1 = new Driver(
                new Address("Warszawa", "01-222", "Marszałkowska", "33a", "22"),
                "12019922123",
                "Jan",
                "Kowalski",
                Date.valueOf(LocalDate.of(2020, 3, 12))
        );
        driverRepository.save(driver1);

        Authorisation authorisation = new Authorisation(
                Authorisation.Category.A,
                Date.valueOf(LocalDate.of(2012, 10, 5)),
                Date.valueOf(LocalDate.of(2027, 4, 10)),
                driver1);

        authorisationRepository.save(authorisation);

        DrivingLicence drivingLicence = new DrivingLicence(
                Date.valueOf(LocalDate.of(2012, 10, 5)),
                Date.valueOf(LocalDate.of(2027, 4, 10)),
                "AAABB-3",
                driver1);

        drivingLicenceRepository.save(drivingLicence);

    }
}

package com.mwsi.cepik.configuration;

import com.mwsi.cepik.cek.model.Address;
import com.mwsi.cepik.cek.model.Authorisation;
import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.model.DrivingLicence;
import com.mwsi.cepik.cek.service.AuthorisationService;
import com.mwsi.cepik.cek.service.DriverService;
import com.mwsi.cepik.cek.service.DrivingLicenceService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@AllArgsConstructor
public class InitCEKDatabase {

    private final DriverService driverService;
    private final DrivingLicenceService drivingLicenceService;
    private final AuthorisationService authorisationService;

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
        driverService.add(driver1);

        Authorisation authorisation = new Authorisation(
                Authorisation.Category.A,
                Date.valueOf(LocalDate.of(2012, 10, 5)),
                Date.valueOf(LocalDate.of(2027, 4, 10)),
                driver1);

        authorisationService.add(authorisation);

        DrivingLicence drivingLicence = new DrivingLicence(
                Date.valueOf(LocalDate.of(2012, 10, 5)),
                Date.valueOf(LocalDate.of(2027, 4, 10)),
                "AAABB-3",
                driver1);

        drivingLicenceService.add(drivingLicence);

    }
}

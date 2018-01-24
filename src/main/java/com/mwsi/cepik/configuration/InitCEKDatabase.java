package com.mwsi.cepik.configuration;

import com.mwsi.cepik.cek.model.*;
import com.mwsi.cepik.cek.repository.AuthorisationRepository;
import com.mwsi.cepik.cek.repository.DriverRepository;
import com.mwsi.cepik.cek.repository.DrivingLicenceRepository;
import com.mwsi.cepik.cek.repository.PenaltyPointsRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class InitCEKDatabase {

    private final DriverRepository driverRepository;
    private final DrivingLicenceRepository drivingLicenceRepository;
    private final AuthorisationRepository authorisationRepository;
    private final PenaltyPointsRepository penaltyPointsRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void initDb() {

        //drivers
        List<Driver> driverList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            driverList.add(new Driver(
                    new Address("Warszawa", "01-222", "Marszałkowska", "33a", "22"),
                    "950113" + (int) (10000 + (Math.random() * 89999)), "Jan", "Kowalski", Date.valueOf(LocalDate.of(2010 + i % 20, (i % 12) + 1, (i % 27) + 1))));
        }

        driverRepository.save(driverList);

        //authorisations
        List<Authorisation> authorisationList = new ArrayList<>();
        for (int i = 0; i < 70; i++) {
            authorisationList.add(new Authorisation(
                    Authorisation.Category.A,
                    Date.valueOf(LocalDate.of(2012 - (i % 12), (i % 7) + 1, (i % 24) + 1)),
                    Date.valueOf(LocalDate.of(2027, (i % 9) + 1, (i % 20) + 1)),
                    driverList.get((int) (0 + (Math.random() * 49)))));
        }

        authorisationRepository.save(authorisationList);

        //driving licences
        List<DrivingLicence> drivingLicenceList = new ArrayList<>();
        for (int i = 0; i < 70; i++) {
            drivingLicenceList.add(new DrivingLicence(
                    Date.valueOf(LocalDate.of(2012 - (i % 6), (i % 12) + 1, (i % 26) + 1)),
                    Date.valueOf(LocalDate.of(2027 + i % 3, (i % 5) + 1, (i % 10) + 1)),
                    "AAABB-3",
                    driverList.get((int) (0 + (Math.random() * 49)))));
        }

        drivingLicenceRepository.save(drivingLicenceList);

        //penalty points
        List<PenaltyPoints> penaltyPointsList = new ArrayList<>();
        for (int i = 0; i < 70; i++) {
            penaltyPointsList.add(new PenaltyPoints(
                    (i % 24) + 1,
                    Date.valueOf(LocalDate.of(2017 - (i % 6), (i % 12) + 1, (i % 26) + 1)),
                    driverList.get((int) (0 + (Math.random() * 49)))));
        }

        penaltyPointsRepository.save(penaltyPointsList);
    }
}

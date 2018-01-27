package com.mwsi.cepik.configuration;

import com.google.common.collect.Sets;
import com.mwsi.cepik.cek.model.Address;
import com.mwsi.cepik.cep.model.*;
import com.mwsi.cepik.cep.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class InitCEPDatabase {

    private final CarBrandRepository carBrandRepository;
    private final CarModelRepository carModelRepository;
    private final CarOwnerRepository carOwnerRepository;
    private final OCInsuranceRepository ocInsuranceRepository;
    private final RegistrationDocumentRepository registrationDocumentRepository;
    private final RegistrationNumberRepository registrationNumberRepository;
    private final VehicleRepository vehicleRepository;

    @EventListener(ContextRefreshedEvent.class)

    public void initDb() {

        // brands
        List<CarBrand> carBrandList = new ArrayList<>();
        carBrandList.add(new CarBrand("Audi"));
        carBrandList.add(new CarBrand("Opel"));
        carBrandList.add(new CarBrand("Honda"));
        carBrandList.add(new CarBrand("Toyota"));
        carBrandRepository.save(carBrandList);

        // models
        List<CarModel> carModelList = new ArrayList<>();
        carModelList.add(new CarModel(carBrandList.get(0), "A5"));
        carModelList.add(new CarModel(carBrandList.get(0), "A4"));
        carModelList.add(new CarModel(carBrandList.get(1), "Astra"));
        carModelList.add(new CarModel(carBrandList.get(1), "Vectra"));
        carModelList.add(new CarModel(carBrandList.get(2), "Civic"));
        carModelList.add(new CarModel(carBrandList.get(2), "Accord"));
        carModelList.add(new CarModel(carBrandList.get(3), "Yaris"));
        carModelList.add(new CarModel(carBrandList.get(3), "Corolla"));
        carModelRepository.save(carModelList);

        // vehicles
        List<Vehicle> vehicleList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Vehicle vehicle = new Vehicle();
            vehicle.setModel(carModelList.get(i % carModelList.size()));
            vehicle.setProductionYear("200" + i % 10);
            vehicle.setVin("763894827384" + (int) (10000 + (Math.random() * 89999)));
            vehicle.setEngineNumber("83278937" + (int) (10000 + (Math.random() * 89999)));
            vehicle.setEnginePower(100 + i % 41);
            vehicle.setEngineCapacity(BigDecimal.valueOf(1.0 + i % 2.2).setScale(1, RoundingMode.HALF_UP).doubleValue());
            vehicle.setNumberOfSeats(5);
            vehicle.setFirstRegistrationDate(Date.valueOf(LocalDate.of(2014 - (i % 12), (i % 7) + 1, (i % 24) + 1)));
            vehicle.setCurbWeight(1200 + i * 12);
            vehicle.setPermissibleLadenMass(1600 + i * 19);
            vehicle.setNumberOfAxies(2);
            vehicle.setPrivileged(i % 15 == 0);
            vehicle.setServicingDate(Date.valueOf(LocalDate.of(2017 - (i % 12), (i % 7) + 1, (i % 24) + 1)));
            vehicleList.add(vehicle);
        }

        vehicleRepository.save(vehicleList);

        // registration documents
        List<RegistrationDocument> registrationDocumentList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            RegistrationDocument registrationDocument = new RegistrationDocument();
            registrationDocument.setSequence("263728283736" + (int) (10000 + (Math.random() * 89999)));
            registrationDocument.setTo(Date.valueOf(LocalDate.of(2017 - (i % 12), (i % 9) + 1, (i % 16) + 1)));
            registrationDocument.setVehicle(vehicleList.get(i));
            registrationDocumentList.add(registrationDocument);
        }
        registrationDocumentRepository.save(registrationDocumentList);

        // car owners
        List<CarOwner> carOwnerList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            CarOwner carOwner = new CarOwner();
            carOwner.setFirstName("Jan");
            carOwner.setLastName("Kowalski");
            carOwner.setAddress(new Address("Warszawa", "01-222", "Marszałkowska", "33a", "22"));
            carOwner.setInstitution("Urzad m.st. Warszawy");
            carOwner.setPesel("950113" + (int) (10000 + (Math.random() * 89999)));
            carOwner.setRegistrationDocumentSet(Sets.newHashSet(registrationDocumentList.get(i%40)));
            carOwnerList.add(carOwner);
        }
        carOwnerRepository.save(carOwnerList);

        // OC
        List<OCInsurance> ocInsuranceList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            OCInsurance ocInsurance = new OCInsurance();
            LocalDate start = LocalDate.of(2017 - (i % 12), (i % 7) + 1, (i % 24) + 1);
            LocalDate end = start.plusYears(1);
            ocInsurance.setFrom(Date.valueOf(start));
            ocInsurance.setTo(Date.valueOf(end));
            ocInsurance.setPolicyNumberWithPIN("JHJS434/" + (int) (10000 + (Math.random() * 89999)));
            ocInsurance.setCarOwner(carOwnerList.get(i));
            ocInsurance.setVehicle(vehicleList.get(i));
            ocInsuranceList.add(ocInsurance);
        }
        ocInsuranceRepository.save(ocInsuranceList);

        // registration numbers
        List<RegistrationNumber> registrationNumberList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            RegistrationNumber registrationNumber = new RegistrationNumber();
            registrationNumber.setActual(i % 8 < 7);
            registrationNumber.setRegistrationNumber("22" + (int) (10000 + (Math.random() * 89999)));
            registrationNumber.setVehicle(vehicleList.get(i));
            registrationNumberList.add(registrationNumber);
        }
        registrationNumberRepository.save(registrationNumberList);

    }
}

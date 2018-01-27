package com.mwsi.cepik.cep.service;

import com.mwsi.cepik.cep.model.CarModel;
import com.mwsi.cepik.cep.model.Vehicle;
import com.mwsi.cepik.cep.model.form.VehicleForm;
import com.mwsi.cepik.cep.repository.VehicleRepository;
import com.mwsi.cepik.exception.cep.DuplicatedVehicleException;
import com.mwsi.cepik.exception.cep.VehicleNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CarModelService carModelService;

    @Transactional
    public Vehicle add(VehicleForm vehicleForm) {
        if (isDuplicated(vehicleForm)) {
            throw new DuplicatedVehicleException(vehicleForm.getVin(), vehicleForm.getEngineNumber());
        }
        CarModel carModel = carModelService.findById(vehicleForm.getCarModelId());
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(carModel);
        vehicle.setProductionYear(vehicleForm.getProductionYear());
        vehicle.setVin(vehicleForm.getVin());
        vehicle.setEngineNumber(vehicleForm.getEngineNumber());
        vehicle.setEnginePower(vehicleForm.getEnginePower());
        vehicle.setEngineCapacity(vehicleForm.getEngineCapacity());
        vehicle.setNumberOfSeats(vehicleForm.getNumberOfSeats());
        vehicle.setFirstRegistrationDate(vehicleForm.getFirstRegistrationDate());
        vehicle.setCurbWeight(vehicleForm.getCurbWeight());
        vehicle.setPermissibleLadenMass(vehicleForm.getPermissibleLadenMass());
        vehicle.setNumberOfAxies(vehicleForm.getNumberOfAxies());
        vehicle.setPrivileged(vehicleForm.isPrivileged());
        vehicle.setServicingDate(vehicleForm.getServicingDate());
        return vehicleRepository.save(vehicle);
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        vehicleRepository.delete(id);
    }

    @Transactional
    public Vehicle update(VehicleForm vehicleForm, Long id) {
        CarModel carModel = carModelService.findById(vehicleForm.getCarModelId());
        Vehicle dbVehicle = findById(id);
        dbVehicle.setModel(carModel);
        dbVehicle.setProductionYear(vehicleForm.getProductionYear());
        dbVehicle.setVin(vehicleForm.getVin());
        dbVehicle.setEngineNumber(vehicleForm.getEngineNumber());
        dbVehicle.setEnginePower(vehicleForm.getEnginePower());
        dbVehicle.setEngineCapacity(vehicleForm.getEngineCapacity());
        dbVehicle.setNumberOfSeats(vehicleForm.getNumberOfSeats());
        dbVehicle.setFirstRegistrationDate(vehicleForm.getFirstRegistrationDate());
        dbVehicle.setCurbWeight(vehicleForm.getCurbWeight());
        dbVehicle.setPermissibleLadenMass(vehicleForm.getPermissibleLadenMass());
        dbVehicle.setNumberOfAxies(vehicleForm.getNumberOfAxies());
        dbVehicle.setPrivileged(vehicleForm.isPrivileged());
        dbVehicle.setServicingDate(vehicleForm.getServicingDate());
        return vehicleRepository.save(dbVehicle);
    }

    private boolean isDuplicated(VehicleForm vehicleForm) {
        int count = vehicleRepository.countByVinOrEngineNumber(vehicleForm.getVin(), vehicleForm.getEngineNumber());
        return count != 0;
    }
}

package com.enzo.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getSoftwareEngineers(){

        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {

        softwareEngineerRepository.save(softwareEngineer);

    }
    public SoftwareEngineer getSoftwareEngineersByID(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public void deleteSoftwareEngineer(Integer id) {
        if (!softwareEngineerRepository.existsById(id)) {
            throw new IllegalStateException(id + " not found");
        }
        softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineer updateSoftwareEngineer(Integer id, SoftwareEngineer updatedEngineer){
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not FOund"));
        engineer.setName(updatedEngineer.getName());
        engineer.setTechStack(updatedEngineer.getTechStack());

        return softwareEngineerRepository.save(engineer);
    }


}

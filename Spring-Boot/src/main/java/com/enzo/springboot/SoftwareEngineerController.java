package com.enzo.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getAllEngineers(){
        return softwareEngineerService.getSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineersByID(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineersByID(id);
    }


    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer){

        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

}

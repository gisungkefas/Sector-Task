package com.kefas.TaskBackend.controller;

import com.kefas.TaskBackend.dto.DataDto;
import com.kefas.TaskBackend.entity.Sectors;
import com.kefas.TaskBackend.repository.SectorsRepository;
import com.kefas.TaskBackend.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private SectorsRepository sectorsRepository;

    @GetMapping("/api/v1/sectors")
    public List<Sectors> getSectors() {
        return sectorsRepository.findAll();
    }

    @PostMapping("/api/v1/saveData")
    public void saveData(@RequestBody @Valid DataDto data) {
        dataService.saveData(data);
    }
}

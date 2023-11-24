//package com.kefas.TaskBackend.controller;
//
//import com.kefas.TaskBackend.service.SectorsService;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:5173")
//public class SectorsController {
//
//    private final SectorsService sectorsService;
//
//    @Autowired
//    public SectorsController(SectorsService sectorsService) {
//        this.sectorsService = sectorsService;
//    }
//
//    @Transactional
//    @GetMapping("/api/v1/sectors")
//    public ResponseEntity<String> initializeSectors() {
//        try {
//            sectorsService.mapNamesToSectors();
//            sectorsService.prePersistSectors();
//            return new ResponseEntity<>("Sectors initialized and persisted successfully!", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to initialize sectors: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//}

package com.kefas.TaskBackend.service;

import com.kefas.TaskBackend.entity.Sectors;
import com.kefas.TaskBackend.repository.SectorsRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SectorsService {

    private final SectorsRepository sectorsRepository;

    private static final Logger logger = LoggerFactory.getLogger(SectorsService.class);

    private final Map<String, List<String>> subOptions = new HashMap<>();
    private final Map<String, Sectors> sectorMap = new HashMap<>();

    @Autowired
    public SectorsService(SectorsRepository sectorsRepository) {
        this.sectorsRepository = sectorsRepository;
        initializeSubOptions();
    }

    private void initializeSubOptions() {
        subOptions.put("Manufacturing", Arrays.asList("Construction materials", "Electronics and Optics", "Food and Beverage"));
        subOptions.put("Food and Beverage", Arrays.asList("Bakery & confectionery products", "Beverages", "Fish & fish products", "Meat & meat products", "Milk & dairy products", "Other", "Sweets & snack food"));
        subOptions.put("Furniture", Arrays.asList("Bathroom/sauna", "Bedroom", "Children room", "Kitchen", "Living room", "Office", "Other (Furniture)", "Outdoor", "Project furniture"));
        subOptions.put("Machinery", Arrays.asList("Machinery components", "Machinery equipment/tools", "Manufacture of machinery", "Maritime", "Metal structures", "Other", "Repair and maintenance service"));
        subOptions.put("Maritime", Arrays.asList("Aluminium and steel workboats", "Boat/Yacht building", "Ship repair and conversion"));
        subOptions.put("Metalworking", Arrays.asList("Construction of metal structures", "Houses and buildings", "Metal products", "Metal works"));
        subOptions.put("Metal works", Arrays.asList("CNC-machining", "Forgings, Fasteners", "Gas, Plasma, Laser cutting", "MIG, TIG, Aluminum welding"));
        subOptions.put("Plastic and Rubber", Arrays.asList("Packaging", "Plastic goods", "Plastic processing technology", "Plastic Profile"));
        subOptions.put("Plastic processing technology", Arrays.asList("Blowing", "Moulding", "Plastics welding and processing"));
        subOptions.put("Printing", Arrays.asList("Advertising", "Book/Periodicals printing", "Labelling and packaging printing"));
        subOptions.put("Textile and Clothing", Arrays.asList("Clothing", "Textile"));
        subOptions.put("Wood", Arrays.asList("Other (Wood)", "Wooden building materials", "Wooden houses"));
        subOptions.put("Other", Arrays.asList("Creative industries", "Energy technology", "Environment"));
        subOptions.put("Service", Arrays.asList("Business services", "Engineering", "Information Technology and Telecommunications", "Tourism", "Translation services", "Transport and Logistics"));
        subOptions.put("Information Technology and Telecommunications", Arrays.asList("Data processing, Web portals, E-marketing", "Programming, Consultancy", "Software, Hardware", "Telecommunications"));
        subOptions.put("Transportation and Logistics", Arrays.asList("Air", "Road", "Water"));
    }

    public void mapNamesToSectors() {
        synchronized (sectorMap) {
            for (Map.Entry<String, List<String>> sectors : subOptions.entrySet()) {
                for (String sector : sectors.getValue()) {
                    Sectors s = new Sectors();
                    s.setName(sector);
                    s.setParent(sectors.getKey());
                    sectorMap.put(s.getName(), s);
                }

                if (!sectorMap.containsKey(sectors.getKey())) {
                    Sectors s = new Sectors();
                    s.setName(sectors.getKey());
                    sectorMap.put(s.getName(), s);
                }
            }
        }
    }

    public void prePersistSectors() {
        for (Map.Entry<String, Sectors> sectors : sectorMap.entrySet()) {
            try {
                sectorsRepository.save(sectors.getValue());
                logger.info("Saved sector: {}", sectors.getValue());
            } catch (Exception e) {
                logger.error("Error saving sector: {}", sectors.getValue(), e);
            }
        }
    }

}

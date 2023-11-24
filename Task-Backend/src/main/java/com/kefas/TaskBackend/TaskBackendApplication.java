package com.kefas.TaskBackend;

import com.kefas.TaskBackend.service.SectorsService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskBackendApplication implements ApplicationRunner {

	private final SectorsService sectorsService;

	public TaskBackendApplication(SectorsService sectorsService) {
		this.sectorsService = sectorsService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskBackendApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args){
		sectorsService.mapNamesToSectors();
		sectorsService.prePersistSectors();
	}

}

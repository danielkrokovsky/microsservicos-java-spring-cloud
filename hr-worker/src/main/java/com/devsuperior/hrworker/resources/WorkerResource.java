package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	@Autowired
	private Environment env;
	
	@Value("${test.config}")
	private String config;
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
		
		
		logger.info("PORT = " +env.getProperty("local.server.port"));
		
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
	@GetMapping(value = "/configs")
	public void configs() {
		
		logger.info("CONFIG = " +config);
	}

}

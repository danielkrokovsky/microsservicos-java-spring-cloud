package com.devsuperior.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.payroll.entities.Payment;
import com.devsuperior.payroll.entities.Worker;
import com.devsuperior.payroll.feignclients.WorkerFeignClients;

@Service
public class PaymentService {
	
	/*
	@Value("${hr-worker.host}")
	private String host;
	
	@Autowired
	private RestTemplate restTemplate;
	*/
	
	@Autowired
	private WorkerFeignClients workerFeignClients;

	public Payment getPayment(long workerId, int days) {
		/*
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		Worker worker = restTemplate.getForObject(host+"/workers/{id}", Worker.class, uriVariables);
		*/
		
		Worker worker = workerFeignClients.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}

package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.service.ProductService;
//import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Product;

@SpringBootApplication
public class JooqdemoApplication {


	public static void main(String[] args)throws Exception {
		SpringApplication.run(JooqdemoApplication.class, args);
	//	runBenchmark();

	}
	private static void runBenchmark()throws Exception {
		org.openjdk.jmh.Main.main(new String[]{
				"-f", "1",
				"-wi", "5",
				"-i", "5",
				"-t", "1",
				"-bm", "Throughput"
		});
	}


}

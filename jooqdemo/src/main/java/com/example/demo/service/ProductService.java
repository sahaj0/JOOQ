package com.example.demo.service;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Product;

@Service
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
//@Warmup(iterations = 5)
//@Measurement(iterations = 5)
public class ProductService {

	@Autowired
	private DSLContext dslContext;

	public void insertProduct(Product product) {
		long startTime=System.currentTimeMillis();
		dslContext.insertInto(Tables.PRODUCT,Tables.PRODUCT.PRODUCT_ID,Tables.PRODUCT.PRODUCT_NAME,Tables.PRODUCT.PRODUCT_PRICE)
		.values(product.getProductId(),product.getProductName(),product.getProductPrice())
		.execute();
		long endTime=System.currentTimeMillis();
		long executionTime=endTime-startTime;
		System.out.println("-----"+executionTime+"-----");
	}


	public List<Product> getProducts(){
		long startTime=System.currentTimeMillis();
		List<Product>p=dslContext.selectFrom(Tables.PRODUCT)
				.fetchInto(Product.class);
		long endTime=System.currentTimeMillis();
		long executionTime=endTime-startTime;
		System.out.println(p+"-----"+executionTime+"-----");


		return dslContext.selectFrom(Tables.PRODUCT)
				.fetchInto(Product.class);
	}
//	@Benchmark
//	public void measureProducts(Blackhole blackhole){
//		List<Product>p=dslContext.selectFrom(Tables.PRODUCT)
//				.fetchInto(Product.class);
//		blackhole.consume(p);
//
//	}


	public void deleteById(Long productId){
		long startTime=System.currentTimeMillis();
		dslContext.deleteFrom(Tables.PRODUCT).where(Tables.PRODUCT.PRODUCT_ID.eq(Math.toIntExact(productId)))
				.execute();
		long endTime=System.currentTimeMillis();
		long executionTime=endTime-startTime;
		System.out.println("-----"+executionTime+"-----");
	}

	public void updateProducts(Long productID,String productName, Double productPrice){
		long startTime=System.currentTimeMillis();
		dslContext.update(Tables.PRODUCT).set(Tables.PRODUCT.PRODUCT_NAME,productName)
				.set(Tables.PRODUCT.PRODUCT_PRICE,productPrice).where(Tables.PRODUCT.PRODUCT_ID.eq(Math.toIntExact(productID)))
				.execute();
		long endTime=System.currentTimeMillis();
		long executionTime=endTime-startTime;
		System.out.println("-----"+executionTime+"-----");
	}

}

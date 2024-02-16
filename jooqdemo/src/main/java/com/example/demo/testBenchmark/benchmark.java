//package com.example.demo.testBenchmark;
//
//import com.example.demo.controller.ProductController;
//import com.example.demo.service.ProductService;
////import java.util.concurrent.TimeUnit;
//import com.tej.JooQDemo.jooq.sample.model.Tables;
//import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Product;
//import org.jooq.DSLContext;
//import org.jooq.impl.DSL;
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//
//
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
//
//public class benchmark {
//    private  static  final  String JDBC_URL="jdbc:mysql://localhost:3306/productdb";
//    private  static  final  String USER="root";
//    private  static  final  String PASSWORD="root";
//
//    private DSLContext dslContext;
//
//    @Autowired
//    ProductService productService;
//
//    @Setup
//    public  void  setup()throws SQLException{
//        Connection connection= DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
//        dslContext= DSL.using(connection);
//    }
//
//    @TearDown
//    public  void  tearDown(){
//        if(dslContext!=null){
//            return ;
//        }
//    }
//
//    @Benchmark
//    public void measureProducts(Blackhole blackhole){
//        int result=dslContext.selectCount().from(Tables.PRODUCT).fetchOneInto(int.class);
//        blackhole.consume(result);
//    }
//
//    @Benchmark
//    public void update(){
//        productService.updateProducts(1l,"sample",23.0);
//    }
//
//    @Benchmark
//    public void delete(){
//        productService.deleteById(1l);
//    }
//
//
//
////    @Benchmark
////    public void addProduct(){
////      // productService.insertProduct(1,"sample",50.0);
////    }
//
////    @Benchmark
////    public void getProduct(){
////        productService.getProducts();
////    }
//
//}

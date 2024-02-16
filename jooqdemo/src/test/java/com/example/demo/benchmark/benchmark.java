//package com.example.demo.benchmark;
//
//
//import com.tej.JooQDemo.jooq.sample.model.Tables;
//import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Product;
//import org.jooq.DSLContext;
//import org.junit.runner.RunWith;
//import org.openjdk.jmh.annotations.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
//@RunWith(SpringRunner.class)
//public class benchmark extends AbstractBenchmark{
//
//    /**
//     * The most important thing is to get Spring (autowired) components into the executing
//     * benchmark instance. To accomplish this you can do the following
//     *
//     *  * set `forks` to 0 for the JMH runner to run the benchmarks within the same VM
//     *  * store all @Autowired dependencies into static fields of the surrounding class
//     *
//     */
//    private static DSLContext dsl;
//
//    /**
//     * We use setter autowiring to make Spring save an instance of `DSLContext` into a
//     * static field accessible be the benchmarks spawned through the JMH runner.
//     *
//     * @param dslContext
//     */
//    @Autowired
//    void setDslContext(DSLContext dslContext) {
//        benchmark.dsl = dslContext;
//    }
//
//    // this variable is set during the benchmarks setup and is accessible by the benchmark method
//    Record someRecord;
//
//    /*
//     * There is no @Test annotated method within here, because the AbstractBenchmark
//     * defines one, which spawns the JMH runner. This class only contains JMH/Benchmark
//     * related code.
//     */
//
//    @Setup(Level.Trial)
//    public void setupBenchmark() {
//        // Seed the database with some (1000) random records
//        new RecordsSeeder(dsl, 1000).seedRecords();
//        // fetch one of these for the upcoming benchmarks to query for certain fields
//        someRecord = dsl.selectFrom(RecordTable.RECORD_TABLE).fetchAny();
//        // disable jooqs execution logging or it will spam STDOUT *AND* slow down the whole benchmark
//        dsl.configuration().settings().setExecuteLogging(false);
//    }
//
//    @Benchmark
//    public void someBenchmarkMethod() {
//        // query the database
////        dsl.selectFrom(Tables.PRODUCT)
////                .fetchInto(Product.class);
//        dsl.selectFrom(RecordTable.RECORD_TABLE).where(RecordTable.RECORD_TABLE.SOME_ID.eq(someRecord.getSomeId())).fetch();
//    }
//
//}

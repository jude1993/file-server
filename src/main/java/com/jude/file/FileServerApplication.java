package com.jude.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jude
 */
@SpringBootApplication
@MapperScan("com.jude.file.mapper")
public class FileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileServerApplication.class, args);
    }

    /*@Bean("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.ro-datasource")
    DataSource slaveDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    DataSource primaryDataSource(
            @Autowired @Qualifier("masterDataSource") DataSource masterDataSource,
            @Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        Map<Object, Object> map = new HashMap<>();
        map.put("masterDataSource", masterDataSource);
        map.put("slaveDataSource", slaveDataSource);
        RoutingDataSource routing = new RoutingDataSource();
        routing.setTargetDataSources(map);
        routing.setDefaultTargetDataSource(masterDataSource);
        return routing;
    }*/

}

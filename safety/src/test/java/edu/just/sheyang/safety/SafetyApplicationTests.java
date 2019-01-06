package edu.just.sheyang.safety;

import edu.just.sheyang.safety.dao.*;
import edu.just.sheyang.safety.model.Patrol_record;
import edu.just.sheyang.safety.model.Riskpoints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SafetyApplicationTests {
    @Autowired
    IndustryMapper industryMapper;
    @Autowired
    RiskpointsMapper riskpointsMapper;
    @Autowired
    FactoryMapper factoryMapper;
    @Autowired
    Patrol_recordMapper patrol_recordMapper;
    @Autowired
    RisksMapper risksMapper;


    @Test
    public void contextLoads() {
        List<Patrol_record> patrol_records=patrol_recordMapper.getriskfactory("电力设备");
        String date=patrol_records.get(0).getTime();
        System.out.println(date);
    }

}

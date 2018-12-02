package edu.just.sheyang.safety;

import edu.just.sheyang.safety.dao.FactoryMapper;
import edu.just.sheyang.safety.dao.IndustryMapper;
import edu.just.sheyang.safety.dao.RiskpointsMapper;
import edu.just.sheyang.safety.model.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void contextLoads() {
        riskpointsMapper.delete_data("射阳港龙凤烟花爆竹门市","2018-11-26 00:00:00");
    }

}

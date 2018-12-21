package edu.just.sheyang.safety;

import edu.just.sheyang.safety.dao.FactoryMapper;
import edu.just.sheyang.safety.dao.IndustryMapper;
import edu.just.sheyang.safety.dao.RiskpointsMapper;
import edu.just.sheyang.safety.model.Riskpoints;
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
        List<Riskpoints> riskpoints=riskpointsMapper.select(new Riskpoints("碧蓝宾馆",null,null,"2018-11-02"+" 00:00:00","21"));
        System.out.println(riskpoints);
    }

}

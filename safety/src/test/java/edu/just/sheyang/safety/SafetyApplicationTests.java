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
        List<Factory>factories =factoryMapper.selectAll();
        System.out.println(factories.toString());
        String risk_display="";
        for(Factory factory:factories){
            String factory_name=factory.getFactoryName();
            if(factory_name.equals("碧蓝宾馆")){
                risk_display=factory.getRiskDisplay();
            }
        }
        System.out.println(risk_display);
    }

}

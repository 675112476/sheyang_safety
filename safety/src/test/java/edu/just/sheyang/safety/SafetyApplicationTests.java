package edu.just.sheyang.safety;

import edu.just.sheyang.safety.dao.IndustryMapper;
import edu.just.sheyang.safety.dao.RiskpointsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SafetyApplicationTests {
    @Autowired
    IndustryMapper industryMapper;
    @Autowired
    RiskpointsMapper riskpointsMapper;
    @Test
    public void contextLoads() {
        String flag="不可控";
        List<String> result=riskpointsMapper.isControl("碧蓝宾馆","2018-11-20");
        System.out.println(result.toString());
        if(result.toString().equals("[]")){
            flag="可控";
        }
        System.out.println(flag);
    }

}

package edu.just.sheyang.safety;

import edu.just.sheyang.safety.dao.IndustryMapper;
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

    @Test
    public void contextLoads() {
        List ids=new ArrayList();
        ids.add("4028e4f2661439a701661439a7a20000");
        ids.add("4028e4f2661439a701661534f2a10024");
        List<String> result=industryMapper.getIndustry(ids);
        System.out.println(result.toString());
    }

}

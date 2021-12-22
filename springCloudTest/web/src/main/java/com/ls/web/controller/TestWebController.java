package com.ls.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ls.web.apis.TestServicesApis;
import com.ls.server.entity.MoneyPo;
import com.ls.server.mapper.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/test")
public class TestWebController {
    @Value("${aa.bb}")
    String value;

    @Autowired
    private MoneyMapper moneyMapper;

    @Autowired
    private TestServicesApis testServicesApis;

    private Random random = new Random();

    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public String getTest(@RequestParam String name) {
        return testServicesApis.get(name);
    }

    @RequestMapping(value = "/value",method = RequestMethod.GET)
    public String value() {
        return "value:"+value;
    }

    @RequestMapping(value = "/mybatis",method = RequestMethod.GET)
    public void getMybatis() {
        MoneyPo po = new MoneyPo();
        po.setId(123);
        po.setName("mybatis plus user");
        po.setMoney((long) random.nextInt(12343));
        po.setIsDeleted(0);
        po.setCreateAt(new Timestamp(System.currentTimeMillis()));
        po.setUpdateAt(new Timestamp(System.currentTimeMillis()));

        // 添加一条数据
        moneyMapper.insert(po);

        // 查询
        List<MoneyPo> list =
                moneyMapper.selectList(new QueryWrapper<MoneyPo>().lambda().eq(MoneyPo::getName, po.getName()));
        System.out.println("after insert: " + list);

        // 修改
        po.setMoney(po.getMoney() + 300);
        moneyMapper.updateById(po);
        System.out.println("after update: " + moneyMapper.selectById(po.getId()));

        // 删除
        moneyMapper.deleteById(po.getId());

        // 查询
        Map<String, Object> queryMap = new HashMap<>(2);
        queryMap.put("name", po.getName());
        System.out.println("after delete: " + moneyMapper.selectByMap(queryMap));
        System.out.println("测试git");
    }
}

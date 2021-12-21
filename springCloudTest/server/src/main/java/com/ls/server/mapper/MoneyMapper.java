package com.ls.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ls.server.entity.MoneyPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoneyMapper extends BaseMapper<MoneyPo> {
}

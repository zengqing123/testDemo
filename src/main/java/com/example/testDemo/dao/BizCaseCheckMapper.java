package com.example.testDemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testDemo.entity.BizCaseCheck;

import java.util.List;
import java.util.Map;

public interface BizCaseCheckMapper extends BaseMapper<BizCaseCheck> {
    List<BizCaseCheck> getList(Map<String,Object> map);
    List<BizCaseCheck> selectLists();
}

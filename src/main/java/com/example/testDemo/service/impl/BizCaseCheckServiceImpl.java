package com.example.testDemo.service.impl;

import com.example.testDemo.entity.BizCaseCheck;
import com.example.testDemo.dao.BizCaseCheckMapper;
import com.example.testDemo.service.IBizCaseCheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 案件审核表 服务实现类
 * </p>
 *
 * @author luozq
 * @since 2020-07-23
 */
@Service
public class BizCaseCheckServiceImpl extends ServiceImpl<BizCaseCheckMapper, BizCaseCheck> implements IBizCaseCheckService {

    @Autowired
    private BizCaseCheckMapper mapper;

    @Override
    public List<BizCaseCheck> selectLists() {
        return mapper.selectLists();
    }
}

package com.example.testDemo.service;

import com.example.testDemo.dao.BizCaseCheckMapper;
import com.example.testDemo.entity.BizCaseCheck;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 案件审核表 服务类
 * </p>
 *
 * @author luozq
 * @since 2020-07-23
 */
public interface IBizCaseCheckService extends IService<BizCaseCheck> {
    List<BizCaseCheck> selectLists();

}

package com.example.testDemo.service;

import com.example.testDemo.entity.BizCaseCheck;

import java.util.concurrent.ExecutionException;

public interface RequsetTestService {
    BizCaseCheck getEntity(String caseId) throws ExecutionException, InterruptedException;
}

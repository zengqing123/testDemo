package com.example.testDemo.api;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.testDemo.service.ExcelInport;
import com.example.testDemo.utils.ExcelUtil;
import com.example.testDemo.utils.RRException;
import com.example.testDemo.utils.Result;

@RestController
@RequestMapping("/api/excel")
@Api("文件导入导出")
public class ExcelUtilContrller {
	@Autowired
	private ExcelInport excelInport;
	
	@PostMapping("/import")
	@ApiOperation(value = "导入",notes = "导入")
	public Result importExcel(@RequestParam("file") MultipartFile file){
		if (file.isEmpty()) {
			throw new RRException("文件不能为空");
		}
		Workbook book = ExcelUtil.readyFile(file);
		List<Sheet> shList = new ArrayList<Sheet>();
		int numberOfSheets = book.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet= book.getSheetAt(i);
			shList.add(sheet);
		}
		excelInport.inport(shList);
		return Result.ok();
	}

}

/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.service.impl<br/>
 * <b>文件名：</b>ExcelInportImpl.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月9日-下午12:00:34<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.service.impl;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import com.example.testDemo.service.ExcelInport;
import com.example.testDemo.utils.ExcelUtil;

/**
 * <b>类   名：</b>ExcelInportImpl<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月9日 下午12:00:34<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月9日 下午12:00:34<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Service
public class ExcelInportImpl implements ExcelInport {
	
	@Override
	public String inport(List<Sheet> list){
		for (Sheet sheet : list) {
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null) {
					continue;
				}
				String row1 = ExcelUtil.getCellValue(row.getCell(0)).toString().trim();
				String row2 = ExcelUtil.getCellValue(row.getCell(1)).toString().trim();
				System.out.println(row1+" "+row2);
			}
		}
		return null;
	}

}

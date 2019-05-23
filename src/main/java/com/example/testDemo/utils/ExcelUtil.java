/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.utils<br/>
 * <b>文件名：</b>ExcelUtil.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月8日-上午11:18:27<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * <b>类   名：</b>ExcelUtil<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月8日 上午11:18:27<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月8日 上午11:18:27<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class ExcelUtil {
	
	//将文件变为工作簿
	public static Workbook readyFile(MultipartFile file) {
		Workbook wb = null;
		InputStream in = null;
		if (file != null) {
			try {
				in = file.getInputStream();
				wb = new XSSFWorkbook(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return wb;
	}
	
	//读取单元格的值
	 public static String getCellValue(Cell cell) {
		 Object result = "";
		 if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				result = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				double a = cell.getNumericCellValue();
            	String valueStr = String.valueOf(a);
            	if(valueStr.contains("E")){
            		DecimalFormat df = new DecimalFormat("0");
            		if(a%100d>0.01){
            			df = new DecimalFormat("0");
            		}
            		result = df.format(cell.getNumericCellValue());
            	}else{
            		result = cell.getNumericCellValue();
            	}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				result = cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				result = cell.getCellFormula();
				break;
			case Cell.CELL_TYPE_ERROR:
				result = cell.getErrorCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				
				break;
			default:
				break;
			}
		}
		 String resultStr = result.toString();
		 if (resultStr.endsWith(".0")) {
			 return resultStr.substring(0, resultStr.length()-2);
		}
		return resultStr;
	 }
	 
	 //下载
	 //cols 列名  dataList 列值 fileName 文件名 
	 public static void exportExcelXlsx(String[] cols, List<String[]> dataList,String fileName,HttpServletResponse response,HttpServletRequest request){
			try{
				// 声明一个工作薄
				XSSFWorkbook workBook = new XSSFWorkbook();//xlsx文件
				// 生成一个表格
				XSSFSheet sheet = workBook.createSheet(fileName); 
				XSSFCell cell;
				
				
				//标题样式
				XSSFFont font1 = workBook.createFont();
				font1.setFontName("Arial");
				font1.setFontHeightInPoints((short)14);
				font1.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);//粗体显示
				XSSFCellStyle style1 = workBook.createCellStyle();
				style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				style1.setBorderRight(XSSFCellStyle.BORDER_THIN);
				style1.setBorderTop(XSSFCellStyle.BORDER_THIN);
				style1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
				style1.setFont(font1);
				
				//内容样式
				XSSFFont font2 = workBook.createFont();
				font2.setFontName("Arial");
				font1.setFontHeightInPoints((short)14);
				XSSFCellStyle style2 = workBook.createCellStyle();
				style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
				style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
				style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
				//style2.setWrapText(true);
				style2.setFont(font2);
				
				
				XSSFRow row = sheet.createRow(0); //创建行
				//row.setHeight((short)512);
				for (int i = 0; i < cols.length; i++) {
					//创建行的：列
					cell = row.createCell(i);
					cell.setCellValue(cols[i]);
					cell.setCellStyle(style1);
				}
	            for(int i=0;i<dataList.size();i++){
	            	XSSFRow row2 = sheet.createRow(i+1);
	            	//row2.setHeight((short)512);
	            	String[] thisTr = dataList.get(i);
	            	for(int j=0;j<thisTr.length;j++){
	            		cell = row2.createCell(j);
	    				cell.setCellValue(thisTr[j]);
	    				cell.setCellStyle(style2);
	            	}
	            }
	            //自动设置对应列宽
	            for (int i = 0; i < cols.length; i++) {
					sheet.autoSizeColumn((short)i); //调整对应列宽度
				}
	            
	            
	            String downFileName = new String(fileName+".xlsx");  
	            try {  
	                //若不进行编码在IE下会乱码  
	                downFileName = URLEncoder.encode(downFileName, "UTF-8");  
	            } catch (UnsupportedEncodingException e) {  
	                e.printStackTrace();  
	            }  
	            try {  
	                // 清空response  
	                response.reset();  
	                response.setContentType("application/msexcel");//设置生成的文件类型  
	                response.setCharacterEncoding("UTF-8");//设置文件头编码方式和文件名  
	                response.setHeader("Content-Disposition", "attachment; filename=" + new String(downFileName.getBytes("utf-8"), "ISO8859-1"));  
	                OutputStream os=response.getOutputStream();  
	                workBook.write(os);  
	                os.flush();  
	                os.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            } 
			}catch (Exception e) {
				e.printStackTrace();
				throw new RRException("导出Excel失败");
			}
		}
	
}

package com.example.testDemo.test.io;

import java.io.*;

/**
 * <b>类   名：</b>IOTest<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/13 9:53<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/13 9:53<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
public class IOTest {
    public void saveDataToFile(String fileName,String data){
        BufferedWriter writer = null;
        String destDirName="d:\\jsonfile\\测试.txt";
        File dir = new File(destDirName);
        FileWriter fw = null;
        PrintWriter pw = null;
//        if (dir.exists()) {
//            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
//        }
//        if (!destDirName.endsWith(File.separator)) {
//            destDirName = destDirName + File.separator;
//        }
//        //创建目录
//        if (dir.mkdirs()) {
//            System.out.println("创建目录" + destDirName + "成功！");
//        } else {
//            System.out.println("创建目录" + destDirName + "失败！");
//        }
//        File file = new File(destDirName+ fileName + ".txt");
//        System.out.println(file+"file");
//        //如果文件不存在，则新建一个
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(fileName + ".txt文件不存在");
//        }
        //写入
        try {
//            fw = new FileWriter(dir, true);
//            pw = new PrintWriter(fw);
//            pw.append(data);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir,true), "UTF-8"));
            writer.write(data+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }if (fw != null){fw.close();}
                if (pw != null) pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件写入成功！");
    }
}

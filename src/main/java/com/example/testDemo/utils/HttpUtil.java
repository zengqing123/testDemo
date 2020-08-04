package com.example.testDemo.utils;

import org.apache.commons.httpclient.util.HttpURLConnection;
import java.io.*;
import java.net.URL;

public class HttpUtil {

    /**
     * 从网络上下载文件
     *
     * @param uri
     * @return
     * @throws IOException
     */
    public static InputStream downFile(String uri) throws IOException {
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(uri);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            inputStream= conn.getInputStream();
            return inputStream;
        } catch (Exception e) {
        }finally {
            try{
                if (conn != null) {
                    conn.disconnect();
                }
            }catch (Exception e){
            }
        }
        return inputStream;
    }


    public static void saveFileByStream(InputStream stream,String path,String name,String type) throws FileNotFoundException {


        String tempAbsFile = path + "/" + name + "." + type;
        BufferedOutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(stream);
            outputStream = new BufferedOutputStream(new FileOutputStream(tempAbsFile));
            int len = inputStream.available();
            //判断长度是否大于4k
            if (len <= 4096) {
                byte[] bytes = new byte[len];
                inputStream.read(bytes);
                outputStream.write(bytes);
            } else {
                int byteCount = 0;
                //1M逐个读取
                byte[] bytes = new byte[4096];
                while ((byteCount = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, byteCount);
                }
            }

        } catch (Exception e) {
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }

                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
            }
        }
    }


}

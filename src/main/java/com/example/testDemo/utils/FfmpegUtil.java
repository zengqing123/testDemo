package com.example.testDemo.utils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FfmpegUtil {
    /**
     * 将视频转换为ts流
     *
     * @param ffmpegPath ffmpegPath bin路径
     * @param url        源文件路径
     * @param outputPath 输出文件路径
     * @return
     */
    public static Boolean ffmpeg(String ffmpegPath, String url, String outputPath) throws Exception {
        List<String> command = getFfmpegCommand(ffmpegPath, url, outputPath);
        if (null != command && command.size() > 0) {
            return process(command);
        }
        return false;
    }

    /**
     * @param command
     * @throws Exception
     */
    private static boolean process(List<String> command) {
        try {
            if (null == command || command.size() == 0) {
                return false;
            }
            Process videoProcess = new ProcessBuilder(command).redirectErrorStream(true).start();
            new PrintStream(videoProcess.getErrorStream()).start();
            new PrintStream(videoProcess.getInputStream()).start();
            int exitcode = videoProcess.waitFor();
            if (exitcode == 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据文件类型设置ffmpeg命令
     *
     * @param url
     * @param outputPath
     * @return
     */
    private static List<String> getFfmpegCommand(String ffmpegPath, String url, String outputPath) {
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath + File.separator + "ffmpeg");
        command.add("-i");
        command.add(url);
        command.add("-vcodec");
        command.add("copy");
        command.add("-acodec");
        command.add("copy");
        command.add("-absf");
        command.add("aac_adtstoasc");
        command.add(outputPath);
        return command;
    }
}

class PrintStream extends Thread {
    InputStream __is = null;

    public PrintStream(InputStream is) {
        __is = is;
    }

    public void run() {
        try {
            while (this != null) {
                int _ch = __is.read();
                if (_ch == -1) {
                    break;
                } else {
                    System.out.print((char) _ch);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

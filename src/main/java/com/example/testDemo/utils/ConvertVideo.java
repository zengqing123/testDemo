package com.example.testDemo.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.system.ApplicationHome;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConvertVideo {
    private static final String projectDir = new ApplicationHome(ConvertVideo.class).getDir().toString();

    /**
     * 视频转化
     *
     * @param url        视频源地址
     * @param ffmpegPath ffmpeg 软件安装目录
     * @return
     */
    public static Map<String, Object> convertVideo(String url, String ffmpegPath) {
        Map<String, Object> map = new HashMap<>();
        String toolPath = ffmpegPath;
        if (StringUtils.isBlank(toolPath)) {
            toolPath = getFfmpegPath();
        }
        String outputPath = getOutputPath();
        map.put("path", outputPath);
        map.put("flag", false);
        try {
            Boolean ffmpeg = FfmpegUtil.ffmpeg(toolPath, url, outputPath);
            map.put("flag", ffmpeg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取ffmpeg执行文件的路径
     *
     * @return
     */
    private static String getFfmpegPath() {
        return projectDir + File.separator + "ffmpeg";
    }

    /**
     * 获取输出文件名
     *
     * @return
     */
    private static String getOutputPath() {
        String tempPath = projectDir + File.separator + "video" + File.separator;
        File tempFolder = new File(tempPath);
        if (!tempFolder.exists()) {
            boolean mkdirs = tempFolder.mkdirs();
            if (mkdirs) {
                return tempPath + UUID.randomUUID().toString().replaceAll("-", "") + ".mp4";
            }
        }
        return tempPath + UUID.randomUUID().toString().replaceAll("-", "") + ".mp4";
    }
}

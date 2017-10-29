package com.mobin.thread.Example;

/**
 * Created by Mobin on 2017/8/6.
 */
public class BigFileDownloaderMain {
    public static void main(String[] args) throws Exception {
        String url = "http://101.44.1.118/files/5211000006D9CFFB/dlc2.pconline.com.cn/filedown7_1322_29001581/dKg4hJWu/Adobe_Reader_XI_zh_CN_2200000013229001581.exe";
        BigFileDownloader downloader = new BigFileDownloader(url);
        int workerThreadCount = 3;
        long reportInterval = 2;
        downloader.download(workerThreadCount, reportInterval);
    }
}

package com.mobin.thread.Example;

/**
 * Created by Mobin on 2017/8/6.
 */
public class BigFileDownloaderMain {
    public static void main(String[] args) throws Exception {
        String url = "https://downloads.atlassian.com/software/sourcetree/windows/ga/SourceTreeSetup-2.3.1.0.exe?_ga=2.161465213.1522870431.1508740383-2134808483.1508740383";
        BigFileDownloader downloader = new BigFileDownloader(url);
        int workerThreadCount = 3;
        long reportInterval = 2;
        downloader.download(workerThreadCount, reportInterval);
    }
}

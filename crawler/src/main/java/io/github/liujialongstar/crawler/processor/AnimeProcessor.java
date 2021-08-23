package io.github.liujialongstar.crawler.processor;

import io.github.liujialongstar.crawler.utils.UrlFileDownloadUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

/**
 * @author liujialong
 * @date 2021/8/18
 * 用于抓取喜欢的番剧
 */
public class AnimeProcessor {
    public static void main(String[] args) {
        //谷歌驱动在你本地位置
        String value="D:/爬虫/chromedriver.exe";
        String key="webdriver.chrome.driver";
        System.setProperty(key,value);
        WebDriver driver = new ChromeDriver();

        // 番剧标题, 集数
        String title = "Code Geass 反叛的鲁路修R2";
        int num = 25;
        for (int i = 1; i <= num; i++) {
            // 番剧地址
            String url = "http://yhdm5.com/acg/19890/" + i + ".html";
            System.out.println("目标页面url: " + url);

            driver.get(url);
            WebElement iframe1 = driver.findElement(By.id("playiframe"));
            driver.switchTo().frame(iframe1);

            WebElement iframe2 = driver.findElements(By.id("playiframe")).get(0);
            driver.switchTo().frame(iframe2);

            WebElement video = driver.findElements(By.tagName("video")).get(0);
            String videoUrl = video.getAttribute("src");
            System.out.println("视频地址url: " + videoUrl);

//            String videoFormat =videoUrl.substring(videoUrl.lastIndexOf("."));
//            String fileName = String.format("D:/番剧/%s/%s%02d%s", title, title, i, videoFormat);
            String fileName = String.format("D:/番剧/%s/%s%03d.mp4", title, title, i);
            System.out.println("文件路径: " + fileName);
            File destFile = new File(fileName);
            UrlFileDownloadUtil.downloadVideo(videoUrl, destFile);
            System.out.println("\n\n\n" + title + i + " 下载完成\n\n\n");
        }

    }
}
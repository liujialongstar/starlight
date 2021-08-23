package io.github.liujialongstar.crawler.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author liujialong
 * @date 2021/8/18
 */
public class UrlFileDownloadUtil {
    /**
     * 下载视频
     * @param url
     * @throws IOException
     */
    public static void downloadVideo(String url, File destFile)  {
        try {
            if(!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }

            URL videoUrl = new URL(url);
            InputStream is = videoUrl.openStream();
            FileOutputStream fos = new FileOutputStream(destFile);

            int len = 0;
            byte[] buffer = new byte[1024];
            while ((-1) != (len = is.read(buffer))) {
                fos.write(buffer, 0, len);
            }
            fos.flush();

            if (null != fos) {
                fos.close();
            }

            if (null != is) {
                is.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

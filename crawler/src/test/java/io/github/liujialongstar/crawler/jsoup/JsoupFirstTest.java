package io.github.liujialongstar.crawler.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
public class JsoupFirstTest {
    @Test
    public void testUrl() throws Exception{
        //解析url
        URL url = new URL("http://www.itcast.cn");
        Document doc = Jsoup.parse(url, 1000);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }
}

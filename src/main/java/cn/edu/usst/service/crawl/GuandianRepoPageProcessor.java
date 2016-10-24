package cn.edu.usst.service.crawl;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by Wan on 2016/9/21 0021.
 */
public class GuandianRepoPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setCharset("UTF-8").setRetryTimes(3).setSleepTime(1000);


    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        List<String> title = page.getHtml().xpath("//li[@class='clearfix']//h2//a//text()").all();
        List<String> url = page.getHtml().xpath("//li[@class='clearfix']//h2//a/@href").all();
        //page.putField("title", title);
        //page.putField("url", url);
        for (int i = 0; i < title.size(); i++) {
            System.out.println(title.get(i)+" "+url.get(i));
        }


        //筛选不符合的
        if (page.getResultItems().get("title") == null) {
            page.setSkip(true);
        }

        // 部分三：从页面发现后续的url地址来抓取
        //page.addTargetRequests(url);


    }


    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new GuandianRepoPageProcessor())
                .addUrl("http://news.leju.com/")
                .thread(5)
                .run();
    }
}

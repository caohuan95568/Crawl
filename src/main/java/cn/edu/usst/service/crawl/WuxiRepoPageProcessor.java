package cn.edu.usst.service.crawl;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by Wan on 2016/9/22 0022.
 */
public class WuxiRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setCharset("GBK").setRetryTimes(3).setSleepTime(1000);

    public void process(Page page) {

        List<String> title = page.getHtml().xpath("//td[@valign='top']//div[@class='list_title']//a/@title").all();
        List<String> url = page.getHtml().xpath("//td[@valign='top']//div[@class='list_title']//a/@href").all();
        System.out.println("------------进入------------------");
        for (int i = 0; i < title.size(); i++) {
            System.out.println(title.get(i)+"  "+url.get(i));
        }

        // 部分三：从页面发现后续的url地址来抓取
        //page.addTargetRequests(url);
    }


    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new WuxiRepoPageProcessor())
                .addUrl("http://www.wxhouse.com/yanjiu/list.html?typeid=208")
                .thread(5)
                .run();
    }
}

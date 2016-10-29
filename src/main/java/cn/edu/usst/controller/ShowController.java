package cn.edu.usst.controller;

import cn.edu.usst.dao.EstateSalesRepository;
import cn.edu.usst.pojos.EstateSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Wan on 2016/9/22 0022.
 */
@RestController
public class ShowController {

    @Autowired
    private EstateSalesRepository mSalesRepository;

    @RequestMapping("/getPrice")
    public List<EstateSales> getPrice() {
        List<EstateSales> list = mSalesRepository.findBytimeUnit("日");
        return list;
    }


 @RequestMapping("/getPicPrice")
    public List<EstateSales> getPicPrice(){
     Date date = null;
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     try {
         date = sdf.parse("2016-08-01");
     } catch (ParseException e) {
         System.out.println("parse fail...");
     }
     List<EstateSales> list =mSalesRepository.findBytimeUnitAndDateTime("月",date);
     return list;
 }


    @RequestMapping("/Echarts")
    public String getEcharts(){
        return "{\"category\":[\"北京\",\"上海\",\"天津\",\"杭州\",\"南京\",\"武汉\"], \"value\":[38926, 43420, 12716, 18340, 18913, 10365]}";
    }


}

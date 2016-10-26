package cn.edu.usst.controller;

import cn.edu.usst.dao.EstateSalesRepository;
import cn.edu.usst.pojos.EstateSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
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
        List<EstateSales> list = new ArrayList<EstateSales>();
        //        EstateSales es1 = new EstateSales("上海", "123", "456");
        //        EstateSales es2 = new EstateSales("北京", "123", "456");
        //        EstateSales es3 = new EstateSales("天津", "123", "456");
        //        list.add(es1);
        //        list.add(es2);
        //        list.add(es3);
        Iterator<EstateSales> iterator = mSalesRepository.findAll().iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }


}

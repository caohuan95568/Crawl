package cn.edu.usst.dao;

import cn.edu.usst.pojos.EstateSales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Wan on 2016/10/23 0023.
 */
@Repository
public interface EstateSalesRepository extends CrudRepository<EstateSales, Long> {
    List<EstateSales> findBytimeUnit(String timeUnit);

    List<EstateSales> findBytimeUnitAndDateTime(String timeUnit,Date date);
}

package com.kdn.ecsi.epengine.repositories;

import com.kdn.ecsi.epengine.domain.CommUrlInfo;
import com.kdn.ecsi.epengine.domain.CommUrlInfoPK;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Young Gyu Park on 1/10/2015.
 */
@Repository
public interface CommUrlInfoRepository extends CrudRepository<CommUrlInfo, CommUrlInfoPK>, QueryDslPredicateExecutor<CommUrlInfo> {

    // @Query(value = "SELECT * FROM whatever_custom_query here s WHERE s.reconciliation_setting_id=?1", nativeQuery = true)
    // B2gHist doAFoo(String s);

}
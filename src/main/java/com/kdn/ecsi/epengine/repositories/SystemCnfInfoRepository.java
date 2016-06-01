package com.kdn.ecsi.epengine.repositories;

import com.kdn.ecsi.epengine.domain.SystemCnfInfo;
import com.kdn.ecsi.epengine.domain.SystemCnfInfoPK;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Young Gyu Park on 1/10/2015.
 */
@Repository
public interface SystemCnfInfoRepository extends CrudRepository<SystemCnfInfo, SystemCnfInfoPK>, QueryDslPredicateExecutor<SystemCnfInfo> {

    // @Query(value = "SELECT * FROM whatever_custom_query here s WHERE s.reconciliation_setting_id=?1", nativeQuery = true)
    // B2gHist doAFoo(String s);

}

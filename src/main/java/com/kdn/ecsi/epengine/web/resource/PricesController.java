package com.kdn.ecsi.epengine.web.resource;

import com.kdn.ecsi.epengine.domain.QUcostDlHist;
import com.kdn.ecsi.epengine.domain.QUcostInfo;
import com.kdn.ecsi.epengine.domain.UcostDlHist;
import com.kdn.ecsi.epengine.domain.UcostDlHistPK;
import com.kdn.ecsi.epengine.domain.UcostInfo;
import com.kdn.ecsi.epengine.domain.UcostInfoPK;
import com.kdn.ecsi.epengine.domain.oxm.*;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResGet02;
import com.kdn.ecsi.epengine.domain.oxm.response.body.GET02;
import com.kdn.ecsi.epengine.repositories.UcostDlHistRepository;
import com.kdn.ecsi.epengine.repositories.UcostInfoRepository;
import com.kdn.ecsi.epengine.support.CommonUtil;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Log4j2
@Profile("web")
@Component
@Path("/prices")
@Produces(MediaType.APPLICATION_XML)
public class PricesController {

    // @Inject
    // private CustomerRepository customerRepository;
 
     @Inject
    private UcostInfoRepository ucostInfoRepository;
     
     @Inject
     private UcostDlHistRepository ucostDlHistRepository;

    @GET
    @Path("{charger_type}/{version}")
    public EvcomResGet02 get02(@PathParam("charger_type") int chargerType, @PathParam("version") String version) {

        EvcomResponseHead erh = null;
        EvcomResGet02 ec = null;
        System.out.println("chargerTypechargerTypechargerTypechargerTypechargerType : " + chargerType);
        
        int rcd;
        String rms;
        GET02 ERB;
       // 공통 유틸 선언
        CommonUtil comm = new CommonUtil(); 
        long ecrdt = comm.getNowDate();
        try {
        	
	        QUcostInfo qui = QUcostInfo.ucostInfo;
	        //주어진 정보로 해당된 충전기의 단가를 조회 한다
	        Iterable<UcostInfo> ui = ucostInfoRepository.findAll(qui.id.eqpType.eq(String.valueOf(chargerType)).and(qui.id.ucostNum.eq(version))
	        		.and(qui.id.protocolType.eq(2)));
	        
	        // 단가가를 리스트 형식으로 배열로 선언한다.
	        Stream<UcostInfo> s = StreamSupport.stream(ui.spliterator(), false);
	        List<BigDecimal> ucosts = s.map(c -> c.getKwhUcost()).collect(Collectors.toList());
	        log.info("====================================================");
	        log.info(ucosts);
	        log.info("---------------------------------------------------");
	        
	        

	        for (int i = 0; i < ucosts.size(); i++) {
	        	// 단가 다운로드 테이블 선언
	        	UcostDlHistPK udlPk = new UcostDlHistPK();
	        	UcostDlHist udlh = new UcostDlHist();
	        	
	        	//데이터 값 세팅
	        	udlPk.setEqpNum(0);
	  	        udlPk.setUcostNum(version);
	  	        udlPk.setHh24(i);
	        	udlPk.setIntervalNo(0);
	        	udlPk.setProtocolTp(2);
	        	udlPk.setUcostTp(0);
	        	udlPk.setEqpTp(String.valueOf(chargerType));
	        	udlPk.setDlDatetime(comm.dateTime(comm.getNowDate()));
	        	udlh.setId(udlPk);
	        	udlh.setKwhbillUcost(ucosts.get(i));

	        	// 단가 다운로드 저장
	        	ucostDlHistRepository.save(udlh);
			}
	        	        
	        if(qui.id.eqpType.eq(String.valueOf(chargerType)) != null && qui.id.ucostNum.eq(version)  != null && qui.id.protocolType.eq(2) != null ){
	        	rcd = 1;
	        	rms = "성공";
	        } else {
	        	rcd = 999;
	        	rms = "실패";
	        }
	        erh = new EvcomResponseHead(ecrdt, 0, "00", rcd, rms, 000);
	    	ERB = new GET02(chargerType, version, ucosts.get(0).intValue(), ucosts.get(1).intValue(), ucosts.get(2).intValue(), ucosts.get(3).intValue(), ucosts.get(4).intValue(), ucosts.get(5).intValue(),
	        		ucosts.get(6).intValue(),  ucosts.get(7).intValue(),  ucosts.get(8).intValue(),  ucosts.get(9).intValue(), ucosts.get(10).intValue(), 
	        		ucosts.get(11).intValue(), ucosts.get(12).intValue(), ucosts.get(13).intValue(), ucosts.get(14).intValue(), ucosts.get(15).intValue(),
	        		ucosts.get(16).intValue(), ucosts.get(17).intValue(), ucosts.get(18).intValue(), ucosts.get(19).intValue(), ucosts.get(20).intValue(),
	        		ucosts.get(21).intValue(), ucosts.get(22).intValue(), ucosts.get(23).intValue());  
	    	
	    	// 응답하는 값을 세팅
	        ec = new EvcomResGet02(erh, ERB);

        } catch (Exception e) {
        	rcd = 999;
        	rms = "실패";
        	erh = new EvcomResponseHead(ecrdt, 0, "00", rcd, rms, 000);
        	ERB = new GET02();
        	// 응답하는 값을 세팅
	        ec = new EvcomResGet02(erh, ERB);
        	
            System.out.println( e );
        } 
        return ec;
       }
    
}



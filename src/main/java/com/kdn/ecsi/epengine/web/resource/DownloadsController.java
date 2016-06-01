package com.kdn.ecsi.epengine.web.resource;

import com.kdn.ecsi.epengine.domain.CpProgramInfo;
import com.kdn.ecsi.epengine.domain.ProgramDlHist;
import com.kdn.ecsi.epengine.domain.ProgramDlHistPK;
import com.kdn.ecsi.epengine.domain.QCpProgramInfo;
import com.kdn.ecsi.epengine.domain.oxm.*;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResGet03;
import com.kdn.ecsi.epengine.repositories.CpProgramInfoRepository;
import com.kdn.ecsi.epengine.repositories.ProgramDlHistRepository;
import com.kdn.ecsi.epengine.support.CommonUtil;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Log4j2
@Profile("web")
@Component
@Path("/downloads")
@Produces(MediaType.APPLICATION_XML)
public class DownloadsController {

	@Inject
	CpProgramInfoRepository cpProgramInfoRepository;
	
	@Inject
	ProgramDlHistRepository programDlHistRepository;
	
	@SuppressWarnings("unused")
	@GET
	@Path("{chager_prd}/{prog_kind}/{version}")
	public EvcomResGet03 get03(@PathParam("chager_prd") String chager_prd, @PathParam("prog_kind") String prog_kind,
			@PathParam("version") String version) {

		EvcomResGet03 ec = null;
		EvcomResponseHead erh = null;
		
		// 공통 유틸 선언
		CommonUtil comm = new CommonUtil();
		long ecrdt = comm.getNowDate();
		int sid = 0;
		String cid = "00";
		int rcd;
		String rms;
		int tid = 0;
		
		//program_dl_hist 테이블 선언
		ProgramDlHist pdh = new ProgramDlHist();
		ProgramDlHist Savepdh = null;
		ProgramDlHistPK pdhPk = new ProgramDlHistPK();

		try {
			QCpProgramInfo qcpif = QCpProgramInfo.cpProgramInfo;
			CpProgramInfo cpif = cpProgramInfoRepository
					.findOne(qcpif.cpCompanyInfo.maker.eq(chager_prd).and(qcpif.programName.eq(prog_kind)).and(qcpif.programVer.eq(version))); 

			if (cpif == null) {
				rcd = 999;
				rms = "실패";
				erh = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, tid);
				ec = new EvcomResGet03(erh, null);
				
				return ec;
			} else {
				
				//파일 경로 설정
				String filePath = cpif.getParogramPath();
				File verfile = new File(filePath);
				long FileSize = verfile.length();
				
				//파일 읽기
				FileInputStream in = new FileInputStream(verfile);
				byte[] buf = new byte[(int) FileSize];
				//데이터 담기
				in.read(buf, 0, (int)FileSize);
				
				//pk값 설정
				pdhPk.setEqpNum(0);
				pdhPk.setDlDate(String.valueOf(ecrdt));
				pdhPk.setProgramNum(cpif.getProgramNum());
				
				//program_dl_hist 저장
				pdh.setId(pdhPk);
				pdh.setMaker(chager_prd);
				pdh.setProgramName(prog_kind);
				pdh.setProgramVer(version);
				
				Savepdh = programDlHistRepository.save(pdh);

				log.info("Savepdh : " + Savepdh );
				log.info(Savepdh.getId().getEqpNum());
				log.info(Savepdh.getId().getProgramNum());
				log.info(Savepdh.getId().getDlDate());
				log.info(Savepdh.getMaker());
				log.info(Savepdh.getProgramName());
				log.info(Savepdh.getProgramVer());
				
				if (Savepdh != null ) {
					rcd = 1;
					rms = "성공";

					erh = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, tid);
					ec = new EvcomResGet03(erh, buf);
				} else {
					rcd = 999;
					rms = "실패";
					
					erh = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, tid);
					ec = new EvcomResGet03(erh, null);
				}
			}
			
			
		} catch (Exception e) {
			rcd = 999;
			rms = "요청(전송)처리실패";
			ec = new EvcomResGet03(null, null);
			System.out.println(e);
		}
		return ec;
	}
}

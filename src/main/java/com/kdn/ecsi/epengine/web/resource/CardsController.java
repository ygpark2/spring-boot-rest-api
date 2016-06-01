package com.kdn.ecsi.epengine.web.resource;

import com.kdn.ecsi.epengine.domain.oxm.*;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos04;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos04;
import com.kdn.ecsi.epengine.domain.oxm.response.body.POS04;
import com.kdn.ecsi.epengine.repositories.CsInfoRepository;
import com.kdn.ecsi.epengine.repositories.EquipInfoRepository;
import com.kdn.ecsi.epengine.support.CommonUtil;
import com.kdn.ecsi.epengine.support.GenericUnmarshallFactory;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

@Profile("web")
@Component
@Path("/cards")
@Log4j2
@Produces(MediaType.APPLICATION_XML)
public class CardsController {
	CommonUtil commonUtil = new CommonUtil();

	@Inject
	EquipInfoRepository equipInfoRepository;

	@Inject
	CsInfoRepository csInfoRepository;

	@POST
	@Path("{card-number}/auth")

	public EvcomResPos04 pos04(@PathParam("card-number") String cardNumber, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		int rcd = 0;
		String rms = null;
		String cardNum = null;
		int payType = 0;
		EvcomResPos04 ec = null;
		EvcomResponseHead ech = null;
		POS04 ecb;

		long ecrdt = commonUtil.getNowDate();

		OutputStreamWriter wr = null;
		BufferedReader rd = null;

		try {

			EvcomReqPos04 ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos04.class, xmlBody);

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(ecr.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(ecr.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr.getHd().getSts())) {
				stsChecked = true;
			}
			// 정상적일때
			if (stsChecked && cidChecked && sidChecked && timeChecked) {

				// Construct data
				String data = URLEncoder.encode("stm", "UTF-8") + "="
						+ URLEncoder.encode(String.valueOf(ecr.getHd().getStm()), "UTF-8");
				data += "&" + URLEncoder.encode("sid", "UTF-8") + "="
						+ URLEncoder.encode(String.valueOf(ecr.getHd().getSid()), "UTF-8");
				data += "&" + URLEncoder.encode("cid", "UTF-8") + "="
						+ URLEncoder.encode(String.valueOf(ecr.getHd().getCid()), "UTF-8");
				data += "&" + URLEncoder.encode("sts", "UTF-8") + "="
						+ URLEncoder.encode(String.valueOf(ecr.getHd().getSts()));
				data += "&" + URLEncoder.encode("tid", "UTF-8") + "="
						+ URLEncoder.encode(String.valueOf(ecr.getHd().getTid()));
				data += "&" + URLEncoder.encode("cno", "UTF-8") + "=" + URLEncoder.encode(cardNumber, "UTF-8");

				// Send data
				URL url = new URL("http://localhost:8080/uppage/trans_cno.jsp");
				URLConnection conn = url.openConnection();

				conn.setDoOutput(true);
				wr = new OutputStreamWriter(conn.getOutputStream());
				wr.write(data);
				wr.flush();

				// Get the response
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				String line;

				while ((line = rd.readLine()) != null) {
					if (line.indexOf("rcd") != -1) {
						rcd = Integer.parseInt(commonUtil.getNumber(line));
					}
					if (line.indexOf("rms") != -1) {
						rms = commonUtil.getLanguage(line);
					}
					if (line.indexOf("cno") != -1) {
						cardNum = commonUtil.getNumber(line);
					}
					if (line.indexOf("pyn") != -1) {
						payType = Integer.parseInt(commonUtil.getNumber(line));
					}
				}
			}

			// 데이터 값 세팅
			if (!timeChecked) {
				rcd = 901;
				rms = "충전기 시간 오류 (stm)";
			} else if (!sidChecked) {
				rcd = 902;
				rms = "충전소 ID 오류, 일치하는 충전소가 없거나 승인되지 않은 충전소 (sid)";
			} else if (!cidChecked) {
				rcd = 903;
				rms = "충전기 ID 오류, 일치하는 충전기가 없거나 승인되지 않은 충전기 (cid)";
			} else if (!stsChecked) {
				rcd = 904;
				rms = "충전기 상태 코드 오류 (sts)";
			}

			ech = new EvcomResponseHead(ecrdt, ecr.getHd().getSid(), ecr.getHd().getCid(), rcd, rms,
					ecr.getHd().getTid());
			ecb = new POS04(cardNum, payType);

			ec = new EvcomResPos04(ech, ecb);

		} catch (Exception e) {
			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos04 ecr = null;
			int tid = 0;
			try {
				ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos04.class, xmlBody);
				tid = ecr.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			ec = new EvcomResPos04(
					new EvcomResponseHead(rdatetime, ecr.getHd().getSid(), ecr.getHd().getCid(), rcd, rms, tid),
					new POS04(cardNum, payType));
			System.out.println(e);
		}
		return ec;
	}
}

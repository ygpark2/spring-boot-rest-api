package com.kdn.ecsi.epengine.web.resource;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import com.kdn.ecsi.epengine.domain.oxm.request.*;
import com.kdn.ecsi.epengine.domain.oxm.response.body.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.kdn.ecsi.epengine.domain.ChargingEndHist;
import com.kdn.ecsi.epengine.domain.ChargingEndHistPK;
import com.kdn.ecsi.epengine.domain.ChargingEndInfo;
import com.kdn.ecsi.epengine.domain.ChargingEndInfoPK;
import com.kdn.ecsi.epengine.domain.ChargingPayHist;
import com.kdn.ecsi.epengine.domain.ChargingPayHistPK;
import com.kdn.ecsi.epengine.domain.ChargingStat;
import com.kdn.ecsi.epengine.domain.ChargingStatHist;
import com.kdn.ecsi.epengine.domain.ChargingStatHistPK;
import com.kdn.ecsi.epengine.domain.ChargingStatPK;
import com.kdn.ecsi.epengine.domain.CpCtrl;
import com.kdn.ecsi.epengine.domain.CpCtrlHist;
import com.kdn.ecsi.epengine.domain.CpCtrlPK;
import com.kdn.ecsi.epengine.domain.CpDayEndHist;
import com.kdn.ecsi.epengine.domain.CpDayEndHistPK;
import com.kdn.ecsi.epengine.domain.CpProgramInfo;
import com.kdn.ecsi.epengine.domain.CsInfo;
import com.kdn.ecsi.epengine.domain.EquipInfo;
import com.kdn.ecsi.epengine.domain.OutletStat;
import com.kdn.ecsi.epengine.domain.OutletStatPK;
import com.kdn.ecsi.epengine.domain.ProtocolInfo;
import com.kdn.ecsi.epengine.domain.QChargingEndInfo;
import com.kdn.ecsi.epengine.domain.QChargingStat;
import com.kdn.ecsi.epengine.domain.QCpCtrl;
import com.kdn.ecsi.epengine.domain.QCpCtrlHist;
import com.kdn.ecsi.epengine.domain.QCpProgramInfo;
import com.kdn.ecsi.epengine.domain.QCsInfo;
import com.kdn.ecsi.epengine.domain.QEquipInfo;
import com.kdn.ecsi.epengine.domain.QProtocolInfo;
import com.kdn.ecsi.epengine.domain.QUcostInfo;
import com.kdn.ecsi.epengine.domain.UcostInfo;
import com.kdn.ecsi.epengine.domain.WarningHist;
import com.kdn.ecsi.epengine.domain.WarningHistPK;
import com.kdn.ecsi.epengine.domain.WarningStat;
import com.kdn.ecsi.epengine.domain.WarningStatPK;
import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseHead;
import com.kdn.ecsi.epengine.domain.oxm.fields.PG;
import com.kdn.ecsi.epengine.domain.oxm.fields.PG_KND;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.CTRM;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.EIP;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.EPT;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.FR;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.KND;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.MOD;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.PRM;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.RTRM;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.STRM;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.TO;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.VER;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.VIP;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.VPT;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.VTRM;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos01;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos02;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos03;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos06;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos07;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos08;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos09;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos10;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos11;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos12;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos13;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos15;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos16;
import com.kdn.ecsi.epengine.domain.oxm.request.EvcomReqPos17;

import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResGet01;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos01;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos02;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos03;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos06;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos07;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos08;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos09;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos10;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos11;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos12;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos13;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos14;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos15;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos16;
import com.kdn.ecsi.epengine.domain.oxm.response.EvcomResPos17;
import com.kdn.ecsi.epengine.repositories.B2gHistRepository;
import com.kdn.ecsi.epengine.repositories.ChargingEndHistRepository;
import com.kdn.ecsi.epengine.repositories.ChargingEndInfoRepository;
import com.kdn.ecsi.epengine.repositories.ChargingPayHistRepository;
import com.kdn.ecsi.epengine.repositories.ChargingStatHistRepository;
import com.kdn.ecsi.epengine.repositories.ChargingStatRepository;
import com.kdn.ecsi.epengine.repositories.ComCdRepository;
import com.kdn.ecsi.epengine.repositories.CpCtrlHistRepository;
import com.kdn.ecsi.epengine.repositories.CpCtrlRepository;
import com.kdn.ecsi.epengine.repositories.CpDayEndHistRepository;
import com.kdn.ecsi.epengine.repositories.CpProgramInfoRepository;
import com.kdn.ecsi.epengine.repositories.CsInfoRepository;
import com.kdn.ecsi.epengine.repositories.EquipInfoRepository;
import com.kdn.ecsi.epengine.repositories.NetStatRepository;
import com.kdn.ecsi.epengine.repositories.OutletInfoRepository;
import com.kdn.ecsi.epengine.repositories.OutletStatRepository;
import com.kdn.ecsi.epengine.repositories.ProtocolInfoRepository;
import com.kdn.ecsi.epengine.repositories.UcostInfoRepository;
import com.kdn.ecsi.epengine.repositories.WarningHistRepository;
import com.kdn.ecsi.epengine.repositories.WarningStatRepository;
import com.kdn.ecsi.epengine.support.CommonUtil;
import com.kdn.ecsi.epengine.support.GenericUnmarshallFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Profile("web")
@Component
@Path("/stations")
@Produces(MediaType.APPLICATION_XML)
public class StationsController {
	CommonUtil commonUtil = new CommonUtil();

	@Inject
	B2gHistRepository b2gHistRepository;

	@Inject
	NetStatRepository netStatRepository;

	@Inject
	ProtocolInfoRepository protocolInfoRepository;

	@Inject
	ComCdRepository comCdRepository;

	@Inject
	CpDayEndHistRepository cpDayEndHistRepository;

	@Inject
	EquipInfoRepository equipInfoRepository;

	@Inject
	CpCtrlRepository cpCtrlRepository;

	@Inject
	CpCtrlHistRepository cpCtrlHistRepository;

	@Inject
	WarningStatRepository warningStatRepository;

	@Inject
	WarningHistRepository warningHistRepository;

	@Inject
	OutletStatRepository outletStatRepository;

	@Inject
	ChargingStatRepository chargingStatRepository;

	@Inject
	ChargingStatHistRepository chargingStatHistRepository;

	@Inject
	ChargingEndHistRepository chargingEndHistRepository;

	@Inject
	CsInfoRepository csInfoRepository;

	@Inject
	OutletInfoRepository outletInfoRepository;

	@Inject
	UcostInfoRepository ucostInfoRepository;

	@Inject
	ChargingEndInfoRepository chargingEndInfoRepository;

	@Inject
	ChargingPayHistRepository chargingPayHistRepository;

	@Inject
	CpProgramInfoRepository cpProgramInfoRepository;

	@POST
	@Path("{sid}/chargers/{cid}")
	public EvcomResPos01 pos01(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResponseHead erh = null;
		POS01 erb = null;
		EvcomResPos01 ec = null;
		int rcd;
		String rms;
		try {
			EvcomReqPos01 ecr01 = GenericUnmarshallFactory.getInstance(EvcomReqPos01.class, xmlBody);

			OutletStat saveOS = null;
			OutletStat oS = null;
			OutletStatPK oSPk = new OutletStatPK();
			long rdatetime = commonUtil.getNowDate();
			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr01.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr01.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr01.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr01.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				int outletNumber = 1;

				oSPk.setEqpNum(eqpNumber);
				oSPk.setOutletNum(outletNumber);

				oS = outletStatRepository.findOne(oSPk);
				if (oS == null) {
					oS = new OutletStat();
				}
				oS.setId(oSPk);
				oS.setOutletStat(ecr01.getHd().getSts());
				oS.setUpdateDay(String.valueOf(ecr01.getHd().getStm()).substring(0, 8));
				oS.setUpdateTime(String.valueOf(ecr01.getHd().getStm()).substring(8));

				saveOS = outletStatRepository.save(oS); // 상태테이블 업데이트
				checked = true;
			}
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
			} else if (saveOS != null && checked) {
				rcd = 1;
				rms = "전송성공";
			} else {
				rcd = 999;
				rms = "요청(전송)처리실패";
			}

			if (rcd == 1) {
				log.info("POS01가 정상처리 되었습니다.");
			} else {
				log.info("POS01가 실패했습니다.");
			}
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr01.getHd().getTid());
			erb = new POS01();
			ec = new EvcomResPos01(erh, erb);
		} catch (Exception e) {
			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos01 ecr01 = null;
			int tid = 0;
			try {
				ecr01 = GenericUnmarshallFactory.getInstance(EvcomReqPos01.class, xmlBody);
				tid = ecr01.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				e1.printStackTrace();
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, tid);
			erb = new POS01();
			ec = new EvcomResPos01(erh, erb);
			System.out.println(e);
		}
		return ec;
	}

	@GET
	@Path("{sid}/chargers/{cid}/commands")
	public EvcomResGet01 get01(@PathParam("sid") int sid, @PathParam("cid") String cid) {

		EvcomResponseHead erh01 = null;
		GET01 erb01 = null;
		int rcd = 0;
		String rms = null;
		int ptt = 2;
		String on = "1";
		int cdt = 0;
		int seq = 0;
		String cmd = null;
		String ver = "";
		String knd = "";
		String fr = "";
		String to = "";
		int EqpNum = 0;
		int strm = 0;
		int rtrm = 0;
		int ctrm = 0;
		int vtrm = 0;
		int mod = 0;
		Iterable<CpCtrl> cpCtrlEntries = null;
		long ecrdt = commonUtil.getNowDate();

		try {
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, equipInfoRepository)) {
				cidChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (sidChecked && cidChecked && sidCidChecked) {

				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				QCpCtrl qcpCtrl = QCpCtrl.cpCtrl;

				CpCtrl ct = null;
				CpCtrlPK ctPk = new CpCtrlPK();

				// 등록 되어 있는 원격명령을 찾자
				cpCtrlEntries = cpCtrlRepository.cpCtrlTest(sid, cid, ptt, on);

				if (!cpCtrlEntries.iterator().hasNext()) {
					rcd = 2;
					rms = "원격명령 없음";
					erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
					erb01 = new GET01(cdt, seq, cmd);
				} else {
					// cpCtrlEntries 데이터 보기
					cpCtrlEntries.forEach(c -> {
						log.info(c.getId().getEqpNum());
						log.info(c.getId().getOutletNum());
						log.info(c.getId().getRegstDay());
						log.info(c.getId().getRegstTime());
						log.info(c.getCtrlCode());
						log.info(c.getCtrlParameter());
						log.info(c.getTransYn());
					});

					// 찾은 원격 명령을 정의 하자
					EqpNum = cpCtrlEntries.iterator().next().getId().getEqpNum();
					cdt = Integer.parseInt(cpCtrlEntries.iterator().next().getId().getRegstDay());
					seq = Integer.parseInt(cpCtrlEntries.iterator().next().getId().getRegstTime());
					cmd = cpCtrlEntries.iterator().next().getCtrlCode();

					// CP_CTRL DB 저장처리
					ctPk.setEqpNum(EqpNum);
					ctPk.setOutletNum(Integer.parseInt(on));
					ctPk.setRegstDay(String.valueOf(cdt));
					ctPk.setRegstTime(String.valueOf(seq));

					ct = cpCtrlRepository.findOne(ctPk);
					if (ct == null) {
						new OutletStat();
					}
					ct.setTransYn("Y");

					// 원격 명령의 파라메터를 JSon 형식 으로 불러 오자
					String scptlParam = "";
					byte[] cptlParam = cpCtrlEntries.iterator().next().getCtrlParameter();

					// 파라메터 예외 처리
					if (cptlParam == null || cptlParam.equals(null)) {
						scptlParam = "{}";
					} else {
						scptlParam = new String(cptlParam);
					}

					// Json Object 처리
					JsonObject object = Json.parse(scptlParam).asObject();

					// 케이스 별로 데이터를 처리 하자.
					switch (cmd) {
					case "POS01":
						rcd = 1;
						rms = "원격명령 수신";
						erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
						erb01 = new GET01(cdt, seq, cmd);
						// DB 저장
						cpCtrlRepository.save(ct);
						break;

					case "POS11":
						rcd = 1;
						rms = "원격명령 수신";
						erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
						erb01 = new GET01(cdt, seq, cmd);
						// DB 저장
						cpCtrlRepository.save(ct);
						break;

					case "CCFG":
						// PRM 데이터 값 setting
						String eip = object.get("eip").asString();
						String ept = object.get("ept").asString();
						String vip = object.get("vip").asString();
						String vpt = object.get("vpt").asString();
						strm = object.get("strm").asInt();
						rtrm = object.get("rtrm").asInt();
						ctrm = object.get("ctrm").asInt();
						vtrm = object.get("vtrm").asInt();

						if (eip.equals("") || eip == null || ept.equals("") || ept == null || vip.equals("")
								|| vip == null || vpt.equals("") || vpt == null || strm == 0 || rtrm == 0 || ctrm == 0
								|| vtrm == 0) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new EIP(eip));
							leip.add(new EPT(ept));
							leip.add(new VIP(vip));
							leip.add(new VPT(vpt));
							leip.add(new STRM(strm));
							leip.add(new RTRM(rtrm));
							leip.add(new CTRM(ctrm));
							leip.add(new VTRM(vtrm));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}
					case "POS13":
						rcd = 1;
						rms = "원격명령 수신";
						erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
						erb01 = new GET01(cdt, seq, cmd);
						// DB 저장
						cpCtrlRepository.save(ct);
						break;

					case "GET02":
						ver = object.get("ver").asString();

						if (ver.equals("") || ver == null) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new VER(ver));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}

					case "POS14":
						rcd = 1;
						rms = "원격명령 수신";
						erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
						erb01 = new GET01(cdt, seq, cmd);
						// DB 저장
						cpCtrlRepository.save(ct);
						break;

					case "GET03":
						knd = object.get("knd").asString();
						ver = object.get("ver").asString();

						if (ver.equals("") || ver == null || knd.equals("") || knd == null) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new KND(knd));
							leip.add(new VER(ver));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}

					case "POS15":
						fr = object.get("fr").asString();
						to = object.get("to").asString();

						if (fr.equals("") || fr == null || to.equals("") || to == null) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new FR(fr));
							leip.add(new TO(to));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}

					case "POS16":
						fr = object.get("fr").asString();
						to = object.get("to").asString();

						if (fr.equals("") || fr == null || to.equals("") || to == null) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new FR(fr));
							leip.add(new TO(to));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}

					case "POS17":
						fr = object.get("fr").asString();
						to = object.get("to").asString();

						if (fr.equals("") || fr == null || to.equals("") || to == null) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new FR(fr));
							leip.add(new TO(to));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}

					case "CMOD":
						mod = object.get("mod").asInt();

						if (mod == 0) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new MOD(mod));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}

					case "RSET":
						knd = object.get("knd").asString();

						if (knd.equals("") || knd == null) {
							rcd = 999;
							rms = "요청(전송)처리 실패";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							break;
						} else {
							rcd = 1;
							rms = "원격명령 수신";
							erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
							erb01 = new GET01(cdt, seq, cmd);
							List<PRM> leip = new ArrayList<>();
							leip.add(new KND(knd));
							erb01.setPrm(leip);
							// DB 저장
							cpCtrlRepository.save(ct);
							break;
						}

					default:
						rcd = 2;
						rms = "원격 명령 없음";
						erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
					}
				}
			}
			if (!sidChecked) {
				rcd = 902;
				rms = "충전소 ID 오류, 일치하는 충전소가 없거나 승인되지 않은 충전소 (sid)";
			} else if (!cidChecked) {
				rcd = 903;
				rms = "충전기 ID 오류, 일치하는 충전기가 없거나 승인되지 않은 충전기 (cid)";
			}
		} catch (Exception e) {
			rcd = 999;
			rms = "요청(전송)처리실패";
			erh01 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, 0);
			erb01 = new GET01(00000000, 000, "XXXXXX");
			System.out.println(e);
		}

		return new EvcomResGet01(erh01, erb01);
	}

	@POST
	@Path("{sid}/chargers/{cid}/commands")
	public EvcomResPos02 pos02(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResponseHead erh = null;
		POS02 erb = null;
		EvcomResPos02 ec = null;
		int rcd;
		String rms;
		try {

			EvcomReqPos02 ecr02 = GenericUnmarshallFactory.getInstance(EvcomReqPos02.class, xmlBody);
			QCpCtrl qcpCtrl = QCpCtrl.cpCtrl;
			QCpCtrlHist qcpCtrlHist = QCpCtrlHist.cpCtrlHist;
			Iterable<CpCtrlHist> newCCH = null;
			long ecrdt = commonUtil.getNowDate();

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr02.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr02.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr02.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기 상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr02.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				int outletNumber = 1;

				Iterable<CpCtrl> cC = cpCtrlRepository
						.findAll(qcpCtrl.id.eqpNum.eq(eqpNumber).and(qcpCtrl.id.outletNum.eq(outletNumber))
								.and(qcpCtrl.id.regstDay.eq(String.valueOf(ecr02.getBd().getSqd())))
								.and(qcpCtrl.id.regstTime.eq(String.valueOf(ecr02.getBd().getSqn())))
								.and(qcpCtrl.ctrlCode.eq(ecr02.getBd().getCmd())).and(qcpCtrl.transYn.eq("Y")));

				Iterable<CpCtrlHist> cCH = cpCtrlHistRepository
						.findAll(qcpCtrlHist.id.eqpNum.eq(eqpNumber).and(qcpCtrlHist.id.outletNum.eq(outletNumber))
								.and(qcpCtrlHist.id.regstDay.eq(String.valueOf(ecr02.getBd().getSqd())))
								.and(qcpCtrlHist.id.regstTime.eq(String.valueOf(ecr02.getBd().getSqn())))
								.and(qcpCtrlHist.ctrlCode.eq(ecr02.getBd().getCmd())));
				cCH.forEach(c -> {
					// 결과값,결과메세지 업데이트 하기 위해 값 세팅
					c.setRsltCode(String.valueOf(ecr02.getBd().getRst()));
					c.setRsltMsg(ecr02.getBd().getRms().getBytes());
				});

				newCCH = cpCtrlHistRepository.save(cCH); // 제어이력테이블에 업데이트
				cpCtrlRepository.delete(cC); // 제어테이블 삭제
				checked = true;
			}
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
			} else if (newCCH.iterator().hasNext() && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS02가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS02가 실패했습니다.");
			}

			erh = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, ecr02.getHd().getTid());
			erb = new POS02();
			ec = new EvcomResPos02(erh, erb);

		} catch (Exception e) {
			long ecrdt = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos02 ecr02 = null;
			int tid = 0;
			try {
				// 데이터 포멧 에러
				ecr02 = GenericUnmarshallFactory.getInstance(EvcomReqPos02.class, xmlBody);
				tid = ecr02.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}

			erh = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, tid);
			erb = new POS02();
			ec = new EvcomResPos02(erh, erb);
			System.out.println(e);
		}
		return ec;
	}

	@POST
	@Path("{sid}/chargers/{cid}/alarms")
	public EvcomResPos03 pos03(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResponseHead erh = null;
		POS03 erb = null;
		EvcomResPos03 ec = null;
		int rcd;
		String rms;

		int eqpNumber;

		try {

			EvcomReqPos03 ecr03 = GenericUnmarshallFactory.getInstance(EvcomReqPos03.class, xmlBody);
			log.info(ecr03.getHd());
			log.info(ecr03.getHd().getCid());
			log.info(ecr03.getHd().getSid());
			log.info(ecr03.getHd().getStm());
			log.info(ecr03.getHd().getSts());
			log.info(ecr03.getHd().getTid());
			log.info(ecr03.getBd());
			log.info(ecr03.getBd().getAcd());
			log.info(ecr03.getBd().getTdt());
			log.info(ecr03.getBd().getTtm());
			log.info(ecr03.getBd().getCdt());
			log.info(ecr03.getBd().getCtm());
			log.info(ecr03.getBd().getSts());
			log.info(ecr03.getBd().getLvl());

			log.info("-----STS---->" + ecr03.getBd().getSts().getSts());
			log.info("-----sid(충전소ID)---->" + ecr03.getHd().getSid());
			log.info("-----cid(충전기ID)---->" + ecr03.getHd().getCid());

			// 결보 발생 처리
			if (ecr03.getBd().getSts().getSts() == 1) {

				log.info("-----경보 발생---->" + ecr03.getBd().getSts().getSts());

				// validation check
				// 시간 체크
				boolean timeChecked = false;
				if (commonUtil.checkTime(ecr03.getHd().getStm())) {
					timeChecked = true;
				}
				// 충전소 체크
				boolean sidChecked = false;
				if (commonUtil.ckeckSid(sid, ecr03.getHd().getSid(), csInfoRepository)) {
					sidChecked = true;
				}
				// 충전기 체크
				boolean cidChecked = false;
				if (commonUtil.ckeckCid(cid, ecr03.getHd().getCid(), equipInfoRepository)) {
					cidChecked = true;
				}
				// 충전기상태 체크
				boolean stsChecked = false;
				if (commonUtil.checkSts(ecr03.getHd().getSts())) {
					stsChecked = true;
				}
				boolean sidCidChecked = false;
				if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
					sidCidChecked = true;
				} else {
					if (cidChecked) {
						sidChecked = false;
					}
				}
				boolean checked = false;
				if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
					checked = true;
				}

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
				} else if (checked) {
					rcd = 1;
					rms = "전송성공";
				} else {
					rcd = 999;
					rms = "요청(전송)처리실패";
				}
				// validation check

				log.info("-----경보 발생2-1---->" + ecr03.getBd().getSts().getSts());

				if (checked) {

					// 장치 번호 가져옴
					eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
					log.info("-----장치번호---->" + eqpNumber);

					// 경보 발생 PK 값 세팅
					WarningStatPK wsPk = new WarningStatPK();
					wsPk.setEqpNum(eqpNumber);
					wsPk.setOccrDay(String.valueOf(ecr03.getBd().getTdt().getTdt())); // 발생일자
					wsPk.setOccrTime(String.valueOf(ecr03.getBd().getTtm().getTtm())); // 발생일시
					wsPk.setOutletNum(1);
					wsPk.setWarningCd(String.valueOf(ecr03.getHd().getTid()));// 경보코드

					log.info("-----경보 발생1---->" + ecr03.getBd().getSts().getSts());

					// 경보 발생 데이터 값 세팅
					WarningStat ws = new WarningStat();
					ws.setId(wsPk);
					ws.setWarningLevel(ecr03.getBd().getLvl().getLvl()); // 경보레벨
					ws.setWarningStat(ecr03.getBd().getSts().getSts()); // 경보상태
					// 경보발생 데이타 저장
					ws = warningStatRepository.save(ws);

					// 경보발생 데이타 저장
					WarningHistPK whPk = new WarningHistPK();
					whPk.setEqpNum(eqpNumber);
					whPk.setOccrDay(String.valueOf(ecr03.getBd().getTdt().getTdt())); // 발생일자
					whPk.setOccrTime(String.valueOf(ecr03.getBd().getTtm().getTtm())); // 발생일시
					whPk.setOutletNum(1);
					whPk.setWarningCd(String.valueOf(ecr03.getHd().getTid()));// 경보코드

					log.info("-----경보 발생3---->" + ecr03.getBd().getSts().getSts());

					// 경보 발생 이력 데이터 값 세팅
					WarningHist wh = new WarningHist();
					wh.setId(whPk);
					wh.setWarningLevel(ecr03.getBd().getLvl().getLvl()); // 경보레벨
					wh.setWarningStat(ecr03.getBd().getSts().getSts()); // 경보상태

					log.info("-----경보 발생4---->" + ecr03.getBd().getSts().getSts());
					// 경보발생 이력 데이타 저장
					warningHistRepository.save(wh);
					log.info("-----경보 발생5---->" + ecr03.getBd().getSts().getSts());
				}

				// 경보 발생 해제.
			} else {
				log.info("-----경보 해제---->" + ecr03.getBd().getSts().getSts());

				// 장치 번호 가져옴
				eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				// validation check
				// 시간 체크
				boolean timeChecked = false;
				if (commonUtil.checkTime(ecr03.getHd().getStm())) {
					timeChecked = true;
					log.info("-----경보 해제(timeChecked)-1--->" + timeChecked);
				}
				log.info("-----경보 해제(timeChecked)-2--->" + timeChecked);
				// 충전소 체크
				boolean sidChecked = false;
				if (commonUtil.ckeckSid(sid, ecr03.getHd().getSid(), csInfoRepository)) {
					sidChecked = true;
					log.info("-----경보 해제_충전소 check(sidChecked)-1--->" + sidChecked);
				}
				log.info("-----경보 해제_충전소 check(sidChecked)-2--->" + sidChecked);
				// 충전기 체크
				boolean cidChecked = false;
				if (commonUtil.ckeckCid(cid, ecr03.getHd().getCid(), equipInfoRepository)) {
					cidChecked = true;
					log.info("-----경보 해제_충전기 check(cidChecked)-1--->" + cidChecked);
				}
				log.info("-----경보 해제_충전기 check(cidChecked)-2--->" + cidChecked);
				// 충전기상태 체크
				boolean stsChecked = false;
				if (commonUtil.checkSts(ecr03.getHd().getSts())) {
					stsChecked = true;
					log.info("-----경보 해제_상태 check(stsChecked)-1--->" + stsChecked);
				}
				log.info("-----경보 해제_상태 check(stsChecked)-2--->" + stsChecked);
				boolean sidCidChecked = false;
				if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
					sidCidChecked = true;
					log.info("-----경보 해제_check(sidCidChecked)-0--->" + stsChecked);
				} else {
					sidChecked = false;
					cidChecked = false;
					log.info("-----경보 해제_check(sidCidChecked)-1--->" + stsChecked);
				}
				boolean checked = false;
				if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
					checked = true;
					log.info("-----경보 해제checked(checked)-1--->" + checked);
				}

				log.info("-----경보 해제checked(checked)-2--->" + checked);

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
				} else if (checked) {
					rcd = 1;
					rms = "전송성공";
				} else {
					rcd = 999;
					rms = "요청(전송)처리실패";
				}
				// validation check

				if (checked) {
					// 경보 해제 PK 값 세팅
					WarningStatPK wsPk = new WarningStatPK();
					wsPk.setEqpNum(eqpNumber);
					wsPk.setOccrDay(String.valueOf(ecr03.getBd().getTdt().getTdt())); // 발생일자
					wsPk.setOccrTime(String.valueOf(ecr03.getBd().getTtm().getTtm())); // 발생일시
					wsPk.setOutletNum(1);
					wsPk.setWarningCd(String.valueOf(ecr03.getHd().getTid()));// 경보코드

					// 경보 발생 데이터 값 세팅
					WarningStat ws = new WarningStat();
					ws.setId(wsPk);
					ws.setWarningLevel(ecr03.getBd().getLvl().getLvl()); // 경보레벨
					ws.setWarningStat(ecr03.getBd().getSts().getSts()); // 경보상태

					// 경보해제 상태 데이타 저장
					warningStatRepository.delete(ws);

					log.info("-----경보 해제2---->" + ecr03.getBd().getSts().getSts());
					// 경보해제 데이타 저장
					WarningHistPK whPk = new WarningHistPK();
					whPk.setEqpNum(eqpNumber);
					whPk.setOccrDay(String.valueOf(ecr03.getBd().getTdt().getTdt())); // 발생일자
					whPk.setOccrTime(String.valueOf(ecr03.getBd().getTtm().getTtm())); // 발생일시
					whPk.setOutletNum(1);
					whPk.setWarningCd(String.valueOf(ecr03.getHd().getTid()));// 경보코드
					log.info("-----경보 해제3---->" + ecr03.getBd().getSts().getSts());
					// 경보 해제 이력 데이터 값 세팅
					WarningHist wh = new WarningHist();

					wh.setId(whPk);
					wh.setCloseDay(String.valueOf(ecr03.getBd().getCdt().getCdt())); // 해제일자
					wh.setCloseTime(String.valueOf(ecr03.getBd().getCtm().getCtm())); // 해제일시
					wh.setWarningLevel(ecr03.getBd().getLvl().getLvl()); // 경보레벨
					wh.setWarningStat(ecr03.getBd().getSts().getSts()); // 경보상태
					log.info("-----경보 해제4---->" + ecr03.getBd().getSts().getSts());
					// 경보해제 이력 데이타 저장
					warningHistRepository.save(wh);
					log.info("-----경보 해제5---->" + ecr03.getBd().getSts().getSts());
					warningHistRepository.save(wh);
				}
			}

			long rdatetime = commonUtil.getNowDate();
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr03.getHd().getTid());
			erb = new POS03();
			ec = new EvcomResPos03(erh, erb);

		} catch (Exception e) {

			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos03 ecr03 = null;
			int tid = 0;

			try {

				ecr03 = GenericUnmarshallFactory.getInstance(EvcomReqPos03.class, xmlBody);
				tid = ecr03.getHd().getTid();

			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {

				e1.printStackTrace();
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);

			}

			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, tid);
			erb = new POS03();
			ec = new EvcomResPos03(erh, erb);
			System.out.println(e);
		}

		return ec;
	}

	@POST
	@Path("{sid}/chargers/{cid}/plug")
	public EvcomResPos06 pos06(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResPos06 plug = null;
		int rcd;
		String rms;

		// date 포멧 변경
		long ecrdt = commonUtil.getNowDate();

		try {

			EvcomReqPos06 ecr06 = GenericUnmarshallFactory.getInstance(EvcomReqPos06.class, xmlBody);

			log.info(ecr06.getHd());
			log.info(ecr06.getHd().getCid());
			log.info(ecr06.getHd().getStm());
			log.info(ecr06.getHd().getSts());
			log.info(ecr06.getHd().getTid());
			log.info(ecr06.getBd());
			log.info(ecr06.getBd().getAth());
			log.info(ecr06.getBd().getPdt());
			log.info(ecr06.getBd().getPiwh());
			log.info(ecr06.getBd().getPtm());
			log.info(ecr06.getBd().getUsr());

			// long 형 date 포멧 변경
			Date dupdatetime = commonUtil.dateTime(ecr06.getHd().getStm());

			QEquipInfo qeif = QEquipInfo.equipInfo;

			// 충전 상태 이력 DB 저장
			ChargingStatHist newCsh = null;
			// 아웃넷상태 객체 선언
			OutletStat os = null;
			// 아웃넷상태 PK 선언
			OutletStatPK osPk = new OutletStatPK();
			// 아웃넷상태 저장
			OutletStat newOs = null;
			// 충전 상태 테이블 선언
			ChargingStatPK csPk = new ChargingStatPK();
			ChargingStat cs = new ChargingStat();
			// 충전 상태DB 저장
			ChargingStat newCs = null;
			// 충전 상태 이력 테이블 선언
			ChargingStatHistPK cshPk = new ChargingStatHistPK();
			ChargingStatHist csh = new ChargingStatHist();

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr06.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr06.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr06.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기 상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr06.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
				// 장비 넘버를 찾는다.
				EquipInfo eif = equipInfoRepository.findOne(qeif.csInfo.csId.eq(String.valueOf(sid))
						.and(qeif.eqpId.eq(cid)).and(qeif.protocolInfo.protocolType.eq(2)));
				// 아웃넷 번호를 찾는다.
				int oi = 1;

				// 아웃넷상태 PK 값 setting
				osPk.setEqpNum(eif.getEqpNum());
				osPk.setOutletNum(oi);

				os = outletStatRepository.findOne(osPk);
				if (os == null) {
					new OutletStat();
				}

				// 아웃넷 상태 setting
				os.setId(osPk);
				os.setOutletStat(ecr06.getHd().getSts());
				os.setUpdateDay(String.valueOf(ecr06.getHd().getStm()).substring(0, 8));
				os.setUpdateTime(String.valueOf(ecr06.getHd().getStm()).substring(8, 14));

				// 충전 상태 PK값 setting
				csPk.setEqpNum(eif.getEqpNum());
				csPk.setOutletNum(oi);

				// 충전 상태값 세팅
				cs.setId(csPk);
				cs.setMemberCardNo(ecr06.getBd().getUsr());
				cs.setAuthCl(ecr06.getBd().getAth());
				cs.setPlugDay(String.valueOf(ecr06.getBd().getPdt()));
				cs.setPlugTime(commonUtil.timeChack(ecr06.getBd().getPtm()));
				cs.setStatUpdateDatetime(dupdatetime);

				// 충전 상태 이력 PK 값 세팅
				cshPk.setEqpNum(eif.getEqpNum());
				cshPk.setOutletNum(oi);
				cshPk.setStatUpdateDatetime(dupdatetime);

				// 충전 상태 이력 값 세팅
				csh.setId(cshPk);
				csh.setMemberCardNo(ecr06.getBd().getUsr());
				csh.setAuthCl(ecr06.getBd().getAth());
				csh.setPlugDay(String.valueOf(ecr06.getBd().getPdt()));
				csh.setPlugTime(commonUtil.timeChack(ecr06.getBd().getPtm()));

				newOs = outletStatRepository.save(os);
				newCs = chargingStatRepository.save(cs);
				newCsh = chargingStatHistRepository.save(csh);
				checked = true;
			}
			// rcd , rms 응답 설정

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
			} else if (newOs != null && newCs != null && newCsh != null && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS06가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS06가 실패했습니다.");
			}

			plug = new EvcomResPos06(new EvcomResponseHead(ecrdt, ecr06.getHd().getSid(), ecr06.getHd().getCid(), rcd,
					rms, ecr06.getHd().getTid()), new POS06());

		} catch (Exception e) {

			ecrdt = commonUtil.getNowDate();

			rcd = 999;
			rms = "실패";
			EvcomReqPos06 ecr06 = null;
			int tid = 0;
			try {
				ecr06 = GenericUnmarshallFactory.getInstance(EvcomReqPos06.class, xmlBody);
				tid = ecr06.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			plug = new EvcomResPos06(
					new EvcomResponseHead(ecrdt, ecr06.getHd().getSid(), ecr06.getHd().getCid(), rcd, rms, tid),
					new POS06());
			log.info("POS06가 실패했습니다.");
			System.out.println(e);
		}
		return plug;
	}

	@POST
	@Path("{sid}/chargers/{cid}/start")
	public EvcomResPos07 pos07(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");
		EvcomResPos07 ecrp07 = null;
		EvcomResponseHead erh07 = null;
		POS07 erb07 = null;
		int rcd;
		String rms;
		try {
			EvcomReqPos07 ecr07 = GenericUnmarshallFactory.getInstance(EvcomReqPos07.class, xmlBody);

			OutletStatPK oSPk = new OutletStatPK();
			OutletStat oS = null;
			OutletStat newOS = null;
			ChargingStatPK cSPk = new ChargingStatPK();
			ChargingStat cS = null;
			ChargingStat newCS = null;
			ChargingStatHistPK cSHPk = new ChargingStatHistPK();
			ChargingStatHist cSH = new ChargingStatHist();
			ChargingStatHist newCSH = null;

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr07.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr07.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr07.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr07.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
				String endDate = commonUtil.sumChrgingEndDate(ecr07.getBd().getRmnsec());
				String endTime = commonUtil.sumChrgingEndTime(ecr07.getBd().getRmnsec());

				// 장치 번호 가져옴
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				int outletNumber = 1;

				oSPk.setEqpNum(eqpNumber);
				oSPk.setOutletNum(outletNumber);

				oS = outletStatRepository.findOne(oSPk);
				if (oS == null) {
					oS = new OutletStat();
				}
				oS.setId(oSPk);
				oS.setOutletStat(ecr07.getHd().getSts());
				oS.setUpdateDay(String.valueOf(ecr07.getHd().getStm()).substring(0, 8));
				oS.setUpdateTime(String.valueOf(ecr07.getHd().getStm()).substring(8));

				// long --> date 타입으로 형변환
				Date dupdatetime = commonUtil.dateTime(ecr07.getHd().getStm());

				cSPk.setEqpNum(eqpNumber);
				cSPk.setOutletNum(outletNumber);

				cS = chargingStatRepository.findOne(cSPk);
				if (cS == null) {
					cS = new ChargingStat();
				}
				// 업데이트 하기 위해 값 세팅
				cS.setId(cSPk);
				cS.setPlugDay(String.valueOf(ecr07.getBd().getPdt()));
				cS.setPlugTime(commonUtil.timeChack(ecr07.getBd().getPtm()));
				cS.setChargeReqCfmMthd(String.valueOf(ecr07.getBd().getCwy()));
				cS.setChargeReqAmt(BigDecimal.valueOf(ecr07.getBd().getRamt()));
				cS.setChargeReqKwh(BigDecimal.valueOf(ecr07.getBd().getRwh()));
				cS.setPayMthd(String.valueOf(ecr07.getBd().getPwy()));
				cS.setBattStat(String.valueOf(ecr07.getBd().getBsts()));
				cS.setBattCapa(BigDecimal.valueOf(ecr07.getBd().getBcapa()));
				cS.setBattRmnkwh(BigDecimal.valueOf(ecr07.getBd().getBwh()));
				cS.setBattVolt(ecr07.getBd().getBvolt());
				cS.setEndFocastDay(endDate);
				cS.setEndFocastTime(endTime);
				cS.setBmsSwVer(ecr07.getBd().getBms());
				cS.setChargeStDatetime(dupdatetime);
				cS.setStatUpdateDatetime(dupdatetime);
				cS.setChargeAccumTime(0);
				BigDecimal rate = commonUtil.chargingRate(ecr07.getBd().getBwh(),
						BigDecimal.valueOf(ecr07.getBd().getBcapa()));
				cS.setWrkExeRate(rate); // 작업진행률

				cSHPk.setEqpNum(eqpNumber);
				cSHPk.setOutletNum(outletNumber);

				cSHPk.setStatUpdateDatetime(dupdatetime);
				cSHPk.setEqpNum(eqpNumber);
				cSHPk.setOutletNum(outletNumber);

				cSH.setId(cSHPk);
				cSH.setPlugDay(String.valueOf(ecr07.getBd().getPdt()));
				cSH.setPlugTime(commonUtil.timeChack(ecr07.getBd().getPtm()));
				cSH.setChargeReqCfmMthd(String.valueOf(ecr07.getBd().getCwy()));
				cSH.setChargeReqAmt(BigDecimal.valueOf(ecr07.getBd().getRamt()));
				cSH.setChargeReqKwh(BigDecimal.valueOf(ecr07.getBd().getRwh()));
				cSH.setPayMthd(String.valueOf(ecr07.getBd().getPwy()));
				cSH.setBattStat(String.valueOf(ecr07.getBd().getBsts()));
				cSH.setBattCapa(BigDecimal.valueOf(ecr07.getBd().getBcapa()));
				cSH.setBattRmnkwh(BigDecimal.valueOf(ecr07.getBd().getBwh()));
				cSH.setBattVolt(ecr07.getBd().getBvolt());
				cSH.setEndFocastDay(endDate);
				cSH.setEndFocastTime(endTime);
				cSH.setBmsSwVer(ecr07.getBd().getBms());
				cSH.setChargeStDatetime(dupdatetime);
				cSH.setChargeAccumTime(0);

				newOS = outletStatRepository.save(oS);
				newCS = chargingStatRepository.save(cS);
				newCSH = chargingStatHistRepository.save(cSH);
				checked = true;
			}

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
			} else if (newOS != null && newCS != null && newCSH != null && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS07가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS07가 실패했습니다.");
			}

			long ecrdt = commonUtil.getNowDate();
			erh07 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, ecr07.getHd().getTid());
			erb07 = new POS07();
			ecrp07 = new EvcomResPos07(erh07, erb07);
		} catch (Exception e) {
			EvcomReqPos07 ecr07 = null;
			int tid = 0;
			rcd = 999;
			rms = "실패";
			try {
				ecr07 = GenericUnmarshallFactory.getInstance(EvcomReqPos07.class, xmlBody);
				tid = ecr07.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			long ecrdt = commonUtil.getNowDate();
			erh07 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, tid);
			erb07 = new POS07();
			ecrp07 = new EvcomResPos07(erh07, erb07);
			log.info("POS07가 실패했습니다.");
			System.out.println(e);
		}
		return ecrp07;
	}

	@POST
	@Path("{sid}/chargers/{cid}/charging")
	public EvcomResPos08 pos08(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");
		EvcomResPos08 ecrp08 = null;
		EvcomResponseHead erh08 = null;
		POS08 erb08 = null;
		int rcd;
		String rms;
		try {
			EvcomReqPos08 ecr08 = GenericUnmarshallFactory.getInstance(EvcomReqPos08.class, xmlBody);

			OutletStatPK oSPk = new OutletStatPK();
			OutletStat oS = null;
			OutletStat newOS = null;
			ChargingStatPK cSPk = new ChargingStatPK();
			ChargingStat cS = null;
			ChargingStat newCS = null;
			ChargingStatHistPK cSHPk = new ChargingStatHistPK();
			ChargingStatHist cSH = new ChargingStatHist();
			ChargingStatHist newCSH = null;

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr08.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr08.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr08.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr08.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
				// 충전종료일계산
				String endDate = commonUtil.sumChrgingEndDate(ecr08.getBd().getRmnsec());
				// 충전종료시간계산
				String endTime = commonUtil.sumChrgingEndTime(ecr08.getBd().getRmnsec());

				// 장치 번호 가져옴
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				int outletNumber = 1;

				oSPk.setEqpNum(eqpNumber);
				oSPk.setOutletNum(outletNumber);

				oS = outletStatRepository.findOne(oSPk);
				if (oS == null) {
					oS = new OutletStat();
				}
				oS.setId(oSPk);
				oS.setOutletStat(ecr08.getHd().getSts());
				oS.setUpdateDay(String.valueOf(ecr08.getHd().getStm()).substring(0, 8));
				oS.setUpdateTime(String.valueOf(ecr08.getHd().getStm()).substring(8));

				// long --> date 타입으로 형변환
				Date dupdatetime = commonUtil.dateTime(ecr08.getHd().getStm());

				cSPk.setEqpNum(eqpNumber);
				cSPk.setOutletNum(outletNumber);
				cS = chargingStatRepository.findOne(cSPk);
				if (cS == null) {
					cS = new ChargingStat();
				}
				// 업데이트 하기 위해 값 세팅
				cS.setId(cSPk);
				cS.setPlugDay(String.valueOf(ecr08.getBd().getPdt()));
				cS.setPlugTime(commonUtil.timeChack(ecr08.getBd().getPtm()));
				cS.setCurrentKwh(BigDecimal.valueOf(ecr08.getBd().getCwh()));
				cS.setCurrentAmt(BigDecimal.valueOf(ecr08.getBd().getCamt()));
				cS.setBattStat(String.valueOf(ecr08.getBd().getBsts()));
				cS.setBattVolt(ecr08.getBd().getBvolt());
				cS.setBattCurr(ecr08.getBd().getBamp());
				cS.setBattTmp(BigDecimal.valueOf(ecr08.getBd().getBtemp()));
				cS.setEndFocastDay(endDate);
				cS.setEndFocastTime(endTime);
				cS.setStatUpdateDatetime(dupdatetime);
				BigDecimal rate = null;
				if (cS.getBattCapa() != null) {
					rate = commonUtil.chargingRate(ecr08.getBd().getBwh(), cS.getBattCapa());
				}
				cS.setWrkExeRate(rate); // 작업진행률
				long diff = 0;
				if (cS.getChargeStDatetime() != null) {
					String supdatetime = String.valueOf(ecr08.getHd().getStm());
					String y = supdatetime.substring(0, 4);
					String m = supdatetime.substring(4, 6);
					String d = supdatetime.substring(6, 8);
					String h = supdatetime.substring(8, 10);
					String mi = supdatetime.substring(10, 12);
					String s = supdatetime.substring(12, 14);
					String supdatetime2 = y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s;
					Date ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(supdatetime2);
					diff = ss.getTime() - cS.getChargeStDatetime().getTime();
				}
				cS.setChargeAccumTime(Integer.parseInt(String.valueOf(diff)));

				cSHPk.setEqpNum(eqpNumber);
				cSHPk.setOutletNum(outletNumber);

				cSHPk.setStatUpdateDatetime(dupdatetime);
				cSHPk.setEqpNum(eqpNumber);
				cSHPk.setOutletNum(outletNumber);

				cSH.setId(cSHPk);
				cSH.setPlugDay(String.valueOf(ecr08.getBd().getPdt()));
				cSH.setPlugTime(commonUtil.timeChack(ecr08.getBd().getPtm()));
				cSH.setCurrentKwh(BigDecimal.valueOf(ecr08.getBd().getCwh()));
				cSH.setCurrentAmt(BigDecimal.valueOf(ecr08.getBd().getCamt()));
				cSH.setBattStat(String.valueOf(ecr08.getBd().getBsts()));
				cSH.setBattVolt(ecr08.getBd().getBvolt());
				cSH.setBattCurr(ecr08.getBd().getBamp());
				cSH.setBattTmp(BigDecimal.valueOf(ecr08.getBd().getBtemp()));
				cSH.setEndFocastDay(endDate);
				cSH.setEndFocastTime(endTime);
				cSH.setWrkExeRate(rate);
				cSH.setChargeAccumTime(Integer.parseInt(String.valueOf(diff)));

				newOS = outletStatRepository.save(oS);
				newCS = chargingStatRepository.save(cS);
				newCSH = chargingStatHistRepository.save(cSH);
				checked = true;
			}

			long ecrdt = commonUtil.getNowDate();

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
			} else if (newOS != null && newCS != null && newCSH != null && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS08가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS08가 실패했습니다.");
			}

			erh08 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, ecr08.getHd().getTid());
			erb08 = new POS08();
			ecrp08 = new EvcomResPos08(erh08, erb08);
		} catch (Exception e) {
			long ecrdt = commonUtil.getNowDate();
			rcd = 999;
			rms = "실패";
			EvcomReqPos08 ecr08;
			int tid = 0;
			try {
				ecr08 = GenericUnmarshallFactory.getInstance(EvcomReqPos08.class, xmlBody);
				tid = ecr08.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			erh08 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, tid);
			erb08 = new POS08();
			ecrp08 = new EvcomResPos08(erh08, erb08);
			log.info("POS08가 실패했습니다.");
			System.out.println(e);
		}
		return ecrp08;
	}

	@POST
	@Path("{sid}/chargers/{cid}/stop")
	public EvcomResPos09 pos09(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");
		EvcomResPos09 ecrp09 = null;
		EvcomResponseHead erh09 = null;
		POS09 erb09 = null;
		int rcd;
		String rms;
		try {
			EvcomReqPos09 ecr09 = GenericUnmarshallFactory.getInstance(EvcomReqPos09.class, xmlBody);

			OutletStatPK oSPk = new OutletStatPK();
			OutletStat oS = null;
			OutletStat newOS = null;
			ChargingStatPK cSPk = new ChargingStatPK();
			ChargingStat cS = null;
			ChargingStat newCS = null;
			ChargingStatHistPK cSHPk = new ChargingStatHistPK();
			ChargingStatHist cSH = new ChargingStatHist();
			ChargingStatHist newCSH = null;
			ChargingEndInfoPK cEIPk = new ChargingEndInfoPK();
			ChargingEndInfo cEI = null;
			ChargingEndInfo newCEI = null;
			ChargingEndHistPK cEHPk = new ChargingEndHistPK();
			ChargingEndHist cEH = null;
			ChargingEndHist newCEH = null;
			ChargingPayHistPK cPHPk = new ChargingPayHistPK();
			ChargingPayHist cPH = null;
			ChargingPayHist newCPH = null;

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr09.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr09.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr09.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr09.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;

			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
				// 장치 번호 가져옴
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				int outletNumber = 1;

				oSPk.setEqpNum(eqpNumber);
				oSPk.setOutletNum(outletNumber);

				oS = outletStatRepository.findOne(oSPk);
				if (oS == null) {
					oS = new OutletStat();
				}
				oS.setId(oSPk);
				oS.setOutletStat(ecr09.getHd().getSts());
				oS.setUpdateDay(String.valueOf(ecr09.getHd().getStm()).substring(0, 8));
				oS.setUpdateTime(String.valueOf(ecr09.getHd().getStm()).substring(8));

				cSPk.setEqpNum(eqpNumber);
				cSPk.setOutletNum(outletNumber);

				// long --> date 타입으로 형변환
				Date dupdatetime = commonUtil.dateTime(ecr09.getHd().getStm());

				cS = chargingStatRepository.findOne(cSPk);
				// cS 널값 체크해서 확인하기
				if (cS == null) {
					cS = new ChargingStat();
				}
				// 업데이트 하기 위해 값 세팅
				cS.setId(cSPk);
				cS.setPlugDay(String.valueOf(ecr09.getBd().getPdt()));
				cS.setPlugTime(commonUtil.timeChack(ecr09.getBd().getPtm()));
				cS.setCurrentKwh(BigDecimal.valueOf(ecr09.getBd().getCwh()));
				cS.setCurrentUcost(BigDecimal.valueOf(ecr09.getBd().getPrc()));
				cS.setCurrentAmt(BigDecimal.valueOf(ecr09.getBd().getCamt()));
				ecr09.getBd().getPrst(); // 결제결과 해당하는 컬럼없음
				ecr09.getBd().getBwh(); // 배터리 현재 충전량(잔량) 해당하는 컬럼없음
				cS.setChargeAccumTime(ecr09.getBd().getElpsec());
				ecr09.getBd().getEst(); // 충전종료구분 해당한는 컬럼없음
				cS.setStatUpdateDatetime(dupdatetime);
				BigDecimal rate = null;
				if (cS.getBattCapa() != null) {
					rate = commonUtil.chargingRate(ecr09.getBd().getBwh(), cS.getBattCapa());
					cS.setWrkExeRate(rate);
				}

				cSHPk.setStatUpdateDatetime(dupdatetime);
				cSHPk.setEqpNum(eqpNumber);
				cSHPk.setOutletNum(outletNumber);

				cSH.setId(cSHPk);
				cSH.setPlugDay(String.valueOf(ecr09.getBd().getPdt()));
				cSH.setPlugTime(commonUtil.timeChack(ecr09.getBd().getPtm()));
				cSH.setCurrentKwh(BigDecimal.valueOf(ecr09.getBd().getCwh()));
				cSH.setCurrentUcost(BigDecimal.valueOf(ecr09.getBd().getPrc()));
				cSH.setCurrentAmt(BigDecimal.valueOf(ecr09.getBd().getCamt()));
				ecr09.getBd().getPrst(); // 결제결과 해당하는 컬럼없음
				ecr09.getBd().getBwh(); // 배터리 현재 충전량(잔량) 해당하는 컬럼없음
				cSH.setChargeAccumTime(ecr09.getBd().getElpsec());
				ecr09.getBd().getEst(); // 충전종료구분 해당한는 컬럼없음
				if (cS.getBattCapa() != null)
					cS.setWrkExeRate(rate);

				cEIPk.setEqpNum(eqpNumber);
				cEIPk.setOutletNum(outletNumber);

				String dt = null;
				String stDate = "00000000";
				String stTime = "000000";
				if (cS.getChargeStDatetime() != null) {
					dt = String.valueOf(cS.getChargeStDatetime());
					stDate = dt.substring(0, 4) + dt.substring(5, 7) + dt.substring(8, 10);
					stTime = dt.substring(11, 13) + dt.substring(14, 16) + dt.substring(17, 19);
				}
				cEI = chargingEndInfoRepository.findOne(cEIPk);
				if (cEI == null) {
					cEI = new ChargingEndInfo();
				}
				cEI.setId(cEIPk);
				if (cS.getChargeStDatetime() != null) {
					cEI.setStDay(stDate);
					cEI.setStTime(stTime);
				}
				cEI.setPlugDay(String.valueOf(ecr09.getBd().getPdt()));
				cEI.setPlugTime(commonUtil.timeChack(ecr09.getBd().getPtm()));
				cEI.setChargeKwh(BigDecimal.valueOf(ecr09.getBd().getCwh()));
				cEI.setAplyUcost(ecr09.getBd().getPrc());
				ecr09.getBd().getCamt(); // 충전금액 해당하는 컬럼없음
				cEI.setPayStat(String.valueOf(ecr09.getBd().getPrst()));
				ecr09.getBd().getBwh(); // 배터리 현재 충전량(잔량) 해당하는 컬럼없음
				cEI.setChargeTime(ecr09.getBd().getElpsec());
				cEI.setChargeEndStat(String.valueOf(ecr09.getBd().getEst()));
				cEI.setEndDay(String.valueOf(ecr09.getHd().getStm()).substring(0, 8));
				cEI.setEndTime(String.valueOf(ecr09.getHd().getStm()).substring(8));

				cEHPk.setEqpNum(eqpNumber);
				cEHPk.setOutletNum(outletNumber);
				cEHPk.setStDay(stDate);
				cEHPk.setStTime(stTime);

				cEH = chargingEndHistRepository.findOne(cEHPk);
				if (cEH == null) {
					cEH = new ChargingEndHist();
				}
				cEH.setId(cEHPk);
				cEH.setPlugDay(String.valueOf(ecr09.getBd().getPdt()));
				cEH.setPlugTime(commonUtil.timeChack(ecr09.getBd().getPtm()));
				cEH.setChargekwh(BigDecimal.valueOf(ecr09.getBd().getCwh()));
				cEH.setAplyUcost(BigDecimal.valueOf(ecr09.getBd().getPrc()));
				ecr09.getBd().getCamt(); // 충전금액 해당하는 컬럼없음
				cEH.setPayStat(String.valueOf(ecr09.getBd().getPrst()));
				ecr09.getBd().getBwh(); // 배터리 현재 충전량(잔량) 해당하는 컬럼없음
				cEH.setChargeTime(ecr09.getBd().getElpsec());
				cEH.setChargeEndStat(String.valueOf(ecr09.getBd().getEst()));
				cEH.setEndDay(String.valueOf(ecr09.getHd().getStm()).substring(0, 8));
				cEH.setEndTime(String.valueOf(ecr09.getHd().getStm()).substring(8));
				cEH.setUpdateDatetime(dupdatetime);
				if (ecr09.getBd().getPrst() == 2) {
					cEH.setPayDay(String.valueOf(ecr09.getHd().getStm()).substring(0, 8));
					cEH.setPayTime(String.valueOf(ecr09.getHd().getStm()).substring(8));
				}

				cPHPk.setEqpNum(eqpNumber);
				cPHPk.setOutletNum(outletNumber);
				cPHPk.setPayDay(String.valueOf(ecr09.getHd().getStm()).substring(0, 8));
				cPHPk.setPayTime(String.valueOf(ecr09.getHd().getStm()).substring(8));

				cPH = chargingPayHistRepository.findOne(cPHPk);
				if (cPH == null) {
					cPH = new ChargingPayHist();
				}
				cPH.setId(cPHPk);
				cPH.setChargeBill(BigDecimal.valueOf(ecr09.getBd().getPrc()));
				cPH.setAprvBill(BigDecimal.valueOf(ecr09.getBd().getCamt()));
				cPH.setPayStat(String.valueOf(ecr09.getBd().getPrst()));

				newOS = outletStatRepository.save(oS);
				newCS = chargingStatRepository.save(cS);
				newCSH = chargingStatHistRepository.save(cSH);
				newCEI = chargingEndInfoRepository.save(cEI);
				newCEH = chargingEndHistRepository.save(cEH);
				newCPH = chargingPayHistRepository.save(cPH);
				checked = true;
			}

			long ecrdt = commonUtil.getNowDate();

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
			} else if (newOS != null && newCS != null && newCSH != null && newCEI != null && newCEH != null
					&& newCPH != null && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS09가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS09가 실패했습니다.");
			}
			erh09 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, ecr09.getHd().getTid());
			erb09 = new POS09();
			ecrp09 = new EvcomResPos09(erh09, erb09);
		} catch (Exception e) {
			rcd = 999;
			rms = "실패";
			long ecrdt = commonUtil.getNowDate();
			int tid = 0;
			EvcomReqPos09 ecr09 = null;

			try {
				ecr09 = GenericUnmarshallFactory.getInstance(EvcomReqPos09.class, xmlBody);
				tid = ecr09.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}

			erh09 = new EvcomResponseHead(ecrdt, sid, cid, rcd, rms, tid);
			erb09 = new POS09();
			ecrp09 = new EvcomResPos09(erh09, erb09);
			log.info("POS09가 실패했습니다.");
			System.out.println(e);
		}
		return ecrp09;
	}

	@POST
	@Path("{sid}/chargers/{cid}/unplug")
	public EvcomResPos10 pos10(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResPos10 unPlug = null;
		int rcd;
		String rms;

		try {
			EvcomReqPos10 ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos10.class, xmlBody);
			log.info(ecr.getHd());
			log.info(ecr.getHd().getCid());
			log.info(ecr.getHd().getStm());
			log.info(ecr.getHd().getSts());
			log.info(ecr.getHd().getTid());
			log.info(ecr.getBd());
			log.info(ecr.getBd().getUwh());
			log.info(ecr.getBd().getPdt());
			log.info(ecr.getBd().getPtm());

			// 아웃넷상태 객체 선언
			OutletStat os = new OutletStat();
			// 아웃넷상태 PK 선언
			OutletStatPK osPk = new OutletStatPK();
			// 아웃넷 상태 DB update
			OutletStat newOs = null;
			// 충전 완료 정보 table선언
			ChargingEndInfoPK ceiPk = new ChargingEndInfoPK();
			ChargingEndInfo cei = null;
			// 충전기 완료 정보 Table DB 저장
			ChargingEndInfo saveCei = null;
			// 충전기 완료 이력 table 선언
			ChargingEndHistPK cehPk = new ChargingEndHistPK();
			ChargingEndHist ceh = null;

			QEquipInfo qeif = QEquipInfo.equipInfo;
			QChargingStat qcs = QChargingStat.chargingStat;
			QChargingEndInfo qci = QChargingEndInfo.chargingEndInfo;

			// 충전 완료 이력 DB 저장
			ChargingEndHist saveCeh = null;

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {

				// 장비 넘버를 찾는다.
				EquipInfo eif = equipInfoRepository.findOne(qeif.csInfo.csId.eq(String.valueOf(sid))
						.and(qeif.eqpId.eq(cid)).and(qeif.protocolInfo.protocolType.eq(2)));
				// 아웃넷 번호를 찾는다.
				int oi = 1;

				// 아웃넷상태 PK 값 setting
				osPk.setEqpNum(eif.getEqpNum());
				osPk.setOutletNum(oi);

				// 아웃넷 상태 setting
				os.setId(osPk);
				os.setOutletStat(ecr.getHd().getSts());
				os.setUpdateDay(String.valueOf(ecr.getHd().getStm()).substring(0, 8));
				os.setUpdateTime(String.valueOf(ecr.getHd().getStm()).substring(8, 14));

				// 충전 상태 불러 오기
				ChargingStat scs = chargingStatRepository
						.findOne(qcs.id.eqpNum.eq(eif.getEqpNum()).and(qcs.id.outletNum.eq(oi)));

				// 충전 완료 정보 PK값 세팅
				ceiPk.setEqpNum(eif.getEqpNum());
				ceiPk.setOutletNum(oi);

				// 선언 하지 않는 기본값 가져 오기
				cei = chargingEndInfoRepository.findOne(ceiPk);
				if (cei == null) {
					cei = new ChargingEndInfo();
				}
				// 충전 완료 정보 Data 세팅
				cei.setId(ceiPk);
				cei.setUnplugDay(String.valueOf(ecr.getBd().getPdt()));
				cei.setUnplugTime(commonUtil.timeChack(ecr.getBd().getPtm()));
				cei.setUnplugIkwh(ecr.getBd().getUwh());

				// 충전 완료 정보 불러 오기
				ChargingEndInfo scei = chargingEndInfoRepository
						.findOne(qci.id.eqpNum.eq(eif.getEqpNum()).and(qci.id.outletNum.eq(oi)));

				// 충전 완료 이력 PK값 선언.
				cehPk.setEqpNum(eif.getEqpNum());
				cehPk.setOutletNum(oi);
				cehPk.setStDay(cei.getStDay());
				cehPk.setStTime(cei.getStTime());

				// 선언 하지 않는 기본값 가져 오기
				ceh = chargingEndHistRepository.findOne(cehPk);
				if (ceh == null) {
					ceh = new ChargingEndHist();
				}

				// 충전 완료 이력 data 세팅
				ceh.setId(cehPk);
				ceh.setEndDay(cei.getEndDay());
				ceh.setEndTime(cei.getEndTime());
				ceh.setUnplugDay(String.valueOf(ecr.getBd().getPdt()));
				ceh.setUnplugTime(commonUtil.timeChack(ecr.getBd().getPtm()));
				ceh.setUnplugIkwh(ecr.getBd().getUwh());

				saveCei = chargingEndInfoRepository.save(cei);
				newOs = outletStatRepository.save(os);
				saveCeh = chargingEndHistRepository.save(ceh);
				chargingEndInfoRepository.delete(scei); // 충전기 완료 정보 데이터 지우기
				checked = true;

				// 충전기 상태 데이터 지우기
				chargingStatRepository.delete(scs);
			}

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
			} else if (saveCei != null && saveCeh != null && newOs != null && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS11가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS11가 실패했습니다.");
			}
			// date 포멧 변경
			long ecrdt = commonUtil.getNowDate();

			//
			unPlug = new EvcomResPos10(new EvcomResponseHead(ecrdt, ecr.getHd().getSid(), ecr.getHd().getCid(), rcd,
					rms, ecr.getHd().getTid()), new POS10());

		} catch (Exception e) {
			long ecrdt = commonUtil.getNowDate();
			rcd = 999;
			rms = "실패";
			EvcomReqPos10 ecr = null;
			int tid = 0;
			try {
				ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos10.class, xmlBody);
				tid = ecr.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			unPlug = new EvcomResPos10(
					new EvcomResponseHead(ecrdt, ecr.getHd().getSid(), ecr.getHd().getCid(), rcd, rms, tid),
					new POS10());
			log.info("POS11가 실패했습니다.");
			System.out.println(e);
		}

		return unPlug;
	}

	@POST
	@Path("{sid}/chargers/{cid}/config")
	public EvcomResPos11 pos11(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResponseHead erh = null;
		POS11 erb = null;
		EvcomResPos11 ec = null;
		int rcd;
		String rms;

		try {

			EvcomReqPos11 ecr11 = GenericUnmarshallFactory.getInstance(EvcomReqPos11.class, xmlBody);

			log.info(ecr11.getHd());
			log.info(ecr11.getHd().getCid());
			log.info(ecr11.getHd().getStm());
			log.info(ecr11.getHd().getSts());
			log.info(ecr11.getHd().getTid());
			log.info(ecr11.getBd());
			log.info(ecr11.getBd().getPmr());// 충전기 제조사코드
			log.info(ecr11.getBd().getPmd());// 충전기모델코드
			log.info(ecr11.getBd().getCtp());// 충전기타입
			log.info(ecr11.getBd().getCot());// 네트웨크 연결방식
			log.info(ecr11.getBd().getMdn());// 모뎀번호
			log.info(ecr11.getBd().getEip());// Evcis IP
			log.info(ecr11.getBd().getEpt());// Evcis Port
			log.info(ecr11.getBd().getVip());// Van IP
			log.info(ecr11.getBd().getVpt());// Van Port
			log.info(ecr11.getBd().getMmr());// m2m단말기 제조사 코드
			log.info(ecr11.getBd().getRmr());// RF 단말기 제조사 코드
			log.info(ecr11.getBd().getStrm());// 충전기 상태 전송주기(sec)
			log.info(ecr11.getBd().getRtrm());// 원격명령 조회 주기(sec)
			log.info(ecr11.getBd().getCtrm());// 충전중 상태 전송 주기(sec)
			log.info(ecr11.getBd().getVtrm());// 저장 자료 전송주기(sec)

			// validation check
			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr11.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr11.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr11.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr11.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {

				// 장치 번호 가져옴
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				log.info("-----장치번호---->" + eqpNumber);
				// 충전기 운영 파라미터 설정 세팅
				EquipInfo epInfo = new EquipInfo();

				QCsInfo qcsInfo = QCsInfo.csInfo;
				QProtocolInfo qptInfo = QProtocolInfo.protocolInfo;

				CsInfo csInfo = null;
				ProtocolInfo protocolInfo = null;

				csInfo = csInfoRepository.findOne(qcsInfo.csId.eq(String.valueOf(sid)));
				if (csInfo == null) {
					csInfo = new CsInfo();
				}

				protocolInfo = protocolInfoRepository.findOne(qptInfo.protocolType.eq(2));

				if (protocolInfo == null) {
					protocolInfo = new ProtocolInfo();
				}

				epInfo.setEqpNum(eqpNumber);
				epInfo.setCsInfo(csInfo);
				epInfo.setEqpId(cid);
				epInfo.setEqpType(ecr11.getBd().getCtp());
				epInfo.setProtocolInfo(protocolInfo);

				// JsonObject -> {"pmr": "1", "pmd": "2", .....};
				JsonObject object = Json.object().add("pmr", ecr11.getBd().getPmr()).add("pmd", ecr11.getBd().getPmd())
						.add("ctp", ecr11.getBd().getCtp()).add("cot", ecr11.getBd().getCot())
						.add("mdn", ecr11.getBd().getMdn()).add("eip", ecr11.getBd().getEip())
						.add("ept", ecr11.getBd().getEpt()).add("vip", ecr11.getBd().getVip())
						.add("vpt", ecr11.getBd().getVpt()).add("mmr", ecr11.getBd().getMmr())
						.add("rmr", ecr11.getBd().getRmr()).add("strm", ecr11.getBd().getStrm())
						.add("rtrm", ecr11.getBd().getRtrm()).add("ctrm", ecr11.getBd().getCtrm())
						.add("vtrm", ecr11.getBd().getVtrm());
				epInfo.setOpData(object.toString().getBytes());
				// 운영파라미터 전송 데이타 저장
				equipInfoRepository.save(epInfo);
				checked = true;
			}

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
			} else if (checked) {
				rcd = 1;
				rms = "전송성공";
			} else {
				rcd = 999;
				rms = "요청(전송)처리실패";
			}
			// validation check

			long rdatetime = commonUtil.getNowDate();
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr11.getHd().getTid());
			erb = new POS11();
			ec = new EvcomResPos11(erh, erb);

		} catch (Exception e) {
			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos11 ecr11 = null;
			int tid = 0;

			try {

				ecr11 = GenericUnmarshallFactory.getInstance(EvcomReqPos11.class, xmlBody);
				tid = ecr11.getHd().getTid();

			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {

				e1.printStackTrace();
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}

			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, tid);
			erb = new POS11();
			ec = new EvcomResPos11(erh, erb);
			System.out.println(e);
		}
		return ec;
	}

	@POST
	@Path("{sid}/chargers/{cid}/boot")
	public EvcomResPos12 pos12(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResponseHead erh = null;
		POS12 erb = null;
		EvcomResPos12 ec = null;
		int rcd;
		String rms;
		try {
			EvcomReqPos12 ecr12 = GenericUnmarshallFactory.getInstance(EvcomReqPos12.class, xmlBody);

			QEquipInfo qeif = QEquipInfo.equipInfo;
			OutletStatPK oSPk = new OutletStatPK();
			OutletStat saveOS = null;
			OutletStat oS = null;

			long rdatetime = commonUtil.getNowDate();

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr12.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr12.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr12.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr12.getHd().getSts())) {
				stsChecked = true;
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked) {
				EquipInfo eif = equipInfoRepository.findOne(qeif.csInfo.csId.eq(String.valueOf(sid))
						.and(qeif.eqpId.eq(cid)).and(qeif.protocolInfo.protocolType.eq(2)));
				int outletNumber = 1;
				oSPk.setEqpNum(eif.getEqpNum());
				oSPk.setOutletNum(outletNumber);

				oS = outletStatRepository.findOne(oSPk);
				if (oS == null) {
					oS = new OutletStat();
				}
				oS.setId(oSPk);
				oS.setOutletStat(ecr12.getHd().getSts());
				oS.setEqpTp(eif.getEqpType());
				oS.setUpdateDay(String.valueOf(ecr12.getHd().getStm()).substring(0, 8));
				oS.setUpdateTime(String.valueOf(ecr12.getHd().getStm()).substring(8));

				saveOS = outletStatRepository.save(oS);
				checked = true;
			}

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
			} else if (saveOS != null && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS12가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS12가 실패했습니다.");
			}

			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr12.getHd().getTid());
			erb = new POS12();
			ec = new EvcomResPos12(erh, erb);
		} catch (Exception e) {
			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "실패";
			EvcomReqPos12 ecr12 = null;
			int tid = 0;
			try {
				ecr12 = GenericUnmarshallFactory.getInstance(EvcomReqPos12.class, xmlBody);
				tid = ecr12.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, tid);
			erb = new POS12();
			ec = new EvcomResPos12(erh, erb);
			log.info("POS12가 실패했습니다.");
			System.out.println(e);
		}
		return ec;
	}

	@POST
	@Path("{sid}/chargers/{cid}/prices_ver")
	public EvcomResPos13 pos13(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResPos13 pricesVer = null;
		int rcd;
		String rms;
		try {

			EvcomReqPos13 ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos13.class, xmlBody);
			QUcostInfo qui = QUcostInfo.ucostInfo;
			Iterable<UcostInfo> ui = null;

			// 해당하는 단가버전 탐색
			ui = ucostInfoRepository.findAll(qui.id.eqpType.eq(String.valueOf(ecr.getBd().getCtp()))
					.and(qui.id.ucostNum.eq(ecr.getBd().getVer())).and(qui.id.protocolType.eq(2)));

			// 적용시간 길이 측정
			Stream<UcostInfo> s = StreamSupport.stream(ui.spliterator(), false);
			List<Integer> ucosts = s.map(c -> c.getId().getHh24()).collect(Collectors.toList());

			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
				checked = true;
			}

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
			} else if (ucosts.size() == 24 && checked) {
				rcd = 1;
				rms = "성공";
				log.info("POS13가 정상처리 되었습니다.");
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS13가 실패했습니다.");
			}
			long ecrdt = commonUtil.getNowDate();
			pricesVer = new EvcomResPos13(new EvcomResponseHead(ecrdt, ecr.getHd().getSid(), ecr.getHd().getCid(), rcd,
					rms, ecr.getHd().getTid()), new POS13());
		} catch (Exception e) {
			long ecrdt = commonUtil.getNowDate();
			rcd = 999;
			rms = "실패";
			int tid = 0;
			EvcomReqPos13 ecr = null;
			try {
				ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos13.class, xmlBody);
				tid = ecr.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			pricesVer = new EvcomResPos13(
					new EvcomResponseHead(ecrdt, ecr.getHd().getSid(), ecr.getHd().getCid(), rcd, rms, tid),
					new POS13());
			log.info("POS13가 실패했습니다.");
			System.out.println(e);
		}
		return pricesVer;
	}

	@POST
	@Path("{sid}/chargers/{cid}/{chager_prod}")
	public EvcomResPos14 pos14(@PathParam("sid") int sid, @PathParam("cid") String cid,
			@PathParam("chager_prod") String chager_prod, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResPos14 ec = null;
		EvcomResponseHead erh = null;
		POS14 erb = null;
		int rcd;
		String rms;
		long rdatetime = commonUtil.getNowDate();

		try {

			EvcomReqPos14 ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos14.class, xmlBody);

			log.info(ecr.getHd());
			log.info(ecr.getHd().getCid());
			log.info(ecr.getHd().getSid());
			log.info(ecr.getHd().getStm());
			log.info(ecr.getHd().getSts());
			log.info(ecr.getHd().getTid());
			log.info(ecr.getBd());

			ecr.getBd().getPgs().forEach(c -> {
				log.info(c.getPg_knd().getPg_knd());
				log.info(c.getVer().getVer());
			});

			// 시간 체크
			boolean timeChecked = true;
//			 if (commonUtil.checkTime(ecr.getHd().getStm())) {
//			 timeChecked = true;
//			 }
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr.getHd().getSts())) {
				stsChecked = true;
			}
			boolean checked = false;
			boolean cpiChecked = true;

			if (timeChecked && sidChecked && cidChecked && stsChecked) {

				QEquipInfo qeif = QEquipInfo.equipInfo;
				// 장비 넘버를 찾는다.
				EquipInfo eif = equipInfoRepository.findOne(qeif.csInfo.csId.eq(String.valueOf(sid))
						.and(qeif.eqpId.eq(cid)).and(qeif.protocolInfo.protocolType.eq(2))
						.and(qeif.cpCompanyInfo.maker.eq(chager_prod)));

				QCpProgramInfo qcpi = QCpProgramInfo.cpProgramInfo;

				Stream<PG> s = StreamSupport.stream(ecr.getBd().getPgs().spliterator(), false);
				Stream<PG> t = StreamSupport.stream(ecr.getBd().getPgs().spliterator(), false);
				List<PG_KND> pgknd = s.map(c -> c.getPg_knd()).collect(Collectors.toList());
				List<com.kdn.ecsi.epengine.domain.oxm.fields.VER> ver = t.map(c -> c.getVer())
						.collect(Collectors.toList());

				for (int i = 0; i < pgknd.size(); i++) {
					for (int j = 0; j < ver.size(); j++) {
						if (i == j) {
							CpProgramInfo cpi = null;
							cpi = cpProgramInfoRepository.findOne(qcpi.cpCompanyInfo.maker.eq(chager_prod)
									.and(qcpi.cpCompanyInfo.maker.eq(eif.getCpCompanyInfo().getMaker()))
									.and(qcpi.programName.eq(pgknd.get(i).getPg_knd())).and(qcpi.programVer.eq(ver.get(j).getVer())));
							if (cpi == null) {
								cpiChecked = false;
								break;
							}
						}
					}
					if (!cpiChecked){
						break;
					}
				}
				checked = true;
			}

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
			} else if (cpiChecked&&checked) {
				rcd = 1;
				rms = "성공";
			} else {
				rcd = 999;
				rms = "실패";
				log.info("POS14가 실패했습니다.");
			}

			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr.getHd().getTid());
			erb = new POS14();
			ec = new EvcomResPos14(erh, erb);
		} catch (Exception e) {
			long ecrdt = commonUtil.getNowDate();
			rcd = 999;
			rms = "실패";
			int tid = 0;
			EvcomReqPos14 ecr = null;
			try {
				ecr = GenericUnmarshallFactory.getInstance(EvcomReqPos14.class, xmlBody);
				tid = ecr.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			ec = new EvcomResPos14(
					new EvcomResponseHead(ecrdt, ecr.getHd().getSid(), ecr.getHd().getCid(), rcd, rms, tid),
					new POS14());
			log.info("POS14가 실패했습니다.");
			System.out.println(e);
		}
		return ec;
	}

	@POST
	@Path("{sid}/chargers/{cid}/chrghis")
	public EvcomResPos15 pos15(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResponseHead erh = null;
		POS15 erb = null;
		EvcomResPos15 ec = null;
		int rcd;
		String rms;

		try {

			EvcomReqPos15 ecr15 = GenericUnmarshallFactory.getInstance(EvcomReqPos15.class, xmlBody);

			log.info(ecr15.getHd());
			log.info(ecr15.getHd().getCid());
			log.info(ecr15.getHd().getSid());
			log.info(ecr15.getHd().getStm());
			log.info(ecr15.getHd().getSts());
			log.info(ecr15.getHd().getTid());
			log.info(ecr15.getBd());
			log.info(ecr15.getBd().getLoc());
			log.info(ecr15.getBd().getAth());
			log.info(ecr15.getBd().getUsr());
			log.info(ecr15.getBd().getPdt());
			log.info(ecr15.getBd().getPtm());
			log.info(ecr15.getBd().getPiwh());
			log.info(ecr15.getBd().getCwy());
			log.info(ecr15.getBd().getRamt());
			log.info(ecr15.getBd().getRwh());
			log.info(ecr15.getBd().getSdt());
			log.info(ecr15.getBd().getStm());
			log.info(ecr15.getBd().getPwy());
			log.info(ecr15.getBd().getCwh());
			log.info(ecr15.getBd().getPwy());
			log.info(ecr15.getBd().getCwh());
			log.info(ecr15.getBd().getPrc());
			log.info(ecr15.getBd().getCamt());
			log.info(ecr15.getBd().getPrst());
			log.info(ecr15.getBd().getEdt());
			log.info(ecr15.getBd().getEtm());
			log.info(ecr15.getBd().getElpsec());
			log.info(ecr15.getBd().getRst());
			log.info(ecr15.getBd().getUiwh());

			log.info("-----sid(충전소ID)---->" + ecr15.getHd().getSid());
			log.info("-----cid(충전기ID)---->" + ecr15.getHd().getCid());

			long rdatetime = commonUtil.getNowDate();
			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr15.getHd().getStm())) {
				timeChecked = true;
			}
			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr15.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr15.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr15.getHd().getSts())) {
				stsChecked = true;
			}

			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {

				// 장치 번호 가져옴
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				log.info("-----장치번호---->" + eqpNumber);

				ChargingEndHistPK cePk = new ChargingEndHistPK();
				cePk.setEqpNum(eqpNumber);
				cePk.setStDay(String.valueOf(ecr15.getBd().getSdt())); // 충전시작일자
				cePk.setStTime(String.valueOf(ecr15.getBd().getStm())); // 충전시작일시
				cePk.setOutletNum(1);
				log.info("-----충전시작일자---->" + String.valueOf(ecr15.getBd().getSdt()));
				log.info("-----충전시작일시---->" + String.valueOf(ecr15.getBd().getStm()));
				// 경보 발생 이력 데이터 값 세팅
				ChargingEndHist ceh = new ChargingEndHist();
				ceh.setId(cePk);
				log.info("-----충전종료 이력1---->");
				ceh.setAuthLoc(ecr15.getBd().getLoc()); // 인증위치
				ceh.setAuthCl(ecr15.getBd().getAth()); // 인증구분
				ceh.setMemberCardNo(ecr15.getBd().getUsr()); // 회원번호 or 카드번호
				ceh.setPlugDay(String.valueOf(ecr15.getBd().getPdt())); // 플러그날짜
				ceh.setPlugTime(String.valueOf(ecr15.getBd().getPtm())); // 플러그시간
				ceh.setPlugIkwh(ecr15.getBd().getPiwh()); // 플러그시점 적산 전력량
				ceh.setChargeReqCfmMthd(String.valueOf(ecr15.getBd().getCwy())); // 충전요구방식-
				ceh.setChargeReqAmt(BigDecimal.valueOf(ecr15.getBd().getRamt())); // 충전요구금액-
				ceh.setChargeReqKwh(BigDecimal.valueOf(ecr15.getBd().getRwh())); // 충전요구전력량-
				ceh.setPayMthd(String.valueOf(ecr15.getBd().getPwy())); // 결제방식
				ceh.setChargekwh(BigDecimal.valueOf(ecr15.getBd().getCwh()));// 주입된
																				// 충전량(wh)
				ceh.setAplyUcost(BigDecimal.valueOf(ecr15.getBd().getPrc())); // 적용단가
				ceh.setTotChargeBill(BigDecimal.valueOf(ecr15.getBd().getCamt())); // 충전
																					// 청구금액(요금)--

				log.info("-----충전종료 이력2---->");
				ceh.setPayStat(String.valueOf(ecr15.getBd().getPrst())); // 결제결과(1:무료,
																			// 2:결제완료,
																			// 3:결제실패)
				ceh.setEndDay(String.valueOf(ecr15.getBd().getEdt())); // 충전 종료
																		// 날짜
				ceh.setEndTime(String.valueOf(ecr15.getBd().getEtm())); // 충전 종료
																		// 시간
				ceh.setChargeTime(ecr15.getBd().getElpsec()); // 충전시간(초)
				ceh.setChargeEndStat(String.valueOf(ecr15.getBd().getRst())); // 충전완료구분
				ceh.setUnplugIkwh(ecr15.getBd().getUiwh()); // 언플러그 시점 적산전력량값
				log.info("-----충전종료 이력3---->");
				// 경보해제 이력 데이타 저장
				chargingEndHistRepository.save(ceh);
				log.info("-----충전종료 이력4---->");
				checked = true;
			}
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
			} else if (checked) {
				rcd = 1;
				rms = "전송성공";
			} else {
				rcd = 999;
				rms = "요청(전송)처리실패";
			}

			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr15.getHd().getTid());
			erb = new POS15();
			ec = new EvcomResPos15(erh, erb);

		} catch (Exception e) {
			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos15 ecr15 = null;
			int tid = 0;
			try {
				ecr15 = GenericUnmarshallFactory.getInstance(EvcomReqPos15.class, xmlBody);
				tid = ecr15.getHd().getTid();
			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				e1.printStackTrace();
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, tid);
			erb = new POS15();
			ec = new EvcomResPos15(erh, erb);
			System.out.println(e);
		}
		return ec;
	}

	@POST
	@Path("{sid}/chargers/{cid}/almhis")
	public EvcomResPos16 pos16(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");
		EvcomResponseHead erh = null;
		POS16 erb = null;
		EvcomResPos16 ec = null;
		int rcd;
		String rms;
		int eqpNumber;

		try {

			EvcomReqPos16 ecr16 = GenericUnmarshallFactory.getInstance(EvcomReqPos16.class, xmlBody);
			log.info(ecr16.getHd());
			log.info(ecr16.getHd().getCid());
			log.info(ecr16.getHd().getSid());
			log.info(ecr16.getHd().getStm());
			log.info(ecr16.getHd().getSts());
			log.info(ecr16.getHd().getTid());
			log.info(ecr16.getBd());
			log.info(ecr16.getBd().getAcd());
			log.info(ecr16.getBd().getTdt());
			log.info(ecr16.getBd().getTtm());
			log.info(ecr16.getBd().getCdt());
			log.info(ecr16.getBd().getCtm());
			log.info(ecr16.getBd().getSts());
			log.info(ecr16.getBd().getLvl());

			log.info("-----STS---->" + ecr16.getBd().getSts());
			log.info("-----sid(충전소ID)---->" + ecr16.getHd().getSid());
			log.info("-----cid(충전기ID)---->" + ecr16.getHd().getCid());

			// 결보 발생 처리
			if (ecr16.getBd().getSts() == 1) {
				log.info("-----경보 저장 자료 전송(발생)---->" + ecr16.getBd().getSts());

				// validation check
				long rdatetime = commonUtil.getNowDate();
				// 시간 체크
				boolean timeChecked = false;
				if (commonUtil.checkTime(ecr16.getHd().getStm())) {
					timeChecked = true;
				}
				// 충전소 체크
				boolean sidChecked = false;
				if (commonUtil.ckeckSid(sid, ecr16.getHd().getSid(), csInfoRepository)) {
					sidChecked = true;
				}
				// 충전기 체크
				boolean cidChecked = false;
				if (commonUtil.ckeckCid(cid, ecr16.getHd().getCid(), equipInfoRepository)) {
					cidChecked = true;
				}
				// 충전기상태 체크
				boolean stsChecked = false;
				if (commonUtil.checkSts(ecr16.getHd().getSts())) {
					stsChecked = true;
				}
				boolean sidCidChecked = false;
				if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
					sidCidChecked = true;
				} else {
					if (cidChecked) {
						sidChecked = false;
					}
				}
				boolean checked = false;
				if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
					// 장치 번호 가져옴
					eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
					log.info("-----장치번호---->" + eqpNumber);

					// 경보발생 데이타 저장
					WarningHistPK whPk = new WarningHistPK();
					whPk.setEqpNum(eqpNumber);
					whPk.setOccrDay(String.valueOf(ecr16.getBd().getTdt())); // 발생일자
					whPk.setOccrTime(String.valueOf(ecr16.getBd().getTtm())); // 발생일시
					whPk.setOutletNum(1);
					whPk.setWarningCd(String.valueOf(ecr16.getHd().getTid()));// 경보코드
					log.info("-----경보 저장 자료 전송(발생)1---->" + ecr16.getBd().getSts());

					// 경보 발생 이력 데이터 값 세팅
					WarningHist wh = new WarningHist();
					wh.setId(whPk);
					wh.setWarningLevel(ecr16.getBd().getLvl()); // 경보레벨
					wh.setWarningStat(ecr16.getBd().getSts()); // 경보상태
					// 경보발생 이력 데이타 저장
					warningHistRepository.save(wh);
					checked = true;
				}

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
				} else if (checked) {
					rcd = 1;
					rms = "전송성공";
				} else {
					rcd = 999;
					rms = "요청(전송)처리실패";
				}
				// validation check
				log.info("-----경보 저장 자료 전송(발생)2---->" + ecr16.getBd().getSts());
				erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr16.getHd().getTid());
				erb = new POS16();
				ec = new EvcomResPos16(erh, erb);

				// 경보 발생 해제.
			} else {
				log.info("-----경보 저장 자료 전송(해제)---->" + ecr16.getBd().getSts());

				log.info("-----경보 저장 자료 전송(해제)2---->" + ecr16.getBd().getSts());

				// validation check
				// 시간 체크
				boolean timeChecked = false;
				if (commonUtil.checkTime(ecr16.getHd().getStm())) {
					timeChecked = true;
				}

				// 충전소 체크
				boolean sidChecked = false;
				if (commonUtil.ckeckSid(sid, ecr16.getHd().getSid(), csInfoRepository)) {
					sidChecked = true;
				}
				// 충전기 체크
				boolean cidChecked = false;
				if (commonUtil.ckeckCid(cid, ecr16.getHd().getCid(), equipInfoRepository)) {
					cidChecked = true;
				}
				// 충전기상태 체크
				boolean stsChecked = false;
				if (commonUtil.checkSts(ecr16.getHd().getSts())) {
					stsChecked = true;
				}
				boolean sidCidChecked = false;
				if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
					sidCidChecked = true;
				} else {
					if (cidChecked) {
						sidChecked = false;
					}
				}
				boolean checked = false;
				if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {
					// 장치 번호 가져옴
					eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
					// 경보해제 데이타 저장
					WarningHistPK whPk = new WarningHistPK();
					whPk.setEqpNum(eqpNumber);
					whPk.setOccrDay(String.valueOf(ecr16.getBd().getTdt())); // 발생일자
					whPk.setOccrTime(String.valueOf(ecr16.getBd().getTtm())); // 발생일시
					whPk.setOutletNum(1);
					whPk.setWarningCd(String.valueOf(ecr16.getHd().getTid()));// 경보코드
					log.info("-----경보 저장 자료 전송(해제)1---->" + ecr16.getBd().getSts());
					// 경보 해제 이력 데이터 값 세팅
					WarningHist wh = new WarningHist();

					wh.setId(whPk);
					wh.setCloseDay(String.valueOf(ecr16.getBd().getCdt())); // 해제일자
					wh.setCloseTime(String.valueOf(ecr16.getBd().getCtm())); // 해제일시
					wh.setWarningLevel(ecr16.getBd().getLvl()); // 경보레벨
					wh.setWarningStat(ecr16.getBd().getSts()); // 경보상태
					// 경보해제 이력 데이타 저장
					warningHistRepository.save(wh);
					checked = true;
				}

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
				} else if (checked) {
					rcd = 1;
					rms = "전송성공";
				} else {
					rcd = 999;
					rms = "요청(전송)처리실패";
				}
			}

			long rdatetime = commonUtil.getNowDate();
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr16.getHd().getTid());
			erb = new POS16();
			ec = new EvcomResPos16(erh, erb);

		} catch (Exception e) {

			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos16 ecr16 = null;
			int tid = 0;

			try {
				ecr16 = GenericUnmarshallFactory.getInstance(EvcomReqPos16.class, xmlBody);
				tid = ecr16.getHd().getTid();

			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {

				e1.printStackTrace();
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);

			}

			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, tid);
			erb = new POS16();
			ec = new EvcomResPos16(erh, erb);
			System.out.println(e);
		}

		return ec;
	}

	@POST
	@Path("{sid}/chargers/{cid}/dayhis")
	public EvcomResPos17 pos17(@PathParam("sid") int sid, @PathParam("cid") String cid, @RequestBody String xmlBody) {

		log.info("--------------------------- xml body -----------------------------");
		log.info(xmlBody);
		log.info("--------------------------- xml body -----------------------------");

		EvcomResponseHead erh = null;
		POS17 erb = null;
		EvcomResPos17 ec = null;
		int rcd;
		String rms;

		try {

			EvcomReqPos17 ecr17 = GenericUnmarshallFactory.getInstance(EvcomReqPos17.class, xmlBody);

			log.info(ecr17.getHd());// 전문 헤더
			log.info(ecr17.getHd().getCid());// 충전기ID
			log.info(ecr17.getHd().getSid());// 충전소ID
			log.info(ecr17.getHd().getStm());// 요청전송일시
			log.info(ecr17.getHd().getSts());// 충전기상태
			log.info(ecr17.getHd().getTid());// 트랜잭션번호
			log.info(ecr17.getBd());// 전문바디
			log.info(ecr17.getBd().getDte());// 마감일자
			log.info(ecr17.getBd().getCwh());// 금일충전량
			log.info(ecr17.getBd().getCcnt());// 금일충전횟수
			log.info(ecr17.getBd().getAcnt());// 금일발생경보갯수
			log.info(ecr17.getBd().getCamt());// 금일충전청구총금액
			log.info(ecr17.getBd().getPscnt());// 결제성공건수
			log.info(ecr17.getBd().getPfcnt());// 결제실패건수

			log.info("-----마감일자---->" + String.valueOf(ecr17.getBd().getDte()));

			// validation check
			long rdatetime = commonUtil.getNowDate();
			// 시간 체크
			boolean timeChecked = false;
			if (commonUtil.checkTime(ecr17.getHd().getStm())) {
				timeChecked = true;
			}

			// 충전소 체크
			boolean sidChecked = false;
			if (commonUtil.ckeckSid(sid, ecr17.getHd().getSid(), csInfoRepository)) {
				sidChecked = true;
			}
			// 충전기 체크
			boolean cidChecked = false;
			if (commonUtil.ckeckCid(cid, ecr17.getHd().getCid(), equipInfoRepository)) {
				cidChecked = true;
			}
			// 충전기상태 체크
			boolean stsChecked = false;
			if (commonUtil.checkSts(ecr17.getHd().getSts())) {
				stsChecked = true;
			}
			boolean sidCidChecked = false;
			if (commonUtil.checkSidCid(sid, cid, equipInfoRepository)) {
				sidCidChecked = true;
			} else {
				if (cidChecked) {
					sidChecked = false;
				}
			}
			boolean checked = false;
			if (timeChecked && sidChecked && cidChecked && stsChecked && sidCidChecked) {

				// 경보해제 데이타 저장
				CpDayEndHistPK cpDayEndHistPk = new CpDayEndHistPK();
				// 장치 번호 가져옴
				int eqpNumber = commonUtil.getEqpNum(sid, cid, equipInfoRepository);
				log.info("-----장치번호---->" + eqpNumber);
				cpDayEndHistPk.setEqpNum(eqpNumber);// 장치번호
				cpDayEndHistPk.setEndDay(String.valueOf(ecr17.getBd().getDte()));// 마감일자

				// 일일마감저장자료 데이터 값 세팅
				CpDayEndHist cpDayEndHist = new CpDayEndHist();

				cpDayEndHist.setId(cpDayEndHistPk);
				cpDayEndHist.setTodayChargekwh(ecr17.getBd().getCwh());// 금일충전량
				cpDayEndHist.setTodayChargeCnt(ecr17.getBd().getCcnt());// 금일충전횟수
				cpDayEndHist.setTodayTotChargeBill(ecr17.getBd().getCamt());// 금일충전청구총금액
				cpDayEndHist.setTodayWarningCnt(ecr17.getBd().getAcnt());// 금일발생경보갯수
				cpDayEndHist.setPaySuccCnt(ecr17.getBd().getPscnt());// 결제성공건수
				cpDayEndHist.setPayFailCnt(ecr17.getBd().getPfcnt());// 결제실패건수
				// 일일ㅇ마감 저장자료 데이타 저장
				cpDayEndHistRepository.save(cpDayEndHist);

				checked = true;
			}

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
			} else if (checked) {
				rcd = 1;
				rms = "전송성공";
			} else {
				rcd = 999;
				rms = "요청(전송)처리실패";
			}
			// validation check
			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, ecr17.getHd().getTid());
			erb = new POS17();
			ec = new EvcomResPos17(erh, erb);

		} catch (Exception e) {
			System.out.println(e);
			long rdatetime = commonUtil.getNowDate();
			rcd = 999;
			rms = "요청(전송)처리실패";
			EvcomReqPos17 ecr17 = null;
			int tid = 0;

			try {
				ecr17 = GenericUnmarshallFactory.getInstance(EvcomReqPos17.class, xmlBody);
				tid = ecr17.getHd().getTid();

			} catch (IllegalAccessException | InstantiationException | JAXBException e1) {
				e1.printStackTrace();
				rcd = 900;
				rms = "XML Data Format Error";
				System.out.println(e1);
			}

			erh = new EvcomResponseHead(rdatetime, sid, cid, rcd, rms, tid);
			erb = new POS17();
			ec = new EvcomResPos17(erh, erb);
			System.out.println(e);
		}
		return ec;
	}

}

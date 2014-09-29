package nz.co.s3m.clientside.service;

import java.util.ArrayList;

import nz.co.s3m.clientside.dao.ClientSideDAOImpl;
import nz.co.s3m.clientside.vo.ClientSideVO;
import nz.co.s3m.member.service.MemberService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

@Service
public class ClientSideService {

	private static final Logger logger = LoggerFactory
			.getLogger(MemberService.class);

	@Autowired
	private ClientSideDAOImpl daoImpl;

	@Transactional(propagation = Propagation.REQUIRED)
	public ArrayList<ClientSideVO> getClientSideList() {
		return daoImpl.getClientSideList();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String getClientSideListJSON() {
		Gson gson = new Gson();
		String rtnString = gson.toJson(daoImpl.getClientSideList());
		return rtnString;
	}

}

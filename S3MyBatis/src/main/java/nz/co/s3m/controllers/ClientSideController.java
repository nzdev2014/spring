package nz.co.s3m.controllers;

import java.util.List;
import java.util.Locale;

import nz.co.s3m.clientside.service.ClientSideService;
import nz.co.s3m.clientside.vo.ClientSideVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientSideController {
	@Autowired
	private ClientSideService svc;

	private static final Logger logger = LoggerFactory
			.getLogger(ClientSideController.class);

	
	@RequestMapping(value = "/clientsideList.do", method = RequestMethod.GET)
	public String clientsideList(Locale locale, Model model) {
		logger.info("ClientSideController > clientsideList :", locale);

		List<ClientSideVO> webList = svc.getClientSideList();
		model.addAttribute("result", webList);
		return "main";
	}
	
	@ResponseBody
	@RequestMapping(value = "/clientsideListJson.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String clientsideListJson(Locale locale, Model model) {
		logger.info("ClientSideController > clientsideListJson :", locale);
		
		return svc.getClientSideListJSON();
	}
}

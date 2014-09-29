package nz.co.s3m.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import nz.co.s3m.member.vo.MemberVO;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private BasicDataSource myDatasource;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/dbcp.do", method = RequestMethod.GET)
	public String dbcp(Locale locale, Model model) {
		logger.info("HomeController > DBCP");

		String active_status = myDatasource.getNumActive() + "/"
				+ myDatasource.getMaxActive();
		String idle_status = myDatasource.getNumIdle() + "/"
				+ myDatasource.getMaxIdle();

		model.addAttribute("active", active_status);
		model.addAttribute("idle", idle_status);

		return "dbcp";
	}

	@ResponseBody
	@RequestMapping(value = "/ang05.do", method = RequestMethod.GET)
	public String ang05(Locale locale, Model model) {
		return "[ {\"name\" : \"Dave Jones\", \"city\" : \"Phoenix\"}, {\"name\" : \"Jamie Riley\",	\"city\" : \"Atlanta\"}, {\"name\" : \"Heedy Wahlin\",\"city\" : \"Chandler\"} ]";
	}
	

}

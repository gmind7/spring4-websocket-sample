package com.gmind7.bakery.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	protected Logger log = LoggerFactory.getLogger(ViewController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		log.debug("welcome to the gmind7 bakery homeController.............");
		return "index";
	}
	
	/* mvc:view path => javaconfig 사용 설정은 샘플링 이라서 하지 않았습니다. */
	@RequestMapping(value = "/echo/view", method = RequestMethod.GET)
	public String echo(){
		return "echo";
	}
	
	@RequestMapping(value = "/echo-issue4/view", method = RequestMethod.GET)
	public String echo_issue4(){
		return "echo-issue4";
	}
	
	@RequestMapping(value = "/snake/view", method = RequestMethod.GET)
	public String snake(){
		return "snake";
	}
	
}

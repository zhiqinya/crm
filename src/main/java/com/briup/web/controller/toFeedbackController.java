package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class toFeedbackController {
	@RequestMapping("toFeedback")
	public String toplan(HttpSession session) {
		
		return "pages/feedback";
	}		
}

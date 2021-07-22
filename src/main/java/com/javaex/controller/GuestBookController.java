package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	// 리스트
	@RequestMapping( value="list", method= {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("[GuestBookController.list]");
		GuestBookDao gbDao = new GuestBookDao();
		List<GuestBookVo> gbList = gbDao.getGuestBookList();
		System.out.println(gbList);
		model.addAttribute("gbList", gbList);
		
		return "/WEB-INF/views/addList.jsp";
	}
	
	// 작성
	@RequestMapping( value="write", method= {RequestMethod.GET, RequestMethod.POST} )
	public String write(@ModelAttribute GuestBookVo gbVo) {
		System.out.println("[GuestBookController.write]");
		GuestBookDao gbDao = new GuestBookDao();
		gbDao.guestBookInsert(gbVo);
			
		return "redirect:/list";
	}
	
	// 삭제폼
	@RequestMapping( value="deleteForm", method= {RequestMethod.GET, RequestMethod.POST} )
	public String deleteForm(Model model, @RequestParam("no") int listNo) {
		System.out.println("[GuestBookController.deleteForm]");
		model.addAttribute("listNo", listNo);
		
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	//삭제
	@RequestMapping( value="delete", method= {RequestMethod.GET, RequestMethod.POST} )
	public String delete(@ModelAttribute GuestBookVo gbVo) {
		System.out.println("[GuestBookController.delete]");
		GuestBookDao gbDao = new GuestBookDao();
		gbDao.guestBookDelete(gbVo);
		System.out.println(gbVo);
		
		return "redirect:/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

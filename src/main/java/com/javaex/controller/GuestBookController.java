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

	/*
	//삭제
	@RequestMapping( value="delete", method= {RequestMethod.GET, RequestMethod.POST} )
	public String delete(@ModelAttribute GuestBookVo gbVo) {
		System.out.println("[GuestBookController.delete]");
		GuestBookDao gbDao = new GuestBookDao();
		gbDao.guestBookDelete(gbVo);
		
		return "redirect:/list";
	}
	*/
	
	//삭제 if추가?해봄?
	@RequestMapping( value="delete", method= {RequestMethod.GET, RequestMethod.POST} )
	public String delete(Model model, @ModelAttribute GuestBookVo gbVo) {
		System.out.println("[GuestBookController.delete]");
		GuestBookDao gbDao = new GuestBookDao();
		GuestBookVo gbUserInfo = gbDao.getUserInfo(gbVo.getNo());
		
		//if추가?
		if(gbUserInfo.getPassword().equals(gbVo.getPassword())) {
			System.out.println("패스워드 일치");
			gbDao.guestBookDelete(gbVo);
		}else {
			System.out.println("패스워드 불일치");
			return "redirect:/deleteForm?no=" + gbVo.getNo() + "&action=fail";
		}
	
		return "redirect:/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

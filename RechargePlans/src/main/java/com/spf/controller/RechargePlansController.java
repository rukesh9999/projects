package com.spf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spf.dto.PlanDto;
import com.spf.form.SaveRechargePlanForm;
import com.spf.service.saveRechargePlanService;

@Controller
public class RechargePlansController {

	/*
	 * @Autowired saveRechargePlanService saveRechargePlanService;
	 */
	/*
	 * @RequestMapping("/planDetails.htm") public ModelAndView
	 * saveEmployee(@ModelAttribute SaveRechargePlanForm
	 * SaveRechargePlanForm,BindingResult BindingResult) {
	 * System.out.println("plan controller..."); ModelAndView modelAndview=null;
	 * modelAndview=new ModelAndView(); List<PlanDto> dtolist=null; dtolist=new
	 * ArrayList<PlanDto>(); dtolist.add(new
	 * PlanDto(SaveRechargePlanForm.getPlanNo(), SaveRechargePlanForm.getPlanName(),
	 * SaveRechargePlanForm.getValidity(), SaveRechargePlanForm.getPlanType(),
	 * SaveRechargePlanForm.getAmount())); dtolist.add(new
	 * PlanDto(SaveRechargePlanForm.getPlanNo(), SaveRechargePlanForm.getPlanName(),
	 * SaveRechargePlanForm.getValidity(), SaveRechargePlanForm.getPlanType(),
	 * SaveRechargePlanForm.getAmount())); dtolist.add(new
	 * PlanDto(SaveRechargePlanForm.getPlanNo(), SaveRechargePlanForm.getPlanName(),
	 * SaveRechargePlanForm.getValidity(), SaveRechargePlanForm.getPlanType(),
	 * SaveRechargePlanForm.getAmount()));
	 * 
	 * modelAndview.addObject("dtolist", dtolist);
	 * System.out.println(SaveRechargePlanForm.getPlanType()+""+SaveRechargePlanForm
	 * .getPlanNo()+""+SaveRechargePlanForm.getPlanName()+""+SaveRechargePlanForm.
	 * getValidity()); modelAndview.setViewName("planDetails");
	 * 
	 * return modelAndview; }
	 * 
	 * 
	 * 
	 */
	  
	  @Autowired
	  saveRechargePlanService saveRechargePlanService;
	  
	  @RequestMapping("/planDetails.htm") 
	  public void saveEmployee(@ModelAttribute SaveRechargePlanForm SaveRechargePlanForm,BindingResult BindingResult) { 
	  System.out.println("plan controller...");
	  List<PlanDto> dtolist=null;
	  dtolist=new ArrayList<PlanDto>();  
	  dtolist.add(new PlanDto(SaveRechargePlanForm.getPlanNo(), SaveRechargePlanForm.getPlanName(), SaveRechargePlanForm.getValidity(), SaveRechargePlanForm.getPlanType(), SaveRechargePlanForm.getAmount()));
	  	  
	  System.out.println(SaveRechargePlanForm.getPlanType()+""+SaveRechargePlanForm.getPlanNo()+""+SaveRechargePlanForm.getPlanName()+""+SaveRechargePlanForm.getValidity());
	  saveRechargePlanService.savePlanService(dtolist);
	 }
	  
	  
	  @RequestMapping("/saveplans.htm")
		public String showWelcomePage()
		{
			return "saveplans";
		}
		

}

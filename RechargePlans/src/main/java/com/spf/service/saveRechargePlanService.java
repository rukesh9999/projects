package com.spf.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spf.bo.saveRechargePlanBo;
import com.spf.dao.saveRechargePlanDao;
import com.spf.dto.PlanDto;
import com.spf.dto.SaveRechargePlanDto;
@Service
public class saveRechargePlanService {
   
	@Autowired(required = true)
	private saveRechargePlanDao saveRechargePlanDao;
	
	public saveRechargePlanService(com.spf.dao.saveRechargePlanDao saveRechargePlanDao) {
		this.saveRechargePlanDao = saveRechargePlanDao;
	}
	public saveRechargePlanService()
	{
		
	}
	
	private saveRechargePlanBo saveRechargePlanBo=null;
	@Transactional(readOnly = false)
	public void savePlanService(List<PlanDto> dtolist) {
   
		Iterator<PlanDto>  SaveRechargePlanDtolist = dtolist.iterator();
		List<saveRechargePlanBo> boslist=new ArrayList<saveRechargePlanBo>(); 
		while(SaveRechargePlanDtolist.hasNext())
		{
			PlanDto SaveRechargePlanDto =SaveRechargePlanDtolist.next();
			saveRechargePlanBo=new saveRechargePlanBo();
			saveRechargePlanBo.setAmount(SaveRechargePlanDto.getAmount());
			saveRechargePlanBo.setPlanName(SaveRechargePlanDto.getPlanName());
			saveRechargePlanBo.setPlanType(SaveRechargePlanDto.getPlantype());
			saveRechargePlanBo.setValidity(SaveRechargePlanDto.getValidity());
			saveRechargePlanBo.setPlanNo(SaveRechargePlanDto.getPlanNo());
			boslist.add(saveRechargePlanBo);
			
		}
		
		 saveRechargePlanDao.savePlanDao(boslist);

	}

}

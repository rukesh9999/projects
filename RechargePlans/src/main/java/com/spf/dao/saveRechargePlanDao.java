package com.spf.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spf.bo.saveRechargePlanBo;

@Repository
public class saveRechargePlanDao {
    @Autowired(required = true)
    private HibernateTemplate hibernateTemplate;
	
    public void savePlanDao(List<saveRechargePlanBo> saveRechargePlanBolist)
	{
		
    	Iterator<saveRechargePlanBo>  saveRechargePlanBos  = saveRechargePlanBolist.iterator();
    	while(saveRechargePlanBos.hasNext())
    	{
    		saveRechargePlanBo  saveRechargePlanBo = saveRechargePlanBos.next();
    		hibernateTemplate.save(saveRechargePlanBo); 
    		System.out.println("plan saved.....successfully");
    	}
	 
	}

}

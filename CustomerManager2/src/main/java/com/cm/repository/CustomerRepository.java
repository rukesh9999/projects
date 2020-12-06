package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cm.model.customer;	

public interface CustomerRepository  extends CrudRepository<customer, Long>{

	@Query(value="select c from customer c where c.name LIKE  '%' || :keyword || '%' "
	 +" OR c.email LIKE '%' || :keyword || '%' "
	 +" OR c.address LIKE '%' ||:keyword || '%' ")
	public List<customer> search(@Param("keyword")String keyword);
}
	
package com.wipro.customertool.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.AccountEntity;

@Repository
public interface AccountRepository  extends JpaRepository<AccountEntity, Integer>{
	
	List<AccountEntity> findByUserId(String userId);
	
	List<AccountEntity> findByUserIdAndCountryCodeIn(String userId, Collection<String> countryCodes);

}

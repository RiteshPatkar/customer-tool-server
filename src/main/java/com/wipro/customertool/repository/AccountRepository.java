package com.wipro.customertool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customertool.entity.AccountEntity;
import com.wipro.customertool.entity.AccountEntityKey;

@Repository
public interface AccountRepository  extends JpaRepository<AccountEntity, AccountEntityKey>{

}

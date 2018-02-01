package com.wipro.customertool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customertool.entity.AccountEntity;
import com.wipro.customertool.entity.AccountEntityKey;

public interface AccountRepository  extends JpaRepository<AccountEntity, AccountEntityKey>{

}

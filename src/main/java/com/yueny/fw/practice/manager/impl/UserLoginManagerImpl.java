/**
 *
 */
package com.yueny.fw.practice.manager.impl;

import com.yueny.fw.practice.bo.CarBo;
import com.yueny.fw.practice.entry.CarEntry;
import com.yueny.fw.practice.entry.CarType;
import com.yueny.fw.practice.manager.IService;
import com.yueny.fw.practice.manager.IUserLoginManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserLoginManagerImpl implements IUserLoginManager {
	@Autowired
	private IService service;

	@Override
	public boolean login(final String userName) {
		CarEntry entry = new CarEntry();
		entry.setMake(userName);
		entry.setNumberOfSeats(2);
		entry.setType(CarType.A);

		CarBo bo = service.carToCarDto(entry);

		//log.info("result is :{}.", bo);

		return true;
	}

}

/**
 *
 */
package com.yueny.fw.manager.impl;

import com.yueny.fw.entry.CarEntry;
import com.yueny.fw.entry.CarType;
import com.yueny.fw.manager.IUserLoginManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserLoginManagerImpl implements IUserLoginManager {

	@Override
	public boolean login(final String userName) {
		CarEntry entry = new CarEntry();
		entry.setMake(userName);
		entry.setNumberOfSeats(2);
		entry.setType(CarType.A);

		IUserLoginManager.super.print();
		print();

		IUserLoginManager.blowHorn();

//		CarBo bo = service.carToCarDto(entry);

//		log.info("result is :{}.", bo);

		return true;
	}

	@Override
	public void print() {
		System.out.println("UserLoginManagerImpl 默认打印");
	}

}

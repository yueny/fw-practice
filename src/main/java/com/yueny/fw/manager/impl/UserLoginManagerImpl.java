/**
 *
 */
package com.yueny.fw.manager.impl;

import com.yueny.fw.entry.CarEntry;
import com.yueny.fw.entry.CarType;
import com.yueny.fw.manager.IUserLoginManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;


@Slf4j
@Service
public class UserLoginManagerImpl implements IUserLoginManager {


//	/ 配置文件   time=5s
//
//	/**
//	 * 常用单位如下:
//	 *
//	 *     ns for nanoseconds (纳秒)
//	 *     us for microseconds (微秒)
//	 *     ms for milliseconds (毫秒)
//	 *     s for seconds (秒)
//	 *     m for minutes (分)
//	 *     h for hours (时)
//	 *     d for days (天)
//	*/
	// 时间配置单位，默认毫秒
//	@DurationUnit(ChronoUnit.SECONDS)
//    private Duration time;

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

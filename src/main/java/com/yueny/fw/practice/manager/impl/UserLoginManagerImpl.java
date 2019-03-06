/**
 *
 */
package com.yueny.fw.practice.manager.impl;

import com.yueny.fw.practice.manager.IUserLoginManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserLoginManagerImpl implements IUserLoginManager {

	@Override
	public boolean login(final String userName) {
		//
		return true;
	}

}

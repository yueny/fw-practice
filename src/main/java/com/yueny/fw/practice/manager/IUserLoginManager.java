/**
 *
 */
package com.yueny.fw.practice.manager;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2017年11月1日 下午8:52:44
 *
 */
public interface IUserLoginManager {
	/**
	 * 执行操作
	 */
	boolean login(String userName);

	default void print(){
		// 在父类中重写此方法后，如果直接调用接口默认方法，期返回值为接口实现逻辑
		System.out.println("IUserLoginManager 默认打印");
	}

	static void blowHorn(){
		System.out.println("IUserLoginManager 静态!!!");
	}

}

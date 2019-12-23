package org.crazyit.activiti.spring.impl;

import org.crazyit.activiti.MyService;

public class MyServiceImpl implements MyService {

	@Override
	public void serviceMethod(String name) {
		// TODO Auto-generated method stub
		System.out.println("MyService 的实现类处理业务方法：" + name);
	}

}

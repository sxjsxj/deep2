package com.deep.two.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.deep.two.util.SpringContextUtil;

public class ConfigInitListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ConfigInitializer configInitializer = SpringContextUtil.getBean(ConfigInitializer.class);
		configInitializer.init();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}

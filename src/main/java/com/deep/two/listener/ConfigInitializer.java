package com.deep.two.listener;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.deep.two.authority.impl.CustomFilterInvocationSecurityMetadataSource;
import com.deep.two.util.SpringContextUtil;
import com.deep.two.util.ViewException;

@Component
public class ConfigInitializer {
	private static Logger logger = Logger.getLogger(ConfigInitializer.class);
	private CustomFilterInvocationSecurityMetadataSource ms = SpringContextUtil.getBean(CustomFilterInvocationSecurityMetadataSource.class);
	
	public void init() {
		initResourceMap();
	}
	
	private void initResourceMap() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(120000);
				} catch (InterruptedException e) {
					logger.error(e.getMessage(), e);
				}
				try {
					ms.initResourceMap();
				} catch (ViewException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}).start();
	}
}

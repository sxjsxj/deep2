package com.deep.two.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringContextUtil implements ApplicationContextAware {
	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * 
	 * @param applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return SpringContextUtil.applicationContext;
	}

	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static <T> Map<String, T> getBeans(Class<T> type) throws BeansException {
		Map<String, T> t = SpringContextUtil.applicationContext.getBeansOfType(type);
		return t;
	}
	
	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static <T> T getBean(String name, Class<T> type) throws BeansException {
		T t = SpringContextUtil.applicationContext.getBean(name, type);
		return t;
	}
	
	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static <T> T getBean(Class<T> clazz) throws BeansException {
		T t = SpringContextUtil.applicationContext.getBean(clazz);
//		if (t == null) {
//			registerBean(clazz);
//		}
		return t;
	}

	/**
	 * 根据名称获取对象
	 * @param name
	 * @return
     */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	public static <T> void registerBean(Class<T> clazz) {
	    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
	    String beanName = clazz.getSimpleName();
	    BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
	    ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
	    BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
		beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinition);
	}
}

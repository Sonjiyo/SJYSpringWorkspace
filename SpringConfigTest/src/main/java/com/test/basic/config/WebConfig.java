package com.test.basic.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml�� �ڹٷ� ������ Ŭ����
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	//��Ʈ ���ؽ�Ʈ ��ü
	@Override
	protected Class<?>[] getRootConfigClasses() { //root-context.xml
		return new Class[] { RootConfig.class };
	}

	//���� ���ؽ�Ʈ ��ü
	@Override
	protected Class<?>[] getServletConfigClasses() { //servlet-context.xml
		return new Class[] { ServletConfig.class };
	}
	
	//�ڵ鷯 ���� ��ü
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);		
		return new Filter[]{encodingFilter};
	}
}
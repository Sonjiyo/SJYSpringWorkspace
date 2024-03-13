package kr.board.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml을 자바로 구현한 클래스
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	//루트 컨텍스트 객체
	@Override
	protected Class<?>[] getRootConfigClasses() { //root-context.xml
		return new Class[] { RootConfig.class };
	}

	//서블릿 컨텍스트 객체
	@Override
	protected Class<?>[] getServletConfigClasses() { //servlet-context.xml
		return new Class[] { ServletConfig.class };
	}
	
	//핸들러 맵핑 객체
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
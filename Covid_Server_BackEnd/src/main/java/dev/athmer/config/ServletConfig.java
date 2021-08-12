package dev.athmer.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// This class replaces our Deployment Descriptor (web.xml)
public class ServletConfig implements WebApplicationInitializer {
	
	/*
	 * Before we were the Front Controller Design Pattern - mapping one servlet 
	 * 
	 * Spring also uses this FCDP
	 * 
	 * Our deployment descriptor would like exactly the same (with Spring's front controller in the servlet class tag
	 * 
	 * Ultimately - we're just saying 'Use Spring's Front Controller'
	 * 
	 * */

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Setting up
		
		// Access ApplicationContext
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		
		// Register Spring config - the class that we created
		ac.register(SpringConfig.class);
		
		// Set Servlet Context for the ApplicationContext
		ac.setServletContext(servletContext);
		
		// Add Spring's Front Controller
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ac));
		
		// Set the servlet settings
		servlet.setLoadOnStartup(1); // mirroring <load-on-startup>1</load-on-start-up>
		servlet.addMapping("/"); // mirroring <url-mapping>/</url-mapping>
	}
}

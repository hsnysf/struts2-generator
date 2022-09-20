package employee.interceptor;

import java.lang.reflect.Field;

import javax.ejb.EJB;
import javax.naming.InitialContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class EJBInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Object object = invocation.getAction();
		
		Field[] fields = object.getClass().getDeclaredFields();
		
		if(fields != null){
			
			for(Field field : fields){
				
				if(field.isAnnotationPresent(EJB.class)){
					
					Object value = new InitialContext().lookup("java:global/struts2-sample/" + field.getType().getSimpleName());
					
					field.setAccessible(true);
					
					field.set(object, value);
				}
			}
		}
		
		return invocation.invoke();
	}
}

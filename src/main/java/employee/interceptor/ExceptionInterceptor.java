package employee.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import employee.action.CommonAction;
import employee.exception.BusinessException;

public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String result = null;
		
		CommonAction action = (CommonAction) invocation.getAction();
		
		try {
			
			result = invocation.invoke();
			
		} catch (BusinessException e) {
			
			action.addActionError(e.getMessage());
			
			return action.toSessionPage();
		
		}catch (Exception e) {
			
			action.addActionError("Some error occur while processing");
			
			return action.toSessionPage();
		}
		
		return result;
	}
}

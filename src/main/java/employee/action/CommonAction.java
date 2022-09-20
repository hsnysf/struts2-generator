package employee.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class CommonAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;
	
	protected String page;
	
	@Override
	public void prepare() throws Exception {
		
	}
	
	public String toPage(String page) {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		this.page = page;
		
		session.put("page", page);
		
		return "layout";
	}
	
	public String toSessionPage() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		this.page = (String) session.get("page");
		
		return "layout";
	}
	
	public String getPage() {
		return page;
	}
	
	public void setPage(String page) {
		this.page = page;
	}
}

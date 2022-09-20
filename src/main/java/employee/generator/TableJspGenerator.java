package employee.generator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.node.SimpleNode;

public class TableJspGenerator {

	public static void main(String[] args) throws Exception {
		
		Map<String, Table> tableMap = DatabaseReader.getTableMap();

		for (Table table : tableMap.values()) {
			
			RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
			
			Reader reader = new FileReader("./src/main/webapp/list.txt");
			
			Template template = new Template();
			
			SimpleNode node = runtimeServices.parse(reader, template);
			
			template.setRuntimeServices(runtimeServices);
			
			template.setData(node);
			
			template.initDocument();
			
			VelocityContext context = new VelocityContext();
			context.put("table", table);
			
			FileWriter writer = new FileWriter("./src/main/webapp/" + table.propertyName + "s-list.jsp");
			
			template.merge(context, writer);
			
			writer.close();
			
			runtimeServices = RuntimeSingleton.getRuntimeServices();
			
			reader = new FileReader("./src/main/webapp/save.txt");
			
			template = new Template();
			
			node = runtimeServices.parse(reader, template);
			
			template.setRuntimeServices(runtimeServices);
			
			template.setData(node);
			
			template.initDocument();
			
			context = new VelocityContext();
			context.put("table", table);
			
			writer = new FileWriter("./src/main/webapp/save-" + table.propertyName + ".jsp");
			
			template.merge(context, writer);
			
			writer.close();
		}
	}
}

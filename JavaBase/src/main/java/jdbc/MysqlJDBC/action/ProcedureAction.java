package jdbc.MysqlJDBC.action;

import java.util.List;

import org.junit.Test;

import jdbc.MysqlJDBC.dao.ProcedureDao;
import jdbc.MysqlJDBC.model.Goddess;

/**调用无参的存储过程*/
public class ProcedureAction {

	private ProcedureDao dao = new ProcedureDao();
	
	/**调用无参的存储过程*/
	@Test
	public void procedure_select_nofilter() {
		List<Goddess> list = dao.procedure_select_nofilter();
		System.out.println(list.toString());
	}
	
	/**调用无参的存储过程*/
	@Test
	public void procedure_select_filter() {
		String userName = "简";
		List<Goddess> list = dao.procedure_select_filter(userName);
		System.out.println(list.toString());
	}
	
	/**调用出参的存储过程*/
	@Test
	public void procedure_select_count() {
		int count = dao.procedure_select_count();
		System.out.println("总记录数为:"+count);
	}
}

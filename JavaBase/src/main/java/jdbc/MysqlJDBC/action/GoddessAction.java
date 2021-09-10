package jdbc.MysqlJDBC.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import jdbc.MysqlJDBC.dao.GoddessDao;
import jdbc.MysqlJDBC.model.Goddess;

/**控制层*/
public class GoddessAction {

	private GoddessDao dao = new GoddessDao();
	
	/**查找对象集合*/
	@Test
	public void queryGoddess() {
		List<Goddess> list = dao.queryGoddess();
		System.out.println(list.toString());
	}
	
	/**新增对象*/
	@Test
	public void	addGoddess(){
		Goddess goddess = new Goddess(2, "小简", "女", 24, new Date(),
					"456@qq.com", "123456789", "张谦", null, "张谦", null, 0);
		dao.addGoddess(goddess);
	}
	
	/**更新对象*/
	@Test
	public void	updateGoddess(){
		Goddess goddess = new Goddess(2, "小梅梅", "女", 23, new Date(),
					"456@qq.com", "987654321", null, null, "张谦", null, 0);
		dao.updateGoddess(goddess);
	}
	
	/**删除对象*/
	@Test
	public void	deleteGoddess(){
		Goddess goddess = new Goddess();
		goddess.setId(2);
		dao.deleteGoddess(goddess);
	}
	
	/**查询单个对象*/
	@Test
	public void	getGoddess(){
		Goddess goddess = new Goddess();
		goddess.setId(1);
		goddess = dao.getGoddess(goddess);
		System.out.println(goddess);
	}
	
	
	/**条件查询对象*/
	@Test
	public void	queryGoddessBySome(){
		List<Map<String, Object>> params = new ArrayList<>();
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("key", "sex");
		param1.put("nexus", "=");
		param1.put("value", "'女'");
		params.add(param1);
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("key", "user_name");
		param2.put("nexus", "like");
		param2.put("value", "'%小%'");
		params.add(param2);
		List<Goddess> list = dao.queryGoddessBySome(params);
		System.out.println(list.toString());
	}
}

package javaAnnotation.demo;


import java.lang.reflect.Field;
import java.lang.reflect.Method;



/**进行查询的测试类*/
public class QueryTest {

	private static String query(User user) throws Exception{
		StringBuffer sql = new StringBuffer();
		//获取被注解表示的类
		Class<?> clazz = user.getClass();
		//获取类上的表示表名的注解
		//首先判断是否存在该注解
		boolean tableExist = clazz.isAnnotationPresent(Table.class);
		if (!tableExist) {
			return null;		//如果不存在,程序终止
		}
		//获取注解对象
		Table table = (Table) clazz.getAnnotation(Table.class);
		//获取注解对象中的值
		String tableName = table.value();
		//拼写SQL语句
		sql.append(" select * from ").append( tableName ).append(" where 1=1 ");
		//遍历所有的属性
		Field[] files = clazz.getDeclaredFields();
		for (Field field : files) {
			//是够该字段上有相应的注解
			boolean columnExist = field.isAnnotationPresent(Column.class);
			if (columnExist) {
				//获得字段对象上的注解信息,表字段信息
				Column column = field.getAnnotation(Column.class);
				String columnName = column.value();
				//获得字段封装的get方法的值
				String fileName = field.getName();
				//获得各种get方法		get + 首字母大写  + 剩下部分
				String getMethodName = "get"+fileName.substring(0, 1).toUpperCase()+fileName.substring(1);
				//传入方法名,完成对方法的获取
				Method getMethod = clazz.getMethod(getMethodName);
				//传入反射对象,参数,执行对应方法.返回值可以为date,string,int...  
				Object fieldValue = getMethod.invoke(user);		//静态方法,需要在调用前进行实例化
				
				//拼装SQL	如果字段值为空	或者为数字0(首先强转为数字型,随后取值判断)
				if(fieldValue == null || (fieldValue instanceof Integer  && (Integer)fieldValue ==0)){
					continue;
				}
				if(fieldValue == null || (fieldValue instanceof Integer  && (Integer)fieldValue !=0)){
					sql.append(" and ").append(columnName).append(" = ").append(fieldValue);
				}
				//拼装SQL,如果是String类型,则增加"\'"或者in条件
				if(fieldValue instanceof String){
					//强制转为String类型,如果包含,则认为in型的包含查询
					if (((String)fieldValue).contains(",")) {
						//根据分号分隔,追加"\'".
						String[] ins = ((String)fieldValue).split(",");
						sql.append(" and ").append(columnName).append(" in (");
						for (String s : ins) {
							sql.append("\'"+s+"\'"+",");
						}
						sql.deleteCharAt(sql.length()-1);	//删除最后一个
						sql.append(")");
					}else {
						sql.append(" and ").append(columnName).append(" = ").append("\'"+fieldValue+"\'");
					}
				}
			}
		}
		//获取注解后判断条件进行追加SQL
		return sql.toString();
	}
	
	public static void main(String[] args) throws Exception{
		
		/*定义查询条件*/
		User user1 = new User();
		user1.setId(10);
		
		User user2 = new User();
		user2.setUsername("张三");
		
		User user3 = new User();
		user3.setId(20);
		user3.setEmail("123@qq.com,456@qq.com,789@qq.com");
		
		/*传入对象,生成SQL语句*/
		String sql1 = query(user1);
		System.out.println(sql1);
		String sql2 = query(user2);
		System.out.println(sql2);
		String sql3 = query(user3);
		System.out.println(sql3);
	}
}

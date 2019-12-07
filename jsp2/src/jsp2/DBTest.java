package jsp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	//声明连接对象
	Connection conn=null;
	//声明预编译陈述对象
	PreparedStatement ps=null;
	//声明结果集对象
	ResultSet rs=null;
	//声明连接数据库的url地址
	          //      http://www.baidu.com
	          //主要协议:次要协议://主机名:端口号/数据名
	String url="jdbc:mysql://localhost:3306/db1903";
	//声明连接数据库的用户名
	String user="root";
	//声明连接数据库的密码
	String password="root";
	
	//添加用户
	public boolean add(String uname,String upass,String sex,int age){
		boolean isOk=false;
		try {
			//1、加载注册mysql驱动
			Class.forName("com.mysql.jdbc.Driver");//驱动类
			System.out.println("加载注册mysql驱动成功");
			//2、通过(驱动管理器)获取（连接对象）
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功");
			//3、通过（连接对象）获取（预编译陈述对象）,并且设置sql
			String sql="insert into users values(null,?,?,?,?,null,null,null)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, sex);
			ps.setInt(4, age);
			//4、通过（预编译陈述对象）执行sql语句
			ps.executeUpdate();
			isOk=true;
			System.out.println("添加成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("加载注册mysql驱动失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("连接数据库失败");
		} finally {
			    //5、关闭数据库资源
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("关闭资源成功");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("关闭资源失败");
				}
		}
		return isOk;
	}

	
	//修改用户
	public void update(int uid,String uname,String upass,String sex,int age){
		try {
			//1、加载注册mysql驱动
			Class.forName("com.mysql.jdbc.Driver");//驱动类
			System.out.println("加载注册mysql驱动成功");
			//2、通过(驱动管理器)获取（连接对象）
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功");
			//3、通过（连接对象）获取（预编译陈述对象）,并且设置sql
			String sql="update users set uname=?,upass=?,sex=?,age=? where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, sex);
			ps.setInt(4, age);
			ps.setInt(5, uid);
			//4、通过（预编译陈述对象）执行sql语句
			ps.executeUpdate();
			System.out.println("修改成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("加载注册mysql驱动失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("连接数据库失败");
		} finally {
			    //5、关闭数据库资源
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("关闭资源成功");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("关闭资源失败");
				}
		}
	}

	//删除用户
	public void delete(int uid){
		try {
			//1、加载注册mysql驱动
			Class.forName("com.mysql.jdbc.Driver");//驱动类
			System.out.println("加载注册mysql驱动成功");
			//2、通过(驱动管理器)获取（连接对象）
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功");
			//3、通过（连接对象）获取（预编译陈述对象）,并且设置sql
			String sql="delete from users where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			//4、通过（预编译陈述对象）执行sql语句
			ps.executeUpdate();
			System.out.println("删除成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("加载注册mysql驱动失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("连接数据库失败");
		} finally {
			    //5、关闭数据库资源
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("关闭资源成功");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("关闭资源失败");
				}
		}
	}

	//查询用户
	public void select(){
		try {
			//1、加载注册mysql驱动
			Class.forName("com.mysql.jdbc.Driver");//驱动类
			System.out.println("加载注册mysql驱动成功");
			//2、通过(驱动管理器)获取（连接对象）
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功");
			//3、通过（连接对象）获取（预编译陈述对象）,并且设置sql
			String sql="select * from users";
			ps=conn.prepareStatement(sql);
			//4、通过（预编译陈述对象）执行sql语句，获取结果集
			rs=ps.executeQuery();
			System.out.println("查询成功");
			//5、处理结果集
			while(rs!=null&&rs.next()){
				                 //列名
				int uid=rs.getInt("uid");
				String uname=rs.getString("uname");
				int age=rs.getInt("age");
				System.out.println("编号："+uid+"，姓名："+uname+"，年龄："+age);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("加载注册mysql驱动失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("---"+e.getErrorCode()+"=="+e.getSQLState());
			//e.printStackTrace();
			System.out.println("连接数据库失败");
		} finally {
			    //6、关闭数据库资源
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("关闭资源成功");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("关闭资源失败");
				}
		}
	}
	
	
	//添加：insert into 表名(列名) values(列值)
	//修改：update 表名 set 列名=新值  where 条件
	//删除：delete from 表名  where 条件
	//查询：select 列名 from 表名 where 条件
	
}

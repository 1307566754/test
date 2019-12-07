package jsp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	//�������Ӷ���
	Connection conn=null;
	//����Ԥ�����������
	PreparedStatement ps=null;
	//�������������
	ResultSet rs=null;
	//�����������ݿ��url��ַ
	          //      http://www.baidu.com
	          //��ҪЭ��:��ҪЭ��://������:�˿ں�/������
	String url="jdbc:mysql://localhost:3306/db1903";
	//�����������ݿ���û���
	String user="root";
	//�����������ݿ������
	String password="root";
	
	//����û�
	public boolean add(String uname,String upass,String sex,int age){
		boolean isOk=false;
		try {
			//1������ע��mysql����
			Class.forName("com.mysql.jdbc.Driver");//������
			System.out.println("����ע��mysql�����ɹ�");
			//2��ͨ��(����������)��ȡ�����Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("�������ݿ�ɹ�");
			//3��ͨ�������Ӷ��󣩻�ȡ��Ԥ�����������,��������sql
			String sql="insert into users values(null,?,?,?,?,null,null,null)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, sex);
			ps.setInt(4, age);
			//4��ͨ����Ԥ�����������ִ��sql���
			ps.executeUpdate();
			isOk=true;
			System.out.println("��ӳɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("����ע��mysql����ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("�������ݿ�ʧ��");
		} finally {
			    //5���ر����ݿ���Դ
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("�ر���Դ�ɹ�");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("�ر���Դʧ��");
				}
		}
		return isOk;
	}

	
	//�޸��û�
	public void update(int uid,String uname,String upass,String sex,int age){
		try {
			//1������ע��mysql����
			Class.forName("com.mysql.jdbc.Driver");//������
			System.out.println("����ע��mysql�����ɹ�");
			//2��ͨ��(����������)��ȡ�����Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("�������ݿ�ɹ�");
			//3��ͨ�������Ӷ��󣩻�ȡ��Ԥ�����������,��������sql
			String sql="update users set uname=?,upass=?,sex=?,age=? where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, sex);
			ps.setInt(4, age);
			ps.setInt(5, uid);
			//4��ͨ����Ԥ�����������ִ��sql���
			ps.executeUpdate();
			System.out.println("�޸ĳɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("����ע��mysql����ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("�������ݿ�ʧ��");
		} finally {
			    //5���ر����ݿ���Դ
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("�ر���Դ�ɹ�");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("�ر���Դʧ��");
				}
		}
	}

	//ɾ���û�
	public void delete(int uid){
		try {
			//1������ע��mysql����
			Class.forName("com.mysql.jdbc.Driver");//������
			System.out.println("����ע��mysql�����ɹ�");
			//2��ͨ��(����������)��ȡ�����Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("�������ݿ�ɹ�");
			//3��ͨ�������Ӷ��󣩻�ȡ��Ԥ�����������,��������sql
			String sql="delete from users where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			//4��ͨ����Ԥ�����������ִ��sql���
			ps.executeUpdate();
			System.out.println("ɾ���ɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("����ע��mysql����ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("�������ݿ�ʧ��");
		} finally {
			    //5���ر����ݿ���Դ
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("�ر���Դ�ɹ�");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("�ر���Դʧ��");
				}
		}
	}

	//��ѯ�û�
	public void select(){
		try {
			//1������ע��mysql����
			Class.forName("com.mysql.jdbc.Driver");//������
			System.out.println("����ע��mysql�����ɹ�");
			//2��ͨ��(����������)��ȡ�����Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("�������ݿ�ɹ�");
			//3��ͨ�������Ӷ��󣩻�ȡ��Ԥ�����������,��������sql
			String sql="select * from users";
			ps=conn.prepareStatement(sql);
			//4��ͨ����Ԥ�����������ִ��sql��䣬��ȡ�����
			rs=ps.executeQuery();
			System.out.println("��ѯ�ɹ�");
			//5����������
			while(rs!=null&&rs.next()){
				                 //����
				int uid=rs.getInt("uid");
				String uname=rs.getString("uname");
				int age=rs.getInt("age");
				System.out.println("��ţ�"+uid+"��������"+uname+"�����䣺"+age);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("����ע��mysql����ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("---"+e.getErrorCode()+"=="+e.getSQLState());
			//e.printStackTrace();
			System.out.println("�������ݿ�ʧ��");
		} finally {
			    //6���ر����ݿ���Դ
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
					System.out.println("�ر���Դ�ɹ�");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("�ر���Դʧ��");
				}
		}
	}
	
	
	//��ӣ�insert into ����(����) values(��ֵ)
	//�޸ģ�update ���� set ����=��ֵ  where ����
	//ɾ����delete from ����  where ����
	//��ѯ��select ���� from ���� where ����
	
}

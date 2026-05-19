package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.TestListSubject;

public class TestListSubjectDao extends DAO {
	
	//String baseSql= "select * from t where test school_cd = ? ";
	
	
	public List<TestListSubject> filter(String school, int entYear, String classNum, String subject) throws Exception {
		List<TestListSubject> list=new ArrayList<>();
		Map<String, TestListSubject> students = new HashMap<>();
		//String conditions = " and ent_year = ? and class_num = ? and subject = ?";
		//String order = " order by no asc ";
		//String conditionIsAttend = "";
		String sql =
				"select " +
				"t.no as test_no, " +
				"t.point, " +
				"t.student_no, " +
				"s.name, " +
				"s.ent_year, " +
				"s.class_num " +
				"from test t " + 
				"join student s on t.student_no = s.no " +
				"where t.school_cd = ? " +
				"and s.ent_year = ? " +
				"and t.class_num = ? " +
				"and t.subject_cd = ? " +
				"order by t.no asc ";
		
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, school);
		st.setInt(2, entYear);
		st.setString(3, classNum);
		st.setString(4, subject);
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			String studentNo = rs.getString("student_no");
			
			// すでに作ったかチェック
			TestListSubject s = students.get(studentNo);
			
			// 無ければ作る
			if (s == null) {
				s=new TestListSubject();
				s.setStudentNo(rs.getString("student_no"));
				s.setStudentName(rs.getString("name"));
				s.setEntYear(rs.getInt("ent_Year"));
				s.setClassNum(rs.getString("class_Num"));
				
				students.put(studentNo, s);
			}
			
			int no = rs.getInt("test_no");
			int point = rs.getInt("point");
			
			System.out.println("no=" + no + ", point=" + point);
			s.putPoint(no, point);
			System.out.println("PUT: " + no + " = " + point);
		}
		st.close();
		con.close();
		
		list.addAll(students.values());
		
		return list;
	}
	
}
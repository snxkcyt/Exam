package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListStudent;

public class TestListStudentDao extends DAO {
	
	//String baseSql= "select * from t where test school_cd = ? ";
	
	
	public List<TestListStudent> filter(String school, String studentNo) throws Exception {
		List<TestListStudent> list=new ArrayList<>();
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
				"s.class_num, " +
				"sub.name as subject_name," +
				"sub.cd as subject_cd " +
				"from test t " + 
				"join student s on t.student_no = s.no " +
				"join subject sub on t.subject_cd = sub.cd " +
				"where t.school_cd = ? " +
				"and t.student_no = ? " +
				"order by t.subject_cd, t.no ";
		
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, school);
		st.setString(2, studentNo);
		
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			
			TestListStudent s = new TestListStudent();
			
			s.setSubjectName(rs.getString("subject_name"));
			s.setSubjectCd(rs.getString("subject_cd"));
			s.setNum(rs.getInt("test_no"));
			s.setPoint(rs.getInt("point"));
			
			
			list.add(s);
		}
		st.close();
		con.close();
		
		
		return list;
	}
	
}
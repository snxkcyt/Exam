package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDAO extends DAO {
	
	String baseSql= "select * from student where school_cd = ?";

	public Student get(String no) throws Exception {
	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement(
	        "SELECT * FROM student WHERE no = ?"
	    );
	    st.setString(1, no);

	    ResultSet rs = st.executeQuery();

	    Student student = null;

	    if (rs.next()) {
	        student = new Student();
	        student.setNo(rs.getString("no"));
	        student.setName(rs.getString("name"));
	        student.setEntYear(rs.getInt("ent_year"));
	        student.setClassNum(rs.getString("class_num"));
	        student.setAttend(rs.getBoolean("is_attend"));
	        student.setSchool(rs.getString("school_cd"));
	    }

	    st.close();
	    con.close();

	    return student;
	}
	
	public List<Student> postFilter(ResultSet ResultSet,School school) throws Exception{
		return null;
	}
	public List<Student> filter(String school_cd,int entYear,String classNum,boolean isAttend) throws Exception{
		// リストを初期化
		List<Student> list = new ArrayList<>();
		// SQL文の条件
		String conditions = " and ent_year = ? and class_num = ?";
		String order = " order by no asc";
		// SQL文を在学フラグ
		String conditionIsAttend = "";
		// 在学フラグがtrueの場合
		if (isAttend) {
			conditionIsAttend = " and is_attend = true";
		}
		Connection con=getConnection();
		// プリペアードステートメントにSQL文をセット
		PreparedStatement st = con.prepareStatement(baseSql + conditions + conditionIsAttend + order);
		// プリペアードステートメントにバインド
		st.setString(1, school_cd);
		st.setInt(2, entYear);
		st.setString(3, classNum);

		// プリペアードステートメントを実行
		ResultSet resultSet=st.executeQuery();
		// リストへの格納処理を実行
		while (resultSet.next()) {
			// 学生インスタンスを初期化
			Student student = new Student();
			// 学生インスタンスに検索結果をセット
			student.setNo(resultSet.getString("no"));
			student.setName(resultSet.getString("name"));
			student.setEntYear(resultSet.getInt("ent_year"));
			student.setClassNum(resultSet.getString("class_num"));
			student.setAttend(resultSet.getBoolean("is_attend"));
			student.setSchool(resultSet.getString("school_cd"));
			// リストに追加
			list.add(student);
		}
		st.close();
		con.close();
		System.out.println(list);
		return list;
		
	}
	public List<Student> filter(String school_cd,int entYear,boolean isAttend) throws Exception{
		// リストを初期化
		List<Student> list = new ArrayList<>();
		// SQL文の条件
		String conditions = " and ent_year = ? ";
		String order = " order by no asc";
		// SQL文を在学フラグ
		String conditionIsAttend = "";
		// 在学フラグがtrueの場合
		if (isAttend) {
			conditionIsAttend = " and is_attend = true";
		}
		Connection con=getConnection();
		// プリペアードステートメントにSQL文をセット
		PreparedStatement st = con.prepareStatement(baseSql + conditions + conditionIsAttend + order);
		// プリペアードステートメントにバインド
		st.setString(1, school_cd);
		st.setInt(2, entYear);
		// プリペアードステートメントを実行
		ResultSet resultSet=st.executeQuery();
		// リストへの格納処理を実行
		while (resultSet.next()) {
			// 学生インスタンスを初期化
			Student student = new Student();
			// 学生インスタンスに検索結果をセット
			student.setNo(resultSet.getString("no"));
			student.setName(resultSet.getString("name"));
			student.setEntYear(resultSet.getInt("ent_year"));
			student.setClassNum(resultSet.getString("class_num"));
			student.setAttend(resultSet.getBoolean("is_attend"));
			student.setSchool(resultSet.getString("school_cd"));
			// リストに追加
			list.add(student);
		}
		st.close();
		con.close();
		return list;
	}
	public List<Student> filter(String school_cd,boolean isAttend) throws Exception{
		
		// リストを初期化
		List<Student> list = new ArrayList<>();
		// SQL文の条件
		String order = "order by no asc";
		// SQL文を在学フラグ
		String conditionIsAttend = "";
		// 在学フラグがtrueの場合
		if (isAttend) {
			conditionIsAttend = "and is_attend = true ";
		}
		Connection con=getConnection();
		// プリペアードステートメントにSQL文をセット
		PreparedStatement st = con.prepareStatement(baseSql + conditionIsAttend + order);
		// プリペアードステートメントに学校コードをバインド
		st.setString(1, school_cd);
		// プリペアードステートメントを実行
		ResultSet resultSet=st.executeQuery();
		// リストへの格納処理を実行
		while (resultSet.next()) {
			// 学生インスタンスを初期化
			Student student = new Student();
			// 学生インスタンスに検索結果をセット
			student.setNo(resultSet.getString("no"));
			student.setName(resultSet.getString("name"));
			student.setEntYear(resultSet.getInt("ent_year"));
			student.setClassNum(resultSet.getString("class_num"));
			student.setAttend(resultSet.getBoolean("is_attend"));
			student.setSchool(resultSet.getString("school_cd"));
			// リストに追加
			list.add(student);
		}
		st.close();
		con.close();
		return list;	
	}
    //新規登録
    public int insert(Student student) throws Exception {
        Connection con=getConnection();

        PreparedStatement st=con.prepareStatement(
            "insert into student(no, name, ent_year, class_num, is_attend, school_cd ) values(?, ?, ?, ?, ?, ?)");
        st.setString(1, student.getNo());
        st.setString(2, student.getName());
        st.setInt(3, student.getEntYear());
        st.setString(4, student.getClassNum());
        st.setBoolean(5, student.isAttend());
        st.setString(6, student.getSchool()); //ログイン中TEACHERの学校コードを取得;
        int line=st.executeUpdate();

        st.close();
        con.close();
        return line;
    }

    //更新
    public int update(Student student) throws Exception {
        Connection con=getConnection();

        PreparedStatement st=con.prepareStatement(
            "UPDATE student "
            + "SET name = ?,"
            + "    class_num = ?,"
            + "    is_attend = ?,"
            + "    school_cd = ?"
            + "WHERE no = ?;");
        
        st.setString(1, student.getName());
        st.setString(2, student.getClassNum());
        st.setBoolean(3, student.isAttend());
        st.setString(4, student.getSchool());

        st.setString(5, student.getNo());
        
        int line=st.executeUpdate();

        st.close();
        con.close();
        return line;
    	
    	
    }
    
	public boolean save(Student student) throws Exception {
		return false;		
	}
	
}
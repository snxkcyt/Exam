package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.Subject;

public class SubjectDAO extends DAO {
	
	// 変更
    public int update(Subject subject) throws Exception {
        Connection con=getConnection();

        PreparedStatement st=con.prepareStatement(
            "UPDATE subject SET school_cd = ?, name = ? WHERE cd = ?;");
        
        st.setString(1, subject.getSchool());
        st.setString(2, subject.getName());
        st.setString(3, subject.getCd());
        
        int line=st.executeUpdate();

        st.close();
        con.close();
        return line;
    	
    	
    }
	
    // 削除
    public int delete(Subject subject) throws Exception {
        
        String sql = "DELETE FROM subject WHERE cd = ?";

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            
           st.setString(1, subject.getCd());
           
           return st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return 0;
       
    }

    public List<Subject> filter(String school) throws Exception{
		// リストを初期化
		List<Subject> list = new ArrayList<>();
		Connection con=getConnection(); 
		// プリペアードステートメントにSQL文をセット
		PreparedStatement st = con.prepareStatement("select * from subject where school_cd=?");
		// プリペアードステートメントに学校コードをバインド
		st.setString(1, school);
		// プリペアードステートメントを実行
		ResultSet rs=st.executeQuery();
		// リストへの格納処理を実行
		while (rs.next()) {
	        Subject s = new Subject();
	        s.setCd(rs.getString("cd"));
	        s.setName(rs.getString("name"));
	        s.setSchool(rs.getString("school_cd"));
	        list.add(s);
	    }
		rs.close();
		st.close();
		con.close();
		return list;
	}

	public boolean save(ClassNum classNum) throws Exception {
		return false;		
	}	
	public boolean save(ClassNum classNum,String newClassNum) throws Exception {
		return false;		
	}	

}

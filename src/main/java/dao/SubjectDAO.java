package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Subject;

public class SubjectDAO extends DAO {
	
	// 変更
    public int update(Subject subject) throws Exception {
        Connection con=getConnection();

        PreparedStatement st=con.prepareStatement(
            "UPDATE subject SET school_cd = ? name = ? WHERE cd = ?;");
        
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
}
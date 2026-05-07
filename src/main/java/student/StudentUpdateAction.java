package student;


import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	    HttpSession session = request.getSession();
	    Teacher teacher = (Teacher) session.getAttribute("teacher");

	    // パラメータ取得
	    String no = request.getParameter("no");
	    String name = request.getParameter("name");

	    // 入学年度
	    String entYearStr = request.getParameter("ent_year");
	    int ent_year = 0;
	    if (entYearStr != null && !entYearStr.isEmpty()) {
	        ent_year = Integer.parseInt(entYearStr);
	    }

	    // クラス番号
	    String classNum = request.getParameter("class_num");

	    // 在学中，チェックされていればtrue，されてなければnull
	    boolean isAttend = request.getParameter("is_attend") != null;

	    // Student にセット
	    Student student = new Student();
	    student.setNo(no);
	    student.setName(name);
	    student.setEntYear(ent_year);
	    student.setClassNum(classNum);
	    student.setAttend(isAttend);
	    student.setSchool(teacher.getSchool());

	    // DAOで登録
	    StudentDAO dao = new StudentDAO();
	    int count = dao.update(student);

	    if (count > 0) {
	        request.getRequestDispatcher("student_update_done.jsp")
	               .forward(request, response);
	    } else {
	        request.setAttribute("message", "更新失敗");
	        request.getRequestDispatcher("student_update.jsp")
	               .forward(request, response);
	    }
	}
}
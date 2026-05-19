package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Subject;
import bean.Teacher;
import bean.TestListSubject;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import dao.TestListSubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {
	public void execute(
			HttpServletRequest request, HttpServletResponse response
			) throws Exception {
				
				Teacher teacher = new Teacher();
				//StudentDao studentdao = new StudentDao();
				SubjectDAO subjectdao = new SubjectDAO();
				TestListSubjectDao testlistsubjectdao = new TestListSubjectDao();
				ClassNumDAO classnumdao = new ClassNumDAO();
				Map<String, String> errors = new HashMap<>();
				
				HttpSession session=request.getSession();
				teacher = (Teacher)session.getAttribute("teacher");
				List<TestListSubject> list = null;
				
				
				String entYearStr = request.getParameter("f1");
				String classNum = request.getParameter("f2");
				String subject = request.getParameter("f3");
				
				
				if (
					entYearStr != null && !entYearStr.equals("0") &&
					classNum != null && !classNum.equals("0") &&
					subject != null && !subject.equals("0")
					) {
					int entYear = Integer.parseInt(entYearStr);
					
					System.out.println("school=" + teacher.getSchool());
				    System.out.println("entYear=" + entYear);
				    System.out.println("classNum=" + classNum);
				    System.out.println("subject=" + subject);
					
					list = testlistsubjectdao.filter(teacher.getSchool(), entYear, classNum, subject);	
					} 
					else {
						errors.put("search", "科目情報を選択または学生情報を入力して検索ボタンをクリックしてください");
					}
				List<String> classnum = classnumdao.filter(teacher.getSchool());
				List<Subject> subjectnum = subjectdao.filter(teacher.getSchool());
				String subjectName = "";
				for (Subject s : subjectnum) {
					if (s.getCd().equals(subject)) {
						subjectName = s.getName();
						break;
					}
				}
				System.out.println("school=" + teacher.getSchool());
				request.setAttribute("subjectName", subjectName);
				request.setAttribute("list", list);
				request.setAttribute("classnum", classnum);
				request.setAttribute("subjectnum", subjectnum);
				request.setAttribute("subject", subject);
				request.setAttribute("errors", errors);
				
				request.getRequestDispatcher("test_list_subject.jsp").forward(request, response);
				
	
	
	


}
}
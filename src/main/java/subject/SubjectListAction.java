package subject;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectListAction extends Action {

    public void execute(
            HttpServletRequest request, HttpServletResponse response
        )throws Exception{

        HttpSession session = request.getSession();

        Teacher teacher = (Teacher)session.getAttribute("teacher");

        String schoolCd = teacher.getSchool();

        SubjectDAO subDao = new SubjectDAO();

        List<Subject> subjectList = subDao.filter(schoolCd);

        request.setAttribute("subjectList", subjectList);

        request.getRequestDispatcher("/subject/subject_list.jsp").forward(request, response);
    }
}
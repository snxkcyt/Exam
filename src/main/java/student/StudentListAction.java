package student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentListAction extends Action {
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		Teacher teacher = new Teacher(); //セッションのteacherを取り出すため
		StudentDAO studentDAO = new StudentDAO();//studentテーブルアクセスのため
		ClassNumDAO classnumDAO = new ClassNumDAO();//classnumテーブルアクセスのため
		List<Student> list = null;//学生一覧保存用
		Map<String, String> errors = new HashMap<>(); // エラーメッセージ用マップ
		
		HttpSession session=request.getSession();//セッション利用
		teacher = (Teacher)session.getAttribute("teacher");//セッションからteacher取り出し

		boolean isAttend=false;
		int entYear=0;//年度
		
		//2回目以降の処理で使用する
		String entYearStr = request.getParameter("f1");//年度
		String classNum = request.getParameter("f2");//クラス番号
		String isAttendStr = request.getParameter("f3");//在学中チェック
	
		if (entYearStr != null && !entYearStr.isEmpty()) {//入学年度が指定されている場合
			// 数値に変換
			entYear = Integer.parseInt(entYearStr);
		}
		if (isAttendStr != null) { // 在学フラグにチェックが入っている場合
			// 在学フラグをtrueに変換
			isAttend = true;
		}
		if (entYear != 0 && !classNum.equals("0")) { //入学年度とクラス番号が指定されている場合
			list = studentDAO.filter(teacher.getSchool(), entYear, classNum, isAttend);
		
		}else if (entYear != 0 && (classNum.equals("0"))) { //入学年度だけ指定されている場合
			list = studentDAO.filter(teacher.getSchool(), entYear, isAttend);
		
		}else if (entYear == 0 && (classNum == null || entYear == 0 && classNum.equals("0"))){ //初期状態
			list = studentDAO.filter(teacher.getSchool(),isAttend);
			
		}else { //それ以外（クラス番号だけ指定した場合）
			errors.put("f1", "クラスを指定する場合は入学年度も指定してください");
			// リクエストにエラーメッセージをセット
			request.setAttribute("errors", errors);
			list=studentDAO.filter(teacher.getSchool(),isAttend);//何も指定されていない場合			
 		}
		//List<String> classnum = classnumDAO.filter(School school);
		List<String> classnum = classnumDAO.filter(teacher.getSchool());
		//dao実行の結果、↑クラス番号取得

		request.setAttribute("list",list);//リクエスト属性へ保存
		request.setAttribute("classnum",classnum);//リクエスト属性へ保存
		
		System.out.println("entYear=" + entYear);
		System.out.println("classNum=" + classNum);
		System.out.println("isAttend=" + isAttend);
		System.out.println("teacher=" + teacher.getSchool());

		request.getRequestDispatcher("student_list.jsp").forward(request, response);//フォワード
	}
}

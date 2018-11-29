package coffee.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.commad.inter.CommandProcess;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "*.do" }, initParams = {
		@WebInitParam(name = "propertyConfig", value = "command.properties") })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property";

		ServletContext context = config.getServletContext(); // ���� �� ���ø����̼ǿ� ��θ� ��� ����
		String realPath = context.getRealPath(realFolder) + "\\" + props;

		Properties pr = new Properties();
		FileInputStream f = null;

		try {
			f = new FileInputStream(realPath);
			pr.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		Iterator<?> keyIter = pr.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			System.out.println("init" + command);
			String className = pr.getProperty(command);
			try {
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				//throw new ServletException();
				e.printStackTrace();
			} catch (InstantiationException e) {
				//throw new ServletException();
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				//throw new ServletException();
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		requestPro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String view = null;
		CommandProcess com = null;

		try {
			String command = request.getRequestURI();
			System.out.println("command: "+command);
			if (command.indexOf(request.getContextPath()) == 0)
				command = command.substring(request.getContextPath().length());
			com = (CommandProcess) commandMap.get(command);
			view = com.requestPro(request, response);
			System.out.println("view : " + view);
		} catch (Throwable e) {
			e.printStackTrace();
		}
//		request.setAttribute("cont", view);
//		response.getWriter().append(view).toString();
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}
	/*
	 * 의문점 : ajax로 처리된 데이터로  success 프로퍼티에서 처리할때 자바는 response.getWriter().append() 이런식으로 
	 *처리를 해야 하는데 포워딩 시키면 거기에 있는 html 문서로 부터 값이 data 로 담기기 때문에 처리하기가 힘들어진다 .
	 *location.href=""로 보내야 하는건지 일반적으로 포워딩으로 넘겨야 하는지 모르겠다 .
	 * 
	 */

}

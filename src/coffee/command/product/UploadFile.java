package coffee.command.product;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class UploadFile implements CommandProcess {

	public UploadFile() {
		// TODO Auto-generated constructor stub
		System.out.println("파일 업로드 되냐 ㅅㅂ");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("요청되니?");

		String filename = "";
		String realFolder = ""; // 웹 애플리케이션상의 절대 경로 저장
		String encType = "utf-8";
		String saveFolder = "/images"; // 파일 업로드 파일 지정
		int maxSize = 100 * 1024 * 1024; // 최대 업로드 파일 크기 100MB

		MultipartRequest imageUp = null;

		// 웹 애플리케이션 상의 절대 경로를 구함
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);

		try {
			// 파일 업로드를 수행하는 MultipartRequest 객체 생성
			imageUp = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

			// <input type="file">인 모든 파라미터를 얻어냄
			Enumeration<?> files = imageUp.getFileNames();

			// 파일 정보가 있따면
			while (files.hasMoreElements()) {
				// input 태그의 속성이 file인 태그의 name 속성값 : 파라미터 이름
				String name = (String) files.nextElement();

				// 서버에 저장된 파일 이름
				filename = imageUp.getFilesystemName(name);
				
				System.out.println("fuck");
				
			}
		} catch (Exception e) {
			System.out.println("파일 경로 구하기 실패");
		}
		System.out.println("fuck");
		// 폼으로 부터 넘어온 정보 중 파일이 아닌 정보를 얻어냄
		ProductDataBean product = ProductDataBean.getINSTANCE();
		String pName = imageUp.getParameter("filName");
		String pPath = filename;
		
		String pPrice = imageUp.getParameter("filePrice");
		String ct_code = imageUp.getParameter("category");
		System.out.println("pName" + pName);
		System.out.println("pPath" + pPath);
		System.out.println("가격 : " + pPrice);
		System.out.println("카테고리 : " + ct_code);
		
		

		product.insertPrpduct(pName, pPath, pPrice, ct_code);

		return "/mng/managerMenu.jsp";
	}

}

package com.tutorial.spring;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.spring.dao.CategoryDAO;
import com.tutorial.spring.dao.ImageDAO;
import com.tutorial.spring.dao.MembersDAO;
import com.tutorial.spring.dao.ProductDAO;
import com.tutorial.spring.dto.CategoryVO;
import com.tutorial.spring.dto.ImageVO;
import com.tutorial.spring.dto.MembersVO;
import com.tutorial.spring.dto.ProductVO;

@Controller
public class HomeController {

	// 루트컨테이너에 존재하는 Bean을 주입하고 싶을 땐 @Inject 어노테이션을 활용.
	@Inject
	private DataSource dataSource;
	@Inject
	private SqlSessionFactory sqlFactory;
	@Resource
	private MembersDAO member;
	@Resource
	private ProductDAO product;
	@Resource
	private CategoryDAO category;
	@Resource
	private ImageDAO imageDAO;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<ProductVO> pList = product.selectLimit(0);
		model.addAttribute("pList", pList);
		
		List<CategoryVO> categoryList = category.selectAll();
		model.addAttribute("categoryList", categoryList);

		return "index";
	}
	
	@RequestMapping(value="/products/{productPage}")
	public String products(@PathVariable("productPage") int productPage, Model model) {
		int startIdx = 6*(productPage-1);
		List<ProductVO> pList = product.selectLimit(startIdx);
		model.addAttribute("pList", pList);
		
		List<CategoryVO> categoryList = category.selectAll();
		model.addAttribute("categoryList", categoryList);
		
		return "index";
	}
	
	@RequestMapping(value="/category/{categoryId}")
	public String category(@PathVariable("categoryId") int categoryId, Model model) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("categoryId", categoryId);
		hm.put("page", 0);
		List<ProductVO> productList = product.selectCategory(hm);
		model.addAttribute("productList", productList);
		
		List<CategoryVO> categoryList = category.selectAll();
		int totalPageNo = product.selectRowCnt(categoryId)/6;

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("totalPageNo", totalPageNo);
		
		return "products";
	}
	
	@RequestMapping(value="/category/paging", method=RequestMethod.POST)
	@ResponseBody
	public List<ProductVO> paging(@RequestBody HashMap<String, Object> dataTransfer) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("categoryId", dataTransfer.get("categoryId"));
		hm.put("page", dataTransfer.get("page"));
		List<ProductVO> productList = product.selectCategory(hm);
		
		return productList;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String testGet() {
		return "test";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String testPost(@RequestParam("imgFile") MultipartFile image, ImageVO imageVO) throws IllegalStateException, IOException {
		String originName = image.getOriginalFilename();	//원본파일이름
		String ext = FilenameUtils.getExtension(originName);	//확장자
		UUID uuid = UUID.randomUUID();
		String fileName = uuid+"."+ext;
		image.transferTo(new File("C:\\study\\spring2\\tutorial\\src\\main\\resources\\upload_images\\" + fileName));
		
		imageDAO.insertImage(imageDAO.selectMaxImageId()+1, fileName);
		return "test";
	}
	// /list1 URI에 대한 요청 처리 - dataSource
//	@RequestMapping(value = "/list1")
//	public String home2() {
//		
//		try {
//			Connection conn = (Connection) dataSource.getConnection();
//		System.out.println("성공 : " + conn);
//		
//		} catch (Exception ex){
//			System.out.println("실패..!");
//			ex.printStackTrace();
//		}
//		
//		return "list1";
//	}
	
	// "/list1 URI에 대한 요청 처리 - Session
//	@RequestMapping(value = "/list2")
//	public String home3() {
//		
//		try {
//			SqlSession session = sqlFactory.openSession();
//			System.out.println("성공 : " + session);
//				
//		} catch (Exception ex){
//			System.out.println("실패..!");
//			ex.printStackTrace();
//		}
//		
//		return "list2";
//	}
	
//	@RequestMapping(value="/members", method= {RequestMethod.GET, RequestMethod.POST})
//	public String members(Model model, HttpServletRequest request, @RequestParam(defaultValue="") String email) {
//		if (request.getMethod().equals("POST")) {
//			member.insert(email);
//		}
//		List<MembersVO> m = member.selectAll();
//		String emails = "";
//		
//		for (int i=0; i<m.size(); i++) {
//			emails += m.get(i).getEmail() + "<br>";
//		}
//		model.addAttribute("email", emails);
//		
//		return "members";
//	}
//	
//	@RequestMapping(value="/member")
//	public String member() {
//		return "member";
//	}
	
	
}
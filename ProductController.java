package jp.co.internous.quest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.quest.model.domain.MstProduct;
import jp.co.internous.quest.model.mapper.MstProductMapper;
import jp.co.internous.quest.model.session.LoginSession;

/**
 * 商品情報の詳細に関する処理を行うコントローラー
 * @author Ninomiya-Takahito
 *
 */
@Controller
@RequestMapping("/quest/product")
public class ProductController {

	@Autowired
	private MstProductMapper mstProductMapper;

	@Autowired
	private LoginSession loginSession;

	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model model) {
		// 商品情報を取得
		MstProduct product = mstProductMapper.findById(id);
		model.addAttribute("product",product);
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		model.addAttribute("loginSession",loginSession);

		return "product_detail";
	}
}

package com.example.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("search")
public class SearchController {

	//検索欄結果一覧表示
	@GetMapping
	public String searchList() {
		//キーワードで検索

		//画面に返す
		return "search/search";
	}

	//製作年結果一覧表示

	//ジャンル結果一覧表示
}

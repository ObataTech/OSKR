package com.example.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Filmwork;
import com.example.utility.FilmworkDetail;

@Controller
@RequestMapping("search")
public class SearchController {

	private SearchService searchService;

	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

//	作品一覧
	@GetMapping
	public String searchList(Model model) {
		List<FilmworkDetail> filmworks = this.searchService.listAll();
		model.addAttribute("filmworks", filmworks);
		return "search/search";
	}

	//検索欄結果一覧表示
	@GetMapping("keyword")
	public String searchList(@RequestParam (value ="keyword", required = false) String keyword,Model model) {
		List<FilmworkDetail> filmworks =null;
		//キーワードで検索
		//検索キーワードの入力がある場合
		if(keyword != null && !keyword.isEmpty()) {
			filmworks = this.searchService.listAllKeyword(keyword);
		}
		//画面に返す
		model.addAttribute("keyword", keyword);
		model.addAttribute("filmworks", filmworks);
		return "search/search";
	}

	//製作年結果一覧表示
	@GetMapping("year")
	public String searchYear(@RequestParam (value ="year") String year,Model model) {
		List<FilmworkDetail> filmworks = this.searchService.listAllYear(year);

		//画面に返す
		model.addAttribute("keyword",year+"年公開");
		model.addAttribute("filmworks", filmworks);
		return "search/search";
	}

	//ジャンル結果一覧表示
	@GetMapping("category")
	public String searchCategory(@RequestParam (value ="category") String category,Model model) {
		List<FilmworkDetail> filmworks = this.searchService.listAllCategory(category);
		//画面に返す
		model.addAttribute("keyword", category);
		model.addAttribute("filmworks", filmworks);
		return "search/search";
	}
}

package com.animal.catcat.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.animal.catcat.domain.repository.Url;
import com.animal.catcat.domain.service.RestService;

@Controller
public class ResultController {
	
	@Autowired
	RestService service;
	Url url;
	
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@PostMapping("/index")
	public String getResult(Model model) {
		
		// 受け取った文字列を使ってAPIを実行して返ってきたURLを取得する
		// 返ってくるときはJSON形式のため、不要な[]と""を取り除く。
		url = service.apiExecute();
		
		// APIの実行結果をmodelに格納
		model.addAttribute("url", url.getFile());
		System.out.println(url.getFile());
		
		return "index";
	}

}

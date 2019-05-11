package br.com.projuris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myFindChar")
public class MyFindCharEndpoint {

	@Autowired
	private FindCharachter findCharachter;
	
	@GetMapping("/findString")
	public char findCharachter(@RequestParam String word) {
		
		return findCharachter.findChar(word);
	}
}

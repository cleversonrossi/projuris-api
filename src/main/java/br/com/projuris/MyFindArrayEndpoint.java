package br.com.projuris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myArray")
public class MyFindArrayEndpoint {

	@Autowired
	private FindArray findArray;
	
	@GetMapping
	public int findArray() {
		
		return findArray.findArray(new int[] {4,9,3,7,8,3,7,1}, new int[] {3,7} );
	}
}

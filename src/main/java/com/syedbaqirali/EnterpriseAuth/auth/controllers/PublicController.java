/**
 * 
 */
package com.syedbaqirali.EnterpriseAuth.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SBA
 *
 */

@RestController
public class PublicController {

	@GetMapping("/")
	public String getAllUsers() {
		return ("<h1>Welcome</h1>");

	}

}

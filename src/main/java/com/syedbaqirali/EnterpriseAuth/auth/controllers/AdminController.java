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
public class AdminController {

	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");

	}

}

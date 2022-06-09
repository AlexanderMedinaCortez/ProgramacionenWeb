package com.hampcode.controller;



import javax.validation.Valid;

import com.google.gson.Gson;
import com.hampcode.entity.Affiliate;
import com.hampcode.service.impl.AffiliateService;
import com.hampcode.service.impl.CountryService;
import com.hampcode.service.impl.DepartmentService;
import com.hampcode.service.impl.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/affiliates")
public class AffiliateController {

	@Autowired
	private AffiliateService affiliateService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CountryService countryService;

	@GetMapping
	public String showAllAffiliates(Model model) {
		model.addAttribute("affiliates", affiliateService.getAll());
		return "affiliates/list";
	}

	@GetMapping("/new")
	public String newAffiliateForm(Model model) {
		model.addAttribute("affiliate", new Affiliate());
		model.addAttribute("countries", countryService.getAllCountry());
		return "affiliates/new";
	}

	@PostMapping("/save")
	public String saveNewAffiliate(@Valid Affiliate affiliate, BindingResult result, Model model,
			SessionStatus status) {
		try {
			if (result.hasErrors()) {
				return "affiliates/new";
			}
			affiliateService.create(affiliate);
			status.setComplete();
		} catch (Exception e) {

		}

		return "redirect:/affiliates";
	}

	@GetMapping("/edit/{id}")
	public String editAffiliateForm(@PathVariable("id") long id, Model model) {
		Affiliate affiliate = affiliateService.getOneById(id);
		model.addAttribute("affiliate", affiliate);
		model.addAttribute("countries", countryService.getAllCountry());
		model.addAttribute("departments", departmentService.getAllDeparmentByCountry(affiliate.getCountry().getId()));
		model.addAttribute("provinces", provinceService.getAllProvinceByDeparment(affiliate.getDepartment().getId()));
		return "affiliates/edit";
	}

	@PostMapping("/update/{id}")
	public String updateAffiliate(@PathVariable("id") long id, Affiliate affiliate) {
		affiliateService.update(id, affiliate);
		return "redirect:/affiliates";
	}
	
	@ResponseBody
	@RequestMapping(value = "loadDeparmentByCountry/{id}", method = RequestMethod.GET)
	public String loadStatesByCountry(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(departmentService.getAllDeparmentByCountry(id));
	}

	@ResponseBody
	@RequestMapping(value = "loadProvinceByDeparment/{id}", method = RequestMethod.GET)
	public String loadCitiesByState(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(provinceService.getAllProvinceByDeparment(id));
	}


}

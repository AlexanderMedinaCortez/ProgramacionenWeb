package com.hampcode.controller;

import java.util.List;

import javax.validation.Valid;

import com.hampcode.entity.Affiliate;
import com.hampcode.entity.TypeAffiliate;
import com.hampcode.entity.User;
import com.hampcode.service.AffiliateService;
import com.hampcode.service.TypeAffiliateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/affiliates")
public class AffiliateController {

	@Autowired
	private AffiliateService affiliateService;

	@Autowired
	private TypeAffiliateService typeAffiliateService;

	@GetMapping
	public String showAllAffiliates(Model model) {
		model.addAttribute("affiliates", affiliateService.getAll());
		model.addAttribute("typeAffiliates", typeAffiliateService.getAll());
		return "affiliates/list";
	}

	@GetMapping("/new")
	public String newAffiliateForm(Model model) {
		model.addAttribute("affiliate", new Affiliate());
		List<TypeAffiliate> typeAffiliates = typeAffiliateService.getAll();
		model.addAttribute("typeAffiliates", typeAffiliates);
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
		List<TypeAffiliate> typeAffiliates = typeAffiliateService.getAll();
		model.addAttribute("typeAffiliates", typeAffiliates);
		return "affiliates/edit";
	}

	@PostMapping("/update/{id}")
	public String updateAffiliate(@PathVariable("id") long id, Affiliate affiliate) {
		affiliateService.update(id, affiliate);
		return "redirect:/affiliates";
	}

	@GetMapping("/typeaffiliate/list/{id}")
	public String typeAffiliateForm(@PathVariable("id") long id, Model model) {
		Affiliate affiliate = affiliateService.getOneById(id);
		model.addAttribute("affiliate", affiliate);
		List<TypeAffiliate> typeAffiliates = typeAffiliateService.getAll();
		model.addAttribute("typeAffiliates", typeAffiliates);
		return "affiliates/typeaffiliates/list";
	}

	@GetMapping("/typeaffiliate/new/{id}")
	public String typeAffiliateNewForm(@PathVariable("id") long id, Model model) {
		Affiliate affiliate = affiliateService.getOneById(id);
		model.addAttribute("affiliate", affiliate);
		List<TypeAffiliate> typeAffiliates = typeAffiliateService.getAll();
		model.addAttribute("typeAffiliates", typeAffiliates);
		return "affiliates/typeaffiliates/new";
	}

}

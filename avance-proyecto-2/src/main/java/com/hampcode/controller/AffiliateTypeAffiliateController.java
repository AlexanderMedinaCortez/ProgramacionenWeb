package com.hampcode.controller;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.hampcode.entity.Affiliate;
import com.hampcode.entity.AffiliateTypeAffiliate;
import com.hampcode.entity.TypeAffiliate;
import com.hampcode.service.impl.AffiliateService;
import com.hampcode.service.impl.AffiliateTypeAffiliateService;
import com.hampcode.service.impl.TypeAffiliateService;

@Controller
@RequestMapping("/affiliateTypeAffiliates")
public class AffiliateTypeAffiliateController {

	@Autowired
	private AffiliateTypeAffiliateService affiliateTypeAffiliateService;

	@Autowired
	private AffiliateService  affiliateService;

	@Autowired
	private TypeAffiliateService typeAffiliateService;

	@GetMapping
	public String showAllAffiliates(Model model) {

		model.addAttribute("affiliateTypeAffiliate", new AffiliateTypeAffiliate());
		model.addAttribute("affiliateTypeAffiliates", affiliateTypeAffiliateService.getAll());
		return "affiliateTypeAffiliates/list";
	}

	@GetMapping("/new")
	public String newAffiliateForm(Model model) {
		model.addAttribute("affiliateTypeAffiliate", new AffiliateTypeAffiliate());
		List<Affiliate> affiliates = affiliateService.getAll();
		model.addAttribute("affiliates", affiliates);
		List<TypeAffiliate> typeAffiliates = typeAffiliateService.getAll();
		model.addAttribute("typeAffiliates", typeAffiliates);
		return "affiliateTypeAffiliates/new";
	}

	@PostMapping("/save")
	public String saveNewAffiliates(@Valid AffiliateTypeAffiliate affiliateTypeAffiliate, BindingResult result,
			Model model, SessionStatus status) {
		try {
			if (result.hasErrors()) {
				return "affiliateTypeAffiliates/new";
			}
			affiliateTypeAffiliateService.create(affiliateTypeAffiliate);
			status.setComplete();
		} catch (Exception e) {

		}

		return "redirect:/affiliateTypeAffiliates";
	}

	@GetMapping("/edit/{id}")
	public String editAffiliateForm(@PathVariable long id, Model model) {
		AffiliateTypeAffiliate affiliateTypeAffiliate = affiliateTypeAffiliateService.getOneById(id);

		List<Affiliate> affiliates = affiliateService.getAll();
		model.addAttribute("affiliates", affiliates);
		List<TypeAffiliate> typeAffiliates = typeAffiliateService.getAll();
		model.addAttribute("typeAffiliates", typeAffiliates);

		model.addAttribute("affiliateTypeAffiliate", affiliateTypeAffiliate);
		return "affiliateTypeAffiliates/edit";
	}

	@PostMapping("/update/{id}")
	public String updateAffiliate(@PathVariable long id, AffiliateTypeAffiliate affiliateTypeAffiliate) {
		affiliateTypeAffiliateService.update(id, affiliateTypeAffiliate);
		return "redirect:/affiliateTypeAffiliates";
	}

	@GetMapping("/delete/{id}")
	public String deleteAffiliate(@PathVariable long id, AffiliateTypeAffiliate affiliateTypeAffiliate) {
		affiliateTypeAffiliateService.delete(id);
		return "redirect:/affiliateTypeAffiliates";
	}

	@PostMapping("/find")
	public String findForDateAffiliate(Model model, @ModelAttribute AffiliateTypeAffiliate affiliateTypeAffiliate) {
		model.addAttribute("affiliateTypeAffiliates", affiliateTypeAffiliateService.findByDate(affiliateTypeAffiliate.getStartDate(), affiliateTypeAffiliate.getFinishDate()));
		return "affiliateTypeAffiliates/list";
	}
}

package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Expert;
import by.gstu.choicecamera.domain.Manufacturers;
import by.gstu.choicecamera.service.ExpertService;
import by.gstu.choicecamera.util.SessionUtil;
import by.gstu.choicecamera.util.Tuple;
import by.gstu.choicecamera.web.validator.ExpertFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class ExpertController {

	@Autowired
	public ExpertService expertService;

	@Autowired
	ExpertFormValidator expertFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(expertFormValidator);
	}

	@RequestMapping("/expert")
	public String expert(Model model) {

		Expert expert = expertService.get(SessionUtil.getSessionUser());
		model.addAttribute("expert", expert);
		return "expert/table";
	}

	// update marks
	@RequestMapping(value = "/expert/api/marks", method = RequestMethod.POST)
	public String editMarks(@ModelAttribute("expertForm") @Validated Expert expert,
							BindingResult result, Model model, final RedirectAttributes redirectAttributes, Locale locale) {

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "expert/evaluateCriteria";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
			bean.setBasename("messages");
			String msg = bean.getMessage("msg.marks_updated_successfully", null, locale);
			redirectAttributes.addFlashAttribute("msg", msg);
			expertService.edit(expert);

			// POST/REDIRECT/GET
			return "redirect:/expert";
		}
	}

	// show edit form
	@RequestMapping(value = "/expert/marks", method = RequestMethod.GET)
	public String showEditExpertForm(Model model) {

		Expert expert = expertService.get(SessionUtil.getSessionUser());
		model.addAttribute("expertForm", expert);

		populateDefaultModel(model);

		return "expert/evaluateCriteria";
	}

	// show edit form
	@RequestMapping(value = "/expert/marks/manuf", method = RequestMethod.GET)
	public String editValueManufForm(Model model) {

		Expert expert = expertService.get(SessionUtil.getSessionUser());
		model.addAttribute("expert", expert);

		populateDefaultModel(model);

		return "expert/evaluateManufacturers";
	}

	// edit marks
	@RequestMapping(value = "/expert/api/marks/manuf", method = RequestMethod.POST)
	public String editManufMarks(@ModelAttribute("expert") Expert expert,
								 BindingResult result, Model model, final RedirectAttributes redirectAttributes, Locale locale) {

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "expert/evaluateManufacturers";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
			bean.setBasename("messages");
			String msg = bean.getMessage("msg.marks_updated_successfully", null, locale);
			redirectAttributes.addFlashAttribute("msg", msg);
			expertService.edit(expert);

			// POST/REDIRECT/GET
			return "redirect:/expert";
		}
	}

	private void populateDefaultModel(Model model) {

		List<Integer> listMarks = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			listMarks.add(i);
		}
		model.addAttribute("listMarks", listMarks);
		List<Tuple<Manufacturers, Integer>> manufacturers = new ArrayList<>();
		for (Manufacturers item : Manufacturers.values()) {
			manufacturers.add(new Tuple<>(item, 0));
		}
		model.addAttribute("manufacturers", manufacturers);
	}
}

package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Expert;
import by.gstu.choicecamera.domain.Manufacturers;
import by.gstu.choicecamera.service.ExpertService;
import by.gstu.choicecamera.web.dto.JQueryDataTableParamModel;
import by.gstu.choicecamera.web.dto.JsonDTO;
import by.gstu.choicecamera.web.dto.SortHelper;
import by.gstu.choicecamera.web.validator.ExpertFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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


	// update marks
	@RequestMapping(value = "/expert", method = RequestMethod.POST)
	public String saveOrUpdateCamera(@ModelAttribute("expertForm") @Validated Expert expert,
									 BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "expert/addMark";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Marks updated successfully!");
			expertService.edit(expert);

			// POST/REDIRECT/GET
			return "redirect:/index";
		}

	}

	// show add form
	@RequestMapping(value = "/addmarks/{id}", method = RequestMethod.GET)
	public String showUpdateCameraForm(@PathVariable("id") int id, Model model) {

		Expert expert = expertService.get(id);
		model.addAttribute("expertForm", expert);

		populateDefaultModel(model);

		return "expert/addMark";
	}

	private void populateDefaultModel(Model model) {

		List<Integer> listMarks = new ArrayList<>();
		for(int i=1; i<=5; i++)
		{
			listMarks.add(i);
		}
		model.addAttribute("listMarks", listMarks);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

		ModelAndView model = new ModelAndView();
		model.setViewName("cameras/show");
		model.addObject("msg", "camera not found");

		return model;

	}
}

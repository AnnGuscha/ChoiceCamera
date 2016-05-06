package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.domain.Manufacturers;
import by.gstu.choicecamera.service.CameraService;
import by.gstu.choicecamera.web.dto.JQueryDataTableParamModel;
import by.gstu.choicecamera.web.dto.JsonDTO;
import by.gstu.choicecamera.web.dto.SortHelper;
import by.gstu.choicecamera.web.validator.CameraFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
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
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class CameraController {

	@Autowired
	public CameraService cameraService;
	@Autowired
	CameraFormValidator cameraFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(cameraFormValidator);
	}

	@RequestMapping("/index")
	public String listCameras() {

		return "cameras/table";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public
	@ResponseBody
	Object getAll(JQueryDataTableParamModel param) {

		List<Camera> cameraList = cameraService.list();
		int iTotalRecords = cameraList.size();

		//Search
		if (param.getsSearch() != null) {
			cameraList = SortHelper.search(cameraList, param.getsSearch());
		}

		//Sorting
		int sortColumnIndex = param.getiSortCol_0();
		String sortDirection = param.getsSortDir_0();
		switch (sortColumnIndex) {
			case 0: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return Integer.compare(o1.getId(), o2.getId());
					}
				});
//                cameraList.stream()
//                        .sorted((c1, c2) -> Integer.compare(c1.getId(), c2.getId()));
			}
			break;
			case 1: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
			}
			break;
			case 2: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return Integer.compare(o1.getPrice(), o2.getPrice());
					}
				});
			}
			break;
			case 3: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return Integer.compare(o1.getReleaseDate(), o2.getReleaseDate());
					}
				});
			}
			break;
			case 4: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return o1.getManufacturer().compareTo(o2.getManufacturer());
					}
				});
			}
			break;
			case 5: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return Double.compare(o1.getApertureMin(), o2.getApertureMin());
					}
				});
			}
			break;
			case 6: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return Double.compare(o1.getApertureMax(), o2.getApertureMax());
					}
				});
			}
			break;
			case 7: {
				cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
					@Override
					public int compare(Camera o1, Camera o2) {
						return Double.compare(o1.getMatrixDot(), o2.getMatrixDot());
					}
				});
			}
			break;
		}
//        if (sortDirection.equals("desc")) // asc or desc
//            Collections.reverse(cameraList);

		//Pagination
		List<Camera> result = cameraList.stream().skip(param.getiDisplayStart()).limit(param.getiDisplayLength()).collect(Collectors.toList());
		JsonDTO jsonDTO = new JsonDTO(param.getsEcho(), iTotalRecords, cameraList.size(), result);

		return jsonDTO;
	}

	// show camera
	@RequestMapping(value = "/cameras/{id}", method = RequestMethod.GET)
	public String showCamera(@PathVariable("id") int id, Model model, Locale locale) {

		Camera camera = cameraService.get(id);
		if (camera == null) {
			model.addAttribute("css", "danger");
			ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
			bean.setBasename("messages");
			String msg = bean.getMessage("msg.camera_not_found", null, locale);
			model.addAttribute("msg", msg);
		}
		model.addAttribute("camera", camera);

		return "cameras/show";

	}

	// save or update camera
	@RequestMapping(value = "/camera", method = RequestMethod.POST)
	public String saveOrUpdateCamera(@ModelAttribute("cameraForm") @Validated Camera camera,
									 BindingResult result, Model model, final RedirectAttributes redirectAttributes, Locale locale) {

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "cameras/cameraForm";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			if (camera.getId() == null || camera.getId() == 0) {
				redirectAttributes.addFlashAttribute("msg", "camera_added_successfully");
				cameraService.add(camera);
			} else {
				ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
				bean.setBasename("messages");
				String msg = bean.getMessage("msg.camera_updated_successfully", null, locale);
				redirectAttributes.addFlashAttribute("msg", msg);
				cameraService.edit(camera);
			}

			// POST/REDIRECT/GET
			return "redirect:/cameras/" + camera.getId();
		}

	}

	// show add camera form
	@RequestMapping(value = "/cameras/add", method = RequestMethod.GET)
	public String showAddCameraForm(Model model) {

		Camera camera = new Camera();

		// set default value
		camera.setId(0);
		camera.setName("");
		camera.setPrice(0);
		camera.setReleaseDate(2016);
		camera.setManufacturer("");
		camera.setApertureMax(0.0);
		camera.setApertureMin(0.0);
		camera.setMatrixDot(0.0);

		model.addAttribute("cameraForm", camera);
		model.addAttribute("isNew", true);

		populateDefaultModel(model);

		return "cameras/cameraForm";

	}

	// show update form
	@RequestMapping(value = "/cameras/update/{id}", method = RequestMethod.GET)
	public String showUpdateCameraForm(@PathVariable("id") int id, Model model) {

		Camera camera = cameraService.get(id);
		model.addAttribute("cameraForm", camera);
		model.addAttribute("isNew", false);

		populateDefaultModel(model);

		return "cameras/cameraForm";

	}

	// delete camera
	@RequestMapping(value = "/cameras/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes, Locale locale) {

		cameraService.remove(id);

		redirectAttributes.addFlashAttribute("css", "success");
		ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
		bean.setBasename("messages");
		String msg = bean.getMessage("msg.camera_is_deleted", null, locale);
		redirectAttributes.addFlashAttribute("msg", msg);

		return "redirect:/index";

	}

	private void populateDefaultModel(Model model) {

		List<String> manufacturer = new ArrayList<>();
		for (Manufacturers manuf : Manufacturers.values()) {
			manufacturer.add(manuf.getString());
		}
		model.addAttribute("manufacturerList", manufacturer);

	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex, Locale locale) {

		ModelAndView model = new ModelAndView();
		model.setViewName("cameras/show");
		ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
		bean.setBasename("messages");
		String msg = bean.getMessage("msg.camera_not_found", null, locale);
		model.addObject("msg", msg);

		return model;

	}
}

package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.InfoSemester;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrentAll();

		InfoSemester Y2016_S1 = new InfoSemester(), 
					 Y2017_S1= new InfoSemester(), 	 
					 Y2018_S1 = new InfoSemester(),
					 Y2016_S2 = new InfoSemester(), 
					 Y2017_S2 = new InfoSemester(), 
					 Y2018_S2 = new InfoSemester();
		// 2016~ 2018 1학기 기준
		Y2016_S1.setYear(2016);
		Y2016_S1.setSemester(1);
		Y2016_S1.setTotalGrade(0);
	    Y2017_S1.setYear(2017);
		Y2017_S1.setSemester(1);
		Y2017_S1.setTotalGrade(0);
		Y2018_S1.setYear(2018);
		Y2018_S1.setSemester(1);
		Y2018_S1.setTotalGrade(0);
		// 2016~ 2018 2학기 기준
		Y2016_S2.setYear(2016);
		Y2016_S2.setSemester(2);
		Y2016_S2.setTotalGrade(0);
		Y2017_S2.setYear(2017);
		Y2017_S2.setSemester(2);
		Y2017_S2.setTotalGrade(0);
		Y2018_S2.setYear(2018);
		Y2018_S2.setSemester(2);
		Y2018_S2.setTotalGrade(0);

		for (Offer o : offers) {
			if (o.getYear() == 2016 && o.getSemester() == 1) {
				Y2016_S1.setTotalGrade(Y2016_S1.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2016 && o.getSemester() == 2) {
				Y2016_S2.setTotalGrade(Y2016_S2.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2017 && o.getSemester() == 1) {
				Y2017_S1.setTotalGrade(Y2017_S1.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2017 && o.getSemester() == 2) {
				Y2017_S2.setTotalGrade(Y2017_S2.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2018 && o.getSemester() == 1) {
				Y2018_S1.setTotalGrade(Y2018_S1.getTotalGrade() + o.getGrade());
			}
			if (o.getYear() == 2018 && o.getSemester() == 2) {
				Y2018_S2.setTotalGrade(Y2018_S2.getTotalGrade() + o.getGrade());
			}
		}

		model.addAttribute("Y2016_S1", Y2016_S1);
		model.addAttribute("Y2016_S2", Y2016_S2);
		model.addAttribute("Y2017_S1", Y2017_S1);
		model.addAttribute("Y2017_S2", Y2017_S2);
		model.addAttribute("Y2018_S1", Y2018_S1);
		model.addAttribute("Y2018_S2", Y2018_S2);

		return "offers";
	}

	@RequestMapping("/semester")
	public String showSemester(@RequestParam("year") String year, @RequestParam("semester") String semester,
			Model model) {

		int yearInt = Integer.parseInt(year);
		int semesterInt = Integer.parseInt(semester);

		List<Offer> offers = offerService.getCurrent(yearInt, semesterInt);

		model.addAttribute("offers", offers);

		return "semester";
	}

	@RequestMapping("/createoffer")
	public String createOffers(Model model) {

		model.addAttribute("offer", new Offer());

		return "createoffer";
	}

	@RequestMapping(value = "/docreate", produces = "text/html; charset=utf-8")
	public String docreate(Model model, @Valid Offer offer, BindingResult result) {

		System.out.println(offer.getCoursename());

		if (result.hasErrors()) {
			System.out.println("===Form data dose not validated");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "createoffer";
		}

		offerService.insert(offer);

		return "offercreated";
	}
}

package com.team6.paf2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team6.paf2.model.Pattern;
import com.team6.paf2.model.service.PatternService;
import com.team6.paf2.model.service.PatternServiceImpl;
import com.team6.paf2.view.form.PatternForm;

@Controller
public class PatternController {
	protected PatternServiceImpl patternservice = PatternService.getInstance();

	@RequestMapping(value="/")
	public ModelAndView showHome(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/pattern-selector")
	public ModelAndView showPatternSelector(HttpServletResponse response) throws IOException{
		return new ModelAndView("patternselector");
	}
	
	@RequestMapping(value="/pattern-editor", method = RequestMethod.GET)
	public String showPatternEditor(ModelMap model) throws IOException{
		
		List<Pattern> patterns = patternservice.getAllPatterns();
		model.addAttribute("patterns", patterns);
		
		model.addAttribute("PatternForm", new PatternForm());
		
		return "patterneditor";
	}
	
	@RequestMapping(value="/pattern-editor", method = RequestMethod.POST)
	public String processPatternEditorNew(ModelMap model, @ModelAttribute("PatternForm") PatternForm patternform) throws IOException{
		
		// create pattern according form values
		String name = patternform.getName();
		String context = patternform.getContext();
		String problems = patternform.getProblems();
		String forces = patternform.getForces();
		String solution = patternform.getSolution();
		String description = patternform.getDescription();
		String consequences = patternform.getConsequences();
		File diagram = patternform.getDiagram();
		String participants = patternform.getParticipants();
		
		int id = patternservice.getNewId();
		
		Pattern pattern = new Pattern(id, name, context, problems, forces, solution, description, consequences, diagram, participants);
		this.patternservice.addPattern(pattern);
		
		// assemble view properties
		List<Pattern> patterns = patternservice.getAllPatterns();
		model.addAttribute("patterns", patterns);
		
		model.addAttribute("PatternForm", new PatternForm());
		
		return "patterneditor";
	}
	
	@RequestMapping(value="/pattern-editor/{id}", method = RequestMethod.GET)
	public String showPatternEditorEdit(ModelMap model, @PathVariable(value ="id") int id) throws IOException{
		
		// assemble view properties
		List<Pattern> patterns = patternservice.getAllPatterns();
		model.addAttribute("patterns", patterns);
		
		Pattern pattern = this.patternservice.getPatternById(id);
		
		PatternForm patternForm = new PatternForm();
		patternForm.setId("" + pattern.getId());
		patternForm.setName(pattern.getName());
		patternForm.setContext(pattern.getContext());
		patternForm.setProblems(pattern.getProblems());
		patternForm.setForces(pattern.getForces());
		patternForm.setSolution(pattern.getSolution());
		patternForm.setDescription(pattern.getDescription());
		patternForm.setConsequences(pattern.getConsequences());
		patternForm.setDiagram(pattern.getDiagram());
		patternForm.setParticipants(pattern.getParticipants());
		
		model.addAttribute("PatternForm", patternForm);
		
		return "patterneditor";
	}
	
	@RequestMapping(value="/pattern-editor/{id}", method = RequestMethod.POST)
	public String processPatternEditorEdit(ModelMap model, @PathVariable(value ="id") int id, @ModelAttribute("PatternForm") PatternForm patternform) throws IOException{
		
		// save form values to pattern
		Pattern pattern = this.patternservice.getPatternById(id);
		
		pattern.setName(patternform.getName());
		pattern.setContext(patternform.getContext());
		pattern.setProblems(patternform.getProblems());
		pattern.setForces(patternform.getForces());
		pattern.setSolution(patternform.getSolution());
		pattern.setDescription(patternform.getDescription());
		pattern.setConsequences(patternform.getConsequences());
		pattern.setDiagram(patternform.getDiagram());
		pattern.setParticipants(patternform.getParticipants());
		
		// assemble view properties
		List<Pattern> patterns = patternservice.getAllPatterns();
		model.addAttribute("patterns", patterns);
		
		return "redirect:/pattern-editor/" + id;
	}
	
	@RequestMapping(value="/pattern-editor/remove/{id}", method = RequestMethod.GET)
	public String removePatternEditorPattern(ModelMap model, @PathVariable(value ="id") int id) throws IOException{
		
		this.patternservice.removePatternById(id);
		
		return "redirect:/pattern-editor";
	}
}

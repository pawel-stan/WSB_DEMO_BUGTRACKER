package wsb.bugtrackerexercise.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wsb.bugtrackerexercise.filters.ProjectFilter;
import wsb.bugtrackerexercise.models.Project;
import wsb.bugtrackerexercise.services.ProjectService;

import java.util.List;

@Controller
@RequestMapping("projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    ModelAndView index(@ModelAttribute ProjectFilter filter) {
        List<Project> projects = projectService.findAll(filter);

        ModelAndView modelAndView = new ModelAndView("projects/index");
        modelAndView.addObject("projects", projects);
        modelAndView.addObject("filter", filter);

        return modelAndView;
    }



}

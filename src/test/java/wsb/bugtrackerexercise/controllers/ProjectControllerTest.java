package wsb.bugtrackerexercise.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wsb.bugtrackerexercise.models.Person;
import wsb.bugtrackerexercise.models.Project;
import wsb.bugtrackerexercise.services.ProjectService;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProjectService projectService;

    @Test
    void index() throws Exception {
        Project project = new Project();
        project.setCode("CODE");

        List<Project> projects = List.of(
                project
        );

        doReturn(projects).when(projectService).findAll(any());
        doReturn(Collections.emptySet()).when(projectService).findAllCreators();

        mockMvc.perform(get("/projects"))
                .andExpect(status().isOk())
                .andExpect(view().name("projects/index"))
                .andExpect(model().attribute("projects", projects))
                .andExpect(model().attribute("creators", Collections.emptySet()));
    }
}
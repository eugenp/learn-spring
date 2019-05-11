package com.baeldung.ls.persistence.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.ls.persistence.dao.IProjectDao;
import com.baeldung.ls.persistence.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDaoIntegrationTest {

    @Autowired
    private IProjectDao projectDao;

    @Test
    public void givenNewProject_thenSavedSuccess() {
        Project newProject = new Project(null, "Project", LocalDate.now());
        assertThat(projectDao.save(newProject)).isNotNull();
    }

    @Test
    public void givenProjectCreated_thenFindByIdSuccess() {
        Project newProject = new Project(null, "Another project", LocalDate.now());
        projectDao.save(newProject);

        Optional<Project> retreivedProject = projectDao.findById(newProject.getId());
        assertThat(retreivedProject.get()).isEqualTo(newProject);
    }

}

package com.baeldung.ls.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IListProjectRepository;
import com.baeldung.ls.service.IProjectService;

@Service
public class ListProjectServiceImpl implements IProjectService {

    private IListProjectRepository listProjectRepository;

    public ListProjectServiceImpl(IListProjectRepository listProjectRepository) {
        this.listProjectRepository = listProjectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return listProjectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return listProjectRepository.save(project);
    }

    @Override
    public List<Project> retrieveAll() {
        return listProjectRepository.findAll();
    }

}

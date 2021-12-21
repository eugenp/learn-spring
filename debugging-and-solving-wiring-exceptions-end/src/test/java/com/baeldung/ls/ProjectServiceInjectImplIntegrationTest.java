package com.baeldung.ls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.baeldung.ls.contextconfigs.ContextConfigNoRepositoryScanned;
import com.baeldung.ls.contextconfigs.ContextConfigWithNoChanges;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.core.NestedExceptionUtils;

import com.baeldung.additionalbeans.contextconfigs.ContextConfigWithAdditionalCircularDependencyBeans;
import com.baeldung.ls.persistence.repository.IProjectRepository;

public class ProjectServiceInjectImplIntegrationTest {

	@Test
	public void givenNoRepositoryExistsInContext_whenContextLoaded_thenNoSuchBeanDefinitionExceptionThrown() {
		final ApplicationContextRunner contextRunner = new ApplicationContextRunner();
		// ISE thrown because Repository bean can't be injected on Service bean
		Exception thrown = assertThrows(IllegalStateException.class, () -> {
			contextRunner.withUserConfiguration(ContextConfigNoRepositoryScanned.class).run(context -> {
				context.getBean(IProjectRepository.class);
			});
		});
		assertThat(NestedExceptionUtils.getRootCause(thrown)).isInstanceOf(NoSuchBeanDefinitionException.class);
	}

	@Test
	public void givenNormalContext_whenLoadRepositoryWithNoQualifier_thenNoUniqueBeanDefinitionExceptionThrown() {

		final ApplicationContextRunner contextRunner = new ApplicationContextRunner();
		assertThrows(NoUniqueBeanDefinitionException.class, () -> {
			contextRunner.withUserConfiguration(ContextConfigWithNoChanges.class).run(context -> {
				context.getBean(IProjectRepository.class);
			});
		});
	}

	@Test
	public void givenContextWithCircularDependency_whenLoadContext_thenBeanCurrentlyInCreationExceptionThrown() {
		final ApplicationContextRunner contextRunner = new ApplicationContextRunner();
		// ISE thrown because of Circular Dependency in Context
		Exception thrown = assertThrows(IllegalStateException.class, () -> {
			contextRunner.withUserConfiguration(ContextConfigWithAdditionalCircularDependencyBeans.class)
					.run(context -> {
						context.getBean(IProjectRepository.class);
					});
		});
		assertThat(NestedExceptionUtils.getRootCause(thrown)).isInstanceOf(BeanCurrentlyInCreationException.class);
	}
}
package es.w2m.domain;

import es.w2m.domain.model.PageInfoDomainModel;
import es.w2m.domain.model.PageableDomainModel;
import es.w2m.domain.model.SpaceshipDomainModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpaceshipServiceTest {

    @Mock
    ISpaceshipRepositoryPort repository;

    @InjectMocks
    SpaceshipServiceImpl service;

    @Test
    void testSearchSpaceshipsReturnPageableResults() {
        PageableDomainModel pageableDomainExpected = PageableDomainModel.builder()
                .pageInfo(new PageInfoDomainModel(1, 10, 2L, 20L))
                .spaceships(List.of(new SpaceshipDomainModel(1L, "X-wing"), new SpaceshipDomainModel(2L, "wing-x")))
                .build();
        when(repository.searchSpaceshipsWithPartialName(any(), any(), any()))
                .thenReturn(pageableDomainExpected);
        PageableDomainModel pageableDomainActual = service.searchSpaceships("wing", 1,10);

        verify(repository).searchSpaceshipsWithPartialName("wing", 1,10);
        assertEquals(pageableDomainExpected, pageableDomainActual);
    }

    @Test
    void testSearchSpaceshipByIdReturnSpaceship() {
        SpaceshipDomainModel spaceshipDomainExpected = SpaceshipDomainModel.builder()
                .id(1L)
                .build();
        when(repository.searchSpaceshipById(1L))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomainModel spaceshipDomainActual = service.searchSpaceshipById(1L);

        verify(repository).searchSpaceshipById(1L);
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldCreateSpaceship() {
        SpaceshipDomainModel spaceshipDomainExpected = SpaceshipDomainModel.builder()
                .id(1L)
                .name("X-wing")
                .build();
        when(repository.createSpaceship(spaceshipDomainExpected))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomainModel spaceshipDomainActual = service.createSpaceship(spaceshipDomainExpected);

        verify(repository).createSpaceship(spaceshipDomainExpected);
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldCreateSpaceshipWithNewIdWhenIdIsNotPresent() {
        String name = "X-wing";
        SpaceshipDomainModel spaceshipDomainExpected = SpaceshipDomainModel.builder()
                .id(1L)
                .name(name)
                .build();
        SpaceshipDomainModel spaceshipWithoutId = SpaceshipDomainModel.builder()
                .id(null)
                .name(name)
                .build();
        when(repository.createSpaceship(spaceshipWithoutId))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomainModel spaceshipDomainActual = service.createSpaceship(spaceshipWithoutId);

        verify(repository).createSpaceship(spaceshipWithoutId);
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldUpdateSpaceshipReturningUpdatedSpaceship() {
        SpaceshipDomainModel spaceshipDomainExpected = SpaceshipDomainModel.builder().build();
        when(repository.updateSpaceship(any()))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomainModel spaceshipDomainActual = service.updateSpaceship(spaceshipDomainExpected);

        verify(repository).updateSpaceship(any());
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldDeleteSpaceshipWhenIdIsPresent() {
        service.deleteSpaceshipById(1L);
        verify(repository).deleteSpaceshipById(1L);
    }
}

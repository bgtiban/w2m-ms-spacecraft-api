package es.w2m.domain;

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
        PageableDomain pageableDomainExpected = PageableDomain.builder()
                .pageInfo(new PageInfoDomain(1, 10, 2L, 20L))
                .spaceships(List.of(new SpaceshipDomain(1L, "X-wing"), new SpaceshipDomain(2L, "wing-x")))
                .build();
        when(repository.searchSpaceshipsWithPartialName(any(), any(), any()))
                .thenReturn(pageableDomainExpected);
        PageableDomain pageableDomainActual = service.searchSpaceships("wing", 1,10);

        verify(repository).searchSpaceshipsWithPartialName("wing", 1,10);
        assertEquals(pageableDomainExpected, pageableDomainActual);
    }

    @Test
    void testSearchSpaceshipByIdReturnSpaceship() {
        SpaceshipDomain spaceshipDomainExpected = SpaceshipDomain.builder()
                .id(1L)
                .build();
        when(repository.searchSpaceshipById(1L))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomain spaceshipDomainActual = service.searchSpaceshipById(1L);

        verify(repository).searchSpaceshipById(1L);
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldCreateSpaceship() {
        SpaceshipDomain spaceshipDomainExpected = SpaceshipDomain.builder()
                .id(1L)
                .name("X-wing")
                .build();
        when(repository.createSpaceship(spaceshipDomainExpected))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomain spaceshipDomainActual = service.createSpaceship(spaceshipDomainExpected);

        verify(repository).createSpaceship(spaceshipDomainExpected);
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldCreateSpaceshipWithNewIdWhenIdIsNotPresent() {
        String name = "X-wing";
        SpaceshipDomain spaceshipDomainExpected = SpaceshipDomain.builder()
                .id(1L)
                .name(name)
                .build();
        SpaceshipDomain spaceshipWithoutId = SpaceshipDomain.builder()
                .id(null)
                .name(name)
                .build();
        when(repository.createSpaceship(spaceshipWithoutId))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomain spaceshipDomainActual = service.createSpaceship(spaceshipWithoutId);

        verify(repository).createSpaceship(spaceshipWithoutId);
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldUpdateSpaceshipReturningUpdatedSpaceship() {
        SpaceshipDomain spaceshipDomainExpected = SpaceshipDomain.builder().build();
        when(repository.updateSpaceship(any()))
                .thenReturn(spaceshipDomainExpected);

        SpaceshipDomain spaceshipDomainActual = service.updateSpaceship(spaceshipDomainExpected);

        verify(repository).updateSpaceship(any());
        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
    }

    @Test
    void shouldDeleteSpaceshipWhenIdIsPresent() {
        service.deleteSpaceshipById(1L);
        verify(repository).deleteSpaceshipById(1L);
    }
}

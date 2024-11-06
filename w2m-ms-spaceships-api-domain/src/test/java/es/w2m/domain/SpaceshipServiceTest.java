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
        when(repository.searchSpaceships(any(), any(), any()))
                .thenReturn(pageableDomainExpected);
        PageableDomain pageableDomainActual = service.searchSpaceships("wing", 1,10);

        verify(repository).searchSpaceships("wing", 1,10);
        assertEquals(pageableDomainExpected, pageableDomainActual);
    }

//    @Test
//    void testSearchSpaceshipByIdReturnSpaceship() {
//        SpaceshipDomain spaceshipDomainExpected = SpaceshipDomain.builder().build();
//        when(repository.searchById(1L))
//                .thenReturn(spaceshipDomainExpected);
//
//        SpaceshipDomain spaceshipDomainActual = service.searchById(1L);
//
//        verify(repository).findById(1L);
//        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
//    }
//
//    @Test
//    void createSpaceshipReturnSpaceshipCreated() {
//        SpaceshipDomain spaceshipDomainExpected = SpaceshipDomain.builder().build();
//        when(repository.createSpaceship(any()))
//                .thenReturn(spaceshipDomainExpected);
//
//        SpaceshipDomain spaceshipDomainActual = service.createSpaceship(spaceshipDomainExpected);
//
//        verify(repository).save();
//        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
//    }
//
//    @Test
//    void updateSpaceshipReturnUpdatedSpaceship() {
//        SpaceshipDomain spaceshipDomainExpected = SpaceshipDomain.builder().build();
//        when(repository.updateSpaceship(any()))
//                .thenReturn(spaceshipDomainExpected);
//
//        SpaceshipDomain spaceshipDomainActual = service.updateSpaceship(spaceshipDomainExpected);
//
//        verify(repository).update();
//        assertEquals(spaceshipDomainExpected, spaceshipDomainActual);
//    }
//
//    @Test
//    void deleteSpaceshipOk() {
//        when(repository.deleteSpaceshipByid(1L))
//                .thenReturn(1L);
//
//        totalDeleted = service.deleteSpaceshipById(1L);
//
//        verify(repository).deleteSpaceshipByid(1L);
//        assertEquals(1L, totalDeleted);
//    }
}

package es.w2m.boot;

import es.w2m.SpaceshipApiImpl;
import es.w2m.api.rest.model.SpaceshipPageDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class W2mSpringBootApplicationTest {

    @Autowired
    private SpaceshipApiImpl controller;

    @Test
    void shouldReturnPageableSpaceshipsWhenNameIsNotGiven() {
        ResponseEntity<SpaceshipPageDto> page0Entity = controller.searchSpaceships(null, BigDecimal.ZERO, BigDecimal.TEN);
        SpaceshipPageDto page0 = page0Entity.getBody();
        SpaceshipPageDto page1 = controller.searchSpaceships(null, BigDecimal.ONE, BigDecimal.TEN).getBody();
        SpaceshipPageDto page2 = controller.searchSpaceships(null, BigDecimal.TWO, BigDecimal.TEN).getBody();

        assertThat(page0Entity.getStatusCode().is2xxSuccessful()).isTrue();
        assert page0 != null;
        assert page1 != null;
        assert page2 != null;
        assertThat(page0.getPageInfo().getTotalPages()).isEqualTo(BigDecimal.valueOf(3));
        assertThat(page0.getPageInfo().getTotalSize()).isEqualTo(BigDecimal.valueOf(22));

        assertThat(page0.getPageInfo().getPageNumber()).isEqualTo(BigDecimal.ZERO);
        assertThat(page0.getSpaceships().size()).isEqualTo(10);

        assertThat(page1.getPageInfo().getPageNumber()).isEqualTo(BigDecimal.ONE);
        assertThat(page1.getSpaceships().size()).isEqualTo(10);

        assertThat(page2.getPageInfo().getPageNumber()).isEqualTo(BigDecimal.TWO);
        assertThat(page2.getSpaceships().size()).isEqualTo(2);
    }

    @Test
    void shouldReturnPageableSpaceshipsWhenAllParametersIsGiven() {
        ResponseEntity<SpaceshipPageDto> page0Entity = controller.searchSpaceships("a", BigDecimal.ZERO, BigDecimal.TEN);
        SpaceshipPageDto page0 = page0Entity.getBody();
        SpaceshipPageDto page1 = controller.searchSpaceships("a", BigDecimal.ONE, BigDecimal.TEN).getBody();

        assertThat(page0Entity.getStatusCode().is2xxSuccessful()).isTrue();
        assert page0 != null;
        assert page1 != null;
        assertThat(page0.getPageInfo().getTotalPages()).isEqualTo(BigDecimal.valueOf(2));
        assertThat(page0.getPageInfo().getTotalSize()).isEqualTo(BigDecimal.valueOf(11));

        assertThat(page0.getPageInfo().getPageNumber()).isEqualTo(BigDecimal.ZERO);
        assertThat(page0.getSpaceships().size()).isEqualTo(10);

        assertThat(page1.getPageInfo().getPageNumber()).isEqualTo(BigDecimal.ONE);
        assertThat(page1.getSpaceships().size()).isEqualTo(1);
    }
}

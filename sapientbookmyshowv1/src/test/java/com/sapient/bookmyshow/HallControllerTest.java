package com.sapient.bookmyshow;

import com.sapient.bookmyshow.controllers.HallController;
import com.sapient.bookmyshow.dtos.CreateHallRequest;
import com.sapient.bookmyshow.dtos.SeatPosition;
import com.sapient.bookmyshow.enums.MovieFeature;
import com.sapient.bookmyshow.enums.SeatType;
import com.sapient.bookmyshow.models.Hall;
import com.sapient.bookmyshow.services.HallService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class HallControllerTest {

    @Mock
    private HallService hallService;

    @InjectMocks
    private HallController hallController;

    @Test
    void testCreateHall() {
        // Arrange
        CreateHallRequest request = new CreateHallRequest();
        request.setName("Premium Hall");
        request.setFeatures(List.of(MovieFeature.THREE_D, MovieFeature.DOLBY_DIGITAL));
        request.setSeatRanges(Map.of(
                SeatType.VIP, List.of(new SeatPosition(1, 1), new SeatPosition(1, 2)),
                SeatType.GOLD, List.of(new SeatPosition(2, 1), new SeatPosition(2, 2))
        ));

        Hall expectedHall = Hall.builder()
                .name("Premium Hall")
                .features(List.of(MovieFeature.THREE_D, MovieFeature.DOLBY_DIGITAL))
                .build();

        Mockito.when(hallService.createHall(request)).thenReturn(expectedHall);

        // Act
        Hall result = hallController.createHall(request);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Premium Hall", result.getName());
        Assertions.assertTrue(result.getFeatures().contains(MovieFeature.THREE_D));
        Mockito.verify(hallService, Mockito.times(1)).createHall(request);
    }

    @Test
    void testGetHall() {
        // Arrange
        Long hallId = 1L;
        Hall expectedHall = Hall.builder()
                .name("Premium Hall")
                .features(List.of(MovieFeature.THREE_D))
                .build();

        Mockito.when(hallService.getHall(hallId)).thenReturn(expectedHall);

        // Act
        Hall result = hallController.getHall(hallId);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Premium Hall", result.getName());
        Mockito.verify(hallService, Mockito.times(1)).getHall(hallId);
    }
}

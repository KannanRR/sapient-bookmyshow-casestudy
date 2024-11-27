package com.theatre.booking;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theatre.booking.controllers.CityController;
import com.theatre.booking.dtos.CreateCityResponse;
import com.theatre.booking.models.City;
import com.theatre.booking.services.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

class CityControllerTest {

    @Mock
    private CityService cityService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CityController cityController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cityController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testCreateCity() throws Exception {
        City city = new City();
        city.setName("Test City");

        when(cityService.createCity(any(City.class))).thenReturn(city);

        mockMvc.perform(post("/city")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(city)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test City"));

        verify(cityService, times(1)).createCity(any(City.class));
    }

    @Test
    void testGetCity() throws Exception {
        City city = new City();
        city.setName("Test City");

        when(cityService.getCity(1L)).thenReturn(city);

        mockMvc.perform(get("/city/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test City"));

        verify(cityService, times(1)).getCity(1L);
    }

    @Test
    void testGetAllCities() throws Exception {
        City city1 = new City();
        city1.setName("City 1");
        City city2 = new City();
        city2.setName("City 2");

        List<City> cities = Arrays.asList(city1, city2);

        when(cityService.getallCity()).thenReturn(cities);

        mockMvc.perform(get("/city/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("City 1"))
                .andExpect(jsonPath("$[1].name").value("City 2"));

        verify(cityService, times(1)).getallCity();
    }

    @Test
    void testSearchCity() throws Exception {
        City city1 = new City();
        city1.setName("City 1");
        City city2 = new City();
        city2.setName("City 2");

        List<City> cities = Arrays.asList(city1, city2);

        CreateCityResponse response1 = new CreateCityResponse();
        response1.setName("City 1");
        CreateCityResponse response2 = new CreateCityResponse();
        response2.setName("City 2");

        when(cityService.searchCity("City")).thenReturn(cities);
        when(modelMapper.map(city1, CreateCityResponse.class)).thenReturn(response1);
        when(modelMapper.map(city2, CreateCityResponse.class)).thenReturn(response2);

        mockMvc.perform(get("/city/search/City"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("City 1"))
                .andExpect(jsonPath("$[1].name").value("City 2"));

        verify(cityService, times(1)).searchCity("City");
    }
}


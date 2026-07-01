package Anfri.Repartidores;

import Anfri.Repartidores.Controller.RepartidoresController;
import Anfri.Repartidores.DTO.RepartidorRequest;
import Anfri.Repartidores.Model.RepartidorModel;
import Anfri.Repartidores.Service.RepartidoresService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RepartidoresController.class)
public class RepartidoresControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RepartidoresService repartidoresService;

    @Autowired
    private ObjectMapper objectMapper;

    private RepartidorModel repartidorEjemplo;
    private RepartidorRequest requestEjemplo;

    @BeforeEach
    void setUp() {
        repartidorEjemplo = new RepartidorModel();
        repartidorEjemplo.setId(1);
        repartidorEjemplo.setNombre("Juan Pérez");
        repartidorEjemplo.setTelefono("987654321");
        repartidorEjemplo.setTipoVehiculo("Moto");
        repartidorEjemplo.setEstado("DISPONIBLE");

        requestEjemplo = new RepartidorRequest();
        requestEjemplo.setNombre("Juan Pérez");
        requestEjemplo.setTelefono("987654321");
        requestEjemplo.setTipoVehiculo("Moto");
    }

    @Test
    void listarTodos_DeberiaRetornarListaVacia_CuandoNoHayRepartidores() throws Exception {
        when(repartidoresService.listarTodos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/repartidores"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void crear_DeberiaRetornarCreado_CuandoElRequestEsValido() throws Exception {
        when(repartidoresService.crear(any(RepartidorRequest.class))).thenReturn(repartidorEjemplo);

        mockMvc.perform(post("/api/v1/repartidores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestEjemplo)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Juan Pérez"))
                .andExpect(jsonPath("$.estado").value("DISPONIBLE"));
    }

    @Test
    void obtener_DeberiaRetornarRepartidor_CuandoIdExiste() throws Exception {
        when(repartidoresService.buscarPorId(1)).thenReturn(repartidorEjemplo);

        mockMvc.perform(get("/api/v1/repartidores/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Juan Pérez"));
    }
}
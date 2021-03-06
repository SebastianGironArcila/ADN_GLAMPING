package com.ceiba.glamping.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.glamping.comando.ComandoGlamping;
import com.ceiba.glamping.modelo.entidad.Glamping;
import com.ceiba.glamping.servicio.testdatabuilder.ComandoGlampingTestDataBuilder;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorGlamping.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorGlampingTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un glamping")
    void deberiaCrearUnGlamping() throws Exception{
        // arrange
        ComandoGlamping glamping = new ComandoGlampingTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/glamping")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(glamping)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

    }
}

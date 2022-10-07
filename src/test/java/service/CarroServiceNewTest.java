package service;

import builder.CarroProvider;
import model.Carro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarroServiceNewTest {

    @Mock
    private SistemaDeSeguranca sistemaDeSeguranca;

    @Mock
    private GPS gps;

    @InjectMocks
    private CarroServiceImpl carroService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void naoDevePermitirAcelerarCarroBloqueado() throws Exception {
        Carro carro = CarroProvider.get();

        Mockito.when(sistemaDeSeguranca.travaDeEmergenciaAtivada(Mockito.any(Carro.class))).thenReturn(true);


        //Mockito.when(sistemaDeSeguranca.travaDeEmergenciaAtivada(carro)).thenReturn(true);

        Throwable throwable = assertThrows(Exception.class,

                () -> carroService.acelerar(carro,10));



        assertEquals("Carro bloqueado!", throwable.getMessage());
    }@Test
    public void deveEnviarLocalizacaoQuandoLigarCarroBloqueado() throws Exception {
        Carro carro = CarroProvider.get();

        Mockito.when(sistemaDeSeguranca.travaDeEmergenciaAtivada(Mockito.any(Carro.class))).thenReturn(true);


        //Mockito.when(sistemaDeSeguranca.travaDeEmergenciaAtivada(carro)).thenReturn(true);

        Throwable throwable = assertThrows(Exception.class,

                () -> carroService.ligar(carro));



        assertEquals("Carro bloqueado!", throwable.getMessage());
    }

}

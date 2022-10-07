package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class CarroServiceTest {

    @Test
    public void testeVelocidadeNaoPodeSerNegativa() throws Exception {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta",100);

        // When
        carroService.ligar(carro1);
        carroService.acelerar(carro1,10);
        carroService.frear(carro1,10);
        carroService.frear(carro1,10);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }

    @Test
    public void testeFreioGradual() throws Exception {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta",100);

        // When
        carroService.ligar(carro1);
        carroService.acelerar(carro1,20);
        carroService.acelerar(carro1,20);
        carroService.frear(carro1,10);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 30);
    }



    @Test
    public void testeDeveAcelerarCorretamente() throws Exception {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta",100);


        // When
        carroService.ligar(carro1);
        carroService.acelerar(carro1,10);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 10);
    }

    @Test
    public void testeNaoDeveAcelerarDesligado() throws Exception {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta",100);


        // When
        carroService.acelerar(carro1,10);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }

    @Test

    public void asserts() throws Exception {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro3 =
                new Carro("prata", "Ford", "2012", "Ka",100);

        // When
        carroService.ligar(carro3);
        carroService.acelerar(carro3,10);

        // Then
        Assert.assertTrue(carro3.isLigado());
        Assert.assertFalse(carro3.getVelocidadeAtual()==20);

        Assert.assertThat(carro3.getVelocidadeAtual(), is(not(20)));



    }






}

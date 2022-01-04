package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    @BeforeEach
    void setUp() {
        xuxa = new Cliente("xuxa", "12345678910", "1111111");
        silvioSantos = new Cliente("Silvio Santos", "01234567890", "2222222");

        contaXuxa = new Conta("0025", "2251",2500.00,xuxa);
        contaSilvio = new Conta("0028", "2254", 3500.00,silvioSantos);
    }

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000.00, contaSilvio);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());
    }


    @Test
    public void validarTranferenciaInvalida(){

        xuxa = new Cliente("xuxa", "12345678910", "1111111");
        silvioSantos = new Cliente("Silvio Santos", "01234567890", "2222222");

        contaXuxa = new Conta("0025", "2251",2500.00,xuxa);
        contaSilvio = new Conta("0028", "2254", 3500.00,silvioSantos);

        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);
        assertFalse(resultado);
    }

}

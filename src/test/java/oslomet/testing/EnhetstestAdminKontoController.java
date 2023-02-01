package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import oslomet.testing.API.AdminKontoController;
import oslomet.testing.API.BankController;
import oslomet.testing.DAL.AdminRepository;
import oslomet.testing.Models.Konto;
import oslomet.testing.Models.Kunde;
import oslomet.testing.Sikkerhet.Sikkerhet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnhetstestAdminKontoController {

    @InjectMocks
    // denne skal testes
    private AdminKontoController adminController;

    @Mock
    // denne skal Mock'es
    private AdminRepository repository;

    @Mock
    // denne skal Mock'es
    private Sikkerhet sjekk;

    @Test
    public void hentAlleKonti() {
        //arrange
        //act
        //assert
    }

    @Test
    public void hentAlleKontiFeil() {
        //arrange
        //act
        //assert
    }

    @Test
    public void registrerKonto() {
        //arrange
        //act
        //assert
    }

    @Test
    public void registrerKontoFeil() {
        //arrange
        //act
        //assert
    }

    @Test
    public void endreKonto() {
        //arrange
        //act
        //assert
    }

    @Test
    public void endreKontoFeil() {
        //arrange
        //act
        //assert
    }

    @Test
    public void slettKonto() {
        //arrange
        //act
        //assert
    }

    @Test
    public void slettKontoFeil() {
        //arrange
        //act
        //assert
    }
}

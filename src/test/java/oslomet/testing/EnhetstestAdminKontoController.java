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
import oslomet.testing.Models.Transaksjon;
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
        //ARRANGE
        //1. Create a List with an account
        List<Transaksjon> transaksjonList = new ArrayList<>() {};
        Konto konto1 = new Konto("04081516234", "0123.45.67890", 30000, "Sparekonto", "NOK", transaksjonList);
        List<Konto> kontoList = new ArrayList<>() {};
        kontoList.add(konto1);
        //2. When the method sjekk.loggetInn() gets called within hentAlleKonti() return the string below.
        String personnummer = "04081516234";
        when(sjekk.loggetInn()).thenReturn(personnummer);
        //3. When the method repository.hentAlleKonti() gets called, return "kontoList"
        when(repository.hentAlleKonti()).thenReturn(kontoList);

        //ACT
        //4. Call the method to be tested and store the result
        List<Konto> resultat = adminController.hentAlleKonti();

        //ASSERT
        //5. Compare the actual result vs the expected result to assert whether the test was succesful
        assertEquals(resultat, kontoList);
    }

    @Test
    public void hentAlleKontiFeil() {
        //ARRANGE
        //1. This time, when the method sjekk.loggetInn() is called we want to receive a null result
        when(sjekk.loggetInn()).thenReturn(null);

        //ACT
        //2. Call the method to be tested and store the result
        List<Konto> resultat = adminController.hentAlleKonti();

        //ASSERT
        //3. Compare if the result is null to test if it failed as expected
        assertNull(resultat);
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

package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import oslomet.testing.API.AdminKontoController;
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
        Konto konto1 = new Konto("04081516234", "0123.45.67890", 30000, "Sparekonto",
                "NOK", transaksjonList);
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
        //ARRANGE
        //1. Create transaction list + account.
        List<Transaksjon> transaksjonList = new ArrayList<>() {};
        Konto konto1 = new Konto("04081516234", "0123.45.67890", 30000, "Sparekonto",
                "NOK", transaksjonList);

        //2. Fake sjekk.loggetInn() and repository.registrerKonto() return values.
        String personnummer = "04081516234";
        when(sjekk.loggetInn()).thenReturn(personnummer);
        String retur = "OK";
        when(repository.registrerKonto(konto1)).thenReturn(retur);

        //ACT
        //3. Call method and store result.
        String result = adminController.registrerKonto(konto1);

        //ASSERT
        //4. Compare return values to assert validity of the test.
        assertEquals(retur, result);

    }

    @Test
    public void registrerKontoFeil() {
        //ARRANGE
        //1. Create transaction list + account.
        List<Transaksjon> transaksjonList = new ArrayList<>() {};
        Konto konto1 = new Konto("04081516234", "0123.45.67890", 30000, "Sparekonto",
                "NOK", transaksjonList);
        //2. Fake null return, store expected string result
        when(sjekk.loggetInn()).thenReturn(null);
        String retur = "Ikke innlogget";

        //ACT
        //3. Run registrerKonto method and store actual result
        String resultat = adminController.registrerKonto(konto1);

        //ASSERT
        //4. Compare expected result vs actual result
        assertEquals(retur, resultat);
    }

    @Test
    public void endreKonto() {
        //ARRANGE
        //1. Create transaction list + account.
        List<Transaksjon> transaksjonList = new ArrayList<>() {};
        Konto konto1 = new Konto("04081516234", "0123.45.67890", 30000, "Sparekonto",
                "NOK", transaksjonList);
        //2. Fake sjekk.loggetInn() and repository.endreKonto() return values.
        String personnummer = "04081516234";
        when(sjekk.loggetInn()).thenReturn(personnummer);
        String retur = "OK";
        when(repository.endreKonto(konto1)).thenReturn(retur);

        //ACT
        //3. Run method and store result
        String resultat = adminController.endreKonto(konto1);

        //ASSERT
        //4. Compare expected result and actual result
        assertEquals(retur, resultat);
    }

    @Test
    public void endreKontoFeil() {
        //ARRANGE
        //1. Create transaction list + account.
        List<Transaksjon> transaksjonList = new ArrayList<>() {};
        Konto konto1 = new Konto("04081516234", "0123.45.67890", 30000, "Sparekonto",
                "NOK", transaksjonList);
        //2. Fake null return, store expected string result
        when(sjekk.loggetInn()).thenReturn(null);
        String retur = "Ikke innlogget";

        //ACT
        //3.Run method and store result
        String resultat = adminController.endreKonto(konto1);

        //ASSERT
        //4. Compare expected result and actual result
        assertEquals(retur, resultat);
    }

    @Test
    public void slettKonto() {
        //ARRANGE
        //1. Create kontonummer in a string.
        String kontonummer = "0123.45.67890";
        //2. Fake sjekk.loggetInn() and repository.slettKonto() return values.
        String personnummer = "04081516234";
        when(sjekk.loggetInn()).thenReturn(personnummer);
        String retur = "OK";
        when(repository.slettKonto(kontonummer)).thenReturn(retur);

        //ACT
        //3. Run controller method, store result
        String resultat = adminController.slettKonto(kontonummer);

        //ASSERT
        //4. Compare expected result vs actual result
        assertEquals(retur, resultat);

    }

    @Test
    public void slettKontoFeil() {
        //ARRANGE
        //1. Create kontonummer in a string.
        String kontonummer = "0123.45.67890";
        //2. Fake sjekk.loggetInn() and store expected string return values.
        when(sjekk.loggetInn()).thenReturn(null);
        String retur = "Ikke innlogget";

        //ACT
        //3. Run controller method and save result
        String resultat = adminController.slettKonto(kontonummer);

        //ASSERT
        //4. Compare results
        assertEquals(retur, resultat);
    }
}

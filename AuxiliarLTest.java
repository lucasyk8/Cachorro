

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste AuxiliarLTest.
 *
 *  @author Lucas Yugi Kumagai
 * @version 1.0 2021-06-15
 */
public class AuxiliarLTest
{
    /**
     * Construtor default para a classe de teste AuxiliarLTest
     */
    public AuxiliarLTest()
    {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void validarMovimento()
    {
        assertEquals(1, AuxiliarL.validarMovimentoLe(new String[][] {{"","00","00","D1",""},{"Le","00","00","00","D2"}, {"","00","00","D3",""}}, "Le", 1, 1));
    }
}








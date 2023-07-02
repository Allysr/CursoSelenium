package CodigoComPageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CampoDeTreinamentoTest {
    private CampoDeTreinamentoPage campoDeTreinamento;

    @Before
    public void antesDeCada(){
        campoDeTreinamento = new CampoDeTreinamentoPage();
        campoDeTreinamento.antesDeCada();
    }

    @After
    public void  depoisDeCada() {
        campoDeTreinamento.depoisDeCada();
    }

    @Test
    public void validarCadastro(){
        campoDeTreinamento.preencherCampoNome("Alicia");
        campoDeTreinamento.preencherCampoSobrenome("Souza");
        campoDeTreinamento.preencherCampoSexo("Feminino");
        campoDeTreinamento.preencherCampoComidaFavorita();
        campoDeTreinamento.preencherCampoEsportes();
        campoDeTreinamento.clicarNoBotaoCadastrar();

        Assert.assertEquals("Cadastrado!", campoDeTreinamento.mensagemSucessoAoCadastrar());
    }






}
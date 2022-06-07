package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Formulario;
import com.github.lipenathan.chillout.negocio.dominio.Pergunta;
import com.github.lipenathan.chillout.negocio.dominio.Psicologo;
import com.github.lipenathan.chillout.negocio.dominio.Resposta;
import com.github.lipenathan.chillout.negocio.processos.ProcessosCadastroFormulario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ViewScoped
@ManagedBean
public class CadastroFomularioController implements Serializable {

    private Psicologo psicologo = new Psicologo(1, "CRM01523/PR");
    private Formulario formulario = new Formulario();
    private List<Pergunta> perguntas = Arrays.asList(new Pergunta(), new Pergunta(), new Pergunta(true));
    private final ProcessosCadastroFormulario processosCadastroFormulario = new ProcessosCadastroFormulario();

    private FacesContext context;

    public void cadastrar() {
        context = FacesContext.getCurrentInstance();
        try {
            validarPerguntas();
            formulario.setPerguntas(perguntas);
            formulario.setPsicologo(psicologo);
            formulario.setQuantidadePerguntas(3);
            formulario.setDataCricao(Date.from(Instant.now()));
            System.out.println(formulario);
            processosCadastroFormulario.cadastrarFormulario(formulario);
            context.addMessage(null, new FacesMessage("Formulário cadastrado com sucesso"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
    }

    // métodos de apoio privados
    private void validarPerguntas() throws Exception {
        int onze = 0;
        for (Pergunta p: perguntas) {
            p.validar();
            onze++;
        }
        if (onze < 3) throw new Exception("Todas as 3 perguntas precisam ser preenchidas corretamente");
    }

    public Resposta getResposta(int pergunta, int resposta) {
        return perguntas.get(pergunta).getRespostas().get(resposta);
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
}
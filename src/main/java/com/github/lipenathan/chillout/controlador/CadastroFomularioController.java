package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.*;
import com.github.lipenathan.chillout.negocio.processos.ProcessosCadastroFormulario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ViewScoped
@ManagedBean
public class CadastroFomularioController extends AbstractFormulario implements Serializable {

    private Psicologo psicologo = new Psicologo(1, "CRM01254/PR");
    private Formulario formulario = new Formulario();
    private List<Pergunta> perguntas = Arrays.asList(new Pergunta(), new Pergunta(), new Pergunta(true));
    private final ProcessosCadastroFormulario processosCadastroFormulario = new ProcessosCadastroFormulario();
    private List<SelectItem> comboEmpresas = new ArrayList<>();
    private Long empresaSelecionada;

    private FacesContext context;

    public CadastroFomularioController() {
        montarComboEmpresas();
    }

    public void cadastrar() {
        context = FacesContext.getCurrentInstance();
        try {
            validarPerguntas();
            if (empresaSelecionada == null || empresaSelecionada < 1) throw new Exception("Selecione uma empresa");
            formulario.setPerguntas(perguntas);
            formulario.relacionarPerguntas();
            formulario.setPsicologo(psicologo);
            formulario.setQuantidadePerguntas(3);
            formulario.setDataCricao(Date.from(Instant.now()));
            formulario.setEmpresa(new Empresa(empresaSelecionada));
            System.out.println(formulario);
            processosCadastroFormulario.cadastrarFormulario(formulario);
            context.addMessage(null, new FacesMessage("Formulário cadastrado com sucesso"));
            limparCampos();
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

    private void montarComboEmpresas() {
        List<Empresa> empresas = processosCadastroFormulario.buscarEmpresas();
        empresas.forEach(e -> comboEmpresas.add(new SelectItem(e.getId(), e.getNome())));
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

    public List<SelectItem> getComboEmpresas() {
        return comboEmpresas;
    }

    public void setComboEmpresas(List<SelectItem> comboEmpresas) {
        this.comboEmpresas = comboEmpresas;
    }

    public Long getEmpresaSelecionada() {
        return empresaSelecionada;
    }

    public void setEmpresaSelecionada(Long empresaSelecionada) {
        this.empresaSelecionada = empresaSelecionada;
    }

    @Override
    void limparCampos() {
        formulario = new Formulario();
        perguntas = Arrays.asList(new Pergunta(), new Pergunta(), new Pergunta(true));
        comboEmpresas = new ArrayList<>();
        empresaSelecionada = null;
    }
}
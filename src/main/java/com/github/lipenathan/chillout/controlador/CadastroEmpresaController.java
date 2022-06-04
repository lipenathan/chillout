package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Empresa;
import com.github.lipenathan.chillout.negocio.dominio.Endereco;
import com.github.lipenathan.chillout.negocio.processos.ProcessosCadastroEmpresa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ViewScoped
@ManagedBean
public class CadastroEmpresaController implements Serializable {

    private Empresa empresa = new Empresa();
    private Endereco endereco = new Endereco();
    private String senha1;
    private String senha2;
    private final ProcessosCadastroEmpresa processosCadastroEmpresa = new ProcessosCadastroEmpresa();
    private FacesContext context;
    private List<SelectItem> comboRamos = carregarComboRamos();

    public void cadastrar() {
        context = FacesContext.getCurrentInstance();
        try {
            validarSenhas();
            empresa.setEnderecoEmpresa(endereco);
            processosCadastroEmpresa.cadastrar(empresa);
            context.addMessage(null, new FacesMessage("Empresa cadastrada com sucesso"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
    }

    // métodos de apoio privados
    private void validarSenhas() throws Exception {
        if (!senha1.equals(senha2)) {
            throw new Exception("As senhas precisam ser a mesma");
        }
    }

    private List<SelectItem> carregarComboRamos() {
        return Arrays.asList(new SelectItem("Comércio de Alimentos", "Comércio de Alimentos"),
                new SelectItem("Indústria Gráfica", "Indústria Gráfica"),
                new SelectItem("Indústria de Calçados", "Indústria de Calçados"),
                new SelectItem("Indústria de Bebidas", "Indústria de Bebidas"),
                new SelectItem("Indústria de Móveis", "Indústria de Móveis"),
                new SelectItem("Indústria de Automóveis", "Indústria de Automóveis"),
                new SelectItem("Indústria de Roupas", "Indústria de Roupas"),
                new SelectItem("Indústria de Laticínios", "Indústria de Laticínios"),
                new SelectItem("Indústria de Equipamentos Eletrônicos", "Indústria de Equipamentos Eletrônicos"),
                new SelectItem("Indústria de Cosméticos", "Indústria de Cosméticos"),
                new SelectItem("Comércio de Roupas", "Comércio de Roupas"),
                new SelectItem("Comércio de Medicamentos", "Comércio de Medicamentos"),
                new SelectItem("Comércio de Cosméticos", "Comércio de Cosméticos"),
                new SelectItem("Comércio de Alimentos", "Comércio de Alimentos"),
                new SelectItem("Comércio de Bebidas", "Comércio de Bebidas"),
                new SelectItem("Comércio de Ferragens", "Comércio de Ferragens"),
                new SelectItem("Comércio de Eletrônicos", "Comércio de Eletrônicos"),
                new SelectItem("Serviços de Psicologia", "Serviços de Psicologia"),
                new SelectItem("Serviços de Advocacia", "Serviços de Advocacia"),
                new SelectItem("Serviços de Odontologia", "Serviços de Odontologia"),
                new SelectItem("Serviços de Consultoria", "Serviços de Consultoria"),
                new SelectItem("Serviços de Lavanderia", "Serviços de Lavanderia"),
                new SelectItem("Serviços de Tatuagens", "Serviços de Tatuagens"),
                new SelectItem("Serviços de Educação", "Serviços de Educação"),
                new SelectItem("Serviços de Aviação ", "Serviços de Aviação"),
                new SelectItem("Serviços de Limpeza", "Serviços de Limpeza"),
                new SelectItem("Serviços de Construção", "Serviços de Construção "));
    }

    //getters & setters
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<SelectItem> getComboRamos() {
        return comboRamos;
    }

    public void setComboRamos(List<SelectItem> comboRamos) {
        this.comboRamos = comboRamos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
}

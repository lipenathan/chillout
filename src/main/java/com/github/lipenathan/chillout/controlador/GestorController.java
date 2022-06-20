package com.github.lipenathan.chillout.controlador;

import com.github.lipenathan.chillout.negocio.dominio.Funcionario;
import com.github.lipenathan.chillout.negocio.dominio.Usuario;
import com.github.lipenathan.chillout.negocio.fabrica.FabricaUsuario;
import com.github.lipenathan.chillout.negocio.processos.ProcessosGestor;
import com.github.lipenathan.chillout.utils.arquivos.ArquivoHandler;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

@ViewScoped
@Named
public class GestorController implements Serializable {
    private Funcionario gestor;
    private ProcessosGestor processosGestor;
    private FacesContext context;
    private Part arquivo;

    @Inject
    public GestorController(LoginController sessao) {
        context = FacesContext.getCurrentInstance();
        processosGestor = new ProcessosGestor();
        Usuario u = sessao.getUsuario();
        gestor = processosGestor.buscarGestorPeloId(u.getId());
        if (gestor == null) {
            context.addMessage(null, new FacesMessage("Não foi possível encontrar um gestor"));
        }
    }

    public void uploadArquivo() {
        if (arquivo != null && arquivo.getSize() > 0) {
            String nomeArquivo = ArquivoHandler.getNomeArquivo(arquivo);
            File savedFile = new File("C://Users/lipen/AppData/Local/Temp", nomeArquivo);
            try {
                InputStream input = arquivo.getInputStream();
                String path = savedFile.getPath();
                Files.copy(input, savedFile.toPath());
                FileReader f = new FileReader(path);
                BufferedReader bufReader = new BufferedReader(f);
                List<Funcionario> funcionarios = FabricaUsuario.fabricarFuncionarios(bufReader);
                relacionarFuncionariosEmpresa(funcionarios);
                processosGestor.cadastrarFuncionarios(funcionarios);
            } catch (Exception e) {
                context.addMessage(null, new FacesMessage("Erro ao salvar funcionários"));
            }
        }
    }

    private void relacionarFuncionariosEmpresa(List<Funcionario> funcionarios) {
        funcionarios.forEach(f -> {
            f.setEmpresa(gestor.getEmpresa());
        });
    }

    public Part getArquivo() {
        return arquivo;
    }

    public void setArquivo(Part arquivo) {
        this.arquivo = arquivo;
    }
}
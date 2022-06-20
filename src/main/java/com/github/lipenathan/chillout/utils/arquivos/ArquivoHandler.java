package com.github.lipenathan.chillout.utils.arquivos;

import javax.servlet.http.Part;

public class ArquivoHandler {
    private ArquivoHandler() {

    }

    public static String getNomeArquivo(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                String fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                return fileName;
            }
        }
        return null;
    }
}

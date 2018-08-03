package com.lgapontes.notepad_v1.util;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoHelper {

    public static String[] listarArquivos(Context context) {
        File diretorio = context.getFilesDir();
        return diretorio.list();
    }

    public static void salvarArquivo(Context context, String nome, String conteudo) throws IOException {
        FileOutputStream fileOutputStream = context.openFileOutput(nome, Context.MODE_PRIVATE);
        fileOutputStream.write(conteudo.getBytes());
        fileOutputStream.close();
    }

    public static String lerArquivo(Context context, String nome) throws IOException {
        FileInputStream fileInputStream = context.openFileInput(nome);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        StringBuilder conteudo = new StringBuilder();
        String linha;

        while ( (linha = reader.readLine()) != null) {
            conteudo.append(linha + "\n");
        }

        fileInputStream.close();
        return conteudo.toString();
    }

    public static void apagarArquivo(Context context, String nome) {
        String path = context.getFilesDir() + "/" + nome;
        File arquivo = new File(path);
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }

}


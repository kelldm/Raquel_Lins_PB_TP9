package org.example.repository;

import org.example.model.Funcionario;
import java.util.ArrayList;
import java.util.Date;

public class FuncionarioRepository {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public ArrayList<Funcionarios> list() {
        return funcionarios;
    }

    public ArrayList<Funcionario> findMany(Date data) {
        return funcionarios;
    }


}

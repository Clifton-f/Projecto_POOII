package com.company.Controller;

import com.company.Model.Conexao;
import com.company.Model.Funcionario;

import java.sql.Timestamp;
import java.util.ArrayList;

public class FuncionarioController {
    private Funcionario funcionario;
    private Conexao conexao = new Conexao();
    private String [][]lista;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public boolean login(String email, String password) {
        String[] valores = {email, password};
        String[] atributos = {"email", "password"};

        funcionario = conexao.consultaFuncionario(atributos, valores);

        if (funcionario == null) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addFuncionario(String nome, String apelido, Timestamp dataNascimento,String contacto, String email,
                                  String password){

        funcionario = new Funcionario(nome, apelido,dataNascimento,contacto,email,password);
        boolean sucesso = conexao.inserir(funcionario);

        return sucesso;
    }

    public String[][] lista(){


        ArrayList<Object> funcionarios = new ArrayList<>();
        funcionarios = conexao.consultalista(funcionario);
        lista = new String[funcionarios.size()][7];
        for(int i = 0; i<funcionarios.size();i++) {
            if(funcionarios.get(i) instanceof Funcionario){
                for (int j = 0; j < 7;i++) {
                    switch (j){
                        case 0:
                            lista[i][j] = String.valueOf(((Funcionario) funcionarios.get(i)).getIdFuncionaro());
                        break;
                        case 1:
                            lista[i][j] = String.valueOf(((Funcionario) funcionarios.get(i)).getNome());
                            break;
                        case 2:
                            lista[i][j] = String.valueOf(((Funcionario) funcionarios.get(i)).getApelido());
                            break;
                        case 3:
                            lista[i][j] = String.valueOf(((Funcionario) funcionarios.get(i)).getDataNascimento());
                            break;
                        case 4:
                            lista[i][j] = String.valueOf(((Funcionario) funcionarios.get(i)).getEmail());
                            break;
                        case 5:
                            lista[i][j] = String.valueOf(((Funcionario) funcionarios.get(i)).getContacto());
                            break;
                        case 6:
                            lista[i][j] = String.valueOf(((Funcionario) funcionarios.get(i)).getPassword());
                            break;
                    }
                }

            }



        }


        return lista;
    }

    public String[] pegarElemento(String id, int iterador) {
        if(lista[iterador][0] ==id){
            return lista[iterador];
        }
        else {
            return pegarElemento(id,iterador+1);
        }
    }

    public boolean actualizar(String idFuncionario, String nome, String apelido, Timestamp data,String email,
                              String contacto, String password,String []clnActualizadas){
        boolean sucesso = false;
        ArrayList<ArrayList<String>> lstParametros = new ArrayList<>();
        //ArrayList<String> parametrosQuery

        funcionario = new Funcionario(apelido,nome,data,contacto,email,password);
        funcionario.setIdFuncionaro(Integer.parseInt(idFuncionario));
        String []novosVlrs = new String[clnActualizadas.length];
        for(int i = 0;i<funcionario.toArray().length; i++) {
            boolean actualizado = false;
            for (int j = 0; j < clnActualizadas.length; j++) {
                if (funcionario.toArray()[i][0] == clnActualizadas[j]) {
                    novosVlrs[j] = funcionario.toArray()[i][1];


                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(funcionario.toArray()[i][0]);
                    arrayList.add(funcionario.toArray()[i][1]);
                    lstParametros.add(arrayList);


                }

            }
        }
        String []clnParametros = new String[lstParametros.size()];
        String []vlrParametros = new String[lstParametros.size()];



        for(int i = 0; i<lstParametros.size();i++){
            clnParametros[i] = lstParametros.get(i).get(0);
            vlrParametros[i] = lstParametros.get(i).get(1);
        }
        if(conexao.actualizar(funcionario,clnActualizadas,novosVlrs,clnParametros,vlrParametros)){
            sucesso = true;
        }else {
            sucesso = false;
        }



        return sucesso;
    }

    public static void main(String []args){

        FuncionarioController fc = new FuncionarioController();
        boolean verdade = fc.login("admin","admin");
        System.out.println(fc.funcionario);
        System.out.println(verdade);



    }
}

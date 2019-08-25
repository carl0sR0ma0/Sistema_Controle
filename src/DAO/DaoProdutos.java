/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author Carlos
 */
public class DaoProdutos extends ConexaoMySql {

    /**
     * Cadastrar um produto no banco
     *
     * @param pModelProdutos
     * @return
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produtos ("
                    + "pro_codigoPro,"
                    + "pro_nome,"
                    + "pro_tipo,"
                    + "pro_estoque"
                    + ") VALUE ("
                    + "'" + pModelProdutos.getCodPro() + "',"
                    + "'" + pModelProdutos.getProNome() + "',"
                    + "'" + pModelProdutos.getProTipo() + "',"
                    + "'" + pModelProdutos.getProEstoque() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Excluir um produto do banco
     *
     * @param pCodigoPro
     * @return boolean
     */
    public boolean excluirProdutoDAO(int pCodigoPro) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produtos WHERE pk_idProduto = '" + pCodigoPro + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Alterar dados do produto
     *
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produtos SET "
                    + "pro_codigoPro = '" + pModelProdutos.getCodPro() + "',"
                    + "pro_nome = '" + pModelProdutos.getProNome() + "',"
                    + "pro_tipo = '" + pModelProdutos.getProTipo() + "',"
                    + "pro_estoque = '" + pModelProdutos.getProEstoque() + "'"
                    + " WHERE pk_idProduto = '" + pModelProdutos.getIdProduto() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Retornar produto pelo codigo
     *
     * @param pIdProduto
     * @return modelProdutos
     */
    public ModelProdutos retornarProdutoDAO(int pIdProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_idProduto, "
                    + "pro_codigoPro,"
                    + "pro_nome,"
                    + "pro_tipo,"
                    + "pro_estoque "
                    + "FROM tbl_produtos WHERE pk_idProduto = '" + pIdProduto + "';");
            while (this.getResultSet().next()) {
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setCodPro(this.getResultSet().getInt(2));
                modelProdutos.setProNome(this.getResultSet().getString(3));
                modelProdutos.setProTipo(this.getResultSet().getString(4));
                modelProdutos.setProEstoque(this.getResultSet().getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * Retornar uma lista completa de produtos
     *
     * @return listaModelProdutos
     */
    public ArrayList<ModelProdutos> retornarListaProdutosDAO() {
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_idProduto, "
                    + "pro_codigoPro, "
                    + "pro_nome,"
                    + "pro_tipo,"
                    + "pro_estoque "
                    + "FROM tbl_produtos;");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setCodPro(this.getResultSet().getInt(2));
                modelProdutos.setProNome(this.getResultSet().getString(3));
                modelProdutos.setProTipo(this.getResultSet().getString(4));
                modelProdutos.setProEstoque(this.getResultSet().getInt(5));
                listaModelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutos;
    }
}

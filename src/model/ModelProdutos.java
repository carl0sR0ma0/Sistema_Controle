/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;

/**
 *
 * @author Carlos
 */
public class ModelProdutos {
    
    private int idProduto;
    private int codPro;
    private String proNome;
    private String proTipo;
    private int proEstoque;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the proNome
     */
    public String getProNome() {
        return proNome;
    }

    /**
     * @param proNome the proNome to set
     */
    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    /**
     * @return the proTipo
     */
    public String getProTipo() {
        return proTipo;
    }

    /**
     * @param proTipo the proTipo to set
     */
    public void setProTipo(String proTipo) {
        this.proTipo = proTipo;
    }

    /**
     * @return the proEstoque
     */
    public int getProEstoque() {
        return proEstoque;
    }

    /**
     * @param proEstoque the proEstoque to set
     */
    public void setProEstoque(int proEstoque) {
        this.proEstoque = proEstoque;
    }

    /**
     * @return the codPro
     */
    public int getCodPro() {
        return codPro;
    }

    /**
     * @param codPro the codPro to set
     */
    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }
}

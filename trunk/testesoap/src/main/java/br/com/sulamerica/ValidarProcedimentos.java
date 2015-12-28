
package br.com.sulamerica;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoBeneficiario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoPrestador" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoSolicitacao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="caraterSolicitacao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataPrevistaAtendimento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoInternacao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="regimeInternacao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qtdeDiarias" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="flgUsoVideo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="servicos" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}ServicoAutorizador" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codigoBeneficiario",
    "codigoPrestador",
    "tipoSolicitacao",
    "caraterSolicitacao",
    "dataPrevistaAtendimento",
    "tipoInternacao",
    "regimeInternacao",
    "qtdeDiarias",
    "flgUsoVideo",
    "servicos"
})
@XmlRootElement(name = "validarProcedimentos")
public class ValidarProcedimentos {

    @XmlElement(required = true)
    protected String codigoBeneficiario;
    @XmlElement(required = true)
    protected String codigoPrestador;
    @XmlElement(required = true)
    protected String tipoSolicitacao;
    @XmlElement(required = true)
    protected String caraterSolicitacao;
    @XmlElement(required = true)
    protected String dataPrevistaAtendimento;
    @XmlElement(required = true)
    protected String tipoInternacao;
    @XmlElement(required = true)
    protected String regimeInternacao;
    @XmlElement(required = true)
    protected BigInteger qtdeDiarias;
    @XmlElement(required = true)
    protected String flgUsoVideo;
    @XmlElement(required = true)
    protected List<ServicoAutorizador> servicos;

    /**
     * Gets the value of the codigoBeneficiario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBeneficiario() {
        return codigoBeneficiario;
    }

    /**
     * Sets the value of the codigoBeneficiario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBeneficiario(String value) {
        this.codigoBeneficiario = value;
    }

    /**
     * Gets the value of the codigoPrestador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPrestador() {
        return codigoPrestador;
    }

    /**
     * Sets the value of the codigoPrestador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPrestador(String value) {
        this.codigoPrestador = value;
    }

    /**
     * Gets the value of the tipoSolicitacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    /**
     * Sets the value of the tipoSolicitacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSolicitacao(String value) {
        this.tipoSolicitacao = value;
    }

    /**
     * Gets the value of the caraterSolicitacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaraterSolicitacao() {
        return caraterSolicitacao;
    }

    /**
     * Sets the value of the caraterSolicitacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaraterSolicitacao(String value) {
        this.caraterSolicitacao = value;
    }

    /**
     * Gets the value of the dataPrevistaAtendimento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataPrevistaAtendimento() {
        return dataPrevistaAtendimento;
    }

    /**
     * Sets the value of the dataPrevistaAtendimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataPrevistaAtendimento(String value) {
        this.dataPrevistaAtendimento = value;
    }

    /**
     * Gets the value of the tipoInternacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoInternacao() {
        return tipoInternacao;
    }

    /**
     * Sets the value of the tipoInternacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoInternacao(String value) {
        this.tipoInternacao = value;
    }

    /**
     * Gets the value of the regimeInternacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegimeInternacao() {
        return regimeInternacao;
    }

    /**
     * Sets the value of the regimeInternacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegimeInternacao(String value) {
        this.regimeInternacao = value;
    }

    /**
     * Gets the value of the qtdeDiarias property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQtdeDiarias() {
        return qtdeDiarias;
    }

    /**
     * Sets the value of the qtdeDiarias property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQtdeDiarias(BigInteger value) {
        this.qtdeDiarias = value;
    }

    /**
     * Gets the value of the flgUsoVideo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgUsoVideo() {
        return flgUsoVideo;
    }

    /**
     * Sets the value of the flgUsoVideo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgUsoVideo(String value) {
        this.flgUsoVideo = value;
    }

    /**
     * Gets the value of the servicos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicoAutorizador }
     * 
     * 
     */
    public List<ServicoAutorizador> getServicos() {
        if (servicos == null) {
            servicos = new ArrayList<ServicoAutorizador>();
        }
        return this.servicos;
    }

    /**
     * Sets the value of the servicos property.
     * 
     * @param servicos
     *     allowed object is
     *     {@link ServicoAutorizador }
     *     
     */
    public void setServicos(List<ServicoAutorizador> servicos) {
        this.servicos = servicos;
    }

}

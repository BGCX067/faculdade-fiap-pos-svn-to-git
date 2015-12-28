
package br.com.sulamerica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetornoAutorizador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetornoAutorizador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRetorno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descricaoStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mensagens" type="{http://autorizador.portalws.susis.sulamerica.com.br}ArrayOf_xsd_string"/>
 *         &lt;element name="nomeRegra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetornoAutorizador", namespace = "http://to.autorizador.portalws.susis.sulamerica.com.br", propOrder = {
    "codRetorno",
    "descricaoStatus",
    "mensagem",
    "mensagens",
    "nomeRegra",
    "status"
})
@XmlSeeAlso({
    RetornoServicoAutorizador.class,
    RetornoItemAutorizador.class
})
public class RetornoAutorizador {

    @XmlElement(required = true, nillable = true)
    protected String codRetorno;
    @XmlElement(required = true, nillable = true)
    protected String descricaoStatus;
    @XmlElement(required = true, nillable = true)
    protected String mensagem;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfXsdString mensagens;
    @XmlElement(required = true, nillable = true)
    protected String nomeRegra;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer status;

    /**
     * Gets the value of the codRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRetorno() {
        return codRetorno;
    }

    /**
     * Sets the value of the codRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRetorno(String value) {
        this.codRetorno = value;
    }

    /**
     * Gets the value of the descricaoStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    /**
     * Sets the value of the descricaoStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoStatus(String value) {
        this.descricaoStatus = value;
    }

    /**
     * Gets the value of the mensagem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Sets the value of the mensagem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Gets the value of the mensagens property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfXsdString }
     *     
     */
    public ArrayOfXsdString getMensagens() {
        return mensagens;
    }

    /**
     * Sets the value of the mensagens property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfXsdString }
     *     
     */
    public void setMensagens(ArrayOfXsdString value) {
        this.mensagens = value;
    }

    /**
     * Gets the value of the nomeRegra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeRegra() {
        return nomeRegra;
    }

    /**
     * Sets the value of the nomeRegra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeRegra(String value) {
        this.nomeRegra = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

}

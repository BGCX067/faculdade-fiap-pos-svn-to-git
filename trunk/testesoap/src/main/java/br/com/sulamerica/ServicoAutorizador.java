
package br.com.sulamerica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServicoAutorizador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServicoAutorizador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoServico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoServicoOrigem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descricaoServico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descricaoServicoOrigem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qtde" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicoAutorizador", namespace = "http://to.autorizador.portalws.susis.sulamerica.com.br", propOrder = {
    "codigoServico",
    "codigoServicoOrigem",
    "descricaoServico",
    "descricaoServicoOrigem",
    "qtde"
})
public class ServicoAutorizador {

    @XmlElement(required = true, nillable = true)
    protected String codigoServico;
    @XmlElement(required = true, nillable = true)
    protected String codigoServicoOrigem;
    @XmlElement(required = true, nillable = true)
    protected String descricaoServico;
    @XmlElement(required = true, nillable = true)
    protected String descricaoServicoOrigem;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer qtde;

    /**
     * Gets the value of the codigoServico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServico() {
        return codigoServico;
    }

    /**
     * Sets the value of the codigoServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServico(String value) {
        this.codigoServico = value;
    }

    /**
     * Gets the value of the codigoServicoOrigem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServicoOrigem() {
        return codigoServicoOrigem;
    }

    /**
     * Sets the value of the codigoServicoOrigem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServicoOrigem(String value) {
        this.codigoServicoOrigem = value;
    }

    /**
     * Gets the value of the descricaoServico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoServico() {
        return descricaoServico;
    }

    /**
     * Sets the value of the descricaoServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoServico(String value) {
        this.descricaoServico = value;
    }

    /**
     * Gets the value of the descricaoServicoOrigem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoServicoOrigem() {
        return descricaoServicoOrigem;
    }

    /**
     * Sets the value of the descricaoServicoOrigem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoServicoOrigem(String value) {
        this.descricaoServicoOrigem = value;
    }

    /**
     * Gets the value of the qtde property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQtde() {
        return qtde;
    }

    /**
     * Sets the value of the qtde property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQtde(Integer value) {
        this.qtde = value;
    }

}

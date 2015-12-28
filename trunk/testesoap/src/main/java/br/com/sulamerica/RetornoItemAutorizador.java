
package br.com.sulamerica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetornoItemAutorizador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetornoItemAutorizador">
 *   &lt;complexContent>
 *     &lt;extension base="{http://to.autorizador.portalws.susis.sulamerica.com.br}RetornoAutorizador">
 *       &lt;sequence>
 *         &lt;element name="codigoServico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descricaoServico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="linkDocumentoCentralAjuda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pacotes" type="{http://autorizador.portalws.susis.sulamerica.com.br}ArrayOf_tns1_ServicoAutorizador"/>
 *         &lt;element name="qtde" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetornoItemAutorizador", namespace = "http://to.autorizador.portalws.susis.sulamerica.com.br", propOrder = {
    "codigoServico",
    "descricaoServico",
    "linkDocumentoCentralAjuda",
    "pacotes",
    "qtde"
})
public class RetornoItemAutorizador
    extends RetornoAutorizador
{

    @XmlElement(required = true, nillable = true)
    protected String codigoServico;
    @XmlElement(required = true, nillable = true)
    protected String descricaoServico;
    @XmlElement(required = true, nillable = true)
    protected String linkDocumentoCentralAjuda;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfTns1ServicoAutorizador pacotes;
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
     * Gets the value of the linkDocumentoCentralAjuda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkDocumentoCentralAjuda() {
        return linkDocumentoCentralAjuda;
    }

    /**
     * Sets the value of the linkDocumentoCentralAjuda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkDocumentoCentralAjuda(String value) {
        this.linkDocumentoCentralAjuda = value;
    }

    /**
     * Gets the value of the pacotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTns1ServicoAutorizador }
     *     
     */
    public ArrayOfTns1ServicoAutorizador getPacotes() {
        return pacotes;
    }

    /**
     * Sets the value of the pacotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTns1ServicoAutorizador }
     *     
     */
    public void setPacotes(ArrayOfTns1ServicoAutorizador value) {
        this.pacotes = value;
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

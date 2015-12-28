
package br.com.sulamerica;

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
 *         &lt;element name="validarProcedimentosReturn" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}RetornoServicoAutorizador"/>
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
    "validarProcedimentosReturn"
})
@XmlRootElement(name = "validarProcedimentosResponse")
public class ValidarProcedimentosResponse {

    @XmlElement(required = true)
    protected RetornoServicoAutorizador validarProcedimentosReturn;

    /**
     * Gets the value of the validarProcedimentosReturn property.
     * 
     * @return
     *     possible object is
     *     {@link RetornoServicoAutorizador }
     *     
     */
    public RetornoServicoAutorizador getValidarProcedimentosReturn() {
        return validarProcedimentosReturn;
    }

    /**
     * Sets the value of the validarProcedimentosReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetornoServicoAutorizador }
     *     
     */
    public void setValidarProcedimentosReturn(RetornoServicoAutorizador value) {
        this.validarProcedimentosReturn = value;
    }

}

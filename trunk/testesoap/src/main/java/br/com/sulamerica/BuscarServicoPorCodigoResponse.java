
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
 *         &lt;element name="buscarServicoPorCodigoReturn" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}ServicoAutorizador"/>
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
    "buscarServicoPorCodigoReturn"
})
@XmlRootElement(name = "buscarServicoPorCodigoResponse")
public class BuscarServicoPorCodigoResponse {

    @XmlElement(required = true)
    protected ServicoAutorizador buscarServicoPorCodigoReturn;

    /**
     * Gets the value of the buscarServicoPorCodigoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ServicoAutorizador }
     *     
     */
    public ServicoAutorizador getBuscarServicoPorCodigoReturn() {
        return buscarServicoPorCodigoReturn;
    }

    /**
     * Sets the value of the buscarServicoPorCodigoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicoAutorizador }
     *     
     */
    public void setBuscarServicoPorCodigoReturn(ServicoAutorizador value) {
        this.buscarServicoPorCodigoReturn = value;
    }

}

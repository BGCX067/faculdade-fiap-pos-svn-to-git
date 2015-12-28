
package br.com.sulamerica;

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
 *         &lt;element name="buscarServicoPorDescricaoReturn" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}ServicoAutorizador" maxOccurs="unbounded"/>
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
    "buscarServicoPorDescricaoReturn"
})
@XmlRootElement(name = "buscarServicoPorDescricaoResponse")
public class BuscarServicoPorDescricaoResponse {

    @XmlElement(required = true)
    protected List<ServicoAutorizador> buscarServicoPorDescricaoReturn;

    /**
     * Gets the value of the buscarServicoPorDescricaoReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buscarServicoPorDescricaoReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuscarServicoPorDescricaoReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicoAutorizador }
     * 
     * 
     */
    public List<ServicoAutorizador> getBuscarServicoPorDescricaoReturn() {
        if (buscarServicoPorDescricaoReturn == null) {
            buscarServicoPorDescricaoReturn = new ArrayList<ServicoAutorizador>();
        }
        return this.buscarServicoPorDescricaoReturn;
    }

    /**
     * Sets the value of the buscarServicoPorDescricaoReturn property.
     * 
     * @param buscarServicoPorDescricaoReturn
     *     allowed object is
     *     {@link ServicoAutorizador }
     *     
     */
    public void setBuscarServicoPorDescricaoReturn(List<ServicoAutorizador> buscarServicoPorDescricaoReturn) {
        this.buscarServicoPorDescricaoReturn = buscarServicoPorDescricaoReturn;
    }

}

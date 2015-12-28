
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
 *         &lt;element name="buscarListaTipoInternacaoReturn" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}ListObjectTO" maxOccurs="unbounded"/>
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
    "buscarListaTipoInternacaoReturn"
})
@XmlRootElement(name = "buscarListaTipoInternacaoResponse")
public class BuscarListaTipoInternacaoResponse {

    @XmlElement(required = true)
    protected List<ListObjectTO> buscarListaTipoInternacaoReturn;

    /**
     * Gets the value of the buscarListaTipoInternacaoReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buscarListaTipoInternacaoReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuscarListaTipoInternacaoReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListObjectTO }
     * 
     * 
     */
    public List<ListObjectTO> getBuscarListaTipoInternacaoReturn() {
        if (buscarListaTipoInternacaoReturn == null) {
            buscarListaTipoInternacaoReturn = new ArrayList<ListObjectTO>();
        }
        return this.buscarListaTipoInternacaoReturn;
    }

    /**
     * Sets the value of the buscarListaTipoInternacaoReturn property.
     * 
     * @param buscarListaTipoInternacaoReturn
     *     allowed object is
     *     {@link ListObjectTO }
     *     
     */
    public void setBuscarListaTipoInternacaoReturn(List<ListObjectTO> buscarListaTipoInternacaoReturn) {
        this.buscarListaTipoInternacaoReturn = buscarListaTipoInternacaoReturn;
    }

}

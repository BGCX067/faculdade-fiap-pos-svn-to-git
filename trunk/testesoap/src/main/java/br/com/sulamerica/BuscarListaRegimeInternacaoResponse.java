
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
 *         &lt;element name="buscarListaRegimeInternacaoReturn" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}ListObjectTO" maxOccurs="unbounded"/>
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
    "buscarListaRegimeInternacaoReturn"
})
@XmlRootElement(name = "buscarListaRegimeInternacaoResponse")
public class BuscarListaRegimeInternacaoResponse {

    @XmlElement(required = true)
    protected List<ListObjectTO> buscarListaRegimeInternacaoReturn;

    /**
     * Gets the value of the buscarListaRegimeInternacaoReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buscarListaRegimeInternacaoReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuscarListaRegimeInternacaoReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListObjectTO }
     * 
     * 
     */
    public List<ListObjectTO> getBuscarListaRegimeInternacaoReturn() {
        if (buscarListaRegimeInternacaoReturn == null) {
            buscarListaRegimeInternacaoReturn = new ArrayList<ListObjectTO>();
        }
        return this.buscarListaRegimeInternacaoReturn;
    }

    /**
     * Sets the value of the buscarListaRegimeInternacaoReturn property.
     * 
     * @param buscarListaRegimeInternacaoReturn
     *     allowed object is
     *     {@link ListObjectTO }
     *     
     */
    public void setBuscarListaRegimeInternacaoReturn(List<ListObjectTO> buscarListaRegimeInternacaoReturn) {
        this.buscarListaRegimeInternacaoReturn = buscarListaRegimeInternacaoReturn;
    }

}

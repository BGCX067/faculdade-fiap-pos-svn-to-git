
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
 *         &lt;element name="buscarListaCaraterSolicitacaoReturn" type="{http://to.autorizador.portalws.susis.sulamerica.com.br}ListObjectTO" maxOccurs="unbounded"/>
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
    "buscarListaCaraterSolicitacaoReturn"
})
@XmlRootElement(name = "buscarListaCaraterSolicitacaoResponse")
public class BuscarListaCaraterSolicitacaoResponse {

    @XmlElement(required = true)
    protected List<ListObjectTO> buscarListaCaraterSolicitacaoReturn;

    /**
     * Gets the value of the buscarListaCaraterSolicitacaoReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buscarListaCaraterSolicitacaoReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuscarListaCaraterSolicitacaoReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListObjectTO }
     * 
     * 
     */
    public List<ListObjectTO> getBuscarListaCaraterSolicitacaoReturn() {
        if (buscarListaCaraterSolicitacaoReturn == null) {
            buscarListaCaraterSolicitacaoReturn = new ArrayList<ListObjectTO>();
        }
        return this.buscarListaCaraterSolicitacaoReturn;
    }

    /**
     * Sets the value of the buscarListaCaraterSolicitacaoReturn property.
     * 
     * @param buscarListaCaraterSolicitacaoReturn
     *     allowed object is
     *     {@link ListObjectTO }
     *     
     */
    public void setBuscarListaCaraterSolicitacaoReturn(List<ListObjectTO> buscarListaCaraterSolicitacaoReturn) {
        this.buscarListaCaraterSolicitacaoReturn = buscarListaCaraterSolicitacaoReturn;
    }

}


package br.com.sulamerica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetornoServicoAutorizador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetornoServicoAutorizador">
 *   &lt;complexContent>
 *     &lt;extension base="{http://to.autorizador.portalws.susis.sulamerica.com.br}RetornoAutorizador">
 *       &lt;sequence>
 *         &lt;element name="retornosItemAutorizador" type="{http://autorizador.portalws.susis.sulamerica.com.br}ArrayOf_tns1_RetornoItemAutorizador"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetornoServicoAutorizador", namespace = "http://to.autorizador.portalws.susis.sulamerica.com.br", propOrder = {
    "retornosItemAutorizador"
})
public class RetornoServicoAutorizador
    extends RetornoAutorizador
{

    @XmlElement(required = true, nillable = true)
    protected ArrayOfTns1RetornoItemAutorizador retornosItemAutorizador;

    /**
     * Gets the value of the retornosItemAutorizador property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTns1RetornoItemAutorizador }
     *     
     */
    public ArrayOfTns1RetornoItemAutorizador getRetornosItemAutorizador() {
        return retornosItemAutorizador;
    }

    /**
     * Sets the value of the retornosItemAutorizador property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTns1RetornoItemAutorizador }
     *     
     */
    public void setRetornosItemAutorizador(ArrayOfTns1RetornoItemAutorizador value) {
        this.retornosItemAutorizador = value;
    }

}

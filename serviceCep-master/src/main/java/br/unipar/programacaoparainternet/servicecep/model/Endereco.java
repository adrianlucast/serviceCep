package br.unipar.programacaointernet.servicecep.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.io.StringReader;

@XmlRootElement(name = "xmlcep")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ddd;
    private String siafi;
    private String cep;
    private String ibge;
    private String logradouro;
    private String complemento;
    private String gia;
    private String bairro;
    private String localidade;
    private String uf;


    public static Endereco unmarshalFromString(String stringXml)
            throws Exception  {
        JAXBContext context = null;
        context = JAXBContext.newInstance(Endereco.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(stringXml);
        return (Endereco) unmarshaller.unmarshal(reader);
    }

    @Override
    public String toString() {
        return "Endereço {" +
                "cep='" + cep + '\'' +
                ", ddd='" + ddd + '\'' +
                ", siafi='" + siafi + '\'' +
                ", bairro='" + bairro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", gia='" + gia + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge='" + ibge + '\'' +
                '}';

    }
}

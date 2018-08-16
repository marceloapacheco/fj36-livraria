package br.com.caelum.livraria.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.caelum.livraria.modelo.Pedido;

public class SerializadorXml {

	public String toXml(Pedido pedido) {
		Marshaller marshaler;
		StringWriter writer = new StringWriter();
		try {
			marshaler = JAXBContext.newInstance(Pedido.class).createMarshaller();
			marshaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaler.marshal(pedido, writer);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
		return writer.toString();
	}

}

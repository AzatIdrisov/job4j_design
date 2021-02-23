package ru.job4j.ood.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XMLReport implements Report {

    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            for (Employee employee : store.findBy(filter)) {
                marshaller.marshal(employee, writer);
                result.append(writer.getBuffer().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

package com.example.ccda_fhir_converter;

import com.example.ccda_fhir_converter.controller.PatientController;
import com.example.ccda_fhir_converter.model.XmlPatient;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class CcdaFhirConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcdaFhirConverterApplication.class, args);

		/*	try {
				// Create JAXB context for your XmlPatient class
				JAXBContext context = JAXBContext.newInstance(XmlPatient.class);

				// Create Unmarshaller to read XML
				Unmarshaller unmarshaller = context.createUnmarshaller();

				// Unmarshal (convert XML → Java object)
				File file = new File("src/main/resources/sample_patient.xml");
				XmlPatient patient = (XmlPatient) unmarshaller.unmarshal(file);


				// ✅ Print to verify
				System.out.println("Patient ID: " + patient.getId().getRoot());
				System.out.println("Given Name: " + patient.getName().getGiven());
				System.out.println("Family Name: " + patient.getName().getFamily());
				System.out.println("Gender: " + patient.getGender().getCode());
				System.out.println("Birth Date: " + patient.getBirthTime().getValue());
				System.out.println("Phone: " + patient.getTelecom().getValue());
				System.out.println("City: " + patient.getAddr().getCity());
				System.out.println("Country: " + patient.getAddr().getCountry());


			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
	}
}
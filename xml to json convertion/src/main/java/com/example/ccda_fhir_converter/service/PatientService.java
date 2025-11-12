package com.example.ccda_fhir_converter.service;

import ca.uhn.fhir.context.FhirContext;

import com.example.ccda_fhir_converter.model.XmlPatient;

import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Address;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import java.io.StringReader;

@Service
public class PatientService {

        public String convertXmlToFhirJson(String xmlData) throws Exception {

            JAXBContext jaxbContext = JAXBContext.newInstance(XmlPatient.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            XmlPatient xmlPatient = (XmlPatient) unmarshaller.unmarshal(new StringReader(xmlData));

            Patient patient = new Patient();

            patient.setId(xmlPatient.getId().getRoot());
            patient.addName()
                    .setFamily(xmlPatient.getName().getFamily())
                    .addGiven(xmlPatient.getName().getGiven());

            String genderCode = xmlPatient.getGender().getCode();
            if ("M".equalsIgnoreCase(genderCode)) patient.setGender(Enumerations.AdministrativeGender.MALE);
            else if ("F".equalsIgnoreCase(genderCode)) patient.setGender(Enumerations.AdministrativeGender.FEMALE);

            String birthDate = xmlPatient.getBirthTime().getValue();
            if (birthDate != null && birthDate.length() >= 8) {
                String formattedDate = birthDate.substring(0, 4) + "-" +
                        birthDate.substring(4, 6) + "-" +
                        birthDate.substring(6, 8);
                patient.setBirthDateElement(new DateType(formattedDate));
            }

            patient.addTelecom()
                    .setSystem(ContactPoint.ContactPointSystem.PHONE)
                    .setValue(xmlPatient.getTelecom().getValue());

            Address address = new Address()
                    .addLine(xmlPatient.getAddr().getLine())
                    .setCity(xmlPatient.getAddr().getCity())
                    .setCountry(xmlPatient.getAddr().getCountry());
            patient.addAddress(address);

            // Step 3: Convert FHIR object → JSON string
            FhirContext ctx = FhirContext.forR4();
            return ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
        }
    }



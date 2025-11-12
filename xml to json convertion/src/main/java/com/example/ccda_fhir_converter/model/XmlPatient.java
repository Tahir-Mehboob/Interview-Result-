package com.example.ccda_fhir_converter.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlPatient {

        @XmlElement(name = "id")
        private Id id;

        @XmlElement(name = "name")
        private Name name;

        @XmlElement(name = "gender")
        private Gender gender;

        @XmlElement(name = "birthTime")
        private BirthTime birthTime;

        @XmlElement(name = "telecom")
        private Telecom telecom;

        @XmlElement(name = "addr")
        private Address addr;

        // Getters and setters

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BirthTime getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(BirthTime birthTime) {
        this.birthTime = birthTime;
    }

    public Telecom getTelecom() {
        return telecom;
    }

    public void setTelecom(Telecom telecom) {
        this.telecom = telecom;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
        public static class Id {
            @XmlAttribute(name = "root")
            private String root;
            public String getRoot() { return root; }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Name {
            @XmlElement(name = "given")
            private String given;
            @XmlElement(name = "family")
            private String family;
            public String getGiven() { return given; }
            public String getFamily() { return family; }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Gender {
            @XmlAttribute(name = "code")
            private String code;
            public String getCode() { return code; }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class BirthTime {
            @XmlAttribute(name = "value")
            private String value;
            public String getValue() { return value; }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Telecom {
            @XmlAttribute(name = "value")
            private String value;
            public String getValue() { return value; }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Address {
            @XmlElement(name = "streetAddressLine")
            private String line;
            @XmlElement(name = "city")
            private String city;
            @XmlElement(name = "country")
            private String country;

            public String getLine() { return line; }
            public String getCity() { return city; }
            public String getCountry() { return country; }
        }
    }


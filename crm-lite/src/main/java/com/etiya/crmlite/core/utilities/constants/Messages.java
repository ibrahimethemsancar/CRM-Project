package com.etiya.crmlite.core.utilities.constants;

public class Messages {
    public static class Party {
    }

    public static class Customer {
        public static final String customerAdded = "customerAdded";
    }

    public static class Individual {
        public static final String individualAdded = "individualAdded";
        public static final String individualUpdated = "individualUpdated";
        public static final String individualExists = "individualExists";
        public static final String individualsListed = "individualsListed";
        public static final String individualNotFound = "individualNotFound";
    }

    public static class Address {
        public static final String addressAdded = "addressAdded";
        public static final String addressUpdated = "addressUpdated";
        public static final String addressDeleted = "addressDeleted";
        public static final String addressNotFound = "addressNotFound";
        public static final String addressListed = "addressListed";
    }

    public static class ContactMedium {
        public static final String contactInfoAdded = "contactInfoAdded";
        public static final String contactInfoUpdated = "contactInfoUpdated";
        public static final String contactInfoNotFound = "contactInfoNotFound";

    }

    public static class Validation {
        public static final String requiredField = "requiredField";
    }

    public static class Exception {
        public static final String businessException = "BUSINESS_EXCEPTION";
        public static final String validationException = "VALIDATION_EXCEPTION";
    }
}

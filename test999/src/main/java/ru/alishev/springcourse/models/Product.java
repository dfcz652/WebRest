package ru.alishev.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Product {
        private int id;

        @NotEmpty(message = "Name should not be empty")
        @Size(min = 2, max = 60, message = "Name should be between 2 and 30 characters")
        private String product;

        @Min(value = 0, message = "ERROR")
        private int s1price;

        @Min(value = 0, message = "ERROR")
        private int s1rest;

        @Min(value = 0, message = "ERROR")
        private int s2price;

        @Min(value = 0, message = "ERROR")
        private int s2rest;

        @Min(value = 0, message = "ERROR")
        private int s3price;

        @Min(value = 0, message = "ERROR")
        private int s3rest;

        @Min(value = 0, message = "ERROR")
        private long barcode;

        public Product() {

        }

        public Product(int id, String product, int s1price, String email) {
            this.id = id;
            this.product = product;
            this.s1price = s1price;
            this.s1price = s1price;
            this.s1price = s2price;
            this.s1price = s2price;
            this.s1price = s3price;
            this.s1price = s3price;
            this.barcode = barcode;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public int getS1price() {
            return s1price;
        }

        public int getS2price() {
            return s2price;
        }

        public int getS3price() {
            return s3price;
        }

        public void setS1price(int s1price) {
            this.s1price = s1price;
        }

        public void setS2price(int s2price) {
            this.s2price = s2price;
        }


        public void setS3price(int s3price) {
            this.s3price = s3price;
        }

        public long getBarcode(){return barcode;}

        public void setBarcode(long barcode){
            this.barcode = barcode;
        }

    public int getS1rest() {
        return s1rest;
    }

    public int getS2rest() {
        return s1rest;
    }

    public int getS3rest() {
        return s1rest;
    }

}

package com.ironhack.accountservice.model;

import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer imageId;
        private String imageName;
        private String imageType;

        @OneToOne
        @JoinColumn(name = "post")
        private Post post;

        //@Column(name = "picByte") //, length = 1000)
        @Lob
        @Type(type="org.hibernate.type.ImageType")
        private byte[] picByte;

        public Image() {
            super();
        }

        public Image(String name, String type, byte[] picByte) {
            this.imageName = name;
            this.imageType = type;
            this.picByte = picByte;
        }

        public Integer getId() {
            return imageId;
        }

        public void setId(Integer imageId) {
            this.imageId = imageId;
        }

        public String getName() {
            return imageName;
        }

        public void setName(String name) {
            this.imageName = name;
        }

        public String getType() {
            return imageType;
        }

        public void setType(String type) {
            this.imageType = type;
        }

        public byte[] getPicByte() {
            return picByte;
        }

        public void setPicByte(byte[] picByte) {
            this.picByte = picByte;
        }

}

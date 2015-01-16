package com.my.messages.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;




    @Entity
    @Table (name="message")
    public class Message{


        @Id
        @GeneratedValue(generator="increment")
        @GenericGenerator(name="increment", strategy = "increment")
        @Column(name="id")
        private Integer id;



        @NotEmpty(message = "Поле не должны быть пустыми!!!")
        @Column(name="nickname")
        private String nickname;

        @NotEmpty (message = "Поле не должны быть пустыми!!!")
        @Column(name="subject")
        private String subject;


        @Column(name="body")
        private String body;




        @ManyToOne
        @JoinColumn(name = "receiver_id")
        private User receiver;


        @ManyToOne
        @JoinColumn(name = "sender_id")
        private User sender;




        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public User getReceiver() {
            return receiver;
        }

        public void setReceiver(User receiver) {
            this.receiver = receiver;
        }


        public User getSender() {
            return sender;
        }

        public void setSender(User sender) {
            this.sender = sender;
        }
    }


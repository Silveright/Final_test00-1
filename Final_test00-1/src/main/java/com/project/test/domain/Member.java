package com.project.test.domain;
//관리자 회원 조회용 DTO
   public class Member {
      private String id;
      
      //member_joinForm.jsp에서 비밀번호 name속성 값을 확인해주세요
      private String password;
      private String name;
      private int age;
      private String gender;
      private String email;

      private String auth="ROLE_MEMBER";
      
      public String getAuth() {
         return auth;
      }
      private String joindate;
      private int rnum;
      private String group_name;
      private String cnt;
      private String catename;
      private String userid;
      
      public String getCatename() {
         return catename;
      }

      public void setCatename(String catename) {
         this.catename = catename;
      }

      public String getGroup_name() {
         return group_name;
      }

      public void setGroup_name(String group_name) {
         this.group_name = group_name;
      }

      public String getCnt() {
         return cnt;
      }

      public void setCnt(String cnt) {
         this.cnt = cnt;
      }

      public int getRnum() {
         return rnum;
      }

      public void setRnum(int rnum) {
         this.rnum = rnum;
      }

      public String getUserid() {
         return getUserid();
      }

      public void setUserid(String userid) {
         this.userid = userid;

      }
      public void setAuth(String auth) {
         this.auth = auth;
      }
      public String getId() {
         return id;
      }
      public void setId(String id) {
         this.id = id;
      }
      public String getPassword() {
         return password;
      }
      public void setPassword(String password) {
         this.password = password;
      }
      public String getName() {
         return name;
      }
      public void setName(String name) {
         this.name = name;
      }
      public int getAge() {
         return age;
      }
      public void setAge(int age) {
         this.age = age;
      }
      public String getGender() {
         return gender;
      }
      public void setGender(String gender) {
         this.gender = gender;
      }
      public String getEmail() {
         return email;
      }
      public void setEmail(String email) {
         this.email = email;
      }
   }
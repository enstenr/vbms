package hibernateconfig.hbm;
// Generated Jan 23, 2012 6:57:48 AM by Hibernate Tools 3.4.0.CR1



/**
 * VbmsScheme generated by hbm2java
 */
public class VbmsScheme  implements java.io.Serializable {


     private int schemeid;
     private String schemename;
     private String schemedescription;
     private String startdate;
     private String enddate;
     private String agelowerlimit;
     private String ageupperlimit;
     private String gender;
     private String area;
     private String status;

    public VbmsScheme() {
    }

	
    public VbmsScheme(int schemeid) {
        this.schemeid = schemeid;
    }
    public VbmsScheme(int schemeid, String schemename, String schemedescription, String startdate, String enddate, String agelowerlimit, String ageupperlimit, String gender, String area, String status) {
       this.schemeid = schemeid;
       this.schemename = schemename;
       this.schemedescription = schemedescription;
       this.startdate = startdate;
       this.enddate = enddate;
       this.agelowerlimit = agelowerlimit;
       this.ageupperlimit = ageupperlimit;
       this.gender = gender;
       this.area = area;
       this.status = status;
    }
   
    public int getSchemeid() {
        return this.schemeid;
    }
    
    public void setSchemeid(int schemeid) {
        this.schemeid = schemeid;
    }
    public String getSchemename() {
        return this.schemename;
    }
    
    public void setSchemename(String schemename) {
        this.schemename = schemename;
    }
    public String getSchemedescription() {
        return this.schemedescription;
    }
    
    public void setSchemedescription(String schemedescription) {
        this.schemedescription = schemedescription;
    }
    public String getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    public String getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    public String getAgelowerlimit() {
        return this.agelowerlimit;
    }
    
    public void setAgelowerlimit(String agelowerlimit) {
        this.agelowerlimit = agelowerlimit;
    }
    public String getAgeupperlimit() {
        return this.ageupperlimit;
    }
    
    public void setAgeupperlimit(String ageupperlimit) {
        this.ageupperlimit = ageupperlimit;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}



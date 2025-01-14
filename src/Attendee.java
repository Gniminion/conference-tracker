public class Attendee 
{
    private String fName;
    private String lName;
    private int age;
    private String contactEmail;
    private String contactPhone;
    private String[] interests;
    private boolean attendance;

    public Attendee (String fName,String lName,int age) // allows the creation of the attendee object
    {
        //instantiates an attendee with essential information: name and age
        this.fName=fName;
        this.lName=lName;
        this.age=age;
        //creates a sufficent empty array of interests
        interests = new String[5];
        for(int i=0; i<interests.length;i++)
        {
            interests[i]="";
        }     
    }

    //general setters and getters:
    public String getFName() 
    {
        return this.fName;
    }

    public void setFName(String fName) 
    {
        this.fName = fName;
    }

    public String getLName() 
    {
        return this.lName;
    }

    public void setLName(String lName) 
    {
        this.lName = lName;
    }

    public int getAge() 
    {
        return this.age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public String getContactEmail() 
    {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) 
    {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() 
    {
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public boolean getAttendance() 
    {
        return this.attendance;
    }
    
    public String getAttendanceText() 
    //returns text instead of boolean value which can be used for display
    {
        if(attendance)
        {
            return "Present";
        }
        else
        {
            return "Absent";
        }
        
    }

    public void setAttendance(boolean attendance) 
    {
        this.attendance = attendance;
    }

    public String getInterest()
    //returns interest as a string value, which can be used for ticket or application display
    {
        String interestStr="";
        for (int i=0; !"".equals(interests[i]) && i<interests.length; i++)
        {
            interestStr=interestStr + ", " + interests[i];
        }
        if(!"".equals(interestStr))
        {
            interestStr=interestStr.substring(1,interestStr.length());
        }
        return interestStr;
    }

    public void addInterest(String interest) 
    //adds an interest to the end of the array
    {
        for(int i=0; i<interests.length;i++)
        {
            if("".equals(interests[i]))
            {
                interests[i]=interest;
                i=interests.length;
            }
        }
    }
    
}

import java.util.Iterator;
import java.util.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AttendeeList //Allows all associated actions for a list of attendees (dependency on attendee class)
{
    private LinkedList <Attendee> list;
    private static int currStudentCount; //a static variable that keeps track of student attendee count
    private static int currMediaCount;//a static variable that keeps track of media attendee count
    
    public AttendeeList()
    {
        //instansiates new linked list of attendees
        list=new LinkedList<Attendee>();
        currStudentCount=0;
        currMediaCount=0;
    }

    public void addAtt(Attendee att)
    {
        list.add(att);
        if (att instanceof StudentAttendee)
        {
            currStudentCount++;
        }
        else if (att instanceof MediaAttendee)
        {
            currMediaCount++;
        }
    }

    public void deleteAtt(int index)
    {
        if (list.get(index) instanceof StudentAttendee)
        {
            currStudentCount--;
        }
        else if (list.get(index) instanceof MediaAttendee)
        {
            currMediaCount--;
        }
        list.remove(index); 
    }
    // add and delete methods utilizes the built in java linked list method

    public Attendee getAtt(int index)
    {
        return list.get(index);
    }

    //searches for name and returns index
    public int search(String name)
    {
        //a negative number to represent nothing is found
        int index=-999;
        for (int i=0; i<list.size(); i++)
        {
            String fullName= list.get(i).getFName() + " " + list.get(i).getLName();
            if(list.get(i).getFName().equalsIgnoreCase(name) || list.get(i).getLName().equalsIgnoreCase(name) || fullName.equalsIgnoreCase(name))
            // Ensures first, last, and full name can be used to search, where upper or lower cases does not matter
            {
                index=i;
                i=list.size();
            }
        }
        return index;
    }

    public void importExcel(File file) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet attendeeSheet = workbook.getSheetAt(0);

        //Iterating through each row, creating a new attendee in the list
        Iterator<Row> rowIterator = attendeeSheet.iterator();
        Row row = rowIterator.next();
        while (rowIterator.hasNext())
        {
            row=rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i=0;
            //temp values needed for the attributes of an attendee
            String tempFName="";
            String tempLName="";
            int tempAge=-99;
            String tempCPhone="";
            String tempCMail="";
            String tempOrganization="";
            String tempPosition="";
            String tempInterest="";
            String tempAttendence="";
            while(cellIterator.hasNext())
            {
                //each column corresponds with a certain attribute
                Cell cell = cellIterator.next(); 
                if(i==0)
                {
                    tempFName=cell.getStringCellValue(); 
                }
                else if(i==1)
                {
                    tempLName=cell.getStringCellValue();
                }
                else if(i==2)
                {
                    tempAge=(int) cell.getNumericCellValue();
                }
                else if(i==3)
                {
                    tempCPhone=cell.getStringCellValue();
                }
                else if(i==4)
                {
                    tempCMail=cell.getStringCellValue();
                }
                else if(i==5)
                {
                    tempPosition=cell.getStringCellValue();
                }
                else if(i==6)
                {
                    tempOrganization=cell.getStringCellValue();
                }
                else if(i==7)
                {
                    tempInterest=cell.getStringCellValue();             
                }
                else if(i==8)
                {
                    tempAttendence=cell.getStringCellValue();
                }
                i++;
            } 
            //Checking for type of attendee, since different types contain different job position and parameters
            if (tempPosition.equals("Research Student"))
            {
                StudentAttendee tempAttendee = new StudentAttendee(tempFName, tempLName, tempAge);
                //sets empty values if either contact is not available
                tempAttendee.setContactPhone("");
                tempAttendee.setContactEmail("");
                if(!tempCPhone.equals("N/A"))
                {
                    tempAttendee.setContactPhone(tempCPhone);
                }
                if(!tempCMail.equals("N/A"))
                {
                    tempAttendee.setContactEmail(tempCMail);
                }
                //Adds String value from Excel to interests array
                int interestStart=0;
                for (int j=0;j<tempInterest.length(); j++)
                {
                    if(tempInterest.substring(j,j+1).equals(","))
                    {
                        tempAttendee.addInterest(tempInterest.substring(interestStart,j));                            
                        interestStart=j+1;
                    }
                }
                //Confirms attendee attendance 
                if(tempAttendence.equals("YES"))
                {
                    tempAttendee.setAttendance(true);
                }
                else if(tempAttendence.equals("NO"))
                {
                    tempAttendee.setAttendance(false);
                }
                list.add(tempAttendee);
                currStudentCount++;
            }
            else if (tempPosition.equals("Media Personnel"))
            {
                MediaAttendee tempAttendee = new MediaAttendee(tempFName, tempLName, tempAge, tempOrganization);
                tempAttendee.setContactPhone("");
                tempAttendee.setContactEmail("");
                if(!tempCPhone.equals("N/A"))
                {
                    tempAttendee.setContactPhone(tempCPhone);
                }
                if(!tempCMail.equals("N/A"))
                {
                    tempAttendee.setContactEmail(tempCMail);
                }
                int interestStart=0;
                for (int j=0;j<tempInterest.length(); j++)
                {
                    if(tempInterest.substring(j,j+1).equals(","))
                    {
                        tempAttendee.addInterest(tempInterest.substring(interestStart,j));                            
                        interestStart=j+1;
                    }
                }
                if(tempAttendence.equals("YES"))
                {
                    tempAttendee.setAttendance(true);
                }
                else if(tempAttendence.equals("NO"))
                {
                    tempAttendee.setAttendance(false);
                }
                list.add(tempAttendee);
                currMediaCount++;
            }
            else
            {
                OtherAttendee tempAttendee = new OtherAttendee(tempFName, tempLName, tempAge, tempPosition);
                tempAttendee.setContactPhone("");
                tempAttendee.setContactEmail("");
                tempAttendee.setOrganization("");
                if(!tempCPhone.equals("N/A"))
                {
                    tempAttendee.setContactPhone(tempCPhone);
                }
                if(!tempCMail.equals("N/A"))
                {
                    tempAttendee.setContactEmail(tempCMail);
                }
                if(!tempOrganization.equals("N/A"))
                {
                    tempAttendee.setOrganization(tempOrganization);
                }
                int interestStart=0;
                for (int j=0;j<tempInterest.length(); j++)
                {
                    if(tempInterest.substring(j,j+1).equals(","))
                    {
                        tempAttendee.addInterest(tempInterest.substring(interestStart,j));                            
                        interestStart=j+1;
                    }
                }
                if(tempAttendence.equals("YES"))
                {
                    tempAttendee.setAttendance(true);
                }
                else if(tempAttendence.equals("NO"))
                {
                    tempAttendee.setAttendance(false);
                }
                list.add(tempAttendee);
            }    
        }
        workbook.close();
        inputStream.close();
        //referenced from https://howtodoinjava.com/java/library/readingwriting-excel-files-in-java-poi-tutorial/
    }

    public void exportExcel(File file) throws Exception
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("AttendeeList");

        //creates headings
        String [] headings= {"First Name", "Last Name", "Age", "Contact Phone", "Contact Email",  "Position", "Organization", "Interested Fields", "Attendance"};
        Row headerRow=sheet.createRow(0);
        for(int i=0;i<headings.length;i++)
        {
            Cell cell=headerRow.createCell(i);
            cell.setCellValue(headings[i]);
        }
        
        for(int j=0;j<list.size();j++)
        {
            Row row=sheet.createRow(j+1); //skips first row as headings
            row.createCell(3).setCellValue("N/A");
            row.createCell(4).setCellValue("N/A");
            row.createCell(5).setCellValue("Research Student");
            //defaults attendee type as a student
            row.createCell(6).setCellValue("N/A");

	    row.createCell(0).setCellValue(list.get(j).getFName());
	    row.createCell(1).setCellValue(list.get(j).getLName());
            row.createCell(2).setCellValue(list.get(j).getAge());
	    if(list.get(j).getContactPhone()!=null)
            {
                row.createCell(3).setCellValue(list.get(j).getContactPhone());
            }
            else if(list.get(j).getContactEmail()!=null)
            {
                row.createCell(4).setCellValue(list.get(j).getContactEmail());
            }
            //assumes only one contact info can be empty
            
            if (list.get(j) instanceof MediaAttendee)
            {
                row.createCell(5).setCellValue("Media Personnel");
                row.createCell(6).setCellValue(((MediaAttendee) list.get(j)).getOrganization());
            }
            else if(list.get(j) instanceof OtherAttendee)
            {
                if(((OtherAttendee) list.get(j)).getOrganization()!=null)
                {
                    row.createCell(6).setCellValue(((OtherAttendee) list.get(j)).getOrganization());
                }
                row.createCell(5).setCellValue(((OtherAttendee) list.get(j)).getOccupation());  
            }
            //depending on type of attendee, fills required fields
            if(list.get(j).getInterest()!=null)
            {
                row.createCell(7).setCellValue(list.get(j).getInterest());
            }
            if(list.get(j).getAttendance())
            {
                row.createCell(8).setCellValue("YES");
            }
            else if(!list.get(j).getAttendance())
            {
                row.createCell(8).setCellValue("NO");
            }
            //sets interest and attendance        
        }

        FileOutputStream outstream=new FileOutputStream(file);
        workbook.write(outstream);
        outstream.close();
        //referenced from https://www.geeksforgeeks.org/how-to-write-data-into-excel-sheet-using-java/
    }

    //Statistics related methods:
    
    public int totalCount()
    {
        return list.size();
    }

    public int studentCount() 
    {
        return currStudentCount;
        //Uses static attribute currStudentCount
    }

    public int mediaCount() 
    {
        return currMediaCount;
        //Uses static attribute currMediaCount
    }

    public int otherCount(String occupation)
    {
        //counts total attendees with the occupration entered
        int count=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i) instanceof OtherAttendee)
            {
                OtherAttendee tempAtt= (OtherAttendee) list.get(i);
                if(tempAtt.getOccupation().equalsIgnoreCase(occupation))
                {
                    count++;
                }    
            }
        }
        return count;
    }
    
    public Attendee[] absentList()
    {
        //checks for attendee who are absent, and returns them in an array for display use
        Attendee [] abList= new Attendee[list.size()];
        int listCount=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getAttendance()==false)
            {
                abList[listCount] = list.get(i);
                listCount++;
            }
        }
        return abList;
    }
}

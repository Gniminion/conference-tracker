import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.nio.file.Path;

public class AttendeeTicket //Allows the generation of the ticket object
{
    private String Tname;
    private String Tinterests;
    private String Tposition;
    private String type;

    public AttendeeTicket (Attendee att) 
    //Sets up nessesary information for the ticket of an attendee
    {
        Tname=att.getFName () + " " + att.getLName();
        Tinterests=att.getInterest();
        if (att instanceof StudentAttendee)
        {
            Tposition="Research Student";
            type="Student";
        }
        else if (att instanceof MediaAttendee)
        {
            Tposition="Media Personnel";
            type="Media";
        }
        else if (att instanceof OtherAttendee)
        {
            Tposition=((OtherAttendee) att).getOccupation();
            type="Other";
        }
    }

    public void generate(String fileName, String folderPath) throws IOException
    {
        //creates pdf document
        PDDocument document = new PDDocument();
        PDRectangle size = new PDRectangle(900,300);
        PDPage page = new PDPage(size);
        document.addPage(page);

        //sets size
        int pageWidth = (int) page.getTrimBox().getWidth();
        int pageHeight = (int) page.getTrimBox().getHeight();

        //sets font
        PDFont fontmain = PDType1Font.TIMES_BOLD;
        PDFont fontsub = PDType1Font.TIMES_ROMAN;
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        //sets color border depending on type of attendee
        if(type.equals("Student"))
        {
            contentStream.setNonStrokingColor(0, 200, 50);
        }
        else if(type.equals("Media"))
        {
            contentStream.setNonStrokingColor(255, 80, 80);
        }
        else
        {
            contentStream.setNonStrokingColor(70, 120, 250);
        }
        contentStream.addRect(0,pageHeight-50,pageWidth,50);
        contentStream.fill();

        //Name Display
        contentStream.beginText();
        contentStream.setFont(fontmain, 40);
        contentStream.setNonStrokingColor(0,0,0);
        String text1 = Tname;
        contentStream.newLineAtOffset(pageWidth-850, pageHeight-120);
        contentStream.showText(text1);
        contentStream.endText();

        //Position Display
        contentStream.beginText();
        contentStream.setFont(fontsub, 30);
        contentStream.setNonStrokingColor(0,0,0);
        String text2 = Tposition;
        contentStream.newLineAtOffset(pageWidth-850, pageHeight-170);
        contentStream.showText(text2);
        contentStream.endText();

        //Interests Display
        contentStream.beginText();
        contentStream.setFont(fontsub, 20);
        contentStream.setNonStrokingColor(0,0,0);
        String text3 = "Fields of Interest: " + Tinterests;
        contentStream.newLineAtOffset(pageWidth-850, pageHeight-250);
        contentStream.showText(text3);
        contentStream.endText();

        //Time Display
        contentStream.beginText();
        contentStream.setFont(fontmain, 25);
        contentStream.setNonStrokingColor(0,0,0);
        String text4 = "Time of Entry: " + getTime();
        contentStream.newLineAtOffset(pageWidth-450, pageHeight-170);
        contentStream.showText(text4);
        contentStream.endText();

        //saves to a folder
        contentStream.close();
        document.save(folderPath+fileName+".pdf");
        document.close();
        //referenced from https://youtu.be/msD7TtIh48s
    }

    public String getTime() 
    {
        //gets local time of the system, down to the second
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return(pattern.format(now)); 
    }

    public String getTName() 
    {
        return this.Tname;
    }

    public void setTName(String name) 
    {
        this.Tname = name;
    }

    public String getTInterests() 
    {
        return this.Tinterests;
    }

    public void setTInterests(String interests) 
    {
        this.Tinterests = interests;
    }

    public String getPosition() 
    {
        return this.Tposition;
    }

    public void setPosition(String position) 
    {
        this.Tposition = position;
    }

    public String getType() 
    {
        return this.type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }
    
}
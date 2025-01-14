import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ConferenceTrackerApp extends javax.swing.JFrame //Sets up GUI - program interface
{
    AttendeeList attList = new AttendeeList();
    //creates new model for Jlist display
    DefaultListModel attModel = new DefaultListModel();
    int attModelCount=0;
    //Sets up folder directory used to save tickets
    String selectedTicketFolder=null;

    //method used to set optional attendee attributes
    public void setNonEssentials(Attendee att)
    {
        if(TFCMail.getText()!=null)
        {
            String contactEmail = TFCMail.getText();
            att.setContactEmail(contactEmail);
            
        }
        if(TFCPhone.getText()!=null)
        {
            String contactPhone = TFCPhone.getText(); 
            att.setContactPhone(contactPhone);       
        }
         
        if(cBtnPolicies.isSelected())
        {
            att.addInterest("Prevention Policies");
        }
        
        if(cBtnVaccine.isSelected())
        {
            att.addInterest("Vaccine Development");
        }
        
        if(cBtnTreatment.isSelected())
        {
            att.addInterest("Clinical Treatment");
        }
    }
    
    public void clearAdd()
    {  
    //Resets all add attendee tab fields
        TFName.setText(null);
        TFLName.setText(null);
        TFAge.setText(null);
        TFOrganization.setText(null);
        TFJob.setText(null);
        TFCMail.setText(null);
        TFCPhone.setText(null);
        BtnInvisible.setSelected(true);
        cBtnVaccine.setSelected(false);
        cBtnTreatment.setSelected(false);
        cBtnPolicies.setSelected(false);
        cBtnVaccine.setEnabled(true);
        cBtnTreatment.setEnabled(true);
        LblJob.setEnabled(true);
        LblJob.setText("Job position:");
        TFJob.setEnabled(true);
        LblOrganization.setEnabled(true);
        LblOrganization.setText("Organization:");
        TFOrganization.setEnabled(true);
    }
    
    public void addToAttList(String fName,String lName)
    //method used to add attendee to displayed lists
    {
        String attDisplay = (attModelCount+1) + " ｜ " + fName +" "+ lName +" ｜ Absent" ;
        attModel.add(attModelCount, attDisplay);
        attModelCount++;
        JOptionPane.showMessageDialog(null, "Attendee Added");
        clearAdd();
    }
    
    
    public ConferenceTrackerApp()
    {
        //Warning message before closing
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                int pane= JOptionPane.showConfirmDialog(null, "Do you want to save before exiting?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                //Considers 3 scenarios - 
                //one where user does not want to save, 
                //one that saves, and one where user wants to continue using the application
                if(pane==JOptionPane.YES_OPTION)
                {
                    try
                    {
                        ExcelFileChooser.showSaveDialog(null);
                        File exportFile = ExcelFileChooser.getSelectedFile();
                        if(ExcelFileChooser.getSelectedFile()==null)
                        {  
                            System.out.println("Cancelled");
                        }
                        else
                        {               
                            attList.exportExcel(exportFile);
                            JOptionPane.showMessageDialog(null, "Successfully Exported");
                            e.getWindow().dispose();
                            //only closes if the application saves successfully
                        }
                    }
                    catch (Exception ex)
                    {
                        Logger.getLogger(ConferenceTrackerApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if (pane==JOptionPane.NO_OPTION)
                {
                    e.getWindow().dispose();
                }
                else
                {
                    System.out.println("Cancelled");
                }
            }
            
        });
        //referenced from https://youtu.be/GTFQi5McbzE  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        BtnAttendenceG = new javax.swing.ButtonGroup();
        BtnPositionG = new javax.swing.ButtonGroup();
        ExcelFileChooser = new javax.swing.JFileChooser();
        BtnInvisible = new javax.swing.JRadioButton();
        TicketFolderChooser = new javax.swing.JFileChooser();
        TabAtt = new javax.swing.JTabbedPane();
        PnAttList = new javax.swing.JPanel();
        SPAttList = new javax.swing.JScrollPane();
        JAttList = new javax.swing.JList<>();
        BtnSearch = new javax.swing.JButton();
        TFSearch = new javax.swing.JTextField();
        Separator1 = new javax.swing.JSeparator();
        BtnAttDetails = new javax.swing.JButton();
        BtnImportEx = new javax.swing.JButton();
        BtnExportEx = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        SPDetails = new javax.swing.JScrollPane();
        TAttDetails = new javax.swing.JTextArea();
        Separator2 = new javax.swing.JSeparator();
        BtnPresent = new javax.swing.JButton();
        BtnAbsent = new javax.swing.JButton();
        LblSetAttendence = new javax.swing.JLabel();
        PnAddAtt = new javax.swing.JPanel();
        LblFName = new javax.swing.JLabel();
        LblLName = new javax.swing.JLabel();
        TFName = new javax.swing.JTextField();
        TFLName = new javax.swing.JTextField();
        LblAge = new javax.swing.JLabel();
        TFAge = new javax.swing.JTextField();
        LblCMail = new javax.swing.JLabel();
        TFCMail = new javax.swing.JTextField();
        LblCPhone = new javax.swing.JLabel();
        TFCPhone = new javax.swing.JTextField();
        rBtnMedia = new javax.swing.JRadioButton();
        rBtnStudent = new javax.swing.JRadioButton();
        LblJob = new javax.swing.JLabel();
        TFJob = new javax.swing.JTextField();
        LblOrganization = new javax.swing.JLabel();
        TFOrganization = new javax.swing.JTextField();
        LblInterest = new javax.swing.JLabel();
        cBtnTreatment = new javax.swing.JCheckBox();
        cBtnVaccine = new javax.swing.JCheckBox();
        cBtnPolicies = new javax.swing.JCheckBox();
        AddSep1 = new javax.swing.JSeparator();
        AddSep2 = new javax.swing.JSeparator();
        BtnAddAtt = new javax.swing.JButton();
        BtnClearAdd = new javax.swing.JButton();
        PnTicket = new javax.swing.JPanel();
        SPTicketList = new javax.swing.JScrollPane();
        JAttListTicket = new javax.swing.JList<>();
        BtnSearchT = new javax.swing.JButton();
        TFSearchT = new javax.swing.JTextField();
        TSeparator1 = new javax.swing.JSeparator();
        BtnTicketDetails = new javax.swing.JButton();
        BtnGenerateTicket = new javax.swing.JButton();
        SPTicketDetails = new javax.swing.JScrollPane();
        TATicketDetails = new javax.swing.JTextArea();
        TSeparator2 = new javax.swing.JSeparator();
        BtnTicketFolder = new javax.swing.JButton();
        LblPath = new javax.swing.JLabel();
        BtnGenerateAll = new javax.swing.JButton();
        PnStats = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAStats = new javax.swing.JTextArea();
        LblCount = new javax.swing.JLabel();
        CBAttendeeType = new javax.swing.JComboBox<>();
        LblCountOccu = new javax.swing.JLabel();
        TFCountOccu = new javax.swing.JTextField();
        BtnGenerateStats = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        cBtnAbsentList = new javax.swing.JCheckBox();
        BtnCopy = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx", "xls");
        //Only accepts excel files
        ExcelFileChooser.setFileFilter(filter);
        ExcelFileChooser.setAcceptAllFileFilterUsed(false);

        BtnPositionG.add(BtnInvisible);
        BtnInvisible.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conference Tracker");

        JAttList.setModel(attModel);
        JAttList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        SPAttList.setViewportView(JAttList);

        BtnSearch.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/magnifying-glass-solid.png")); // NOI18N
        BtnSearch.setText("SEARCH");
        BtnSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnSearchActionPerformed(evt);
            }
        });

        BtnAttDetails.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        BtnAttDetails.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/clipboard-solid.png")); // NOI18N
        BtnAttDetails.setText(" View Attendee Details");
        BtnAttDetails.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnAttDetailsActionPerformed(evt);
            }
        });

        BtnImportEx.setBackground(new java.awt.Color(207, 220, 243));
        BtnImportEx.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        BtnImportEx.setForeground(new java.awt.Color(0, 51, 204));
        BtnImportEx.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/file-import-solid.png")); // NOI18N
        BtnImportEx.setText(" Import Excel");
        BtnImportEx.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnImportExActionPerformed(evt);
            }
        });

        BtnExportEx.setBackground(new java.awt.Color(207, 220, 243));
        BtnExportEx.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        BtnExportEx.setForeground(new java.awt.Color(0, 51, 204));
        BtnExportEx.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/file-export-solid.png")); // NOI18N
        BtnExportEx.setText("Export Excel");
        BtnExportEx.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnExportExActionPerformed(evt);
            }
        });

        BtnDelete.setBackground(new java.awt.Color(248, 217, 211));
        BtnDelete.setForeground(new java.awt.Color(255, 0, 0));
        BtnDelete.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/user-minus-solid.png")); // NOI18N
        BtnDelete.setText(" DELETE ATTENDEE RECORD");
        BtnDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnDeleteActionPerformed(evt);
            }
        });

        TAttDetails.setColumns(20);
        TAttDetails.setRows(5);
        SPDetails.setViewportView(TAttDetails);

        BtnPresent.setText("Present");
        BtnPresent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnPresentActionPerformed(evt);
            }
        });

        BtnAbsent.setText("Absent");
        BtnAbsent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnAbsentActionPerformed(evt);
            }
        });

        LblSetAttendence.setText("Set Attendence to:");

        javax.swing.GroupLayout PnAttListLayout = new javax.swing.GroupLayout(PnAttList);
        PnAttList.setLayout(PnAttListLayout);
        PnAttListLayout.setHorizontalGroup(
            PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAttListLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SPAttList)
                    .addGroup(PnAttListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnImportEx, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnExportEx, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnAttListLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAttListLayout.createSequentialGroup()
                                .addComponent(LblSetAttendence)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnAbsent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAttListLayout.createSequentialGroup()
                                .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(TFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Separator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SPDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Separator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAttListLayout.createSequentialGroup()
                                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))))
                    .addGroup(PnAttListLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(BtnAttDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        PnAttListLayout.setVerticalGroup(
            PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAttListLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnAttListLayout.createSequentialGroup()
                        .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAttDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(SPDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LblSetAttendence, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnAbsent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SPAttList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnAttListLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PnAttListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnExportEx, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnImportEx, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnAttListLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        TabAtt.addTab("View Attendee List", PnAttList);

        LblFName.setText("*First Name:");

        LblLName.setText("*Last Name:");

        TFName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TFNameActionPerformed(evt);
            }
        });

        LblAge.setText("*Age:");

        LblCMail.setText("Contact Email:");

        LblCPhone.setText("Contact Phone:");

        BtnPositionG.add(rBtnMedia);
        rBtnMedia.setText("Is this attendee a media reporter?");
        rBtnMedia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rBtnMediaActionPerformed(evt);
            }
        });

        BtnPositionG.add(rBtnStudent);
        rBtnStudent.setText("Is this attendee a student?");
        rBtnStudent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rBtnStudentActionPerformed(evt);
            }
        });

        LblJob.setText("Job position: ");

        LblOrganization.setText("Organization:");

        LblInterest.setText("Interested Academic Fields: ");

        cBtnTreatment.setText("Clinical Treatment");

        cBtnVaccine.setText("Vaccine Development");

        cBtnPolicies.setText("Prevention Policies");

        BtnAddAtt.setBackground(new java.awt.Color(221, 244, 225));
        BtnAddAtt.setForeground(new java.awt.Color(0, 153, 51));
        BtnAddAtt.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/user-plus-solid.png")); // NOI18N
        BtnAddAtt.setText(" ADD ATTENDEE");
        BtnAddAtt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnAddAttActionPerformed(evt);
            }
        });

        BtnClearAdd.setText("Clear");
        BtnClearAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnClearAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnAddAttLayout = new javax.swing.GroupLayout(PnAddAtt);
        PnAddAtt.setLayout(PnAddAttLayout);
        PnAddAttLayout.setHorizontalGroup(
            PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAddAttLayout.createSequentialGroup()
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnAddAttLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(LblInterest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBtnTreatment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBtnVaccine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBtnPolicies))
                    .addGroup(PnAddAttLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblCMail)
                            .addComponent(LblFName, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PnAddAttLayout.createSequentialGroup()
                                .addComponent(TFName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LblLName)
                                .addGap(18, 18, 18)
                                .addComponent(TFLName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(LblAge)
                                .addGap(18, 18, 18)
                                .addComponent(TFAge))
                            .addGroup(PnAddAttLayout.createSequentialGroup()
                                .addComponent(TFCMail, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LblCPhone)
                                .addGap(18, 18, 18)
                                .addComponent(TFCPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(PnAddAttLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAddAttLayout.createSequentialGroup()
                        .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddSep2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddSep1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAddAttLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAddAttLayout.createSequentialGroup()
                                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAddAttLayout.createSequentialGroup()
                                        .addComponent(LblJob)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TFJob, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAddAttLayout.createSequentialGroup()
                                        .addComponent(rBtnStudent)
                                        .addGap(99, 99, 99)))
                                .addGap(6, 6, 6)
                                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PnAddAttLayout.createSequentialGroup()
                                        .addComponent(LblOrganization)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TFOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(rBtnMedia))
                                .addGap(82, 82, 82))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnAddAttLayout.createSequentialGroup()
                                .addComponent(BtnAddAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnClearAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(236, 236, 236))))))
        );
        PnAddAttLayout.setVerticalGroup(
            PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAddAttLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblFName)
                    .addComponent(LblLName)
                    .addComponent(TFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblAge)
                    .addComponent(TFAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCMail)
                    .addComponent(TFCMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblCPhone)
                    .addComponent(TFCPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(AddSep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtnStudent)
                    .addComponent(rBtnMedia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblJob)
                    .addComponent(TFJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblOrganization)
                    .addComponent(TFOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AddSep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblInterest)
                    .addComponent(cBtnTreatment)
                    .addComponent(cBtnVaccine)
                    .addComponent(cBtnPolicies))
                .addGap(42, 42, 42)
                .addGroup(PnAddAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAddAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnClearAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        TabAtt.addTab("Add Attendee", PnAddAtt);

        JAttListTicket.setModel(attModel);
        SPTicketList.setViewportView(JAttListTicket);

        BtnSearchT.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/magnifying-glass-solid.png")); // NOI18N
        BtnSearchT.setText("SEARCH");
        BtnSearchT.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnSearchTActionPerformed(evt);
            }
        });

        BtnTicketDetails.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        BtnTicketDetails.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/clipboard-solid.png")); // NOI18N
        BtnTicketDetails.setText(" View Attendee Details");
        BtnTicketDetails.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnTicketDetailsActionPerformed(evt);
            }
        });

        BtnGenerateTicket.setBackground(new java.awt.Color(255, 248, 233));
        BtnGenerateTicket.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        BtnGenerateTicket.setForeground(new java.awt.Color(227, 105, 23));
        BtnGenerateTicket.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/ticket-solid.png")); // NOI18N
        BtnGenerateTicket.setText(" GENERATE TICKET");
        BtnGenerateTicket.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnGenerateTicketActionPerformed(evt);
            }
        });

        TATicketDetails.setColumns(20);
        TATicketDetails.setRows(5);
        SPTicketDetails.setViewportView(TATicketDetails);

        BtnTicketFolder.setText("Select Ticket Folder");
        BtnTicketFolder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnTicketFolderActionPerformed(evt);
            }
        });

        LblPath.setText("Current Path: PLEASE SELECT FOLDER PATH");

        BtnGenerateAll.setBackground(new java.awt.Color(255, 248, 233));
        BtnGenerateAll.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        BtnGenerateAll.setForeground(new java.awt.Color(227, 105, 23));
        BtnGenerateAll.setText("GENERATE ALL");
        BtnGenerateAll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnGenerateAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnTicketLayout = new javax.swing.GroupLayout(PnTicket);
        PnTicket.setLayout(PnTicketLayout);
        PnTicketLayout.setHorizontalGroup(
            PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTicketLayout.createSequentialGroup()
                .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnTicketLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblPath)
                            .addComponent(SPTicketList, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnTicketLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(BtnTicketFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnTicketLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SPTicketDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PnTicketLayout.createSequentialGroup()
                                    .addComponent(BtnGenerateTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(BtnGenerateAll, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TSeparator2)
                                .addGroup(PnTicketLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(PnTicketLayout.createSequentialGroup()
                                            .addComponent(BtnSearchT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(TFSearchT, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(TSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(PnTicketLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(BtnTicketDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        PnTicketLayout.setVerticalGroup(
            PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTicketLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnTicketLayout.createSequentialGroup()
                        .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSearchT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFSearchT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnTicketDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SPTicketDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SPTicketList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnTicketLayout.createSequentialGroup()
                        .addComponent(TSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnGenerateTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnGenerateAll, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnTicketLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LblPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnTicketFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        TabAtt.addTab("Generate Ticket", PnTicket);

        TAStats.setColumns(20);
        TAStats.setRows(5);
        jScrollPane1.setViewportView(TAStats);

        LblCount.setText("Generate Count for:");

        CBAttendeeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Total Attendees", "Student Attendees", "Media Attendees" }));

        LblCountOccu.setText("Generate Count for Occupation:");

        BtnGenerateStats.setBackground(new java.awt.Color(226, 226, 251));
        BtnGenerateStats.setForeground(new java.awt.Color(51, 0, 153));
        BtnGenerateStats.setIcon(new javax.swing.ImageIcon("/Users/ming/Desktop/For CS/ConferenceTracker/img/signal-solid.png")); // NOI18N
        BtnGenerateStats.setText(" GENERATE STATS");
        BtnGenerateStats.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnGenerateStatsActionPerformed(evt);
            }
        });

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnClearActionPerformed(evt);
            }
        });

        cBtnAbsentList.setText("Generate List of Absent Attendees");
        cBtnAbsentList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cBtnAbsentListActionPerformed(evt);
            }
        });

        BtnCopy.setText("Copy to Clipboard");
        BtnCopy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnCopyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnStatsLayout = new javax.swing.GroupLayout(PnStats);
        PnStats.setLayout(PnStatsLayout);
        PnStatsLayout.setHorizontalGroup(
            PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnStatsLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnStatsLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(BtnCopy)
                        .addGap(18, 18, 18)
                        .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnStatsLayout.createSequentialGroup()
                        .addGroup(PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnStatsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnStatsLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(LblCount)
                                .addGap(18, 18, 18)
                                .addComponent(CBAttendeeType, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnStatsLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(LblCountOccu)
                                .addGap(18, 18, 18)
                                .addComponent(TFCountOccu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnStatsLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(cBtnAbsentList)))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnStatsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGenerateStats, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );
        PnStatsLayout.setVerticalGroup(
            PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnStatsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCount)
                    .addComponent(CBAttendeeType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFCountOccu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblCountOccu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cBtnAbsentList)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGenerateStats, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnStatsLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TabAtt.addTab("Generate Statistics", PnStats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TabAtt)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExportExActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnExportExActionPerformed
    {//GEN-HEADEREND:event_BtnExportExActionPerformed
        try
        {    
            ExcelFileChooser.showSaveDialog(TabAtt);
            File exportFile = ExcelFileChooser.getSelectedFile();
            if(ExcelFileChooser.getSelectedFile()==null)
            {
                System.out.println("Cancelled");
                //does nothing if no files are chosen
            }
            else
            {               
                attList.exportExcel(exportFile);
                ExcelFileChooser.setSelectedFile(null);
                //resets selected file for next time
                JOptionPane.showMessageDialog(null, "Successfully Exported");
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error when exporting, please make sure your excel file format is valid");
        }
    }//GEN-LAST:event_BtnExportExActionPerformed

    private void BtnImportExActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnImportExActionPerformed
    {//GEN-HEADEREND:event_BtnImportExActionPerformed
         try
        {
            ExcelFileChooser.showOpenDialog(null);
            File selectedFile = ExcelFileChooser.getSelectedFile();
            if(ExcelFileChooser.getSelectedFile()==null)
            {
                System.out.println("Cancelled");
            }
            else
            {
                attList.importExcel(selectedFile);
                //adds imported attendees to the selectable list                
                for (int i=attModelCount;i<attList.totalCount();i++)
                {
                    String attDisplay = (i+1) + " ｜ " + attList.getAtt(i).getFName() +" "+attList.getAtt(i).getLName() + " ｜ " + attList.getAtt(i).getAttendanceText();
                    attModel.add(attModelCount, attDisplay);
                    attModelCount++;
                }
                ExcelFileChooser.setSelectedFile(null);
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error when importing, please make sure your excel file format is valid");
        }
    }//GEN-LAST:event_BtnImportExActionPerformed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnSearchActionPerformed
    {//GEN-HEADEREND:event_BtnSearchActionPerformed
        //Checks if search field is empty before proceeding
        if(TFSearchT.getText()==null)
        {
            JOptionPane.showMessageDialog(null, "Please search a first, last, or full name");
        }
        else
        {
            //shows appropriate message based on returned index value
            int indexPosition = attList.search(TFSearch.getText());
            if(indexPosition==-999)
            {
                JOptionPane.showMessageDialog(null, "Attendee not found"); 
            }
            else
            {
                JAttList.setSelectedIndex(indexPosition);
                JOptionPane.showMessageDialog(null, "Attendee found at position: "+(indexPosition+1));
            }     
        }       
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void TFNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TFNameActionPerformed
    {//GEN-HEADEREND:event_TFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFNameActionPerformed

    private void BtnAddAttActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnAddAttActionPerformed
    {//GEN-HEADEREND:event_BtnAddAttActionPerformed
          //Validation of a numerical, valid age
        if (!TFAge.getText().isEmpty())
        {
            try
            {
                if (Integer.parseInt(TFAge.getText())<0 || Integer.parseInt(TFAge.getText())>150)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid age!");
                    TFAge.setText(null);
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Please enter a numerical age!");
                TFAge.setText(null);
            }         
        }
        //Checks if essential fields are filled
        if (!TFName.getText().isEmpty() && !TFLName.getText().isEmpty() && !TFAge.getText().isEmpty() &&(!TFCMail.getText().isEmpty()||!TFCPhone.getText().isEmpty())) 
        {
            String fName = TFName.getText();
            String lName = TFLName.getText();
            int age = Integer.parseInt(TFAge.getText());                   
        
            //checks for attendee type, then adds appropriate attributes
            if(rBtnStudent.isSelected())
            {
                StudentAttendee att = new StudentAttendee(fName,lName,age);
                attList.addAtt(att);
                setNonEssentials(att);
                addToAttList(fName,lName);
            }
            else if (rBtnMedia.isSelected())
            {
                if(TFOrganization.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter an associated organization!");
                    LblOrganization.setText("*Organization:");
                }
                else
                {
                    String organization = TFOrganization.getText();
                    MediaAttendee att = new MediaAttendee(fName,lName,age,organization);
                    attList.addAtt(att);
                    setNonEssentials(att);
                    addToAttList(fName,lName);
                }
            }
            else
            {
                if(TFJob.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter your current occupation!");
                    LblJob.setText("*Job position:");
                }
                else
                {
                    String occupation = TFJob.getText();
                    OtherAttendee att = new OtherAttendee(fName,lName,age,occupation);
                    attList.addAtt(att);
                    setNonEssentials(att);
                    addToAttList(fName,lName);
                }   
            }
            
        }
        else //makes sure name and age is filled
        {
            JOptionPane.showMessageDialog(null, "Please enter *REQUIRED fields, and make sure one form of contact information is entered!");
        }
        
        
    }//GEN-LAST:event_BtnAddAttActionPerformed

    private void BtnGenerateStatsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnGenerateStatsActionPerformed
    {//GEN-HEADEREND:event_BtnGenerateStatsActionPerformed
        //Checks for selected fields, and generates statistics alltogether
        if(!TFCountOccu.getText().isEmpty())
        {
            TAStats.append("Count for " + TFCountOccu.getText() + " attendees: " );
            TAStats.append(Integer.toString((attList.otherCount(TFCountOccu.getText()))) + "\n");
        }
        if(cBtnAbsentList.isSelected())
        {
            Attendee [] abList=attList.absentList();
            TAStats.append("-\nList of absent attendees: \n");
            for(int i=0;i<abList.length && abList[i]!=null;i++)
            {
                TAStats.append(abList[i].getFName() +" "+ abList[i].getLName()+"\n");
            }
            TAStats.append("-\n");
        }
        if(CBAttendeeType.getSelectedItem().equals("Total Attendees"))
        {
            TAStats.append("Count for total attendees: " );
            TAStats.append(Integer.toString(attList.totalCount())+ "\n");
        }
        else if(CBAttendeeType.getSelectedItem().equals("Student Attendees"))
        {
            TAStats.append("Count for student attendees: " );
            TAStats.append(Integer.toString(attList.studentCount())+ "\n");
        }
        else if(CBAttendeeType.getSelectedItem().equals("Media Attendees"))
        {
            TAStats.append("Count for media attendees: " );
            TAStats.append(Integer.toString(attList.mediaCount())+ "\n");
        }
        
    }//GEN-LAST:event_BtnGenerateStatsActionPerformed

    private void BtnAttDetailsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnAttDetailsActionPerformed
    {//GEN-HEADEREND:event_BtnAttDetailsActionPerformed
        //Checks if an attendee is selected
        if(JAttList.isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please select an attendee");
        }
        else
        //Displays details for the selected attendee
        {
            int indexPosition = JAttList.getSelectedIndex();
            TAttDetails.setText(null);
            TAttDetails.append("NAME: "+attList.getAtt(indexPosition).getFName() + " " +attList.getAtt(indexPosition).getLName() + "\n");
            TAttDetails.append("ATTENDANCE: "+attList.getAtt(indexPosition).getAttendanceText() + "\n");
            TAttDetails.append("Age: "+attList.getAtt(indexPosition).getAge() + "\n");
            TAttDetails.append("Phone: "+attList.getAtt(indexPosition).getContactPhone() +"\n");
            TAttDetails.append("Email: "+attList.getAtt(indexPosition).getContactEmail() +"\n");
            if(attList.getAtt(indexPosition) instanceof StudentAttendee)
            {
                TAttDetails.append("Position: Research Student" +"\n");
            }
            else if(attList.getAtt(indexPosition) instanceof MediaAttendee)
            {
                TAttDetails.append("Position: Media Personnel" +"\n");
                MediaAttendee att= (MediaAttendee)attList.getAtt(indexPosition);
                TAttDetails.append("Organization: "+ att.getOrganization() +"\n");
            }
            else if(attList.getAtt(indexPosition) instanceof OtherAttendee)
            {
                OtherAttendee att= (OtherAttendee)attList.getAtt(indexPosition);
                TAttDetails.append("Position: "+ att.getOccupation() +"\n");
            }
            TAttDetails.append("Interests: "+attList.getAtt(indexPosition).getInterest() +"\n");
        }
        
    }//GEN-LAST:event_BtnAttDetailsActionPerformed

    private void BtnTicketDetailsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnTicketDetailsActionPerformed
    {//GEN-HEADEREND:event_BtnTicketDetailsActionPerformed
        //Same logic with the attendee list tab
        if(JAttListTicket.isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please select an attendee");
        }
        else
        {
            int indexPosition = JAttListTicket.getSelectedIndex();
            TATicketDetails.setText(null);
            TATicketDetails.append("ATTENDANCE: "+attList.getAtt(indexPosition).getAttendanceText() + "\n");
            TATicketDetails.append("Age: "+attList.getAtt(indexPosition).getAge() + "\n");
            TATicketDetails.append("Phone: "+attList.getAtt(indexPosition).getContactPhone() +"\n");
            TATicketDetails.append("Email: "+attList.getAtt(indexPosition).getContactEmail() +"\n");
            if(attList.getAtt(indexPosition) instanceof StudentAttendee)
            {
                TATicketDetails.append("Position: Research Student" +"\n");
            }
            else if(attList.getAtt(indexPosition) instanceof MediaAttendee)
            {
                TATicketDetails.append("Position: Media Personnel" +"\n");
                MediaAttendee att= (MediaAttendee)attList.getAtt(indexPosition);
                TATicketDetails.append("Organization: "+ att.getOrganization() +"\n");
            }
            else if(attList.getAtt(indexPosition) instanceof OtherAttendee)
            {
                OtherAttendee att= (OtherAttendee)attList.getAtt(indexPosition);
                TATicketDetails.append("Position: "+ att.getOccupation() +"\n");
            }
            TATicketDetails.append("Interests: "+attList.getAtt(indexPosition).getInterest() +"\n");
        }
    }//GEN-LAST:event_BtnTicketDetailsActionPerformed

    private void BtnSearchTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnSearchTActionPerformed
    {//GEN-HEADEREND:event_BtnSearchTActionPerformed
        //Same logic with the attendee list tab
        if(TFSearchT.getText()==null)
        {
            JOptionPane.showMessageDialog(null, "Please search a first, last, or full name");
        }
        else
        {
            int indexPosition = attList.search(TFSearchT.getText());
            if(indexPosition==-999)
            {
                JOptionPane.showMessageDialog(null, "Attendee not found"); 
            }
            else
            {
                JAttListTicket.setSelectedIndex(indexPosition);
                JOptionPane.showMessageDialog(null, "Attendee found at position: "+(indexPosition+1));
            }       
        }      
    }//GEN-LAST:event_BtnSearchTActionPerformed

    private void BtnPresentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnPresentActionPerformed
    {//GEN-HEADEREND:event_BtnPresentActionPerformed
        //Sets attendee attendance to present
        if(!JAttList.isSelectionEmpty())
        {
            int attIndex=JAttList.getSelectedIndex();
            attList.getAtt(attIndex).setAttendance(true);
            attModel.setElementAt((attIndex+1) + " ｜ " + attList.getAtt(attIndex).getFName() +" "+attList.getAtt(attIndex).getLName() + " ｜ " + attList.getAtt(attIndex).getAttendanceText(), attIndex);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select an attendee first");
            //checks if an attendee is selected
        }
    }//GEN-LAST:event_BtnPresentActionPerformed

    private void BtnAbsentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnAbsentActionPerformed
    {//GEN-HEADEREND:event_BtnAbsentActionPerformed
        //Sets attendee attendance to absent
        if(!JAttList.isSelectionEmpty())
        {
            int attIndex=JAttList.getSelectedIndex();
            attList.getAtt(attIndex).setAttendance(false);
            attModel.setElementAt((attIndex+1) + " ｜ " + attList.getAtt(attIndex).getFName() +" "+attList.getAtt(attIndex).getLName() + " ｜ " + attList.getAtt(attIndex).getAttendanceText(), attIndex);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select an attendee first");
        }
    }//GEN-LAST:event_BtnAbsentActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnDeleteActionPerformed
    {//GEN-HEADEREND:event_BtnDeleteActionPerformed
        if(JAttList.isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please select an attendee");
        }
        else
        {
            int attIndex=JAttList.getSelectedIndex();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            //Shows confirmation before deletion
            int dialogResult = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + attList.getAtt(attIndex).getFName() + " " +attList.getAtt(attIndex).getLName() + "?", "Warning", dialogButton);
        
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                attList.deleteAtt(attIndex);
                attModel.removeElementAt(attIndex);
                attModelCount--;
                //Reshuffles attendee numbers of the Jlist
                for(int i=attIndex;i<attModelCount;i++)
                {
                    String currText=(String) attModel.getElementAt(i);
                    int space = 0;
                    for(int j=0;j<currText.length();j++)
                    {
                        if(currText.substring(j,j+1).equals(" "))
                        {
                            space=j;
                            j=currText.length();
                        }
                    }
                    currText= (i+1) +currText.substring(space,currText.length());
                    attModel.setElementAt(currText, i);
                }
            }
        }
   
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnGenerateTicketActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnGenerateTicketActionPerformed
    {//GEN-HEADEREND:event_BtnGenerateTicketActionPerformed
        if(JAttListTicket.isSelectionEmpty())
        {
            //checks if an attendee is selected
            JOptionPane.showMessageDialog(null, "Please select an attendee");
        }
        else
        {
            try
            {  
                int attIndex=JAttListTicket.getSelectedIndex();
                AttendeeTicket ticket = new AttendeeTicket (attList.getAtt(attIndex));
                String attName = attList.getAtt(attIndex).getFName()+ " " + attList.getAtt(attIndex).getLName();
                if(selectedTicketFolder==null)//checks if folder path is selected, if not, prompts the user to choose a folder
                {
                    BtnTicketFolder.doClick();
                    ticket.generate(attName, selectedTicketFolder);
                    JOptionPane.showMessageDialog(null, "PDF Ticket Successfully Generated");
                }
                else
                {
                    ticket.generate(attName, selectedTicketFolder); //auto generates from folder path
                    JOptionPane.showMessageDialog(null, "PDF Ticket Successfully Generated");
                }    
            } 
            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(null,"Error when generating ticket");
            }
        }
    }//GEN-LAST:event_BtnGenerateTicketActionPerformed

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnClearActionPerformed
    {//GEN-HEADEREND:event_BtnClearActionPerformed
        TAStats.setText(null);
    }//GEN-LAST:event_BtnClearActionPerformed

    private void BtnClearAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnClearAddActionPerformed
    {//GEN-HEADEREND:event_BtnClearAddActionPerformed
        clearAdd();
    }//GEN-LAST:event_BtnClearAddActionPerformed

    private void rBtnStudentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rBtnStudentActionPerformed
    {//GEN-HEADEREND:event_rBtnStudentActionPerformed
        //disables occupation, organization, and certain academic fields
        cBtnVaccine.setEnabled(false);
        cBtnTreatment.setEnabled(false);
        LblJob.setEnabled(false);
        TFJob.setEnabled(false);
        LblOrganization.setEnabled(false);
        TFOrganization.setEnabled(false);
    }//GEN-LAST:event_rBtnStudentActionPerformed

    private void rBtnMediaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rBtnMediaActionPerformed
    {//GEN-HEADEREND:event_rBtnMediaActionPerformed
        //disables occupation only
        LblJob.setEnabled(false);
        TFJob.setEnabled(false);
        LblOrganization.setEnabled(true);
        TFOrganization.setEnabled(true);
    }//GEN-LAST:event_rBtnMediaActionPerformed

    private void cBtnAbsentListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cBtnAbsentListActionPerformed
    {//GEN-HEADEREND:event_cBtnAbsentListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBtnAbsentListActionPerformed

    private void BtnTicketFolderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnTicketFolderActionPerformed
    {//GEN-HEADEREND:event_BtnTicketFolderActionPerformed
        try
        {
            //gets directory from selected folder
            TicketFolderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
            TicketFolderChooser.showOpenDialog(null);
            File selectedFolder = TicketFolderChooser.getSelectedFile();
            
            if(TicketFolderChooser.getCurrentDirectory()==null)
            {
                System.out.println("Cancelled");
            }
            else
            {
                selectedTicketFolder=selectedFolder.getAbsolutePath() + "/";
                //Displays folder path for user
                if(selectedTicketFolder.length()>32)
                //Makes sure the text does not mess up scale
                {
                    LblPath.setText("Current Path: ..."+selectedTicketFolder.substring(selectedTicketFolder.length()-32,selectedTicketFolder.length()));
                }
                else
                {
                    LblPath.setText("Current Path: "+selectedTicketFolder);
                }      
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error when selecting ticket folder");
        }
    }//GEN-LAST:event_BtnTicketFolderActionPerformed

    private void BtnCopyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnCopyActionPerformed
    {//GEN-HEADEREND:event_BtnCopyActionPerformed
        String str = TAStats.getText();

	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Clipboard clipboard = toolkit.getSystemClipboard();
	StringSelection strSelection = new StringSelection(str);
	clipboard.setContents(strSelection, null);
        //referenced from: https://stackoverflow.com/questions/6710350/copying-text-to-the-clipboard-using-java
    }//GEN-LAST:event_BtnCopyActionPerformed

    private void BtnGenerateAllActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnGenerateAllActionPerformed
    {//GEN-HEADEREND:event_BtnGenerateAllActionPerformed
        //Prompts user for confirmation
        int dialogResult=JOptionPane.showConfirmDialog(rootPane, "Generate tickets for all attendees?");
        
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            if(selectedTicketFolder==null)
            {
                BtnTicketFolder.doClick();
            }
            for(int i=0;i<attModelCount;i++)//iterates through every attendee
            {
                try
                {  
                    AttendeeTicket ticket = new AttendeeTicket (attList.getAtt(i));
                    String attName = attList.getAtt(i).getFName()+ " " + attList.getAtt(i).getLName();
                    
                    ticket.generate(attName, selectedTicketFolder);
                } 
                catch (IOException ex)
                {
                    System.out.println("Error when generating tickets");
                }
            }
            JOptionPane.showMessageDialog(null, "PDF Tickets Successfully Generated");
        }
    }//GEN-LAST:event_BtnGenerateAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ConferenceTrackerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConferenceTrackerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConferenceTrackerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConferenceTrackerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConferenceTrackerApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator AddSep1;
    private javax.swing.JSeparator AddSep2;
    private javax.swing.JButton BtnAbsent;
    private javax.swing.JButton BtnAddAtt;
    private javax.swing.JButton BtnAttDetails;
    private javax.swing.ButtonGroup BtnAttendenceG;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnClearAdd;
    private javax.swing.JButton BtnCopy;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnExportEx;
    private javax.swing.JButton BtnGenerateAll;
    private javax.swing.JButton BtnGenerateStats;
    private javax.swing.JButton BtnGenerateTicket;
    private javax.swing.JButton BtnImportEx;
    private javax.swing.JRadioButton BtnInvisible;
    private javax.swing.ButtonGroup BtnPositionG;
    private javax.swing.JButton BtnPresent;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton BtnSearchT;
    private javax.swing.JButton BtnTicketDetails;
    private javax.swing.JButton BtnTicketFolder;
    private javax.swing.JComboBox<String> CBAttendeeType;
    private javax.swing.JFileChooser ExcelFileChooser;
    private javax.swing.JList<String> JAttList;
    private javax.swing.JList<String> JAttListTicket;
    private javax.swing.JLabel LblAge;
    private javax.swing.JLabel LblCMail;
    private javax.swing.JLabel LblCPhone;
    private javax.swing.JLabel LblCount;
    private javax.swing.JLabel LblCountOccu;
    private javax.swing.JLabel LblFName;
    private javax.swing.JLabel LblInterest;
    private javax.swing.JLabel LblJob;
    private javax.swing.JLabel LblLName;
    private javax.swing.JLabel LblOrganization;
    private javax.swing.JLabel LblPath;
    private javax.swing.JLabel LblSetAttendence;
    private javax.swing.JPanel PnAddAtt;
    private javax.swing.JPanel PnAttList;
    private javax.swing.JPanel PnStats;
    private javax.swing.JPanel PnTicket;
    private javax.swing.JScrollPane SPAttList;
    private javax.swing.JScrollPane SPDetails;
    private javax.swing.JScrollPane SPTicketDetails;
    private javax.swing.JScrollPane SPTicketList;
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JTextArea TAStats;
    private javax.swing.JTextArea TATicketDetails;
    private javax.swing.JTextArea TAttDetails;
    private javax.swing.JTextField TFAge;
    private javax.swing.JTextField TFCMail;
    private javax.swing.JTextField TFCPhone;
    private javax.swing.JTextField TFCountOccu;
    private javax.swing.JTextField TFJob;
    private javax.swing.JTextField TFLName;
    private javax.swing.JTextField TFName;
    private javax.swing.JTextField TFOrganization;
    private javax.swing.JTextField TFSearch;
    private javax.swing.JTextField TFSearchT;
    private javax.swing.JSeparator TSeparator1;
    private javax.swing.JSeparator TSeparator2;
    private javax.swing.JTabbedPane TabAtt;
    private javax.swing.JFileChooser TicketFolderChooser;
    private javax.swing.JCheckBox cBtnAbsentList;
    private javax.swing.JCheckBox cBtnPolicies;
    private javax.swing.JCheckBox cBtnTreatment;
    private javax.swing.JCheckBox cBtnVaccine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rBtnMedia;
    private javax.swing.JRadioButton rBtnStudent;
    // End of variables declaration//GEN-END:variables
}

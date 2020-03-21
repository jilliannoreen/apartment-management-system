/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdashboard;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.SwingConstants;
import loginregister.LoginRegister;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Noli
 */
public class UserDashboard extends javax.swing.JFrame {

    /**
     * Creates new form UserDashboard
     */
    //GridBagLayout layout = new GridBagLayout();
    //ApartPanel apartpanel;
    //LogoPanel logopanel;
    //UnitPanel unitpanel;
    //ViewPanel viewpanel;
    private static int user_id, apartmentID, i, unitID;
    private Connection conn = null;   
    public static int TF = 0;
    
    public UserDashboard(int id) {
        initComponents();
        user_id = id;
        setLocationRelativeTo(null);
        try{
            String sql = "jdbc:mysql://localhost/apartment_db";
            conn = DriverManager.getConnection(sql, "root", "");
        }
        catch(SQLException ev)
        {
            System.err.println("Got an exception! ");
            System.err.println(ev.getMessage());
        } 
        //apartpanel = new ApartPanel();
        //logopanel = new LogoPanel();
        //unitpanel = new UnitPanel();
        //viewpanel = new ViewPanel();
        //dashboardpanels.setLayout(layout);
        //GridBagConstraints c = new GridBagConstraints();
        //c.gridx=0;
        //c.gridy=0;
        //dashboardpanels.add(logopanel);
        //dashboardpanels.add(apartpanel);
        //dashboardpanels.add(unitpanel);
        //dashboardpanels.add(viewpanel);
        addUnitPanel.setVisible(false);
        apartpanel.setVisible(false); 
        viewpanel.setVisible(false); 
        unitpanel.setVisible(false);
        editApartmentP.setVisible(false);
        addClearTenantP.setVisible(false);
        billingpanel.setVisible(false);
        paymentPanel.setVisible(false);
        logopanel.setVisible(true);
        paymentTA.setEditable(false);
        xxx.setVisible(false);
        //BillTA.setEditable(false);
        i=0;
        numofunitsLO.setText(String.format("%d",i)); //reset No of units counter
        numofunitsLO1.setText(String.format("%d",i));
        
        String query2 = "SELECT first_name FROM users WHERE id = ?";
        try
        {
            PreparedStatement preparedStmt = conn.prepareStatement(query2);
            preparedStmt.setInt (1, user_id);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next())
            {
                jLabel19.setText("Welcome, " + rs.getString("first_name"));
                jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel19.setVerticalAlignment(SwingConstants.CENTER);
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        
        
        
        
        
        
        String query = "SELECT *,CONCAT(users.first_name,' ', users.last_name)AS 'owner', apartment.id AS 'aID' FROM apartment INNER JOIN users ON users.id = apartment.user_id WHERE users.id = ?";
        String apartmentName, address, owner;
        int noOfUnits;
        try
        {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, user_id);

            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next())
            {
                apartmentName = rs.getString("name");
                address = rs.getString("address");
                owner = rs.getString("owner");
                apartmentID = rs.getInt("aID");
                
                nameApartLO.setText(apartmentName);
                addressLO.setText(address);
                ownerLO.setText(owner);
                ownerLO1.setText(owner);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        //---------------------------------- get units
        query = "SELECT * FROM units WHERE apartment_id = ? ORDER BY unit_name";
        try
        {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, apartmentID);
            DefaultListModel list = new DefaultListModel();
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next())
            {
                list.addElement(rs.getString("unit_name"));
                i++;
            }
            jList1.setModel(list);
            DefaultListCellRenderer renderer =  (DefaultListCellRenderer)jList1.getCellRenderer();  
            renderer.setHorizontalAlignment(JLabel.CENTER);  
            numofunitsLO.setText(String.format("%d",i));
            numofunitsLO1.setText(String.format("%d",i));
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        toppanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        sidebarpanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dashboardpanels = new javax.swing.JPanel();
        addClearTenantP = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        addTFNameTF = new javax.swing.JTextField();
        addTNumTF = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        addTLNameTF = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        addTenantError = new javax.swing.JLabel();
        viewpanel = new javax.swing.JPanel();
        unitNameLO = new javax.swing.JLabel();
        tenantNameL = new javax.swing.JLabel();
        tenantNameLO = new javax.swing.JLabel();
        unitpriceL = new javax.swing.JLabel();
        unitpriceLO = new javax.swing.JLabel();
        unittypeL = new javax.swing.JLabel();
        unittypeLO = new javax.swing.JLabel();
        balanceL = new javax.swing.JLabel();
        balanceLO = new javax.swing.JLabel();
        lastPaymentL = new javax.swing.JLabel();
        lastPaymentLO = new javax.swing.JLabel();
        contactL = new javax.swing.JLabel();
        contactLO = new javax.swing.JLabel();
        depositL = new javax.swing.JLabel();
        depositLO = new javax.swing.JLabel();
        BillingB = new javax.swing.JButton();
        PaymentB = new javax.swing.JButton();
        AddClearB = new javax.swing.JButton();
        back2 = new javax.swing.JButton();
        ClearError = new javax.swing.JLabel();
        unitpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        unitPriceLO = new javax.swing.JLabel();
        statusLO = new javax.swing.JLabel();
        tenantLO = new javax.swing.JLabel();
        addB = new javax.swing.JButton();
        viewB = new javax.swing.JButton();
        deleteB = new javax.swing.JButton();
        billingpanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        waterTF = new javax.swing.JTextField();
        electricTF = new javax.swing.JTextField();
        genBillB = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTA = new javax.swing.JTextArea();
        printBillB = new javax.swing.JButton();
        back4 = new javax.swing.JButton();
        BillingError = new javax.swing.JLabel();
        paymentPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        rentPayL = new javax.swing.JLabel();
        rentPayL1 = new javax.swing.JLabel();
        rentPayL2 = new javax.swing.JLabel();
        rentPTF = new javax.swing.JTextField();
        waterPTF = new javax.swing.JTextField();
        elecPTF = new javax.swing.JTextField();
        useAdvanceB = new javax.swing.JRadioButton();
        genReceiptB = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        paymentTA = new javax.swing.JTextArea();
        printPB = new javax.swing.JButton();
        addToAdvance = new javax.swing.JRadioButton();
        back5 = new javax.swing.JButton();
        PaymentError = new javax.swing.JLabel();
        addUnitPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addUnitName = new javax.swing.JTextField();
        addUnitPrice = new javax.swing.JTextField();
        addUnitType = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        back3 = new javax.swing.JButton();
        xxx = new javax.swing.JLabel();
        editApartmentP = new javax.swing.JPanel();
        nameApartL1 = new javax.swing.JLabel();
        addressL1 = new javax.swing.JLabel();
        numofunitsL1 = new javax.swing.JLabel();
        ownerL1 = new javax.swing.JLabel();
        editANameTF = new javax.swing.JTextField();
        editAAddTF = new javax.swing.JTextField();
        numofunitsLO1 = new javax.swing.JLabel();
        ownerLO1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        back1 = new javax.swing.JButton();
        apartpanel = new javax.swing.JPanel();
        nameApartL = new javax.swing.JLabel();
        addressL = new javax.swing.JLabel();
        numofunitsL = new javax.swing.JLabel();
        nameApartLO = new javax.swing.JLabel();
        addressLO = new javax.swing.JLabel();
        numofunitsLO = new javax.swing.JLabel();
        ownerL = new javax.swing.JLabel();
        ownerLO = new javax.swing.JLabel();
        editApartmentB = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        logopanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(19, 34, 53));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toppanel.setBackground(new java.awt.Color(19, 255, 230));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-menu-squared-30.png"))); // NOI18N
        jLabel1.setText("Dashboard");
        toppanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8ss-minimize-window-35.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setRequestFocusEnabled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-minimize-windows-35.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toppanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 50));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8s-close-window-35.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setRequestFocusEnabled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-window-35 (1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        toppanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 50));

        jPanel1.add(toppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 50));

        sidebarpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(19, 255, 230));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-exit-30.png"))); // NOI18N
        jButton2.setText("Log out    ");
        jButton2.setFocusable(false);
        jButton2.setIconTextGap(10);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        sidebarpanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 240, 50));

        jButton7.setBackground(new java.awt.Color(19, 255, 230));
        jButton7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-city-32.png"))); // NOI18N
        jButton7.setText("Apartment");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setFocusable(false);
        jButton7.setIconTextGap(10);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        sidebarpanel.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 240, 50));

        jButton4.setBackground(new java.awt.Color(19, 255, 230));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-rent-30.png"))); // NOI18N
        jButton4.setText("Units         ");
        jButton4.setFocusable(false);
        jButton4.setIconTextGap(10);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        sidebarpanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 240, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-person-60.png"))); // NOI18N
        sidebarpanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel19.setMaximumSize(new java.awt.Dimension(240, 30));
        sidebarpanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 30));

        jPanel1.add(sidebarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 240, 460));

        dashboardpanels.setBackground(new java.awt.Color(19, 35, 53));
        dashboardpanels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addClearTenantP.setBackground(new java.awt.Color(19, 35, 53));
        addClearTenantP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Add Tenant");
        addClearTenantP.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 110, 27));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tenant First Name ");
        addClearTenantP.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact Number");
        addClearTenantP.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        addTFNameTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        addClearTenantP.add(addTFNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 192, -1));

        addTNumTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        addClearTenantP.add(addTNumTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 192, -1));

        jButton8.setBackground(new java.awt.Color(19, 255, 230));
        jButton8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton8.setText("Add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        addClearTenantP.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 110, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tenant Last Name ");
        addClearTenantP.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        addTLNameTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        addClearTenantP.add(addTLNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 192, -1));

        back.setBackground(new java.awt.Color(19, 255, 230));
        back.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        back.setForeground(new java.awt.Color(19, 35, 53));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        addClearTenantP.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));

        addTenantError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        addTenantError.setForeground(new java.awt.Color(255, 0, 0));
        addClearTenantP.add(addTenantError, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 190, 20));

        dashboardpanels.add(addClearTenantP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        viewpanel.setBackground(new java.awt.Color(19, 35, 53));
        viewpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unitNameLO.setBackground(new java.awt.Color(19, 35, 53));
        unitNameLO.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        unitNameLO.setForeground(new java.awt.Color(255, 255, 255));
        unitNameLO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        unitNameLO.setOpaque(true);
        viewpanel.add(unitNameLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 570, 30));

        tenantNameL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tenantNameL.setForeground(new java.awt.Color(255, 255, 255));
        tenantNameL.setText("Tenant Name");
        viewpanel.add(tenantNameL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        tenantNameLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tenantNameLO.setForeground(new java.awt.Color(255, 255, 255));
        tenantNameLO.setText("jLabel12");
        viewpanel.add(tenantNameLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        unitpriceL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        unitpriceL.setForeground(new java.awt.Color(255, 255, 255));
        unitpriceL.setText("Unit Price");
        viewpanel.add(unitpriceL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        unitpriceLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        unitpriceLO.setForeground(new java.awt.Color(255, 255, 255));
        unitpriceLO.setText("jLabel12");
        viewpanel.add(unitpriceLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        unittypeL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        unittypeL.setForeground(new java.awt.Color(255, 255, 255));
        unittypeL.setText("Unit type");
        viewpanel.add(unittypeL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        unittypeLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        unittypeLO.setForeground(new java.awt.Color(255, 255, 255));
        unittypeLO.setText("jLabel12");
        viewpanel.add(unittypeLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        balanceL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        balanceL.setForeground(new java.awt.Color(255, 255, 255));
        balanceL.setText("Balance");
        viewpanel.add(balanceL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        balanceLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        balanceLO.setForeground(new java.awt.Color(255, 255, 255));
        balanceLO.setText("jLabel12");
        viewpanel.add(balanceLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        lastPaymentL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lastPaymentL.setForeground(new java.awt.Color(255, 255, 255));
        lastPaymentL.setText("Last Payment");
        viewpanel.add(lastPaymentL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        lastPaymentLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lastPaymentLO.setForeground(new java.awt.Color(255, 255, 255));
        lastPaymentLO.setText("jLabel12");
        viewpanel.add(lastPaymentLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        contactL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        contactL.setForeground(new java.awt.Color(255, 255, 255));
        contactL.setText("Contact No.");
        viewpanel.add(contactL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        contactLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        contactLO.setForeground(new java.awt.Color(255, 255, 255));
        contactLO.setText("jLabel12");
        viewpanel.add(contactLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        depositL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        depositL.setForeground(new java.awt.Color(255, 255, 255));
        depositL.setText("Deposit / Advance");
        viewpanel.add(depositL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        depositLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        depositLO.setForeground(new java.awt.Color(255, 255, 255));
        depositLO.setText("jLabel12");
        viewpanel.add(depositLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        BillingB.setBackground(new java.awt.Color(19, 255, 230));
        BillingB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        BillingB.setText("Billing");
        BillingB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillingBActionPerformed(evt);
            }
        });
        viewpanel.add(BillingB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 100, 30));

        PaymentB.setBackground(new java.awt.Color(19, 255, 230));
        PaymentB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        PaymentB.setText("Payment");
        PaymentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentBActionPerformed(evt);
            }
        });
        viewpanel.add(PaymentB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 100, 30));

        AddClearB.setBackground(new java.awt.Color(19, 255, 230));
        AddClearB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        AddClearB.setText("AddClearB");
        AddClearB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClearBActionPerformed(evt);
            }
        });
        viewpanel.add(AddClearB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 120, 30));

        back2.setBackground(new java.awt.Color(19, 255, 230));
        back2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        back2.setForeground(new java.awt.Color(19, 35, 53));
        back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back2.setText("Back");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });
        viewpanel.add(back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));

        ClearError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ClearError.setForeground(new java.awt.Color(255, 0, 0));
        viewpanel.add(ClearError, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 360, 30));

        dashboardpanels.add(viewpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        unitpanel.setBackground(new java.awt.Color(19, 35, 53));
        unitpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setToolTipText("");
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jScrollPane1.setName(""); // NOI18N
        jScrollPane1.setPreferredSize(null);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        jList1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.setFocusCycleRoot(true);
        jList1.setFocusTraversalPolicyProvider(true);
        jList1.setMaximumSize(new java.awt.Dimension(1, 1));
        jList1.setPreferredSize(null);
        jList1.setSelectionBackground(new java.awt.Color(19, 255, 230));
        jList1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        unitpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 430, 200));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apartment Units");
        unitpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        unitpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        unitPriceLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        unitPriceLO.setForeground(new java.awt.Color(255, 255, 255));
        unitpanel.add(unitPriceLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 130, 20));

        statusLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        statusLO.setForeground(new java.awt.Color(255, 255, 255));
        unitpanel.add(statusLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 130, 20));

        tenantLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        tenantLO.setForeground(new java.awt.Color(255, 255, 255));
        unitpanel.add(tenantLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 130, 20));

        addB.setBackground(new java.awt.Color(19, 255, 230));
        addB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        addB.setText("Add Unit");
        addB.setToolTipText("");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });
        unitpanel.add(addB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        viewB.setBackground(new java.awt.Color(19, 255, 230));
        viewB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        viewB.setText("View");
        viewB.setToolTipText("");
        viewB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBActionPerformed(evt);
            }
        });
        unitpanel.add(viewB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 90, -1));

        deleteB.setBackground(new java.awt.Color(19, 255, 230));
        deleteB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        deleteB.setText("Delete");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });
        unitpanel.add(deleteB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 90, -1));

        dashboardpanels.add(unitpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        billingpanel.setBackground(new java.awt.Color(19, 35, 53));
        billingpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Billing");
        billingpanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Enter Water Bill");
        billingpanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter Electric Bill");
        billingpanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        waterTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        billingpanel.add(waterTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, 20));

        electricTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        billingpanel.add(electricTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 160, 20));

        genBillB.setBackground(new java.awt.Color(19, 255, 230));
        genBillB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        genBillB.setText("Generate Bill");
        genBillB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genBillBActionPerformed(evt);
            }
        });
        billingpanel.add(genBillB, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        BillTA.setColumns(20);
        BillTA.setRows(5);
        jScrollPane2.setViewportView(BillTA);

        billingpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 142, 524, 200));

        printBillB.setBackground(new java.awt.Color(19, 255, 230));
        printBillB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        printBillB.setText("Print Bill");
        printBillB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBillBActionPerformed(evt);
            }
        });
        billingpanel.add(printBillB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        back4.setBackground(new java.awt.Color(19, 255, 230));
        back4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        back4.setForeground(new java.awt.Color(19, 35, 53));
        back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back4.setText("Back");
        back4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back4ActionPerformed(evt);
            }
        });
        billingpanel.add(back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));

        BillingError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        BillingError.setForeground(new java.awt.Color(255, 0, 0));
        billingpanel.add(BillingError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, 20));

        dashboardpanels.add(billingpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        paymentPanel.setBackground(new java.awt.Color(19, 35, 53));
        paymentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Payment");
        paymentPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        rentPayL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        rentPayL.setForeground(new java.awt.Color(255, 255, 255));
        rentPayL.setText("Rent ");
        paymentPanel.add(rentPayL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        rentPayL1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        rentPayL1.setForeground(new java.awt.Color(255, 255, 255));
        rentPayL1.setText("Water");
        paymentPanel.add(rentPayL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        rentPayL2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        rentPayL2.setForeground(new java.awt.Color(255, 255, 255));
        rentPayL2.setText("Electicity");
        paymentPanel.add(rentPayL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        rentPTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        paymentPanel.add(rentPTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 148, 20));

        waterPTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        waterPTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterPTFActionPerformed(evt);
            }
        });
        paymentPanel.add(waterPTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 148, 20));

        elecPTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        paymentPanel.add(elecPTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 148, 20));

        useAdvanceB.setBackground(new java.awt.Color(19, 255, 230));
        useAdvanceB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        useAdvanceB.setText("Use Advance");
        paymentPanel.add(useAdvanceB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        genReceiptB.setBackground(new java.awt.Color(19, 255, 230));
        genReceiptB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        genReceiptB.setText("Generate Receipt");
        genReceiptB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReceiptBActionPerformed(evt);
            }
        });
        paymentPanel.add(genReceiptB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        paymentTA.setColumns(20);
        paymentTA.setRows(5);
        jScrollPane3.setViewportView(paymentTA);

        paymentPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 162, 520, 190));

        printPB.setBackground(new java.awt.Color(19, 255, 230));
        printPB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        printPB.setText("Print");
        printPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPBActionPerformed(evt);
            }
        });
        paymentPanel.add(printPB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 90, -1));

        addToAdvance.setBackground(new java.awt.Color(19, 255, 230));
        addToAdvance.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        addToAdvance.setText("Add Advance");
        paymentPanel.add(addToAdvance, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        back5.setBackground(new java.awt.Color(19, 255, 230));
        back5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        back5.setForeground(new java.awt.Color(19, 35, 53));
        back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back5.setText("Back");
        back5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back5ActionPerformed(evt);
            }
        });
        paymentPanel.add(back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));

        PaymentError.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        PaymentError.setForeground(new java.awt.Color(255, 0, 0));
        paymentPanel.add(PaymentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 20));

        dashboardpanels.add(paymentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        addUnitPanel.setBackground(new java.awt.Color(19, 35, 53));
        addUnitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add Unit");
        addUnitPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 80, 35));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Unit Name");
        addUnitPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Unit Price");
        addUnitPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 20));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Unit Type");
        addUnitPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 20));

        addUnitName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUnitNameActionPerformed(evt);
            }
        });
        addUnitPanel.add(addUnitName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 160, 20));
        addUnitPanel.add(addUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 160, 20));
        addUnitPanel.add(addUnitType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 160, 20));

        jButton5.setBackground(new java.awt.Color(19, 255, 230));
        jButton5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton5.setText("Submit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        addUnitPanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 110, 30));

        back3.setBackground(new java.awt.Color(19, 255, 230));
        back3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        back3.setForeground(new java.awt.Color(19, 35, 53));
        back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back3.setText("Back");
        back3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back3ActionPerformed(evt);
            }
        });
        addUnitPanel.add(back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));

        xxx.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        xxx.setForeground(new java.awt.Color(255, 0, 0));
        addUnitPanel.add(xxx, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 190, 20));

        dashboardpanels.add(addUnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        editApartmentP.setBackground(new java.awt.Color(19, 35, 53));
        editApartmentP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameApartL1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        nameApartL1.setForeground(new java.awt.Color(255, 255, 255));
        nameApartL1.setText("Name of Apartment");
        editApartmentP.add(nameApartL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        addressL1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        addressL1.setForeground(new java.awt.Color(255, 255, 255));
        addressL1.setText("Address");
        editApartmentP.add(addressL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        numofunitsL1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        numofunitsL1.setForeground(new java.awt.Color(255, 255, 255));
        numofunitsL1.setText("No. of Units");
        editApartmentP.add(numofunitsL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        ownerL1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        ownerL1.setForeground(new java.awt.Color(255, 255, 255));
        ownerL1.setText("Owner");
        editApartmentP.add(ownerL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        editANameTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        editApartmentP.add(editANameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 194, -1));

        editAAddTF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        editApartmentP.add(editAAddTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 194, -1));

        numofunitsLO1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        numofunitsLO1.setForeground(new java.awt.Color(255, 255, 255));
        numofunitsLO1.setText("jLabel31");
        editApartmentP.add(numofunitsLO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        ownerLO1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        ownerLO1.setForeground(new java.awt.Color(255, 255, 255));
        ownerLO1.setText("jLabel33");
        editApartmentP.add(ownerLO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        jButton6.setBackground(new java.awt.Color(19, 255, 250));
        jButton6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        editApartmentP.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 90, 30));

        jLabel20.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Edit Apartment Details");
        editApartmentP.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        back1.setBackground(new java.awt.Color(19, 255, 230));
        back1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        back1.setForeground(new java.awt.Color(19, 35, 53));
        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back1.setText("Back");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });
        editApartmentP.add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));

        dashboardpanels.add(editApartmentP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        apartpanel.setBackground(new java.awt.Color(19, 35, 53));
        apartpanel.setForeground(new java.awt.Color(255, 255, 255));
        apartpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameApartL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        nameApartL.setForeground(new java.awt.Color(255, 255, 255));
        nameApartL.setText("Name of Apartment");
        apartpanel.add(nameApartL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        addressL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        addressL.setForeground(new java.awt.Color(255, 255, 255));
        addressL.setText("Address");
        apartpanel.add(addressL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        numofunitsL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        numofunitsL.setForeground(new java.awt.Color(255, 255, 255));
        numofunitsL.setText("No. of Units");
        apartpanel.add(numofunitsL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        nameApartLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        nameApartLO.setForeground(new java.awt.Color(255, 255, 255));
        nameApartLO.setText("jLabel29");
        apartpanel.add(nameApartLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        addressLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        addressLO.setForeground(new java.awt.Color(255, 255, 255));
        addressLO.setText("jLabel30");
        apartpanel.add(addressLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        numofunitsLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        numofunitsLO.setForeground(new java.awt.Color(255, 255, 255));
        numofunitsLO.setText("jLabel31");
        apartpanel.add(numofunitsLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        ownerL.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        ownerL.setForeground(new java.awt.Color(255, 255, 255));
        ownerL.setText("Owner");
        apartpanel.add(ownerL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        ownerLO.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        ownerLO.setForeground(new java.awt.Color(255, 255, 255));
        ownerLO.setText("jLabel33");
        apartpanel.add(ownerLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        editApartmentB.setBackground(new java.awt.Color(19, 255, 230));
        editApartmentB.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        editApartmentB.setText("Edit");
        editApartmentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editApartmentBActionPerformed(evt);
            }
        });
        apartpanel.add(editApartmentB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 110, 30));

        jLabel21.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Apartment Details");
        apartpanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        dashboardpanels.add(apartpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        logopanel.setBackground(new java.awt.Color(19, 35, 53));
        logopanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue Icon Construction Logo.png"))); // NOI18N
        logopanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        dashboardpanels.add(logopanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        jPanel1.add(dashboardpanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 570, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        addUnitPanel.setVisible(false);
        editApartmentP.setVisible(false);
        apartpanel.setVisible(false); 
        logopanel.setVisible(false);
        viewpanel.setVisible(false); 
        billingpanel.setVisible(false);
        paymentPanel.setVisible(false);
        useAdvanceB.setSelected(false);
        addClearTenantP.setVisible(false);
        unitpanel.setVisible(true);
        jList1.clearSelection();
        
        addUnitName.setText("");
        addUnitPrice.setText("");
        addUnitType.setText("");
        
        addTLNameTF.setText("");
        addTFNameTF.setText("");
        addTNumTF.setText("");
        
        waterTF.setText("");
        electricTF.setText("");
        
        rentPTF.setText("");
        waterPTF.setText("");
        elecPTF.setText("");
        
        unitPriceLO.setText("");
        tenantLO.setText("");
        statusLO.setText("");
        
        editANameTF.setText("");
        editAAddTF.setText("");
        
        addTenantError.setText("");
        BillingError.setText("");
        PaymentError.setText("");
        ClearError.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        addUnitPanel.setVisible(false);
        editApartmentP.setVisible(false);
        logopanel.setVisible(false);
        viewpanel.setVisible(false); 
        unitpanel.setVisible(false); 
        billingpanel.setVisible(false);
        paymentPanel.setVisible(false);
        addClearTenantP.setVisible(false);
        useAdvanceB.setSelected(false);
        apartpanel.setVisible(true); 
        
        editANameTF.setText("");
        editAAddTF.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BillingBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillingBActionPerformed
        ClearError.setText("");
        waterTF.setText("");
        electricTF.setText("");
        if(TF == 0)
        {
            viewpanel.setVisible(false);
            billingpanel.setVisible(true);
            printBillB.setVisible(false);
            
            BillTA.setText("****************************************************************************************************\n");
            String query = "SELECT * FROM apartment where id = ?";
            try
            {
                String address="", apartment="";
                PreparedStatement prep = conn.prepareStatement(query);
                prep.setInt(1,apartmentID);
                ResultSet rs = prep.executeQuery();
                while(rs.next())
                {
                    apartment = rs.getString("name");
                    address = rs.getString("address");
                }
                BillTA.setText(BillTA.getText() + apartment + "\n");
                BillTA.setText(BillTA.getText() + address + "\n");
            }
            catch(SQLException e)
            {
               System.err.println("Exception Catched!");
               System.err.println(e);
            }
            BillTA.setText(BillTA.getText() + "****************************************************************************************************\n");
            
        }
    }//GEN-LAST:event_BillingBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoginRegister mainwindow = new LoginRegister();
        mainwindow.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        unitpanel.setVisible(false);
        addUnitPanel.setVisible(true);
    }//GEN-LAST:event_addBActionPerformed
    
    
    private void viewBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBActionPerformed
        if(jList1.getSelectedValue() != null)
        {    
            unitpanel.setVisible(false);
            viewpanel.setVisible(true);
            String unitName = jList1.getSelectedValue();
            unitNameLO.setText(unitName);
            unitNameLO.setHorizontalAlignment(SwingConstants.CENTER);
            unitNameLO.setVerticalAlignment(SwingConstants.CENTER);
            TF = 0;
            AddClearB.setText("Clear Tenant");

            int up = 0;
            String query = "SELECT * from units WHERE unit_name = ? AND apartment_id = ?";
            try
            {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, unitName);
                preparedStmt.setInt (2, apartmentID);
                ResultSet rs = preparedStmt.executeQuery();
                while(rs.next())
                {
                    unitpriceLO.setText(String.format("%s",rs.getInt("unit_price")));
                    unittypeLO.setText(rs.getString("unit_type"));
                    up = rs.getInt("unit_price");
                    unitID = rs.getInt("id");
                    
                    String tenantName = "", balance="", contact="",deposit="", strDate="", strCheck="";
                    int balanceI = 0;
                    query = "SELECT *, concat(tenants.first_name,' ',tenants.last_name) AS 'tenant_name' from units INNER JOIN tenants ON tenants.unit_id = units.id WHERE units.unit_name = ? AND units.apartment_id = ?";
                    preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, unitName);
                    preparedStmt.setInt (2, apartmentID);
                    rs = preparedStmt.executeQuery();
                    while(rs.next())
                    {
                        tenantName = rs.getString("tenant_name");
                        balanceI = rs.getInt("balance") + rs.getInt("water_bill") + rs.getInt("electric_bill");
                        balance = String.format("%d",balanceI);
                        contact = String.format("%d",rs.getLong("contact_no"));
                        deposit= String.format("%s",rs.getInt("advance"));
                            if(rs.getInt("advance")<=0)
                            {
                                useAdvanceB.setVisible(false);
                            }
                            else
                            {
                                useAdvanceB.setVisible(true);
                            }
                        try
                        {    
                            Date date =  rs.getDate("last_payment"); 
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                            strDate = dateFormat.format(date);
                        }
                        catch(SQLException ee)
                        {
                            strDate = "";
                        }
                        
                        try
                        {    
                            java.sql.Date date =  rs.getDate("last_checked"); 
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                            strCheck = dateFormat.format(date);
                        }
                        catch(SQLException ee)
                        {
                            strCheck = "";
                        }
                    
                    }
                    if(tenantName.isEmpty())
                    {
                        TF = 1;
                        AddClearB.setText("Add Tenant");
                        balanceLO.setText("");
                        tenantNameLO.setText("");
                        contactLO.setText("");
                        depositLO.setText("");
                        lastPaymentLO.setText("");
                    }
                    else
                    {
                        balanceLO.setText(balance);
                        tenantNameLO.setText(tenantName);
                        contactLO.setText(contact);
                        depositLO.setText(deposit);
                        lastPaymentLO.setText(strDate);
                        
                        
                        long millis=System.currentTimeMillis();  
                        java.sql.Date date=new java.sql.Date(millis);
                        
                        String format = "yyyy-MM-dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(format);
                        Date strCheck2 = sdf.parse(strCheck);
                        
                        long diff = date.getTime() - strCheck2.getTime();
                        
                        
                        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                        
                        if(diffDays >= 30)
                        {
                            int x = diffDays / 30;
                            
                            int balanceZ = balanceI + (x*up);
                            query = "UPDATE tenants SET last_checked = ? ,balance = ? WHERE unit_id = ?";
                            preparedStmt = conn.prepareStatement(query);
                            preparedStmt.setDate(1, date);
                            preparedStmt.setInt(2,balanceZ);
                            preparedStmt.setInt(3,unitID);
                            preparedStmt.execute();
                            
                        }
                    }
                }

            }
            catch(SQLException e)
            {
                System.err.println(e);
            } catch (ParseException ex) {
                Logger.getLogger(UserDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_viewBActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        String unitName = jList1.getSelectedValue();
       
        String query = "SELECT * from units WHERE unit_name = ? AND apartment_id = ?";
        try
        {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, unitName);
            preparedStmt.setInt (2, apartmentID);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next())
            {
                
                
                unitPriceLO.setText(String.format("Unit Price : %d",rs.getInt("unit_price")));
                
                query = "SELECT concat(tenants.first_name,' ',tenants.last_name) AS 'tenant_name' from tenants INNER JOIN units ON tenants.unit_id = units.id WHERE units.unit_name = ? AND units.apartment_id = ?";
                String tenantName = "";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, unitName);
                preparedStmt.setInt (2, apartmentID);
                rs = preparedStmt.executeQuery();
                while(rs.next())
                {
                    tenantName = rs.getString("tenant_name");
                }
                if(tenantName.isEmpty())
                {
                    jLabel4.setText("Unit Details");
                    statusLO.setText("Status: Unoccupied");
                    tenantLO.setText("Tenant: ");
                }
                else
                {
                    jLabel4.setText("Unit Details");
                    statusLO.setText("Status: Occupied");
                    tenantLO.setText("Tenant: " + tenantName);                  
                }
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        String unitName = jList1.getSelectedValue();
        String query = "SELECT * FROM units WHERE unit_name = ? AND apartment_id = ?";
        try
        {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, unitName);
            preparedStmt.setInt (2, apartmentID);
            ResultSet rs = preparedStmt.executeQuery();
            int id = 0;
            while(rs.next())
            {
                id = rs.getInt("id");
            }
            
            query = "DELETE FROM tenants where unit_id = ?";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, id);
            preparedStmt.execute();
        }
        catch(SQLException ez)
        {
            System.err.println("Exception Catched!");
            System.err.println(ez);
        }
        
            
        query = "DELETE FROM units WHERE unit_name = ? AND apartment_id = ?";
        try
        {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, unitName);
            preparedStmt.setInt (2, apartmentID);
            preparedStmt.execute();
                query = "SELECT * FROM units WHERE apartment_id = ?";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt (1, apartmentID);
                DefaultListModel list = new DefaultListModel();
                ResultSet rs = preparedStmt.executeQuery();
                i=0;
                while(rs.next())
                {
                    i++;
                    list.addElement(rs.getString("unit_name"));
                }
                
                
                jList1.setModel(list);
                
                query = "UPDATE apartment SET no_of_units = ? WHERE id = ?";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt (1, i);
                preparedStmt.setInt (2, apartmentID);
                preparedStmt.execute();
                
                numofunitsLO.setText(String.format("%d",i));
                numofunitsLO1.setText(String.format("%d",i));
                
                unitPriceLO.setText("");
                statusLO.setText("");
                tenantLO.setText("");
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_deleteBActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String query = "SELECT * FROM units WHERE apartment_id = ?";
        String unitName, unitType;
        int unitPrice;
        if(addUnitName.getText().isEmpty() || addUnitPrice.getText().isEmpty() || addUnitType.getText().isEmpty())
        {
            xxx.setVisible(true);
            xxx.setText("All Fields are Reuired");
        }
        else
        {
            unitName = addUnitName.getText();
            unitType = addUnitType.getText();
            try
            {
                unitPrice = Integer.parseInt(addUnitPrice.getText());            
                try
                {
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setInt (1, apartmentID);
                    ResultSet rs = preparedStmt.executeQuery();
                    int xx = 0;
                    while(rs.next())
                    {   
                        String yy = rs.getString("unit_name");
                        if(unitName.equals(yy) )
                        {
                            xx = 1;
                        }
                    }
                    if(xx != 1)
                    {
                        query = " insert into units(apartment_id,unit_name,unit_price,unit_type)"
                        + " values (?,?,?,?)";

                        preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setInt (1, apartmentID);
                        preparedStmt.setString (2, unitName);
                        preparedStmt.setInt (3, unitPrice);
                        preparedStmt.setString (4, unitType);

                        preparedStmt.execute();

                            query = "SELECT * FROM units WHERE apartment_id = ?";
                            preparedStmt = conn.prepareStatement(query);
                            preparedStmt.setInt (1, apartmentID);
                            DefaultListModel list = new DefaultListModel();
                            rs = preparedStmt.executeQuery();
                            i=0;
                            while(rs.next())
                            {
                                i++;
                                list.addElement(rs.getString("unit_name"));                
                            }
                            jList1.setModel(list);

                            query = "UPDATE apartment SET no_of_units = ? WHERE id = ?";
                            preparedStmt = conn.prepareStatement(query);
                            preparedStmt.setInt (1, i);
                            preparedStmt.setInt (2, apartmentID);
                            preparedStmt.execute();

                            numofunitsLO.setText(String.format("%d",i));
                            numofunitsLO1.setText(String.format("%d",i));

                            addUnitPanel.setVisible(false);
                            unitpanel.setVisible(true);
                            addUnitName.setText("");
                            addUnitPrice.setText("");
                            addUnitType.setText("");
                            xxx.setVisible(false);
                    }
                    else
                    {
                        xxx.setVisible(true);
                        xxx.setText("Unit Name Already Exist");
                    }

                }
                catch(SQLException e)
                {
                    System.err.println(e);
                }
            }
            catch(NumberFormatException ez)
            {
                xxx.setVisible(true);
                xxx.setText("Invalid Unit Price");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void addUnitNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUnitNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addUnitNameActionPerformed

    private void editApartmentBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editApartmentBActionPerformed
        apartpanel.setVisible(false);
        editApartmentP.setVisible(true);
    }//GEN-LAST:event_editApartmentBActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String apartName, apartAdd;
        apartName = editANameTF.getText();
        apartAdd = editAAddTF.getText();
        
        String query = "UPDATE apartment SET name = ?, address = ? WHERE id = ?";
        try
        {
            PreparedStatement prep = conn.prepareStatement(query);
            prep.setString(1,apartName);
            prep.setString(2,apartAdd);
            prep.setInt(3,apartmentID);
            
            prep.execute();
            
            nameApartLO.setText(apartName);
            addressLO.setText(apartAdd);
            
            editApartmentP.setVisible(false);
            apartpanel.setVisible(true);
        }
        catch(SQLException e)
        {
            System.err.println("Exception Catched!");
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void AddClearBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClearBActionPerformed
        if(TF == 0)
        {
            double balance = 0;
            String query = "SELECT * FROM tenants WHERE unit_id = ?";
            try
            {
                PreparedStatement prep = conn.prepareStatement(query);
                prep.setInt(1,unitID);
                ResultSet rs = prep.executeQuery();
                while(rs.next())
                {
                    balance = rs.getDouble("balance") + rs.getDouble("water_bill") + rs.getDouble("electric_bill");
                }
            }
            catch(SQLException ez)
            {
                System.err.println("Exception Catched");
                System.err.println(ez);
            }
            if(balance == 0)
            {
                query = "DELETE FROM tenants WHERE unit_id = ?";
                try
                {
                    PreparedStatement prep = conn.prepareStatement(query);
                    prep.setInt(1,unitID);

                    prep.execute();

                    balanceLO.setText("");
                    tenantNameLO.setText("");
                    contactLO.setText("");
                    depositLO.setText("");
                    lastPaymentLO.setText("");

                    statusLO.setText("Unoccupied");
                    tenantLO.setText("");

                    TF=1;
                    AddClearB.setText("Add Tenant");
                }
                catch(SQLException e)
                {
                    System.err.println("Exception Catched");
                    System.err.println(e);
                }
            }
            else
            {
                ClearError.setText("Can't Clear Tenant! Unpaid Balance");
            }
        }
        else
        {
            ClearError.setText("");
            viewpanel.setVisible(false);
            addClearTenantP.setVisible(true);
        }
    }//GEN-LAST:event_AddClearBActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        TF = 0;
        String query ="INSERT INTO tenants(unit_id,last_name,first_name,contact_no,balance,advance,water_bill,electric_bill) VALUES(?,?,?,?,0,0,0,0)";
        String lName, fName,contact;
        long  contact1;
        if(addTLNameTF.getText().isEmpty() || addTFNameTF.getText().isEmpty() || addTNumTF.getText().isEmpty())
        {
            addTenantError.setText("All Fields are Required");
        }
        else
        {
            lName = addTLNameTF.getText();
            fName = addTFNameTF.getText();
            contact = addTNumTF.getText();
            try
            {
                contact1 = Long.parseLong(contact);
                try
                {
                    PreparedStatement prep = conn.prepareStatement(query);
                    prep.setInt(1,unitID);
                    prep.setString(2,lName);
                    prep.setString(3,fName);
                    prep.setLong(4,contact1);

                    prep.execute();

                    int balance = 0;
                    query = "SELECT * FROM units where id = ?";
                    prep = conn.prepareStatement(query);
                    prep.setInt(1,unitID);
                    ResultSet rs = prep.executeQuery();
                    while(rs.next())
                    {
                        balance = rs.getInt("unit_price");
                    }

                    long millis=System.currentTimeMillis();  
                    java.sql.Date date=new java.sql.Date(millis);
                    query = "UPDATE tenants SET last_checked = ? ,balance = ? WHERE unit_id = ?";
                    prep = conn.prepareStatement(query);
                    prep.setDate(1, date);
                    prep.setInt(2,balance);
                    prep.setInt(3,unitID);
                    prep.execute();

                    addClearTenantP.setVisible(false);
                    viewpanel.setVisible(true);

                    balanceLO.setText(String.format("%d",balance));
                    tenantNameLO.setText(fName+" "+lName);
                    contactLO.setText(contact);
                    depositLO.setText("0");
                    lastPaymentLO.setText("");

                    statusLO.setText("Occupied");
                    tenantLO.setText(fName+" "+lName);

                     AddClearB.setText("Clear Tenant");
                     addTenantError.setText("");
                }
                catch(SQLException e)
                {
                    System.err.println("Exception Catched!");
                    System.err.println(e);
                }
                
            }    
            catch(NumberFormatException ez)
            {
                addTenantError.setText("Invalid Contact Number");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    public static double Pwater=0, Pelectric=0, Cwater=0,Celectric;
    private void genBillBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genBillBActionPerformed
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);
        try
        {
            if(waterTF.getText().isEmpty())
            {
                Cwater = 0;
            }
            else
            {
               Cwater = Double.parseDouble(waterTF.getText());
            }
            if(electricTF.getText().isEmpty())
            {
                    Celectric = 0;
            }
            else
            {
                Celectric = Double.parseDouble(electricTF.getText());
            }        
            BillTA.setText("****************************************************************************************************\n");
            String query = "SELECT * FROM apartment where id = ?";
            try
            {
                String address="", apartment="";
                PreparedStatement prep = conn.prepareStatement(query);
                prep.setInt(1,apartmentID);
                ResultSet rs = prep.executeQuery();
               while(rs.next())
                {
                    apartment = rs.getString("name");
                    address = rs.getString("address");
                }
                BillTA.setText(BillTA.getText() + apartment + "\n");
                BillTA.setText(BillTA.getText() + address + "\n");
            }
            catch(SQLException e)
            {
               System.err.println("Exception Catched!");
               System.err.println(e);
            }
            BillTA.setText(BillTA.getText() + "****************************************************************************************************\n");

            query = "SELECT * from tenants INNER JOIN units ON tenants.unit_id = units.id WHERE unit_id = ?";
            try
            {
                String unitName = "", tenantName="";
                double balance=0;
                PreparedStatement prep = conn.prepareStatement(query);
                prep.setInt(1,unitID);
                ResultSet rs = prep.executeQuery();
                while(rs.next())
                {
                    unitName = rs.getString("unit_name");
                    tenantName = rs.getString("first_name") + " " + rs.getString("last_name");
                    balance = rs.getDouble("balance");
                    Pwater = rs.getDouble("water_bill");
                    Pelectric = rs.getDouble("electric_bill");
                }
                BillTA.setText(BillTA.getText() + "\n");
                BillTA.setText(BillTA.getText() + unitName + "\n");
                BillTA.setText(BillTA.getText() + tenantName + "\n");
                BillTA.setText(BillTA.getText() + date + "\n");
                BillTA.setText(BillTA.getText() + "\n");
                BillTA.setText(BillTA.getText() + "-----------------------------------------------------------------------------------------------------------------------------\n");
                if(balance!=0)
                {
                    BillTA.setText(BillTA.getText() + "Rent Balance :                                                  " + String.format("%.2f",balance) + "\n");
                    BillTA.setText(BillTA.getText() + "-----------------------------------------------------------------------------------------------------------------------------\n");
                }
                if(Pwater!=0)
                {
                    BillTA.setText(BillTA.getText() + "Previous Water Balance :      " + String.format("%.2f",Pwater) + "\n");
                }
                if(Cwater != 0)
                {
                    BillTA.setText(BillTA.getText() + "Current Water Bill :                 " + String.format("%.2f",Cwater) + "\n");
                }
                Cwater = Cwater + Pwater;
                if(Cwater != 0)
                {
                    BillTA.setText(BillTA.getText() + "Total Water Bill :                                               " + String.format("%.2f",Cwater) + "\n");
                    BillTA.setText(BillTA.getText() + "-----------------------------------------------------------------------------------------------------------------------------\n");
                }
                if(Pelectric!=0)
                {
                    BillTA.setText(BillTA.getText() + "Previous Electric Balance :   " + String.format("%.2f",Pelectric) + "\n");
                }
                if(Celectric != 0)
                {
                    BillTA.setText(BillTA.getText() + "Current Electric Bill :               " + String.format("%.2f",Celectric) + "\n");
                }
                Celectric = Celectric + Pelectric;
                if(Celectric != 0)
                {
                    BillTA.setText(BillTA.getText() + "Total Electric Bill :                                            " + String.format("%.2f",Celectric) + "\n");
                    BillTA.setText(BillTA.getText() + "-----------------------------------------------------------------------------------------------------------------------------\n");
                }
                double Total = balance + Cwater + Celectric;
                BillTA.setText(BillTA.getText() + "Total :                                                                 " +  String.format("%.2f",Total) + "\n");
            }
            catch(SQLException e)
            {
                System.err.println("Exception Catched");
                System.err.println(e);
            }
            BillTA.setText(BillTA.getText() + "****************************************************************************************************");
            printBillB.setVisible(true);
            BillingError.setText("");
        }
        catch(NumberFormatException ez)
        {
            BillTA.setText("****************************************************************************************************\n");
            String query = "SELECT * FROM apartment where id = ?";
            try
            {
                String address="", apartment="";
                PreparedStatement prep = conn.prepareStatement(query);
                prep.setInt(1,apartmentID);
                ResultSet rs = prep.executeQuery();
               while(rs.next())
                {
                    apartment = rs.getString("name");
                    address = rs.getString("address");
                }
                BillTA.setText(BillTA.getText() + apartment + "\n");
                BillTA.setText(BillTA.getText() + address + "\n");
            }
            catch(SQLException e)
            {
               System.err.println("Exception Catched!");
               System.err.println(e);
            }
            BillTA.setText(BillTA.getText() + "****************************************************************************************************\n");
            BillingError.setText("Invalid Bill Input");
            printBillB.setVisible(false);
        }
        waterTF.setText("");
        electricTF.setText("");
    }//GEN-LAST:event_genBillBActionPerformed

    private void printBillBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBillBActionPerformed
        double Bal = 0;
        String query = "SELECT * FROM tenants WHERE unit_id = ?";
        try
        {
            PreparedStatement prep = conn.prepareStatement(query);
            prep.setInt(1,unitID);
            ResultSet rs = prep.executeQuery();
            while(rs.next())
            {
                Bal = rs.getDouble("balance");
            }
        }
        catch(SQLException e)
        {
            System.err.println("Exception Catched!!");
            System.err.println(e);
        }
        query = "UPDATE tenants SET water_bill = ?, electric_bill = ? WHERE unit_id = ?";
        try
        {
            PreparedStatement prep = conn.prepareStatement(query);
            prep.setDouble(1,Cwater);
            prep.setDouble(2,Celectric);
            prep.setInt(3,unitID);
            
            prep.execute();
            
            balanceLO.setText(String.format("%.2f",Cwater + Celectric+ Bal));
            
            try
            {
                BillTA.print();
            }
            catch(PrinterException er)
            {
                System.err.println("Got an exception! ");
		System.err.println(er.getMessage());
            }
            
            billingpanel.setVisible(false);
            viewpanel.setVisible(true);
        }
        catch(SQLException e)
        {
            System.err.println("Exception Catched!");
            System.err.println(e);
        }
        
    }//GEN-LAST:event_printBillBActionPerformed

    private void PaymentBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentBActionPerformed
        ClearError.setText("");
        rentPTF.setText("");
        waterPTF.setText("");
        elecPTF.setText("");
        if(TF == 0)
        {
            viewpanel.setVisible(false);
            paymentPanel.setVisible(true);
            printPB.setVisible(false);
            
            paymentTA.setText("****************************************************************************************************\n");
            String query = "SELECT * FROM apartment where id = ?";
            try
            {
                String address="", apartment="";
                PreparedStatement prep = conn.prepareStatement(query);
                prep.setInt(1,apartmentID);
                ResultSet rs = prep.executeQuery();
                while(rs.next())
                {
                    apartment = rs.getString("name");
                    address = rs.getString("address");
                }
                paymentTA.setText(paymentTA.getText() + apartment + "\n");
                paymentTA.setText(paymentTA.getText() + address + "\n");
            }
            catch(SQLException e)
            {
               System.err.println("Exception Catched!");
               System.err.println(e);
            }
            paymentTA.setText(paymentTA.getText() + "****************************************************************************************************\n");
        }
    }//GEN-LAST:event_PaymentBActionPerformed

    private void waterPTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waterPTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waterPTFActionPerformed
    public static double waterPay=0, elecPay=0, rentPay=0 ,advanceP; 
    private void genReceiptBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReceiptBActionPerformed
        if(rentPTF.getText().isEmpty() == false || waterPTF.getText().isEmpty() == false || elecPTF.getText().isEmpty() == false || useAdvanceB.isSelected())
        {   waterPay=0;
            elecPay=0; 
            rentPay=0;
            advanceP =0;
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);
            
            double elecBPay=0,waterBPay=0;
            paymentTA.setText("****************************************************************************************************\n");
            String query = "SELECT * FROM apartment where id = ?";
            try
            {
                String address="", apartment="";
                PreparedStatement prep = conn.prepareStatement(query);
                prep.setInt(1,apartmentID);
                ResultSet rs = prep.executeQuery();
               while(rs.next())
                {
                    apartment = rs.getString("name");
                    address = rs.getString("address");
                }
                paymentTA.setText(paymentTA.getText() + apartment + "\n");
                paymentTA.setText(paymentTA.getText() + address + "\n");
            }
            catch(SQLException e)
            {
               System.err.println("Exception Catched!");
               System.err.println(e);
            }
            paymentTA.setText(paymentTA.getText() + "****************************************************************************************************\n");

            try
            {
                query = "SELECT * from tenants INNER JOIN units ON tenants.unit_id = units.id WHERE unit_id = ?";
                try
                {
                    String unitName = "", tenantName="";
                    double balance=0, change = 0;
                    PreparedStatement prep = conn.prepareStatement(query);
                    prep.setInt(1,unitID);
                    ResultSet rs = prep.executeQuery();
                    while(rs.next())
                    {
                        unitName = rs.getString("unit_name");
                        tenantName = rs.getString("first_name") + " " + rs.getString("last_name");
                        balance = rs.getDouble("balance");
                        waterBPay = rs.getDouble("water_bill");
                        elecBPay = rs.getDouble("electric_bill");
                        advanceP = rs.getDouble("advance");
                    }
                    paymentTA.setText(paymentTA.getText() + "\n" + unitName + "\n");
                   paymentTA.setText(paymentTA.getText()  + tenantName + "\n");
                   paymentTA.setText(paymentTA.getText()  + date + "\n\n");
                   paymentTA.setText(paymentTA.getText() + "-----------------------------------------------------------------------------------------------------------------------------\n");
                    if(balance!=0)
                    {
                        paymentTA.setText(paymentTA.getText() + "Rent Bill :                         " + String.format("%.2f",balance) + "\n");
                    }
                    if(waterBPay!=0)
                    {
                        paymentTA.setText(paymentTA.getText() + "Water Bill :                       " + String.format("%.2f",waterBPay) + "\n");
                    }
                    if(elecBPay!=0)
                    {
                        paymentTA.setText(paymentTA.getText() + "Electric Bill :                    " + String.format("%.2f",elecBPay) + "\n");
                    }
                    double TotalBalance = balance + waterBPay + elecBPay;
                    paymentTA.setText(paymentTA.getText() + "Total Bill :                                                                        " +  String.format("%.2f",TotalBalance) + "\n");

                    paymentTA.setText(paymentTA.getText() + "-----------------------------------------------------------------------------------------------------------------------------\n");

                    if(useAdvanceB.isSelected())
                    {
                        rentPay = advanceP;
                        advanceP = 0;
                    }
                    if(rentPTF.getText().isEmpty())
                    {
                        if(rentPay!=0)
                        {   
                            paymentTA.setText(paymentTA.getText() + "Rent Payment :              " + String.format("%.2f",rentPay) + "\n");
                        }
                    }
                    else
                    {
                        rentPay = Double.parseDouble(rentPTF.getText()) + rentPay;
                        paymentTA.setText(paymentTA.getText() + "Rent Payment :              " + String.format("%.2f",rentPay) + "\n");
                    }
                    if(waterPTF.getText().isEmpty())
                    {
                        waterPay = 0;
                    }
                    else
                    {
                        waterPay = Double.parseDouble(waterPTF.getText());
                        paymentTA.setText(paymentTA.getText() + "Water Bill Payment :     " + String.format("%.2f",waterPay) + "\n");
                    }
                    if(elecPTF.getText().isEmpty())
                    {
                        elecPay = 0;
                    }
                    else
                    {
                        elecPay = Double.parseDouble(elecPTF.getText());
                        paymentTA.setText(paymentTA.getText() + "Electric Bill Payment :   " + String.format("%.2f",elecPay) + "\n");
                    }
                    double TotalPayment = rentPay + waterPay + elecPay;
                    paymentTA.setText(paymentTA.getText() + "Total Payment :                                                             " +  String.format("%.2f",TotalPayment) + "\n");

                    paymentTA.setText(paymentTA.getText() + "-----------------------------------------------------------------------------------------------------------------------------\n");

                    rentPay = balance - rentPay;
                    if(rentPay<0)
                    {
                        if(addToAdvance.isSelected() || useAdvanceB.isSelected())
                        {
                            double excelP = 0 - rentPay;
                            advanceP = advanceP + excelP;
                            rentPay = 0;
                        }
                        else
                        {
                            double excelP = 0 - rentPay;
                            change = change + excelP;
                            rentPay = 0;
                        }
                    }
                    waterPay = waterBPay - waterPay;
                    if(waterPay<0)
                    {
                        double excelP = 0 - waterPay;
                        change = change + excelP;
                        waterPay = 0;
                    }
                    elecPay = elecBPay - elecPay;
                    if(elecPay<0)
                    {
                        double excelP = 0 - elecPay;
                        change = change + excelP;
                        elecPay = 0;
                    }

                    double TBalance = rentPay + waterPay + elecPay;
                    paymentTA.setText(paymentTA.getText() + "Remaining Balance :                                                   " +  String.format("%.2f",TBalance) + "\n");
                    if(change != 0)
                    {
                        paymentTA.setText(paymentTA.getText() + "Change :                                                                         " +  String.format("%.2f",change) + "\n");
                    }
                    if(advanceP!=0)
                    {
                        paymentTA.setText(paymentTA.getText() + "\nRemaining Advance :                                                   " +  String.format("%.2f",advanceP) + "\n");                
                    }


                }
                catch(SQLException e)
                {
                    System.err.println("Exception Catched");
                    System.err.println(e);
                }
                paymentTA.setText(paymentTA.getText() + "****************************************************************************************************");
                PaymentError.setText("");
                printPB.setVisible(true);
            }
            catch(NumberFormatException ez)
            {
                paymentTA.setText("****************************************************************************************************\n");
                query = "SELECT * FROM apartment where id = ?";
                try
                {
                    String address="", apartment="";
                    PreparedStatement prep = conn.prepareStatement(query);
                    prep.setInt(1,apartmentID);
                    ResultSet rs = prep.executeQuery();
                   while(rs.next())
                    {
                        apartment = rs.getString("name");
                        address = rs.getString("address");
                    }
                    paymentTA.setText(paymentTA.getText() + apartment + "\n");
                    paymentTA.setText(paymentTA.getText() + address + "\n");
                }
                catch(SQLException e)
                {
                   System.err.println("Exception Catched!");
                   System.err.println(e);
                }
                paymentTA.setText(paymentTA.getText() + "****************************************************************************************************\n");
                PaymentError.setText("Invalid Bill Input");
                printPB.setVisible(false);
            }
        }
        rentPTF.setText("");
        waterPTF.setText("");
        elecPTF.setText("");
        useAdvanceB.setSelected(false);
    }//GEN-LAST:event_genReceiptBActionPerformed

    private void printPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPBActionPerformed
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);
    
        String query = "UPDATE tenants SET balance = ?,water_bill = ?, electric_bill = ? , advance = ?, last_payment = ? WHERE unit_id = ?";
        try
        {
            PreparedStatement prep = conn.prepareStatement(query);
            prep.setDouble(1,rentPay);
            prep.setDouble(2,waterPay);
            prep.setDouble(3,elecPay);
            prep.setDouble(4,advanceP);
            prep.setDate(5,date);
            prep.setInt(6,unitID);
            
            prep.execute();
           
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = dateFormat.format(date);
            lastPaymentLO.setText(strDate);
            balanceLO.setText(String.format("%.2f",rentPay + waterPay + elecPay));
            depositLO.setText(String.format("%.2f",advanceP));
            try
            {
                paymentTA.print();
            }
            catch(PrinterException er)
            {
                System.err.println("Got an exception! ");
		System.err.println(er.getMessage());
            }
            
            paymentPanel.setVisible(false);
            viewpanel.setVisible(true);
        }
        catch(SQLException e)
        {
            System.err.println("Exception Catched!");
            System.err.println(e);
        }
    }//GEN-LAST:event_printPBActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        addClearTenantP.setVisible(false);
        viewpanel.setVisible(true);
        
        addTLNameTF.setText("");
        addTFNameTF.setText("");
        addTNumTF.setText("");
        
        addTenantError.setText("");
    }//GEN-LAST:event_backActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        editApartmentP.setVisible(false);
        apartpanel.setVisible(true);
        
        editANameTF.setText("");
        editAAddTF.setText("");
    }//GEN-LAST:event_back1ActionPerformed

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
       viewpanel.setVisible(false);
       unitpanel.setVisible(true);
       jList1.clearSelection();
       
       unitPriceLO.setText("");
       tenantLO.setText("");
       statusLO.setText("");
       ClearError.setText("");
    }//GEN-LAST:event_back2ActionPerformed

    private void back3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back3ActionPerformed
       addUnitPanel.setVisible(false);
       unitpanel.setVisible(true);
       jList1.clearSelection();
       
       addUnitName.setText("");
       addUnitPrice.setText("");
       addUnitType.setText("");
       
       unitPriceLO.setText("");
       tenantLO.setText("");
       statusLO.setText("");
    }//GEN-LAST:event_back3ActionPerformed

    private void back4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back4ActionPerformed
        billingpanel.setVisible(false);
        viewpanel.setVisible(true);
        
        waterTF.setText("");
        electricTF.setText("");
        BillingError.setText("");
    }//GEN-LAST:event_back4ActionPerformed

    private void back5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back5ActionPerformed
        paymentPanel.setVisible(false);
        viewpanel.setVisible(true);
        
        rentPTF.setText("");
        waterPTF.setText("");
        elecPTF.setText("");
    }//GEN-LAST:event_back5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard(user_id).setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClearB;
    private javax.swing.JTextArea BillTA;
    private javax.swing.JButton BillingB;
    private javax.swing.JLabel BillingError;
    private javax.swing.JLabel ClearError;
    private javax.swing.JButton PaymentB;
    private javax.swing.JLabel PaymentError;
    private javax.swing.JButton addB;
    private javax.swing.JPanel addClearTenantP;
    private javax.swing.JTextField addTFNameTF;
    private javax.swing.JTextField addTLNameTF;
    private javax.swing.JTextField addTNumTF;
    private javax.swing.JLabel addTenantError;
    private javax.swing.JRadioButton addToAdvance;
    private javax.swing.JTextField addUnitName;
    private javax.swing.JPanel addUnitPanel;
    private javax.swing.JTextField addUnitPrice;
    private javax.swing.JTextField addUnitType;
    private javax.swing.JLabel addressL;
    private javax.swing.JLabel addressL1;
    private javax.swing.JLabel addressLO;
    private javax.swing.JPanel apartpanel;
    private javax.swing.JButton back;
    private javax.swing.JButton back1;
    private javax.swing.JButton back2;
    private javax.swing.JButton back3;
    private javax.swing.JButton back4;
    private javax.swing.JButton back5;
    private javax.swing.JLabel balanceL;
    private javax.swing.JLabel balanceLO;
    private javax.swing.JPanel billingpanel;
    private javax.swing.JLabel contactL;
    private javax.swing.JLabel contactLO;
    private javax.swing.JPanel dashboardpanels;
    private javax.swing.JButton deleteB;
    private javax.swing.JLabel depositL;
    private javax.swing.JLabel depositLO;
    private javax.swing.JTextField editAAddTF;
    private javax.swing.JTextField editANameTF;
    private javax.swing.JButton editApartmentB;
    private javax.swing.JPanel editApartmentP;
    private javax.swing.JTextField elecPTF;
    private javax.swing.JTextField electricTF;
    private javax.swing.JButton genBillB;
    private javax.swing.JButton genReceiptB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lastPaymentL;
    private javax.swing.JLabel lastPaymentLO;
    private javax.swing.JPanel logopanel;
    private javax.swing.JLabel nameApartL;
    private javax.swing.JLabel nameApartL1;
    private javax.swing.JLabel nameApartLO;
    private javax.swing.JLabel numofunitsL;
    private javax.swing.JLabel numofunitsL1;
    private javax.swing.JLabel numofunitsLO;
    private javax.swing.JLabel numofunitsLO1;
    private javax.swing.JLabel ownerL;
    private javax.swing.JLabel ownerL1;
    private javax.swing.JLabel ownerLO;
    private javax.swing.JLabel ownerLO1;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JTextArea paymentTA;
    private javax.swing.JButton printBillB;
    private javax.swing.JButton printPB;
    private javax.swing.JTextField rentPTF;
    private javax.swing.JLabel rentPayL;
    private javax.swing.JLabel rentPayL1;
    private javax.swing.JLabel rentPayL2;
    private javax.swing.JPanel sidebarpanel;
    private javax.swing.JLabel statusLO;
    private javax.swing.JLabel tenantLO;
    private javax.swing.JLabel tenantNameL;
    private javax.swing.JLabel tenantNameLO;
    private javax.swing.JPanel toppanel;
    private javax.swing.JLabel unitNameLO;
    private javax.swing.JLabel unitPriceLO;
    private javax.swing.JPanel unitpanel;
    private javax.swing.JLabel unitpriceL;
    private javax.swing.JLabel unitpriceLO;
    private javax.swing.JLabel unittypeL;
    private javax.swing.JLabel unittypeLO;
    private javax.swing.JRadioButton useAdvanceB;
    private javax.swing.JButton viewB;
    private javax.swing.JPanel viewpanel;
    private javax.swing.JTextField waterPTF;
    private javax.swing.JTextField waterTF;
    private javax.swing.JLabel xxx;
    // End of variables declaration//GEN-END:variables
}

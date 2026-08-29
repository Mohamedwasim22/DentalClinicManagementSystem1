/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dentalclinic.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class DashboardForm extends JFrame {

    private JPanel sidebarPanel;
    private JPanel contentPanel;

    private JLabel lblWelcome;
    private JLabel lblTotalPatients;
    private JLabel lblTotalAppointments;
    private JLabel lblTotalDoctors;
    private JLabel lblTotalPayments;

    private JButton btnDashboard;
    private JButton btnPatients;
    private JButton btnAppointments;
    private JButton btnDoctors;
    private JButton btnTreatments;
    private JButton btnPayments;
    private JButton btnReports;
    private JButton btnUsers;
    private JButton btnLogout;

    private JTable tblAppointments;

    public DashboardForm() {

        initializeUI();

    }

    private void initializeUI() {

        setTitle("Dental Clinic Management System - Dashboard");

        setSize(1200, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        createSidebar();

        createMainContent();

    }

    // ==========================================
    // SIDEBAR
    // ==========================================

    private void createSidebar() {

        sidebarPanel = new JPanel();

        sidebarPanel.setBackground(new Color(30, 45, 60));

        sidebarPanel.setPreferredSize(
                new Dimension(230, 700)
        );

        sidebarPanel.setLayout(
                new BorderLayout()
        );


        // ------------------------------------------
        // CLINIC TITLE
        // ------------------------------------------

        JPanel titlePanel = new JPanel();

        titlePanel.setBackground(
                new Color(30, 45, 60)
        );

        titlePanel.setPreferredSize(
                new Dimension(230, 120)
        );

        titlePanel.setLayout(
                new GridLayout(2, 1)
        );


        JLabel lblClinic = new JLabel(
                "DENTAL CLINIC"
        );

        lblClinic.setForeground(Color.WHITE);

        lblClinic.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        lblClinic.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        JLabel lblSystem = new JLabel(
                "MANAGEMENT SYSTEM"
        );

        lblSystem.setForeground(
                new Color(200, 210, 220)
        );

        lblSystem.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );

        lblSystem.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        titlePanel.add(lblClinic);

        titlePanel.add(lblSystem);


        // ------------------------------------------
        // MENU PANEL
        // ------------------------------------------

        JPanel menuPanel = new JPanel();

        menuPanel.setBackground(
                new Color(30, 45, 60)
        );

        menuPanel.setLayout(
                new GridLayout(9, 1, 0, 8)
        );

        menuPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        15,
                        20,
                        15
                )
        );


        btnDashboard =
                createMenuButton("Dashboard");

        btnPatients =
                createMenuButton("Patients");

        btnAppointments =
                createMenuButton("Appointments");

        btnDoctors =
                createMenuButton("Doctors");

        btnTreatments =
                createMenuButton("Treatments");

        btnPayments =
                createMenuButton("Payments");

        btnReports =
                createMenuButton("Reports");

        btnUsers =
                createMenuButton("Users");

        btnLogout =
                createMenuButton("Logout");


        menuPanel.add(btnDashboard);

        menuPanel.add(btnPatients);

        menuPanel.add(btnAppointments);

        menuPanel.add(btnDoctors);

        menuPanel.add(btnTreatments);

        menuPanel.add(btnPayments);

        menuPanel.add(btnReports);

        menuPanel.add(btnUsers);

        menuPanel.add(btnLogout);


        sidebarPanel.add(
                titlePanel,
                BorderLayout.NORTH
        );

        sidebarPanel.add(
                menuPanel,
                BorderLayout.CENTER
        );


        add(
                sidebarPanel,
                BorderLayout.WEST
        );

    }


    // ==========================================
    // CREATE MENU BUTTON
    // ==========================================

    private JButton createMenuButton(String text) {

        JButton button =
                new JButton(text);

        button.setBackground(
                new Color(30, 45, 60)
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setMargin(
                new Insets(0, 15, 0, 0)
        );

        return button;

    }


    // ==========================================
    // MAIN CONTENT
    // ==========================================

    private void createMainContent() {

        contentPanel = new JPanel();

        contentPanel.setBackground(
                new Color(245, 247, 250)
        );

        contentPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );

        contentPanel.setLayout(
                new BorderLayout(0, 25)
        );


        // ------------------------------------------
        // TOP WELCOME AREA
        // ------------------------------------------

        JPanel topPanel = new JPanel();

        topPanel.setBackground(
                new Color(245, 247, 250)
        );

        topPanel.setLayout(
                new GridLayout(2, 1)
        );


        lblWelcome =
                new JLabel("Welcome back, Admin!");

        lblWelcome.setFont(
                new Font("Arial", Font.BOLD, 30)
        );


        JLabel lblSubtitle =
                new JLabel(
                        "Here is what is happening in your clinic today."
                );

        lblSubtitle.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        lblSubtitle.setForeground(
                Color.GRAY
        );


        topPanel.add(lblWelcome);

        topPanel.add(lblSubtitle);


        contentPanel.add(
                topPanel,
                BorderLayout.NORTH
        );


        // ------------------------------------------
        // CENTER AREA
        // ------------------------------------------

        JPanel centerPanel = new JPanel();

        centerPanel.setOpaque(false);

        centerPanel.setLayout(
                new BorderLayout(0, 25)
        );


        // ==========================================
        // DASHBOARD CARDS
        // ==========================================

        JPanel cardsPanel = new JPanel();

        cardsPanel.setOpaque(false);

        cardsPanel.setLayout(
                new GridLayout(
                        1,
                        4,
                        20,
                        0
                )
        );


        JPanel cardPatients =
                createDashboardCard(
                        "TOTAL PATIENTS",
                        "0"
                );

        JPanel cardAppointments =
                createDashboardCard(
                        "TODAY'S APPOINTMENTS",
                        "0"
                );

        JPanel cardDoctors =
                createDashboardCard(
                        "TOTAL DOCTORS",
                        "0"
                );

        JPanel cardPayments =
                createDashboardCard(
                        "TOTAL PAYMENTS",
                        "Rs. 0"
                );


        lblTotalPatients =
                (JLabel) cardPatients.getClientProperty("valueLabel");

        lblTotalAppointments =
                (JLabel) cardAppointments.getClientProperty("valueLabel");

        lblTotalDoctors =
                (JLabel) cardDoctors.getClientProperty("valueLabel");

        lblTotalPayments =
                (JLabel) cardPayments.getClientProperty("valueLabel");


        cardsPanel.add(cardPatients);

        cardsPanel.add(cardAppointments);

        cardsPanel.add(cardDoctors);

        cardsPanel.add(cardPayments);


        centerPanel.add(
                cardsPanel,
                BorderLayout.NORTH
        );


        // ==========================================
        // APPOINTMENT TABLE PANEL
        // ==========================================

        JPanel appointmentPanel = new JPanel();

        appointmentPanel.setBackground(
                Color.WHITE
        );

        appointmentPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(220, 220, 220)
                )
        );

        appointmentPanel.setLayout(
                new BorderLayout(10, 10)
        );


        JLabel lblAppointmentTitle =
                new JLabel("Today's Appointments");

        lblAppointmentTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        lblAppointmentTitle.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        20,
                        10,
                        0
                )
        );


        appointmentPanel.add(
                lblAppointmentTitle,
                BorderLayout.NORTH
        );


        // ==========================================
        // TABLE
        // ==========================================

        String[] columns = {
            "Time",
            "Patient",
            "Doctor",
            "Treatment",
            "Status"
        };


        DefaultTableModel model =
                new DefaultTableModel(
                        columns,
                        0
                );


        tblAppointments =
                new JTable(model);


        tblAppointments.setRowHeight(35);

        tblAppointments.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );


        tblAppointments.getTableHeader().setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );


        JScrollPane scrollPane =
                new JScrollPane(tblAppointments);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        15,
                        15,
                        15
                )
        );


        appointmentPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );


        centerPanel.add(
                appointmentPanel,
                BorderLayout.CENTER
        );


        contentPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );


        add(
                contentPanel,
                BorderLayout.CENTER
        );


        // ==========================================
        // BUTTON EVENTS
        // ==========================================

        btnDashboard.addActionListener(e -> {

            System.out.println(
                    "Dashboard Clicked"
            );

        });


        btnPatients.addActionListener(e -> {

            System.out.println(
                    "Patients Clicked"
            );

        });


        btnAppointments.addActionListener(e -> {

            System.out.println(
                    "Appointments Clicked"
            );

        });


        btnDoctors.addActionListener(e -> {

            System.out.println(
                    "Doctors Clicked"
            );

        });


        btnTreatments.addActionListener(e -> {

            System.out.println(
                    "Treatments Clicked"
            );

        });


        btnPayments.addActionListener(e -> {

            System.out.println(
                    "Payments Clicked"
            );

        });


        btnReports.addActionListener(e -> {

            System.out.println(
                    "Reports Clicked"
            );

        });


        btnUsers.addActionListener(e -> {

            System.out.println(
                    "Users Clicked"
            );

        });


        btnLogout.addActionListener(e -> {

            dispose();

            new LoginForm().setVisible(true);

        });

    }


    // ==========================================
    // DASHBOARD CARD
    // ==========================================

    private JPanel createDashboardCard(
            String title,
            String value
    ) {

        JPanel card = new JPanel();

        card.setBackground(
                Color.WHITE
        );

        card.setLayout(
                new GridLayout(2, 1)
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        220,
                                        220,
                                        220
                                )
                        ),
                        BorderFactory.createEmptyBorder(
                                10,
                                10,
                                10,
                                10
                        )
                )
        );


        JLabel titleLabel =
                new JLabel(
                        title,
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        titleLabel.setForeground(
                Color.GRAY
        );


        JLabel valueLabel =
                new JLabel(
                        value,
                        SwingConstants.CENTER
                );

        valueLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        valueLabel.setForeground(
                new Color(
                        41,
                        128,
                        185
                )
        );


        card.add(titleLabel);

        card.add(valueLabel);


        // Store value label
        card.putClientProperty(
                "valueLabel",
                valueLabel
        );


        return card;

    }


    // ==========================================
    // MAIN METHOD
    // ==========================================

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {

            e.printStackTrace();

        }


        java.awt.EventQueue.invokeLater(() -> {

            DashboardForm dashboard =
                    new DashboardForm();

            dashboard.setVisible(true);

        });

    }

}

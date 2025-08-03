import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class GymMembershipRegistration extends javax.swing.JFrame {
    public static double membershipAmount = 0;
    public static double facilityAmount = 0;
    public static double groupClasses = 0;
    private static double personalTrainerCost = 0.0;
    private static double discountPercentage = 0.0;
    private static double membershipTotal = 0.0;

    private javax.swing.ButtonGroup personalTrainerGroup;
    private javax.swing.ButtonGroup paymentFrequencyGroup;

    public GymMembershipRegistration() {
        initComponents();
        setupButtonGroups();

        this.jMembershiplan.addItem("Please select your membership plan");
        this.jMembershiplan.addItem("Basic plan");
        this.jMembershiplan.addItem("Standard plan");
        this.jMembershiplan.addItem("Premium plan");

        getContentPane().setBackground(Color.PINK);
    }

        public double MembershipPlan() {
        int selectedIndex = this.jMembershiplan.getSelectedIndex();
        String plan = this.jMembershiplan.getItemAt(selectedIndex);
        double amount = 0;

        if (plan.equalsIgnoreCase("Basic plan")) {
            amount = 250;
        } else if (plan.equalsIgnoreCase("Standard plan")) {
            amount = 400;
        } else if (plan.equalsIgnoreCase("Premium plan")) {
            amount = 600;
        }

        return amount;
    }

    private double calculateFacilityAmount() {
        double total = 0;
        if (jcbSauna.isSelected()) total += 50;
        if (jcbPool.isSelected()) total += 70;
        if (jcbLocker.isSelected()) total += 30;
        return total;
    }

    private double calculateGroupClassesAmount() {
        double total = 0;
        if (jcbCrossFit.isSelected()) total += 120;
        if (jcbYoga.isSelected()) total += 100;
        if (jcbZumba.isSelected()) total += 90;
        return total;
    }
    
    private double addPersonalTrainer() {
        double total = 0;
        if (jrbtnDaily.isSelected()) total += 400;
        if (jrbtnWeek.isSelected()) total += 150;
        return total;
    }
    
    public double addDiscount() {
        double total = 0;
        if (radBtnPayMonthly.isSelected()) total = 0;
        if (radBtnPayQuaterly.isSelected()) total = 0.05;
        return total;
    }

    private void updateSlipTextArea() {
        StringBuilder slip = new StringBuilder();

        slip.append("======= GYM MEMBERSHIP SLIP =======\n");

        String plan = jMembershiplan.getSelectedItem().toString();
        slip.append("Plan: ").append(plan).append("\n");

        slip.append("Add-on Facilities:\n");
        if (jcbSauna.isSelected()) slip.append(" - Sauna (R50)\n");
        if (jcbPool.isSelected()) slip.append(" - Pool (R70)\n");
        if (jcbLocker.isSelected()) slip.append(" - Locker (R30)\n");

        slip.append("Group Classes:\n");
        if (jcbCrossFit.isSelected()) slip.append(" - CrossFit (R120)\n");
        if (jcbYoga.isSelected()) slip.append(" - Yoga (R100)\n");
        if (jcbZumba.isSelected()) slip.append(" - Zumba (R90)\n");

        slip.append("Trainer Option:\n");
        if (jrbtnNo.isSelected()) slip.append(" - None (R0)\n");
        else if (jrbtnDaily.isSelected()) slip.append(" - Daily (R400)\n");
        else if (jrbtnWeek.isSelected()) slip.append(" - Once a Week (R150)\n");

        slip.append("Payment Frequency: ");
        if (radBtnPayMonthly.isSelected()) slip.append("Monthly (No Discount)\n");
        else if (radBtnPayQuaterly.isSelected()) slip.append("Quarterly (5% Discount)\n");

        if (jDateChooser1.getDate() != null) {
            String date = new SimpleDateFormat("dd MMM yyyy").format(jDateChooser1.getDate());
            slip.append("Start Date: ").append(date).append("\n");
        }

        slip.append("\n\n-----------------------------------\n");
        slip.append("Total Amount: ").append(membershipTotal).append("\n");
        slip.append("===================================");

        costBreakDown.setText(slip.toString());
    }

    private void clearAllFields() {
        jMembershiplan.setSelectedIndex(0);

        jcbSauna.setSelected(false);
        jcbPool.setSelected(false);
        jcbLocker.setSelected(false);

        jcbCrossFit.setSelected(false);
        jcbYoga.setSelected(false);
        jcbZumba.setSelected(false);

        personalTrainerGroup.clearSelection();
        paymentFrequencyGroup.clearSelection();

        jDateChooser1.setDate(null);
        jTxtTotalAmount.setText("");
        costBreakDown.setText("");
        jTxtMembership.setText("");
    }


    private void updateTotalAmount() {
        membershipAmount = MembershipPlan();
        facilityAmount = calculateFacilityAmount();
        groupClasses = calculateGroupClassesAmount();
        personalTrainerCost = addPersonalTrainer();
        discountPercentage = addDiscount();
        membershipTotal = membershipAmount + facilityAmount + groupClasses + personalTrainerCost;
        
        if (discountPercentage > 0) {
            membershipTotal -= (membershipTotal * discountPercentage);
        }
        updateSlipTextArea();
        jTxtTotalAmount.setText(String.format("R%.2f", membershipTotal));
    }

    
    private void setupButtonGroups() {
        personalTrainerGroup = new javax.swing.ButtonGroup();
        paymentFrequencyGroup = new javax.swing.ButtonGroup();

        personalTrainerGroup.add(jrbtnNo);
        personalTrainerGroup.add(jrbtnDaily);
        personalTrainerGroup.add(jrbtnWeek);

        paymentFrequencyGroup.add(radBtnPayMonthly);
        paymentFrequencyGroup.add(radBtnPayQuaterly);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GymMembershipRegistration().setVisible(true));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMembershiplan = new javax.swing.JComboBox<>();
        jTxtTotalAmount = new javax.swing.JTextField();
        jTxtMembership = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtnSubmit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbYoga = new javax.swing.JCheckBox();
        jcbZumba = new javax.swing.JCheckBox();
        jcbCrossFit = new javax.swing.JCheckBox();
        jcbSauna = new javax.swing.JCheckBox();
        jcbPool = new javax.swing.JCheckBox();
        jcbLocker = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jrbtnNo = new javax.swing.JRadioButton();
        jrbtnWeek = new javax.swing.JRadioButton();
        jrbtnDaily = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        radBtnPayMonthly = new javax.swing.JRadioButton();
        radBtnPayQuaterly = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        costBreakDown = new java.awt.TextArea();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 153, 0));

        jMembershiplan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jMembershiplanItemStateChanged(evt);
            }
        });

        jTxtTotalAmount.setEditable(false);
        jTxtTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTxtTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTotalAmountActionPerformed(evt);
            }
        });

        jTxtMembership.setEditable(false);
        jTxtMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtMembershipActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("GYM MEMBERSHIP REGISTRATION");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Select Membership Plan");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Amount");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Membership Start Date");

        jbtnSubmit.setBackground(new java.awt.Color(204, 102, 255));
        jbtnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSubmit.setText("Submit");
        jbtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSubmitActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Total Amount");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Group Classes");

        jcbYoga.setBackground(new java.awt.Color(245, 192, 192));
        jcbYoga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbYoga.setText("Yoga- R100");
        jcbYoga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbYogaActionPerformed(evt);
            }
        });

        jcbZumba.setBackground(new java.awt.Color(245, 192, 192));
        jcbZumba.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbZumba.setText("Zumba-R90");
        jcbZumba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbZumbaActionPerformed(evt);
            }
        });

        jcbCrossFit.setBackground(new java.awt.Color(245, 192, 192));
        jcbCrossFit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbCrossFit.setText("CrossFit - R120");
        jcbCrossFit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCrossFitActionPerformed(evt);
            }
        });

        jcbSauna.setBackground(new java.awt.Color(245, 192, 192));
        jcbSauna.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbSauna.setText("Sauna -R50");
        jcbSauna.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSaunaItemStateChanged(evt);
            }
        });
        jcbSauna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSaunaActionPerformed(evt);
            }
        });

        jcbPool.setBackground(new java.awt.Color(245, 192, 192));
        jcbPool.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbPool.setText("Pool -R70");
        jcbPool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPoolActionPerformed(evt);
            }
        });

        jcbLocker.setBackground(new java.awt.Color(245, 192, 192));
        jcbLocker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbLocker.setText("Locker-R30");
        jcbLocker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLockerActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Add-on Facilities");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Personal Trainer");

        jrbtnNo.setBackground(new java.awt.Color(245, 192, 192));
        jrbtnNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrbtnNo.setText("No- R0");
        jrbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtnNoActionPerformed(evt);
            }
        });

        jrbtnWeek.setBackground(new java.awt.Color(245, 192, 192));
        jrbtnWeek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrbtnWeek.setText("Once a Week - R150");
        jrbtnWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtnWeekActionPerformed(evt);
            }
        });

        jrbtnDaily.setBackground(new java.awt.Color(245, 192, 192));
        jrbtnDaily.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrbtnDaily.setText("Daily - R400");
        jrbtnDaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtnDailyActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Payment Frequency ");

        radBtnPayMonthly.setBackground(new java.awt.Color(245, 192, 192));
        radBtnPayMonthly.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radBtnPayMonthly.setText("Monthly - No Discount");
        radBtnPayMonthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnPayMonthlyActionPerformed(evt);
            }
        });

        radBtnPayQuaterly.setBackground(new java.awt.Color(245, 192, 192));
        radBtnPayQuaterly.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radBtnPayQuaterly.setText("Quarterly - 5% Discount");
        radBtnPayQuaterly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnPayQuaterlyActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel12.setText("Cost Breakdown");

        costBreakDown.setEditable(false);
        costBreakDown.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                costBreakDownPropertyChange(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo'ss.png"))); // NOI18N
        jLabel13.setText("jLabel13");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbLocker)
                                            .addComponent(jcbSauna, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbPool)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jrbtnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jrbtnDaily)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jrbtnWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(80, 80, 80)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jcbYoga, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbZumba)
                                            .addComponent(jcbCrossFit)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jMembershiplan, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTxtMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(79, 79, 79)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(radBtnPayMonthly, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(radBtnPayQuaterly, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(costBreakDown, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTxtTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(739, 739, 739)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1355, 1355, 1355)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(937, 937, 937)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(934, 934, 934)
                        .addComponent(jbtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1051, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMembershiplan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTxtMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbCrossFit)
                            .addComponent(jcbSauna, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbYoga, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPool)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbZumba)
                    .addComponent(jcbLocker))
                .addGap(2, 2, 2)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbtnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radBtnPayMonthly))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbtnDaily)
                            .addComponent(radBtnPayQuaterly))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jrbtnWeek)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1335, 1335, 1335))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(costBreakDown, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbYogaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbYogaActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jcbYogaActionPerformed

    private void jcbSaunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSaunaActionPerformed
        updateTotalAmount();          
    }//GEN-LAST:event_jcbSaunaActionPerformed

    private void jrbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtnNoActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jrbtnNoActionPerformed

    private void jMembershiplanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jMembershiplanItemStateChanged
        if (jMembershiplan.getSelectedItem().equals("Basic plan")) {
            this.jTxtMembership.setText("R250/month");
        }

        if (jMembershiplan.getSelectedItem().equals("Standard plan")) {
            this.jTxtMembership.setText("R400/month");
        }
        if (jMembershiplan.getSelectedItem().equals("Premium plan")) {
            this.jTxtMembership.setText("R600/month");
        }
        
        updateTotalAmount();
    }//GEN-LAST:event_jMembershiplanItemStateChanged

    private void jTxtMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtMembershipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtMembershipActionPerformed

    private void jbtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSubmitActionPerformed
        // 1. Validation checks
        if (!radBtnPayMonthly.isSelected() && !radBtnPayQuaterly.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a payment frequency.", "Missing Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!jrbtnNo.isSelected() && !jrbtnDaily.isSelected() && !jrbtnWeek.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a personal trainer option.", "Missing Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (jMembershiplan.getSelectedIndex() == 0) { // Assuming index 0 is "Please select..."
            JOptionPane.showMessageDialog(this, "Please select a membership plan.", "Missing Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Calculate the total before confirmation
        updateTotalAmount(); // This should set `membershipTotal` and update UI
        String totalAmountText = String.format("Total amount to be paid: R%.2f", membershipTotal);
        
        Date selectedDate = jDateChooser1.getDate();
        Date today = new Date();

        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please select a start date.", "Missing Date", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selectedDate.before(today)) {
            JOptionPane.showMessageDialog(this, "Start date cannot be in the past.", "Invalid Date", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this, totalAmountText + "\nDo you want to confirm the order?", "Confirm Order", JOptionPane.OK_CANCEL_OPTION);

        if (confirm == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, "Your order has been successfully submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearAllFields();
        } else {
            JOptionPane.showMessageDialog(this, "Order cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSubmitActionPerformed

    private void jcbSaunaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSaunaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSaunaItemStateChanged

    private void jTxtTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTotalAmountActionPerformed

    private void jrbtnWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtnWeekActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jrbtnWeekActionPerformed

    private void radBtnPayMonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnPayMonthlyActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_radBtnPayMonthlyActionPerformed

    private void jcbPoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPoolActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jcbPoolActionPerformed

    private void jMembershiplanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMembershiplanActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jMembershiplanActionPerformed

    private void jcbLockerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLockerActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jcbLockerActionPerformed

    private void jcbCrossFitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCrossFitActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jcbCrossFitActionPerformed

    private void jcbZumbaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbZumbaActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_jcbZumbaActionPerformed

    private void jrbtnDailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtnDailyActionPerformed
        updateTotalAmount();  
    }//GEN-LAST:event_jrbtnDailyActionPerformed

    private void radBtnPayQuaterlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnPayQuaterlyActionPerformed
        updateTotalAmount();
    }//GEN-LAST:event_radBtnPayQuaterlyActionPerformed

    private void costBreakDownPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_costBreakDownPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_costBreakDownPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea costBreakDown;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jMembershiplan;
    private javax.swing.JTextField jTxtMembership;
    private javax.swing.JTextField jTxtTotalAmount;
    private javax.swing.JButton jbtnSubmit;
    private javax.swing.JCheckBox jcbCrossFit;
    private javax.swing.JCheckBox jcbLocker;
    private javax.swing.JCheckBox jcbPool;
    private javax.swing.JCheckBox jcbSauna;
    private javax.swing.JCheckBox jcbYoga;
    private javax.swing.JCheckBox jcbZumba;
    private javax.swing.JRadioButton jrbtnDaily;
    private javax.swing.JRadioButton jrbtnNo;
    private javax.swing.JRadioButton jrbtnWeek;
    private javax.swing.JRadioButton radBtnPayMonthly;
    private javax.swing.JRadioButton radBtnPayQuaterly;
    // End of variables declaration//GEN-END:variables
}

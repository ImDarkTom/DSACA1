/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsaca1;

import dsaca1.datastructures.doublylinkedlist.DLList;
import dsaca1.datastructures.singlylinkedlist.SLList;
import dsaca1.enums.Diet;
import dsaca1.models.FaunaSpecies;
import dsaca1.models.FloraSpecies;
import dsaca1.models.GreenArea;
import dsaca1.models.Species;
import dsaca1.ui.FloraListItem;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author tom
 */
public class MainGUI extends javax.swing.JFrame {
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        
        refreshFloraList();
        refreshFaunaList();
        refreshGreenAreasList();
    }
    
    private <T extends Species> JPanel createListItemPanel(T species, Consumer<T> onDelete) {
        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        container.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        
        JLabel nameLbl = new JLabel(species.getName());
        nameLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel nomenclatureLbl = new JLabel(species.getNomenclature());
        nomenclatureLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        textPanel.add(nameLbl);
        textPanel.add(nomenclatureLbl);
        
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(e -> onDelete.accept(species));
        
        rightPanel.add(deleteBtn);
        
        container.add(textPanel, BorderLayout.WEST);
        container.add(rightPanel, BorderLayout.EAST);
        
        return container;
    }
    
    
    private <T extends Species> void refreshList(
        JPanel panel,
        SLList<T> speciesList,
        Consumer<T> onDelete
    ) {
        panel.removeAll();
        
        
        for (T species : speciesList) {
            JPanel listItem = createListItemPanel(species, onDelete);
            panel.add(listItem);
        }
        
        panel.revalidate();
        panel.repaint();
    }
    
    private void refreshFloraList() {
        SLList<FloraSpecies> floraList = AppState.getFloraSpecies().inOrderTraversal();
        
        floraListPanel.removeAll();

        for (FloraSpecies species : floraList) {
            floraListPanel.add(new FloraListItem(species, (t) -> {
                AppState.getFloraSpecies().delete(t);
                refreshFloraList();
            }));
        }

        floraListPanel.revalidate();
        floraListPanel.repaint();

        greenAreaFloraList.clearSelection();
        greenAreaFloraList.setModel(convertSLLToListModel(floraList));
    }
    
    private void refreshFaunaList() {
        refreshList(
                faunaListPanel,
                AppState.getFaunaSpecies().inOrderTraversal(),
                (t) -> {
                    AppState.getFaunaSpecies().delete(t);
                    refreshFaunaList();
                }
        );
        
        SLList<FaunaSpecies> faunaList = AppState.getFaunaSpecies().inOrderTraversal();
        greenAreaFaunaList.clearSelection();
        greenAreaFaunaList.setModel(convertSLLToListModel(faunaList));
    }
    
    private <T> DefaultListModel<T> convertSLLToListModel(SLList<T> list) {
        DefaultListModel<T> model = new DefaultListModel<>();
        
        for (T item : list) {
            model.addElement(item);
        }
        
        return model;
    }
    
    private void refreshGreenAreasList() {
        greenAreasList.setModel(convertSLLToListModel(AppState.getGreenAreas()));
        greenAreasList.clearSelection();
    }
    
    private <T extends Comparable<T>> DLList<T> toDLList(java.util.List<? extends T> list) {
        DLList<T> out = new DLList<>();
        
        for (T item : list) {
            out.add(item);
        }
        
        return out;
    }
    
    private <T> int[] indicesInModelThatAppearInDLList(
        ListModel<T> model,
        Iterable<T> dlList
    ) {
        List<Integer> indices = new ArrayList<>();
        
        for (int i = 0; i < model.getSize(); i++) {
            T modelValue = model.getElementAt(i);
            
            boolean found = false;
            for (T dlValue : dlList) {
                if (modelValue == null ? dlValue == null : modelValue.equals(dlValue)) {
                    found = true;
                    break;
                }
            }
            
            if (found) {
                indices.add(i);
            }
        }
        
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        floraTabPane = new javax.swing.JPanel();
        floraNameLbl = new javax.swing.JLabel();
        floraNameTF = new javax.swing.JTextField();
        addFloraLbl = new javax.swing.JLabel();
        floraNomenclatureLbl = new javax.swing.JLabel();
        floraNomenclatureTF = new javax.swing.JTextField();
        floraDescriptionLbl = new javax.swing.JLabel();
        floraDescriptionTF = new javax.swing.JTextField();
        addFloraBtn = new javax.swing.JButton();
        floraGrowthTypeLbl = new javax.swing.JLabel();
        floraGrowthTypeTF = new javax.swing.JTextField();
        floraListScrollPane = new javax.swing.JScrollPane();
        floraListPanel = new javax.swing.JPanel();
        faunaTabPanel = new javax.swing.JPanel();
        faunaNameLbl = new javax.swing.JLabel();
        faunaNameTF = new javax.swing.JTextField();
        addFaunaLbl = new javax.swing.JLabel();
        faunaNomenclatureLbl = new javax.swing.JLabel();
        faunaNomenclatureTF = new javax.swing.JTextField();
        faunaDescriptionLbl = new javax.swing.JLabel();
        faunaDescriptionTF = new javax.swing.JTextField();
        faunaListPanel = new javax.swing.JPanel();
        addFaunaBtn = new javax.swing.JButton();
        faunaDietCB = new javax.swing.JComboBox<>();
        faunaDietLbl = new javax.swing.JLabel();
        greenAreasTabPanel = new javax.swing.JPanel();
        greenAreaListScrollPane = new javax.swing.JScrollPane();
        greenAreasList = new javax.swing.JList<>();
        newGreenAreaBtn = new javax.swing.JButton();
        deleteGreenAreaBtn = new javax.swing.JButton();
        greenAreaNameLbl = new javax.swing.JLabel();
        greenAreaNameTF = new javax.swing.JTextField();
        greenAreaFloraListScroll = new javax.swing.JScrollPane();
        greenAreaFloraList = new javax.swing.JList<>();
        greenAreaFloraLbl = new javax.swing.JLabel();
        greenAreaFaunaLbl = new javax.swing.JLabel();
        greenAreaFaunaListScroll = new javax.swing.JScrollPane();
        greenAreaFaunaList = new javax.swing.JList<>();
        addGreenAreaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DSA CA1 App");
        setMinimumSize(new java.awt.Dimension(600, 500));

        floraNameLbl.setText("Name");

        addFloraLbl.setText("Add a flora species");

        floraNomenclatureLbl.setText("Nomenclature");

        floraDescriptionLbl.setText("Description");

        addFloraBtn.setText("Add");
        addFloraBtn.addActionListener(this::addFloraBtnActionPerformed);

        floraGrowthTypeLbl.setText("Growth type");

        floraListScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        floraListScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        floraListPanel.setLayout(new javax.swing.BoxLayout(floraListPanel, javax.swing.BoxLayout.Y_AXIS));
        floraListScrollPane.setViewportView(floraListPanel);

        javax.swing.GroupLayout floraTabPaneLayout = new javax.swing.GroupLayout(floraTabPane);
        floraTabPane.setLayout(floraTabPaneLayout);
        floraTabPaneLayout.setHorizontalGroup(
            floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(floraTabPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(floraTabPaneLayout.createSequentialGroup()
                            .addComponent(floraDescriptionLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(floraDescriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, floraTabPaneLayout.createSequentialGroup()
                            .addComponent(floraNameLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(floraNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(floraTabPaneLayout.createSequentialGroup()
                            .addComponent(floraNomenclatureLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(floraNomenclatureTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(addFloraBtn)
                        .addGroup(floraTabPaneLayout.createSequentialGroup()
                            .addComponent(floraGrowthTypeLbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(floraGrowthTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addFloraLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(floraListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );
        floraTabPaneLayout.setVerticalGroup(
            floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(floraTabPaneLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(addFloraLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floraNameLbl)
                    .addComponent(floraNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floraNomenclatureLbl)
                    .addComponent(floraNomenclatureTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floraDescriptionLbl)
                    .addComponent(floraDescriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(floraTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floraGrowthTypeLbl)
                    .addComponent(floraGrowthTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addFloraBtn)
                .addContainerGap(302, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, floraTabPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(floraListScrollPane)
                .addContainerGap())
        );

        tabbedPane.addTab("Flora", floraTabPane);

        faunaNameLbl.setText("Name");

        addFaunaLbl.setText("Add a fauna species");

        faunaNomenclatureLbl.setText("Nomenclature");

        faunaDescriptionLbl.setText("Description");

        faunaListPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        faunaListPanel.setLayout(new javax.swing.BoxLayout(faunaListPanel, javax.swing.BoxLayout.Y_AXIS));

        addFaunaBtn.setText("Add");
        addFaunaBtn.addActionListener(this::addFaunaBtnActionPerformed);

        faunaDietCB.setModel(new DefaultComboBoxModel<>(Diet.values()));

        faunaDietLbl.setText("Diet");

        javax.swing.GroupLayout faunaTabPanelLayout = new javax.swing.GroupLayout(faunaTabPanel);
        faunaTabPanel.setLayout(faunaTabPanelLayout);
        faunaTabPanelLayout.setHorizontalGroup(
            faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faunaTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(faunaTabPanelLayout.createSequentialGroup()
                        .addComponent(addFaunaLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(faunaTabPanelLayout.createSequentialGroup()
                        .addGroup(faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(faunaTabPanelLayout.createSequentialGroup()
                                .addComponent(faunaDescriptionLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(faunaDescriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, faunaTabPanelLayout.createSequentialGroup()
                                .addComponent(faunaNameLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(faunaNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(faunaTabPanelLayout.createSequentialGroup()
                                .addComponent(faunaNomenclatureLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(faunaNomenclatureTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addFaunaBtn)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, faunaTabPanelLayout.createSequentialGroup()
                                .addComponent(faunaDietLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(faunaDietCB, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(faunaListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
                .addContainerGap())
        );
        faunaTabPanelLayout.setVerticalGroup(
            faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(faunaTabPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(addFaunaLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(faunaTabPanelLayout.createSequentialGroup()
                        .addGroup(faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faunaNameLbl)
                            .addComponent(faunaNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faunaNomenclatureLbl)
                            .addComponent(faunaNomenclatureTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faunaDescriptionLbl)
                            .addComponent(faunaDescriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(faunaTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faunaDietCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(faunaDietLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addFaunaBtn)
                        .addGap(0, 296, Short.MAX_VALUE))
                    .addComponent(faunaListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("Fauna", faunaTabPanel);

        greenAreasList.addListSelectionListener(this::greenAreasListValueChanged);
        greenAreaListScrollPane.setViewportView(greenAreasList);

        newGreenAreaBtn.setText("New");
        newGreenAreaBtn.addActionListener(this::newGreenAreaBtnActionPerformed);

        deleteGreenAreaBtn.setText("Delete");
        deleteGreenAreaBtn.setEnabled(false);
        deleteGreenAreaBtn.addActionListener(this::deleteGreenAreaBtnActionPerformed);

        greenAreaNameLbl.setText("Name");

        greenAreaFloraListScroll.setViewportView(greenAreaFloraList);

        greenAreaFloraLbl.setText("Flora");

        greenAreaFaunaLbl.setText("Fauna");

        greenAreaFaunaListScroll.setViewportView(greenAreaFaunaList);

        addGreenAreaBtn.setText("Add");
        addGreenAreaBtn.addActionListener(this::addGreenAreaBtnActionPerformed);

        javax.swing.GroupLayout greenAreasTabPanelLayout = new javax.swing.GroupLayout(greenAreasTabPanel);
        greenAreasTabPanel.setLayout(greenAreasTabPanelLayout);
        greenAreasTabPanelLayout.setHorizontalGroup(
            greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(greenAreaListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                        .addComponent(newGreenAreaBtn)
                        .addGap(78, 78, 78)))
                .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                                .addComponent(greenAreaNameLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(greenAreaNameTF))
                            .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                                .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(greenAreaFloraListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(greenAreaFloraLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                                        .addComponent(greenAreaFaunaLbl)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(greenAreaFaunaListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, greenAreasTabPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addGreenAreaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteGreenAreaBtn)))
                .addContainerGap())
        );
        greenAreasTabPanelLayout.setVerticalGroup(
            greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(greenAreasTabPanelLayout.createSequentialGroup()
                        .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(greenAreaNameLbl)
                            .addComponent(greenAreaNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(greenAreaFloraLbl)
                            .addComponent(greenAreaFaunaLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(greenAreaFloraListScroll)
                            .addComponent(greenAreaFaunaListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)))
                    .addComponent(greenAreaListScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(greenAreasTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newGreenAreaBtn)
                    .addComponent(deleteGreenAreaBtn)
                    .addComponent(addGreenAreaBtn))
                .addContainerGap())
        );

        tabbedPane.addTab("Green Areas", greenAreasTabPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addFloraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFloraBtnActionPerformed
        try {
            AppState.getFloraSpecies().insertNode(
                new FloraSpecies(
                    floraNameTF.getText(),
                    floraNomenclatureTF.getText(),
                    floraDescriptionTF.getText(),
                    floraGrowthTypeTF.getText()
                )
            );

            refreshFloraList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding item: " + e.getMessage());
        }
    }//GEN-LAST:event_addFloraBtnActionPerformed

    private void addFaunaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFaunaBtnActionPerformed
        try {
            AppState.getFaunaSpecies().insertNode(
                new FaunaSpecies(
                    faunaNameTF.getText(),
                    faunaNomenclatureTF.getText(),
                    faunaDescriptionTF.getText(),
                    Diet.valueOf(faunaDietCB.getSelectedItem().toString())
                )
            );

            refreshFaunaList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding item: " + e.getMessage());
        }
    }//GEN-LAST:event_addFaunaBtnActionPerformed

    private void deleteGreenAreaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGreenAreaBtnActionPerformed
        GreenArea selected = greenAreasList.getSelectedValue();
        int selectedIndex = AppState.getGreenAreas().indexOf(selected);
        if (selectedIndex != -1) {
            AppState.getGreenAreas().remove(selectedIndex);
        }
        
        refreshGreenAreasList();
    }//GEN-LAST:event_deleteGreenAreaBtnActionPerformed

    private void greenAreasListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_greenAreasListValueChanged
        GreenArea selected = greenAreasList.getSelectedValue();
        if (selected == null) {
            greenAreaNameTF.setText("");
//            editGreenAreaBtn.setEnabled(false);
            deleteGreenAreaBtn.setEnabled(false);
            addGreenAreaBtn.setEnabled(true);
            
            greenAreaFaunaList.clearSelection();
            greenAreaFloraList.clearSelection();
            return;
        }
        
        greenAreaNameTF.setText(selected.getName());
//        editGreenAreaBtn.setEnabled(true);
        deleteGreenAreaBtn.setEnabled(true);
        addGreenAreaBtn.setEnabled(false);
        
        greenAreaFloraList.setSelectedIndices(indicesInModelThatAppearInDLList(greenAreaFloraList.getModel(), selected.getFlora()));
        greenAreaFaunaList.setSelectedIndices(indicesInModelThatAppearInDLList(greenAreaFaunaList.getModel(), selected.getFauna()));
    }//GEN-LAST:event_greenAreasListValueChanged

    private void newGreenAreaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGreenAreaBtnActionPerformed
        if (greenAreasList.getSelectedIndex() != -1) {
            greenAreasList.clearSelection();
        }
    }//GEN-LAST:event_newGreenAreaBtnActionPerformed

    private void addGreenAreaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGreenAreaBtnActionPerformed
        String toBeAdded = greenAreaNameTF.getText();
        if (toBeAdded.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be blank.");
            return;
        }
        
        DLList<FloraSpecies> selectedFlora = toDLList(greenAreaFloraList.getSelectedValuesList());
        DLList<FaunaSpecies> selectedFauna = toDLList(greenAreaFaunaList.getSelectedValuesList());
        
        AppState.getGreenAreas().add(new GreenArea(greenAreaNameTF.getText(), selectedFlora, selectedFauna));
        refreshGreenAreasList();
    }//GEN-LAST:event_addGreenAreaBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFaunaBtn;
    private javax.swing.JLabel addFaunaLbl;
    private javax.swing.JButton addFloraBtn;
    private javax.swing.JLabel addFloraLbl;
    private javax.swing.JButton addGreenAreaBtn;
    private javax.swing.JButton deleteGreenAreaBtn;
    private javax.swing.JLabel faunaDescriptionLbl;
    private javax.swing.JTextField faunaDescriptionTF;
    private javax.swing.JComboBox<Diet> faunaDietCB;
    private javax.swing.JLabel faunaDietLbl;
    private javax.swing.JPanel faunaListPanel;
    private javax.swing.JLabel faunaNameLbl;
    private javax.swing.JTextField faunaNameTF;
    private javax.swing.JLabel faunaNomenclatureLbl;
    private javax.swing.JTextField faunaNomenclatureTF;
    private javax.swing.JPanel faunaTabPanel;
    private javax.swing.JLabel floraDescriptionLbl;
    private javax.swing.JTextField floraDescriptionTF;
    private javax.swing.JLabel floraGrowthTypeLbl;
    private javax.swing.JTextField floraGrowthTypeTF;
    private javax.swing.JPanel floraListPanel;
    private javax.swing.JScrollPane floraListScrollPane;
    private javax.swing.JLabel floraNameLbl;
    private javax.swing.JTextField floraNameTF;
    private javax.swing.JLabel floraNomenclatureLbl;
    private javax.swing.JTextField floraNomenclatureTF;
    private javax.swing.JPanel floraTabPane;
    private javax.swing.JLabel greenAreaFaunaLbl;
    private javax.swing.JList<FaunaSpecies> greenAreaFaunaList;
    private javax.swing.JScrollPane greenAreaFaunaListScroll;
    private javax.swing.JLabel greenAreaFloraLbl;
    private javax.swing.JList<FloraSpecies> greenAreaFloraList;
    private javax.swing.JScrollPane greenAreaFloraListScroll;
    private javax.swing.JScrollPane greenAreaListScrollPane;
    private javax.swing.JLabel greenAreaNameLbl;
    private javax.swing.JTextField greenAreaNameTF;
    private javax.swing.JList<GreenArea> greenAreasList;
    private javax.swing.JPanel greenAreasTabPanel;
    private javax.swing.JButton newGreenAreaBtn;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}

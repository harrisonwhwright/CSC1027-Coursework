package part03;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;


public class QUBMediaMuseum {
    public static void main(String[] args) {
        generate();
        
        JFrame frame = createFrame();
        frame.setVisible(true);
    }
    
    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setForeground(Color.BLACK);
        return button;
    }

    public static JFrame createFrame() {
        JFrame frame = new JFrame("QUB Media Museum");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ImageIcon logo = new ImageIcon(QUBMediaMuseum.class.getResource("/part03/QUBLogo.PNG"));
        Image img = logo.getImage().getScaledInstance(400, 260, Image.SCALE_SMOOTH);
        logo = new ImageIcon(img);

        JLabel imageLabel = new JLabel(logo);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton viewArtifacts = createButton("View Artifacts");
        JButton viewExhibits = createButton("View Exhibits");
        JButton viewAnnualPlans = createButton("View Annual Plans");

        JButton exit = createButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        viewArtifacts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showArtifactsWindow();
            }
        });
        
        viewExhibits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showExhibitsWindow();
            }
        });
        
        viewAnnualPlans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAnnualPlansWindow();
            }
        });

        buttonPanel.add(viewArtifacts);
        buttonPanel.add(viewExhibits);
        buttonPanel.add(viewAnnualPlans);
        buttonPanel.add(exit);
        JScrollPane scrollPane = new JScrollPane(buttonPanel);

        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.EAST);

        frame.add(panel);

        return frame;
    }

    public static void showArtifactsWindow() {
        JFrame artifactsFrame = new JFrame("Artifacts");
        artifactsFrame.setSize(600, 400);

        String[] columnNames = {"ID", "Artifact Name", "Type", "Engagement Time"};

        Object[][] data = new Object[QUBMuseum.getArtifacts().size()][4];

        for (int i = 0; i < QUBMuseum.getArtifacts().size(); i++) {
            Artifact artifact = QUBMuseum.getArtifacts().get(i);

            data[i][0] = artifact.getId();
            data[i][1] = artifact.getName();
            data[i][2] = artifact.getType().toString();
            data[i][3] = artifact.getEngagementTime();
        }

        JTable artifactTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(artifactTable);

        JButton deleteButton = new JButton("Delete Artifact");
        deleteButton.setEnabled(false);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = artifactTable.getSelectedRow();
                if (selectedRow != -1) {
                    int artifactId = (int) artifactTable.getValueAt(selectedRow, 0);
                    Artifact.deleteArtifact(artifactId);

                    JOptionPane.showMessageDialog(artifactsFrame, "Artifact deleted successfully.");
                    updateArtifactTableModel(artifactTable);
                }
            }
        });

        artifactTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = artifactTable.getSelectedRow();
                deleteButton.setEnabled(selectedRow != -1);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.SOUTH);

        artifactsFrame.add(panel);
        artifactsFrame.setVisible(true);
    }

    private static void updateArtifactTableModel(JTable artifactTable) {
        String[] columnNames = {"ID", "Artifact Name", "Type", "Engagement Time"};
        Object[][] data = new Object[QUBMuseum.getArtifacts().size()][4];

        for (int i = 0; i < QUBMuseum.getArtifacts().size(); i++) {
            Artifact artifact = QUBMuseum.getArtifacts().get(i);
            data[i][0] = artifact.getId();
            data[i][1] = artifact.getName();
            data[i][2] = artifact.getType().toString();
            data[i][3] = artifact.getEngagementTime();
        }

        DefaultTableModel model = (DefaultTableModel) artifactTable.getModel();
        model.setDataVector(data, columnNames);
        model.fireTableDataChanged();
    }

    public static void showExhibitsWindow() {
        JFrame exhibitsFrame = new JFrame("Exhibits");
        exhibitsFrame.setSize(600, 400);

        String[] columnNames = {"Exhibit ID", "Exhibit Name"};

        Object[][] data = new Object[QUBMuseum.getExhibits().size()][2];

        for (int i = 0; i < QUBMuseum.getExhibits().size(); i++) {
            Exhibit exhibit = QUBMuseum.getExhibits().get(i);
            data[i][0] = exhibit.getId();
            data[i][1] = exhibit.getName();
        }

        JTable exhibitTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(exhibitTable);

        JButton deleteButton = new JButton("Delete Exhibit");
        deleteButton.setEnabled(false);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = exhibitTable.getSelectedRow();
                if (selectedRow != -1) {
                    int exhibitId = (int) exhibitTable.getValueAt(selectedRow, 0);
                    Exhibit.deleteExhibit(exhibitId);

                    JOptionPane.showMessageDialog(exhibitsFrame, "Exhibit deleted successfully.");
                    
                    updateExhibitTableModel(exhibitTable);
                }
            }
        });

        exhibitTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = exhibitTable.getSelectedRow();
                deleteButton.setEnabled(selectedRow != -1);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.SOUTH);

        exhibitsFrame.add(panel);
        exhibitsFrame.setVisible(true);
    }

    private static void updateExhibitTableModel(JTable exhibitTable) {
        String[] columnNames = {"Exhibit ID", "Exhibit Name"};
        Object[][] data = new Object[QUBMuseum.getExhibits().size()][2];

        for (int i = 0; i < QUBMuseum.getExhibits().size(); i++) {
            Exhibit exhibit = QUBMuseum.getExhibits().get(i);
            data[i][0] = exhibit.getId();
            data[i][1] = exhibit.getName();
        }

        DefaultTableModel model = (DefaultTableModel) exhibitTable.getModel();
        model.setDataVector(data, columnNames);
        model.fireTableDataChanged();
    }

    public static void showAnnualPlansWindow() {
        JFrame annualPlansFrame = new JFrame("Annual Plans");
        annualPlansFrame.setSize(600, 400);

        String[] columnNames = {"Year"};

        Object[][] data = new Object[QUBMuseum.getAnnualPlans().size()][1];

        for (int i = 0; i < QUBMuseum.getAnnualPlans().size(); i++) {
            AnnualPlan annualPlan = QUBMuseum.getAnnualPlans().get(i);
            data[i][0] = annualPlan.getYear();
        }

        JTable annualPlanTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(annualPlanTable);

        JButton deleteButton = new JButton("Delete Annual Plan");
        deleteButton.setEnabled(false);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = annualPlanTable.getSelectedRow();
                if (selectedRow != -1) {
                    int year = (int) annualPlanTable.getValueAt(selectedRow, 0);
                    AnnualPlan.deleteAnnualPlan(year);

                    JOptionPane.showMessageDialog(annualPlansFrame, "Annual Plan deleted successfully.");
                    
                    updateAnnualPlanTableModel(annualPlanTable);
                }
            }
        });

        annualPlanTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = annualPlanTable.getSelectedRow();
                deleteButton.setEnabled(selectedRow != -1);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.SOUTH);

        annualPlansFrame.add(panel);
        annualPlansFrame.setVisible(true);
    }

    private static void updateAnnualPlanTableModel(JTable annualPlanTable) {
        String[] columnNames = {"Year"};
        Object[][] data = new Object[QUBMuseum.getAnnualPlans().size()][1];

        for (int i = 0; i < QUBMuseum.getAnnualPlans().size(); i++) {
            AnnualPlan annualPlan = QUBMuseum.getAnnualPlans().get(i);
            data[i][0] = annualPlan.getYear();
        }

        DefaultTableModel model = (DefaultTableModel) annualPlanTable.getModel();
        model.setDataVector(data, columnNames);
        model.fireTableDataChanged();
    }
    
    public static void generate() {
        Artifact.addArtifacts("Acropolis Statues", Type.SCULPTURE, 5);
        Artifact.addArtifacts("Mona Lisa", Type.PAINTING, 8);
        Artifact.addArtifacts("TouchIT", Type.TACTILE, 4);
        Artifact.addArtifacts("The Thinker", Type.SCULPTURE, 9);
        Artifact.addArtifacts("The Persistence of Memory", Type.PAINTING, 7);
        Artifact.addArtifacts("Starry Night", Type.PAINTING, 8);
        Artifact.addArtifacts("The Scream", Type.PAINTING, 6);
        Artifact.addArtifacts("Venus de Milo", Type.SCULPTURE, 10);
        Artifact.addArtifacts("Machu Picchu", Type.OTHER, 10);
        Artifact.addArtifacts("The Last Supper", Type.PAINTING, 9);
        Artifact.addArtifacts("The Sistine Chapel Ceiling", Type.SCULPTURE, 9);
        Artifact.addArtifacts("Monet's Water Lilies", Type.PAINTING, 7);
        Artifact.addArtifacts("Robot Arm", Type.DIGITAL, 4);

        Exhibit.createExhibit("Modern Art Exhibit");
        Exhibit.addArtifact(1, 1, "Ancient Sculpture");
        Exhibit.addArtifact(1, 2, "Renaissance Masterpiece");
        Exhibit.addArtifact(1, 4, "Philosophical Sculpture");
        Exhibit.addArtifact(1, 6, "Post-Impressionist Art");
        Exhibit.addArtifact(1, 9, "Classical Sculpture");
        Exhibit.addArtifact(1, 11, "Famous Fresco");
        Exhibit.addArtifact(1, 13, "Impressionist Landscape");

        Exhibit.createExhibit("Classical Sculptures Exhibit");
        Exhibit.addArtifact(2, 1, "Ancient Sculpture");
        Exhibit.addArtifact(2, 4, "Philosophical Sculpture");
        Exhibit.addArtifact(2, 9, "Classical Sculpture");
        Exhibit.addArtifact(2, 12, "Iconic Fresco");

        Exhibit.createExhibit("Renaissance and Baroque Art Exhibit");
        Exhibit.addArtifact(3, 2, "Renaissance Masterpiece");
        Exhibit.addArtifact(3, 7, "Modernised Surrealism");
        Exhibit.addArtifact(3, 10, "Sacred Masterpiece");
        Exhibit.addArtifact(3, 11, "Famous Fresco");

        Exhibit.createExhibit("Digital Innovations and Sculptures");
        Exhibit.addArtifact(4, 3, "Interactive Technology");
        Exhibit.addArtifact(4, 13, "Impressionist Landscape");
        Exhibit.addArtifact(4, 14, "Futuristic Creation");
        Exhibit.addArtifact(4, 1, "Ancient Sculpture");

        AnnualPlan.createAnnualPlan(2024);
        AnnualPlan.addToAnnualPlan(2024, 1, 1, 1);
        AnnualPlan.addToAnnualPlan(2024, 2, 2, 2);
        AnnualPlan.addToAnnualPlan(2024, 3, 5, 2);
        AnnualPlan.addToAnnualPlan(2024, 4, 3, 3);
        AnnualPlan.addToAnnualPlan(2024, 1, 1, 1);
        AnnualPlan.addToAnnualPlan(2024, 2, 4, 1);
        AnnualPlan.addToAnnualPlan(2024, 3, 6, 1);
        AnnualPlan.addToAnnualPlan(2024, 4, 4, 1);

        AnnualPlan.createAnnualPlan(2025);
        AnnualPlan.addToAnnualPlan(2025, 1, 5, 2);
        AnnualPlan.addToAnnualPlan(2025, 2, 6, 1);
        AnnualPlan.addToAnnualPlan(2025, 3, 7, 3);
        AnnualPlan.addToAnnualPlan(2025, 4, 8, 2);

        AnnualPlan.createAnnualPlan(2026);
        AnnualPlan.addToAnnualPlan(2026, 1, 2, 2);
        AnnualPlan.addToAnnualPlan(2026, 2, 3, 3);
        AnnualPlan.addToAnnualPlan(2026, 3, 4, 1);
    }
}
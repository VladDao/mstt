package ua.mstt.plietnov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

public class BookSellerGui extends JFrame {

    private BookSellerAgent myAgent;
    private JTextField priceField;
    private JTextField titleField;


    public BookSellerGui(BookSellerAgent myAgent) {
        super(myAgent.getLocalName());
        this.myAgent = myAgent;

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));
        jPanel.add(new JLabel("Book title:"));
        this.titleField = new JTextField(15);
        jPanel.add(this.titleField);
        jPanel.add(new Label("Price:"));
        this.priceField = new JTextField(15);
        jPanel.add(this.priceField);
        getContentPane().add(jPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(ev -> {
            try {
                String title = titleField.getText().trim();
                String price = priceField.getText().trim();

                myAgent.updateCatalogue(title, Integer.parseInt(price));
                titleField.setText("");
                priceField.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(BookSellerGui.this,
                        "Invalid values",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        jPanel = new JPanel();
        jPanel.add(addButton);
        getContentPane().add(jPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
        });

        setResizable(false);
    }

    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;

        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }
}

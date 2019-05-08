import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BPPResultaatGUI extends JFrame implements ActionListener {

    private HMIStatusGUI hmiStatusGUI;
    private TekenPanelBPPResultaat tekenPanelBPPResultaat;

    private JLabel jlRood, jlGroen, jlGeel;
    private JButton jbPakbon;

    private int yPlus = 0;

    public BPPResultaatGUI(HMIStatusGUI hmiStatusGUI) {
        this.hmiStatusGUI = hmiStatusGUI;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(HoofdschermGUI.getSchermBreedte(), HoofdschermGUI.getSchermHoogte());
        setTitle("BPP Resultaat");

        jlRood = new JLabel("Rood: " + hmiStatusGUI.getAantal("rood"));
        jlGroen = new JLabel("Groen: " + hmiStatusGUI.getAantal("groen"));
        jlGeel = new JLabel("Geel: " + hmiStatusGUI.getAantal("geel"));

        tekenPanelBPPResultaat = new TekenPanelBPPResultaat(this);

        //tekenPanelBPPResultaat.add(Box.createRigidArea(new Dimension(100, 100)));
        tekenPanelBPPResultaat.add(jlRood);
        tekenPanelBPPResultaat.add(Box.createRigidArea(new Dimension(800, 200)));
        tekenPanelBPPResultaat.add(jlGroen);
        tekenPanelBPPResultaat.add(Box.createRigidArea(new Dimension(800, 90)));
        tekenPanelBPPResultaat.add(jlGeel);
        tekenPanelBPPResultaat.add(Box.createRigidArea(new Dimension(800, 200)));

        jbPakbon = new JButton("Pakbon");
        jbPakbon.addActionListener(this);

        // voeg dit allemaal toe op het scherm
        add(jbPakbon);
        add(tekenPanelBPPResultaat);


        setVisible(false);
    }


    public void drawBins(Graphics g) {

        for (int j = 2; j < 7; j += 2) {

            for (int i = 1; i < 8; i++) {
                int x1 = 100 * i;
                int x2 = 100 * i;

                int y1 = 50 * j + yPlus;
                int y2 = 50 * j + yPlus + 100;

                g.drawLine(x1, y1, x2, y2);                  // linker lijn
                g.drawLine(x1, y2, x2 + 80, y2);         // onderste lijn
                g.drawLine(x2 + 80, y1, x1 + 80, y2); // rechter lijn
            }
            yPlus += 50;
        }
    }

            // Teken de producten in de dozen
    public void drawProducts(Graphics g, int aRood, int aGroen, int aGeel) {

        if (aRood > 0) {
            int y1 = 160; // Onderin doos
            int x1 = 105; // helemaal links in 1e doos
            int blok = 0;
            for (int i = 0; i < aRood; i++) {
                g.setColor(Color.RED);
                g.fillRect(x1, y1, 30, 35);
                blok++;

                if (blok == 1) {
                    x1 += 10 + 30;
                } else if (blok == 2) {
                    x1 -= 10 + 30;
                    y1 -= 5 + 35;
                } else if (blok == 3) {
                    x1 += 10 + 30;
                } else if (blok == 4) {
                    y1 += 5 + 35;
                    x1 += 60;
                    blok = 0;
                }
            }
        }

        if (aGroen > 0) {
            int y1 = 310; // Onderin doos
            int x1 = 105; // helemaal links in 1e doos
            int blok = 0;
            for (int i = 0; i < aGroen; i++) {
                g.setColor(Color.GREEN);
                g.fillRect(x1, y1, 30, 35);
                blok++;

                if (blok == 1) {
                    x1 += 10 + 30;
                } else if (blok == 2) {
                    x1 -= 10 + 30;
                    y1 -= 5 + 35;
                } else if (blok == 3) {
                    x1 += 10 + 30;
                } else if (blok == 4) {
                    y1 += 5 + 35;
                    x1 += 60;
                    blok = 0;
                }
            }
        }

        if (aGeel > 0) {
            int y1 = 460; // Onderin doos
            int x1 = 105; // helemaal links in 1e doos
            int blok = 0;
            for (int i = 0; i < aGeel; i++) {
                g.setColor(Color.YELLOW);
                g.fillRect(x1, y1, 30, 35);
                blok++;

                if (blok == 1) {
                    x1 += 10 + 30;
                } else if (blok == 2) {
                    x1 -= 10 + 30;
                    y1 -= 5 + 35;
                } else if (blok == 3) {
                    x1 += 10 + 30;
                } else if (blok == 4) {
                    y1 += 5 + 35;
                    x1 += 60;
                    blok = 0;
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbPakbon) {
            this.dispose();
            new PakbonGUI().setVisible(true);
        }
    }
}
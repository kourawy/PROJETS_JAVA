package coo.questionnaire.gui;

import coo.questionnaire.Questionnaire;
import coo.questionnaire.QuestionnaireFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * Class who create and run the app.
 */
public class QuestionnaireGuiMain {
    private JFrame f;
    private int nbpoints;

    /**
     * Create the main frame of the gui.
     */
    public void createFrame() {
        this.f = new JFrame();
        JPanel pp = new JPanel();
        pp.setLayout(new GridLayout(5, 1));
        JScrollPane p = new JScrollPane(pp);
        this.f.setLayout(new BorderLayout(2, 1));
        this.f.getContentPane().add(p, "Center");
        this.f.setSize(900, 700);
        this.f.addWindowListener(new FermeWindowEvent((FermeWindowEvent) null));

        QuestionnaireFactory factory = new QuestionnaireFactory();
        String file = "questionnairetest.txt";
        try {
            Questionnaire questionnaire = factory.createQuestionnaire(file);
            nbpoints = questionnaire.askAllGui(pp);

        } catch (IOException except) {
            System.out.println(file + " : wrong file");
            System.exit(0);
        }

        JButton finished = new JButton("j'ai fini");
        finished.addActionListener(new FinishedActionListener((FinishedActionListener) null));
        this.f.add(finished, "South");
        this.f.setVisible(true);
    }

    /**
     * Create the gui.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        (new QuestionnaireGuiMain()).createFrame();
    }

    private class FermeWindowEvent extends WindowAdapter {
        private FermeWindowEvent(FermeWindowEvent fermeWindowEvent) {
        }

        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class FinishedActionListener implements ActionListener {
        private FinishedActionListener(FinishedActionListener finishedActionListener) {
        }

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(QuestionnaireGuiMain.this.f, "vous avez " + nbpoints + " points", "Finished !", 1);
        }
    }
}
